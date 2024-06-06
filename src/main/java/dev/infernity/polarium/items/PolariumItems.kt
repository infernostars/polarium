package dev.infernity.polarium.items

import dev.infernity.polarium.PolariumServersideInit
import dev.infernity.polarium.items.MicrocraftingItems.TexturedPolymerItem
import eu.pb4.polymer.core.api.item.PolymerItemGroupUtils
import net.minecraft.entity.attribute.EntityAttributeModifier
import net.minecraft.entity.attribute.EntityAttributes
import net.minecraft.item.*
import net.minecraft.item.Items.*
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.text.Text

/**
 * Registers the items, puts them in an ItemGroup, and can be used as a reference later.
 */
object PolariumItems {
    // microcrafting
    val REDSTONE_SUPERCONDUCTOR: Item = register<TexturedPolymerItem>(
        "redstone_superconductor", MicrocraftingItems.texturedCraftingItem(
            RED_DYE, PolariumServersideInit.Companion.id("item/redstone_superconductor")
        )
    )
    val SALT_POWDER: Item = register<TexturedPolymerItem>(
        "salt_powder",
        MicrocraftingItems.texturedCraftingItem(SUGAR, PolariumServersideInit.Companion.id("item/salt_powder"))
    )
    val SAND_POWDER: Item = register<TexturedPolymerItem>(
        "sand_powder",
        MicrocraftingItems.texturedCraftingItem(GLOWSTONE_DUST, PolariumServersideInit.Companion.id("item/sand_powder"))
    )
    val SAND_PLATE: Item = register<TexturedPolymerItem>(
        "sand_plate",
        MicrocraftingItems.texturedCraftingItem(BIRCH_PRESSURE_PLATE, PolariumServersideInit.Companion.id("item/sand_plate"))
    )
    val SILICON_PLATE: Item = register<TexturedPolymerItem>(
        "silicon_plate", MicrocraftingItems.texturedCraftingItem(POLISHED_BLACKSTONE_PRESSURE_PLATE, PolariumServersideInit.Companion.id("item/silicon_plate"))
    )

    // foods
    val CHEESE: Item = register<BaseFoodItem>(
        "cheese",
        BaseFoodItem(PolariumServersideInit.Companion.id("item/cheese"), 2, 2f))
    val BEEF_JERKY: Item = register<BaseFoodItem>(
        "beef_jerky",
        BaseFoodItem(PolariumServersideInit.Companion.id("item/beef_jerky"), 2, 2f)
    )

    // usables
    val HEART_CRYSTAL: Item = register("heart_crystal", HeartCrystalItem())

    // misc
    val COIN: Item = register<TexturedPolymerItem>(
        "coin",
        MicrocraftingItems.texturedCraftingItem(STICK, PolariumServersideInit.Companion.id("item/coin"))
    )

    // talismans
    val BASE_TALISMAN: Item = register<TexturedPolymerItem>(
        "base_talisman", MicrocraftingItems.texturedCraftingItem(
            EMERALD, PolariumServersideInit.Companion.id("item/talisman_base")
        )
    )
    val REACH_TALISMAN: Item = register<TalismanItem>(
        "reach_talisman",
        TalismanItem.Companion.builder(
            MicrocraftingItems.emptySetting,
            PolariumServersideInit.Companion.id("item/talisman")
        )
            .add_attribute(
                EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE,
                1.0,
                EntityAttributeModifier.Operation.ADD_VALUE
            )
            .add_attribute(
                EntityAttributes.PLAYER_BLOCK_INTERACTION_RANGE,
                1.0,
                EntityAttributeModifier.Operation.ADD_VALUE
            )
            .build()
    )
    val DAMAGE_TALISMAN: Item = register<TalismanItem>(
        "damage_talisman",
        TalismanItem.Companion.builder(
            MicrocraftingItems.emptySetting,
            PolariumServersideInit.Companion.id("item/talisman")
        )
            .add_attribute(
                EntityAttributes.GENERIC_ATTACK_DAMAGE,
                2.0,
                EntityAttributeModifier.Operation.ADD_VALUE)
            .build()
    )
    val HUP_TALISMAN: Item = register<TalismanItem>(
        "hup_talisman",
        TalismanItem.Companion.builder(
            MicrocraftingItems.emptySetting,
            PolariumServersideInit.Companion.id("item/talisman")
        )
            .add_attribute(
                EntityAttributes.GENERIC_STEP_HEIGHT,
                0.75,
                EntityAttributeModifier.Operation.ADD_VALUE)
            .add_attribute(
                EntityAttributes.GENERIC_MOVEMENT_SPEED,
                0.5,
                EntityAttributeModifier.Operation.ADD_MULTIPLIED_BASE)

            .build()

    )
    val IRON_TALISMAN: Item = register<TalismanItem>(
        "iron_talisman",
        TalismanItem.Companion.builder(
            MicrocraftingItems.emptySetting,
            PolariumServersideInit.Companion.id("item/talisman")
        )
            .add_attribute(
                EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE,
                0.50,
                EntityAttributeModifier.Operation.ADD_MULTIPLIED_BASE)
            .add_attribute(
                EntityAttributes.GENERIC_ARMOR,
                4.0,
                EntityAttributeModifier.Operation.ADD_VALUE)
            .add_attribute(
                EntityAttributes.GENERIC_ATTACK_KNOCKBACK,
                1.0,
                EntityAttributeModifier.Operation.ADD_MULTIPLIED_BASE)
            .add_attribute(
                EntityAttributes.GENERIC_MOVEMENT_SPEED,
                -0.2,
                EntityAttributeModifier.Operation.ADD_MULTIPLIED_BASE)
            .add_attribute(
                EntityAttributes.GENERIC_GRAVITY,
                0.25,
                EntityAttributeModifier.Operation.ADD_MULTIPLIED_BASE)
            .build()
    )
    val PAPER_TALISMAN: Item = register<TalismanItem>(
        "paper_talisman",
        TalismanItem.Companion.builder(
            MicrocraftingItems.emptySetting,
            PolariumServersideInit.Companion.id("item/talisman")
        )
            .add_attribute(
                EntityAttributes.GENERIC_SAFE_FALL_DISTANCE,
                5.0,
                EntityAttributeModifier.Operation.ADD_VALUE)
            .add_attribute(
                EntityAttributes.GENERIC_STEP_HEIGHT,
                2.0,
                EntityAttributeModifier.Operation.ADD_VALUE)
            .add_attribute(
                EntityAttributes.GENERIC_GRAVITY,
                -0.8,
                EntityAttributeModifier.Operation.ADD_MULTIPLIED_BASE)
            .add_attribute(
                EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE,
                -2.0,
                EntityAttributeModifier.Operation.ADD_MULTIPLIED_BASE)
            .add_attribute(
                EntityAttributes.GENERIC_ARMOR,
                -0.25,
                EntityAttributeModifier.Operation.ADD_MULTIPLIED_BASE)
            .build()
    )
    val SCAVENGER_TALISMAN: Item = register<TalismanItem>(
        "scavenger_talisman",
        TalismanItem.Companion.builder(
            MicrocraftingItems.emptySetting,
            PolariumServersideInit.Companion.id("item/talisman")
        )
            .add_attribute(
                EntityAttributes.GENERIC_LUCK,
                2.0,
                EntityAttributeModifier.Operation.ADD_VALUE)
            .add_attribute(
                EntityAttributes.PLAYER_BLOCK_BREAK_SPEED,
                1.0,
                EntityAttributeModifier.Operation.ADD_MULTIPLIED_BASE)
            .add_attribute(
                EntityAttributes.GENERIC_MOVEMENT_SPEED,
                0.15,
                EntityAttributeModifier.Operation.ADD_MULTIPLIED_BASE)
            .add_attribute(
                EntityAttributes.GENERIC_SCALE,
                -0.5,
                EntityAttributeModifier.Operation.ADD_MULTIPLIED_BASE)
            .add_attribute(
                EntityAttributes.GENERIC_MAX_HEALTH,
                -8.0,
                EntityAttributeModifier.Operation.ADD_VALUE)
            .add_attribute(
                EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE,
                -0.25,
                EntityAttributeModifier.Operation.ADD_MULTIPLIED_BASE)
            .add_attribute(
                EntityAttributes.PLAYER_BLOCK_INTERACTION_RANGE,
                -0.25,
                EntityAttributeModifier.Operation.ADD_MULTIPLIED_BASE)
            .build()
    )


    val ITEM_GROUP: ItemGroup = ItemGroup.create(null, -1)
        .displayName(Text.literal("Polarium"))
        .icon { SNOWBALL.defaultStack }

        .entries { ctx: ItemGroup.DisplayContext?, e: ItemGroup.Entries ->
            //microcrafting
            e.add(REDSTONE_SUPERCONDUCTOR)
            e.add(SALT_POWDER)
            e.add(SAND_POWDER)
            e.add(SAND_PLATE)
            e.add(SILICON_PLATE)
            //foods
            e.add(CHEESE)
            e.add(BEEF_JERKY)
            //usables
            e.add(HEART_CRYSTAL)
            //misc
            e.add(COIN)
            //talismans
            e.add(BASE_TALISMAN)
            e.add(REACH_TALISMAN)
            e.add(DAMAGE_TALISMAN)
            e.add(HUP_TALISMAN)
            e.add(IRON_TALISMAN)
            e.add(PAPER_TALISMAN)
            e.add(SCAVENGER_TALISMAN)

        }
        .build()

    /**
     * Registers the ItemGroup.
     */
    fun register() {
        PolymerItemGroupUtils.registerPolymerItemGroup(PolariumServersideInit.Companion.id("items"), ITEM_GROUP)
    }

    /**
     * Utility function to register items.
     */
    private fun <T : Item?> register(path: String, item: T): T {
        return Registry.register<Item, T>(Registries.ITEM, PolariumServersideInit.Companion.id(path), item)
    }
}
