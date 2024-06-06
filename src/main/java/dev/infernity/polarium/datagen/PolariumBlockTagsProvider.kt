package dev.infernity.polarium.datagen

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider.BlockTagProvider
import net.minecraft.registry.RegistryWrapper.WrapperLookup
import java.util.concurrent.CompletableFuture

internal class PolariumBlockTagsProvider(
    output: FabricDataOutput,
    registriesFuture: CompletableFuture<WrapperLookup>
) : BlockTagProvider(output, registriesFuture) {
    override fun configure(wrapperLookup: WrapperLookup) {
        // For now, Polarium doesn't implement any blocks - so this is mostly a filler so that ItemTagsProvider works.
    }
}
