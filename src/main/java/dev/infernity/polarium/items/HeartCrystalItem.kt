package dev.infernity.polarium.items

import dev.infernity.polarium.PolariumServersideInit
import dev.infernity.polarium.items.MicrocraftingItems.TexturedPolymerItem
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.ItemStack
import net.minecraft.item.Items
import net.minecraft.util.Hand
import net.minecraft.util.TypedActionResult
import net.minecraft.world.World

class HeartCrystalItem : TexturedPolymerItem(
    MicrocraftingItems.emptySetting,
    Items.NETHER_WART,
    PolariumServersideInit.Companion.id("item/heart_crystal")
) {
    override fun use(world: World, user: PlayerEntity, hand: Hand): TypedActionResult<ItemStack> {
        val stack = user.getStackInHand(hand)
        PolariumServersideInit.Companion.LOGGER.info("WHIRLING NEGOTIATE WITH THEM | heart use by " + user.name.string)

        //user.playSound(new PolymerSoundEvent(UUID.randomUUID(), id("sounds/heart_crystal"), 32, false, SoundEvents.ITEM_TOTEM_USE), 1.0F, 1.0F);
        return TypedActionResult.success(stack)
    }
}
