package com.nickkick.nicksmod.player;

import com.nickkick.nicksmod.NicksMod;
import com.nickkick.nicksmod.data_map.ModDataMapTypes;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import javax.naming.LinkLoopException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.function.Supplier;


public class ModPlayerData {
    // Create the DeferredRegister for attachment types
    private static final DeferredRegister<AttachmentType<?>> ATTACHMENT_TYPES = DeferredRegister.create(NeoForgeRegistries.ATTACHMENT_TYPES, NicksMod.MOD_ID);

    public static final LinkedHashMap<String, Supplier<AttachmentType<ModDataMapTypes.SkillData>>> SKILL_NAMES = new LinkedHashMap<>();

    public static final Supplier<AttachmentType<ModDataMapTypes.SkillData>> MINING_SKILL = registerSkill("mining");
    public static final Supplier<AttachmentType<ModDataMapTypes.SkillData>> CHOPPING_SKILL = registerSkill("chopping");
    public static final Supplier<AttachmentType<ModDataMapTypes.SkillData>> SWORDS_SKILL = registerSkill("swords");
    public static final Supplier<AttachmentType<ModDataMapTypes.SkillData>> DIGGING_SKILL = registerSkill("digging");
    public static final Supplier<AttachmentType<ModDataMapTypes.SkillData>> AXES_SKILL = registerSkill("axes");
    public static final Supplier<AttachmentType<ModDataMapTypes.SkillData>> UNARMED_SKILL = registerSkill("unarmed");

    public static Supplier<AttachmentType<ModDataMapTypes.SkillData>> registerSkill(String name) {
        Supplier<AttachmentType<ModDataMapTypes.SkillData>> skill = ATTACHMENT_TYPES.register(
                name + "_skill", () -> AttachmentType.builder(() -> new ModDataMapTypes.SkillData(name,0))
                        .serialize(ModDataMapTypes.SkillData.CODEC)
                        .copyOnDeath()
                        .build()
        );
        SKILL_NAMES.put(name, skill);
        // To add to Map
        return skill;
    }

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

    public static final LinkedHashMap<String, Supplier<AttachmentType<ModDataMapTypes.BonusData>>> BONUS_NAMES = new LinkedHashMap<>();

    public static final BonusTree MINING_TREE = new BonusTree("mining", new ArrayList<>());
    public static final BonusTree CHOPPING_TREE = new BonusTree("chopping", new ArrayList<>());
    public static final BonusTree DIGGING_TREE = new BonusTree("digging", new ArrayList<>());
    public static final BonusTree SWORDS_TREE = new BonusTree("swords", new ArrayList<>());
    public static final BonusTree AXES_TREE = new BonusTree("axes", new ArrayList<>());
    public static final BonusTree UNARMED_TREE = new BonusTree("unarmed", new ArrayList<>());

    public static BonusNode makeBonus(String name, String skill, int cost) {
        String bonus_name = name + "_" + skill + "_bonus";
        ModDataMapTypes.BonusData bonus = new ModDataMapTypes.BonusData(bonus_name, skill, cost, false);
        return new BonusNode(bonus);
    }

    public static final BonusNode AREA_MINING_NODE = makeBonus("area", "mining", AREA_MINING_COST);
    public static final BonusNode XP_MINING_NODE = makeBonus("xp", "mining", XP_MINING_COST);
    public static final BonusNode BURIED_TREASURES_TWO_MINING_NODE = makeBonus("buried_treasures_two", "mining", BURIED_TREASURES_TWO_MINING_COST);
    public static final BonusNode REPLANT_CHOPPING_NODE = makeBonus("replant", "chopping", REPLANT_CHOPPING_COST);
    public static final BonusNode FELLER_CHOPPING_NODE = makeBonus("feller", "chopping", FELLER_CHOPPING_COST);
    public static final BonusNode AREA_DIGGING_NODE = makeBonus("area", "digging", AREA_DIGGING_COST);
    public static final BonusNode BURIED_TREASURES_ONE_DIGGING_NODE = makeBonus("buried_treasures_one", "digging", BURIED_TREASURES_ONE_DIGGING_COST);
    public static final BonusNode BURIED_TREASURES_TWO_DIGGING_NODE = makeBonus("buried_treasures_two", "digging", BURIED_TREASURES_TWO_DIGGING_COST);
    public static final BonusNode WEAKNESS_SWORDS_NODE = makeBonus("weakness", "swords", WEAKNESS_SWORDS_COST);
    public static final BonusNode WITHER_SWORDS_NODE = makeBonus("wither", "swords", WITHER_SWORDS_COST);
    public static final BonusNode BLINDNESS_SWORDS_NODE = makeBonus("blindness", "swords", BLINDNESS_SWORDS_COST);
    public static final BonusNode JUMP_AXES_NODE = makeBonus("jump", "axes", JUMP_AXES_COST);
    public static final BonusNode REGENERATION_AXES_NODE = makeBonus("regeneration", "axes", REGENERATION_AXES_COST);
    public static final BonusNode INVISIBILITY_AXES_NODE = makeBonus("invisibility", "axes", INVISIBILITY_AXES_COST);
    public static final BonusNode SLOW_UNARMED_NODE = makeBonus("slow", "unarmed", SLOW_UNARMED_COST);
    public static final BonusNode POISON_UNARMED_NODE = makeBonus("poison", "unarmed", POISON_UNARMED_COST);
    public static final BonusNode LIGHTNING_UNARMED_NODE = makeBonus("lightning", "unarmed", LIGHTNING_UNARMED_COST);

    public static final Supplier<AttachmentType<ModDataMapTypes.BonusData>> AREA_MINING_BONUS;
    public static final Supplier<AttachmentType<ModDataMapTypes.BonusData>> XP_MINING_BONUS;
    public static final Supplier<AttachmentType<ModDataMapTypes.BonusData>> BURIED_TREASURES_TWO_MINING_BONUS;
    public static final Supplier<AttachmentType<ModDataMapTypes.BonusData>> REPLANT_CHOPPING_BONUS;
    public static final Supplier<AttachmentType<ModDataMapTypes.BonusData>> FELLER_CHOPPING_BONUS;
    public static final Supplier<AttachmentType<ModDataMapTypes.BonusData>> AREA_DIGGING_BONUS;
    public static final Supplier<AttachmentType<ModDataMapTypes.BonusData>> BURIED_TREASURES_ONE_DIGGING_BONUS;
    public static final Supplier<AttachmentType<ModDataMapTypes.BonusData>> BURIED_TREASURES_TWO_DIGGING_BONUS;
    public static final Supplier<AttachmentType<ModDataMapTypes.BonusData>> WEAKNESS_SWORDS_BONUS;
    public static final Supplier<AttachmentType<ModDataMapTypes.BonusData>> WITHER_SWORDS_BONUS;
    public static final Supplier<AttachmentType<ModDataMapTypes.BonusData>> BLINDNESS_SWORDS_BONUS;
    public static final Supplier<AttachmentType<ModDataMapTypes.BonusData>> JUMP_AXES_BONUS;
    public static final Supplier<AttachmentType<ModDataMapTypes.BonusData>> REGENERATION_AXES_BONUS;
    public static final Supplier<AttachmentType<ModDataMapTypes.BonusData>> INVISIBILITY_AXES_BONUS;
    public static final Supplier<AttachmentType<ModDataMapTypes.BonusData>> SLOW_UNARMED_BONUS;
    public static final Supplier<AttachmentType<ModDataMapTypes.BonusData>> POISON_UNARMED_BONUS;
    public static final Supplier<AttachmentType<ModDataMapTypes.BonusData>> LIGHTNING_UNARMED_BONUS;

    static {
        try {
            AREA_MINING_BONUS = registerBonus(AREA_MINING_NODE, List.of(), MINING_TREE);
            XP_MINING_BONUS = registerBonus(XP_MINING_NODE, List.of(AREA_MINING_NODE), MINING_TREE);
            BURIED_TREASURES_TWO_MINING_BONUS = registerBonus(BURIED_TREASURES_TWO_MINING_NODE, List.of(XP_MINING_NODE), MINING_TREE);
            REPLANT_CHOPPING_BONUS = registerBonus(REPLANT_CHOPPING_NODE, List.of(), CHOPPING_TREE);
            FELLER_CHOPPING_BONUS = registerBonus(FELLER_CHOPPING_NODE, List.of(REPLANT_CHOPPING_NODE), CHOPPING_TREE);
            AREA_DIGGING_BONUS = registerBonus(AREA_DIGGING_NODE, List.of(), DIGGING_TREE);
            BURIED_TREASURES_ONE_DIGGING_BONUS = registerBonus(BURIED_TREASURES_ONE_DIGGING_NODE, List.of(AREA_DIGGING_NODE), DIGGING_TREE);
            BURIED_TREASURES_TWO_DIGGING_BONUS = registerBonus(BURIED_TREASURES_TWO_DIGGING_NODE, List.of(BURIED_TREASURES_ONE_DIGGING_NODE), DIGGING_TREE);
            WEAKNESS_SWORDS_BONUS = registerBonus(WEAKNESS_SWORDS_NODE, List.of(), SWORDS_TREE);
            WITHER_SWORDS_BONUS = registerBonus(WITHER_SWORDS_NODE, List.of(WEAKNESS_SWORDS_NODE), SWORDS_TREE);
            BLINDNESS_SWORDS_BONUS = registerBonus(BLINDNESS_SWORDS_NODE, List.of(WITHER_SWORDS_NODE), SWORDS_TREE);
            JUMP_AXES_BONUS = registerBonus(JUMP_AXES_NODE, List.of(), AXES_TREE);
            REGENERATION_AXES_BONUS = registerBonus(REGENERATION_AXES_NODE, List.of(JUMP_AXES_NODE), AXES_TREE);
            INVISIBILITY_AXES_BONUS = registerBonus(INVISIBILITY_AXES_NODE, List.of(REGENERATION_AXES_NODE), AXES_TREE);
            SLOW_UNARMED_BONUS = registerBonus(SLOW_UNARMED_NODE, List.of(), UNARMED_TREE);
            POISON_UNARMED_BONUS = registerBonus(POISON_UNARMED_NODE, List.of(SLOW_UNARMED_NODE), UNARMED_TREE);
            LIGHTNING_UNARMED_BONUS = registerBonus(LIGHTNING_UNARMED_NODE, List.of(POISON_UNARMED_NODE), UNARMED_TREE);
        } catch (LinkLoopException e) {
            throw new RuntimeException(e);
        }
    }

    public static Supplier<AttachmentType<ModDataMapTypes.BonusData>> registerBonus(BonusNode node, List<BonusNode> requirements, BonusTree tree) throws LinkLoopException {
        Supplier<AttachmentType<ModDataMapTypes.BonusData>> bonus_supplier = ATTACHMENT_TYPES.register(
                node.data.name(), () -> AttachmentType.builder(node::getData)
                        .serialize(ModDataMapTypes.BonusData.CODEC)
                        .copyOnDeath()
                        .build()
        );
        BONUS_NAMES.put(node.data.name(), bonus_supplier);
        node.addRequirements(requirements);
        tree.addNode(node);
        return bonus_supplier;
    }

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
