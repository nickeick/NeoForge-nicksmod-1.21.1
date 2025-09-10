package com.nickkick.nicksmod.data_map.network;

import com.nickkick.nicksmod.data_map.ModDataMapTypes;
import com.nickkick.nicksmod.player.ModPlayerData;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.network.handling.IPayloadContext;

import java.util.function.Supplier;

public class ServerPayloadHandler {
    public static void handleOnNetwork(ModDataMapTypes.BonusData data, IPayloadContext context) {
        Supplier<AttachmentType<ModDataMapTypes.BonusData>> bonusSupplier = ModPlayerData.BONUS_NAMES.get(data.name());

        context.enqueueWork(() -> {
            Player player = context.player();
            if (player != null && bonusSupplier != null) {
                // Construct BonusData object from int and store
                ModDataMapTypes.BonusData bonusData = new ModDataMapTypes.BonusData(data.name(), data.skill(), data.cost());
                player.setData(bonusSupplier.get(), bonusData);
                ModDataMapTypes.SkillData skillData = player.getData(ModPlayerData.SKILL_NAMES.get(data.skill()));
                player.setData(ModPlayerData.SKILL_NAMES.get(data.skill()).get(), new ModDataMapTypes.SkillData(skillData.name(), skillData.skill() - data.cost()));
            }
        }).exceptionally(e -> {
            context.disconnect(Component.translatable("nicksmod.network.failed", e.getMessage()));
            return null;
        });
    }
}
