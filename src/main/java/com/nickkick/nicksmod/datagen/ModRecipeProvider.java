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

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModItems.HOT_DOG.get(), 2)
                .pattern("#X#")
                .define('#', Items.BREAD)
                .define('X', Items.COOKED_PORKCHOP)
                .unlockedBy("has_bread", has(Items.BREAD))
                .unlockedBy("has_cooked_porkchop", has(Items.COOKED_PORKCHOP)).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.HOT_DOG_WITH_KETCHUP.get())
                .requires(ModItems.HOT_DOG)
                .requires(ModItems.KETCHUP)
                .unlockedBy("has_hot_dog", has(ModItems.HOT_DOG))
                .unlockedBy("has_ketchup", has(ModItems.KETCHUP)).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.HOT_DOG_WITH_MUSTARD.get())
                .requires(ModItems.HOT_DOG)
                .requires(ModItems.MUSTARD)
                .unlockedBy("has_hot_dog", has(ModItems.HOT_DOG))
                .unlockedBy("has_mustard", has(ModItems.MUSTARD)).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.HOT_DOG_WITH_KETCHUP_AND_MUSTARD.get())
                .requires(ModItems.HOT_DOG)
                .requires(ModItems.KETCHUP)
                .requires(ModItems.MUSTARD)
                .unlockedBy("has_hot_dog", has(ModItems.HOT_DOG))
                .unlockedBy("has_ketchup", has(ModItems.KETCHUP))
                .unlockedBy("has_hot_mustard", has(ModItems.MUSTARD))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.HOT_DOG_WITH_KETCHUP_AND_MUSTARD.get())
                .requires(ModItems.HOT_DOG_WITH_KETCHUP)
                .requires(ModItems.MUSTARD)
                .unlockedBy("has_hot_dog_with_ketchup", has(ModItems.HOT_DOG_WITH_KETCHUP))
                .unlockedBy("has_mustard", has(ModItems.MUSTARD))
                .save(recipeOutput, "nicksmod:hot_dog_with_ketchup_and_mustard_from_just_ketchup");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.HOT_DOG_WITH_KETCHUP_AND_MUSTARD.get())
                .requires(ModItems.HOT_DOG_WITH_MUSTARD)
                .requires(ModItems.KETCHUP)
                .unlockedBy("has_hot_dog_with_mustard", has(ModItems.HOT_DOG_WITH_MUSTARD))
                .unlockedBy("has_ketchup", has(ModItems.KETCHUP))
                .save(recipeOutput, "nicksmod:hot_dog_with_ketchup_and_mustard_from_just_mustard");

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModBlocks.HOT_DOG_BLOCK.get())
                .pattern("HHH")
                .pattern("HHH")
                .pattern("HHH")
                .define('H', ModItems.HOT_DOG.get())
                .unlockedBy("has_hot_dog", has(ModItems.HOT_DOG)).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.HOT_DOG.get(), 9)
                .requires(ModBlocks.HOT_DOG_BLOCK)
                .unlockedBy("has_hot_dog_block", has(ModBlocks.HOT_DOG_BLOCK))
                .save(recipeOutput, "nicksmod:hot_dog_from_hot_dog_block");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PIZZADINO_TOKEN.get())
                .pattern("XXX")
                .pattern("XXX")
                .pattern("XXX")
                .define('X', ModBlocks.HOT_DOG_BLOCK.get())
                .unlockedBy("has_hot_dog_block", has(ModBlocks.HOT_DOG_BLOCK)).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModBlocks.HOT_DOG_BLOCK.get(), 9)
                .requires(ModItems.PIZZADINO_TOKEN)
                .unlockedBy("has_pizzadino_token", has(ModItems.PIZZADINO_TOKEN))
                .save(recipeOutput, "nicksmod:hot_dog_block_from_pizzadino_token");

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModItems.PIZZA_SLICE.get())
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

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModBlocks.PIZZA_BLOCK.get())
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

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.KETCHUP.get())
                .requires(ModItems.TOMATO)
                .unlockedBy("has_tomato", has(ModItems.TOMATO))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.TOMATO_SEEDS.get())
                .requires(ModItems.KETCHUP)
                .unlockedBy("has_ketchup", has(ModItems.KETCHUP))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.MUSTARD.get())
                .requires(ModItems.MUSTARD_SEEDS)
                .unlockedBy("has_mustard_seeds", has(ModItems.MUSTARD_SEEDS))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.MUSTARD_SEEDS.get())
                .requires(ModItems.MUSTARD)
                .unlockedBy("has_mustard", has(ModItems.MUSTARD))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.WHITE_BRICKS.get())
                .pattern("BB")
                .pattern("BB")
                .define('B', ModItems.WHITE_BRICK.get())
                .unlockedBy("has_white_brick", has(ModItems.WHITE_BRICK)).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.LIGHT_GRAY_BRICKS.get())
                .pattern("BB")
                .pattern("BB")
                .define('B', ModItems.LIGHT_GRAY_BRICK.get())
                .unlockedBy("has_light_gray_brick", has(ModItems.LIGHT_GRAY_BRICK)).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GRAY_BRICKS.get())
                .pattern("BB")
                .pattern("BB")
                .define('B', ModItems.GRAY_BRICK.get())
                .unlockedBy("has_gray_brick", has(ModItems.GRAY_BRICK)).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BLACK_BRICKS.get())
                .pattern("BB")
                .pattern("BB")
                .define('B', ModItems.BLACK_BRICK.get())
                .unlockedBy("has_black_brick", has(ModItems.BLACK_BRICK)).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BROWN_BRICKS.get())
                .pattern("BB")
                .pattern("BB")
                .define('B', ModItems.BROWN_BRICK.get())
                .unlockedBy("has_brown_brick", has(ModItems.BROWN_BRICK)).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.RED_BRICKS.get())
                .pattern("BB")
                .pattern("BB")
                .define('B', ModItems.RED_BRICK.get())
                .unlockedBy("has_red_brick", has(ModItems.RED_BRICK)).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ORANGE_BRICKS.get())
                .pattern("BB")
                .pattern("BB")
                .define('B', ModItems.ORANGE_BRICK.get())
                .unlockedBy("has_orange_brick", has(ModItems.ORANGE_BRICK)).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.YELLOW_BRICKS.get())
                .pattern("BB")
                .pattern("BB")
                .define('B', ModItems.YELLOW_BRICK.get())
                .unlockedBy("has_yellow_brick", has(ModItems.YELLOW_BRICK)).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.LIME_BRICKS.get())
                .pattern("BB")
                .pattern("BB")
                .define('B', ModItems.LIME_BRICK.get())
                .unlockedBy("has_lime_brick", has(ModItems.LIME_BRICK)).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GREEN_BRICKS.get())
                .pattern("BB")
                .pattern("BB")
                .define('B', ModItems.GREEN_BRICK.get())
                .unlockedBy("has_green_brick", has(ModItems.GREEN_BRICK)).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CYAN_BRICKS.get())
                .pattern("BB")
                .pattern("BB")
                .define('B', ModItems.CYAN_BRICK.get())
                .unlockedBy("has_cyan_brick", has(ModItems.CYAN_BRICK)).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.LIGHT_BLUE_BRICKS.get())
                .pattern("BB")
                .pattern("BB")
                .define('B', ModItems.LIGHT_BLUE_BRICK.get())
                .unlockedBy("has_light_blue_brick", has(ModItems.LIGHT_BLUE_BRICK)).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BLUE_BRICKS.get())
                .pattern("BB")
                .pattern("BB")
                .define('B', ModItems.BLUE_BRICK.get())
                .unlockedBy("has_blue_brick", has(ModItems.BLUE_BRICK)).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PURPLE_BRICKS.get())
                .pattern("BB")
                .pattern("BB")
                .define('B', ModItems.PURPLE_BRICK.get())
                .unlockedBy("has_purple_brick", has(ModItems.PURPLE_BRICK)).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MAGENTA_BRICKS.get())
                .pattern("BB")
                .pattern("BB")
                .define('B', ModItems.MAGENTA_BRICK.get())
                .unlockedBy("has_magenta_brick", has(ModItems.MAGENTA_BRICK)).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PINK_BRICKS.get())
                .pattern("BB")
                .pattern("BB")
                .define('B', ModItems.PINK_BRICK.get())
                .unlockedBy("has_pink_brick", has(ModItems.PINK_BRICK)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.WHITE_CLAY.get(), 8)
                .pattern("CCC")
                .pattern("CXC")
                .pattern("CCC")
                .define('C', Items.CLAY_BALL)
                .define('X', Items.WHITE_DYE)
                .unlockedBy("has_clay_ball", has(Items.CLAY_BALL))
                .unlockedBy("has_white_dye", has(Items.WHITE_DYE))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.LIGHT_GRAY_CLAY.get(), 8)
                .pattern("CCC")
                .pattern("CXC")
                .pattern("CCC")
                .define('C', Items.CLAY_BALL)
                .define('X', Items.LIGHT_GRAY_DYE)
                .unlockedBy("has_clay_ball", has(Items.CLAY_BALL))
                .unlockedBy("has_light_gray_dye", has(Items.LIGHT_GRAY_DYE))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.GRAY_CLAY.get(), 8)
                .pattern("CCC")
                .pattern("CXC")
                .pattern("CCC")
                .define('C', Items.CLAY_BALL)
                .define('X', Items.GRAY_DYE)
                .unlockedBy("has_clay_ball", has(Items.CLAY_BALL))
                .unlockedBy("has_gray_dye", has(Items.GRAY_DYE))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.BLACK_CLAY.get(), 8)
                .pattern("CCC")
                .pattern("CXC")
                .pattern("CCC")
                .define('C', Items.CLAY_BALL)
                .define('X', Items.BLACK_DYE)
                .unlockedBy("has_clay_ball", has(Items.CLAY_BALL))
                .unlockedBy("has_black_dye", has(Items.BLACK_DYE))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.BROWN_CLAY.get(), 8)
                .pattern("CCC")
                .pattern("CXC")
                .pattern("CCC")
                .define('C', Items.CLAY_BALL)
                .define('X', Items.BROWN_DYE)
                .unlockedBy("has_clay_ball", has(Items.CLAY_BALL))
                .unlockedBy("has_brown_dye", has(Items.BROWN_DYE))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.RED_CLAY.get(), 8)
                .pattern("CCC")
                .pattern("CXC")
                .pattern("CCC")
                .define('C', Items.CLAY_BALL)
                .define('X', Items.RED_DYE)
                .unlockedBy("has_clay_ball", has(Items.CLAY_BALL))
                .unlockedBy("has_red_dye", has(Items.RED_DYE))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ORANGE_CLAY.get(), 8)
                .pattern("CCC")
                .pattern("CXC")
                .pattern("CCC")
                .define('C', Items.CLAY_BALL)
                .define('X', Items.ORANGE_DYE)
                .unlockedBy("has_clay_ball", has(Items.CLAY_BALL))
                .unlockedBy("has_orange_dye", has(Items.ORANGE_DYE))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.YELLOW_CLAY.get(), 8)
                .pattern("CCC")
                .pattern("CXC")
                .pattern("CCC")
                .define('C', Items.CLAY_BALL)
                .define('X', Items.YELLOW_DYE)
                .unlockedBy("has_clay_ball", has(Items.CLAY_BALL))
                .unlockedBy("has_yellow_dye", has(Items.YELLOW_DYE))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.LIME_CLAY.get(), 8)
                .pattern("CCC")
                .pattern("CXC")
                .pattern("CCC")
                .define('C', Items.CLAY_BALL)
                .define('X', Items.LIME_DYE)
                .unlockedBy("has_clay_ball", has(Items.CLAY_BALL))
                .unlockedBy("has_lime_dye", has(Items.LIME_DYE))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.GREEN_CLAY.get(), 8)
                .pattern("CCC")
                .pattern("CXC")
                .pattern("CCC")
                .define('C', Items.CLAY_BALL)
                .define('X', Items.GREEN_DYE)
                .unlockedBy("has_clay_ball", has(Items.CLAY_BALL))
                .unlockedBy("has_green_dye", has(Items.GREEN_DYE))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.CYAN_CLAY.get(), 8)
                .pattern("CCC")
                .pattern("CXC")
                .pattern("CCC")
                .define('C', Items.CLAY_BALL)
                .define('X', Items.CYAN_DYE)
                .unlockedBy("has_clay_ball", has(Items.CLAY_BALL))
                .unlockedBy("has_cyan_dye", has(Items.CYAN_DYE))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.LIGHT_BLUE_CLAY.get(), 8)
                .pattern("CCC")
                .pattern("CXC")
                .pattern("CCC")
                .define('C', Items.CLAY_BALL)
                .define('X', Items.LIGHT_BLUE_DYE)
                .unlockedBy("has_clay_ball", has(Items.CLAY_BALL))
                .unlockedBy("has_light_blue_dye", has(Items.LIGHT_BLUE_DYE))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.BLUE_CLAY.get(), 8)
                .pattern("CCC")
                .pattern("CXC")
                .pattern("CCC")
                .define('C', Items.CLAY_BALL)
                .define('X', Items.BLUE_DYE)
                .unlockedBy("has_clay_ball", has(Items.CLAY_BALL))
                .unlockedBy("has_blue_dye", has(Items.BLUE_DYE))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PURPLE_CLAY.get(), 8)
                .pattern("CCC")
                .pattern("CXC")
                .pattern("CCC")
                .define('C', Items.CLAY_BALL)
                .define('X', Items.PURPLE_DYE)
                .unlockedBy("has_clay_ball", has(Items.CLAY_BALL))
                .unlockedBy("has_purple_dye", has(Items.PURPLE_DYE))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.MAGENTA_CLAY.get(), 8)
                .pattern("CCC")
                .pattern("CXC")
                .pattern("CCC")
                .define('C', Items.CLAY_BALL)
                .define('X', Items.MAGENTA_DYE)
                .unlockedBy("has_clay_ball", has(Items.CLAY_BALL))
                .unlockedBy("has_magenta_dye", has(Items.MAGENTA_DYE))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PINK_CLAY.get(), 8)
                .pattern("CCC")
                .pattern("CXC")
                .pattern("CCC")
                .define('C', Items.CLAY_BALL)
                .define('X', Items.PINK_DYE)
                .unlockedBy("has_clay_ball", has(Items.CLAY_BALL))
                .unlockedBy("has_pink_dye", has(Items.PINK_DYE))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.BISMUTH.get(), 18)
                .requires(ModBlocks.BISMUTH_BLOCK)
                .unlockedBy("has_bismuth_block", has(ModBlocks.MAGIC_BLOCK))
                .save(recipeOutput, "nicksmod:bismuth_from_magic_block");


        oreSmelting(recipeOutput, BISMUTH_SMELTABLES, RecipeCategory.MISC, ModItems.BISMUTH.get(), 0.25f, 200, "bismuth");
        oreBlasting(recipeOutput, BISMUTH_SMELTABLES, RecipeCategory.MISC, ModItems.BISMUTH.get(), 0.25f, 100, "bismuth");

        oreSmelting(recipeOutput, List.of(ModItems.WHITE_CLAY), RecipeCategory.MISC, ModItems.WHITE_BRICK.get(), 0.3f, 200, "white_clay");
        oreBlasting(recipeOutput, List.of(ModItems.WHITE_CLAY), RecipeCategory.MISC, ModItems.WHITE_BRICK.get(), 0.3f, 100, "white_clay");
        oreSmelting(recipeOutput, List.of(ModItems.LIGHT_GRAY_CLAY), RecipeCategory.MISC, ModItems.LIGHT_GRAY_BRICK.get(), 0.3f, 200, "light_gray_clay");
        oreBlasting(recipeOutput, List.of(ModItems.LIGHT_GRAY_CLAY), RecipeCategory.MISC, ModItems.LIGHT_GRAY_BRICK.get(), 0.3f, 100, "light_gray_clay");
        oreSmelting(recipeOutput, List.of(ModItems.GRAY_CLAY), RecipeCategory.MISC, ModItems.GRAY_BRICK.get(), 0.3f, 200, "gray_clay");
        oreBlasting(recipeOutput, List.of(ModItems.GRAY_CLAY), RecipeCategory.MISC, ModItems.GRAY_BRICK.get(), 0.3f, 100, "gray_clay");
        oreSmelting(recipeOutput, List.of(ModItems.BLACK_CLAY), RecipeCategory.MISC, ModItems.BLACK_BRICK.get(), 0.3f, 200, "black_clay");
        oreBlasting(recipeOutput, List.of(ModItems.BLACK_CLAY), RecipeCategory.MISC, ModItems.BLACK_BRICK.get(), 0.3f, 100, "black_clay");
        oreSmelting(recipeOutput, List.of(ModItems.BROWN_CLAY), RecipeCategory.MISC, ModItems.BROWN_BRICK.get(), 0.3f, 200, "brown_clay");
        oreBlasting(recipeOutput, List.of(ModItems.BROWN_CLAY), RecipeCategory.MISC, ModItems.BROWN_BRICK.get(), 0.3f, 100, "brown_clay");
        oreSmelting(recipeOutput, List.of(ModItems.RED_CLAY), RecipeCategory.MISC, ModItems.RED_BRICK.get(), 0.3f, 200, "red_clay");
        oreBlasting(recipeOutput, List.of(ModItems.RED_CLAY), RecipeCategory.MISC, ModItems.RED_BRICK.get(), 0.3f, 100, "red_clay");
        oreSmelting(recipeOutput, List.of(ModItems.ORANGE_CLAY), RecipeCategory.MISC, ModItems.ORANGE_BRICK.get(), 0.3f, 200, "orange_clay");
        oreBlasting(recipeOutput, List.of(ModItems.ORANGE_CLAY), RecipeCategory.MISC, ModItems.ORANGE_BRICK.get(), 0.3f, 100, "orange_clay");
        oreSmelting(recipeOutput, List.of(ModItems.YELLOW_CLAY), RecipeCategory.MISC, ModItems.YELLOW_BRICK.get(), 0.3f, 200, "yellow_clay");
        oreBlasting(recipeOutput, List.of(ModItems.YELLOW_CLAY), RecipeCategory.MISC, ModItems.YELLOW_BRICK.get(), 0.3f, 100, "yellow_clay");
        oreSmelting(recipeOutput, List.of(ModItems.LIME_CLAY), RecipeCategory.MISC, ModItems.LIME_BRICK.get(), 0.3f, 200, "lime_clay");
        oreBlasting(recipeOutput, List.of(ModItems.LIME_CLAY), RecipeCategory.MISC, ModItems.LIME_BRICK.get(), 0.3f, 100, "lime_clay");
        oreSmelting(recipeOutput, List.of(ModItems.GREEN_CLAY), RecipeCategory.MISC, ModItems.GREEN_BRICK.get(), 0.3f, 200, "green_clay");
        oreBlasting(recipeOutput, List.of(ModItems.GREEN_CLAY), RecipeCategory.MISC, ModItems.GREEN_BRICK.get(), 0.3f, 100, "green_clay");
        oreSmelting(recipeOutput, List.of(ModItems.CYAN_CLAY), RecipeCategory.MISC, ModItems.CYAN_BRICK.get(), 0.3f, 200, "cyan_clay");
        oreBlasting(recipeOutput, List.of(ModItems.CYAN_CLAY), RecipeCategory.MISC, ModItems.CYAN_BRICK.get(), 0.3f, 100, "cyan_clay");
        oreSmelting(recipeOutput, List.of(ModItems.LIGHT_BLUE_CLAY), RecipeCategory.MISC, ModItems.LIGHT_BLUE_BRICK.get(), 0.3f, 200, "light_blue_clay");
        oreBlasting(recipeOutput, List.of(ModItems.LIGHT_BLUE_CLAY), RecipeCategory.MISC, ModItems.LIGHT_BLUE_BRICK.get(), 0.3f, 100, "light_blue_clay");
        oreSmelting(recipeOutput, List.of(ModItems.BLUE_CLAY), RecipeCategory.MISC, ModItems.BLUE_BRICK.get(), 0.3f, 200, "blue_clay");
        oreBlasting(recipeOutput, List.of(ModItems.BLUE_CLAY), RecipeCategory.MISC, ModItems.BLUE_BRICK.get(), 0.3f, 100, "blue_clay");
        oreSmelting(recipeOutput, List.of(ModItems.PURPLE_CLAY), RecipeCategory.MISC, ModItems.PURPLE_BRICK.get(), 0.3f, 200, "purple_clay");
        oreBlasting(recipeOutput, List.of(ModItems.PURPLE_CLAY), RecipeCategory.MISC, ModItems.PURPLE_BRICK.get(), 0.3f, 100, "purple_clay");
        oreSmelting(recipeOutput, List.of(ModItems.MAGENTA_CLAY), RecipeCategory.MISC, ModItems.MAGENTA_BRICK.get(), 0.3f, 200, "magenta_clay");
        oreBlasting(recipeOutput, List.of(ModItems.MAGENTA_CLAY), RecipeCategory.MISC, ModItems.MAGENTA_BRICK.get(), 0.3f, 100, "magenta_clay");
        oreSmelting(recipeOutput, List.of(ModItems.PINK_CLAY), RecipeCategory.MISC, ModItems.PINK_BRICK.get(), 0.3f, 200, "pink_clay");
        oreBlasting(recipeOutput, List.of(ModItems.PINK_CLAY), RecipeCategory.MISC, ModItems.PINK_BRICK.get(), 0.3f, 100, "pink_clay");

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
