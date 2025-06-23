package com.nickkick.nicksmod.item;

import com.nickkick.nicksmod.NicksMod;
import com.nickkick.nicksmod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

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


    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
