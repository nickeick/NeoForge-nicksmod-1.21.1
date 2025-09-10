package com.nickkick.nicksmod;

import com.nickkick.nicksmod.block.ModBlocks;
import com.nickkick.nicksmod.block.entity.ModBlockEntities;
import com.nickkick.nicksmod.component.ModDataComponents;
import com.nickkick.nicksmod.data_map.ModDataMapTypes;
import com.nickkick.nicksmod.data_map.network.ClientPayloadHandler;
import com.nickkick.nicksmod.data_map.network.ServerPayloadHandler;
import com.nickkick.nicksmod.item.ModCreativeModeTabs;
import com.nickkick.nicksmod.item.ModItems;
import com.nickkick.nicksmod.player.ModKeyMappings;
import com.nickkick.nicksmod.player.ModPlayerData;
import com.nickkick.nicksmod.screen.ModMenuTypes;
import com.nickkick.nicksmod.screen.custom.SkillTreeScreen;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.registration.HandlerThread;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

import static com.nickkick.nicksmod.player.ModPlayerData.AREA_MODE_ENABLED;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(NicksMod.MOD_ID)
public class NicksMod {
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "nicksmod";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    // The constructor for the mod class is the first code that is run when your mod is loaded.
    // FML will recognize some parameter types like IEventBus or ModContainer and pass them in automatically.
    public NicksMod(IEventBus modEventBus, ModContainer modContainer) {
        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register ourselves for server and other game events we are interested in.
        // Note that this is necessary if and only if we want *this* class (ExampleMod) to respond directly to events.
        // Do not add this line if there are no @SubscribeEvent-annotated functions in this class, like onServerStarting() below.
        NeoForge.EVENT_BUS.register(this);

        ModCreativeModeTabs.register(modEventBus);
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        ModBlockEntities.register(modEventBus);
        ModDataComponents.register(modEventBus);
        ModMenuTypes.register(modEventBus);
        ModPlayerData.register(modEventBus);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);

        // Register our mod's ModConfigSpec so that FML can create and load the config file for us
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ModItems.BISMUTH);
            event.accept(ModItems.RAW_BISMUTH);
        }

        if(event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(ModBlocks.BISMUTH_BLOCK);
            event.accept(ModBlocks.BISMUTH_ORE);
        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
    }

    @EventBusSubscriber(modid = MOD_ID, bus = EventBusSubscriber.Bus.MOD)
    public static class ServerModEvents {
        @SubscribeEvent
        public static void registerPayloadHandlers(RegisterPayloadHandlersEvent event) {
            event.registrar(NicksMod.MOD_ID)
                    .executesOn(HandlerThread.NETWORK)
                    .playToClient(
                            ModDataMapTypes.SkillData.TYPE,
                            ModDataMapTypes.SkillData.STREAM_CODEC,
                            ClientPayloadHandler::handleOnNetwork
                    )
                    .playToServer(
                            ModDataMapTypes.BonusData.TYPE,
                            ModDataMapTypes.BonusData.STREAM_CODEC,
                            ServerPayloadHandler::handleOnNetwork
                    )
                    .playToServer(
                            ModDataMapTypes.ToggleAbilityPayload.TYPE,
                            ModDataMapTypes.ToggleAbilityPayload.CODEC,
                            (toggleAbilityPayload, iPayloadContext) -> {
                                var player = iPayloadContext.player();
                                var data = player.getData(AREA_MODE_ENABLED);
                                data.toggle();
                            }
                    );
        }
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @EventBusSubscriber(modid = MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
        }

        @SubscribeEvent
        public static void registerScreens(RegisterMenuScreensEvent event) {
            event.register(ModMenuTypes.SKILL_TREE_MENU.get(), SkillTreeScreen::new);
        }

        @SubscribeEvent
        public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
            event.register(ModKeyMappings.AREA_MODE_MAPPING);
        }
    }
}
