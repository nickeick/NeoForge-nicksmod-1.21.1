package com.nickkick.nicksmod.datagen;

import com.nickkick.nicksmod.NicksMod;
import com.nickkick.nicksmod.block.ModBlocks;
import com.nickkick.nicksmod.block.custom.HotDogLampBlock;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

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
