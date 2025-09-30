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

    public static final Supplier<AttachmentType<ModDataMapTypes.BonusData>> AREA_MINING_BONUS = ATTACHMENT_TYPES.register(
            "area_mining_bonus", () -> AttachmentType.builder(() -> new ModDataMapTypes.BonusData("area_mining_bonus", "mining", 10, false))
                    .serialize(ModDataMapTypes.BonusData.CODEC)
                    .build()
    );
    public static final Supplier<AttachmentType<ModDataMapTypes.BonusData>> XP_MINING_BONUS = ATTACHMENT_TYPES.register(
            "xp_mining_bonus", () -> AttachmentType.builder(() -> new ModDataMapTypes.BonusData("xp_mining_bonus", "mining", 20, false))
                    .serialize(ModDataMapTypes.BonusData.CODEC)
                    .build()
    );

    public static final Supplier<AttachmentType<ModDataMapTypes.BonusData>> FELLER_CHOPPING_BONUS = ATTACHMENT_TYPES.register(
            "feller_chopping_bonus", () -> AttachmentType.builder(() -> new ModDataMapTypes.BonusData("feller_chopping_bonus", "chopping", 10, false))
                    .serialize(ModDataMapTypes.BonusData.CODEC)
                    .build()
    );

    public static final Supplier<AttachmentType<ModDataMapTypes.BonusData>> AREA_DIGGING_BONUS = ATTACHMENT_TYPES.register(
            "area_digging_bonus", () -> AttachmentType.builder(() -> new ModDataMapTypes.BonusData("area_digging_bonus", "digging", 10, false))
                    .serialize(ModDataMapTypes.BonusData.CODEC)
                    .build()
    );

    public static final Supplier<AttachmentType<ModDataMapTypes.BonusData>> WEAKNESS_SWORDS_BONUS = ATTACHMENT_TYPES.register(
            "weakness_swords_bonus", () -> AttachmentType.builder(() -> new ModDataMapTypes.BonusData("weakness_swords_bonus", "swords", 10, false))
                    .serialize(ModDataMapTypes.BonusData.CODEC)
                    .build()
    );
    public static final Supplier<AttachmentType<ModDataMapTypes.BonusData>> WITHER_SWORDS_BONUS = ATTACHMENT_TYPES.register(
            "wither_swords_bonus", () -> AttachmentType.builder(() -> new ModDataMapTypes.BonusData("wither_swords_bonus", "swords", 20, false))
                    .serialize(ModDataMapTypes.BonusData.CODEC)
                    .build()
    );
    public static final Supplier<AttachmentType<ModDataMapTypes.BonusData>> BLINDNESS_SWORDS_BONUS = ATTACHMENT_TYPES.register(
            "blindness_swords_bonus", () -> AttachmentType.builder(() -> new ModDataMapTypes.BonusData("blindness_swords_bonus", "swords", 30, false))
                    .serialize(ModDataMapTypes.BonusData.CODEC)
                    .build()
    );

    public static final Supplier<AttachmentType<ModDataMapTypes.BonusData>> JUMP_AXES_BONUS = ATTACHMENT_TYPES.register(
            "jump_axes_bonus", () -> AttachmentType.builder(() -> new ModDataMapTypes.BonusData("jump_axes_bonus", "axes", 10, false))
                    .serialize(ModDataMapTypes.BonusData.CODEC)
                    .build()
    );
    public static final Supplier<AttachmentType<ModDataMapTypes.BonusData>> REGENERATION_AXES_BONUS = ATTACHMENT_TYPES.register(
            "regeneration_axes_bonus", () -> AttachmentType.builder(() -> new ModDataMapTypes.BonusData("regeneration_axes_bonus", "axes", 20, false))
                    .serialize(ModDataMapTypes.BonusData.CODEC)
                    .build()
    );
    public static final Supplier<AttachmentType<ModDataMapTypes.BonusData>> INVISIBILITY_AXES_BONUS = ATTACHMENT_TYPES.register(
            "invisibility_axes_bonus", () -> AttachmentType.builder(() -> new ModDataMapTypes.BonusData("invisibility_axes_bonus", "axes", 30, false))
                    .serialize(ModDataMapTypes.BonusData.CODEC)
                    .build()
    );

    public static final Supplier<AttachmentType<ModDataMapTypes.BonusData>> SLOW_UNARMED_BONUS = ATTACHMENT_TYPES.register(
            "slow_unarmed_bonus", () -> AttachmentType.builder(() -> new ModDataMapTypes.BonusData("slow_unarmed_bonus", "unarmed", 10, false))
                    .serialize(ModDataMapTypes.BonusData.CODEC)
                    .build()
    );
    public static final Supplier<AttachmentType<ModDataMapTypes.BonusData>> POISON_UNARMED_BONUS = ATTACHMENT_TYPES.register(
            "poison_unarmed_bonus", () -> AttachmentType.builder(() -> new ModDataMapTypes.BonusData("poison_unarmed_bonus", "unarmed", 20, false))
                    .serialize(ModDataMapTypes.BonusData.CODEC)
                    .build()
    );
    public static final Supplier<AttachmentType<ModDataMapTypes.BonusData>> LIGHTNING_UNARMED_BONUS = ATTACHMENT_TYPES.register(
            "lightning_unarmed_bonus", () -> AttachmentType.builder(() -> new ModDataMapTypes.BonusData("lightning_unarmed_bonus", "unarmed", 30, false))
                    .serialize(ModDataMapTypes.BonusData.CODEC)
                    .build()
    );

    public static final Map<String, Supplier<AttachmentType<ModDataMapTypes.BonusData>>> BONUS_NAMES =
            (new ImmutableMap.Builder<String, Supplier<AttachmentType<ModDataMapTypes.BonusData>>>())
                    .put("area_mining_bonus", ModPlayerData.AREA_MINING_BONUS)
                    .put("xp_mining_bonus", ModPlayerData.XP_MINING_BONUS)
                    .put("feller_chopping_bonus", ModPlayerData.FELLER_CHOPPING_BONUS)
                    .put("area_digging_bonus", ModPlayerData.AREA_DIGGING_BONUS)
                    .put("weakness_swords_bonus", ModPlayerData.WEAKNESS_SWORDS_BONUS)
                    .put("wither_swords_bonus", ModPlayerData.WITHER_SWORDS_BONUS)
                    .put("blindness_swords_bonus", ModPlayerData.BLINDNESS_SWORDS_BONUS)
                    .put("jump_axes_bonus", ModPlayerData.JUMP_AXES_BONUS)
                    .put("regeneration_axes_bonus", ModPlayerData.REGENERATION_AXES_BONUS)
                    .put("invisibility_axes_bonus", ModPlayerData.INVISIBILITY_AXES_BONUS)
                    .put("slow_unarmed_bonus", ModPlayerData.SLOW_UNARMED_BONUS)
                    .put("poison_unarmed_bonus", ModPlayerData.POISON_UNARMED_BONUS)
                    .put("lightning_unarmed_bonus", ModPlayerData.LIGHTNING_UNARMED_BONUS)
                    .build();

    public static final Supplier<AttachmentType<ModAbilityData.AreaModeData>> AREA_MODE_ENABLED = ATTACHMENT_TYPES.register(
            "area_mode_enabled", () -> AttachmentType.builder(ModAbilityData.AreaModeData::new).build()
    );

    public static final Supplier<AttachmentType<ModAbilityData.FellerModeData>> FELLER_MODE_ENABLED = ATTACHMENT_TYPES.register(
            "feller_mode_enabled", () -> AttachmentType.builder(ModAbilityData.FellerModeData::new).build()
    );

    public static void register(IEventBus eventBus) {
        ATTACHMENT_TYPES.register(eventBus);
    }
}
