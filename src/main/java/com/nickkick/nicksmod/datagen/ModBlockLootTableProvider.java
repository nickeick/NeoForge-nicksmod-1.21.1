package com.nickkick.nicksmod.datagen;

import com.nickkick.nicksmod.block.ModBlocks;
import com.nickkick.nicksmod.block.custom.TomatoCropBlock;
import com.nickkick.nicksmod.item.ModItems;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.neoforged.fml.common.Mod;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {

    protected ModBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.BISMUTH_BLOCK.get());
        dropSelf(ModBlocks.MAGIC_BLOCK.get());
        dropSelf(ModBlocks.HOT_DOG_BLOCK.get());

        add(ModBlocks.BISMUTH_ORE.get(),
                block -> createOreDrop(ModBlocks.BISMUTH_ORE.get(), ModItems.RAW_BISMUTH.get()));
        add(ModBlocks.BISMUTH_DEEPSLATE_ORE.get(),
                block -> createMultipleOreDrops(ModBlocks.BISMUTH_DEEPSLATE_ORE.get(), ModItems.RAW_BISMUTH.get(), 2, 5));

        dropSelf(ModBlocks.HOT_DOG_STAIRS.get());
        add(ModBlocks.HOT_DOG_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.HOT_DOG_SLAB.get()));

        dropSelf(ModBlocks.HOT_DOG_PRESSURE_PLATE.get());
        dropSelf(ModBlocks.HOT_DOG_BUTTON.get());
        dropSelf(ModBlocks.HOT_DOG_FENCE.get());
        dropSelf(ModBlocks.HOT_DOG_FENCE_GATE.get());
        dropSelf(ModBlocks.HOT_DOG_WALL.get());
        dropSelf(ModBlocks.HOT_DOG_TRAPDOOR.get());

        add(ModBlocks.HOT_DOG_DOOR.get(),
                block -> createDoorTable(ModBlocks.HOT_DOG_DOOR.get()));

        dropSelf(ModBlocks.HOT_DOG_LAMP.get());

        dropSelf(ModBlocks.PIZZA_BLOCK.get());

        LootItemCondition.Builder lootItemConditionBuilderTomato = LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.TOMATO_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(TomatoCropBlock.AGE, 3));

        this.add(ModBlocks.TOMATO_CROP.get(), this.createCropDrops(ModBlocks.TOMATO_CROP.get(),
                ModItems.TOMATO.get(), ModItems.TOMATO_SEEDS.get(), lootItemConditionBuilderTomato));

        LootItemCondition.Builder lootItemConditionBuilderMustard = LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.MUSTARD_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(TomatoCropBlock.AGE, 3));

        this.add(ModBlocks.MUSTARD_CROP.get(), this.createCropDrops(ModBlocks.MUSTARD_CROP.get(),
                ModItems.MUSTARD_SEEDS.get(), ModItems.MUSTARD_SEEDS.get(), lootItemConditionBuilderMustard));
    }

    protected LootTable.Builder createMultipleOreDrops(Block pBlock, Item item, float minDrops, float maxDrops) {
        HolderLookup.RegistryLookup<Enchantment> registryLookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock, LootItem.lootTableItem(item)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops)))
                        .apply(ApplyBonusCount.addOreBonusCount(registryLookup.getOrThrow(Enchantments.FORTUNE)))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
