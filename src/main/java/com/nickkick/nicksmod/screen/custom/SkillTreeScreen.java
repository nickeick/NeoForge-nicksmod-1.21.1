package com.nickkick.nicksmod.screen.custom;

import com.mojang.blaze3d.systems.RenderSystem;
import com.nickkick.nicksmod.NicksMod;
import com.nickkick.nicksmod.data_map.ModDataMapTypes;
import com.nickkick.nicksmod.player.ModPlayerData;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.AbstractButton;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.narration.NarrationElementOutput;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.network.PacketDistributor;

import java.util.*;
import java.util.function.Supplier;

public class SkillTreeScreen extends AbstractContainerScreen<SkillTreeMenu> {
    private static final ResourceLocation GUI_TEXTURE =
            ResourceLocation.fromNamespaceAndPath(NicksMod.MOD_ID, "textures/gui/skill_tree/skill_tree_gui.png");
    private static final ResourceLocation XP_BAR_TEXTURE =
            ResourceLocation.fromNamespaceAndPath(NicksMod.MOD_ID, "textures/gui/skill_tree/xp_bar.png");
    private final Player player;
    private int offsetX;
    private int offsetY;
    private int currentTab = 0;

    public SkillTreeScreen(SkillTreeMenu menu, Inventory playerInventory, Component title) {
        super(menu, playerInventory, title);
        this.inventoryLabelX = 99999;
        this.inventoryLabelY = 99999;
        this.player = playerInventory.player;
        //this.offsetX = (width - imageWidth)/2;
        //this.offsetY = (height - imageHeight) / 2;
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float pPartialTick, int pMouseX, int pMouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, GUI_TEXTURE);
        RenderSystem.setShaderTexture(0, XP_BAR_TEXTURE);

        this.offsetX = (width - imageWidth) / 2;
        this.offsetY = (height - imageHeight) / 2;

        int xp_x = this.offsetX + 26;
        int xp_y = this.offsetY + 18;

        guiGraphics.blit(GUI_TEXTURE, this.offsetX, this.offsetY, 0, 0, imageWidth, imageHeight);
        //guiGraphics.blit(XP_BAR_TEXTURE, xp_x, xp_y, 0, 0, imageWidth, imageHeight);
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        super.render(guiGraphics, mouseX, mouseY, partialTick);
        this.renderTooltip(guiGraphics, mouseX, mouseY);
        this.addRenderableWidget(new SkillTreeCloseButton(this.offsetX + imageWidth / 2 - 50, this.offsetY + imageHeight - 25));
        int iter = 0;
        for (Map.Entry<String, Supplier<AttachmentType<ModDataMapTypes.SkillData>>> entry : ModPlayerData.SKILL_NAMES.entrySet()) {
            int finalIter = iter;
            this.addRenderableWidget(Button.builder(Component.literal(entry.getKey().toUpperCase()), btn -> {
                this.clearWidgets();
                currentTab = finalIter;
            }).pos(this.leftPos - 55, this.topPos + iter*25).size(50, 20).build());
            iter = iter + 1;
        }
        LinkedHashMap<List<String>, Integer> page = new LinkedHashMap<>();
        if (currentTab == 0) {
            page.put(List.of("3x3 Mining", "area_mining_bonus"), 10);
            page.put(List.of("Double Mining XP", "xp_mining_bonus"), 20);
        } else if (currentTab == 1) {
            page.put(List.of("Tree Feller", "feller_chopping_bonus"), 10);
        } else if (currentTab == 2) {
            page.put(List.of("3x3 Digging", "area_digging_bonus"), 10);
        } else if (currentTab == 3) {
            page.put(List.of("Swords Bonus", "empty_swords_bonus"), 10);
        } else if (currentTab == 4) {
            page.put(List.of("Axes Bonus", "empty_axes_bonus"), 10);
        } else if (currentTab == 5) {
            page.put(List.of("Slowing Strike", "slow_unarmed_bonus"), 10);
            page.put(List.of("Poison Punch", "poison_unarmed_bonus"), 20);
            page.put(List.of("The Hand of God", "lightning_unarmed_bonus"), 30);
        }
        renderPage(page);
    }

    private void renderPage(LinkedHashMap<List<String>, Integer> pages) {
        int length = 40;
        for (List<String> page: pages.keySet()) {
            this.addRenderableWidget(new SkillTreeBonusButton(this.offsetX + imageWidth / 2 - 50, this.offsetY + length, page.getFirst(), page.get(1), pages.get(page)));
            length = length + 30;
        }
    }

    @Override
    protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
        super.renderLabels(guiGraphics, mouseX, mouseY);

        Component text = Component.literal("");
        if (currentTab == 0) {
            ModDataMapTypes.SkillData data = this.player.getData(ModPlayerData.MINING_SKILL.get());
            text = Component.literal("Your Mining Skill is " + data.skill());
        } else if (currentTab == 1) {
            ModDataMapTypes.SkillData data = this.player.getData(ModPlayerData.CHOPPING_SKILL.get());
            text = Component.literal("Your Chopping Skill is " + data.skill());
        } else if (currentTab == 2) {
            ModDataMapTypes.SkillData data = this.player.getData(ModPlayerData.DIGGING_SKILL.get());
            text = Component.literal("Your Digging Skill is " + data.skill());
        } else if (currentTab == 3) {
            ModDataMapTypes.SkillData data = this.player.getData(ModPlayerData.SWORDS_SKILL.get());
            text = Component.literal("Your Swords Skill is " + data.skill());
        } else if (currentTab == 4) {
            ModDataMapTypes.SkillData data = this.player.getData(ModPlayerData.AXES_SKILL.get());
            text = Component.literal("Your Axes Skill is " + data.skill());
        } else if (currentTab == 5) {
            ModDataMapTypes.SkillData data = this.player.getData(ModPlayerData.UNARMED_SKILL.get());
            text = Component.literal("Your Unarmed Skill is " + data.skill());
        }
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
        private final int cost;
        private final AttachmentType<ModDataMapTypes.SkillData> skill;
        private final AttachmentType<ModDataMapTypes.BonusData> bonus;
        private final String skillName;
        private final String bonusName;

        public SkillTreeBonusButton(int x, int y, String buttonName, String bonusName, int cost) {
            super(x, y, 100, 20, Component.literal(buttonName + ": " + cost));
            this.bonus = ModPlayerData.BONUS_NAMES.get(bonusName).get();
            this.skillName = SkillTreeScreen.this.player.getData(this.bonus).skill();
            this.skill = ModPlayerData.SKILL_NAMES.get(this.skillName).get();
            this.bonusName = bonusName;
            this.cost = SkillTreeScreen.this.player.getData(this.bonus).cost();
        }

        @Override
        protected void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
            if (SkillTreeScreen.this.player.hasData(bonus)) {
                this.active = (!SkillTreeScreen.this.player.getData(bonus).has() && SkillTreeScreen.this.player.getData(this.skill).skill() >= this.cost);
                if (SkillTreeScreen.this.player.getData(this.skill).skill() < this.cost) {
                    this.setFGColor(16711680);  // Red 255
                }
                if (SkillTreeScreen.this.player.hasData(bonus) && SkillTreeScreen.this.player.getData(bonus).has()) {
                    this.setFGColor(65280);  // Green 255
                }
            }
            super.renderWidget(guiGraphics, mouseX, mouseY, partialTick);
        }

        @Override
        public void onPress() {
            ModDataMapTypes.SkillData skillData = SkillTreeScreen.this.player.getData(this.skill);
            // If the player has the skill cost and doesn't have the bonus already
            if (skillData.skill() >= this.cost && !SkillTreeScreen.this.player.getData(this.bonus).has()) {
                PacketDistributor.sendToServer(new ModDataMapTypes.BonusData(this.bonusName, this.skillName, this.cost, true));
                this.clearFGColor();
            }
        }

        @Override
        protected void updateWidgetNarration(NarrationElementOutput narrationElementOutput) {}
    }
}
