package com.coders.endupdate.content.datagen;

import com.coders.endupdate.EndUpdate;
import com.coders.endupdate.content.Util.ModTags;
import com.coders.endupdate.content.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider {
    public ModRecipeProvider(HolderLookup.Provider provider, RecipeOutput recipeOutput) {
        super(provider, recipeOutput);
    }

    public static class Runner extends RecipeProvider.Runner {
        public Runner(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> provider) {
            super(packOutput, provider);
        }

        @Override
        protected RecipeProvider createRecipeProvider(HolderLookup.Provider provider, RecipeOutput recipeOutput) {
            return new ModRecipeProvider(provider, recipeOutput);
        }

        @Override
        public String getName() {
            return "My Recipes";
        }
    }


    @Override
    protected void buildRecipes() {


        shapeless(RecipeCategory.MISC, ModBlocks.PACKED_SLUDGE.get(), 1)
                .requires(Items.WHEAT)
                .requires(ModBlocks.SLUDGE)
                .unlockedBy("has_bismuth_block", has(ModBlocks.PACKED_SLUDGE)).save(output);

        shaped(RecipeCategory.MISC, ModBlocks.SLUDGE_BRICKS.get(),4)
                .pattern("BB")
                .pattern("BB")
                .define('B', ModBlocks.PACKED_SLUDGE.get())
                .unlockedBy("has_bismuth", has(ModBlocks.PACKED_SLUDGE)).save(output);

        shaped(RecipeCategory.MISC, ModBlocks.CHORUS_DOOR.get(),3)
                .pattern("BB")
                .pattern("BB")
                .pattern("BB")
                .define('B', ModBlocks.CHORUS_PLANKS.get())
                .unlockedBy("has_bismuth", has(ModBlocks.CHORUS_LOG)).save(output);



        shaped(RecipeCategory.MISC, ModBlocks.CHORUS_TRAPDOOR.get(),2)
                .pattern("BBB")
                .pattern("BBB")
                .define('B', ModBlocks.CHORUS_PLANKS.get())
                .unlockedBy("has_bismuth", has(ModBlocks.CHORUS_LOG)).save(output);
        stairBuilder(ModBlocks.CHORUS_STAIRS.get(), Ingredient.of(ModBlocks.CHORUS_PLANKS)).group("sludge_bricks")
                .unlockedBy("has_bismuth", has(ModBlocks.CHORUS_LOG)).save(output);

        planksFromLogs(ModBlocks.CHORUS_PLANKS, ModTags.Items.CHORUSLOGS, 4);

        shaped(RecipeCategory.MISC, ModBlocks.CHORUS_FENCE.get(),3)
                .pattern("BIB")
                .pattern("BIB")
                .define('B', ModBlocks.CHORUS_PLANKS.get())
                .define('I', Items.STICK)
                .unlockedBy("has_bismuth", has(ModBlocks.CHORUS_LOG)).save(output);

        shaped(RecipeCategory.MISC, ModBlocks.CHORUS_FENCE_GATE.get(),1)
                .pattern("IBI")
                .pattern("IBI")
                .define('B', ModBlocks.CHORUS_PLANKS.get())
                .define('I', Items.STICK)
                .unlockedBy("has_bismuth", has(ModBlocks.CHORUS_LOG)).save(output);

        shaped(RecipeCategory.MISC, ModBlocks.CHORUS_PRESSURE_PLATE.get(),1)
                .pattern("BB")
                .define('B', ModBlocks.CHORUS_PLANKS.get())
                .unlockedBy("has_bismuth", has(ModBlocks.CHORUS_LOG)).save(output);

        shapeless(RecipeCategory.MISC, ModBlocks.CHORUS_BUTTON.get(),1)
                .requires(ModBlocks.CHORUS_PLANKS.get())
                .unlockedBy("has_bismuth", has(ModBlocks.CHORUS_LOG)).save(output);

        slab(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHORUS_SLAB.get(), ModBlocks.CHORUS_PLANKS.get());


        shaped(RecipeCategory.MISC, ModBlocks.SPORE_WILLOW_DOOR.get(),3)
                .pattern("BB")
                .pattern("BB")
                .pattern("BB")
                .define('B', ModBlocks.SPORE_WILLOW_PLANKS.get())
                .unlockedBy("has_bismuth", has(ModBlocks.SPORE_WILLOW_LOG)).save(output);



        shaped(RecipeCategory.MISC, ModBlocks.SPORE_WILLOW_TRAPDOOR.get(),2)
                .pattern("BBB")
                .pattern("BBB")
                .define('B', ModBlocks.SPORE_WILLOW_PLANKS.get())
                .unlockedBy("has_bismuth", has(ModBlocks.SPORE_WILLOW_LOG)).save(output);
        stairBuilder(ModBlocks.SPORE_WILLOW_STAIRS.get(), Ingredient.of(ModBlocks.SPORE_WILLOW_PLANKS)).group("sludge_bricks")
                .unlockedBy("has_bismuth", has(ModBlocks.SPORE_WILLOW_LOG)).save(output);

        planksFromLogs(ModBlocks.SPORE_WILLOW_PLANKS, ModTags.Items.SPORE_WILLOWLOGS, 4);

        shaped(RecipeCategory.MISC, ModBlocks.SPORE_WILLOW_FENCE.get(),3)
                .pattern("BIB")
                .pattern("BIB")
                .define('B', ModBlocks.SPORE_WILLOW_PLANKS.get())
                .define('I', Items.STICK)
                .unlockedBy("has_bismuth", has(ModBlocks.SPORE_WILLOW_LOG)).save(output);

        shaped(RecipeCategory.MISC, ModBlocks.SPORE_WILLOW_FENCE_GATE.get(),1)
                .pattern("IBI")
                .pattern("IBI")
                .define('B', ModBlocks.SPORE_WILLOW_PLANKS.get())
                .define('I', Items.STICK)
                .unlockedBy("has_bismuth", has(ModBlocks.SPORE_WILLOW_LOG)).save(output);

        shaped(RecipeCategory.MISC, ModBlocks.SPORE_WILLOW_PRESSURE_PLATE.get(),1)
                .pattern("BB")
                .define('B', ModBlocks.SPORE_WILLOW_PLANKS.get())
                .unlockedBy("has_bismuth", has(ModBlocks.SPORE_WILLOW_LOG)).save(output);

        shapeless(RecipeCategory.MISC, ModBlocks.SPORE_WILLOW_BUTTON.get(),1)
                .requires(ModBlocks.SPORE_WILLOW_PLANKS.get())
                .unlockedBy("has_bismuth", has(ModBlocks.SPORE_WILLOW_LOG)).save(output);

        slab(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SPORE_WILLOW_SLAB.get(), ModBlocks.SPORE_WILLOW_PLANKS.get());



        stairBuilder(ModBlocks.SLUDGE_BRICK_STAIRS.get(), Ingredient.of(ModBlocks.SLUDGE_BRICKS)).group("sludge_bricks")
                .unlockedBy("has_bismuth", has(ModBlocks.SLUDGE_BRICKS)).save(output);
        slab(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SLUDGE_BRICK_SLAB.get(), ModBlocks.SLUDGE_BRICKS.get());
        wall(RecipeCategory.MISC,ModBlocks.SLUDGE_BRICK_WALL.get(),ModBlocks.SLUDGE_BRICKS);

        shaped(RecipeCategory.MISC, ModBlocks.DEAD_SPORE_WILLOW_DOOR.get(),3)
                .pattern("BB")
                .pattern("BB")
                .pattern("BB")
                .define('B', ModBlocks.DEAD_SPORE_WILLOW_PLANKS.get())
                .unlockedBy("has_bismuth", has(ModBlocks.DEAD_SPORE_WILLOW_LOG)).save(output);



        shaped(RecipeCategory.MISC, ModBlocks.DEAD_SPORE_WILLOW_TRAPDOOR.get(),2)
                .pattern("BBB")
                .pattern("BBB")
                .define('B', ModBlocks.DEAD_SPORE_WILLOW_PLANKS.get())
                .unlockedBy("has_bismuth", has(ModBlocks.DEAD_SPORE_WILLOW_LOG)).save(output);
        stairBuilder(ModBlocks.DEAD_SPORE_WILLOW_STAIRS.get(), Ingredient.of(ModBlocks.DEAD_SPORE_WILLOW_PLANKS)).group("sludge_bricks")
                .unlockedBy("has_bismuth", has(ModBlocks.DEAD_SPORE_WILLOW_LOG)).save(output);

        planksFromLogs(ModBlocks.DEAD_SPORE_WILLOW_PLANKS, ModTags.Items.DEAD_SPORE_WILLOWLOGS, 4);

        shaped(RecipeCategory.MISC, ModBlocks.DEAD_SPORE_WILLOW_FENCE.get(),3)
                .pattern("BIB")
                .pattern("BIB")
                .define('B', ModBlocks.DEAD_SPORE_WILLOW_PLANKS.get())
                .define('I', Items.STICK)
                .unlockedBy("has_bismuth", has(ModBlocks.DEAD_SPORE_WILLOW_LOG)).save(output);

        shaped(RecipeCategory.MISC, ModBlocks.DEAD_SPORE_WILLOW_FENCE_GATE.get(),1)
                .pattern("IBI")
                .pattern("IBI")
                .define('B', ModBlocks.DEAD_SPORE_WILLOW_PLANKS.get())
                .define('I', Items.STICK)
                .unlockedBy("has_bismuth", has(ModBlocks.DEAD_SPORE_WILLOW_LOG)).save(output);

        shaped(RecipeCategory.MISC, ModBlocks.DEAD_SPORE_WILLOW_PRESSURE_PLATE.get(),1)
                .pattern("BB")
                .define('B', ModBlocks.DEAD_SPORE_WILLOW_PLANKS.get())
                .unlockedBy("has_bismuth", has(ModBlocks.DEAD_SPORE_WILLOW_LOG)).save(output);

        shapeless(RecipeCategory.MISC, ModBlocks.DEAD_SPORE_WILLOW_BUTTON.get(),1)
                .requires(ModBlocks.DEAD_SPORE_WILLOW_PLANKS.get())
                .unlockedBy("has_bismuth", has(ModBlocks.DEAD_SPORE_WILLOW_LOG)).save(output);

        slab(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DEAD_SPORE_WILLOW_SLAB.get(), ModBlocks.DEAD_SPORE_WILLOW_PLANKS.get());


        shaped(RecipeCategory.MISC, ModBlocks.POLISHED_MALACHITE.get(),4)
                .pattern("BB")
                .pattern("BB")
                .define('B', ModBlocks.MALACHITE.get())
                .unlockedBy("has_bismuth", has(ModBlocks.MALACHITE)).save(output);

        shaped(RecipeCategory.MISC, ModBlocks.MALACHITE_BRICKS.get(),4)
                .pattern("BB")
                .pattern("BB")
                .define('B', ModBlocks.POLISHED_MALACHITE.get())
                .unlockedBy("has_bismuth", has(ModBlocks.MALACHITE)).save(output);


        stairBuilder(ModBlocks.MALACHITE_STAIRS.get(), Ingredient.of(ModBlocks.MALACHITE)).group("malachite")
                .unlockedBy("has_bismuth", has(ModBlocks.MALACHITE)).save(output);
        slab(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MALACHITE_SLAB.get(), ModBlocks.MALACHITE.get());
        wall(RecipeCategory.MISC,ModBlocks.MALACHITE_WALL.get(),ModBlocks.MALACHITE);

        stairBuilder(ModBlocks.MALACHITE_BRICKS_STAIRS.get(), Ingredient.of(ModBlocks.MALACHITE_BRICKS)).group("malachite_bricks")
                .unlockedBy("has_bismuth", has(ModBlocks.MALACHITE_BRICKS)).save(output);
        slab(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MALACHITE_BRICKS_SLAB.get(), ModBlocks.MALACHITE_BRICKS.get());
        wall(RecipeCategory.MISC,ModBlocks.MALACHITE_BRICKS_WALL.get(),ModBlocks.MALACHITE_BRICKS);

        stairBuilder(ModBlocks.POLISHED_MALACHITE_STAIRS.get(), Ingredient.of(ModBlocks.POLISHED_MALACHITE)).group("polished_malachite")
                .unlockedBy("has_bismuth", has(ModBlocks.SLUDGE_BRICKS)).save(output);
        slab(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_MALACHITE_SLAB.get(), ModBlocks.POLISHED_MALACHITE.get());

        chiseled(RecipeCategory.MISC,ModBlocks.CHISELED_MALACHITE_BRICKS.asItem(),ModBlocks.MALACHITE_BRICKS_SLAB);
        chiseled(RecipeCategory.MISC,ModBlocks.CHISELED_ENDSTONE_BRICKS.asItem(), Blocks.END_STONE_BRICK_SLAB);

        shaped(RecipeCategory.MISC, ModBlocks.HEATER.get(),1)
                .pattern("IBI")
                .pattern("IWI")
                .pattern("GGG")
                .define('B', Items.BLAZE_POWDER)
                .define('I', Items.IRON_INGOT)
                .define('G', Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE)
                .define('W', Items.WIND_CHARGE)
                .unlockedBy("has_bismuth", has(Items.IRON_INGOT)).save(output);

        shaped(RecipeCategory.MISC, ModBlocks.MALACHITE_BRICKS_PEDESTAL.get(),1)
                .pattern("SSS")
                .pattern(" B ")
                .pattern("SSS")
                .define('B', ModBlocks.MALACHITE_BRICKS)
                .define('S', ModBlocks.MALACHITE_BRICKS_SLAB)
                .unlockedBy("has_bismuth", has(ModBlocks.MALACHITE)).save(output);
shaped(RecipeCategory.MISC, ModBlocks.ENDSTONE_BRICKS_PEDESTAL.get(),1)
                .pattern("SSS")
                .pattern(" B ")
                .pattern("SSS")
                .define('B', Blocks.END_STONE_BRICKS)
                .define('S', Blocks.END_STONE_BRICK_SLAB)
                .unlockedBy("has_bismuth", has(Blocks.END_STONE)).save(output);
shaped(RecipeCategory.MISC, ModBlocks.SLUDGE_BRICKS_PEDESTAL.get(),1)
                .pattern("SSS")
                .pattern(" B ")
                .pattern("SSS")
                .define('B', ModBlocks.SLUDGE_BRICKS)
                .define('S', ModBlocks.SLUDGE_BRICK_SLAB)
                .unlockedBy("has_bismuth", has(ModBlocks.SLUDGE)).save(output);


        shaped(RecipeCategory.MISC, ModBlocks.BLACKSTONE_BRICKS_PEDESTAL.get(),1)
                .pattern("SSS")
                .pattern(" B ")
                .pattern("SSS")
                .define('B', Blocks.POLISHED_BLACKSTONE_BRICKS)
                .define('S', Blocks.POLISHED_BLACKSTONE_BRICK_SLAB)
                .unlockedBy("has_bismuth", has(Blocks.BLACKSTONE)).save(output);

        shaped(RecipeCategory.MISC, ModBlocks.BRICKS_PEDESTAL.get(),1)
                .pattern("SSS")
                .pattern(" B ")
                .pattern("SSS")
                .define('B', Blocks.BRICKS)
                .define('S', Blocks.BRICK_SLAB)
                .unlockedBy("has_bismuth", has(Items.CLAY)).save(output);

        shaped(RecipeCategory.MISC, ModBlocks.MOSSY_STONE_BRICKS_PEDESTAL.get(),1)
                .pattern("SSS")
                .pattern(" B ")
                .pattern("SSS")
                .define('B', Blocks.MOSSY_STONE_BRICKS)
                .define('S', Blocks.MOSSY_STONE_BRICK_SLAB)
                .unlockedBy("has_bismuth", has(Blocks.MOSSY_STONE_BRICKS)).save(output);

        shaped(RecipeCategory.MISC, ModBlocks.MUD_BRICKS_PEDESTAL.get(),1)
                .pattern("SSS")
                .pattern(" B ")
                .pattern("SSS")
                .define('B', Blocks.MUD_BRICKS)
                .define('S', Blocks.MUD_BRICK_SLAB)
                .unlockedBy("has_bismuth", has(Blocks.PACKED_MUD)).save(output);

        shaped(RecipeCategory.MISC, ModBlocks.NETHER_BRICKS_PEDESTAL.get(),1)
                .pattern("SSS")
                .pattern(" B ")
                .pattern("SSS")
                .define('B', Blocks.NETHER_BRICKS)
                .define('S', Blocks.NETHER_BRICK_SLAB)
                .unlockedBy("has_bismuth", has(Blocks.NETHER_BRICKS)).save(output);

        shaped(RecipeCategory.MISC, ModBlocks.PRISMARINE_BRICKS_PEDESTAL.get(),1)
                .pattern("SSS")
                .pattern(" B ")
                .pattern("SSS")
                .define('B', Blocks.PRISMARINE_BRICKS)
                .define('S', Blocks.PRISMARINE_BRICK_SLAB)
                .unlockedBy("has_bismuth", has(Blocks.PRISMARINE_BRICKS)).save(output);

        shaped(RecipeCategory.MISC, ModBlocks.QUARTZ_BRICKS_PEDESTAL.get(),1)
                .pattern("SSS")
                .pattern(" B ")
                .pattern("SSS")
                .define('B', Blocks.QUARTZ_BRICKS)
                .define('S', Blocks.QUARTZ_SLAB)
                .unlockedBy("has_bismuth", has(Items.QUARTZ)).save(output);

        shaped(RecipeCategory.MISC, ModBlocks.RED_NETHER_BRICKS_PEDESTAL.get(),1)
                .pattern("SSS")
                .pattern(" B ")
                .pattern("SSS")
                .define('B', Blocks.RED_NETHER_BRICKS)
                .define('S', Blocks.RED_NETHER_BRICK_SLAB)
                .unlockedBy("has_bismuth", has(Blocks.RED_NETHER_BRICKS)).save(output);

        shaped(RecipeCategory.MISC, ModBlocks.RESIN_BRICKS_PEDESTAL.get(),1)
                .pattern("SSS")
                .pattern(" B ")
                .pattern("SSS")
                .define('B', Blocks.RESIN_BRICKS)
                .define('S', Blocks.RESIN_BRICK_SLAB)
                .unlockedBy("has_bismuth", has(Blocks.RESIN_BRICKS)).save(output);

        shaped(RecipeCategory.MISC, ModBlocks.STONE_BRICKS_PEDESTAL.get(),1)
                .pattern("SSS")
                .pattern(" B ")
                .pattern("SSS")
                .define('B', Blocks.STONE_BRICKS)
                .define('S', Blocks.STONE_BRICK_SLAB)
                .unlockedBy("has_bismuth", has(Blocks.STONE_BRICKS)).save(output);

        shaped(RecipeCategory.MISC, ModBlocks.TUFF_BRICKS_PEDESTAL.get(),1)
                .pattern("SSS")
                .pattern(" B ")
                .pattern("SSS")
                .define('B', Blocks.TUFF_BRICKS)
                .define('S', Blocks.TUFF_BRICK_SLAB)
                .unlockedBy("has_bismuth", has(Blocks.TUFF)).save(output);

        shaped(RecipeCategory.MISC, ModBlocks.DEEPSLATE_BRICKS_PEDESTAL.get(),1)
                .pattern("SSS")
                .pattern(" B ")
                .pattern("SSS")
                .define('B', Blocks.DEEPSLATE_BRICKS)
                .define('S', Blocks.DEEPSLATE_BRICK_SLAB)
                .unlockedBy("has_bismuth", has(Blocks.DEEPSLATE)).save(output);





    }

    protected void oreSmelting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                               float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected void oreBlasting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                               float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput recipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                                                                List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(recipeOutput, EndUpdate.MODID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}