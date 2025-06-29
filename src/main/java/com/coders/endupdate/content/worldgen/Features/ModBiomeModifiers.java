package com.coders.endupdate.content.worldgen.Features;

import com.coders.endupdate.EndUpdate;
import com.coders.endupdate.content.worldgen.biome.ModBiomes;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.BiomeModifiers;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class ModBiomeModifiers {

    public static final ResourceKey<BiomeModifier> ADD_TREE_CHORUS_WOOD = registerKey("add_tree_chorus_wood");
    public static final ResourceKey<BiomeModifier> ADD_SGF = registerKey("add_sgf");
    public static final ResourceKey<BiomeModifier> ADD_CHWART = registerKey("add_chwart");
    public static final ResourceKey<BiomeModifier> ADD_ZENILITE_SLUDGE = registerKey("add_zenilite_sludge");
    public static final ResourceKey<BiomeModifier> ADD_CHORUS_BERRY_BUSH = registerKey("add_chorus_berry_bush");

    public static void bootstrap(BootstrapContext<BiomeModifier> context) {
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);

        // Example for individual Biomes!
        // context.register(ADD_BISMUTH_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(
        //         HolderSet.direct(biomes.getOrThrow(Biomes.PLAINS), biomes.getOrThrow(Biomes.SAVANNA)),
        //         HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.BISMUTH_ORE_PLACED_KEY)),
        //         GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_TREE_CHORUS_WOOD, new BiomeModifiers.AddFeaturesBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(ModBiomes.SLUDGE_FIELDS)),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.CHORUS_WOOD_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(ADD_CHORUS_BERRY_BUSH, new BiomeModifiers.AddFeaturesBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(ModBiomes.SLUDGE_FIELDS)),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.CHORUS_BERRY_BUSH_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(ADD_SGF, new BiomeModifiers.AddFeaturesBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(ModBiomes.SLUDGE_FIELDS)),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.SFG_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(ADD_CHWART, new BiomeModifiers.AddFeaturesBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(ModBiomes.SLUDGE_FIELDS)),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.CHWART_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(ADD_ZENILITE_SLUDGE, new BiomeModifiers.AddFeaturesBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(ModBiomes.SLUDGE_FIELDS)),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.ZENILITE_SLUDGE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

    }

    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ResourceLocation.fromNamespaceAndPath(EndUpdate.MODID, name));
    }
}


