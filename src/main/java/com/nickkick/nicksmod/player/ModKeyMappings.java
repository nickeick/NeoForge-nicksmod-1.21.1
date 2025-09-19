package com.nickkick.nicksmod.player;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.neoforged.neoforge.client.settings.KeyConflictContext;
import org.lwjgl.glfw.GLFW;

public class ModKeyMappings {
    public static final KeyMapping AREA_MODE_MAPPING = new KeyMapping(
            "key.nicksmod.areamode",
            KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM,
            GLFW.GLFW_KEY_G,
            "key.categories.misc"
    );

    public static final KeyMapping FELLER_MODE_MAPPING = new KeyMapping(
            "key.nicksmod.fellermode",
            KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM,
            GLFW.GLFW_KEY_H,
            "key.categories.misc"
    );
}
