package com.coders.endupdate.content.block;

import com.coders.endupdate.EndUpdate;
import com.coders.endupdate.content.block.bushes.ChorusBerryBlock;
import com.coders.endupdate.content.block.custom.*;
import com.coders.endupdate.content.block.infested.NoliumInfestedEndstoneBlock;
import com.coders.endupdate.content.block.vegitation.BlockSludgeFermentedGrass;
import com.coders.endupdate.content.item.ModItems;
import com.coders.endupdate.content.worldgen.Features.tree.ModTreeGrowers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Function;

import static net.minecraft.world.item.Items.registerBlock;

public class ModBlocks {

    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(EndUpdate.MODID);




    //FULLBLOCKS

    public static final DeferredBlock<Block> SLUDGE_INFESTED_ENDSTONE = registerBlock("sludge_infested_endstone",
            (properties) -> new SludgeInfestedEndstoneBlock(BlockBehaviour.Properties.of()
                    .strength(4.0F)
                    .sound(SoundType.MUD)
                    .randomTicks()
                    .requiresCorrectToolForDrops()
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("endupdate:sludge_infested_endstone")))));

    public static final DeferredBlock<Block> NOLIUM_ENDSTONE = registerBlock("nolium_endstone",
            (properties) -> new NoliumInfestedEndstoneBlock(BlockBehaviour.Properties.of()
                    .strength(4.0F)
                    .sound(SoundType.STONE)
                    .randomTicks()
                    .requiresCorrectToolForDrops()
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("endupdate:nolium_endstone")))));


    public static final DeferredBlock<Block> NOLIUM_MOSS = registerBlock("nolium_moss",
            (properties) -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSS_BLOCK)
                    .strength(4.0F)
                    .sound(SoundType.MOSS)
                    .randomTicks()
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("endupdate:nolium_moss")))));


    public static final DeferredBlock<Block> SLUDGE = registerBlock("sludge",
            (properties) -> new BlockSludge(BlockBehaviour.Properties.of()
                    .strength(4.0F)
                    .sound(SoundType.MUD)
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("endupdate:sludge")))));

    public static final DeferredBlock<Block> CHORUS_PLANKS = registerBlock("chorus_planks",
            (properties) -> new Block(BlockBehaviour.Properties.of()
                    .strength(4.0F)
                    .sound(SoundType.WOOD)
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("endupdate:chorus_planks")))));

    public static final DeferredBlock<Block> CHORUS_STAIRS = registerBlock("chorus_stairs",
            (properties) -> new StairBlock(ModBlocks.CHORUS_PLANKS.get().defaultBlockState(),
                    properties.strength(2f).sound(SoundType.WOOD).requiresCorrectToolForDrops()));


    public static final DeferredBlock<Block> CHORUS_SLAB = registerBlock("chorus_slab",
            (properties) -> new SlabBlock(BlockBehaviour.Properties.of()
                    .strength(4.0F)
                    .sound(SoundType.WOOD)
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("endupdate:chorus_slab")))));

    public static final DeferredBlock<Block> CHORUS_FENCE = registerBlock("chorus_fence",
            (properties) -> new FenceBlock(BlockBehaviour.Properties.of()
                    .strength(4.0F)
                    .sound(SoundType.WOOD)
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("endupdate:chorus_fence")))));

    public static final DeferredBlock<Block> CHORUS_FENCE_GATE = registerBlock("chorus_fence_gate",
            (properties) -> new FenceGateBlock(WoodType.ACACIA,BlockBehaviour.Properties.of()
                    .strength(4.0F)
                    .sound(SoundType.WOOD)
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("endupdate:chorus_fence_gate")))));

    public static final DeferredBlock<Block> CHORUS_DOOR = registerBlock("chorus_door",
            (properties) -> new DoorBlock(BlockSetType.DARK_OAK,BlockBehaviour.Properties.of()
                    .strength(5.0F).noOcclusion().pushReaction(PushReaction.DESTROY).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("endupdate:chorus_door")))));
    public static final DeferredBlock<Block> CHORUS_TRAPDOOR = registerBlock("chorus_trapdoor",
            (properties) -> new TrapDoorBlock(BlockSetType.DARK_OAK,BlockBehaviour.Properties.of()
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(3.0F)
                    .noOcclusion()
                    .isValidSpawn(Blocks::never)
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("endupdate:chorus_trapdoor")))
                    .ignitedByLava()));
    public static final DeferredBlock<Block> CHORUS_PRESSURE_PLATE = registerBlock("chorus_pressure_plate",
            (properties) -> new PressurePlateBlock(BlockSetType.DARK_OAK,BlockBehaviour.Properties.of()
                    .strength(4.0F)
                    .sound(SoundType.WOOD)
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("endupdate:chorus_pressure_plate")))));

    public static final DeferredBlock<Block> CHORUS_BUTTON = registerBlock("chorus_button",
            (properties) -> new ButtonBlock(BlockSetType.DARK_OAK,2,BlockBehaviour.Properties.of()
                    .strength(4.0F)
                    .sound(SoundType.WOOD)
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("endupdate:chorus_button")))));


    public static final DeferredBlock<Block> PACKED_SLUDGE = registerBlock("packed_sludge",
            (properties) -> new Block(BlockBehaviour.Properties.of()
                    .strength(4.0F)
                    .sound(SoundType.PACKED_MUD)
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("endupdate:packed_sludge")))));

    public static final DeferredBlock<Block> RUINED_END_PORTAL = registerBlock("ruined_end_portal",
            (properties) -> new RuinedEndPortalBlock(BlockBehaviour.Properties.of()
                    .strength(4.0F)
                    .sound(SoundType.MUD_BRICKS)
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("endupdate:ruined_end_portal")))));


    public static final DeferredBlock<Block> SLUDGE_BRICKS = registerBlock("sludge_bricks",
            (properties) -> new Block(BlockBehaviour.Properties.of()
                    .strength(4.0F)
                    .sound(SoundType.MUD_BRICKS)
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("endupdate:sludge_bricks")))));

    public static final DeferredBlock<Block> ZENILITE_SLUDGE = registerBlock("zenilite_sludge",
            (properties) -> new ZeniliteSludgeBlock(BlockBehaviour.Properties.of()
                    .strength(4.0F)
                    .randomTicks()
                    .sound(SoundType.MUD_BRICKS)
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("endupdate:zenilite_sludge")))));

    public static final DeferredBlock<Block> CHORUS_LOG = registerBlock("chorus_log",
            (properties) -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.of()
                    .strength(4.0F)
                    .sound(SoundType.WOOD)
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("endupdate:chorus_log")))));

    public static final DeferredBlock<Block> CHORUS_BERRY_BUSH = BLOCKS.registerBlock("chorus_berry_bush",
            (properties) -> new ChorusBerryBlock(properties.mapColor(MapColor.PLANT).strength(0.2F)
                    .randomTicks().noCollission().sound(SoundType.CROP).noOcclusion().pushReaction(PushReaction.DESTROY)));

    public static final DeferredBlock<Block> SLUDGE_FERMENTED_GRASS = registerBlock("sludge_fermented_grass",
            (properties) -> new BlockSludgeFermentedGrass(BlockBehaviour.Properties.of()
                    .strength(4.0F).instabreak()
                    .noCollission()
                    .sound(SoundType.GRASS).noOcclusion()
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("endupdate:sludge_fermented_grass")))));

    public static final DeferredBlock<Block> CHORUS_WARTS = registerBlock("chorus_warts",
            (properties) -> new BlockSludgeFermentedGrass(BlockBehaviour.Properties.of()
                    .strength(4.0F).instabreak()
                    .noCollission()
                    .sound(SoundType.GRASS).noOcclusion()
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("endupdate:chorus_warts")))));


    public static final DeferredBlock<Block> STRIPPED_CHORUS_LOG = registerBlock("stripped_chorus_log",
            (properties) -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.of()
                    .strength(4.0F)
                    .sound(SoundType.WOOD)
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("endupdate:stripped_chorus_log")))));


    public static final DeferredBlock<Block> CHORUS_WOOD = registerBlock("chorus_wood",
            (properties) -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.of()
                    .strength(4.0F)
                    .sound(SoundType.WOOD)
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("endupdate:chorus_wood")))));

    public static final DeferredBlock<Block> STRIPPED_CHORUS_WOOD = registerBlock("stripped_chorus_wood",
            (properties) -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.of()
                    .strength(4.0F)
                    .sound(SoundType.WOOD)
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("endupdate:stripped_chorus_wood")))));

    public static final DeferredBlock<Block> SPORE_WILLOW_PLANKS = registerBlock("spore_willow_planks",
            (properties) -> new Block(BlockBehaviour.Properties.of()
                    .strength(4.0F)
                    .sound(SoundType.WOOD)
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("endupdate:spore_willow_planks")))));

    public static final DeferredBlock<Block> SPORE_WILLOW_STAIRS = registerBlock("spore_willow_stairs",
            (properties) -> new StairBlock(ModBlocks.SPORE_WILLOW_PLANKS.get().defaultBlockState(),
                    properties.strength(2f).sound(SoundType.WOOD).requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> SPORE_WILLOW_SLAB = registerBlock("spore_willow_slab",
            (properties) -> new SlabBlock(BlockBehaviour.Properties.of()
                    .strength(4.0F)
                    .sound(SoundType.WOOD)
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("endupdate:spore_willow_slab")))));

    public static final DeferredBlock<Block> SPORE_WILLOW_FENCE = registerBlock("spore_willow_fence",
            (properties) -> new FenceBlock(BlockBehaviour.Properties.of()
                    .strength(4.0F)
                    .sound(SoundType.WOOD)
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("endupdate:spore_willow_fence")))));

    public static final DeferredBlock<Block> SPORE_WILLOW_FENCE_GATE = registerBlock("spore_willow_fence_gate",
            (properties) -> new FenceGateBlock(WoodType.ACACIA,BlockBehaviour.Properties.of()
                    .strength(4.0F)
                    .sound(SoundType.WOOD)
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("endupdate:spore_willow_fence_gate")))));

    public static final DeferredBlock<Block> SPORE_WILLOW_DOOR = registerBlock("spore_willow_door",
            (properties) -> new DoorBlock(BlockSetType.DARK_OAK,BlockBehaviour.Properties.of()
                    .strength(5.0F).noOcclusion().pushReaction(PushReaction.DESTROY).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("endupdate:spore_willow_door")))));

    public static final DeferredBlock<Block> SPORE_WILLOW_TRAPDOOR = registerBlock("spore_willow_trapdoor",
            (properties) -> new TrapDoorBlock(BlockSetType.DARK_OAK,BlockBehaviour.Properties.of()
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(3.0F)
                    .noOcclusion()
                    .isValidSpawn(Blocks::never)
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("endupdate:spore_willow_trapdoor")))
                    .ignitedByLava()));

    public static final DeferredBlock<Block> SPORE_WILLOW_PRESSURE_PLATE = registerBlock("spore_willow_pressure_plate",
            (properties) -> new PressurePlateBlock(BlockSetType.DARK_OAK,BlockBehaviour.Properties.of()
                    .strength(4.0F)
                    .sound(SoundType.WOOD)
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("endupdate:spore_willow_pressure_plate")))));

    public static final DeferredBlock<Block> SPORE_WILLOW_BUTTON = registerBlock("spore_willow_button",
            (properties) -> new ButtonBlock(BlockSetType.DARK_OAK,2,BlockBehaviour.Properties.of()
                    .strength(4.0F)
                    .sound(SoundType.WOOD)
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("endupdate:spore_willow_button")))));

    public static final DeferredBlock<Block> SPORE_WILLOW_LOG = registerBlock("spore_willow_log",
            (properties) -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.of()
                    .strength(4.0F)
                    .sound(SoundType.WOOD)
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("endupdate:spore_willow_log")))));

    public static final DeferredBlock<Block> STRIPPED_SPORE_WILLOW_LOG = registerBlock("stripped_spore_willow_log",
            (properties) -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.of()
                    .strength(4.0F)
                    .sound(SoundType.WOOD)
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("endupdate:stripped_spore_willow_log")))));

    public static final DeferredBlock<Block> SPORE_WILLOW_WOOD = registerBlock("spore_willow_wood",
            (properties) -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.of()
                    .strength(4.0F)
                    .sound(SoundType.WOOD)
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("endupdate:spore_willow_wood")))));

    public static final DeferredBlock<Block> STRIPPED_SPORE_WILLOW_WOOD = registerBlock("stripped_spore_willow_wood",
            (properties) -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.of()
                    .strength(4.0F)
                    .sound(SoundType.WOOD)
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("endupdate:stripped_spore_willow_wood")))));


    public static final DeferredBlock<Block> CHORUS_LEAVES = registerBlock("chorus_leaves",
            (properties) -> new UntintedParticleLeavesBlock(0.01f, ParticleTypes.CHERRY_LEAVES,
                    properties.mapColor(MapColor.PLANT).strength(0.2F).randomTicks()
                            .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("endupdate:chorus_leaves")))
                            .sound(SoundType.CHERRY_LEAVES)
                            .noOcclusion().isValidSpawn(Blocks::ocelotOrParrot).ignitedByLava().pushReaction(PushReaction.DESTROY)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 60;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 30;
                }
            });

    public static final DeferredBlock<Block> CHORUS_SAPLING = registerBlock("chorus_sapling",
            (properties) -> new ModSaplingBlock(ModTreeGrowers.CHORUSTREE,
                    properties.mapColor(MapColor.PLANT).noCollission().randomTicks().instabreak()
                            .sound(SoundType.GRASS).pushReaction(PushReaction.DESTROY), ModBlocks.SLUDGE));


    public static final DeferredBlock<Block> DEAD_SPORE_WILLOW_PLANKS = registerBlock("dead_spore_willow_planks",
            (properties) -> new Block(BlockBehaviour.Properties.of()
                    .strength(4.0F)
                    .sound(SoundType.WOOD)
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("endupdate:dead_spore_willow_planks")))));

    public static final DeferredBlock<Block> DEAD_SPORE_WILLOW_STAIRS = registerBlock("dead_spore_willow_stairs",
            (properties) -> new StairBlock(ModBlocks.DEAD_SPORE_WILLOW_PLANKS.get().defaultBlockState(),
                    properties.strength(2f).sound(SoundType.WOOD).requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> DEAD_SPORE_WILLOW_SLAB = registerBlock("dead_spore_willow_slab",
            (properties) -> new SlabBlock(BlockBehaviour.Properties.of()
                    .strength(4.0F)
                    .sound(SoundType.WOOD)
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("endupdate:dead_spore_willow_slab")))));

    public static final DeferredBlock<Block> DEAD_SPORE_WILLOW_FENCE = registerBlock("dead_spore_willow_fence",
            (properties) -> new FenceBlock(BlockBehaviour.Properties.of()
                    .strength(4.0F)
                    .sound(SoundType.WOOD)
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("endupdate:dead_spore_willow_fence")))));

    public static final DeferredBlock<Block> DEAD_SPORE_WILLOW_FENCE_GATE = registerBlock("dead_spore_willow_fence_gate",
            (properties) -> new FenceGateBlock(WoodType.ACACIA,BlockBehaviour.Properties.of()
                    .strength(4.0F)
                    .sound(SoundType.WOOD)
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("endupdate:dead_spore_willow_fence_gate")))));

    public static final DeferredBlock<Block> DEAD_SPORE_WILLOW_DOOR = registerBlock("dead_spore_willow_door",
            (properties) -> new DoorBlock(BlockSetType.DARK_OAK,BlockBehaviour.Properties.of()
                    .strength(5.0F).noOcclusion().pushReaction(PushReaction.DESTROY).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("endupdate:dead_spore_willow_door")))));

    public static final DeferredBlock<Block> DEAD_SPORE_WILLOW_TRAPDOOR = registerBlock("dead_spore_willow_trapdoor",
            (properties) -> new TrapDoorBlock(BlockSetType.DARK_OAK,BlockBehaviour.Properties.of()
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(3.0F)
                    .noOcclusion()
                    .isValidSpawn(Blocks::never)
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("endupdate:dead_spore_willow_trapdoor")))
                    .ignitedByLava()));

    public static final DeferredBlock<Block> DEAD_SPORE_WILLOW_PRESSURE_PLATE = registerBlock("dead_spore_willow_pressure_plate",
            (properties) -> new PressurePlateBlock(BlockSetType.DARK_OAK,BlockBehaviour.Properties.of()
                    .strength(4.0F)
                    .sound(SoundType.WOOD)
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("endupdate:dead_spore_willow_pressure_plate")))));

    public static final DeferredBlock<Block> DEAD_SPORE_WILLOW_BUTTON = registerBlock("dead_spore_willow_button",
            (properties) -> new ButtonBlock(BlockSetType.DARK_OAK,2,BlockBehaviour.Properties.of()
                    .strength(4.0F)
                    .sound(SoundType.WOOD)
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("endupdate:dead_spore_willow_button")))));

    public static final DeferredBlock<Block> DEAD_SPORE_WILLOW_LOG = registerBlock("dead_spore_willow_log",
            (properties) -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.of()
                    .strength(4.0F)
                    .sound(SoundType.WOOD)
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("endupdate:dead_spore_willow_log")))));

    public static final DeferredBlock<Block> STRIPPED_DEAD_SPORE_WILLOW_LOG = registerBlock("stripped_dead_spore_willow_log",
            (properties) -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.of()
                    .strength(4.0F)
                    .sound(SoundType.WOOD)
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("endupdate:stripped_dead_spore_willow_log")))));

    public static final DeferredBlock<Block> DEAD_SPORE_WILLOW_WOOD = registerBlock("dead_spore_willow_wood",
            (properties) -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.of()
                    .strength(4.0F)
                    .sound(SoundType.WOOD)
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("endupdate:dead_spore_willow_wood")))));

    public static final DeferredBlock<Block> STRIPPED_DEAD_SPORE_WILLOW_WOOD = registerBlock("stripped_dead_spore_willow_wood",
            (properties) -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.of()
                    .strength(4.0F)
                    .sound(SoundType.WOOD)
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("endupdate:stripped_dead_spore_willow_wood")))));


    //STAIRS
    public static final DeferredBlock<StairBlock> SLUDGE_BRICK_STAIRS = registerBlock("sludge_brick_stairs",
            (properties) -> new StairBlock(ModBlocks.SLUDGE_BRICKS.get().defaultBlockState(),
                    properties.strength(2f).requiresCorrectToolForDrops()));

    //SLABS
    public static final DeferredBlock<SlabBlock> SLUDGE_BRICK_SLAB = registerBlock("sludge_brick_slab",
            (properties) -> new SlabBlock(properties.strength(2f).requiresCorrectToolForDrops()));
    //WALLS

    public static final DeferredBlock<WallBlock> SLUDGE_BRICK_WALL = registerBlock("sludge_brick_wall",
            (properties) -> new WallBlock(properties.strength(2f).requiresCorrectToolForDrops()));

    public static <T extends Block> DeferredBlock<T> registerBlock(String name, Function<BlockBehaviour.Properties, T> function) {
        DeferredBlock<T> toReturn = BLOCKS.registerBlock(name, function);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, ()
                -> new BlockItem(block.get(),
                new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(EndUpdate.MODID,name)))));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
