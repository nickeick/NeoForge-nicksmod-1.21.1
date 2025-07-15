package com.nickkick.nicksmod.item;

import com.nickkick.nicksmod.NicksMod;
import com.nickkick.nicksmod.block.ModBlocks;
import com.nickkick.nicksmod.item.custom.ChiselItem;
import com.nickkick.nicksmod.item.custom.ModArmorItem;
import com.nickkick.nicksmod.item.custom.SkillStaffItem;
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

    public static final DeferredItem<Item> ZIRCON = ITEMS.register("zircon",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> SKILL_STAFF = ITEMS.register("skill_staff",
            () -> new SkillStaffItem(new Item.Properties()));

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

    public static final DeferredItem<Item> WHITE_BRICK = ITEMS.register("white_brick",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> LIGHT_GRAY_BRICK = ITEMS.register("light_gray_brick",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> GRAY_BRICK = ITEMS.register("gray_brick",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> BLACK_BRICK = ITEMS.register("black_brick",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> BROWN_BRICK = ITEMS.register("brown_brick",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> RED_BRICK = ITEMS.register("red_brick",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> ORANGE_BRICK = ITEMS.register("orange_brick",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> YELLOW_BRICK = ITEMS.register("yellow_brick",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> LIME_BRICK = ITEMS.register("lime_brick",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> GREEN_BRICK = ITEMS.register("green_brick",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> CYAN_BRICK = ITEMS.register("cyan_brick",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> LIGHT_BLUE_BRICK = ITEMS.register("light_blue_brick",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> BLUE_BRICK = ITEMS.register("blue_brick",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> PURPLE_BRICK = ITEMS.register("purple_brick",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> MAGENTA_BRICK = ITEMS.register("magenta_brick",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> PINK_BRICK = ITEMS.register("pink_brick",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> WHITE_CLAY = ITEMS.register("white_clay",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> LIGHT_GRAY_CLAY = ITEMS.register("light_gray_clay",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> GRAY_CLAY = ITEMS.register("gray_clay",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> BLACK_CLAY = ITEMS.register("black_clay",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> BROWN_CLAY = ITEMS.register("brown_clay",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> RED_CLAY = ITEMS.register("red_clay",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> ORANGE_CLAY = ITEMS.register("orange_clay",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> YELLOW_CLAY = ITEMS.register("yellow_clay",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> LIME_CLAY = ITEMS.register("lime_clay",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> GREEN_CLAY = ITEMS.register("green_clay",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> CYAN_CLAY = ITEMS.register("cyan_clay",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> LIGHT_BLUE_CLAY = ITEMS.register("light_blue_clay",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> BLUE_CLAY = ITEMS.register("blue_clay",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> PURPLE_CLAY = ITEMS.register("purple_clay",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> MAGENTA_CLAY = ITEMS.register("magenta_clay",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> PINK_CLAY = ITEMS.register("pink_clay",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
