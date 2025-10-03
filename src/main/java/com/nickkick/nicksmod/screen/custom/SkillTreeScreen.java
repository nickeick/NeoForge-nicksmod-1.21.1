package com.nickkick.nicksmod.screen.custom;

import com.mojang.blaze3d.systems.RenderSystem;
import com.nickkick.nicksmod.NicksMod;
import com.nickkick.nicksmod.data_map.ModDataMapTypes;
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

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
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
            page.put(List.of("area_mining_bonus", "None"), ModPlayerData.AREA_MINING_COST);
            page.put(List.of("xp_mining_bonus", "area_mining_bonus"), ModPlayerData.XP_MINING_COST);
            page.put(List.of("buried_treasures_two_mining_bonus", "xp_mining_bonus"), ModPlayerData.BURIED_TREASURES_TWO_MINING_COST);
        } else if (currentTab == 1) {
            page.put(List.of("replant_chopping_bonus", "None"), ModPlayerData.REPLANT_CHOPPING_COST);
            page.put(List.of("feller_chopping_bonus", "replant_chopping_bonus"), ModPlayerData.FELLER_CHOPPING_COST);
        } else if (currentTab == 2) {
            page.put(List.of("area_digging_bonus", "None"), ModPlayerData.AREA_DIGGING_COST);
            page.put(List.of("buried_treasures_one_digging_bonus", "area_digging_bonus"), ModPlayerData.BURIED_TREASURES_ONE_DIGGING_COST);
            page.put(List.of("buried_treasures_two_digging_bonus", "buried_treasures_one_digging_bonus"), ModPlayerData.BURIED_TREASURES_TWO_DIGGING_COST);
        } else if (currentTab == 3) {
            page.put(List.of("weakness_swords_bonus", "None"), ModPlayerData.WEAKNESS_SWORDS_COST);
            page.put(List.of("wither_swords_bonus", "weakness_swords_bonus"), ModPlayerData.WITHER_SWORDS_COST);
            page.put(List.of("blindness_swords_bonus", "wither_swords_bonus"), ModPlayerData.BLINDNESS_SWORDS_COST);
        } else if (currentTab == 4) {
            page.put(List.of("jump_axes_bonus", "None"), ModPlayerData.JUMP_AXES_COST);
            page.put(List.of("regeneration_axes_bonus", "jump_axes_bonus"), ModPlayerData.REGENERATION_AXES_COST);
            page.put(List.of("invisibility_axes_bonus", "regeneration_axes_bonus"), ModPlayerData.INVISIBILITY_AXES_COST);
        } else if (currentTab == 5) {
            page.put(List.of("slow_unarmed_bonus", "None"), ModPlayerData.SLOW_UNARMED_COST);
            page.put(List.of("poison_unarmed_bonus", "slow_unarmed_bonus"), ModPlayerData.POISON_UNARMED_COST);
            page.put(List.of("lightning_unarmed_bonus", "poison_unarmed_bonus"), ModPlayerData.LIGHTNING_UNARMED_COST);
        }
        renderPage(page);
    }

    private void renderPage(LinkedHashMap<List<String>, Integer> pages) {
        int length = 40;
        for (List<String> page: pages.keySet()) {
            this.addRenderableWidget(new SkillTreeBonusButton(this.offsetX + imageWidth / 2 - 50, this.offsetY + length, page.get(0), pages.get(page), page.get(1)));
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
        private final Boolean required;
        private final String requiredString;

        public SkillTreeBonusButton(int x, int y, String bonusName, int cost, String required) {
            super(x, y, 100, 20, Component.literal(Component.translatable("tooltip.nicksmod.bonus." + bonusName).getString() + ": " + cost));
            this.bonus = ModPlayerData.BONUS_NAMES.get(bonusName).get();
            this.skillName = SkillTreeScreen.this.player.getData(this.bonus).skill();
            this.skill = ModPlayerData.SKILL_NAMES.get(this.skillName).get();
            this.bonusName = bonusName;
            this.cost = SkillTreeScreen.this.player.getData(this.bonus).cost();
            this.requiredString = required;
            this.required = Objects.equals(required, "None") || SkillTreeScreen.this.player.getData(ModPlayerData.BONUS_NAMES.get(required).get()).has();
            this.setTooltip(null);
        }

        @Override
        public void setTooltip(@Nullable Tooltip tooltip) {
            if (Objects.equals(requiredString, "None")) {
                super.setTooltip(tooltip);
            } else {
                super.setTooltip(Tooltip.create(Component.literal("Required: " + Component.translatable("tooltip.nicksmod.bonus." + requiredString).getString())));
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
