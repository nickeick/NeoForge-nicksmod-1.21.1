package com.nickkick.nicksmod.data_map.network;

import com.nickkick.nicksmod.data_map.ModDataMapTypes;
import com.nickkick.nicksmod.player.ModPlayerData;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.network.handling.IPayloadContext;

import java.util.function.Supplier;

public class ServerPayloadHandler {
    public static void handleOnNetwork(ModDataMapTypes.BonusData data, IPayloadContext context) {
        Supplier<AttachmentType<ModDataMapTypes.BonusData>> bonusSupplier = ModPlayerData.BONUS_NAMES.get(data.name());
        ModDataMapTypes.BonusData bonusData = new ModDataMapTypes.BonusData(data.name(), data.skill(), data.cost(), data.has());

        context.enqueueWork(() -> {
            if (context.flow().isServerbound()) {
                Player player = context.player();
                if (player != null && bonusSupplier != null) {
                    System.out.println("server supp:" + bonusSupplier.get());
                    player.setData(bonusSupplier.get(), bonusData);
                    ModDataMapTypes.SkillData skillData = player.getData(ModPlayerData.SKILL_NAMES.get(data.skill()));
                    ModDataMapTypes.SkillData newData = new ModDataMapTypes.SkillData(skillData.name(), skillData.skill() - data.cost());
                    player.setData(ModPlayerData.SKILL_NAMES.get(data.skill()).get(), newData);

                    PacketDistributor.sendToPlayer((ServerPlayer) player, bonusData);
                    PacketDistributor.sendToPlayer((ServerPlayer) player, newData);
                }
            } else {
                Player player = context.player();
                if (player != null && bonusSupplier != null) {
                    System.out.println("supp: " + bonusSupplier.get());
                    System.out.println("[CLIENT] BonusData: " + bonusData);
                    player.setData(bonusSupplier.get(), bonusData);
                }
            }
        }).exceptionally(e -> {
            context.disconnect(Component.translatable("nicksmod.network.failed", e.getMessage()));
            return null;
        });
    }
}
