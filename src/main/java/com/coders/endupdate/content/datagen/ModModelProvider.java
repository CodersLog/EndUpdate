package com.coders.endupdate.content.datagen;

import com.coders.endupdate.EndUpdate;
import com.coders.endupdate.content.block.ModBlocks;
import com.coders.endupdate.content.block.bushes.ChorusBerryBlock;
import com.coders.endupdate.content.item.ModItems;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.MultiVariant;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.model.*;
import net.minecraft.client.renderer.block.model.BlockModel;
import net.minecraft.client.renderer.item.ClientItem;
import net.minecraft.client.renderer.item.ConditionalItemModel;
import net.minecraft.client.renderer.item.ItemModel;
import net.minecraft.client.renderer.item.properties.conditional.HasComponent;
import net.minecraft.core.Holder;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.stream.Stream;

import static net.minecraft.client.data.models.BlockModelGenerators.*;

public class ModModelProvider extends ModelProvider {


    public ModModelProvider(PackOutput output) {
        super(output, EndUpdate.MODID);
    }

    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {

        //ITEMS

        itemModels.generateFlatItem(ModItems.ZENILITE_RESIN.get(), ModelTemplates.FLAT_ITEM);

        //BLOCKS
        blockModels.createTrivialCube(ModBlocks.SLUDGE.get());
        blockModels.createTrivialBlock(ModBlocks.NOLIUM_ENDSTONE.get(), TexturedModel.CUBE_TOP_BOTTOM);

        blockModels.createTrivialCube(ModBlocks.ZENILITE_SLUDGE.get());
        blockModels.createTrivialBlock(ModBlocks.SLUDGE_INFESTED_ENDSTONE.get(), TexturedModel.CUBE_TOP_BOTTOM);
        blockModels.createTrivialCube(ModBlocks.PACKED_SLUDGE.get());


        blockModels.family(ModBlocks.CHORUS_PLANKS.get())
                .fence(ModBlocks.CHORUS_FENCE.get())
                .fenceGate(ModBlocks.CHORUS_FENCE_GATE.get())
                .stairs(ModBlocks.CHORUS_STAIRS.get())
                .slab(ModBlocks.CHORUS_SLAB.get())
                .button(ModBlocks.CHORUS_BUTTON.get())
                .pressurePlate(ModBlocks.CHORUS_PRESSURE_PLATE.get())
                .door(ModBlocks.CHORUS_DOOR.get())
                .trapdoor(ModBlocks.CHORUS_TRAPDOOR.get());

        blockModels.woodProvider(ModBlocks.CHORUS_LOG.get()).logWithHorizontal(ModBlocks.CHORUS_LOG.get()).wood(ModBlocks.CHORUS_WOOD.get());
        blockModels.woodProvider(ModBlocks.STRIPPED_CHORUS_LOG.get()).logWithHorizontal(ModBlocks.STRIPPED_CHORUS_LOG.get()).wood(ModBlocks.STRIPPED_CHORUS_WOOD.get());

        blockModels.createTrivialBlock(ModBlocks.NOLIUM_MOSS.get(), TexturedModel.CUBE);

        blockModels.createCrossBlock(ModBlocks.SLUDGE_FERMENTED_GRASS.get(), PlantType.TINTED);

        blockModels.createCropBlock(ModBlocks.CHORUS_BERRY_BUSH.get(), ChorusBerryBlock.AGE,  0, 1, 2, 3);

        blockModels.createCrossBlock(ModBlocks.CHORUS_SAPLING.get(), BlockModelGenerators.PlantType.TINTED);
        blockModels.createCrossBlock(ModBlocks.CHORUS_WARTS.get(), BlockModelGenerators.PlantType.TINTED);


        blockModels.createTintedLeaves(ModBlocks.CHORUS_LEAVES.get(), TexturedModel.LEAVES, -12012264);

        blockModels.family(ModBlocks.SLUDGE_BRICKS.get())
                .wall(ModBlocks.SLUDGE_BRICK_WALL.get())
                .stairs(ModBlocks.SLUDGE_BRICK_STAIRS.get())
                .slab(ModBlocks.SLUDGE_BRICK_SLAB.get());

        blockModels.family(ModBlocks.SPORE_WILLOW_PLANKS.get())
                .fence(ModBlocks.SPORE_WILLOW_FENCE.get())
                .fenceGate(ModBlocks.SPORE_WILLOW_FENCE_GATE.get())
                .stairs(ModBlocks.SPORE_WILLOW_STAIRS.get())
                .slab(ModBlocks.SPORE_WILLOW_SLAB.get())
                .button(ModBlocks.SPORE_WILLOW_BUTTON.get())
                .pressurePlate(ModBlocks.SPORE_WILLOW_PRESSURE_PLATE.get())
                .door(ModBlocks.SPORE_WILLOW_DOOR.get())
                .trapdoor(ModBlocks.SPORE_WILLOW_TRAPDOOR.get());

        blockModels.woodProvider(ModBlocks.SPORE_WILLOW_LOG.get()).logWithHorizontal(ModBlocks.SPORE_WILLOW_LOG.get()).wood(ModBlocks.SPORE_WILLOW_WOOD.get());
        blockModels.woodProvider(ModBlocks.STRIPPED_SPORE_WILLOW_LOG.get()).logWithHorizontal(ModBlocks.STRIPPED_SPORE_WILLOW_LOG.get()).wood(ModBlocks.STRIPPED_SPORE_WILLOW_WOOD.get());

        blockModels.family(ModBlocks.DEAD_SPORE_WILLOW_PLANKS.get())
                .fence(ModBlocks.DEAD_SPORE_WILLOW_FENCE.get())
                .fenceGate(ModBlocks.DEAD_SPORE_WILLOW_FENCE_GATE.get())
                .stairs(ModBlocks.DEAD_SPORE_WILLOW_STAIRS.get())
                .slab(ModBlocks.DEAD_SPORE_WILLOW_SLAB.get())
                .button(ModBlocks.DEAD_SPORE_WILLOW_BUTTON.get())
                .pressurePlate(ModBlocks.DEAD_SPORE_WILLOW_PRESSURE_PLATE.get())
                .door(ModBlocks.DEAD_SPORE_WILLOW_DOOR.get())
                .trapdoor(ModBlocks.DEAD_SPORE_WILLOW_TRAPDOOR.get());

        blockModels.woodProvider(ModBlocks.DEAD_SPORE_WILLOW_LOG.get()).logWithHorizontal(ModBlocks.DEAD_SPORE_WILLOW_LOG.get()).wood(ModBlocks.DEAD_SPORE_WILLOW_WOOD.get());
        blockModels.woodProvider(ModBlocks.STRIPPED_DEAD_SPORE_WILLOW_LOG.get()).logWithHorizontal(ModBlocks.STRIPPED_DEAD_SPORE_WILLOW_LOG.get()).wood(ModBlocks.STRIPPED_DEAD_SPORE_WILLOW_WOOD.get());



    }

    @Override
    protected Stream<? extends Holder<Block>> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().filter(x -> !x.is(ModBlocks.RUINED_END_PORTAL));
    }








}