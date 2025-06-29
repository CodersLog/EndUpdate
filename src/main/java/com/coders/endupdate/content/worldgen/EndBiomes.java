package com.coders.endupdate.content.worldgen;


import com.coders.endupdate.content.Config.ModConfig;
import com.coders.endupdate.content.worldgen.biome.ModBiomes;
import com.coders.endupdate.content.worldgen.biome.UEEndBiomes;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.npc.VillagerType;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import terrablender.api.EndBiomeRegistry;


public class EndBiomes {

    public static void setupTerraBlender() {

        registerHighlandsBiome(ModBiomes.SLUDGE_FIELDS, 9);

    }

    public static void bootstrapBiomes(BootstrapContext<Biome> context) {

        HolderGetter<ConfiguredWorldCarver<?>> carverGetter = context.lookup(Registries.CONFIGURED_CARVER);
        HolderGetter<PlacedFeature> placedFeatureGetter = context.lookup(Registries.PLACED_FEATURE);

        register(context, ModBiomes.SLUDGE_FIELDS, UEEndBiomes.sludgeFields(placedFeatureGetter, carverGetter));

    }

    private static void register(BootstrapContext<Biome> context, ResourceKey<Biome> key, Biome biome)
    {
        context.register(key, biome);
    }

    private static void registerVillagerType(ResourceKey<Biome> key, ResourceKey<VillagerType> type)
    {
        //if (ModConfig.isBiomeEnabled(key))
        //{
        //    VillagerType.BY_BIOME.put(key, type);
        //}
    }

    private static void registerHighlandsBiome(ResourceKey<Biome> key, int weight)
    {
        if (ModConfig.isBiomeEnabled(key))
        {
            EndBiomeRegistry.registerHighlandsBiome(key, weight);
        }
    }



    }
