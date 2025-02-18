package com.intellij.workspaceModel.test.api

import com.intellij.workspaceModel.storage.EntityInformation
import com.intellij.workspaceModel.storage.EntitySource
import com.intellij.workspaceModel.storage.EntityStorage
import com.intellij.workspaceModel.storage.GeneratedCodeApiVersion
import com.intellij.workspaceModel.storage.GeneratedCodeImplVersion
import com.intellij.workspaceModel.storage.ModifiableWorkspaceEntity
import com.intellij.workspaceModel.storage.MutableEntityStorage
import com.intellij.workspaceModel.storage.WorkspaceEntity
import com.intellij.workspaceModel.storage.impl.ConnectionId
import com.intellij.workspaceModel.storage.impl.ModifiableWorkspaceEntityBase
import com.intellij.workspaceModel.storage.impl.UsedClassesCollector
import com.intellij.workspaceModel.storage.impl.WorkspaceEntityBase
import com.intellij.workspaceModel.storage.impl.WorkspaceEntityData
import java.util.Date

@GeneratedCodeApiVersion(1)
@GeneratedCodeImplVersion(1)
open class UnknownPropertyTypeEntityImpl(val dataSource: UnknownPropertyTypeEntityData) : UnknownPropertyTypeEntity, WorkspaceEntityBase() {

  companion object {


    val connections = listOf<ConnectionId>(
    )

  }

  override val date: Date
    get() = dataSource.date

  override fun connectionIdList(): List<ConnectionId> {
    return connections
  }

  class Builder(val result: UnknownPropertyTypeEntityData?) : ModifiableWorkspaceEntityBase<UnknownPropertyTypeEntity>(), UnknownPropertyTypeEntity.Builder {
    constructor() : this(UnknownPropertyTypeEntityData())

    override fun applyToBuilder(builder: MutableEntityStorage) {
      if (this.diff != null) {
        if (existsInBuilder(builder)) {
          this.diff = builder
          return
        }
        else {
          error("Entity UnknownPropertyTypeEntity is already created in a different builder")
        }
      }

      this.diff = builder
      this.snapshot = builder
      addToBuilder()
      this.id = getEntityData().createEntityId()

      // Process linked entities that are connected without a builder
      processLinkedEntities(builder)
      checkInitialization() // TODO uncomment and check failed tests
    }

    fun checkInitialization() {
      val _diff = diff
      if (!getEntityData().isEntitySourceInitialized()) {
        error("Field WorkspaceEntity#entitySource should be initialized")
      }
      if (!getEntityData().isDateInitialized()) {
        error("Field UnknownPropertyTypeEntity#date should be initialized")
      }
    }

    override fun connectionIdList(): List<ConnectionId> {
      return connections
    }

    // Relabeling code, move information from dataSource to this builder
    override fun relabel(dataSource: WorkspaceEntity, parents: Set<WorkspaceEntity>?) {
      dataSource as UnknownPropertyTypeEntity
      this.entitySource = dataSource.entitySource
      this.date = dataSource.date
      if (parents != null) {
      }
    }


    override var entitySource: EntitySource
      get() = getEntityData().entitySource
      set(value) {
        checkModificationAllowed()
        getEntityData().entitySource = value
        changedProperty.add("entitySource")

      }

    override var date: Date
      get() = getEntityData().date
      set(value) {
        checkModificationAllowed()
        getEntityData().date = value
        changedProperty.add("date")

      }

    override fun getEntityData(): UnknownPropertyTypeEntityData = result ?: super.getEntityData() as UnknownPropertyTypeEntityData
    override fun getEntityClass(): Class<UnknownPropertyTypeEntity> = UnknownPropertyTypeEntity::class.java
  }
}

class UnknownPropertyTypeEntityData : WorkspaceEntityData<UnknownPropertyTypeEntity>() {
  lateinit var date: Date

  fun isDateInitialized(): Boolean = ::date.isInitialized

  override fun wrapAsModifiable(diff: MutableEntityStorage): ModifiableWorkspaceEntity<UnknownPropertyTypeEntity> {
    val modifiable = UnknownPropertyTypeEntityImpl.Builder(null)
    modifiable.allowModifications {
      modifiable.diff = diff
      modifiable.snapshot = diff
      modifiable.id = createEntityId()
      modifiable.entitySource = this.entitySource
    }
    modifiable.changedProperty.clear()
    return modifiable
  }

  override fun createEntity(snapshot: EntityStorage): UnknownPropertyTypeEntity {
    return getCached(snapshot) {
      val entity = UnknownPropertyTypeEntityImpl(this)
      entity.entitySource = entitySource
      entity.snapshot = snapshot
      entity.id = createEntityId()
      entity
    }
  }

  override fun getEntityInterface(): Class<out WorkspaceEntity> {
    return UnknownPropertyTypeEntity::class.java
  }

  override fun serialize(ser: EntityInformation.Serializer) {
  }

  override fun deserialize(de: EntityInformation.Deserializer) {
  }

  override fun createDetachedEntity(parents: List<WorkspaceEntity>): WorkspaceEntity {
    return UnknownPropertyTypeEntity(date, entitySource) {
    }
  }

  override fun getRequiredParents(): List<Class<out WorkspaceEntity>> {
    val res = mutableListOf<Class<out WorkspaceEntity>>()
    return res
  }

  override fun equals(other: Any?): Boolean {
    if (other == null) return false
    if (this::class != other::class) return false

    other as UnknownPropertyTypeEntityData

    if (this.entitySource != other.entitySource) return false
    if (this.date != other.date) return false
    return true
  }

  override fun equalsIgnoringEntitySource(other: Any?): Boolean {
    if (other == null) return false
    if (this::class != other::class) return false

    other as UnknownPropertyTypeEntityData

    if (this.date != other.date) return false
    return true
  }

  override fun hashCode(): Int {
    var result = entitySource.hashCode()
    result = 31 * result + date.hashCode()
    return result
  }

  override fun hashCodeIgnoringEntitySource(): Int {
    var result = javaClass.hashCode()
    result = 31 * result + date.hashCode()
    return result
  }

  override fun collectClassUsagesData(collector: UsedClassesCollector) {
    this.date?.let { collector.addDataToInspect(it) }
    collector.sameForAllEntities = true
  }
}
