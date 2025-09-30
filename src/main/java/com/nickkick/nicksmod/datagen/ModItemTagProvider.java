package com.nickkick.nicksmod.datagen;

import com.nickkick.nicksmod.NicksMod;
import com.nickkick.nicksmod.item.ModItems;
import com.nickkick.nicksmod.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {

    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, NicksMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(ModTags.Items.STAT_TRACKABLE_ITEMS)
                .add(ModItems.SKILL_STAFF.get());

        this.tag(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.PIZZA_HELMET.get())
                .add(ModItems.PIZZA_CHESTPLATE.get())
                .add(ModItems.PIZZA_LEGGINGS.get())
                .add(ModItems.PIZZA_BOOTS.get());
    }
}
