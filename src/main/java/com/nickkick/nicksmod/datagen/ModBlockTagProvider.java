package com.nickkick.nicksmod.datagen;

import com.nickkick.nicksmod.NicksMod;
import com.nickkick.nicksmod.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, NicksMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.BISMUTH_BLOCK.get())
                .add(ModBlocks.BISMUTH_ORE.get())
                .add(ModBlocks.BISMUTH_DEEPSLATE_ORE.get())
                .add(ModBlocks.MAGIC_BLOCK.get())
                .add(ModBlocks.WHITE_BRICKS.get())
                .add(ModBlocks.LIGHT_GRAY_BRICKS.get())
                .add(ModBlocks.GRAY_BRICKS.get())
                .add(ModBlocks.BLACK_BRICKS.get())
                .add(ModBlocks.BROWN_BRICKS.get())
                .add(ModBlocks.RED_BRICKS.get())
                .add(ModBlocks.ORANGE_BRICKS.get())
                .add(ModBlocks.YELLOW_BRICKS.get())
                .add(ModBlocks.LIME_BRICKS.get())
                .add(ModBlocks.GREEN_BRICKS.get())
                .add(ModBlocks.CYAN_BRICKS.get())
                .add(ModBlocks.LIGHT_BLUE_BRICKS.get())
                .add(ModBlocks.BLUE_BRICKS.get())
                .add(ModBlocks.PURPLE_BRICKS.get())
                .add(ModBlocks.MAGENTA_BRICKS.get())
                .add(ModBlocks.PINK_BRICKS.get());

        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.BISMUTH_DEEPSLATE_ORE.get());

        tag(BlockTags.FENCES)
                .add(ModBlocks.HOT_DOG_FENCE.get());
        tag(BlockTags.FENCE_GATES)
                .add(ModBlocks.HOT_DOG_FENCE_GATE.get());
        tag(BlockTags.WALLS)
                .add(ModBlocks.HOT_DOG_WALL.get());
    }
}
