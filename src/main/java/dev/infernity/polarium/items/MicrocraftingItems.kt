package dev.infernity.polarium.items

import eu.pb4.polymer.core.api.item.PolymerItem
import eu.pb4.polymer.core.api.item.SimplePolymerItem
import eu.pb4.polymer.resourcepack.api.PolymerModelData
import eu.pb4.polymer.resourcepack.api.PolymerResourcePackUtils
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.item.Items
import net.minecraft.server.network.ServerPlayerEntity
import net.minecraft.util.Identifier

object MicrocraftingItems {
    val emptySetting: Item.Settings = Item.Settings()

    fun craftingItem(): SimplePolymerItem {
        return SimplePolymerItem(emptySetting, Items.STRUCTURE_VOID)
    }

    fun craftingItem(item: Item?): SimplePolymerItem {
        return SimplePolymerItem(emptySetting, item)
    }

    fun texturedCraftingItem(fallback: Item?, texture: Identifier?): TexturedPolymerItem {
        return TexturedPolymerItem(emptySetting, fallback, texture)
    }

    open class TexturedPolymerItem(settings: Settings?, fallback: Item?, texture: Identifier?) :
        SimplePolymerItem(settings, fallback), PolymerItem {
        private val polymerModelData: PolymerModelData = PolymerResourcePackUtils.requestModel(fallback, texture)

        override fun getPolymerItem(itemStack: ItemStack, player: ServerPlayerEntity?): Item {
            return polymerModelData.item()
        }

        override fun getPolymerCustomModelData(itemStack: ItemStack, player: ServerPlayerEntity?): Int {
            return polymerModelData.value()
        }
    }
}
