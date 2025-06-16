package com.nickkick.nicksmod.item;

import com.nickkick.nicksmod.NicksMod;
import com.nickkick.nicksmod.item.custom.ChiselItem;
import net.minecraft.world.item.Item;
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

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
