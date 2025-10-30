package com.nickkick.nicksmod.datagen;

import com.nickkick.nicksmod.block.ModBlocks;
import com.nickkick.nicksmod.item.ModItems;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementRequirements;
import net.minecraft.advancements.AdvancementType;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.common.data.AdvancementProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class ModAdvancementProvider extends AdvancementProvider {
    public ModAdvancementProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, existingFileHelper, List.of(new SkillAdvancementGenerator(), new StaffAdvancementGenerator()));
    }

    private static final class SkillAdvancementGenerator implements AdvancementProvider.AdvancementGenerator {
        @Override
        public void generate(HolderLookup.Provider registries, Consumer<AdvancementHolder> saver, ExistingFileHelper existingFileHelper) {
            Advancement.Builder ZirconBuilder = Advancement.Builder.advancement();
            ZirconBuilder.display(
                    new ItemStack(ModItems.ZIRCON.get()),
                    Component.translatable("advancements.nicksmod.zircon_advancement.title"),
                    Component.translatable("advancements.nicksmod.zircon_advancement.description"),
                    null,
                    AdvancementType.GOAL,
                    true,
                    true,
                    false
            );
            ZirconBuilder.addCriterion("pickup_zircon", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ZIRCON.get()));
            ZirconBuilder.requirements(AdvancementRequirements.allOf(List.of("pickup_zircon")));
            ZirconBuilder.save(saver, ResourceLocation.fromNamespaceAndPath("nicksmod", "zircon_advancement"), existingFileHelper);

            Advancement.Builder SkillStaffBuilder = Advancement.Builder.advancement();
            SkillStaffBuilder.parent(ZirconBuilder.build(ResourceLocation.fromNamespaceAndPath("nicksmod", "zircon_advancement")));
            SkillStaffBuilder.display(
                    new ItemStack(ModItems.SKILL_STAFF.get()),
                    Component.translatable("advancements.nicksmod.skill_staff_advancement.title"),
                    Component.translatable("advancements.nicksmod.skill_staff_advancement.description"),
                    null,
                    AdvancementType.GOAL,
                    true,
                    true,
                    false
            );
            SkillStaffBuilder.addCriterion("pickup_skill_staff", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.SKILL_STAFF.get()));
            SkillStaffBuilder.requirements(AdvancementRequirements.allOf(List.of("pickup_skill_staff")));
            SkillStaffBuilder.save(saver, ResourceLocation.fromNamespaceAndPath("nicksmod", "skill_staff_advancement"), existingFileHelper);

            Advancement.Builder SkillTreeBlockBuilder = Advancement.Builder.advancement();
            SkillTreeBlockBuilder.parent(SkillStaffBuilder.build(ResourceLocation.fromNamespaceAndPath("nicksmod", "skill_staff_advancement")));
            SkillTreeBlockBuilder.display(
                    new ItemStack(ModBlocks.SKILL_TREE_BLOCK.get()),
                    Component.translatable("advancements.nicksmod.skill_tree_block_advancement.title"),
                    Component.translatable("advancements.nicksmod.skill_tree_block_advancement.description"),
                    null,
                    AdvancementType.GOAL,
                    true,
                    true,
                    false
            );
            SkillTreeBlockBuilder.addCriterion("pickup_skill_tree_block", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.SKILL_TREE_BLOCK.get()));
            SkillTreeBlockBuilder.requirements(AdvancementRequirements.allOf(List.of("pickup_skill_tree_block")));
            SkillTreeBlockBuilder.save(saver, ResourceLocation.fromNamespaceAndPath("nicksmod", "skill_tree_block_advancement"), existingFileHelper);
        }
    }

    private static final class StaffAdvancementGenerator implements AdvancementProvider.AdvancementGenerator {
        @Override
        public void generate(HolderLookup.Provider registries, Consumer<AdvancementHolder> saver, ExistingFileHelper existingFileHelper) {
        }
    }

    private static final class SkillTreeBlockAdvancementGenerator implements AdvancementProvider.AdvancementGenerator {
        @Override
        public void generate(HolderLookup.Provider registries, Consumer<AdvancementHolder> saver, ExistingFileHelper existingFileHelper) {

        }
    }
}