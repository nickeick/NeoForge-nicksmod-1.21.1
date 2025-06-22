package com.nickkick.nicksmod.datagen;

import com.nickkick.nicksmod.NicksMod;
import com.nickkick.nicksmod.block.ModBlocks;
import com.nickkick.nicksmod.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.neoforged.fml.common.Mod;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        List<ItemLike> BISMUTH_SMELTABLES = List.of(ModItems.RAW_BISMUTH,
                ModBlocks.BISMUTH_ORE, ModBlocks.BISMUTH_DEEPSLATE_ORE);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.BISMUTH_BLOCK.get())
                .pattern("BBB")
                .pattern("BBB")
                .pattern("BBB")
                .define('B', ModItems.BISMUTH.get())
                .unlockedBy("has_bismuth", has(ModItems.BISMUTH)).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.BISMUTH.get(), 9)
                .requires(ModBlocks.BISMUTH_BLOCK)
                .unlockedBy("has_bismuth_block", has(ModBlocks.BISMUTH_BLOCK)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.HOT_DOG.get(), 2)
                .pattern("#X#")
                .define('#', Items.BREAD)
                .define('X', Items.COOKED_PORKCHOP)
                .unlockedBy("has_bread", has(Items.BREAD))
                .unlockedBy("has_cooked_porkchop", has(Items.COOKED_PORKCHOP)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.HOT_DOG_BLOCK.get())
                .pattern("HHH")
                .pattern("HHH")
                .pattern("HHH")
                .define('H', ModItems.HOT_DOG.get())
                .unlockedBy("has_hot_dog", has(ModItems.HOT_DOG)).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.HOT_DOG.get(), 9)
                .requires(ModBlocks.HOT_DOG_BLOCK)
                .unlockedBy("has_hot_dog_block", has(ModBlocks.HOT_DOG_BLOCK))
                .save(recipeOutput, "nicksmod:hot_dog_from_hot_dog_block");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PIZZADINO_TOKEN.get())
                .pattern("XXX")
                .pattern("XXX")
                .pattern("XXX")
                .define('X', ModBlocks.HOT_DOG_BLOCK.get())
                .unlockedBy("has_hot_dog_block", has(ModBlocks.HOT_DOG_BLOCK)).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.HOT_DOG_BLOCK.get(), 9)
                .requires(ModItems.PIZZADINO_TOKEN)
                .unlockedBy("has_pizzadino_token", has(ModItems.PIZZADINO_TOKEN))
                .save(recipeOutput, "nicksmod:hot_dog_block_from_pizzadino_token");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PIZZA_SLICE.get())
                .pattern("P  ")
                .pattern("PP ")
                .pattern("PPP")
                .define('P', ModItems.PIZZADINO_TOKEN.get())
                .unlockedBy("has_pizzadino_token", has(ModItems.PIZZADINO_TOKEN))
                .save(recipeOutput, "nicksmod:pizza_slice_from_pizzadino_token");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.PIZZADINO_TOKEN.get(), 6)
                .requires(ModItems.PIZZA_SLICE)
                .unlockedBy("has_pizza_slice", has(ModItems.PIZZA_SLICE))
                .save(recipeOutput, "nicksmod:pizzadino_token_from_pizza_slice");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.PIZZA_BLOCK.get())
                .pattern("PPP")
                .pattern("PPP")
                .pattern("PPP")
                .define('P', ModItems.PIZZA_SLICE.get())
                .unlockedBy("has_pizza_slice", has(ModItems.PIZZA_SLICE)).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.PIZZA_SLICE.get(), 9)
                .requires(ModBlocks.PIZZA_BLOCK)
                .unlockedBy("has_pizza_block", has(ModBlocks.PIZZA_BLOCK))
                .save(recipeOutput, "nicksmod:pizza_slice_from_pizza_block");

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.PIZZA_HELMET.get())
                .pattern("PPP")
                .pattern("P P")
                .pattern("   ")
                .define('P', ModItems.PIZZA_SLICE.get())
                .unlockedBy("has_pizza_slice", has(ModItems.PIZZA_SLICE)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.PIZZA_CHESTPLATE.get())
                .pattern("P P")
                .pattern("PPP")
                .pattern("PPP")
                .define('P', ModItems.PIZZA_SLICE.get())
                .unlockedBy("has_pizza_slice", has(ModItems.PIZZA_SLICE)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.PIZZA_LEGGINGS.get())
                .pattern("PPP")
                .pattern("P P")
                .pattern("P P")
                .define('P', ModItems.PIZZA_SLICE.get())
                .unlockedBy("has_pizza_slice", has(ModItems.PIZZA_SLICE)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.PIZZA_BOOTS.get())
                .pattern("   ")
                .pattern("P P")
                .pattern("P P")
                .define('P', ModItems.PIZZA_SLICE.get())
                .unlockedBy("has_pizza_slice", has(ModItems.PIZZA_SLICE)).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.BISMUTH.get(), 18)
                .requires(ModBlocks.BISMUTH_BLOCK)
                .unlockedBy("has_bismuth_block", has(ModBlocks.MAGIC_BLOCK))
                .save(recipeOutput, "nicksmod:bismuth_from_magic_block");



        oreSmelting(recipeOutput, BISMUTH_SMELTABLES, RecipeCategory.MISC, ModItems.BISMUTH.get(), 0.25f, 200, "bismuth");
        oreBlasting(recipeOutput, BISMUTH_SMELTABLES, RecipeCategory.MISC, ModItems.BISMUTH.get(), 0.25f, 100, "bismuth");

        stairBuilder(ModBlocks.HOT_DOG_STAIRS.get(), Ingredient.of(ModItems.HOT_DOG)).group("hot_dog")
                .unlockedBy("has_hot_dog", has(ModItems.HOT_DOG)).save(recipeOutput);
        slab(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.HOT_DOG_SLAB.get(), ModItems.HOT_DOG.get());
        buttonBuilder(ModBlocks.HOT_DOG_BUTTON.get(), Ingredient.of(ModItems.HOT_DOG.get())).group("hot_dog")
                .unlockedBy("has_hot_dog", has(ModItems.HOT_DOG.get())).save(recipeOutput);
        pressurePlate(recipeOutput, ModBlocks.HOT_DOG_PRESSURE_PLATE.get(), ModItems.HOT_DOG.get());

        fenceBuilder(ModBlocks.HOT_DOG_FENCE.get(), Ingredient.of(ModItems.HOT_DOG.get())).group("hot_dog")
                .unlockedBy("has_hot_dog", has(ModItems.HOT_DOG.get())).save(recipeOutput);
        fenceGateBuilder(ModBlocks.HOT_DOG_FENCE_GATE.get(), Ingredient.of(ModItems.HOT_DOG.get())).group("hot_dog")
                .unlockedBy("has_hot_dog", has(ModItems.HOT_DOG.get())).save(recipeOutput);
        wall(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.HOT_DOG_WALL.get(), ModItems.HOT_DOG.get());

        doorBuilder(ModBlocks.HOT_DOG_DOOR.get(), Ingredient.of(ModItems.HOT_DOG.get())).group("hot_dog")
                .unlockedBy("has_hot_dog", has(ModItems.HOT_DOG.get())).save(recipeOutput);
        trapdoorBuilder(ModBlocks.HOT_DOG_TRAPDOOR.get(), Ingredient.of(ModItems.HOT_DOG.get())).group("hot_dog")
                .unlockedBy("has_hot_dog", has(ModItems.HOT_DOG.get())).save(recipeOutput);
    }

    protected static void oreSmelting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput recipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                                                                       List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(recipeOutput, NicksMod.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}
