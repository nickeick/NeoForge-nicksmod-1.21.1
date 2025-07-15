package com.nickkick.nicksmod.event;

import com.nickkick.nicksmod.NicksMod;
import com.nickkick.nicksmod.block.custom.SkillTreeBlock;
import com.nickkick.nicksmod.component.ModDataComponents;
import com.nickkick.nicksmod.data_map.ModDataMapTypes;
import com.nickkick.nicksmod.item.ModItems;
import com.nickkick.nicksmod.util.ModTags;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.event.level.BlockEvent;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.Map;
import java.util.function.Supplier;

@EventBusSubscriber(modid = NicksMod.MOD_ID, bus = EventBusSubscriber.Bus.GAME)
public class ModEvents {

    @SubscribeEvent
    public static void onMine(BlockEvent.BreakEvent event) {
        if(event.getState().is(BlockTags.MINEABLE_WITH_PICKAXE) && !event.isCanceled() && event.getPlayer().getMainHandItem().is(ItemTags.PICKAXES)) {
            updateSkillStaff(event.getPlayer(), ModDataComponents.MINED_BLOCKS);
        }
        if(event.getState().is(BlockTags.MINEABLE_WITH_AXE) && !event.isCanceled() && event.getPlayer().getMainHandItem().is(ItemTags.AXES)) {
            updateSkillStaff(event.getPlayer(), ModDataComponents.CHOPPED_BLOCKS);
        }
        if(event.getState().is(BlockTags.MINEABLE_WITH_SHOVEL) && !event.isCanceled() && event.getPlayer().getMainHandItem().is(ItemTags.SHOVELS)) {
            updateSkillStaff(event.getPlayer(), ModDataComponents.DUG_BLOCKS);
        }
    }

    @SubscribeEvent
    public static void onDamage(LivingDamageEvent.Pre event) {
        if(event.getSource().getDirectEntity() instanceof Player player) {
            if(player.getMainHandItem().is(ItemTags.SWORDS)) {
                updateSkillStaff(player, ModDataComponents.SWORD_ATTACKS);
            }
            if(player.getMainHandItem().is(ItemTags.AXES)) {
                updateSkillStaff(player, ModDataComponents.AXE_ATTACKS);
            }
            if (player.getMainHandItem().isEmpty()) {
                updateSkillStaff(player, ModDataComponents.UNARMED_ATTACKS);
            }
        }
    }

    private static void updateSkillStaff(Player player, DeferredHolder<DataComponentType<?>, DataComponentType<Integer>> dataComponent) {
        Inventory inv = player.getInventory();
        if (inv.contains(ModTags.Items.STAT_TRACKABLE_ITEMS)) {
            for (int i = 0; i < inv.items.size(); ++i) {
                ItemStack itemStack = inv.getItem(i);
                if (itemStack.getItem() == ModItems.SKILL_STAFF.get()) {
                    itemStack.set(dataComponent, itemStack.get(dataComponent) != null ? itemStack.get(dataComponent) + 1 : 1);
                    return;
                }
            }
        }
    }
}
