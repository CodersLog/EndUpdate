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


        stairBuilder(ModBlocks.SLUDGE_BRICK_STAIRS.get(), Ingredient.of(ModBlocks.SLUDGE_BRICKS)).group("sludge_bricks")
                .unlockedBy("has_bismuth", has(ModBlocks.SLUDGE_BRICKS)).save(output);
        slab(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SLUDGE_BRICK_SLAB.get(), ModBlocks.SLUDGE_BRICKS.get());
        wall(RecipeCategory.MISC,ModBlocks.SLUDGE_BRICK_WALL.get(),ModBlocks.SLUDGE_BRICKS);

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