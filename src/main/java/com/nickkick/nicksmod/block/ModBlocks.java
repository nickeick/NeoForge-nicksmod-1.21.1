package com.nickkick.nicksmod.block;

import com.nickkick.nicksmod.NicksMod;
import com.nickkick.nicksmod.block.custom.HotDogLampBlock;
import com.nickkick.nicksmod.block.custom.MagicBlock;
import com.nickkick.nicksmod.block.custom.MustardCropBlock;
import com.nickkick.nicksmod.block.custom.TomatoCropBlock;
import com.nickkick.nicksmod.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(NicksMod.MOD_ID);

    public static final DeferredBlock<Block> BISMUTH_BLOCK = registerBlock("bismuth_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));

    public static final DeferredBlock<Block> BISMUTH_ORE = registerBlock("bismuth_ore",
            () -> new DropExperienceBlock(UniformInt.of(2, 4),
                    BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));

    public static final DeferredBlock<Block> ZIRCON_ORE = registerBlock("zircon_ore",
            () -> new DropExperienceBlock(UniformInt.of(2, 4),
                    BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));

    public static final DeferredBlock<Block> SKILL_TREE_BLOCK = registerBlock("skill_tree_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.WOOD)));

    public static final DeferredBlock<Block> BISMUTH_DEEPSLATE_ORE = registerBlock("bismuth_deepslate_ore",
            () -> new DropExperienceBlock(UniformInt.of(3, 4),
                    BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)));

    public static final DeferredBlock<Block> MAGIC_BLOCK = registerBlock("magic_block",
            () -> new MagicBlock(BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> HOT_DOG_BLOCK = registerBlock("hot_dog_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(2f).sound(SoundType.WOOL)));

    public static final DeferredBlock<StairBlock> HOT_DOG_STAIRS = registerBlock("hot_dog_stairs",
            () -> new StairBlock(ModBlocks.HOT_DOG_BLOCK.get().defaultBlockState(),
                    BlockBehaviour.Properties.of().strength(2f)));

    public static final DeferredBlock<SlabBlock> HOT_DOG_SLAB = registerBlock("hot_dog_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().strength(2f)));

    public static final DeferredBlock<PressurePlateBlock> HOT_DOG_PRESSURE_PLATE = registerBlock("hot_dog_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.OAK, BlockBehaviour.Properties.of().strength(2f)));

    public static final DeferredBlock<ButtonBlock> HOT_DOG_BUTTON = registerBlock("hot_dog_button",
            () -> new ButtonBlock(BlockSetType.OAK, 20,
                    BlockBehaviour.Properties.of().strength(2f).noCollission()));

    public static final DeferredBlock<FenceBlock> HOT_DOG_FENCE = registerBlock("hot_dog_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.of().strength(2f)));

    public static final DeferredBlock<FenceGateBlock> HOT_DOG_FENCE_GATE = registerBlock("hot_dog_fence_gate",
            () -> new FenceGateBlock(WoodType.OAK, BlockBehaviour.Properties.of().strength(2f)));

    public static final DeferredBlock<WallBlock> HOT_DOG_WALL = registerBlock("hot_dog_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().strength(2f)));

    public static final DeferredBlock<DoorBlock> HOT_DOG_DOOR = registerBlock("hot_dog_door",
            () -> new DoorBlock(BlockSetType.IRON, BlockBehaviour.Properties.of().strength(2f).noOcclusion()));

    public static final DeferredBlock<TrapDoorBlock> HOT_DOG_TRAPDOOR = registerBlock("hot_dog_trapdoor",
            () -> new TrapDoorBlock(BlockSetType.IRON, BlockBehaviour.Properties.of().strength(2f).noOcclusion()));

    public static final DeferredBlock<Block> PIZZA_BLOCK = registerBlock("pizza_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(2f).sound(SoundType.WOOL)));

    public static final DeferredBlock<Block> HOT_DOG_LAMP = registerBlock("hot_dog_lamp",
            () -> new HotDogLampBlock(BlockBehaviour.Properties.of().strength(2f)
                    .lightLevel(state -> state.getValue(HotDogLampBlock.CLICKED) ? 15 : 0)));

    public static final DeferredBlock<Block> TOMATO_CROP = registerBlock("tomato_crop",
            () -> new TomatoCropBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BEETROOTS)));

    public static final DeferredBlock<Block> MUSTARD_CROP = registerBlock("mustard_crop",
            () -> new MustardCropBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.POTATOES)));

    public static final DeferredBlock<Block> WHITE_BRICKS = registerBlock("white_bricks",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.WOOL).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(2.0F, 6.0F)));
    public static final DeferredBlock<Block> LIGHT_GRAY_BRICKS = registerBlock("light_gray_bricks",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GRAY).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(2.0F, 6.0F)));
    public static final DeferredBlock<Block> GRAY_BRICKS = registerBlock("gray_bricks",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GRAY).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(2.0F, 6.0F)));
    public static final DeferredBlock<Block> BLACK_BRICKS = registerBlock("black_bricks",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(2.0F, 6.0F)));
    public static final DeferredBlock<Block> BROWN_BRICKS = registerBlock("brown_bricks",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(2.0F, 6.0F)));
    public static final DeferredBlock<Block> RED_BRICKS = registerBlock("red_bricks",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(2.0F, 6.0F)));
    public static final DeferredBlock<Block> ORANGE_BRICKS = registerBlock("orange_bricks",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(2.0F, 6.0F)));
    public static final DeferredBlock<Block> YELLOW_BRICKS = registerBlock("yellow_bricks",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(2.0F, 6.0F)));
    public static final DeferredBlock<Block> LIME_BRICKS = registerBlock("lime_bricks",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GREEN).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(2.0F, 6.0F)));
    public static final DeferredBlock<Block> GREEN_BRICKS = registerBlock("green_bricks",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GREEN).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(2.0F, 6.0F)));
    public static final DeferredBlock<Block> CYAN_BRICKS = registerBlock("cyan_bricks",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_CYAN).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(2.0F, 6.0F)));
    public static final DeferredBlock<Block> LIGHT_BLUE_BRICKS = registerBlock("light_blue_bricks",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_BLUE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(2.0F, 6.0F)));
    public static final DeferredBlock<Block> BLUE_BRICKS = registerBlock("blue_bricks",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLUE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(2.0F, 6.0F)));
    public static final DeferredBlock<Block> PURPLE_BRICKS = registerBlock("purple_bricks",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PURPLE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(2.0F, 6.0F)));
    public static final DeferredBlock<Block> MAGENTA_BRICKS = registerBlock("magenta_bricks",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_MAGENTA).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(2.0F, 6.0F)));
    public static final DeferredBlock<Block> PINK_BRICKS = registerBlock("pink_bricks",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PINK).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(2.0F, 6.0F)));

    public static final DeferredBlock<SlabBlock> WHITE_BRICKS_SLAB = registerBlock("white_bricks_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOL).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(2.0F, 6.0F)));
    public static final DeferredBlock<SlabBlock> LIGHT_GRAY_BRICKS_SLAB = registerBlock("light_gray_bricks_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GRAY).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(2.0F, 6.0F)));
    public static final DeferredBlock<SlabBlock> GRAY_BRICKS_SLAB = registerBlock("gray_bricks_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GRAY).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(2.0F, 6.0F)));
    public static final DeferredBlock<SlabBlock> BLACK_BRICKS_SLAB = registerBlock("black_bricks_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(2.0F, 6.0F)));
    public static final DeferredBlock<SlabBlock> BROWN_BRICKS_SLAB = registerBlock("brown_bricks_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(2.0F, 6.0F)));
    public static final DeferredBlock<SlabBlock> RED_BRICKS_SLAB = registerBlock("red_bricks_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(2.0F, 6.0F)));
    public static final DeferredBlock<SlabBlock> ORANGE_BRICKS_SLAB = registerBlock("orange_bricks_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(2.0F, 6.0F)));
    public static final DeferredBlock<SlabBlock> YELLOW_BRICKS_SLAB = registerBlock("yellow_bricks_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(2.0F, 6.0F)));
    public static final DeferredBlock<SlabBlock> LIME_BRICKS_SLAB = registerBlock("lime_bricks_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GREEN).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(2.0F, 6.0F)));
    public static final DeferredBlock<SlabBlock> GREEN_BRICKS_SLAB = registerBlock("green_bricks_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GREEN).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(2.0F, 6.0F)));
    public static final DeferredBlock<SlabBlock> CYAN_BRICKS_SLAB = registerBlock("cyan_bricks_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_CYAN).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(2.0F, 6.0F)));
    public static final DeferredBlock<SlabBlock> LIGHT_BLUE_BRICKS_SLAB = registerBlock("light_blue_bricks_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_BLUE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(2.0F, 6.0F)));
    public static final DeferredBlock<SlabBlock> BLUE_BRICKS_SLAB = registerBlock("blue_bricks_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLUE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(2.0F, 6.0F)));
    public static final DeferredBlock<SlabBlock> PURPLE_BRICKS_SLAB = registerBlock("purple_bricks_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PURPLE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(2.0F, 6.0F)));
    public static final DeferredBlock<SlabBlock> MAGENTA_BRICKS_SLAB = registerBlock("magenta_bricks_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_MAGENTA).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(2.0F, 6.0F)));
    public static final DeferredBlock<SlabBlock> PINK_BRICKS_SLAB = registerBlock("pink_bricks_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PINK).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(2.0F, 6.0F)));

    public static final DeferredBlock<StairBlock> WHITE_BRICKS_STAIRS = registerBlock("white_bricks_stairs",
            () -> new StairBlock(ModBlocks.WHITE_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.of().mapColor(MapColor.WOOL).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(2.0F, 6.0F)));
    public static final DeferredBlock<StairBlock> LIGHT_GRAY_BRICKS_STAIRS = registerBlock("light_gray_bricks_stairs",
            () -> new StairBlock(ModBlocks.LIGHT_GRAY_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GRAY).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(2.0F, 6.0F)));
    public static final DeferredBlock<StairBlock> GRAY_BRICKS_STAIRS = registerBlock("gray_bricks_stairs",
            () -> new StairBlock(ModBlocks.GRAY_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GRAY).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(2.0F, 6.0F)));
    public static final DeferredBlock<StairBlock> BLACK_BRICKS_STAIRS = registerBlock("black_bricks_stairs",
            () -> new StairBlock(ModBlocks.BLACK_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(2.0F, 6.0F)));
    public static final DeferredBlock<StairBlock> BROWN_BRICKS_STAIRS = registerBlock("brown_bricks_stairs",
            () -> new StairBlock(ModBlocks.BROWN_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(2.0F, 6.0F)));
    public static final DeferredBlock<StairBlock> RED_BRICKS_STAIRS = registerBlock("red_bricks_stairs",
            () -> new StairBlock(ModBlocks.RED_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(2.0F, 6.0F)));
    public static final DeferredBlock<StairBlock> ORANGE_BRICKS_STAIRS = registerBlock("orange_bricks_stairs",
            () -> new StairBlock(ModBlocks.ORANGE_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(2.0F, 6.0F)));
    public static final DeferredBlock<StairBlock> YELLOW_BRICKS_STAIRS = registerBlock("yellow_bricks_stairs",
            () -> new StairBlock(ModBlocks.YELLOW_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(2.0F, 6.0F)));
    public static final DeferredBlock<StairBlock> LIME_BRICKS_STAIRS = registerBlock("lime_bricks_stairs",
            () -> new StairBlock(ModBlocks.LIME_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GREEN).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(2.0F, 6.0F)));
    public static final DeferredBlock<StairBlock> GREEN_BRICKS_STAIRS = registerBlock("green_bricks_stairs",
            () -> new StairBlock(ModBlocks.GREEN_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GREEN).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(2.0F, 6.0F)));
    public static final DeferredBlock<StairBlock> CYAN_BRICKS_STAIRS = registerBlock("cyan_bricks_stairs",
            () -> new StairBlock(ModBlocks.CYAN_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_CYAN).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(2.0F, 6.0F)));
    public static final DeferredBlock<StairBlock> LIGHT_BLUE_BRICKS_STAIRS = registerBlock("light_blue_bricks_stairs",
            () -> new StairBlock(ModBlocks.LIGHT_BLUE_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_BLUE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(2.0F, 6.0F)));
    public static final DeferredBlock<StairBlock> BLUE_BRICKS_STAIRS = registerBlock("blue_bricks_stairs",
            () -> new StairBlock(ModBlocks.BLUE_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLUE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(2.0F, 6.0F)));
    public static final DeferredBlock<StairBlock> PURPLE_BRICKS_STAIRS = registerBlock("purple_bricks_stairs",
            () -> new StairBlock(ModBlocks.PURPLE_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PURPLE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(2.0F, 6.0F)));
    public static final DeferredBlock<StairBlock> MAGENTA_BRICKS_STAIRS = registerBlock("magenta_bricks_stairs",
            () -> new StairBlock(ModBlocks.MAGENTA_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_MAGENTA).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(2.0F, 6.0F)));
    public static final DeferredBlock<StairBlock> PINK_BRICKS_STAIRS = registerBlock("pink_bricks_stairs",
            () -> new StairBlock(ModBlocks.PINK_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PINK).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(2.0F, 6.0F)));

    public static final DeferredBlock<WallBlock> WHITE_BRICKS_WALL = registerBlock("white_bricks_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOL).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(2.0F, 6.0F)));
    public static final DeferredBlock<WallBlock> LIGHT_GRAY_BRICKS_WALL = registerBlock("light_gray_bricks_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GRAY).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(2.0F, 6.0F)));
    public static final DeferredBlock<WallBlock> GRAY_BRICKS_WALL = registerBlock("gray_bricks_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GRAY).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(2.0F, 6.0F)));
    public static final DeferredBlock<WallBlock> BLACK_BRICKS_WALL = registerBlock("black_bricks_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(2.0F, 6.0F)));
    public static final DeferredBlock<WallBlock> BROWN_BRICKS_WALL = registerBlock("brown_bricks_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(2.0F, 6.0F)));
    public static final DeferredBlock<WallBlock> RED_BRICKS_WALL = registerBlock("red_bricks_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(2.0F, 6.0F)));
    public static final DeferredBlock<WallBlock> ORANGE_BRICKS_WALL = registerBlock("orange_bricks_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(2.0F, 6.0F)));
    public static final DeferredBlock<WallBlock> YELLOW_BRICKS_WALL = registerBlock("yellow_bricks_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(2.0F, 6.0F)));
    public static final DeferredBlock<WallBlock> LIME_BRICKS_WALL = registerBlock("lime_bricks_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GREEN).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(2.0F, 6.0F)));
    public static final DeferredBlock<WallBlock> GREEN_BRICKS_WALL = registerBlock("green_bricks_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GREEN).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(2.0F, 6.0F)));
    public static final DeferredBlock<WallBlock> CYAN_BRICKS_WALL = registerBlock("cyan_bricks_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_CYAN).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(2.0F, 6.0F)));
    public static final DeferredBlock<WallBlock> LIGHT_BLUE_BRICKS_WALL = registerBlock("light_blue_bricks_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_BLUE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(2.0F, 6.0F)));
    public static final DeferredBlock<WallBlock> BLUE_BRICKS_WALL = registerBlock("blue_bricks_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLUE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(2.0F, 6.0F)));
    public static final DeferredBlock<WallBlock> PURPLE_BRICKS_WALL = registerBlock("purple_bricks_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PURPLE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(2.0F, 6.0F)));
    public static final DeferredBlock<WallBlock> MAGENTA_BRICKS_WALL = registerBlock("magenta_bricks_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_MAGENTA).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(2.0F, 6.0F)));
    public static final DeferredBlock<WallBlock> PINK_BRICKS_WALL = registerBlock("pink_bricks_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PINK).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(2.0F, 6.0F)));

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
