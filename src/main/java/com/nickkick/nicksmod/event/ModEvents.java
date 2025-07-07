package com.nickkick.nicksmod.event;

import com.nickkick.nicksmod.NicksMod;
import com.nickkick.nicksmod.component.ModDataComponents;
import com.nickkick.nicksmod.item.ModItems;
import com.nickkick.nicksmod.util.ModTags;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.level.BlockEvent;

@EventBusSubscriber(modid = NicksMod.MOD_ID, bus = EventBusSubscriber.Bus.GAME)
public class ModEvents {

    @SubscribeEvent
    public static void onMine(BlockEvent.BreakEvent event) {
        if(event.getState().is(BlockTags.MINEABLE_WITH_PICKAXE) && !event.isCanceled() && event.getPlayer().getMainHandItem().is(ItemTags.PICKAXES)) {
            Inventory inv = event.getPlayer().getInventory();
            if(inv.contains(ModTags.Items.STAT_TRACKABLE_ITEMS)) {
                for (int i = 0; i < inv.items.size(); ++i) {
                    ItemStack itemStack = inv.getItem(i);
                    if(itemStack.getItem() == ModItems.SKILL_STAFF.get()) {
                        itemStack.set(ModDataComponents.MINED_BLOCKS, itemStack.get(ModDataComponents.MINED_BLOCKS) != null ? itemStack.get(ModDataComponents.MINED_BLOCKS) + 1 : 1);
                        return;
                    }
                }
            }
        }
    }
}
