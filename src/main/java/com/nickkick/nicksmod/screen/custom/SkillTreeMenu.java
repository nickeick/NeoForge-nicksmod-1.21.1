package com.nickkick.nicksmod.screen.custom;

import com.nickkick.nicksmod.screen.ModMenuTypes;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class SkillTreeMenu extends AbstractContainerMenu {
    private final Level level;
    private final ContainerLevelAccess access;

    public SkillTreeMenu(int containerId, Inventory inv, ContainerLevelAccess access) {
        super(ModMenuTypes.SKILL_TREE_MENU.get(), containerId);
        this.level = inv.player.level();
        this.access = access;
    }

    public SkillTreeMenu(int containerId, Inventory inv, FriendlyByteBuf extraData) {
        this(containerId, inv, ContainerLevelAccess.NULL);
    }

    @Override
    public ItemStack quickMoveStack(Player player, int i) {
        return null;
    }

    @Override
    public boolean stillValid(Player player) {
        return true;
    }
}
