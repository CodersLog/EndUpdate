package com.coders.endupdate.content.worldgen.biome;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.data.worldgen.placement.EndPlacements;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class UEEndBiomes {

    public static Biome sludgeFields(HolderGetter<PlacedFeature> placedFeatureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter)
    {
        MobSpawnSettings.Builder mobSpawnBuilder = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder(placedFeatureGetter, carverGetter);
        biomeBuilder.addFeature(GenerationStep.Decoration.RAW_GENERATION, EndPlacements.END_GATEWAY_RETURN);
        biomeBuilder.addFeature(GenerationStep.Decoration.RAW_GENERATION, EndPlacements.CHORUS_PLANT);


        return new Biome.BiomeBuilder()
                .hasPrecipitation(false).temperature(2.0F).downfall(0.5F)
                .specialEffects(new BiomeSpecialEffects.Builder().grassColorOverride(0xEAB35D).foliageColorOverride(0xEAB35D).waterColor(4159204).waterFogColor(329011).fogColor(10518688).skyColor(55014).ambientParticle(new AmbientParticleSettings(ParticleTypes.BUBBLE, 0.3F)).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).build())
                .mobSpawnSettings(mobSpawnBuilder.build()).generationSettings(biomeBuilder.build()).build();
    }

    public static Biome nucleosisBiome(HolderGetter<PlacedFeature> placedFeatureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter)
    {
        MobSpawnSettings.Builder mobSpawnBuilder = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder(placedFeatureGetter, carverGetter);
        biomeBuilder.addFeature(GenerationStep.Decoration.RAW_GENERATION, EndPlacements.END_GATEWAY_RETURN);
        biomeBuilder.addFeature(GenerationStep.Decoration.RAW_GENERATION, EndPlacements.CHORUS_PLANT);


        return new Biome.BiomeBuilder()
                .hasPrecipitation(false).temperature(2.0F).downfall(0.5F)
                .specialEffects(new BiomeSpecialEffects.Builder().grassColorOverride(0xEAB35D).foliageColorOverride(0xEAB35D).waterColor(4159204).waterFogColor(329011).fogColor(10518688).skyColor(55014).ambientParticle(new AmbientParticleSettings(ParticleTypes.BUBBLE, 0.3F)).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).build())
                .mobSpawnSettings(mobSpawnBuilder.build()).generationSettings(biomeBuilder.build()).build();
    }

}
