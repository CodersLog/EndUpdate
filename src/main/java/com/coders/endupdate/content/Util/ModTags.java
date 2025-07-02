package com.coders.endupdate.content.Util;

import com.coders.endupdate.EndUpdate;
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


        private static TagKey<Block> createTag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(EndUpdate.MODID, name));
        }
    }

    public static class Items {

        public static final TagKey<Item> CHORUSLOGS = createTag("chorus_logs");
        public static final TagKey<Item> SPORE_WILLOWLOGS = createTag("spore_willow_logs");
        public static final TagKey<Item> DEAD_SPORE_WILLOWLOGS = createTag("dead_spore_willow_logs");

        private static TagKey<Item> createTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(EndUpdate.MODID, name));
        }
    }
}