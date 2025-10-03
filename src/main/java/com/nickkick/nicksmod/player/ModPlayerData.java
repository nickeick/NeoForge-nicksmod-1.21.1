package com.nickkick.nicksmod.player;

import com.google.common.collect.ImmutableMap;
import com.nickkick.nicksmod.NicksMod;
import com.nickkick.nicksmod.data_map.ModDataMapTypes;
import net.minecraft.world.entity.player.Player;
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

    public static final int AREA_MINING_COST = 500;
    public static final int XP_MINING_COST = 10000;
    public static final int BURIED_TREASURES_TWO_MINING_COST = 100000;
    public static final int REPLANT_CHOPPING_COST = 500;
    public static final int FELLER_CHOPPING_COST = 1000;
    public static final int AREA_DIGGING_COST = 500;
    public static final int BURIED_TREASURES_ONE_DIGGING_COST = 10000;
    public static final int BURIED_TREASURES_TWO_DIGGING_COST = 100000;
    public static final int WEAKNESS_SWORDS_COST = 500;
    public static final int WITHER_SWORDS_COST = 1500;
    public static final int BLINDNESS_SWORDS_COST = 5000;
    public static final int JUMP_AXES_COST = 500;
    public static final int REGENERATION_AXES_COST = 1500;
    public static final int INVISIBILITY_AXES_COST = 5000;
    public static final int SLOW_UNARMED_COST = 500;
    public static final int POISON_UNARMED_COST = 1500;
    public static final int LIGHTNING_UNARMED_COST = 10000;

    public static final Supplier<AttachmentType<ModDataMapTypes.BonusData>> AREA_MINING_BONUS = ATTACHMENT_TYPES.register(
            "area_mining_bonus", () -> AttachmentType.builder(() -> new ModDataMapTypes.BonusData("area_mining_bonus", "mining", AREA_MINING_COST, false))
                    .serialize(ModDataMapTypes.BonusData.CODEC)
                    .build()
    );
    public static final Supplier<AttachmentType<ModDataMapTypes.BonusData>> XP_MINING_BONUS = ATTACHMENT_TYPES.register(
            "xp_mining_bonus", () -> AttachmentType.builder(() -> new ModDataMapTypes.BonusData("xp_mining_bonus", "mining", XP_MINING_COST, false))
                    .serialize(ModDataMapTypes.BonusData.CODEC)
                    .build()
    );
    public static final Supplier<AttachmentType<ModDataMapTypes.BonusData>> BURIED_TREASURES_TWO_MINING_BONUS = ATTACHMENT_TYPES.register(
            "buried_treasures_two_mining_bonus", () -> AttachmentType.builder(() -> new ModDataMapTypes.BonusData("buried_treasures_two_mining_bonus", "mining", BURIED_TREASURES_TWO_MINING_COST, false))
                    .serialize(ModDataMapTypes.BonusData.CODEC)
                    .build()
    );

    public static final Supplier<AttachmentType<ModDataMapTypes.BonusData>> REPLANT_CHOPPING_BONUS = ATTACHMENT_TYPES.register(
            "replant_chopping_bonus", () -> AttachmentType.builder(() -> new ModDataMapTypes.BonusData("replant_chopping_bonus", "chopping", REPLANT_CHOPPING_COST, false))
                    .serialize(ModDataMapTypes.BonusData.CODEC)
                    .build()
    );
    public static final Supplier<AttachmentType<ModDataMapTypes.BonusData>> FELLER_CHOPPING_BONUS = ATTACHMENT_TYPES.register(
            "feller_chopping_bonus", () -> AttachmentType.builder(() -> new ModDataMapTypes.BonusData("feller_chopping_bonus", "chopping", FELLER_CHOPPING_COST, false))
                    .serialize(ModDataMapTypes.BonusData.CODEC)
                    .build()
    );

    public static final Supplier<AttachmentType<ModDataMapTypes.BonusData>> AREA_DIGGING_BONUS = ATTACHMENT_TYPES.register(
            "area_digging_bonus", () -> AttachmentType.builder(() -> new ModDataMapTypes.BonusData("area_digging_bonus", "digging", AREA_DIGGING_COST, false))
                    .serialize(ModDataMapTypes.BonusData.CODEC)
                    .build()
    );
    public static final Supplier<AttachmentType<ModDataMapTypes.BonusData>> BURIED_TREASURES_ONE_DIGGING_BONUS = ATTACHMENT_TYPES.register(
            "buried_treasures_one_digging_bonus", () -> AttachmentType.builder(() -> new ModDataMapTypes.BonusData("buried_treasures_one_digging_bonus", "digging", BURIED_TREASURES_ONE_DIGGING_COST, false))
                    .serialize(ModDataMapTypes.BonusData.CODEC)
                    .build()
    );
    public static final Supplier<AttachmentType<ModDataMapTypes.BonusData>> BURIED_TREASURES_TWO_DIGGING_BONUS = ATTACHMENT_TYPES.register(
            "buried_treasures_two_digging_bonus", () -> AttachmentType.builder(() -> new ModDataMapTypes.BonusData("buried_treasures_two_digging_bonus", "digging", BURIED_TREASURES_TWO_DIGGING_COST, false))
                    .serialize(ModDataMapTypes.BonusData.CODEC)
                    .build()
    );

    public static final Supplier<AttachmentType<ModDataMapTypes.BonusData>> WEAKNESS_SWORDS_BONUS = ATTACHMENT_TYPES.register(
            "weakness_swords_bonus", () -> AttachmentType.builder(() -> new ModDataMapTypes.BonusData("weakness_swords_bonus", "swords", WEAKNESS_SWORDS_COST, false))
                    .serialize(ModDataMapTypes.BonusData.CODEC)
                    .build()
    );
    public static final Supplier<AttachmentType<ModDataMapTypes.BonusData>> WITHER_SWORDS_BONUS = ATTACHMENT_TYPES.register(
            "wither_swords_bonus", () -> AttachmentType.builder(() -> new ModDataMapTypes.BonusData("wither_swords_bonus", "swords", WITHER_SWORDS_COST, false))
                    .serialize(ModDataMapTypes.BonusData.CODEC)
                    .build()
    );
    public static final Supplier<AttachmentType<ModDataMapTypes.BonusData>> BLINDNESS_SWORDS_BONUS = ATTACHMENT_TYPES.register(
            "blindness_swords_bonus", () -> AttachmentType.builder(() -> new ModDataMapTypes.BonusData("blindness_swords_bonus", "swords", BLINDNESS_SWORDS_COST, false))
                    .serialize(ModDataMapTypes.BonusData.CODEC)
                    .build()
    );

    public static final Supplier<AttachmentType<ModDataMapTypes.BonusData>> JUMP_AXES_BONUS = ATTACHMENT_TYPES.register(
            "jump_axes_bonus", () -> AttachmentType.builder(() -> new ModDataMapTypes.BonusData("jump_axes_bonus", "axes", JUMP_AXES_COST, false))
                    .serialize(ModDataMapTypes.BonusData.CODEC)
                    .build()
    );
    public static final Supplier<AttachmentType<ModDataMapTypes.BonusData>> REGENERATION_AXES_BONUS = ATTACHMENT_TYPES.register(
            "regeneration_axes_bonus", () -> AttachmentType.builder(() -> new ModDataMapTypes.BonusData("regeneration_axes_bonus", "axes", REGENERATION_AXES_COST, false))
                    .serialize(ModDataMapTypes.BonusData.CODEC)
                    .build()
    );
    public static final Supplier<AttachmentType<ModDataMapTypes.BonusData>> INVISIBILITY_AXES_BONUS = ATTACHMENT_TYPES.register(
            "invisibility_axes_bonus", () -> AttachmentType.builder(() -> new ModDataMapTypes.BonusData("invisibility_axes_bonus", "axes", INVISIBILITY_AXES_COST, false))
                    .serialize(ModDataMapTypes.BonusData.CODEC)
                    .build()
    );

    public static final Supplier<AttachmentType<ModDataMapTypes.BonusData>> SLOW_UNARMED_BONUS = ATTACHMENT_TYPES.register(
            "slow_unarmed_bonus", () -> AttachmentType.builder(() -> new ModDataMapTypes.BonusData("slow_unarmed_bonus", "unarmed", SLOW_UNARMED_COST, false))
                    .serialize(ModDataMapTypes.BonusData.CODEC)
                    .build()
    );
    public static final Supplier<AttachmentType<ModDataMapTypes.BonusData>> POISON_UNARMED_BONUS = ATTACHMENT_TYPES.register(
            "poison_unarmed_bonus", () -> AttachmentType.builder(() -> new ModDataMapTypes.BonusData("poison_unarmed_bonus", "unarmed", POISON_UNARMED_COST, false))
                    .serialize(ModDataMapTypes.BonusData.CODEC)
                    .build()
    );
    public static final Supplier<AttachmentType<ModDataMapTypes.BonusData>> LIGHTNING_UNARMED_BONUS = ATTACHMENT_TYPES.register(
            "lightning_unarmed_bonus", () -> AttachmentType.builder(() -> new ModDataMapTypes.BonusData("lightning_unarmed_bonus", "unarmed", LIGHTNING_UNARMED_COST, false))
                    .serialize(ModDataMapTypes.BonusData.CODEC)
                    .build()
    );

    public static final Map<String, Supplier<AttachmentType<ModDataMapTypes.BonusData>>> BONUS_NAMES =
            (new ImmutableMap.Builder<String, Supplier<AttachmentType<ModDataMapTypes.BonusData>>>())
                    .put("area_mining_bonus", ModPlayerData.AREA_MINING_BONUS)
                    .put("xp_mining_bonus", ModPlayerData.XP_MINING_BONUS)
                    .put("buried_treasures_two_mining_bonus", ModPlayerData.BURIED_TREASURES_TWO_MINING_BONUS)
                    .put("feller_chopping_bonus", ModPlayerData.FELLER_CHOPPING_BONUS)
                    .put("replant_chopping_bonus", ModPlayerData.REPLANT_CHOPPING_BONUS)
                    .put("area_digging_bonus", ModPlayerData.AREA_DIGGING_BONUS)
                    .put("buried_treasures_one_digging_bonus", ModPlayerData.BURIED_TREASURES_ONE_DIGGING_BONUS)
                    .put("buried_treasures_two_digging_bonus", ModPlayerData.BURIED_TREASURES_TWO_DIGGING_BONUS)
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

    public static boolean check(Player player, AttachmentType<ModDataMapTypes.BonusData> bonusDataAttachmentType) {
        ModDataMapTypes.BonusData checkBonus = player.getData(bonusDataAttachmentType);
        return checkBonus.has();
    }

    public static void register(IEventBus eventBus) {
        ATTACHMENT_TYPES.register(eventBus);
    }
}
