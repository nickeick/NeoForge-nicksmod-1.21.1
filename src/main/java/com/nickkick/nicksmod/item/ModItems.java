package com.nickkick.nicksmod.item;

import com.nickkick.nicksmod.NicksMod;
import com.nickkick.nicksmod.block.ModBlocks;
import com.nickkick.nicksmod.item.custom.ModArmorItem;
import com.nickkick.nicksmod.item.custom.ChiselItem;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(NicksMod.MOD_ID);

    public static final DeferredItem<Item> BISMUTH = ITEMS.register("bismuth",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> RAW_BISMUTH = ITEMS.register("raw_bismuth",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> CHISEL = ITEMS.register("chisel",
            () -> new ChiselItem(new Item.Properties().durability(32)));

    public static final DeferredItem<Item> HOT_DOG = ITEMS.register("hot_dog",
            () -> new Item(new Item.Properties().food(ModFoodProperties.HOT_DOG)));
    public static final DeferredItem<Item> HOT_DOG_WITH_KETCHUP = ITEMS.register("hot_dog_with_ketchup",
            () -> new Item(new Item.Properties().food(ModFoodProperties.HOT_DOG_WITH_KETCHUP)));
    public static final DeferredItem<Item> HOT_DOG_WITH_MUSTARD = ITEMS.register("hot_dog_with_mustard",
            () -> new Item(new Item.Properties().food(ModFoodProperties.HOT_DOG_WITH_MUSTARD)));
    public static final DeferredItem<Item> HOT_DOG_WITH_KETCHUP_AND_MUSTARD = ITEMS.register("hot_dog_with_ketchup_and_mustard",
            () -> new Item(new Item.Properties().food(ModFoodProperties.HOT_DOG_WITH_KETCHUP_AND_MUSTARD)));

    public static final DeferredItem<Item> PIZZADINO_TOKEN = ITEMS.register("pizzadino_token",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> PIZZA_SLICE = ITEMS.register("pizza_slice",
            () -> new Item(new Item.Properties().food(ModFoodProperties.PIZZA_SLICE)));

    public static final DeferredItem<ArmorItem> PIZZA_HELMET = ITEMS.register("pizza_helmet",
            () -> new ArmorItem(ModArmorMaterials.PIZZA_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(15))));
    public static final DeferredItem<ArmorItem> PIZZA_CHESTPLATE = ITEMS.register("pizza_chestplate",
            () -> new ModArmorItem(ModArmorMaterials.PIZZA_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(15))));
    public static final DeferredItem<ArmorItem> PIZZA_LEGGINGS = ITEMS.register("pizza_leggings",
            () -> new ArmorItem(ModArmorMaterials.PIZZA_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(15))));
    public static final DeferredItem<ArmorItem> PIZZA_BOOTS = ITEMS.register("pizza_boots",
            () -> new ArmorItem(ModArmorMaterials.PIZZA_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(15))));

    public static final DeferredItem<Item> TOMATO = ITEMS.register("tomato",
            () -> new Item(new Item.Properties().food(ModFoodProperties.TOMATO)));
    public static final DeferredItem<Item> TOMATO_SEEDS = ITEMS.register("tomato_seeds",
            () -> new ItemNameBlockItem(ModBlocks.TOMATO_CROP.get(), new Item.Properties()));
    public static final DeferredItem<Item> KETCHUP = ITEMS.register("ketchup",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> MUSTARD_SEEDS = ITEMS.register("mustard_seeds",
            () -> new ItemNameBlockItem(ModBlocks.MUSTARD_CROP.get(), new Item.Properties()));
    public static final DeferredItem<Item> MUSTARD = ITEMS.register("mustard",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
