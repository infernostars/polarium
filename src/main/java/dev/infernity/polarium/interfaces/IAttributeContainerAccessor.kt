package dev.infernity.polarium.interfaces

import net.minecraft.entity.attribute.EntityAttribute
import net.minecraft.entity.attribute.EntityAttributeInstance
import net.minecraft.registry.entry.RegistryEntry

interface IAttributeContainerAccessor {
    val custom: Map<RegistryEntry<EntityAttribute?>?, EntityAttributeInstance?>
    fun getCustomInstance(attribute: RegistryEntry<EntityAttribute?>?): EntityAttributeInstance?
}
