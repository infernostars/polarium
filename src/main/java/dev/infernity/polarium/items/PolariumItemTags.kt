package dev.infernity.polarium.items

import dev.infernity.polarium.PolariumServersideInit
import net.minecraft.item.Item
import net.minecraft.registry.RegistryKeys
import net.minecraft.registry.tag.TagKey
/**
 * Item tags, mostly useful for crafting & advancements. For now, only used in the Datagen.
 * This is just a list. For the actual references, see PolariumItemTagProvider.
 * @see dev.infernity.polarium.datagen.PolariumItemTagsProvider
 * @see dev.infernity.polarium.datagen.PolariumAdvancements
 */
object PolariumItemTags {
    val ROOT_ADVANCEMENT: TagKey<Item> = of("root_advancement_items")

    /**
     * Utility function for creating tags.
     */
    private fun of(path: String): TagKey<Item> {
        return TagKey.of<Item>(RegistryKeys.ITEM, PolariumServersideInit.Companion.id(path))
    }
}
