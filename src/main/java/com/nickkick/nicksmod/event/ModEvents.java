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
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.event.level.BlockEvent;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.*;
import java.util.function.Supplier;

@EventBusSubscriber(modid = NicksMod.MOD_ID, bus = EventBusSubscriber.Bus.GAME)
public class ModEvents {

    @SubscribeEvent
    public static void onPlayerLogin(PlayerEvent.PlayerLoggedInEvent event) {
        // This is a Synchronization for server and client data
        if (event.getEntity() instanceof ServerPlayer serverPlayer) {
            // Send SkillData
            for (Supplier<AttachmentType<ModDataMapTypes.SkillData>> skill: ModPlayerData.SKILL_NAMES.values()) {
                var skillData = serverPlayer.getData(skill.get());
                if (skillData != null) {
                    PacketDistributor.sendToPlayer(serverPlayer, skillData);
                }
            }

            // Send BonusData
            for(Supplier<AttachmentType<ModDataMapTypes.BonusData>> bonus: ModPlayerData.BONUS_NAMES.values()) {
                var bonusData = serverPlayer.getData(bonus.get());
                if (bonusData != null) {
                    PacketDistributor.sendToPlayer(serverPlayer, bonusData);
                }
            }
        }
    }

    @SubscribeEvent
    public static void onMine(BlockEvent.BreakEvent event) {
        ItemStack mainHandItem = event.getPlayer().getMainHandItem();
        if(event.getState().is(BlockTags.MINEABLE_WITH_PICKAXE) && !event.isCanceled() && mainHandItem.is(ItemTags.PICKAXES)) {
            updateSkillStaff(event.getPlayer(), ModDataComponents.MINED_BLOCKS);
            ModDataMapTypes.BonusData bonusData = event.getPlayer().getData(ModPlayerData.AREA_MINING_BONUS.get());
            ModAbilityData.AreaModeData abilityData = event.getPlayer().getData(ModPlayerData.AREA_MODE_ENABLED.get());
            if(bonusData.has() && abilityData.isEnabled()) {
                ModEventHelpers.onAreaEffectEvent(event, mainHandItem.getItem());
            }
            Level level = (Level) event.getLevel();
            BlockState blockState = level.getBlockState(event.getPos());
            Block block = blockState.getBlock();
            if (block instanceof DropExperienceBlock experienceBlock) {
                int xp = experienceBlock.getExpDrop(blockState, level, event.getPos(), level.getBlockEntity(event.getPos()), event.getPlayer(), mainHandItem);
                event.getPlayer().giveExperiencePoints(xp);
            }
        }
        if(event.getState().is(BlockTags.MINEABLE_WITH_AXE) && !event.isCanceled() && mainHandItem.is(ItemTags.AXES)) {
            updateSkillStaff(event.getPlayer(), ModDataComponents.CHOPPED_BLOCKS);
            ModDataMapTypes.BonusData bonusData = event.getPlayer().getData(ModPlayerData.FELLER_CHOPPING_BONUS.get());
            ModAbilityData.FellerModeData abilityData = event.getPlayer().getData(ModPlayerData.FELLER_MODE_ENABLED.get());
            if (bonusData.has() && event.getLevel().getBlockState(event.getPos()).is(BlockTags.LOGS) && abilityData.isEnabled()) {
                ModEventHelpers.onTreeFellEffectEvent(event);
                //ModEventHelpers.resetBlock();
            }
        }
        if(event.getState().is(BlockTags.MINEABLE_WITH_SHOVEL) && !event.isCanceled() && mainHandItem.is(ItemTags.SHOVELS)) {
            updateSkillStaff(event.getPlayer(), ModDataComponents.DUG_BLOCKS);
            ModDataMapTypes.BonusData bonusData = event.getPlayer().getData(ModPlayerData.AREA_DIGGING_BONUS.get());
            ModAbilityData.AreaModeData abilityData = event.getPlayer().getData(ModPlayerData.AREA_MODE_ENABLED.get());
            if(bonusData.has() && abilityData.isEnabled()) {
                ModEventHelpers.onAreaEffectEvent(event, mainHandItem.getItem());
            }
        }
    }

    @SubscribeEvent
    public static void onDamage(LivingDamageEvent.Pre event) {
        if(event.getSource().getDirectEntity() instanceof Player player) {
            ItemStack mainHandItem = player.getMainHandItem();
            if(mainHandItem.is(ItemTags.SWORDS)) {
                updateSkillStaff(player, ModDataComponents.SWORD_ATTACKS);
                ModDataMapTypes.BonusData weaknessBonus = player.getData(ModPlayerData.WEAKNESS_SWORDS_BONUS.get());
                if (weaknessBonus.has()) {
                    event.getEntity().addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 600));
                }
                ModDataMapTypes.BonusData witherBonus = player.getData(ModPlayerData.WITHER_SWORDS_BONUS.get());
                if (witherBonus.has()) {
                    event.getEntity().addEffect(new MobEffectInstance(MobEffects.WITHER, 600));
                }
                ModDataMapTypes.BonusData blindnessBonus = player.getData(ModPlayerData.BLINDNESS_SWORDS_BONUS.get());
                if (blindnessBonus.has()) {
                    event.getEntity().addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 600));
                }
            }
            if(mainHandItem.is(ItemTags.AXES)) {
                updateSkillStaff(player, ModDataComponents.AXE_ATTACKS);
                ModDataMapTypes.BonusData jumpBonus = player.getData(ModPlayerData.JUMP_AXES_BONUS.get());
                if (jumpBonus.has()) {
                    player.addEffect(new MobEffectInstance(MobEffects.JUMP, 600));
                }
                ModDataMapTypes.BonusData regenerationBonus = player.getData(ModPlayerData.REGENERATION_AXES_BONUS.get());
                if (regenerationBonus.has()) {
                    player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 600));
                }
                ModDataMapTypes.BonusData invisibilityBonus = player.getData(ModPlayerData.INVISIBILITY_AXES_BONUS.get());
                if (invisibilityBonus.has()) {
                    player.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 600));
                }
            }
            if (mainHandItem.isEmpty()) {
                updateSkillStaff(player, ModDataComponents.UNARMED_ATTACKS);
                ModDataMapTypes.BonusData slowBonus = player.getData(ModPlayerData.SLOW_UNARMED_BONUS.get());
                if(slowBonus.has()) {
                    event.getEntity().addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 600, 3));
                }
                ModDataMapTypes.BonusData poisonBonus = player.getData(ModPlayerData.POISON_UNARMED_BONUS.get());
                if (poisonBonus.has()) {
                    event.getEntity().addEffect(new MobEffectInstance(MobEffects.POISON, 600));
                }
                ModDataMapTypes.BonusData lightningBonus = player.getData(ModPlayerData.LIGHTNING_UNARMED_BONUS.get());
                if (lightningBonus.has()) {
                    EntityType.LIGHTNING_BOLT.spawn((ServerLevel) event.getEntity().level(), event.getEntity().blockPosition(), MobSpawnType.TRIGGERED);
                }
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
                if(player.hasData(ModPlayerData.AREA_MINING_BONUS.get()) && player.getData(ModPlayerData.AREA_MINING_BONUS.get()).has()) {
                    ModAbilityData.AreaModeData abilityData = player.getData(ModPlayerData.AREA_MODE_ENABLED.get());
                    if(abilityData.isEnabled()) {
                        player.sendSystemMessage(Component.literal("3x3 Area Disabled"));
                        abilityData.setEnabled(false);
                    } else {
                        player.sendSystemMessage(Component.literal("3x3 Area Enabled"));
                        abilityData.setEnabled(true);
                    }
                    PacketDistributor.sendToServer(new ModDataMapTypes.ToggleAreaAbilityPayload());
                    //System.out.println("test");
                } else {
                    player.sendSystemMessage(Component.literal("You do not have this upgrade"));
                }
            }
        }
        while (ModKeyMappings.FELLER_MODE_MAPPING.consumeClick()) {
            Player player = Minecraft.getInstance().player;
            if (player != null) {
                if(player.hasData(ModPlayerData.FELLER_CHOPPING_BONUS.get()) && player.getData(ModPlayerData.FELLER_CHOPPING_BONUS.get()).has()) {
                    ModAbilityData.FellerModeData abilityData = player.getData(ModPlayerData.FELLER_MODE_ENABLED.get());
                    if(abilityData.isEnabled()) {
                        player.sendSystemMessage(Component.literal("Tree Feller Disabled"));
                        abilityData.setEnabled(false);
                    } else {
                        player.sendSystemMessage(Component.literal("Tree Feller Enabled"));
                        abilityData.setEnabled(true);
                    }
                    PacketDistributor.sendToServer(new ModDataMapTypes.ToggleFellerAbilityPayload());
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
    private static final Set<BlockPos> FELLED_BLOCKS = new HashSet<>();
    private static Block TO_BE_FELLED_BLOCK = null;

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

    public static void onTreeFellEffectEvent(BlockEvent.BreakEvent event) {
        Player player = event.getPlayer();
        Level level = (Level) event.getLevel();

        if (player instanceof ServerPlayer serverPlayer) {
            BlockPos pos = event.getPos();
            pos = new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ());
            if (level.getBlockState(pos).is(BlockTags.LOGS)) {
                serverPlayer.gameMode.destroyBlock(pos);
                //FELLED_BLOCKS.add(pos);
            }

            //FELLED_BLOCKS.clear();
        }
    }
}