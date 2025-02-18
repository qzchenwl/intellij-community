package com.intellij.workspaceModel.storage.entities.test.api

import com.intellij.workspaceModel.storage.*
import com.intellij.workspaceModel.storage.EntityInformation
import com.intellij.workspaceModel.storage.EntitySource
import com.intellij.workspaceModel.storage.EntityStorage
import com.intellij.workspaceModel.storage.GeneratedCodeApiVersion
import com.intellij.workspaceModel.storage.GeneratedCodeImplVersion
import com.intellij.workspaceModel.storage.ModifiableWorkspaceEntity
import com.intellij.workspaceModel.storage.MutableEntityStorage
import com.intellij.workspaceModel.storage.PersistentEntityId
import com.intellij.workspaceModel.storage.WorkspaceEntity
import com.intellij.workspaceModel.storage.impl.ConnectionId
import com.intellij.workspaceModel.storage.impl.EntityLink
import com.intellij.workspaceModel.storage.impl.ModifiableWorkspaceEntityBase
import com.intellij.workspaceModel.storage.impl.UsedClassesCollector
import com.intellij.workspaceModel.storage.impl.WorkspaceEntityBase
import com.intellij.workspaceModel.storage.impl.WorkspaceEntityData
import com.intellij.workspaceModel.storage.impl.containers.MutableWorkspaceList
import com.intellij.workspaceModel.storage.impl.containers.toMutableWorkspaceList
import com.intellij.workspaceModel.storage.impl.extractOneToManyChildren
import com.intellij.workspaceModel.storage.impl.updateOneToManyChildrenOfParent
import com.intellij.workspaceModel.storage.url.VirtualFileUrl
import java.util.*
import org.jetbrains.deft.ObjBuilder
import org.jetbrains.deft.Type
import org.jetbrains.deft.annotations.Child

@GeneratedCodeApiVersion(1)
@GeneratedCodeImplVersion(1)
open class SampleWithPersistentIdEntityImpl(val dataSource: SampleWithPersistentIdEntityData) : SampleWithPersistentIdEntity, WorkspaceEntityBase() {

  companion object {
    internal val CHILDREN_CONNECTION_ID: ConnectionId = ConnectionId.create(SampleWithPersistentIdEntity::class.java,
                                                                            ChildWpidSampleEntity::class.java,
                                                                            ConnectionId.ConnectionType.ONE_TO_MANY, true)

    val connections = listOf<ConnectionId>(
      CHILDREN_CONNECTION_ID,
    )

  }

  override val booleanProperty: Boolean get() = dataSource.booleanProperty
  override val stringProperty: String
    get() = dataSource.stringProperty

  override val stringListProperty: List<String>
    get() = dataSource.stringListProperty

  override val stringMapProperty: Map<String, String>
    get() = dataSource.stringMapProperty
  override val fileProperty: VirtualFileUrl
    get() = dataSource.fileProperty

  override val children: List<ChildWpidSampleEntity>
    get() = snapshot.extractOneToManyChildren<ChildWpidSampleEntity>(CHILDREN_CONNECTION_ID, this)!!.toList()

  override val nullableData: String?
    get() = dataSource.nullableData

  override fun connectionIdList(): List<ConnectionId> {
    return connections
  }

  class Builder(val result: SampleWithPersistentIdEntityData?) : ModifiableWorkspaceEntityBase<SampleWithPersistentIdEntity>(), SampleWithPersistentIdEntity.Builder {
    constructor() : this(SampleWithPersistentIdEntityData())

    override fun applyToBuilder(builder: MutableEntityStorage) {
      if (this.diff != null) {
        if (existsInBuilder(builder)) {
          this.diff = builder
          return
        }
        else {
          error("Entity SampleWithPersistentIdEntity is already created in a different builder")
        }
      }

      this.diff = builder
      this.snapshot = builder
      addToBuilder()
      this.id = getEntityData().createEntityId()

      index(this, "fileProperty", this.fileProperty)
      // Process linked entities that are connected without a builder
      processLinkedEntities(builder)
      checkInitialization() // TODO uncomment and check failed tests
    }

    fun checkInitialization() {
      val _diff = diff
      if (!getEntityData().isEntitySourceInitialized()) {
        error("Field WorkspaceEntity#entitySource should be initialized")
      }
      if (!getEntityData().isStringPropertyInitialized()) {
        error("Field SampleWithPersistentIdEntity#stringProperty should be initialized")
      }
      if (!getEntityData().isStringListPropertyInitialized()) {
        error("Field SampleWithPersistentIdEntity#stringListProperty should be initialized")
      }
      if (!getEntityData().isStringMapPropertyInitialized()) {
        error("Field SampleWithPersistentIdEntity#stringMapProperty should be initialized")
      }
      if (!getEntityData().isFilePropertyInitialized()) {
        error("Field SampleWithPersistentIdEntity#fileProperty should be initialized")
      }
      // Check initialization for list with ref type
      if (_diff != null) {
        if (_diff.extractOneToManyChildren<WorkspaceEntityBase>(CHILDREN_CONNECTION_ID, this) == null) {
          error("Field SampleWithPersistentIdEntity#children should be initialized")
        }
      }
      else {
        if (this.entityLinks[EntityLink(true, CHILDREN_CONNECTION_ID)] == null) {
          error("Field SampleWithPersistentIdEntity#children should be initialized")
        }
      }
    }

    override fun connectionIdList(): List<ConnectionId> {
      return connections
    }

    // Relabeling code, move information from dataSource to this builder
    override fun relabel(dataSource: WorkspaceEntity, parents: Set<WorkspaceEntity>?) {
      dataSource as SampleWithPersistentIdEntity
      this.entitySource = dataSource.entitySource
      this.booleanProperty = dataSource.booleanProperty
      this.stringProperty = dataSource.stringProperty
      this.stringListProperty = dataSource.stringListProperty.toMutableList()
      this.stringMapProperty = dataSource.stringMapProperty.toMutableMap()
      this.fileProperty = dataSource.fileProperty
      this.nullableData = dataSource.nullableData
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

    override var booleanProperty: Boolean
      get() = getEntityData().booleanProperty
      set(value) {
        checkModificationAllowed()
        getEntityData().booleanProperty = value
        changedProperty.add("booleanProperty")
      }

    override var stringProperty: String
      get() = getEntityData().stringProperty
      set(value) {
        checkModificationAllowed()
        getEntityData().stringProperty = value
        changedProperty.add("stringProperty")
      }

    private val stringListPropertyUpdater: (value: List<String>) -> Unit = { value ->

      changedProperty.add("stringListProperty")
    }
    override var stringListProperty: MutableList<String>
      get() {
        val collection_stringListProperty = getEntityData().stringListProperty
        if (collection_stringListProperty !is MutableWorkspaceList) return collection_stringListProperty
        collection_stringListProperty.setModificationUpdateAction(stringListPropertyUpdater)
        return collection_stringListProperty
      }
      set(value) {
        checkModificationAllowed()
        getEntityData().stringListProperty = value
        stringListPropertyUpdater.invoke(value)
      }

    override var stringMapProperty: Map<String, String>
      get() = getEntityData().stringMapProperty
      set(value) {
        checkModificationAllowed()
        getEntityData().stringMapProperty = value
        changedProperty.add("stringMapProperty")
      }

    override var fileProperty: VirtualFileUrl
      get() = getEntityData().fileProperty
      set(value) {
        checkModificationAllowed()
        getEntityData().fileProperty = value
        changedProperty.add("fileProperty")
        val _diff = diff
        if (_diff != null) index(this, "fileProperty", value)
      }

    // List of non-abstract referenced types
    var _children: List<ChildWpidSampleEntity>? = emptyList()
    override var children: List<ChildWpidSampleEntity>
      get() {
        // Getter of the list of non-abstract referenced types
        val _diff = diff
        return if (_diff != null) {
          _diff.extractOneToManyChildren<ChildWpidSampleEntity>(CHILDREN_CONNECTION_ID, this)!!.toList() + (this.entityLinks[EntityLink(
            true, CHILDREN_CONNECTION_ID)] as? List<ChildWpidSampleEntity> ?: emptyList())
        }
        else {
          this.entityLinks[EntityLink(true, CHILDREN_CONNECTION_ID)] as? List<ChildWpidSampleEntity> ?: emptyList()
        }
      }
      set(value) {
        // Setter of the list of non-abstract referenced types
        checkModificationAllowed()
        val _diff = diff
        if (_diff != null) {
          for (item_value in value) {
            if (item_value is ModifiableWorkspaceEntityBase<*> && (item_value as? ModifiableWorkspaceEntityBase<*>)?.diff == null) {
              _diff.addEntity(item_value)
            }
          }
          _diff.updateOneToManyChildrenOfParent(CHILDREN_CONNECTION_ID, this, value)
        }
        else {
          for (item_value in value) {
            if (item_value is ModifiableWorkspaceEntityBase<*>) {
              item_value.entityLinks[EntityLink(false, CHILDREN_CONNECTION_ID)] = this
            }
            // else you're attaching a new entity to an existing entity that is not modifiable
          }

          this.entityLinks[EntityLink(true, CHILDREN_CONNECTION_ID)] = value
        }
        changedProperty.add("children")
      }

    override var nullableData: String?
      get() = getEntityData().nullableData
      set(value) {
        checkModificationAllowed()
        getEntityData().nullableData = value
        changedProperty.add("nullableData")
      }

    override fun getEntityData(): SampleWithPersistentIdEntityData = result ?: super.getEntityData() as SampleWithPersistentIdEntityData
    override fun getEntityClass(): Class<SampleWithPersistentIdEntity> = SampleWithPersistentIdEntity::class.java
  }
}

class SampleWithPersistentIdEntityData : WorkspaceEntityData.WithCalculablePersistentId<SampleWithPersistentIdEntity>() {
  var booleanProperty: Boolean = false
  lateinit var stringProperty: String
  lateinit var stringListProperty: MutableList<String>
  lateinit var stringMapProperty: Map<String, String>
  lateinit var fileProperty: VirtualFileUrl
  var nullableData: String? = null


  fun isStringPropertyInitialized(): Boolean = ::stringProperty.isInitialized
  fun isStringListPropertyInitialized(): Boolean = ::stringListProperty.isInitialized
  fun isStringMapPropertyInitialized(): Boolean = ::stringMapProperty.isInitialized
  fun isFilePropertyInitialized(): Boolean = ::fileProperty.isInitialized

  override fun wrapAsModifiable(diff: MutableEntityStorage): ModifiableWorkspaceEntity<SampleWithPersistentIdEntity> {
    val modifiable = SampleWithPersistentIdEntityImpl.Builder(null)
    modifiable.allowModifications {
      modifiable.diff = diff
      modifiable.snapshot = diff
      modifiable.id = createEntityId()
      modifiable.entitySource = this.entitySource
    }
    modifiable.changedProperty.clear()
    return modifiable
  }

  override fun createEntity(snapshot: EntityStorage): SampleWithPersistentIdEntity {
    return getCached(snapshot) {
      val entity = SampleWithPersistentIdEntityImpl(this)
      entity.entitySource = entitySource
      entity.snapshot = snapshot
      entity.id = createEntityId()
      entity
    }
  }

  override fun clone(): SampleWithPersistentIdEntityData {
    val clonedEntity = super.clone()
    clonedEntity as SampleWithPersistentIdEntityData
    clonedEntity.stringListProperty = clonedEntity.stringListProperty.toMutableWorkspaceList()
    return clonedEntity
  }

  override fun persistentId(): PersistentEntityId<*> {
    return SamplePersistentId(stringProperty)
  }

  override fun getEntityInterface(): Class<out WorkspaceEntity> {
    return SampleWithPersistentIdEntity::class.java
  }

  override fun serialize(ser: EntityInformation.Serializer) {
  }

  override fun deserialize(de: EntityInformation.Deserializer) {
  }

  override fun createDetachedEntity(parents: List<WorkspaceEntity>): WorkspaceEntity {
    return SampleWithPersistentIdEntity(booleanProperty, stringProperty, stringListProperty, stringMapProperty, fileProperty,
                                        entitySource) {
      this.nullableData = this@SampleWithPersistentIdEntityData.nullableData
    }
  }

  override fun getRequiredParents(): List<Class<out WorkspaceEntity>> {
    val res = mutableListOf<Class<out WorkspaceEntity>>()
    return res
  }

  override fun equals(other: Any?): Boolean {
    if (other == null) return false
    if (this::class != other::class) return false

    other as SampleWithPersistentIdEntityData

    if (this.entitySource != other.entitySource) return false
    if (this.booleanProperty != other.booleanProperty) return false
    if (this.stringProperty != other.stringProperty) return false
    if (this.stringListProperty != other.stringListProperty) return false
    if (this.stringMapProperty != other.stringMapProperty) return false
    if (this.fileProperty != other.fileProperty) return false
    if (this.nullableData != other.nullableData) return false
    return true
  }

  override fun equalsIgnoringEntitySource(other: Any?): Boolean {
    if (other == null) return false
    if (this::class != other::class) return false

    other as SampleWithPersistentIdEntityData

    if (this.booleanProperty != other.booleanProperty) return false
    if (this.stringProperty != other.stringProperty) return false
    if (this.stringListProperty != other.stringListProperty) return false
    if (this.stringMapProperty != other.stringMapProperty) return false
    if (this.fileProperty != other.fileProperty) return false
    if (this.nullableData != other.nullableData) return false
    return true
  }

  override fun hashCode(): Int {
    var result = entitySource.hashCode()
    result = 31 * result + booleanProperty.hashCode()
    result = 31 * result + stringProperty.hashCode()
    result = 31 * result + stringListProperty.hashCode()
    result = 31 * result + stringMapProperty.hashCode()
    result = 31 * result + fileProperty.hashCode()
    result = 31 * result + nullableData.hashCode()
    return result
  }

  override fun hashCodeIgnoringEntitySource(): Int {
    var result = javaClass.hashCode()
    result = 31 * result + booleanProperty.hashCode()
    result = 31 * result + stringProperty.hashCode()
    result = 31 * result + stringListProperty.hashCode()
    result = 31 * result + stringMapProperty.hashCode()
    result = 31 * result + fileProperty.hashCode()
    result = 31 * result + nullableData.hashCode()
    return result
  }

  override fun collectClassUsagesData(collector: UsedClassesCollector) {
    this.stringMapProperty?.let { collector.add(it::class.java) }
    this.stringListProperty?.let { collector.add(it::class.java) }
    this.fileProperty?.let { collector.add(it::class.java) }
    collector.sameForAllEntities = false
  }
}
