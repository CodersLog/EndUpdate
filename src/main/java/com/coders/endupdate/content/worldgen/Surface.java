package com.coders.endupdate.content.worldgen;

import com.coders.endupdate.EndUpdate;
import com.coders.endupdate.content.block.ModBlocks;
import com.coders.endupdate.content.worldgen.biome.ModBiomes;
import com.coders.endupdate.content.worldgen.biome.UEEndBiomes;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Noises;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.synth.NormalNoise;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.registries.NeoForgeRegistries;


public class Surface {



    private static final SurfaceRules.RuleSource SLUDGE = makeStateRule(ModBlocks.SLUDGE.get());
    private static final SurfaceRules.RuleSource NOLIUM = makeStateRule(ModBlocks.NOLIUM_ENDSTONE.get());
    private static final SurfaceRules.RuleSource SIES = makeStateRule(ModBlocks.SLUDGE_INFESTED_ENDSTONE.get());
    private static final SurfaceRules.RuleSource NOLIUM_MOSS = makeStateRule(ModBlocks.NOLIUM_MOSS.get());

    private static SurfaceRules.RuleSource makeStateRule(Block block) {
        return SurfaceRules.state(block.defaultBlockState());
    }




    public static SurfaceRules.RuleSource end()
    {

        return SurfaceRules.sequence
                (SurfaceRules.ifTrue


                        (SurfaceRules.isBiome
                                (ModBiomes.SLUDGE_FIELDS),
                                SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR,SLUDGE),
                                SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, SIES))),

        SurfaceRules.ifTrue


                (SurfaceRules.isBiome
                                (ModBiomes.NUCLEOSIS),
                        SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR,NOLIUM))));



}



}
