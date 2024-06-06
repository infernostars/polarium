package dev.infernity.polarium.items

import dev.infernity.polarium.items.MicrocraftingItems.TexturedPolymerItem
import net.minecraft.component.type.AttributeModifierSlot
import net.minecraft.component.type.AttributeModifiersComponent
import net.minecraft.entity.attribute.EntityAttribute
import net.minecraft.entity.attribute.EntityAttributeModifier
import net.minecraft.item.Item
import net.minecraft.item.Items
import net.minecraft.registry.entry.RegistryEntry
import net.minecraft.util.Identifier

class TalismanItem
/**
 * You shouldn't use this class directly.
 *
 *
 * Also see the builder class (TalismanItem.Builder) if you want to make a talisman.
 */
    (
    settings: Settings,
    fallback: Item?,
    texture: Identifier?,
    attributeModifiersComponent: AttributeModifiersComponent?
) : TexturedPolymerItem(settings.attributeModifiers(attributeModifiersComponent), fallback, texture) {
    class Builder(private val settings: Settings, private val id: Identifier) {
        private val fallback: Item = Items.EMERALD
        private val builder: AttributeModifiersComponent.Builder = AttributeModifiersComponent.builder()

        fun add_attribute(attribute: RegistryEntry<EntityAttribute?>?, modifier: EntityAttributeModifier?): Builder {
            builder.add(attribute, modifier, AttributeModifierSlot.OFFHAND)
            return this
        }

        fun add_attribute(
            attribute: RegistryEntry<EntityAttribute?>,
            value: Double?,
            operation: EntityAttributeModifier.Operation?
        ): Builder {
            val modifier = EntityAttributeModifier(id.path + "__" + attribute.idAsString, value!!, operation)
            builder.add(attribute, modifier, AttributeModifierSlot.OFFHAND)
            return this
        }

        fun build(): TalismanItem {
            return TalismanItem(
                settings,
                fallback,
                id,
                builder.build()
            )
        }
    }

    companion object {
        fun builder(settings: Settings, texture: Identifier): Builder {
            return Builder(settings, texture)
        }
    }
}
