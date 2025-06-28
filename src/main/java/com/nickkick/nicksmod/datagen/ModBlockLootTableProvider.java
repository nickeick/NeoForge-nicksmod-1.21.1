package com.nickkick.nicksmod.datagen;

import com.nickkick.nicksmod.block.ModBlocks;
import com.nickkick.nicksmod.block.custom.TomatoCropBlock;
import com.nickkick.nicksmod.item.ModItems;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
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

        add(ModBlocks.ZIRCON_ORE.get(),
                block -> createOreDrop(ModBlocks.ZIRCON_ORE.get(), ModItems.ZIRCON.get()));
        dropSelf(ModBlocks.SKILL_TREE_BLOCK.get());

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

        dropSelf(ModBlocks.WHITE_BRICKS.get());
        dropSelf(ModBlocks.LIGHT_GRAY_BRICKS.get());
        dropSelf(ModBlocks.GRAY_BRICKS.get());
        dropSelf(ModBlocks.BLACK_BRICKS.get());
        dropSelf(ModBlocks.BROWN_BRICKS.get());
        dropSelf(ModBlocks.RED_BRICKS.get());
        dropSelf(ModBlocks.ORANGE_BRICKS.get());
        dropSelf(ModBlocks.YELLOW_BRICKS.get());
        dropSelf(ModBlocks.LIME_BRICKS.get());
        dropSelf(ModBlocks.GREEN_BRICKS.get());
        dropSelf(ModBlocks.CYAN_BRICKS.get());
        dropSelf(ModBlocks.LIGHT_BLUE_BRICKS.get());
        dropSelf(ModBlocks.BLUE_BRICKS.get());
        dropSelf(ModBlocks.PURPLE_BRICKS.get());
        dropSelf(ModBlocks.MAGENTA_BRICKS.get());
        dropSelf(ModBlocks.PINK_BRICKS.get());

        dropSelf(ModBlocks.WHITE_BRICKS_SLAB.get());
        dropSelf(ModBlocks.LIGHT_GRAY_BRICKS_SLAB.get());
        dropSelf(ModBlocks.GRAY_BRICKS_SLAB.get());
        dropSelf(ModBlocks.BLACK_BRICKS_SLAB.get());
        dropSelf(ModBlocks.BROWN_BRICKS_SLAB.get());
        dropSelf(ModBlocks.RED_BRICKS_SLAB.get());
        dropSelf(ModBlocks.ORANGE_BRICKS_SLAB.get());
        dropSelf(ModBlocks.YELLOW_BRICKS_SLAB.get());
        dropSelf(ModBlocks.LIME_BRICKS_SLAB.get());
        dropSelf(ModBlocks.GREEN_BRICKS_SLAB.get());
        dropSelf(ModBlocks.CYAN_BRICKS_SLAB.get());
        dropSelf(ModBlocks.LIGHT_BLUE_BRICKS_SLAB.get());
        dropSelf(ModBlocks.BLUE_BRICKS_SLAB.get());
        dropSelf(ModBlocks.PURPLE_BRICKS_SLAB.get());
        dropSelf(ModBlocks.MAGENTA_BRICKS_SLAB.get());
        dropSelf(ModBlocks.PINK_BRICKS_SLAB.get());

        dropSelf(ModBlocks.WHITE_BRICKS_STAIRS.get());
        dropSelf(ModBlocks.LIGHT_GRAY_BRICKS_STAIRS.get());
        dropSelf(ModBlocks.GRAY_BRICKS_STAIRS.get());
        dropSelf(ModBlocks.BLACK_BRICKS_STAIRS.get());
        dropSelf(ModBlocks.BROWN_BRICKS_STAIRS.get());
        dropSelf(ModBlocks.RED_BRICKS_STAIRS.get());
        dropSelf(ModBlocks.ORANGE_BRICKS_STAIRS.get());
        dropSelf(ModBlocks.YELLOW_BRICKS_STAIRS.get());
        dropSelf(ModBlocks.LIME_BRICKS_STAIRS.get());
        dropSelf(ModBlocks.GREEN_BRICKS_STAIRS.get());
        dropSelf(ModBlocks.CYAN_BRICKS_STAIRS.get());
        dropSelf(ModBlocks.LIGHT_BLUE_BRICKS_STAIRS.get());
        dropSelf(ModBlocks.BLUE_BRICKS_STAIRS.get());
        dropSelf(ModBlocks.PURPLE_BRICKS_STAIRS.get());
        dropSelf(ModBlocks.MAGENTA_BRICKS_STAIRS.get());
        dropSelf(ModBlocks.PINK_BRICKS_STAIRS.get());

        dropSelf(ModBlocks.WHITE_BRICKS_WALL.get());
        dropSelf(ModBlocks.LIGHT_GRAY_BRICKS_WALL.get());
        dropSelf(ModBlocks.GRAY_BRICKS_WALL.get());
        dropSelf(ModBlocks.BLACK_BRICKS_WALL.get());
        dropSelf(ModBlocks.BROWN_BRICKS_WALL.get());
        dropSelf(ModBlocks.RED_BRICKS_WALL.get());
        dropSelf(ModBlocks.ORANGE_BRICKS_WALL.get());
        dropSelf(ModBlocks.YELLOW_BRICKS_WALL.get());
        dropSelf(ModBlocks.LIME_BRICKS_WALL.get());
        dropSelf(ModBlocks.GREEN_BRICKS_WALL.get());
        dropSelf(ModBlocks.CYAN_BRICKS_WALL.get());
        dropSelf(ModBlocks.LIGHT_BLUE_BRICKS_WALL.get());
        dropSelf(ModBlocks.BLUE_BRICKS_WALL.get());
        dropSelf(ModBlocks.PURPLE_BRICKS_WALL.get());
        dropSelf(ModBlocks.MAGENTA_BRICKS_WALL.get());
        dropSelf(ModBlocks.PINK_BRICKS_WALL.get());
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
