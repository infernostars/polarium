package dev.infernity.polarium.datagen

import dev.infernity.polarium.items.PolariumItemTags
import dev.infernity.polarium.items.PolariumItems
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider
import net.minecraft.registry.RegistryWrapper.WrapperLookup
import java.util.concurrent.CompletableFuture

internal class PolariumItemTagsProvider(
    output: FabricDataOutput,
    registriesFuture: CompletableFuture<WrapperLookup?>?,
    blockTagProvider: BlockTagProvider
) : FabricTagProvider.ItemTagProvider(output, registriesFuture, blockTagProvider) {
    override fun configure(arg: WrapperLookup) {
        getOrCreateTagBuilder(PolariumItemTags.ROOT_ADVANCEMENT)
            .add(PolariumItems.SAND_POWDER)
            .add(PolariumItems.REDSTONE_SUPERCONDUCTOR)
    }
}