package com.nickkick.nicksmod.event;

import com.nickkick.nicksmod.NicksMod;
import com.nickkick.nicksmod.component.ModDataComponents;
import com.nickkick.nicksmod.data_map.ModDataMapTypes;
import com.nickkick.nicksmod.item.ModItems;
import com.nickkick.nicksmod.player.ModAbilityData;
import com.nickkick.nicksmod.player.ModKeyMappings;
import com.nickkick.nicksmod.player.ModPlayerData;
import com.nickkick.nicksmod.util.ModTags;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.neoforged.neoforge.event.level.BlockEvent;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.*;

@EventBusSubscriber(modid = NicksMod.MOD_ID, bus = EventBusSubscriber.Bus.GAME)
public class ModEvents {

    @SubscribeEvent
    public static void onMine(BlockEvent.BreakEvent event) {
        ItemStack mainHandItem = event.getPlayer().getMainHandItem();
        if(event.getState().is(BlockTags.MINEABLE_WITH_PICKAXE) && !event.isCanceled() && mainHandItem.is(ItemTags.PICKAXES)) {
            updateSkillStaff(event.getPlayer(), ModDataComponents.MINED_BLOCKS);
            ModDataMapTypes.BonusData bonusData = event.getPlayer().getData(ModPlayerData.EMPTY_MINING_BONUS.get());
            ModAbilityData.AreaModeData abilityData = event.getPlayer().getData(ModPlayerData.AREA_MODE_ENABLED.get());
            if(Objects.equals(bonusData.name(), "empty_mining_bonus") && abilityData.isEnabled()) {
                ModEventHelpers.onAreaEffectEvent(event, mainHandItem.getItem());
            }
        }
        if(event.getState().is(BlockTags.MINEABLE_WITH_AXE) && !event.isCanceled() && mainHandItem.is(ItemTags.AXES)) {
            updateSkillStaff(event.getPlayer(), ModDataComponents.CHOPPED_BLOCKS);
        }
        if(event.getState().is(BlockTags.MINEABLE_WITH_SHOVEL) && !event.isCanceled() && mainHandItem.is(ItemTags.SHOVELS)) {
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

@EventBusSubscriber(modid = NicksMod.MOD_ID, bus = EventBusSubscriber.Bus.GAME, value = Dist.CLIENT)
class ModClientEvents {
    @SubscribeEvent // on the game event bus only on the physical client
    public static void onClientTick(ClientTickEvent.Post event) {
        while (ModKeyMappings.AREA_MODE_MAPPING.consumeClick()) {
            Player player = Minecraft.getInstance().player;
            if (player != null) {
                ModDataMapTypes.BonusData bonusData = player.getData(ModPlayerData.EMPTY_MINING_BONUS.get());

                if(Objects.equals(bonusData.name(), "empty_mining_bonus")) {
                    ModAbilityData.AreaModeData abilityData = player.getData(ModPlayerData.AREA_MODE_ENABLED.get());
                    if(abilityData.isEnabled()) {
                        player.sendSystemMessage(Component.literal("3x3 Mining Disabled"));
                        abilityData.setEnabled(false);
                    } else {
                        player.sendSystemMessage(Component.literal("3x3 Mining Enabled"));
                        abilityData.setEnabled(true);
                    }
                    PacketDistributor.sendToServer(new ModDataMapTypes.ToggleAbilityPayload());
                    //System.out.println("test");
                } else {
                    player.sendSystemMessage(Component.literal("You do not have this upgrade"));
                }
            }
        }
    }
}

// Thank you Kaupenjoe
class ModEventHelpers {
    private static final Set<BlockPos> HARVESTED_BLOCKS = new HashSet<>();

    public static List<BlockPos> getBlocksToBeDestroyed(int range, BlockPos initalBlockPos, ServerPlayer player) {
        List<BlockPos> positions = new ArrayList<>();

        BlockHitResult traceResult = player.level().clip(new ClipContext(player.getEyePosition(1f),
                (player.getEyePosition(1f).add(player.getViewVector(1f).scale(6f))),
                ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, player));
        if(traceResult.getType() == HitResult.Type.MISS) {
            return positions;
        }

        if(traceResult.getDirection() == Direction.DOWN || traceResult.getDirection() == Direction.UP) {
            for(int x = -range; x <= range; x++) {
                for(int y = -range; y <= range; y++) {
                    positions.add(new BlockPos(initalBlockPos.getX() + x, initalBlockPos.getY(), initalBlockPos.getZ() + y));
                }
            }
        }

        if(traceResult.getDirection() == Direction.NORTH || traceResult.getDirection() == Direction.SOUTH) {
            for(int x = -range; x <= range; x++) {
                for(int y = -range; y <= range; y++) {
                    positions.add(new BlockPos(initalBlockPos.getX() + x, initalBlockPos.getY() + y, initalBlockPos.getZ()));
                }
            }
        }

        if(traceResult.getDirection() == Direction.EAST || traceResult.getDirection() == Direction.WEST) {
            for(int x = -range; x <= range; x++) {
                for(int y = -range; y <= range; y++) {
                    positions.add(new BlockPos(initalBlockPos.getX(), initalBlockPos.getY() + y, initalBlockPos.getZ() + x));
                }
            }
        }

        return positions;
    }
    // Done with the help of https://github.com/CoFH/CoFHCore/blob/1.19.x/src/main/java/cofh/core/event/AreaEffectEvents.java
    // Don't be a jerk License
    // And thank you Kaupenjoe
    public static void onAreaEffectEvent(BlockEvent.BreakEvent event, Item item) {
        Player player = event.getPlayer();
        ItemStack mainHandItem = player.getMainHandItem();

        if (player instanceof ServerPlayer serverPlayer) {
            BlockPos initialBlockPos = event.getPos();
            if(HARVESTED_BLOCKS.contains(initialBlockPos)) {
                return;
            }

            for(BlockPos pos : getBlocksToBeDestroyed(1, initialBlockPos, serverPlayer)) {
                if (pos.equals(initialBlockPos) || !item.isCorrectToolForDrops(mainHandItem, event.getLevel().getBlockState(pos))) {
                    continue;
                }

                HARVESTED_BLOCKS.add(pos);
                serverPlayer.gameMode.destroyBlock(pos);
                HARVESTED_BLOCKS.remove(pos);
            }
        }
    }
}