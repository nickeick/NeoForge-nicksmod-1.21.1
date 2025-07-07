package com.nickkick.nicksmod.item.custom;

import com.nickkick.nicksmod.component.ModDataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;

public class SkillStaffItem extends Item {
    public SkillStaffItem(Properties properties) {
        super(properties);
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        tooltipComponents.add(Component.literal("Mined Blocks: " + stack.get(ModDataComponents.MINED_BLOCKS)));
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
}
