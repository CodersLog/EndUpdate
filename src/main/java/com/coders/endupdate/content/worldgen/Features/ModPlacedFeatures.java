package com.coders.endupdate.content.worldgen.Features;

import com.coders.endupdate.EndUpdate;
import com.coders.endupdate.content.block.ModBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class ModPlacedFeatures {

    public static final ResourceKey<PlacedFeature> CHORUS_BERRY_BUSH_PLACED_KEY = registerKey("chorus_berry_bush_placed");
    public static final ResourceKey<PlacedFeature> SFG_PLACED_KEY = registerKey("sfg_placed_key");

    public static final ResourceKey<PlacedFeature> CHWART_PLACED_KEY = registerKey("chwart_placed_key");
    public static final ResourceKey<PlacedFeature> SPORE_WILLOW_WOOD_PLACED_KEY = registerKey("spore_willow_wood_placed");
    public static final ResourceKey<PlacedFeature> DEAD_SPORE_WILLOW_WOOD_PLACED_KEY = registerKey("dead_spore_willow_wood_placed");
    public static final ResourceKey<PlacedFeature> CHORUS_WOOD_PLACED_KEY = registerKey("choruswood_placed");


    public static final ResourceKey<PlacedFeature> ZENILITE_SLUDGE_PLACED_KEY = registerKey("zenilite_placed");
    public static final ResourceKey<PlacedFeature> NOLIUM_MOSS_PLACED_KEY = registerKey("nolium_moss_placed");

    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        var configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, SFG_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.SGF_KEY),
                List.of(RarityFilter.onAverageOnceEvery(2), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));
        register(context, CHWART_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CHWART_KEY),
                List.of(RarityFilter.onAverageOnceEvery(2), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));
        register(context, ZENILITE_SLUDGE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.ZENILITE_LARGE),
                ModOrePlacement.commonOrePlacement(256, HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))));
        register(context, NOLIUM_MOSS_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.NOLIUM_MOSS_CONFIG),
                ModOrePlacement.commonOrePlacement(128, HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))));


        register(context, CHORUS_WOOD_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CHORUS_WOOD_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(4, 0.1f, 5),
                        ModBlocks.CHORUS_SAPLING.get()));
        register(context, SPORE_WILLOW_WOOD_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.SPORE_WILLOW_WOOD_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(4, 0.1f, 1),
                        ModBlocks.NOLIUM_ENDSTONE.get()));
        register(context, DEAD_SPORE_WILLOW_WOOD_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.DEAD_SPORE_WILLOW_WOOD_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(4, 0.1f, 1),
                        ModBlocks.NOLIUM_MOSS.get()));

        register(context, CHORUS_BERRY_BUSH_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CHORUS_BERRY_BUSH_KEY),
                List.of(RarityFilter.onAverageOnceEvery(32), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));




    }

    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(EndUpdate.MODID, name));
    }

    private static void register(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}