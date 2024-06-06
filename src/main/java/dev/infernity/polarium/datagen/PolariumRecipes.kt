package dev.infernity.polarium.datagen

import dev.infernity.polarium.PolariumServersideInit
import dev.infernity.polarium.items.PolariumItems
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags
import net.minecraft.advancement.criterion.InventoryChangedCriterion
import net.minecraft.data.server.recipe.RecipeExporter
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder
import net.minecraft.item.ItemConvertible
import net.minecraft.item.Items
import net.minecraft.predicate.item.ItemPredicate
import net.minecraft.recipe.book.RecipeCategory
import net.minecraft.registry.RegistryWrapper.WrapperLookup
import net.minecraft.registry.tag.ItemTags
import java.util.concurrent.CompletableFuture

class PolariumRecipes(output: FabricDataOutput, registriesFuture: CompletableFuture<WrapperLookup?>?) :
    FabricRecipeProvider(output, registriesFuture) {
    override fun generate(exporter: RecipeExporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, PolariumItems.REDSTONE_SUPERCONDUCTOR, 1)
            .pattern("awa")
            .pattern("waw")
            .pattern("awa")
            .input('w', Items.REDSTONE_BLOCK)
            .input('a', Items.COPPER_BLOCK)
            .criterion("get_redstone", InventoryChangedCriterion.Conditions.items(Items.REDSTONE))
            .offerTo(exporter)

        /*ShapedRecipeJsonBuilder.create(RecipeCategory.BREWING, PolariumItems.HEART_CRYSTAL, 1)
                .pattern("gca")
                .pattern("crc")
                .pattern("pcb")
                .input('c', Items.END_CRYSTAL)
                .input('g', Items.GOLDEN_APPLE)
                .input('r', PolariumItems.REDSTONE_SUPERCONDUCTOR)
                .input('a', Items.AMETHYST_SHARD)
                .input('b', Items.BLAZE_ROD)
                .input('p', Items.PHANTOM_MEMBRANE)
                .criterion("get_superconductor", InventoryChangedCriterion.Conditions.items(PolariumItems.REDSTONE_SUPERCONDUCTOR))
                .offerTo(exporter);*/
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, PolariumItems.SAND_POWDER, 4)
            .input(Items.SAND)
            .criterion("get_sand", InventoryChangedCriterion.Conditions.items(Items.SAND))
            .offerTo(exporter)

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, PolariumItems.SAND_POWDER, 4)
            .input(ConventionalItemTags.STONES)
            .input(ConventionalItemTags.STONES)
            .criterion(
                "get_stones", InventoryChangedCriterion.Conditions.items(
                    ItemPredicate.Builder.create().tag(ConventionalItemTags.STONES)
                )
            )
            .offerTo(exporter, PolariumServersideInit.Companion.id("sand_powder_two_stone"))

        offerSmelting(
            exporter,
            listOf<ItemConvertible>(PolariumItems.SAND_POWDER),
            RecipeCategory.FOOD,
            PolariumItems.SALT_POWDER,
            0.5f,
            50,
            "salt_powder"
        )
        offerBlasting(
            exporter,
            listOf<ItemConvertible>(PolariumItems.SAND_POWDER),
            RecipeCategory.FOOD,
            PolariumItems.SALT_POWDER,
            0.5f,
            25,
            "salt_powder"
        )

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, PolariumItems.SAND_PLATE, 1)
            .pattern("aa ")
            .input('a', PolariumItems.SAND_POWDER)
            .criterion("get_sand", InventoryChangedCriterion.Conditions.items(Items.SAND))
            .offerTo(exporter)

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.SAND, 1)
            .pattern("aa ")
            .pattern("aa ")
            .input('a', PolariumItems.SAND_POWDER)
            .criterion("get_sand", InventoryChangedCriterion.Conditions.items(Items.SAND))
            .offerTo(exporter, PolariumServersideInit.Companion.id("sand_powder_recraft"))

        offerSmelting(
            exporter,
            listOf<ItemConvertible>(PolariumItems.SAND_PLATE),
            RecipeCategory.MISC,
            PolariumItems.SILICON_PLATE,
            5.5f,
            1200,
            "silicon_plate"
        )
        offerBlasting(
            exporter,
            listOf<ItemConvertible>(PolariumItems.SAND_PLATE),
            RecipeCategory.FOOD,
            PolariumItems.SILICON_PLATE,
            5.5f,
            600,
            "silicon_plate"
        )

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, PolariumItems.CHEESE, 2)
            .input(PolariumItems.SALT_POWDER)
            .input(Items.MILK_BUCKET)
            .criterion("get_salt", InventoryChangedCriterion.Conditions.items(PolariumItems.SALT_POWDER))
            .offerTo(exporter)

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, PolariumItems.BEEF_JERKY, 1)
            .input(PolariumItems.SALT_POWDER)
            .input(Items.ROTTEN_FLESH)
            .criterion("get_salt", InventoryChangedCriterion.Conditions.items(PolariumItems.SALT_POWDER))
            .offerTo(exporter)

        offerSmelting(
            exporter,
            listOf<ItemConvertible>(PolariumItems.BEEF_JERKY),
            RecipeCategory.MISC,
            Items.LEATHER,
            0.35f,
            200,
            "leather"
        )
        offerBlasting(
            exporter,
            listOf<ItemConvertible>(PolariumItems.BEEF_JERKY),
            RecipeCategory.FOOD,
            Items.LEATHER,
            0.35f,
            100,
            "leather"
        )
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, PolariumItems.BASE_TALISMAN, 1)
            .pattern("awa")
            .pattern("wbw")
            .pattern("awa")
            .input('b', PolariumItems.REDSTONE_SUPERCONDUCTOR)
            .input('w', Items.AMETHYST_SHARD)
            .input('a', PolariumItems.SILICON_PLATE)
            .criterion("get_superconductor", InventoryChangedCriterion.Conditions.items(PolariumItems.REDSTONE_SUPERCONDUCTOR))
            .offerTo(exporter)
        ShapelessRecipeJsonBuilder(RecipeCategory.TOOLS, PolariumItems.PAPER_TALISMAN, 1)
            .input(PolariumItems.BASE_TALISMAN)
            .input(ItemTags.WOOL)
            .input(Items.FEATHER)
            .input(Items.PAPER)
            .criterion("get_base_talisman", InventoryChangedCriterion.Conditions.items(PolariumItems.BASE_TALISMAN))
            .offerTo(exporter)
        ShapelessRecipeJsonBuilder(RecipeCategory.TOOLS, PolariumItems.IRON_TALISMAN, 1)
            .input(PolariumItems.BASE_TALISMAN)
            .input(Items.IRON_INGOT, 2)
            .input(Items.IRON_BLOCK)
            .criterion("get_base_talisman", InventoryChangedCriterion.Conditions.items(PolariumItems.BASE_TALISMAN))
            .offerTo(exporter)
        ShapelessRecipeJsonBuilder(RecipeCategory.TOOLS, PolariumItems.SCAVENGER_TALISMAN, 1)
            .input(PolariumItems.BASE_TALISMAN)
            .input(Items.LEATHER_BOOTS)
            .input(Items.IRON_PICKAXE)
            .criterion("get_base_talisman", InventoryChangedCriterion.Conditions.items(PolariumItems.BASE_TALISMAN))
            .offerTo(exporter)
        ShapelessRecipeJsonBuilder(RecipeCategory.TOOLS, PolariumItems.HUP_TALISMAN, 1)
            .input(PolariumItems.BASE_TALISMAN)
            .input(Items.SUGAR, 3)
            .criterion("get_base_talisman", InventoryChangedCriterion.Conditions.items(PolariumItems.BASE_TALISMAN))
            .offerTo(exporter)
        ShapelessRecipeJsonBuilder(RecipeCategory.TOOLS, PolariumItems.DAMAGE_TALISMAN, 1)
            .input(PolariumItems.BASE_TALISMAN)
            .input(Items.IRON_SWORD)
            .criterion("get_base_talisman", InventoryChangedCriterion.Conditions.items(PolariumItems.BASE_TALISMAN))
            .offerTo(exporter)
        ShapelessRecipeJsonBuilder(RecipeCategory.TOOLS, PolariumItems.REACH_TALISMAN, 1)
            .input(PolariumItems.BASE_TALISMAN)
            .input(Items.PISTON)
            .criterion("get_base_talisman", InventoryChangedCriterion.Conditions.items(PolariumItems.BASE_TALISMAN))
            .offerTo(exporter)
    }
}
