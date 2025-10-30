package com.nickkick.nicksmod.screen.custom;

import com.google.common.collect.ImmutableMap;
import com.mojang.blaze3d.systems.RenderSystem;
import com.nickkick.nicksmod.NicksMod;
import com.nickkick.nicksmod.data_map.ModDataMapTypes;
import com.nickkick.nicksmod.player.BonusNode;
import com.nickkick.nicksmod.player.BonusTree;
import com.nickkick.nicksmod.player.ModPlayerData;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.AbstractButton;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.Tooltip;
import net.minecraft.client.gui.narration.NarrationElementOutput;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.network.PacketDistributor;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Map;

public class SkillTreeScreen extends AbstractContainerScreen<SkillTreeMenu> {
    private static final ResourceLocation GUI_TEXTURE =
            ResourceLocation.fromNamespaceAndPath(NicksMod.MOD_ID, "textures/gui/skill_tree/skill_tree_gui.png");
    private final Player player;
    private int offsetX;
    private int offsetY;
    private int currentTab = 0;
    private final Map<Integer, BonusTree> TAB_TO_TREE = new ImmutableMap.Builder<Integer, BonusTree>()
            .put(0, ModPlayerData.MINING_TREE)
            .put(1, ModPlayerData.CHOPPING_TREE)
            .put(2, ModPlayerData.DIGGING_TREE)
            .put(3, ModPlayerData.SWORDS_TREE)
            .put(4, ModPlayerData.AXES_TREE)
            .put(5, ModPlayerData.UNARMED_TREE)
            .build();

    public SkillTreeScreen(SkillTreeMenu menu, Inventory playerInventory, Component title) {
        super(menu, playerInventory, title);
        this.inventoryLabelX = 99999;
        this.inventoryLabelY = 99999;
        this.player = playerInventory.player;
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float pPartialTick, int pMouseX, int pMouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, GUI_TEXTURE);

        this.offsetX = (width - imageWidth) / 2;
        this.offsetY = (height - imageHeight) / 2;

        guiGraphics.blit(GUI_TEXTURE, this.offsetX, this.offsetY, 0, 0, imageWidth, imageHeight);
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        super.render(guiGraphics, mouseX, mouseY, partialTick);
        this.renderTooltip(guiGraphics, mouseX, mouseY);
        this.addRenderableWidget(new SkillTreeCloseButton(this.offsetX + imageWidth / 2 - 50, this.offsetY + imageHeight - 25));
        int iter = 0;
        for (Map.Entry<Integer, BonusTree> entry : TAB_TO_TREE.entrySet()) {
            int finalIter = iter;
            this.addRenderableWidget(Button.builder(Component.literal(entry.getValue().getName().toUpperCase()), btn -> {
                this.clearWidgets();
                currentTab = finalIter;
            }).pos(this.leftPos - 55, this.topPos + iter*25).size(50, 20).build());
            iter = iter + 1;
        }
        renderPage(TAB_TO_TREE.get(currentTab));
    }

    private void renderPage(BonusTree tree) {
        int length = 40;
        for (BonusNode node : tree.getFullTree()) {
            this.addRenderableWidget(new SkillTreeBonusButton(this.offsetX + imageWidth / 2 - 50, this.offsetY + length + 30 * tree.getNodeDepth(node), node));
        }
    }

    @Override
    protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
        super.renderLabels(guiGraphics, mouseX, mouseY);

        ModDataMapTypes.SkillData data = this.player.getData(ModPlayerData.SKILL_NAMES.get(TAB_TO_TREE.get(currentTab).getName()).get());
        Component text = Component.literal("Your " + data.name().toUpperCase() + " skill is " + data.skill());
        guiGraphics.drawString(this.font, text, imageWidth / 2 - font.width(text)/2, 20, 0, false);
    }

    class SkillTreeCloseButton extends AbstractButton {

        public SkillTreeCloseButton(int x, int y) {
            super(x, y, 100, 20, Component.literal("Close"));
        }

        @Override
        public void onPress() {
            SkillTreeScreen.this.player.closeContainer();
        }

        @Override
        protected void updateWidgetNarration(NarrationElementOutput narrationElementOutput) {}
    }

    class SkillTreeBonusButton extends AbstractButton {
        private final BonusNode node;
        private final int cost;
        private final AttachmentType<ModDataMapTypes.SkillData> skill;
        private final AttachmentType<ModDataMapTypes.BonusData> bonus;
        private final String skillName;
        private final String bonusName;
        private final Boolean required;
        private final List<String> requirementStrings;

        public SkillTreeBonusButton(int x, int y, BonusNode node) {
            super(x, y, 100, 20, Component.literal(Component.translatable("tooltip.nicksmod.bonus." + node.getData().name()).getString() + ": " + node.getData().cost()));
            this.node = node;
            this.bonusName = node.getData().name();
            this.bonus = ModPlayerData.BONUS_NAMES.get(bonusName).get();
            this.skillName = SkillTreeScreen.this.player.getData(this.bonus).skill();
            this.skill = ModPlayerData.SKILL_NAMES.get(this.skillName).get();
            this.cost = SkillTreeScreen.this.player.getData(this.bonus).cost();
            this.requirementStrings = node.getRequirements().stream().map(inst -> inst.getData().name()).toList();
            this.required = node.getRequirements().isEmpty() || node.getRequirements().stream().allMatch(inst -> SkillTreeScreen.this.player.getData(ModPlayerData.BONUS_NAMES.get(inst.getData().name()).get()).has());
            this.setTooltip(null);
        }

        @Override
        public void setTooltip(@Nullable Tooltip tooltip) {
            if (this.node.getRequirements().isEmpty()) {
                super.setTooltip(tooltip);
            } else {
                String requirements = "";
                for (String req : requirementStrings) {
                    requirements = "Required: " + Component.translatable("tooltip.nicksmod.bonus." + req).getString() + "\n";
                }
                super.setTooltip(Tooltip.create(Component.literal(requirements.substring(0, requirements.length() - 1))));
            }
        }

        @Override
        protected void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
            if (SkillTreeScreen.this.player.hasData(bonus)) {
                this.active = (!ModPlayerData.check(SkillTreeScreen.this.player, bonus) && SkillTreeScreen.this.player.getData(this.skill).skill() >= this.cost);
                if (SkillTreeScreen.this.player.getData(this.skill).skill() < this.cost || !this.required) {
                    this.setFGColor(16711680);  // Red 255
                }
                if (SkillTreeScreen.this.player.hasData(bonus) && ModPlayerData.check(SkillTreeScreen.this.player, this.bonus)) {
                    this.setFGColor(65280);  // Green 255
                }
            }
            super.renderWidget(guiGraphics, mouseX, mouseY, partialTick);
        }

        @Override
        public void onPress() {
            ModDataMapTypes.SkillData skillData = SkillTreeScreen.this.player.getData(this.skill);
            // If the player has the skill cost and doesn't have the bonus already
            if (skillData.skill() >= this.cost && !ModPlayerData.check(SkillTreeScreen.this.player, this.bonus) && this.required) {
                PacketDistributor.sendToServer(new ModDataMapTypes.BonusData(this.bonusName, this.skillName, this.cost, true));
                this.clearFGColor();
            }
        }

        @Override
        protected void updateWidgetNarration(NarrationElementOutput narrationElementOutput) {}
    }
}
