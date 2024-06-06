package dev.infernity.polarium.items

import dev.infernity.polarium.items.MicrocraftingItems.TexturedPolymerItem
import net.minecraft.component.type.FoodComponent
import net.minecraft.item.ItemStack
import net.minecraft.item.Items
import net.minecraft.util.Identifier


class BaseFoodItem(texture_id: Identifier?, nutrition: Int, saturation: Float) : TexturedPolymerItem(
    Settings().maxCount(64).food(
        FoodComponent.Builder().nutrition(nutrition).saturationModifier(saturation).build()
    ), Items.STICK, texture_id
) {
    private var useDuration = 32

    constructor(texture_id: Identifier?, nutrition: Int, saturation: Float, useDuration: Int) : this(
        texture_id,
        nutrition,
        saturation
    ) {
        this.useDuration = useDuration
    }

    fun getUseDuration(stack: ItemStack?): Int {
        return this.useDuration
    }
}
