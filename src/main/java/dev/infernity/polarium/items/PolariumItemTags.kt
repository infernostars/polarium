package dev.infernity.polarium.items

import dev.infernity.polarium.PolariumServersideInit
import net.minecraft.item.Item
import net.minecraft.registry.RegistryKeys
import net.minecraft.registry.tag.TagKey

object PolariumItemTags {
    val ROOT_ADVANCEMENT: TagKey<Item> = of("root_advancement_items")

    private fun of(path: String): TagKey<Item> {
        return TagKey.of<Item>(RegistryKeys.ITEM, PolariumServersideInit.Companion.id(path))
    }
}
