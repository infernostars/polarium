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
/**
 * You shouldn't use this class directly.
 *
 * Also see the builder class (TalismanItem.Builder) if you want to make a talisman.
 * @see TalismanItem.Builder
 */
class TalismanItem
    (
    settings: Settings,
    fallback: Item?,
    texture: Identifier?,
    attributeModifiersComponent: AttributeModifiersComponent?
) : TexturedPolymerItem(settings.attributeModifiers(attributeModifiersComponent), fallback, texture) {
    /**
     * Class to build TalismanItems.
     */
    class Builder(private val settings: Settings, private val id: Identifier) {
        private val fallback: Item = Items.EMERALD
        private val builder: AttributeModifiersComponent.Builder = AttributeModifiersComponent.builder()

        /**
         * Adds an EntityAttributeModifier directly. You can use this, but there's a utility function w/ the same name
         * that does this more conveniently. Chainable.
         * @return the Builder, with entity modifier applied.
         */
        fun add_attribute(attribute: RegistryEntry<EntityAttribute?>?, modifier: EntityAttributeModifier?): Builder {
            builder.add(attribute, modifier, AttributeModifierSlot.OFFHAND)
            return this
        }

        /**
         * Adds an EntityAttributeModifier with a generated name and defined Value and Operation. Chainable.
         * @return the Builder, with entity modifier applied.
         */
        fun add_attribute(
            attribute: RegistryEntry<EntityAttribute?>,
            value: Double?,
            operation: EntityAttributeModifier.Operation?
        ): Builder {
            val modifier = EntityAttributeModifier(id.path + "__" + attribute.idAsString, value!!, operation)
            builder.add(attribute, modifier, AttributeModifierSlot.OFFHAND)
            return this
        }

        /**
         * Returns the TalismanItem being built.
         * @return a TalismanItem that was made using the builder.
         */
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
        /**
         * Utility class so you don't have to make a new Builder each time. Probably not necessary w/ Kotlin, but I don't want to break old code.
         * @return a Builder.
         */
        fun builder(settings: Settings, texture: Identifier): Builder {
            return Builder(settings, texture)
        }
    }
}
