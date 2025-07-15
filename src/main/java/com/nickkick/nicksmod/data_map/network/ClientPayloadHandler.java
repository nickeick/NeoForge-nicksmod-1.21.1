package com.nickkick.nicksmod.data_map.network;

import com.nickkick.nicksmod.data_map.ModDataMapTypes;
import com.nickkick.nicksmod.player.ModPlayerData;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.network.handling.IPayloadContext;

import java.util.function.Supplier;

public class ClientPayloadHandler {
    public static void handleOnNetwork(ModDataMapTypes.SkillData data, IPayloadContext context) {
        Supplier<AttachmentType<ModDataMapTypes.SkillData>> skillSupplier = ModPlayerData.SKILL_NAMES.get(data.name());

        context.enqueueWork(() -> {
            Player player = context.player();
            if (player != null && skillSupplier != null) {
                // Construct SkillData object from int and store
//                System.out.println(" ~~~~~ ");
//                System.out.println(data.skill());
//                System.out.println(" ~~~~~ ");

                ModDataMapTypes.SkillData skillData = new ModDataMapTypes.SkillData(data.name(), data.skill());
                player.setData(skillSupplier.get(), skillData);
            }
        }).exceptionally(e -> {
            context.disconnect(Component.translatable("nicksmod.network.failed", e.getMessage()));
            return null;
        });
    }
}
