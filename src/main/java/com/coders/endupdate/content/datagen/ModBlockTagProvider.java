package com.coders.endupdate.content.datagen;

import com.coders.endupdate.EndUpdate;
import com.coders.endupdate.content.Util.ModTags;
import com.coders.endupdate.content.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.data.BlockTagsProvider;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, EndUpdate.MODID);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.SLUDGE_BRICKS.get())
                .add(ModBlocks.SLUDGE_BRICK_WALL.get())
                .add(ModBlocks.SLUDGE_BRICK_STAIRS.get())
                .add(ModBlocks.SLUDGE_BRICK_SLAB.get())
                .add(ModBlocks.SLUDGE_INFESTED_ENDSTONE.get())
                .add(ModBlocks.MALACHITE_BRICKS.get())
                .add(ModBlocks.MALACHITE_BRICKS_STAIRS.get())
                .add(ModBlocks.MALACHITE_BRICKS_SLAB.get())
                .add(ModBlocks.MALACHITE_BRICKS_WALL.get())
                .add(ModBlocks.MALACHITE.get())
                .add(ModBlocks.MALACHITE_WALL.get())
                .add(ModBlocks.MALACHITE_SLAB.get())
                .add(ModBlocks.MALACHITE_STAIRS.get())
                .add(ModBlocks.POLISHED_MALACHITE.get())
                .add(ModBlocks.POLISHED_MALACHITE_STAIRS.get())
                .add(ModBlocks.POLISHED_MALACHITE_SLAB.get())
                .add(ModBlocks.CHISELED_MALACHITE_BRICKS.get())
                .add(ModBlocks.CHISELED_ENDSTONE_BRICKS.get())
                .add(ModBlocks.PACKED_SLUDGE.get());

        tag(ModTags.Blocks.MOD_MOSS)
                .add(ModBlocks.NOLIUM_MOSS.get());

        tag(ModTags.Blocks.UTILITY_BLOCKS);



        tag(BlockTags.MINEABLE_WITH_SHOVEL)
                .add(ModBlocks.ZENILITE_SLUDGE.get())
                .add(ModBlocks.SLUDGE.get());


        tag(BlockTags.MINEABLE_WITH_AXE)
                .add(ModBlocks.STRIPPED_CHORUS_LOG.get())
                .add(ModBlocks.STRIPPED_CHORUS_WOOD.get())
                .add(ModBlocks.CHORUS_WOOD.get())
                .add(ModBlocks.CHORUS_PLANKS.get())
                .add(ModBlocks.CHORUS_STAIRS.get())
                .add(ModBlocks.CHORUS_SLAB.get())
                .add(ModBlocks.CHORUS_FENCE.get())
                .add(ModBlocks.CHORUS_FENCE_GATE.get())
                .add(ModBlocks.CHORUS_DOOR.get())
                .add(ModBlocks.CHORUS_TRAPDOOR.get())
                .add(ModBlocks.CHORUS_PRESSURE_PLATE.get())
                .add(ModBlocks.CHORUS_BUTTON.get())
                .add(ModBlocks.CHORUS_LOG.get())
                .add(ModBlocks.STRIPPED_SPORE_WILLOW_LOG.get())
                .add(ModBlocks.STRIPPED_SPORE_WILLOW_WOOD.get())
                .add(ModBlocks.SPORE_WILLOW_WOOD.get())
                .add(ModBlocks.SPORE_WILLOW_PLANKS.get())
                .add(ModBlocks.SPORE_WILLOW_STAIRS.get())
                .add(ModBlocks.SPORE_WILLOW_SLAB.get())
                .add(ModBlocks.SPORE_WILLOW_FENCE.get())
                .add(ModBlocks.SPORE_WILLOW_FENCE_GATE.get())
                .add(ModBlocks.SPORE_WILLOW_DOOR.get())
                .add(ModBlocks.SPORE_WILLOW_TRAPDOOR.get())
                .add(ModBlocks.SPORE_WILLOW_PRESSURE_PLATE.get())
                .add(ModBlocks.SPORE_WILLOW_BUTTON.get())
                .add(ModBlocks.SPORE_WILLOW_LOG.get())
                .add(ModBlocks.STRIPPED_DEAD_SPORE_WILLOW_LOG.get())
                .add(ModBlocks.STRIPPED_DEAD_SPORE_WILLOW_WOOD.get())
                .add(ModBlocks.DEAD_SPORE_WILLOW_WOOD.get())
                .add(ModBlocks.DEAD_SPORE_WILLOW_PLANKS.get())
                .add(ModBlocks.DEAD_SPORE_WILLOW_STAIRS.get())
                .add(ModBlocks.DEAD_SPORE_WILLOW_SLAB.get())
                .add(ModBlocks.DEAD_SPORE_WILLOW_FENCE.get())
                .add(ModBlocks.DEAD_SPORE_WILLOW_FENCE_GATE.get())
                .add(ModBlocks.DEAD_SPORE_WILLOW_DOOR.get())
                .add(ModBlocks.DEAD_SPORE_WILLOW_TRAPDOOR.get())
                .add(ModBlocks.DEAD_SPORE_WILLOW_PRESSURE_PLATE.get())
                .add(ModBlocks.DEAD_SPORE_WILLOW_BUTTON.get())
                .add(ModBlocks.DEAD_SPORE_WILLOW_LOG.get());

        tag(BlockTags.WALLS)
                .add(ModBlocks.MALACHITE_WALL.get())
                .add(ModBlocks.MALACHITE_BRICKS_WALL.get())
                .add(ModBlocks.SLUDGE_BRICK_WALL.get());

        tag(BlockTags.FENCES)
                .add(ModBlocks.CHORUS_FENCE.get());

        tag(ModTags.Blocks.SLUDGE_BLOCKS)
                .add(ModBlocks.SLUDGE.get())
                .add(ModBlocks.PACKED_SLUDGE.get())
                .add(ModBlocks.SLUDGE_BRICKS.get());

        tag(ModTags.Blocks.KNOWNBLOCKS)
                .add(ModBlocks.RUINED_END_PORTAL.get())
                .add(ModBlocks.MALACHITE_BRICKS_PEDESTAL.get())
                .add(ModBlocks.ENDSTONE_BRICKS_PEDESTAL.get())
                .add(ModBlocks.SLUDGE_BRICKS_PEDESTAL.get())
                .add(ModBlocks.BLACKSTONE_BRICKS_PEDESTAL.get())
                .add(ModBlocks.BRICKS_PEDESTAL.get())
                .add(ModBlocks.MOSSY_STONE_BRICKS_PEDESTAL.get())
                .add(ModBlocks.MUD_BRICKS_PEDESTAL.get())
                .add(ModBlocks.NETHER_BRICKS_PEDESTAL.get())
                .add(ModBlocks.PRISMARINE_BRICKS_PEDESTAL.get())
                .add(ModBlocks.QUARTZ_BRICKS_PEDESTAL.get())
                .add(ModBlocks.RED_NETHER_BRICKS_PEDESTAL.get())
                .add(ModBlocks.RESIN_BRICKS_PEDESTAL.get())
                .add(ModBlocks.STONE_BRICKS_PEDESTAL.get())
                .add(ModBlocks.TUFF_BRICKS_PEDESTAL.get())
                .add(ModBlocks.DEEPSLATE_BRICKS_PEDESTAL.get());



        tag(ModTags.Blocks.SLUDGE_REPLACEABLES)
                .add(ModBlocks.SLUDGE.get());


        tag(BlockTags.FENCE_GATES)
                .add(ModBlocks.CHORUS_FENCE_GATE.get());

        tag(BlockTags.LOGS)
                .add(ModBlocks.STRIPPED_CHORUS_LOG.get())
                .add(ModBlocks.STRIPPED_CHORUS_WOOD.get())
                .add(ModBlocks.CHORUS_LOG.get());

        tag(BlockTags.SAPLINGS)
                .add(ModBlocks.CHORUS_SAPLING.get());

        tag(ModTags.Blocks.INFESTED)
                .add(ModBlocks.SLUDGE_INFESTED_ENDSTONE.get());


        tag(ModTags.Blocks.SLUDGE_BLOCK)
                .add(ModBlocks.SLUDGE_INFESTED_ENDSTONE.get())
                .add(ModBlocks.ZENILITE_SLUDGE.get())
                .add(ModBlocks.SLUDGE.get());




        this.tag(BlockTags.LOGS_THAT_BURN);
    }
}