package com.coders.endupdate.content.datagen;

import com.coders.endupdate.EndUpdate;
import com.coders.endupdate.content.Util.ModTags;
import com.coders.endupdate.content.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;


import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                              CompletableFuture<TagLookup<Block>> blockTags) {
        super(output, lookupProvider, blockTags, EndUpdate.MODID);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {


        tag(ItemTags.SWORDS);
        tag(ItemTags.PICKAXES);
        tag(ItemTags.SHOVELS);
        tag(ItemTags.AXES);
        tag(ItemTags.HOES);

        this.tag(ItemTags.TRIMMABLE_ARMOR);

        this.tag(ItemTags.TRIM_MATERIALS);

        tag(ModTags.Items.CHORUSLOGS)
                .add(ModBlocks.STRIPPED_CHORUS_WOOD.asItem())
                .add(ModBlocks.CHORUS_WOOD.asItem())
                .add(ModBlocks.STRIPPED_CHORUS_LOG.asItem())
                .add(ModBlocks.CHORUS_LOG.asItem());

        tag(ModTags.Items.SPORE_WILLOWLOGS)
                .add(ModBlocks.STRIPPED_SPORE_WILLOW_WOOD.asItem())
                .add(ModBlocks.SPORE_WILLOW_WOOD.asItem())
                .add(ModBlocks.STRIPPED_SPORE_WILLOW_LOG.asItem())
                .add(ModBlocks.SPORE_WILLOW_LOG.asItem());

        this.tag(ItemTags.LOGS_THAT_BURN)
                .add(ModBlocks.STRIPPED_CHORUS_WOOD.asItem())
                .add(ModBlocks.CHORUS_WOOD.asItem())
                .add(ModBlocks.STRIPPED_CHORUS_LOG.asItem())
                .add(ModBlocks.CHORUS_LOG.asItem())
                .add(ModBlocks.STRIPPED_SPORE_WILLOW_WOOD.asItem())
                .add(ModBlocks.SPORE_WILLOW_WOOD.asItem())
                .add(ModBlocks.STRIPPED_SPORE_WILLOW_LOG.asItem())
                .add(ModBlocks.SPORE_WILLOW_LOG.asItem())
                .add(ModBlocks.STRIPPED_SPORE_WILLOW_WOOD.asItem())
                .add(ModBlocks.SPORE_WILLOW_WOOD.asItem())
                .add(ModBlocks.STRIPPED_SPORE_WILLOW_LOG.asItem())
                .add(ModBlocks.SPORE_WILLOW_LOG.asItem());
        tag(ModTags.Items.SPORE_WILLOWLOGS)
                .add(ModBlocks.STRIPPED_SPORE_WILLOW_WOOD.asItem())
                .add(ModBlocks.SPORE_WILLOW_WOOD.asItem())
                .add(ModBlocks.STRIPPED_SPORE_WILLOW_LOG.asItem())
                .add(ModBlocks.SPORE_WILLOW_LOG.asItem());

        this.tag(ItemTags.PLANKS);
    }
}