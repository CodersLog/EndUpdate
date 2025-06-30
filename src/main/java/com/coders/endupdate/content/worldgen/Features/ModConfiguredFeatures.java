package com.coders.endupdate.content.worldgen.Features;

import com.coders.endupdate.content.Util.ModTags;
import com.coders.endupdate.content.block.ModBlocks;
import com.coders.endupdate.EndUpdate;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SweetBerryBushBlock;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.ForkingTrunkPlacer;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class ModConfiguredFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> CHORUS_WOOD_KEY = registerKey("choruswood");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SGF_KEY = registerKey("sgf");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CHWART_KEY = registerKey("chwart");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ZENILITE_LARGE = registerKey("zelilite_large");

    public static final ResourceKey<ConfiguredFeature<?, ?>> CHORUS_BERRY_BUSH_KEY = registerKey("chorus_berry_bush");

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {

        RuleTest sludgeReplaceables = new TagMatchTest(ModTags.Blocks.SLUDGE_REPLACEABLES);


        register(context, CHORUS_WOOD_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.CHORUS_LOG.get()),
                new ForkingTrunkPlacer(7, 7, 5),

                BlockStateProvider.simple(ModBlocks.CHORUS_LEAVES.get()),
                new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(1), 2),

                new TwoLayersFeatureSize(3, 4, 4)).dirt(BlockStateProvider.simple(ModBlocks.SLUDGE.get())).build());

        register(context, CHORUS_BERRY_BUSH_KEY, Feature.RANDOM_PATCH,
                FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK,
                        new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.CHORUS_BERRY_BUSH.get()
                                .defaultBlockState().setValue(SweetBerryBushBlock.AGE, 3))
                        ), List.of(ModBlocks.SLUDGE.get())));



        register(context, SGF_KEY, Feature.RANDOM_PATCH,
                FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK,
                        new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.SLUDGE_FERMENTED_GRASS.get()
                                .defaultBlockState())
                        ), List.of(ModBlocks.SLUDGE.get())));

        register(context, CHWART_KEY, Feature.RANDOM_PATCH,
                FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK,
                        new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.CHORUS_WARTS.get()
                                .defaultBlockState())
                        ), List.of(ModBlocks.SLUDGE.get())));

        register(context, ZENILITE_LARGE, Feature.ORE, new OreConfiguration(sludgeReplaceables,
                ModBlocks.ZENILITE_SLUDGE.get().defaultBlockState(), 9));

    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(EndUpdate.MODID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}

