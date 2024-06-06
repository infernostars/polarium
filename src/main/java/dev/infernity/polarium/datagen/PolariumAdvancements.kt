package dev.infernity.polarium.datagen

import dev.infernity.polarium.PolariumServersideInit
import dev.infernity.polarium.items.PolariumItemTags
import dev.infernity.polarium.items.PolariumItems
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider
import net.minecraft.advancement.Advancement
import net.minecraft.advancement.AdvancementEntry
import net.minecraft.advancement.AdvancementFrame
import net.minecraft.advancement.criterion.InventoryChangedCriterion
import net.minecraft.item.Items
import net.minecraft.predicate.item.ItemPredicate
import net.minecraft.registry.RegistryWrapper.WrapperLookup
import net.minecraft.text.Text
import net.minecraft.util.Identifier
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

class PolariumAdvancements(output: FabricDataOutput, registryLookup: CompletableFuture<WrapperLookup?>?) :
    FabricAdvancementProvider(output, registryLookup) {
    override fun generateAdvancement(registryLookup: WrapperLookup, consumer: Consumer<AdvancementEntry>) {
        val root_advancement = Advancement.Builder.create()
            .display(
                Items.SNOWBALL,  // The display icon
                Text.translatable("advancements.polarium.base.title"),  // The title
                Text.translatable("advancements.polarium.base.description"),  // The description
                Identifier("textures/gui/advancements/backgrounds/adventure.png"),  // Background image used
                AdvancementFrame.TASK,  // Options: TASK, CHALLENGE, GOAL
                true,  // Show toast top right
                true,  // Announce to chat
                false // Shown in advancement page
            )
            .criterion(
                "polarium_root_items", InventoryChangedCriterion.Conditions.items(
                    ItemPredicate.Builder.create().tag(PolariumItemTags.ROOT_ADVANCEMENT)
                )
            )
            .build(consumer, PolariumServersideInit.Companion.id("main").toString() + "/root")

        val cheese = Advancement.Builder.create()
            .parent(root_advancement)
            .display(
                PolariumItems.CHEESE,  // The display icon
                Text.translatable("advancements.polarium.cheese.title"),
                Text.translatable("advancements.polarium.cheese.description"),
                null,
                AdvancementFrame.TASK,
                true,  // Show toast top right
                true,  // Announce to chat
                false // Shown in advancement page
            )
            .criterion(
                "polarium_cheese", InventoryChangedCriterion.Conditions.items(
                    PolariumItems.CHEESE
                )
            )
            .build(consumer, PolariumServersideInit.Companion.id("main").toString() + "/cheese")

        val beef_jerky = Advancement.Builder.create()
            .parent(root_advancement)
            .display(
                PolariumItems.BEEF_JERKY,  // The display icon
                Text.translatable("advancements.polarium.beef_jerky.title"),
                Text.translatable("advancements.polarium.beef_jerky.description"),
                null,
                AdvancementFrame.TASK,
                true,  // Show toast top right
                true,  // Announce to chat
                false // Shown in advancement page
            )
            .criterion(
                "polarium_beef_jerky", InventoryChangedCriterion.Conditions.items(
                    PolariumItems.BEEF_JERKY
                )
            )
            .build(consumer, PolariumServersideInit.Companion.id("main").toString() + "/beef_jerky")


        val redstone_superconductor = Advancement.Builder.create()
            .parent(root_advancement)
            .display(
                PolariumItems.REDSTONE_SUPERCONDUCTOR,  // The display icon
                Text.translatable("advancements.polarium.redstone_superconductor.title"),
                Text.translatable("advancements.polarium.redstone_superconductor.description"),
                null,
                AdvancementFrame.GOAL,
                true,  // Show toast top right
                true,  // Announce to chat
                false // Shown in advancement page
            )
            .criterion(
                "polarium_redstone_superconductor", InventoryChangedCriterion.Conditions.items(
                    PolariumItems.REDSTONE_SUPERCONDUCTOR
                )
            )
            .build(consumer, PolariumServersideInit.Companion.id("main").toString() + "/redstone_superconductor")

        val base_talisman = Advancement.Builder.create()
            .parent(redstone_superconductor)
            .display(
                PolariumItems.BASE_TALISMAN,  // The display icon
                Text.translatable("advancements.polarium.base_talisman.title"),
                Text.translatable("advancements.polarium.base_talisman.description"),
                null,
                AdvancementFrame.GOAL,
                true,  // Show toast top right
                true,  // Announce to chat
                false // Shown in advancement page
            )
            .criterion(
                "polarium_base_talisman", InventoryChangedCriterion.Conditions.items(
                    PolariumItems.BASE_TALISMAN
                )
            )
            .build(consumer, PolariumServersideInit.Companion.id("main").toString() + "/base_talisman")

        val iron_talisman = Advancement.Builder.create()
            .parent(base_talisman)
            .display(
                PolariumItems.IRON_TALISMAN,  // The display icon
                Text.translatable("advancements.polarium.iron_talisman.title"),
                Text.translatable("advancements.polarium.iron_talisman.description"),
                null,
                AdvancementFrame.TASK,
                true,  // Show toast top right
                true,  // Announce to chat
                false // Shown in advancement page
            )
            .criterion(
                "polarium_iron_talisman", InventoryChangedCriterion.Conditions.items(
                    PolariumItems.IRON_TALISMAN
                )
            )
            .build(consumer, PolariumServersideInit.Companion.id("main").toString() + "/iron_talisman")
        val paper_talisman = Advancement.Builder.create()
            .parent(base_talisman)
            .display(
                PolariumItems.PAPER_TALISMAN,  // The display icon
                Text.translatable("advancements.polarium.paper_talisman.title"),
                Text.translatable("advancements.polarium.paper_talisman.description"),
                null,
                AdvancementFrame.TASK,
                true,  // Show toast top right
                true,  // Announce to chat
                false // Shown in advancement page
            )
            .criterion(
                "polarium_paper_talisman", InventoryChangedCriterion.Conditions.items(
                    PolariumItems.PAPER_TALISMAN
                )
            )
            .build(consumer, PolariumServersideInit.Companion.id("main").toString() + "/paper_talisman")
        val scavengers_talisman = Advancement.Builder.create()
            .parent(base_talisman)
            .display(
                PolariumItems.SCAVENGER_TALISMAN,  // The display icon
                Text.translatable("advancements.polarium.scavengers_talisman.title"),
                Text.translatable("advancements.polarium.scavengers_talisman.description"),
                null,
                AdvancementFrame.TASK,
                true,  // Show toast top right
                true,  // Announce to chat
                false // Shown in advancement page
            )
            .criterion(
                "polarium_scavengers_talisman", InventoryChangedCriterion.Conditions.items(
                    PolariumItems.SCAVENGER_TALISMAN
                )
            )
            .build(consumer, PolariumServersideInit.Companion.id("main").toString() + "/scavengers_talisman")
    }
}