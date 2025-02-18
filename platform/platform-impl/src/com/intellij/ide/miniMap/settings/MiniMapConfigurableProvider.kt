// Copyright 2000-2022 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license.
package com.intellij.ide.miniMap.settings

import com.intellij.openapi.options.Configurable
import com.intellij.openapi.options.ConfigurableProvider
import com.intellij.openapi.util.registry.Registry

class MiniMapConfigurableProvider : ConfigurableProvider() {
  override fun createConfigurable(): Configurable? =
    if (Registry.`is`("editor.minimap.enabled")) MiniMapConfigurable() else null

  override fun canCreateConfigurable() = Registry.`is`("editor.minimap.enabled")
}