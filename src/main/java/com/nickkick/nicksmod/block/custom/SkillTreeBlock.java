package com.nickkick.nicksmod.block.custom;

import com.google.common.collect.ImmutableMap;
import com.mojang.serialization.MapCodec;
import com.nickkick.nicksmod.block.entity.SkillTreeBlockEntity;
import com.nickkick.nicksmod.component.ModDataComponents;
import com.nickkick.nicksmod.data_map.ModDataMapTypes;
import com.nickkick.nicksmod.item.ModItems;
import com.nickkick.nicksmod.player.ModPlayerData;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class SkillTreeBlock extends BaseEntityBlock {
    public static final MapCodec<SkillTreeBlock> CODEC = simpleCodec(SkillTreeBlock::new);
    public static final Map<DeferredHolder<DataComponentType<?>, DataComponentType<Integer>>, Supplier<AttachmentType<ModDataMapTypes.SkillData>>> SKILLS =
            (new ImmutableMap.Builder<DeferredHolder<DataComponentType<?>, DataComponentType<Integer>>, Supplier<AttachmentType<ModDataMapTypes.SkillData>>>())
                    .put(ModDataComponents.MINED_BLOCKS, ModPlayerData.MINING_SKILL)
                    .put(ModDataComponents.CHOPPED_BLOCKS, ModPlayerData.CHOPPING_SKILL)
                    .put(ModDataComponents.SWORD_ATTACKS, ModPlayerData.SWORDS_SKILL)
                    .put(ModDataComponents.DUG_BLOCKS, ModPlayerData.DIGGING_SKILL)
                    .put(ModDataComponents.AXE_ATTACKS, ModPlayerData.AXES_SKILL)
                    .put(ModDataComponents.UNARMED_ATTACKS, ModPlayerData.UNARMED_SKILL)
                    .build();

    public SkillTreeBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }

    @Override
    protected RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new SkillTreeBlockEntity(blockPos, blockState);
    }

    // In some Block subclass
    @Override
    public MenuProvider getMenuProvider(BlockState state, Level level, BlockPos pos) {
        if(level.getBlockEntity(pos) instanceof SkillTreeBlockEntity skillTreeBlockEntity) {
            return new SimpleMenuProvider(skillTreeBlockEntity, Component.literal("Skill Tree"));
        }
        return null;
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        if(level.getBlockEntity(pos) instanceof SkillTreeBlockEntity skillTreeBlockEntity) {
            if(stack.getItem() == ModItems.SKILL_STAFF.get()) {
                if (!level.isClientSide() && player instanceof ServerPlayer serverPlayer) {
                    for (Map.Entry<DeferredHolder<DataComponentType<?>, DataComponentType<Integer>>, Supplier<AttachmentType<ModDataMapTypes.SkillData>>> entry : SKILLS.entrySet()) {
                        ModDataMapTypes.SkillData old_skill = serverPlayer.getData(entry.getValue().get());
                        ModDataMapTypes.SkillData new_skill = new ModDataMapTypes.SkillData(old_skill.name(), stack.get(entry.getKey()) != null ? stack.get(entry.getKey()) + old_skill.skill() : 0 + old_skill.skill());
                        serverPlayer.setData(entry.getValue().get(), new_skill);
                        //System.out.println(serverPlayer.getData(entry.getValue().get()));
                        stack.set(entry.getKey(), 0);
                        PacketDistributor.sendToPlayer(serverPlayer, new_skill);
                    }
                } else if (level.isClientSide) {
                    level.playSound(player, pos, SoundEvents.AMETHYST_BLOCK_BREAK, SoundSource.BLOCKS, 1f, 2f);
                }
            } else if (stack.isEmpty()) {
                if (!level.isClientSide() && player instanceof ServerPlayer serverPlayer) {
                    for (Map.Entry<DeferredHolder<DataComponentType<?>, DataComponentType<Integer>>, Supplier<AttachmentType<ModDataMapTypes.SkillData>>> entry : SKILLS.entrySet()) {
                        ModDataMapTypes.SkillData skill = serverPlayer.getData(entry.getValue().get());
                        PacketDistributor.sendToPlayer(serverPlayer, skill);
                    }
                    MenuProvider provider = state.getMenuProvider(level, pos);
                    serverPlayer.openMenu(provider);
                } else if (level.isClientSide) {
                    level.playSound(player, pos, SoundEvents.ENDERMAN_TELEPORT, SoundSource.BLOCKS, 1f, 1f);
                }
            }
        }
        return ItemInteractionResult.SUCCESS;
    }

    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        tooltipComponents.add(Component.translatable("tooltip.nicksmod.skill_tree_block.tooltip"));
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
}
