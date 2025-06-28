package com.nickkick.nicksmod.datagen;

import com.nickkick.nicksmod.NicksMod;
import com.nickkick.nicksmod.block.ModBlocks;
import com.nickkick.nicksmod.block.custom.HotDogLampBlock;
import com.nickkick.nicksmod.block.custom.MustardCropBlock;
import com.nickkick.nicksmod.block.custom.TomatoCropBlock;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

import java.util.function.Function;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, NicksMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.BISMUTH_BLOCK);
        blockWithItem(ModBlocks.BISMUTH_ORE);
        blockWithItem(ModBlocks.BISMUTH_DEEPSLATE_ORE);
        blockWithItem(ModBlocks.MAGIC_BLOCK);

        blockWithItem(ModBlocks.ZIRCON_ORE);
        blockWithItem(ModBlocks.SKILL_TREE_BLOCK);

        blockWithItem(ModBlocks.PIZZA_BLOCK);

        blockWithItem(ModBlocks.HOT_DOG_BLOCK);
        stairsBlock(ModBlocks.HOT_DOG_STAIRS.get(), blockTexture(ModBlocks.HOT_DOG_BLOCK.get()));
        slabBlock(ModBlocks.HOT_DOG_SLAB.get(), blockTexture(ModBlocks.HOT_DOG_BLOCK.get()), blockTexture(ModBlocks.HOT_DOG_BLOCK.get()));
        buttonBlock(ModBlocks.HOT_DOG_BUTTON.get(), blockTexture(ModBlocks.HOT_DOG_BLOCK.get()));
        pressurePlateBlock(ModBlocks.HOT_DOG_PRESSURE_PLATE.get(), blockTexture(ModBlocks.HOT_DOG_BLOCK.get()));
        fenceBlock(ModBlocks.HOT_DOG_FENCE.get(), blockTexture(ModBlocks.HOT_DOG_BLOCK.get()));
        fenceGateBlock(ModBlocks.HOT_DOG_FENCE_GATE.get(), blockTexture(ModBlocks.HOT_DOG_BLOCK.get()));
        wallBlock(ModBlocks.HOT_DOG_WALL.get(), blockTexture(ModBlocks.HOT_DOG_BLOCK.get()));

        doorBlockWithRenderType(ModBlocks.HOT_DOG_DOOR.get(), modLoc("block/hot_dog_door_bottom"), modLoc("block/hot_dog_door_top"), "cutout");
        trapdoorBlockWithRenderType(ModBlocks.HOT_DOG_TRAPDOOR.get(), modLoc("block/hot_dog_trapdoor"), true, "cutout");

        blockItem(ModBlocks.HOT_DOG_STAIRS);
        blockItem(ModBlocks.HOT_DOG_SLAB);
        blockItem(ModBlocks.HOT_DOG_PRESSURE_PLATE);
        blockItem(ModBlocks.HOT_DOG_FENCE_GATE);
        blockItem(ModBlocks.HOT_DOG_TRAPDOOR, "_button");

        customLamp();

        makeCrop((CropBlock) ModBlocks.TOMATO_CROP.get(), "tomato_crop_stage", "tomato_crop_stage");
        makeCrop((CropBlock) ModBlocks.MUSTARD_CROP.get(), "mustard_crop_stage", "mustard_crop_stage");

        blockWithItem(ModBlocks.WHITE_BRICKS);
        blockWithItem(ModBlocks.LIGHT_GRAY_BRICKS);
        blockWithItem(ModBlocks.GRAY_BRICKS);
        blockWithItem(ModBlocks.BLACK_BRICKS);
        blockWithItem(ModBlocks.BROWN_BRICKS);
        blockWithItem(ModBlocks.RED_BRICKS);
        blockWithItem(ModBlocks.ORANGE_BRICKS);
        blockWithItem(ModBlocks.YELLOW_BRICKS);
        blockWithItem(ModBlocks.LIME_BRICKS);
        blockWithItem(ModBlocks.GREEN_BRICKS);
        blockWithItem(ModBlocks.CYAN_BRICKS);
        blockWithItem(ModBlocks.LIGHT_BLUE_BRICKS);
        blockWithItem(ModBlocks.BLUE_BRICKS);
        blockWithItem(ModBlocks.PURPLE_BRICKS);
        blockWithItem(ModBlocks.MAGENTA_BRICKS);
        blockWithItem(ModBlocks.PINK_BRICKS);

        slabBlock(ModBlocks.WHITE_BRICKS_SLAB.get(), blockTexture(ModBlocks.WHITE_BRICKS.get()), blockTexture(ModBlocks.WHITE_BRICKS.get()));
        slabBlock(ModBlocks.LIGHT_GRAY_BRICKS_SLAB.get(), blockTexture(ModBlocks.LIGHT_GRAY_BRICKS.get()), blockTexture(ModBlocks.LIGHT_GRAY_BRICKS.get()));
        slabBlock(ModBlocks.GRAY_BRICKS_SLAB.get(), blockTexture(ModBlocks.GRAY_BRICKS.get()), blockTexture(ModBlocks.GRAY_BRICKS.get()));
        slabBlock(ModBlocks.BLACK_BRICKS_SLAB.get(), blockTexture(ModBlocks.BLACK_BRICKS.get()), blockTexture(ModBlocks.BLACK_BRICKS.get()));
        slabBlock(ModBlocks.BROWN_BRICKS_SLAB.get(), blockTexture(ModBlocks.BROWN_BRICKS.get()), blockTexture(ModBlocks.BROWN_BRICKS.get()));
        slabBlock(ModBlocks.RED_BRICKS_SLAB.get(), blockTexture(ModBlocks.RED_BRICKS.get()), blockTexture(ModBlocks.RED_BRICKS.get()));
        slabBlock(ModBlocks.ORANGE_BRICKS_SLAB.get(), blockTexture(ModBlocks.ORANGE_BRICKS.get()), blockTexture(ModBlocks.ORANGE_BRICKS.get()));
        slabBlock(ModBlocks.YELLOW_BRICKS_SLAB.get(), blockTexture(ModBlocks.YELLOW_BRICKS.get()), blockTexture(ModBlocks.YELLOW_BRICKS.get()));
        slabBlock(ModBlocks.LIME_BRICKS_SLAB.get(), blockTexture(ModBlocks.LIME_BRICKS.get()), blockTexture(ModBlocks.LIME_BRICKS.get()));
        slabBlock(ModBlocks.GREEN_BRICKS_SLAB.get(), blockTexture(ModBlocks.GREEN_BRICKS.get()), blockTexture(ModBlocks.GREEN_BRICKS.get()));
        slabBlock(ModBlocks.CYAN_BRICKS_SLAB.get(), blockTexture(ModBlocks.CYAN_BRICKS.get()), blockTexture(ModBlocks.CYAN_BRICKS.get()));
        slabBlock(ModBlocks.LIGHT_BLUE_BRICKS_SLAB.get(), blockTexture(ModBlocks.LIGHT_BLUE_BRICKS.get()), blockTexture(ModBlocks.LIGHT_BLUE_BRICKS.get()));
        slabBlock(ModBlocks.BLUE_BRICKS_SLAB.get(), blockTexture(ModBlocks.BLUE_BRICKS.get()), blockTexture(ModBlocks.BLUE_BRICKS.get()));
        slabBlock(ModBlocks.PURPLE_BRICKS_SLAB.get(), blockTexture(ModBlocks.PURPLE_BRICKS.get()), blockTexture(ModBlocks.PURPLE_BRICKS.get()));
        slabBlock(ModBlocks.MAGENTA_BRICKS_SLAB.get(), blockTexture(ModBlocks.MAGENTA_BRICKS.get()), blockTexture(ModBlocks.MAGENTA_BRICKS.get()));
        slabBlock(ModBlocks.PINK_BRICKS_SLAB.get(), blockTexture(ModBlocks.PINK_BRICKS.get()), blockTexture(ModBlocks.PINK_BRICKS.get()));
        blockItem(ModBlocks.WHITE_BRICKS_SLAB);
        blockItem(ModBlocks.LIGHT_GRAY_BRICKS_SLAB);
        blockItem(ModBlocks.GRAY_BRICKS_SLAB);
        blockItem(ModBlocks.BLACK_BRICKS_SLAB);
        blockItem(ModBlocks.BROWN_BRICKS_SLAB);
        blockItem(ModBlocks.RED_BRICKS_SLAB);
        blockItem(ModBlocks.ORANGE_BRICKS_SLAB);
        blockItem(ModBlocks.YELLOW_BRICKS_SLAB);
        blockItem(ModBlocks.LIME_BRICKS_SLAB);
        blockItem(ModBlocks.GREEN_BRICKS_SLAB);
        blockItem(ModBlocks.CYAN_BRICKS_SLAB);
        blockItem(ModBlocks.LIGHT_BLUE_BRICKS_SLAB);
        blockItem(ModBlocks.BLUE_BRICKS_SLAB);
        blockItem(ModBlocks.PURPLE_BRICKS_SLAB);
        blockItem(ModBlocks.MAGENTA_BRICKS_SLAB);
        blockItem(ModBlocks.PINK_BRICKS_SLAB);

        stairsBlock(ModBlocks.WHITE_BRICKS_STAIRS.get(), blockTexture(ModBlocks.WHITE_BRICKS.get()));
        stairsBlock(ModBlocks.LIGHT_GRAY_BRICKS_STAIRS.get(), blockTexture(ModBlocks.LIGHT_GRAY_BRICKS.get()));
        stairsBlock(ModBlocks.GRAY_BRICKS_STAIRS.get(), blockTexture(ModBlocks.GRAY_BRICKS.get()));
        stairsBlock(ModBlocks.BLACK_BRICKS_STAIRS.get(), blockTexture(ModBlocks.BLACK_BRICKS.get()));
        stairsBlock(ModBlocks.BROWN_BRICKS_STAIRS.get(), blockTexture(ModBlocks.BROWN_BRICKS.get()));
        stairsBlock(ModBlocks.RED_BRICKS_STAIRS.get(), blockTexture(ModBlocks.RED_BRICKS.get()));
        stairsBlock(ModBlocks.ORANGE_BRICKS_STAIRS.get(), blockTexture(ModBlocks.ORANGE_BRICKS.get()));
        stairsBlock(ModBlocks.YELLOW_BRICKS_STAIRS.get(), blockTexture(ModBlocks.YELLOW_BRICKS.get()));
        stairsBlock(ModBlocks.LIME_BRICKS_STAIRS.get(), blockTexture(ModBlocks.LIME_BRICKS.get()));
        stairsBlock(ModBlocks.GREEN_BRICKS_STAIRS.get(), blockTexture(ModBlocks.GREEN_BRICKS.get()));
        stairsBlock(ModBlocks.CYAN_BRICKS_STAIRS.get(), blockTexture(ModBlocks.CYAN_BRICKS.get()));
        stairsBlock(ModBlocks.LIGHT_BLUE_BRICKS_STAIRS.get(), blockTexture(ModBlocks.LIGHT_BLUE_BRICKS.get()));
        stairsBlock(ModBlocks.BLUE_BRICKS_STAIRS.get(), blockTexture(ModBlocks.BLUE_BRICKS.get()));
        stairsBlock(ModBlocks.PURPLE_BRICKS_STAIRS.get(), blockTexture(ModBlocks.PURPLE_BRICKS.get()));
        stairsBlock(ModBlocks.MAGENTA_BRICKS_STAIRS.get(), blockTexture(ModBlocks.MAGENTA_BRICKS.get()));
        stairsBlock(ModBlocks.PINK_BRICKS_STAIRS.get(), blockTexture(ModBlocks.PINK_BRICKS.get()));
        blockItem(ModBlocks.WHITE_BRICKS_STAIRS);
        blockItem(ModBlocks.LIGHT_GRAY_BRICKS_STAIRS);
        blockItem(ModBlocks.GRAY_BRICKS_STAIRS);
        blockItem(ModBlocks.BLACK_BRICKS_STAIRS);
        blockItem(ModBlocks.BROWN_BRICKS_STAIRS);
        blockItem(ModBlocks.RED_BRICKS_STAIRS);
        blockItem(ModBlocks.ORANGE_BRICKS_STAIRS);
        blockItem(ModBlocks.YELLOW_BRICKS_STAIRS);
        blockItem(ModBlocks.LIME_BRICKS_STAIRS);
        blockItem(ModBlocks.GREEN_BRICKS_STAIRS);
        blockItem(ModBlocks.CYAN_BRICKS_STAIRS);
        blockItem(ModBlocks.LIGHT_BLUE_BRICKS_STAIRS);
        blockItem(ModBlocks.BLUE_BRICKS_STAIRS);
        blockItem(ModBlocks.PURPLE_BRICKS_STAIRS);
        blockItem(ModBlocks.MAGENTA_BRICKS_STAIRS);
        blockItem(ModBlocks.PINK_BRICKS_STAIRS);

        wallBlock(ModBlocks.WHITE_BRICKS_WALL.get(), blockTexture(ModBlocks.WHITE_BRICKS.get()));
        wallBlock(ModBlocks.LIGHT_GRAY_BRICKS_WALL.get(), blockTexture(ModBlocks.LIGHT_GRAY_BRICKS.get()));
        wallBlock(ModBlocks.GRAY_BRICKS_WALL.get(), blockTexture(ModBlocks.GRAY_BRICKS.get()));
        wallBlock(ModBlocks.BLACK_BRICKS_WALL.get(), blockTexture(ModBlocks.BLACK_BRICKS.get()));
        wallBlock(ModBlocks.BROWN_BRICKS_WALL.get(), blockTexture(ModBlocks.BROWN_BRICKS.get()));
        wallBlock(ModBlocks.RED_BRICKS_WALL.get(), blockTexture(ModBlocks.RED_BRICKS.get()));
        wallBlock(ModBlocks.ORANGE_BRICKS_WALL.get(), blockTexture(ModBlocks.ORANGE_BRICKS.get()));
        wallBlock(ModBlocks.YELLOW_BRICKS_WALL.get(), blockTexture(ModBlocks.YELLOW_BRICKS.get()));
        wallBlock(ModBlocks.LIME_BRICKS_WALL.get(), blockTexture(ModBlocks.LIME_BRICKS.get()));
        wallBlock(ModBlocks.GREEN_BRICKS_WALL.get(), blockTexture(ModBlocks.GREEN_BRICKS.get()));
        wallBlock(ModBlocks.CYAN_BRICKS_WALL.get(), blockTexture(ModBlocks.CYAN_BRICKS.get()));
        wallBlock(ModBlocks.LIGHT_BLUE_BRICKS_WALL.get(), blockTexture(ModBlocks.LIGHT_BLUE_BRICKS.get()));
        wallBlock(ModBlocks.BLUE_BRICKS_WALL.get(), blockTexture(ModBlocks.BLUE_BRICKS.get()));
        wallBlock(ModBlocks.PURPLE_BRICKS_WALL.get(), blockTexture(ModBlocks.PURPLE_BRICKS.get()));
        wallBlock(ModBlocks.MAGENTA_BRICKS_WALL.get(), blockTexture(ModBlocks.MAGENTA_BRICKS.get()));
        wallBlock(ModBlocks.PINK_BRICKS_WALL.get(), blockTexture(ModBlocks.PINK_BRICKS.get()));
    }

    public void makeCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> states(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] states(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        int stateValue = 0;

        if(block instanceof TomatoCropBlock) {
            stateValue = getTomatoAge(state, block);
        }
        if(block instanceof MustardCropBlock) {
            stateValue = getMustardAge(state, block);
        }

        models[0] = new ConfiguredModel(models().crop(modelName + stateValue,
                ResourceLocation.fromNamespaceAndPath(NicksMod.MOD_ID, "block/" + textureName + stateValue)).renderType("cutout"));

        return models;
    }

    private Integer getTomatoAge(BlockState state, CropBlock block) {
        return state.getValue(((TomatoCropBlock) block).getAgeProperty());
    }

    private Integer getMustardAge(BlockState state, CropBlock block) {
        return state.getValue(((MustardCropBlock) block).getAgeProperty());
    }

    private void customLamp() {
        getVariantBuilder(ModBlocks.HOT_DOG_LAMP.get()).forAllStates(state -> {
            if(state.getValue(HotDogLampBlock.CLICKED)) {
                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll("hot_dog_lamp_on",
                        ResourceLocation.fromNamespaceAndPath(NicksMod.MOD_ID, "block/" + "hot_dog_lamp_on")))};
            } else {
                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll("hot_dog_lamp_off",
                        ResourceLocation.fromNamespaceAndPath(NicksMod.MOD_ID, "block/" + "hot_dog_lamp_off")))};
            }
        });

        simpleBlockItem(ModBlocks.HOT_DOG_LAMP.get(), models().cubeAll("hot_dog_lamp_on",
                ResourceLocation.fromNamespaceAndPath(NicksMod.MOD_ID, "block/" + "hot_dog_lamp_on")));
    }

    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("nicksmod:block/" + deferredBlock.getId().getPath()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock, String appendix) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("nicksmod:block/" + deferredBlock.getId().getPath() + appendix));
    }
}
