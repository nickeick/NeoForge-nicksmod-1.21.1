package com.nickkick.nicksmod.player;

import com.google.common.collect.ImmutableMap;
import com.nickkick.nicksmod.NicksMod;
import com.nickkick.nicksmod.data_map.ModDataMapTypes;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.Map;
import java.util.function.Supplier;


public class ModPlayerData {
    // Create the DeferredRegister for attachment types
    private static final DeferredRegister<AttachmentType<?>> ATTACHMENT_TYPES = DeferredRegister.create(NeoForgeRegistries.ATTACHMENT_TYPES, NicksMod.MOD_ID);

    public static final Supplier<AttachmentType<ModDataMapTypes.SkillData>> MINING_SKILL = ATTACHMENT_TYPES.register(
            "mining_skill", () -> AttachmentType.builder(() -> new ModDataMapTypes.SkillData("mining",0))
                    .serialize(ModDataMapTypes.SkillData.CODEC)
                    .build()
    );

    public static final Supplier<AttachmentType<ModDataMapTypes.SkillData>> CHOPPING_SKILL = ATTACHMENT_TYPES.register(
            "chopping_skill", () -> AttachmentType.builder(() -> new ModDataMapTypes.SkillData("chopping",0))
                    .serialize(ModDataMapTypes.SkillData.CODEC)
                    .build()
    );

    public static final Supplier<AttachmentType<ModDataMapTypes.SkillData>> SWORDS_SKILL = ATTACHMENT_TYPES.register(
            "swords_skill", () -> AttachmentType.builder(() -> new ModDataMapTypes.SkillData("swords",0))
                    .serialize(ModDataMapTypes.SkillData.CODEC)
                    .build()
    );

    public static final Supplier<AttachmentType<ModDataMapTypes.SkillData>> DIGGING_SKILL = ATTACHMENT_TYPES.register(
            "digging_skill", () -> AttachmentType.builder(() -> new ModDataMapTypes.SkillData("digging",0))
                    .serialize(ModDataMapTypes.SkillData.CODEC)
                    .build()
    );

    public static final Supplier<AttachmentType<ModDataMapTypes.SkillData>> AXES_SKILL = ATTACHMENT_TYPES.register(
            "axes_skill", () -> AttachmentType.builder(() -> new ModDataMapTypes.SkillData("axes",0))
                    .serialize(ModDataMapTypes.SkillData.CODEC)
                    .build()
    );

    public static final Supplier<AttachmentType<ModDataMapTypes.SkillData>> UNARMED_SKILL = ATTACHMENT_TYPES.register(
            "unarmed_skill", () -> AttachmentType.builder(() -> new ModDataMapTypes.SkillData("unarmed",0))
                    .serialize(ModDataMapTypes.SkillData.CODEC)
                    .build()
    );

    public static final Map<String, Supplier<AttachmentType<ModDataMapTypes.SkillData>>> SKILL_NAMES =
            (new ImmutableMap.Builder<String, Supplier<AttachmentType<ModDataMapTypes.SkillData>>>())
                    .put("mining", ModPlayerData.MINING_SKILL)
                    .put("chopping", ModPlayerData.CHOPPING_SKILL)
                    .put("digging", ModPlayerData.DIGGING_SKILL)
                    .put("swords", ModPlayerData.SWORDS_SKILL)
                    .put("axes", ModPlayerData.AXES_SKILL)
                    .put("unarmed", ModPlayerData.UNARMED_SKILL)
                    .build();

    public static final Supplier<AttachmentType<ModDataMapTypes.BonusData>> EMPTY_MINING_BONUS = ATTACHMENT_TYPES.register(
            "empty_mining_bonus", () -> AttachmentType.builder(() -> new ModDataMapTypes.BonusData("empty_mining_bonus", "mining", 10))
                    .serialize(ModDataMapTypes.BonusData.CODEC)
                    .build()
    );

    public static final Map<String, Supplier<AttachmentType<ModDataMapTypes.BonusData>>> BONUS_NAMES =
            (new ImmutableMap.Builder<String, Supplier<AttachmentType<ModDataMapTypes.BonusData>>>())
                    .put("empty_mining_bonus", ModPlayerData.EMPTY_MINING_BONUS)
                    .build();

    public static final Supplier<AttachmentType<ModAbilityData.AreaModeData>> AREA_MODE_ENABLED = ATTACHMENT_TYPES.register(
            "area_mode_enabled", () -> AttachmentType.builder(ModAbilityData.AreaModeData::new).build()
    );

    public static void register(IEventBus eventBus) {
        ATTACHMENT_TYPES.register(eventBus);
    }
}
