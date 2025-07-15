package com.nickkick.nicksmod.item.custom;

import com.nickkick.nicksmod.component.ModDataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;

public class SkillStaffItem extends Item {
    public SkillStaffItem(Properties properties) {
        super(properties
                .component(ModDataComponents.MINED_BLOCKS, 0)
                .component(ModDataComponents.CHOPPED_BLOCKS, 0)
                .component(ModDataComponents.DUG_BLOCKS, 0)
                .component(ModDataComponents.SWORD_ATTACKS, 0)
                .component(ModDataComponents.AXE_ATTACKS, 0)
                .component(ModDataComponents.UNARMED_ATTACKS, 0));
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        tooltipComponents.add(Component.literal("Mined Blocks: " + stack.get(ModDataComponents.MINED_BLOCKS)));
        tooltipComponents.add(Component.literal("Chopped Blocks: " + stack.get(ModDataComponents.CHOPPED_BLOCKS)));
        tooltipComponents.add(Component.literal("Dug Blocks: " + stack.get(ModDataComponents.DUG_BLOCKS)));
        tooltipComponents.add(Component.literal("Sword Attacks: " + stack.get(ModDataComponents.SWORD_ATTACKS)));
        tooltipComponents.add(Component.literal("Axe Attacks: " + stack.get(ModDataComponents.AXE_ATTACKS)));
        tooltipComponents.add(Component.literal("Unarmed Attacks: " + stack.get(ModDataComponents.UNARMED_ATTACKS)));
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
}
