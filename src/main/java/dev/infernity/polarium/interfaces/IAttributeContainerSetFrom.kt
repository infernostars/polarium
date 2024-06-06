package dev.infernity.polarium.interfaces

import net.minecraft.entity.attribute.AttributeContainer

interface IAttributeContainerSetFrom {
    fun setBaseFrom(other: AttributeContainer)
    fun setFrom(other: AttributeContainer)
}
