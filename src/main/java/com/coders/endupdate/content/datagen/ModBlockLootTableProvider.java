package com.coders.endupdate.content.datagen;

import com.coders.endupdate.content.block.ModBlocks;
import com.coders.endupdate.content.item.ModItems;
import net.minecraft.advancements.critereon.BlockPredicate;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SweetBerryBushBlock;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    protected ModBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {

        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);




        dropSelf(ModBlocks.SLUDGE.get());
        dropSelf(ModBlocks.SLUDGE_BRICKS.get());
        dropSelf(ModBlocks.PACKED_SLUDGE.get());
        dropSelf(ModBlocks.MALACHITE_BRICKS.get());
        dropSelf(ModBlocks.MALACHITE.get());
        dropSelf(ModBlocks.POLISHED_MALACHITE.get());

        dropSelf(ModBlocks.CHISELED_MALACHITE_BRICKS.get());

        dropSelf(ModBlocks.SLUDGE_BRICK_STAIRS.get());

        dropSelf(ModBlocks.MALACHITE_WALL.get());
        dropSelf(ModBlocks.MALACHITE_BRICKS_WALL.get());


        dropSelf(ModBlocks.POLISHED_MALACHITE_STAIRS.get());
        dropSelf(ModBlocks.MALACHITE_STAIRS.get());
        dropSelf(ModBlocks.MALACHITE_BRICKS_STAIRS.get());


        add(ModBlocks.SLUDGE_BRICK_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.SLUDGE_BRICK_SLAB.get()));

        add(ModBlocks.POLISHED_MALACHITE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.POLISHED_MALACHITE_SLAB.get()));

        add(ModBlocks.MALACHITE_BRICKS_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.MALACHITE_BRICKS_SLAB.get()));

        add(ModBlocks.MALACHITE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.MALACHITE_SLAB.get()));

        dropSelf(ModBlocks.CHISELED_ENDSTONE_BRICKS.get());
        dropSelf(ModBlocks.HEATER.get());
        dropSelf(ModBlocks.SLUDGE_BRICK_WALL.get());
        dropSelf(ModBlocks.CHORUS_LOG.get());
        dropSelf(ModBlocks.CHORUS_WOOD.get());
        dropSelf(ModBlocks.STRIPPED_CHORUS_LOG.get());
        dropSelf(ModBlocks.STRIPPED_CHORUS_WOOD.get());
        dropWhenSilkTouch(ModBlocks.ZENILITE_SLUDGE.get());
        dropOther(ModBlocks.ZENILITE_SLUDGE.get(),ModBlocks.SLUDGE.asItem());
        dropSelf(ModBlocks.RUINED_END_PORTAL.get());



        dropOther(ModBlocks.SLUDGE_FERMENTED_GRASS.get(), Items.WHEAT_SEEDS);

        dropSelf(ModBlocks.CHORUS_WARTS.get());

        dropOther(ModBlocks.SLUDGE_INFESTED_ENDSTONE.get(), Blocks.END_STONE);
        dropOther(ModBlocks.NOLIUM_ENDSTONE.get(), Blocks.END_STONE);
        dropWhenSilkTouch(ModBlocks.NOLIUM_ENDSTONE.get());
        dropWhenSilkTouch(ModBlocks.SLUDGE_INFESTED_ENDSTONE.get());

        dropSelf(ModBlocks.NOLIUM_MOSS.get());

        dropOther(ModBlocks.CHORUS_LEAVES.get(),ModBlocks.CHORUS_SAPLING.asItem());
        dropOther(ModBlocks.SPORE_WILLOW_LEAVES.get(),ModBlocks.SPORE_WILLOW_DOOR.asItem());

        dropSelf(ModBlocks.CHORUS_SAPLING.get());

        dropSelf(ModBlocks.CHORUS_STAIRS.get());
        dropSelf(ModBlocks.CHORUS_PLANKS.get());
        this.add(ModBlocks.CHORUS_BERRY_BUSH.get(), block -> this.applyExplosionDecay(
                block,LootTable.lootTable().withPool(LootPool.lootPool().when(
                                        LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.CHORUS_BERRY_BUSH.get())
                                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SweetBerryBushBlock.AGE, 3))
                                ).add(LootItem.lootTableItem(ModItems.CHORUS_BERRIES.get()))
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 3.0F)))
                                .apply(ApplyBonusCount.addUniformBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))
                ).withPool(LootPool.lootPool().when(
                                        LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.CHORUS_BERRY_BUSH.get())
                                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SweetBerryBushBlock.AGE, 2))
                                ).add(LootItem.lootTableItem(ModItems.CHORUS_BERRIES.get()))
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F)))
                                .apply(ApplyBonusCount.addUniformBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))
                )));
        add(ModBlocks.CHORUS_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.CHORUS_SLAB.get()));

        dropSelf(ModBlocks.CHORUS_PRESSURE_PLATE.get());
        dropSelf(ModBlocks.CHORUS_BUTTON.get());

        dropSelf(ModBlocks.CHORUS_FENCE.get());
        dropSelf(ModBlocks.CHORUS_FENCE_GATE.get());
        dropSelf(ModBlocks.CHORUS_TRAPDOOR.get());

        add(ModBlocks.CHORUS_DOOR.get(),
                block -> createDoorTable(ModBlocks.CHORUS_DOOR.get()));

        dropSelf(ModBlocks.DEAD_SPORE_WILLOW_LOG.get());
        dropSelf(ModBlocks.DEAD_SPORE_WILLOW_WOOD.get());
        dropSelf(ModBlocks.STRIPPED_DEAD_SPORE_WILLOW_LOG.get());
        dropSelf(ModBlocks.STRIPPED_DEAD_SPORE_WILLOW_WOOD.get());
        dropSelf(ModBlocks.DEAD_SPORE_WILLOW_STAIRS.get());
        dropSelf(ModBlocks.DEAD_SPORE_WILLOW_PLANKS.get());
        add(ModBlocks.DEAD_SPORE_WILLOW_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.DEAD_SPORE_WILLOW_SLAB.get()));

        dropSelf(ModBlocks.DEAD_SPORE_WILLOW_PRESSURE_PLATE.get());
        dropSelf(ModBlocks.DEAD_SPORE_WILLOW_BUTTON.get());

        dropSelf(ModBlocks.DEAD_SPORE_WILLOW_FENCE.get());
        dropSelf(ModBlocks.DEAD_SPORE_WILLOW_FENCE_GATE.get());
        dropSelf(ModBlocks.DEAD_SPORE_WILLOW_TRAPDOOR.get());

        add(ModBlocks.DEAD_SPORE_WILLOW_DOOR.get(),
                block -> createDoorTable(ModBlocks.DEAD_SPORE_WILLOW_DOOR.get()));

        dropSelf(ModBlocks.SPORE_WILLOW_LOG.get());
        dropSelf(ModBlocks.SPORE_WILLOW_WOOD.get());
        dropSelf(ModBlocks.STRIPPED_SPORE_WILLOW_LOG.get());
        dropSelf(ModBlocks.STRIPPED_SPORE_WILLOW_WOOD.get());
        dropSelf(ModBlocks.SPORE_WILLOW_STAIRS.get());
        dropSelf(ModBlocks.SPORE_WILLOW_PLANKS.get());
        add(ModBlocks.SPORE_WILLOW_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.SPORE_WILLOW_SLAB.get()));

        dropSelf(ModBlocks.SPORE_WILLOW_PRESSURE_PLATE.get());
        dropSelf(ModBlocks.SPORE_WILLOW_BUTTON.get());

        dropSelf(ModBlocks.MALACHITE_BRICKS_PEDESTAL.get());
        dropSelf(ModBlocks.ENDSTONE_BRICKS_PEDESTAL.get());
        dropSelf(ModBlocks.SLUDGE_BRICKS_PEDESTAL.get());

        dropSelf(ModBlocks.SPORE_WILLOW_FENCE.get());
        dropSelf(ModBlocks.SPORE_WILLOW_FENCE_GATE.get());
        dropSelf(ModBlocks.SPORE_WILLOW_TRAPDOOR.get());

        add(ModBlocks.SPORE_WILLOW_DOOR.get(),
                block -> createDoorTable(ModBlocks.SPORE_WILLOW_DOOR.get()));

    }

    protected LootTable.Builder createMultipleOreDrops(Block pBlock, Item item, float minDrops, float maxDrops) {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock, LootItem.lootTableItem(item)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops)))
                        .apply(ApplyBonusCount.addOreBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}