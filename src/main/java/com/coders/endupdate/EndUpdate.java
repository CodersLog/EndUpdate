package com.coders.endupdate;

import com.coders.endupdate.content.block.ModBlocks;
import com.coders.endupdate.content.block.blockentity.BlockEntityRegistry;
import com.coders.endupdate.content.block.blockentity.blockentityrenderers.PedestalBlockEntityRenderer;
import com.coders.endupdate.content.effect.ModEffects;
import com.coders.endupdate.content.item.ModItems;
import com.coders.endupdate.content.worldgen.EndBiomes;
import com.coders.endupdate.content.worldgen.Surface;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.neoforged.api.distmarker.Dist;
import net.minecraft.client.renderer.chunk.RenderChunkRegion;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import terrablender.api.SurfaceRuleManager;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(EndUpdate.MODID)
public class EndUpdate {
    // Define mod id in a common place for everything to reference
    public static final String MODID = "endupdate";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();
    // Create a Deferred Register to hold Blocks which will all be registered under the "endupdate" namespace
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MODID);
    // Create a Deferred Register to hold Items which will all be registered under the "endupdate" namespace
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MODID);
    // Create a Deferred Register to hold CreativeModeTabs which will all be registered under the "endupdate" namespace
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    // Creates a creative tab with the id "endupdate:example_tab" for the example item, that is placed after the combat tab
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> EXAMPLE_TAB = CREATIVE_MODE_TABS.register("example_tab", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.endupdate")) //The language key for the title of your CreativeModeTab
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .icon(() -> ModBlocks.SLUDGE.asItem().getDefaultInstance())
            .displayItems((parameters, output) -> {
                output.accept(ModBlocks.SLUDGE.asItem().getDefaultInstance());
                output.accept(ModBlocks.SLUDGE_INFESTED_ENDSTONE.asItem().getDefaultInstance());
                output.accept(ModBlocks.PACKED_SLUDGE.asItem().getDefaultInstance());
                output.accept(ModBlocks.SLUDGE_BRICKS.asItem().getDefaultInstance());
                output.accept(ModBlocks.SLUDGE_BRICK_STAIRS.asItem().getDefaultInstance());
                output.accept(ModBlocks.SLUDGE_BRICK_SLAB.asItem().getDefaultInstance());
                output.accept(ModBlocks.SLUDGE_BRICK_WALL.asItem().getDefaultInstance());
                output.accept(ModBlocks.CHORUS_LOG.asItem().getDefaultInstance());
                output.accept(ModBlocks.STRIPPED_CHORUS_LOG.asItem().getDefaultInstance());
                output.accept(ModBlocks.CHORUS_WOOD.asItem().getDefaultInstance());
                output.accept(ModBlocks.STRIPPED_CHORUS_WOOD.asItem().getDefaultInstance());
                output.accept(ModBlocks.CHORUS_PLANKS.asItem().getDefaultInstance());
                output.accept(ModBlocks.CHORUS_STAIRS.asItem().getDefaultInstance());
                output.accept(ModBlocks.CHORUS_SLAB.asItem().getDefaultInstance());
                output.accept(ModBlocks.CHORUS_FENCE.asItem().getDefaultInstance());
                output.accept(ModBlocks.CHORUS_FENCE_GATE.asItem().getDefaultInstance());
                output.accept(ModBlocks.CHORUS_DOOR.asItem().getDefaultInstance());
                output.accept(ModBlocks.CHORUS_TRAPDOOR.asItem().getDefaultInstance());
                output.accept(ModBlocks.CHORUS_PRESSURE_PLATE.asItem().getDefaultInstance());
                output.accept(ModBlocks.CHORUS_BUTTON.asItem().getDefaultInstance());
                output.accept(ModBlocks.CHORUS_LEAVES.asItem().getDefaultInstance());
                output.accept(ModBlocks.CHORUS_SAPLING.asItem().getDefaultInstance());
                output.accept(ModItems.CHORUS_BERRIES.asItem().getDefaultInstance());
                output.accept(ModBlocks.ZENILITE_SLUDGE.asItem().getDefaultInstance());
                output.accept(ModItems.ZENILITE_RESIN.asItem().getDefaultInstance());
                output.accept(ModBlocks.NOLIUM_ENDSTONE.asItem().getDefaultInstance());
                output.accept(ModBlocks.SPORE_WILLOW_LOG.asItem().getDefaultInstance());
                output.accept(ModBlocks.STRIPPED_SPORE_WILLOW_LOG.asItem().getDefaultInstance());
                output.accept(ModBlocks.SPORE_WILLOW_WOOD.asItem().getDefaultInstance());
                output.accept(ModBlocks.STRIPPED_SPORE_WILLOW_WOOD.asItem().getDefaultInstance());
                output.accept(ModBlocks.SPORE_WILLOW_PLANKS.asItem().getDefaultInstance());
                output.accept(ModBlocks.SPORE_WILLOW_STAIRS.asItem().getDefaultInstance());
                output.accept(ModBlocks.SPORE_WILLOW_SLAB.asItem().getDefaultInstance());
                output.accept(ModBlocks.SPORE_WILLOW_FENCE.asItem().getDefaultInstance());
                output.accept(ModBlocks.SPORE_WILLOW_FENCE_GATE.asItem().getDefaultInstance());
                output.accept(ModBlocks.SPORE_WILLOW_DOOR.asItem().getDefaultInstance());
                output.accept(ModBlocks.SPORE_WILLOW_TRAPDOOR.asItem().getDefaultInstance());
                output.accept(ModBlocks.SPORE_WILLOW_PRESSURE_PLATE.asItem().getDefaultInstance());
                output.accept(ModBlocks.SPORE_WILLOW_BUTTON.asItem().getDefaultInstance());
                output.accept(ModBlocks.DEAD_SPORE_WILLOW_LOG.asItem().getDefaultInstance());
                output.accept(ModBlocks.STRIPPED_DEAD_SPORE_WILLOW_LOG.asItem().getDefaultInstance());
                output.accept(ModBlocks.DEAD_SPORE_WILLOW_WOOD.asItem().getDefaultInstance());
                output.accept(ModBlocks.STRIPPED_DEAD_SPORE_WILLOW_WOOD.asItem().getDefaultInstance());
                output.accept(ModBlocks.DEAD_SPORE_WILLOW_PLANKS.asItem().getDefaultInstance());
                output.accept(ModBlocks.DEAD_SPORE_WILLOW_STAIRS.asItem().getDefaultInstance());
                output.accept(ModBlocks.DEAD_SPORE_WILLOW_SLAB.asItem().getDefaultInstance());
                output.accept(ModBlocks.DEAD_SPORE_WILLOW_FENCE.asItem().getDefaultInstance());
                output.accept(ModBlocks.DEAD_SPORE_WILLOW_FENCE_GATE.asItem().getDefaultInstance());
                output.accept(ModBlocks.DEAD_SPORE_WILLOW_DOOR.asItem().getDefaultInstance());
                output.accept(ModBlocks.DEAD_SPORE_WILLOW_TRAPDOOR.asItem().getDefaultInstance());
                output.accept(ModBlocks.DEAD_SPORE_WILLOW_PRESSURE_PLATE.asItem().getDefaultInstance());
                output.accept(ModBlocks.DEAD_SPORE_WILLOW_BUTTON.asItem().getDefaultInstance());
                output.accept(ModBlocks.SPORE_WILLOW_LEAVES.asItem().getDefaultInstance());
                output.accept(ModBlocks.MALACHITE.asItem().getDefaultInstance());
                output.accept(ModBlocks.MALACHITE_STAIRS.asItem().getDefaultInstance());
                output.accept(ModBlocks.MALACHITE_SLAB.asItem().getDefaultInstance());
                output.accept(ModBlocks.MALACHITE_WALL.asItem().getDefaultInstance());
                output.accept(ModBlocks.POLISHED_MALACHITE.asItem().getDefaultInstance());
                output.accept(ModBlocks.POLISHED_MALACHITE_STAIRS.asItem().getDefaultInstance());
                output.accept(ModBlocks.POLISHED_MALACHITE_SLAB.asItem().getDefaultInstance());
                output.accept(ModBlocks.MALACHITE_BRICKS.asItem().getDefaultInstance());
                output.accept(ModBlocks.MALACHITE_BRICKS_STAIRS.asItem().getDefaultInstance());
                output.accept(ModBlocks.MALACHITE_BRICKS_SLAB.asItem().getDefaultInstance());
                output.accept(ModBlocks.MALACHITE_BRICKS_WALL.asItem().getDefaultInstance());
                output.accept(ModBlocks.CHISELED_MALACHITE_BRICKS.asItem().getDefaultInstance());
                output.accept(ModBlocks.CHISELED_ENDSTONE_BRICKS.asItem().getDefaultInstance());
                output.accept(ModBlocks.MALACHITE_BRICKS_PEDESTAL.asItem().getDefaultInstance());
                output.accept(ModBlocks.ENDSTONE_BRICKS_PEDESTAL.asItem().getDefaultInstance());
                output.accept(ModBlocks.SLUDGE_BRICKS_PEDESTAL.asItem().getDefaultInstance());







                // Add the example item to the tab. For your own tabs, this method is preferred over the event
            }).build());

    // The constructor for the mod class is the first code that is run when your mod is loaded.
    // FML will recognize some parameter types like IEventBus or ModContainer and pass them in automatically.
    public EndUpdate(IEventBus modEventBus, ModContainer modContainer) {
        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register the Deferred Register to the mod event bus so blocks get registered
        ModBlocks.register(modEventBus);
        ModEffects.register(modEventBus);
        BlockEntityRegistry.register(modEventBus);
        // Register the Deferred Register to the mod event bus so items get registered
        ModItems.register(modEventBus);
        // Register the Deferred Register to the mod event bus so tabs get registered
        CREATIVE_MODE_TABS.register(modEventBus);

        // Register ourselves for server and other game events we are interested in.
        // Note that this is necessary if and only if we want *this* class (EndUpdate) to respond directly to events.
        // Do not add this line if there are no @SubscribeEvent-annotated functions in this class, like onServerStarting() below.
        NeoForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);

        // Register our mod's ModConfigSpec so that FML can create and load the config file for us
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    @EventBusSubscriber(modid = MODID , value = Dist.CLIENT)
    public static class ClientModEvents {


        @SubscribeEvent
        public static void registerBER(EntityRenderersEvent.RegisterRenderers event) {
            event.registerBlockEntityRenderer(BlockEntityRegistry.PEDESTALS.get(), PedestalBlockEntityRenderer::new);

        }
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {




            ItemBlockRenderTypes.setRenderLayer(ModBlocks.DEAD_SPORE_WILLOW_DOOR.get(), RenderType.CUTOUT);
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.DEAD_SPORE_WILLOW_TRAPDOOR.get(), RenderType.CUTOUT);
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CHORUS_TRAPDOOR.get(), RenderType.CUTOUT);
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CHORUS_DOOR.get(), RenderType.CUTOUT);
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.SPORE_WILLOW_DOOR.get(), RenderType.CUTOUT);
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.SPORE_WILLOW_TRAPDOOR.get(), RenderType.CUTOUT);
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CHORUS_BERRY_BUSH.get(), RenderType.CUTOUT);
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.SLUDGE_FERMENTED_GRASS.get(), RenderType.CUTOUT);
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CHORUS_WARTS.get(), RenderType.CUTOUT);
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.MALACHITE_BRICKS_PEDESTAL.get(), RenderType.CUTOUT);
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.ENDSTONE_BRICKS_PEDESTAL.get(), RenderType.CUTOUT);
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.SLUDGE_BRICKS_PEDESTAL.get(), RenderType.CUTOUT);


            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CHORUS_SAPLING.get(), RenderType.CUTOUT);

        }
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        // Some common setup code

        SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.END, EndUpdate.MODID, Surface.end());

        event.enqueueWork(() ->
        {
            EndBiomes.setupTerraBlender();


        });
        LOGGER.info("HELLO FROM COMMON SETUP");

        if (Config.LOG_DIRT_BLOCK.getAsBoolean()) {
            LOGGER.info("DIRT BLOCK >> {}", BuiltInRegistries.BLOCK.getKey(Blocks.DIRT));
        }

        LOGGER.info("{}{}", Config.MAGIC_NUMBER_INTRODUCTION.get(), Config.MAGIC_NUMBER.getAsInt());

        Config.ITEM_STRINGS.get().forEach((item) -> LOGGER.info("ITEM >> {}", item));
    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {


        }
    }



    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // Do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

}
