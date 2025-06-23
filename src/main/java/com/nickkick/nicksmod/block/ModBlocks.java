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
import net.minecraft.world.level.block.state.properties.WoodType;
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
