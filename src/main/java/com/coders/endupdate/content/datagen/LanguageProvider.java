package com.coders.endupdate.content.datagen;

import com.coders.endupdate.EndUpdate;
import com.coders.endupdate.content.block.ModBlocks;
import com.coders.endupdate.content.effect.ModEffects;
import com.coders.endupdate.content.item.ModItems;
import net.minecraft.data.PackOutput;

public class LanguageProvider extends net.neoforged.neoforge.common.data.LanguageProvider {
    public LanguageProvider(PackOutput output, String locale) {
        super(output, EndUpdate.MODID, locale);
    }

    @Override
    protected void addTranslations() {

        add(ModEffects.CHORUS_BERRY_EFFECT.getRegisteredName(), "Random Teleport");

        add(ModItems.ZENILITE_RESIN.get(), "Zenilite Resin");

        add(ModItems.CHORUS_BERRIES.get(), "Chorus Berries");
        add(ModItems.CHORUS_WART.get(), "Chorus Wart");

        add(ModBlocks.SPORE_WILLOW_PLANKS.get().asItem(),"Spore Willow Planks");
        add(ModBlocks.SPORE_WILLOW_SLAB.get().asItem(),"Spore Willow Plank Slab");
        add(ModBlocks.SPORE_WILLOW_BUTTON.get().asItem(),"Spore Willow Button");
        add(ModBlocks.SPORE_WILLOW_WOOD.get().asItem(),"Spore Willow Wood");
        add(ModBlocks.SPORE_WILLOW_TRAPDOOR.get().asItem(),"Spore Willow Trapdoor");
        add(ModBlocks.SPORE_WILLOW_STAIRS.get().asItem(),"Spore Willow Stairs");
        add(ModBlocks.SPORE_WILLOW_DOOR.get().asItem(),"Spore Willow Door");
        add(ModBlocks.SPORE_WILLOW_PRESSURE_PLATE.get().asItem(),"Spore Willow Pressure Plate");
        add(ModBlocks.SPORE_WILLOW_LOG.get().asItem(),"Spore Willow Log");
        add(ModBlocks.SPORE_WILLOW_FENCE_GATE.get().asItem(),"Spore Willow Fence Date");
        add(ModBlocks.SPORE_WILLOW_FENCE.get().asItem(),"Spore Willow Fence");
        add(ModBlocks.STRIPPED_SPORE_WILLOW_WOOD.get().asItem(),"Stripped Spore Willow Wood");
        add(ModBlocks.STRIPPED_SPORE_WILLOW_LOG.get().asItem(),"Stripped Spore Willow Log");

        add(ModBlocks.CHORUS_PLANKS.get().asItem(),"Chorus Planks");
        add(ModBlocks.CHORUS_SLAB.get().asItem(),"Chorus Plank Slab");
        add(ModBlocks.CHORUS_WARTS.get().asItem(),"Chorus Wart");
        add(ModBlocks.CHORUS_BUTTON.get().asItem(),"Chorus Button");
        add(ModBlocks.CHORUS_WOOD.get().asItem(),"Chorus Wood");
        add(ModBlocks.CHORUS_TRAPDOOR.get().asItem(),"Chorus Trapdoor");
        add(ModBlocks.CHORUS_STAIRS.get().asItem(),"Chorus Stairs");
        add(ModBlocks.CHORUS_DOOR.get().asItem(),"Chorus Door");
        add(ModBlocks.CHORUS_PRESSURE_PLATE.get().asItem(),"Chorus Pressure Plate");
        add(ModBlocks.CHORUS_LOG.get().asItem(),"Chorus Log");
        add(ModBlocks.CHORUS_SAPLING.get().asItem(),"Chorus Sapling");
        add(ModBlocks.CHORUS_FENCE_GATE.get().asItem(),"Chorus Fence Date");
        add(ModBlocks.CHORUS_FENCE.get().asItem(),"Chorus Fence");
        add(ModBlocks.CHORUS_LEAVES.get().asItem(),"Chorus Leaves");
        add(ModBlocks.STRIPPED_CHORUS_WOOD.get().asItem(),"Stripped Chorus Wood");
        add(ModBlocks.STRIPPED_CHORUS_LOG.get().asItem(),"Stripped Chorus Log");

        add(ModBlocks.DEAD_SPORE_WILLOW_PLANKS.get().asItem(),"Dead Spore Willow Planks");
        add(ModBlocks.DEAD_SPORE_WILLOW_SLAB.get().asItem(),"Dead Spore Willow Plank Slab");
        add(ModBlocks.DEAD_SPORE_WILLOW_BUTTON.get().asItem(),"Dead Spore Willow Button");
        add(ModBlocks.DEAD_SPORE_WILLOW_WOOD.get().asItem(),"Dead Spore Willow Wood");
        add(ModBlocks.DEAD_SPORE_WILLOW_TRAPDOOR.get().asItem(),"Dead Spore Willow Trapdoor");
        add(ModBlocks.DEAD_SPORE_WILLOW_STAIRS.get().asItem(),"Dead Spore Willow Stairs");
        add(ModBlocks.DEAD_SPORE_WILLOW_DOOR.get().asItem(),"Dead Spore Willow Door");
        add(ModBlocks.DEAD_SPORE_WILLOW_PRESSURE_PLATE.get().asItem(),"Dead Spore Willow Pressure Plate");
        add(ModBlocks.DEAD_SPORE_WILLOW_LOG.get().asItem(),"Dead Spore Willow Log");
        add(ModBlocks.DEAD_SPORE_WILLOW_FENCE_GATE.get().asItem(),"Dead Spore Willow Fence Date");
        add(ModBlocks.DEAD_SPORE_WILLOW_FENCE.get().asItem(),"Dead Spore Willow Fence");
        add(ModBlocks.STRIPPED_DEAD_SPORE_WILLOW_WOOD.get().asItem(),"Stripped Dead Spore Willow Wood");
        add(ModBlocks.STRIPPED_DEAD_SPORE_WILLOW_LOG.get().asItem(),"Stripped Dead Spore Willow Log");
        add(ModBlocks.SPORE_WILLOW_LEAVES.get().asItem(),"Spore Willow Leaves");

        add(ModBlocks.ZENILITE_SLUDGE.get().asItem(),"Zenilite Sludge");

        add(ModBlocks.SLUDGE.get().asItem(),"Sludge");
        add(ModBlocks.SLUDGE_BRICKS.get().asItem(),"Sludge Bricks");
        add(ModBlocks.PACKED_SLUDGE.get().asItem(),"Packed Sludge");
        add(ModBlocks.SLUDGE_BRICK_SLAB.get().asItem(),"Sludge Bricks Slab");
        add(ModBlocks.SLUDGE_BRICK_STAIRS.get().asItem(),"Sludge Bricks Stairs");
        add(ModBlocks.SLUDGE_BRICK_WALL.get().asItem(),"Sludge Bricks Wall");
        add(ModBlocks.SLUDGE_INFESTED_ENDSTONE.get().asItem(),"Sludge Infested Endstone");
        add(ModBlocks.SLUDGE_FERMENTED_GRASS.get().asItem(),"Sludge Fermented Grass");

        add(ModBlocks.NOLIUM_ENDSTONE.get().asItem(),"Nolium Endstone");
        add(ModBlocks.NOLIUM_MOSS.get().asItem(),"Nolium Moss");


        add(ModBlocks.RUINED_END_PORTAL.get().asItem(),"Ruined End Portal");






    }


}
