package com.nickkick.nicksmod.block.entity;

import com.nickkick.nicksmod.NicksMod;
import com.nickkick.nicksmod.block.ModBlocks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, NicksMod.MOD_ID);

    public static final Supplier<BlockEntityType<SkillTreeBlockEntity>> SKILL_TREE_BE =
            BLOCK_ENTITIES.register("skill_tree_be", () -> BlockEntityType.Builder.of(
                    SkillTreeBlockEntity::new, ModBlocks.SKILL_TREE_BLOCK.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
