package com.coders.endupdate.content.Util;

import com.coders.endupdate.EndUpdate;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {

        public static final TagKey<Block> SLUDGE_BLOCKS = createTag("sludge_blocks");

        public static final TagKey<Block> INFESTED = createTag("infested");
        public static final TagKey<Block> SLUDGE_REPLACEABLES = createTag("sludge_replacable");
        public static final TagKey<Block> SLUDGE_BLOCK = createTag("sludge_block_only");
        public static final TagKey<Block> MOD_MOSS = createTag("mod_moss_blocks");
        public static final TagKey<Block> UTILITY_BLOCKS = createTag("utility_blocks");
        public static final TagKey<Block> KNOWNBLOCKS = createTag("knownblocks");
        public static final TagKey<Block> PEDESTALBLOCKS = createTag("pedestals");


        private static TagKey<Block> createTag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(EndUpdate.MODID, name));
        }
    }

    public static class Items {

        public static final TagKey<Item> CHORUSLOGS = createTag("chorus_logs");
        public static final TagKey<Item> SPORE_WILLOWLOGS = createTag("spore_willow_logs");
        public static final TagKey<Item> DEAD_SPORE_WILLOWLOGS = createTag("dead_spore_willow_logs");
        public static final TagKey<Item> ITEMSTHATCANHEAT = createTag("items_that_can_heat");
        public static final TagKey<Item> BECKLOGS = createTag("beck_logs" );

        private static TagKey<Item> createTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(EndUpdate.MODID, name));
        }
    }
}