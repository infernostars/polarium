package dev.infernity.polarium.datagen

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.minecraft.registry.RegistryWrapper.WrapperLookup
import java.util.concurrent.CompletableFuture

class DataGenInit : DataGeneratorEntrypoint {
    override fun onInitializeDataGenerator(fabricDataGenerator: FabricDataGenerator) {
        val pack = fabricDataGenerator.createPack()
        val blockTags =
            pack.addProvider { output: FabricDataOutput, registriesFuture: CompletableFuture<WrapperLookup> ->
                PolariumBlockTagsProvider(
                    output,
                    registriesFuture
                )
            }
        pack.addProvider { output: FabricDataOutput, registriesFuture: CompletableFuture<WrapperLookup?>? ->
            PolariumRecipes(
                output,
                registriesFuture
            )
        }
        pack.addProvider { a: FabricDataOutput, b: CompletableFuture<WrapperLookup?>? ->
            PolariumItemTagsProvider(
                a,
                b,
                blockTags
            )
        }
        pack.addProvider { output: FabricDataOutput, registryLookup: CompletableFuture<WrapperLookup?>? ->
            PolariumAdvancements(
                output,
                registryLookup
            )
        }
    }
}