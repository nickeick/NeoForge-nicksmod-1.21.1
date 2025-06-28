package com.nickkick.nicksmod.item;

import com.nickkick.nicksmod.NicksMod;
import com.nickkick.nicksmod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;
import java.util.stream.Stream;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, NicksMod.MOD_ID);

    public static final Supplier<CreativeModeTab> BISMUTH_ITEMS_TAB = CREATIVE_MODE_TAB.register("bismuth_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.BISMUTH.get()))
                    .title(Component.translatable("creativetab.nicksmod.bismuth_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.BISMUTH);
                        output.accept(ModItems.RAW_BISMUTH);
                        output.accept(ModItems.CHISEL);
                        output.accept(ModItems.ZIRCON);
                        output.accept(ModItems.SKILL_STAFF);
                    })
                    .build());

    public static final Supplier<CreativeModeTab> BISMUTH_BLOCKS_TAB = CREATIVE_MODE_TAB.register("bismuth_blocks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.BISMUTH_BLOCK))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(NicksMod.MOD_ID, "bismuth_items_tab"))
                    .title(Component.translatable("creativetab.nicksmod.bismuth_blocks"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.BISMUTH_BLOCK);
                        output.accept(ModBlocks.BISMUTH_ORE);
                        output.accept(ModBlocks.BISMUTH_DEEPSLATE_ORE);
                        output.accept(ModBlocks.MAGIC_BLOCK);
                        output.accept(ModBlocks.ZIRCON_ORE);
                        output.accept(ModBlocks.SKILL_TREE_BLOCK);
                    })
                    .build());

    public static final Supplier<CreativeModeTab> HOT_DOG_ITEMS = CREATIVE_MODE_TAB.register("hot_dogs_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.HOT_DOG.get()))
                    .title(Component.translatable("creativetab.nicksmod.hot_dog_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.HOT_DOG);
                        output.accept(ModItems.HOT_DOG_WITH_KETCHUP);
                        output.accept(ModItems.HOT_DOG_WITH_MUSTARD);
                        output.accept(ModItems.HOT_DOG_WITH_KETCHUP_AND_MUSTARD);

                        output.accept(ModItems.PIZZADINO_TOKEN);
                        output.accept(ModItems.PIZZA_SLICE);
                        output.accept(ModBlocks.PIZZA_BLOCK);

                        output.accept(ModBlocks.HOT_DOG_BLOCK);

                        output.accept(ModBlocks.HOT_DOG_STAIRS);
                        output.accept(ModBlocks.HOT_DOG_SLAB);

                        output.accept(ModBlocks.HOT_DOG_PRESSURE_PLATE);
                        output.accept(ModBlocks.HOT_DOG_BUTTON);

                        output.accept(ModBlocks.HOT_DOG_FENCE);
                        output.accept(ModBlocks.HOT_DOG_FENCE_GATE);
                        output.accept(ModBlocks.HOT_DOG_WALL);

                        output.accept(ModBlocks.HOT_DOG_DOOR);
                        output.accept(ModBlocks.HOT_DOG_TRAPDOOR);

                        output.accept(ModBlocks.HOT_DOG_LAMP);

                        output.accept(ModItems.PIZZA_HELMET);
                        output.accept(ModItems.PIZZA_CHESTPLATE);
                        output.accept(ModItems.PIZZA_LEGGINGS);
                        output.accept(ModItems.PIZZA_BOOTS);

                        output.accept(ModItems.TOMATO);
                        output.accept(ModItems.TOMATO_SEEDS);
                        output.accept(ModItems.KETCHUP);
                        output.accept(ModItems.MUSTARD_SEEDS);
                        output.accept(ModItems.MUSTARD);
                    })
                    .build());

    public static final Supplier<CreativeModeTab> COLORFUL_BRICKS = CREATIVE_MODE_TAB.register("colorful_bricks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.LIGHT_BLUE_BRICKS))
                    .title(Component.translatable("creativetab.nicksmod.colorful_bricks"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.WHITE_BRICKS);
                        output.accept(ModBlocks.LIGHT_GRAY_BRICKS);
                        output.accept(ModBlocks.GRAY_BRICKS);
                        output.accept(ModBlocks.BLACK_BRICKS);
                        output.accept(ModBlocks.BROWN_BRICKS);
                        output.accept(ModBlocks.RED_BRICKS);
                        output.accept(ModBlocks.ORANGE_BRICKS);
                        output.accept(ModBlocks.YELLOW_BRICKS);
                        output.accept(ModBlocks.LIME_BRICKS);
                        output.accept(ModBlocks.GREEN_BRICKS);
                        output.accept(ModBlocks.CYAN_BRICKS);
                        output.accept(ModBlocks.LIGHT_BLUE_BRICKS);
                        output.accept(ModBlocks.PURPLE_BRICKS);
                        output.accept(ModBlocks.MAGENTA_BRICKS);
                        output.accept(ModBlocks.PINK_BRICKS);

                        output.accept(ModBlocks.WHITE_BRICKS_SLAB);
                        output.accept(ModBlocks.LIGHT_GRAY_BRICKS_SLAB);
                        output.accept(ModBlocks.GRAY_BRICKS_SLAB);
                        output.accept(ModBlocks.BLACK_BRICKS_SLAB);
                        output.accept(ModBlocks.BROWN_BRICKS_SLAB);
                        output.accept(ModBlocks.RED_BRICKS_SLAB);
                        output.accept(ModBlocks.ORANGE_BRICKS_SLAB);
                        output.accept(ModBlocks.YELLOW_BRICKS_SLAB);
                        output.accept(ModBlocks.LIME_BRICKS_SLAB);
                        output.accept(ModBlocks.GREEN_BRICKS_SLAB);
                        output.accept(ModBlocks.CYAN_BRICKS_SLAB);
                        output.accept(ModBlocks.LIGHT_BLUE_BRICKS_SLAB);
                        output.accept(ModBlocks.PURPLE_BRICKS_SLAB);
                        output.accept(ModBlocks.MAGENTA_BRICKS_SLAB);
                        output.accept(ModBlocks.PINK_BRICKS_SLAB);

                        output.accept(ModBlocks.WHITE_BRICKS_STAIRS);
                        output.accept(ModBlocks.LIGHT_GRAY_BRICKS_STAIRS);
                        output.accept(ModBlocks.GRAY_BRICKS_STAIRS);
                        output.accept(ModBlocks.BLACK_BRICKS_STAIRS);
                        output.accept(ModBlocks.BROWN_BRICKS_STAIRS);
                        output.accept(ModBlocks.RED_BRICKS_STAIRS);
                        output.accept(ModBlocks.ORANGE_BRICKS_STAIRS);
                        output.accept(ModBlocks.YELLOW_BRICKS_STAIRS);
                        output.accept(ModBlocks.LIME_BRICKS_STAIRS);
                        output.accept(ModBlocks.GREEN_BRICKS_STAIRS);
                        output.accept(ModBlocks.CYAN_BRICKS_STAIRS);
                        output.accept(ModBlocks.LIGHT_BLUE_BRICKS_STAIRS);
                        output.accept(ModBlocks.PURPLE_BRICKS_STAIRS);
                        output.accept(ModBlocks.MAGENTA_BRICKS_STAIRS);
                        output.accept(ModBlocks.PINK_BRICKS_STAIRS);

                        output.accept(ModBlocks.WHITE_BRICKS_WALL);
                        output.accept(ModBlocks.LIGHT_GRAY_BRICKS_WALL);
                        output.accept(ModBlocks.GRAY_BRICKS_WALL);
                        output.accept(ModBlocks.BLACK_BRICKS_WALL);
                        output.accept(ModBlocks.BROWN_BRICKS_WALL);
                        output.accept(ModBlocks.RED_BRICKS_WALL);
                        output.accept(ModBlocks.ORANGE_BRICKS_WALL);
                        output.accept(ModBlocks.YELLOW_BRICKS_WALL);
                        output.accept(ModBlocks.LIME_BRICKS_WALL);
                        output.accept(ModBlocks.GREEN_BRICKS_WALL);
                        output.accept(ModBlocks.CYAN_BRICKS_WALL);
                        output.accept(ModBlocks.LIGHT_BLUE_BRICKS_WALL);
                        output.accept(ModBlocks.PURPLE_BRICKS_WALL);
                        output.accept(ModBlocks.MAGENTA_BRICKS_WALL);
                        output.accept(ModBlocks.PINK_BRICKS_WALL);

                        output.accept(ModItems.WHITE_BRICK);
                        output.accept(ModItems.LIGHT_GRAY_BRICK);
                        output.accept(ModItems.GRAY_BRICK);
                        output.accept(ModItems.BLACK_BRICK);
                        output.accept(ModItems.BROWN_BRICK);
                        output.accept(ModItems.RED_BRICK);
                        output.accept(ModItems.ORANGE_BRICK);
                        output.accept(ModItems.YELLOW_BRICK);
                        output.accept(ModItems.LIME_BRICK);
                        output.accept(ModItems.GREEN_BRICK);
                        output.accept(ModItems.CYAN_BRICK);
                        output.accept(ModItems.LIGHT_BLUE_BRICK);
                        output.accept(ModItems.PURPLE_BRICK);
                        output.accept(ModItems.MAGENTA_BRICK);
                        output.accept(ModItems.PINK_BRICK);

                        output.accept(ModItems.WHITE_CLAY);
                        output.accept(ModItems.LIGHT_GRAY_CLAY);
                        output.accept(ModItems.GRAY_CLAY);
                        output.accept(ModItems.BLACK_CLAY);
                        output.accept(ModItems.BROWN_CLAY);
                        output.accept(ModItems.RED_CLAY);
                        output.accept(ModItems.ORANGE_CLAY);
                        output.accept(ModItems.YELLOW_CLAY);
                        output.accept(ModItems.LIME_CLAY);
                        output.accept(ModItems.GREEN_CLAY);
                        output.accept(ModItems.CYAN_CLAY);
                        output.accept(ModItems.LIGHT_BLUE_CLAY);
                        output.accept(ModItems.PURPLE_CLAY);
                        output.accept(ModItems.MAGENTA_CLAY);
                        output.accept(ModItems.PINK_CLAY);
                    })
                    .build());


    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
