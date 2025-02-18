// Copyright 2000-2022 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license.
package com.intellij.ide.miniMap

import com.intellij.ide.miniMap.actions.MoveMiniMapAction
import com.intellij.ide.miniMap.actions.OpenMiniMapSettingsAction
import com.intellij.ide.miniMap.actions.ToggleMiniMapResizableAction
import com.intellij.ide.miniMap.settings.MiniMapSettings
import com.intellij.openapi.Disposable
import com.intellij.openapi.actionSystem.DefaultActionGroup
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.editor.event.SelectionEvent
import com.intellij.openapi.editor.event.SelectionListener
import com.intellij.openapi.editor.event.VisibleAreaEvent
import com.intellij.openapi.editor.event.VisibleAreaListener
import com.intellij.ui.Gray
import com.intellij.ui.PopupHandler
import java.awt.*
import java.awt.event.*
import java.lang.ref.SoftReference
import javax.swing.JPanel
import kotlin.math.min

class MiniMapPanel(private val parentDisposable: Disposable, private val editor: Editor, private val container: JPanel) : JPanel() {

  companion object {
    const val MINIMUM_WIDTH = 50
    const val RESIZE_TOLERANCE = 7
  }

  inner class PanelMouseListener : MouseAdapter() {
    override fun mousePressed(e: MouseEvent) {

      if (e.button != MouseEvent.BUTTON1) {
        return
      }

      if (!isDragging && isInResizeArea(e.x)) {
        isResizing = true
        resizeInitialX = e.xOnScreen
        resizeInitialWidth = state.width
      }
      else {
        isDragging = true
        scrollTo(e.y)
      }
    }

    override fun mouseReleased(e: MouseEvent) {
      if (e.button == MouseEvent.BUTTON1) {
        isDragging = false
        isResizing = false
      }
    }

    override fun mouseWheelMoved(mouseWheelEvent: MouseWheelEvent) {
      editor.scrollingModel.scrollVertically(
        editor.scrollingModel.verticalScrollOffset + (mouseWheelEvent.preciseWheelRotation * editor.lineHeight * 5).toInt())
    }

    override fun mouseDragged(e: MouseEvent) {
      if (isResizing) {
        var newWidth = resizeInitialWidth + if (state.rightAligned) resizeInitialX - e.xOnScreen else e.xOnScreen - resizeInitialX
        newWidth = when {
          newWidth < MINIMUM_WIDTH -> MINIMUM_WIDTH
          newWidth > container.width / 2 -> container.width / 2
          else -> newWidth
        }
        if (state.width != newWidth) {
          state.width = newWidth
          settings.settingsChangeCallback.notify(MiniMapSettings.SettingsChangeType.Normal)
        }
      }
      else if (isDragging) {
        editor.scrollingModel.disableAnimation()
        scrollTo(e.y)
        editor.scrollingModel.enableAnimation()
      }
    }

    override fun mouseMoved(e: MouseEvent) {
      if (isInResizeArea(e.x)) {
        cursor = if (state.rightAligned) Cursor.getPredefinedCursor(Cursor.W_RESIZE_CURSOR)
        else Cursor.getPredefinedCursor(Cursor.E_RESIZE_CURSOR)
      }
      else {
        cursor = Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR)
      }
    }
  }

  private val settings = MiniMapSettings.getInstance()
  private var state = settings.state

  private var isResizing = false
  private var isDragging = false
  private var resizeInitialX = 0
  private var resizeInitialWidth = 0

  private var miniMapImageSoftReference = SoftReference<MiniMapImage>(null)

  private var miniMapHeight = 0
  private var areaStart = 0
  private var areaEnd = 0

  private var thumbStart = 0
  private var thumbHeight = 0

  private val contentComponentListener = object : ComponentAdapter() {
    override fun componentResized(componentEvent: ComponentEvent?) {
      updateParameters()
      repaint()
    }
  }

  private val componentListener = object : ComponentAdapter() {
    private var lastHeight = -1
    override fun componentResized(componentEvent: ComponentEvent?) {
      if (lastHeight == height) {
        return
      }
      lastHeight = height
      updateParameters()
      revalidate()
      repaint()
    }
  }

  private val selectionListener = object : SelectionListener {
    override fun selectionChanged(e: SelectionEvent) {
      repaint()
    }
  }

  private val visibleAreaListener = object : VisibleAreaListener {
    private var visibleArea = Rectangle(0, 0, 0, 0)

    override fun visibleAreaChanged(e: VisibleAreaEvent) {
      if (visibleArea.y == e.newRectangle.y &&
          visibleArea.height == e.newRectangle.height &&
          visibleArea.width == e.newRectangle.width) {
        return
      }
      visibleArea = e.newRectangle
      updateParameters()
      repaint()
    }
  }

  private val onSettingsChange = { _: MiniMapSettings.SettingsChangeType ->
    updatePreferredSize()
    revalidate()
    repaint()
  }

  private var initialized = false

  init {
    container.addComponentListener(componentListener)
    settings.settingsChangeCallback += onSettingsChange
    editor.scrollingModel.addVisibleAreaListener(visibleAreaListener)
    editor.selectionModel.addSelectionListener(selectionListener)
    editor.contentComponent.addComponentListener(contentComponentListener)

    PopupHandler.installPopupMenu(this, createPopupActionGroup(), "MiniMap")

    updatePreferredSize()

    val mouseListener = PanelMouseListener()
    addMouseListener(mouseListener)
    addMouseWheelListener(mouseListener)
    addMouseMotionListener(mouseListener)
  }

  private fun updateParameters() {
    val visibleArea = editor.scrollingModel.visibleArea
    val componentHeight = editor.contentComponent.height
    miniMapHeight = (componentHeight * state.width / visibleArea.width.toDouble()).toInt()

    val proportion = miniMapHeight.toDouble() / componentHeight

    thumbStart = (visibleArea.y * proportion).toInt()
    thumbHeight = (visibleArea.height * proportion).toInt()

    areaStart = ((thumbStart / (miniMapHeight - thumbHeight).toFloat()) * (miniMapHeight - height)).toInt()
    if (areaStart < 0) {
      areaStart = 0
    }

    areaEnd = areaStart + min(height, miniMapHeight)
  }

  private fun isInResizeArea(x: Int): Boolean {
    return when {
      !state.resizable -> false
      state.rightAligned -> x in 0..RESIZE_TOLERANCE
      else -> x in (state.width - RESIZE_TOLERANCE)..state.width
    }
  }

  private fun scrollTo(y: Int) {
    val percentage = (y + areaStart) / miniMapHeight.toFloat()
    val offset = editor.component.size.height / 2
    editor.scrollingModel.scrollVertically((percentage * editor.contentComponent.size.height - offset).toInt())
  }

  override fun updateUI() {
    super.updateUI()
    if (initialized) {
      miniMapImageSoftReference.get()?.update(editor, editor.contentComponent.height, editor.scrollingModel.visibleArea.width,
                                              miniMapHeight, true)
    }
  }

  private fun createPopupActionGroup() = DefaultActionGroup(
    ToggleMiniMapResizableAction(),
    MoveMiniMapAction(),
    OpenMiniMapSettingsAction(),
    // Filters are currently disabled.
    //MiniMapFilterActionGroup()
  )

  private fun updatePreferredSize() {
    preferredSize = Dimension(state.width, 0)
  }

  private fun getOrCreateImage(): MiniMapImage {
    var map = miniMapImageSoftReference.get()

    if (map == null) {
      map = MiniMapImage(parentDisposable)
      map.onImageReady = { repaint() }
      miniMapImageSoftReference = SoftReference(map)
    }

    return map
  }

  override fun paint(g: Graphics) {
    if (!initialized) {
      updateParameters()
      initialized = true
    }

    val miniMap = getOrCreateImage()
    miniMap.update(editor, editor.contentComponent.height, editor.scrollingModel.visibleArea.width, miniMapHeight)

    g.color = editor.contentComponent.background
    g.fillRect(0, 0, width, height)

    val preview = miniMap.preview
    if (preview != null) {
      val scaleY = (preview.graphics as Graphics2D).transform.scaleY

      g.drawImage(preview, 0, 0, state.width, areaEnd - areaStart,
                  0, (areaStart * scaleY).toInt(), preview.width, (areaEnd * scaleY).toInt(),
                  null)
    }

    // Thumb transparent rect
    g.color = Gray._161
    (g as? Graphics2D)?.composite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.35f)
    g.fillRect(0, thumbStart - areaStart, width, thumbHeight)
  }

  fun onClose() {
    settings.settingsChangeCallback -= onSettingsChange
    container.removeComponentListener(componentListener)
    editor.selectionModel.removeSelectionListener(selectionListener)
    editor.contentComponent.removeComponentListener(contentComponentListener)
    editor.scrollingModel.removeVisibleAreaListener(visibleAreaListener)

    miniMapImageSoftReference.clear()
  }
}