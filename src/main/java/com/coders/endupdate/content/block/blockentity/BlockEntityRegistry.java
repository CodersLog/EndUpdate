package com.coders.endupdate.content.block.blockentity;

import com.coders.endupdate.EndUpdate;
import com.coders.endupdate.content.Util.ModTags;
import com.coders.endupdate.content.block.ModBlocks;
import com.mojang.logging.LogUtils;
import net.minecraft.Util;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.util.datafix.fixes.References;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BedBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.slf4j.Logger;

import java.util.Set;
import java.util.function.Supplier;

public class BlockEntityRegistry {

    private static final Logger LOGGER = LogUtils.getLogger();

    private static <T extends BlockEntity> BlockEntityType<T> register(
            String name, BlockEntityType.BlockEntitySupplier<? extends T> factory, Block... validBlocks
    ) {
        if (validBlocks.length == 0) {
            LOGGER.warn("Block entity type {} requires at least one valid block to be defined!", name);
        }

        Util.fetchChoiceType(References.BLOCK_ENTITY, name);
        return Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE, name, new BlockEntityType<>(factory, Set.of(validBlocks)));
    }

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES =
            DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, EndUpdate.MODID);

    public static final Supplier<BlockEntityType<HeaterBlockEntity>> HEATER_BLOCK_ENTITY = BLOCK_ENTITY_TYPES.register(
            "heater_block_entity", () -> new BlockEntityType<>(HeaterBlockEntity::new, false, ModBlocks.HEATER.get()
            )
    );

    public static final Supplier<BlockEntityType<PedestalBlockEntity>> PEDESTALS = BLOCK_ENTITY_TYPES.register(
            "pedestals", () -> new BlockEntityType<>(PedestalBlockEntity::new, false,
                    ModBlocks.MALACHITE_BRICKS_PEDESTAL.get() ,
                    ModBlocks.ENDSTONE_BRICKS_PEDESTAL.get(),
                    ModBlocks.BLACKSTONE_BRICKS_PEDESTAL.get(),
                    ModBlocks.BRICKS_PEDESTAL.get(),
                    ModBlocks.MOSSY_STONE_BRICKS_PEDESTAL.get(),
                    ModBlocks.MUD_BRICKS_PEDESTAL.get(),
                    ModBlocks.NETHER_BRICKS_PEDESTAL.get(),
                    ModBlocks.PRISMARINE_BRICKS_PEDESTAL.get(),
                    ModBlocks.QUARTZ_BRICKS_PEDESTAL.get(),
                    ModBlocks.RED_NETHER_BRICKS_PEDESTAL.get(),
                    ModBlocks.RESIN_BRICKS_PEDESTAL.get(),
                    ModBlocks.STONE_BRICKS_PEDESTAL.get(),
                    ModBlocks.TUFF_BRICKS_PEDESTAL.get(),
                    ModBlocks.DEEPSLATE_BRICKS_PEDESTAL.get(),
                    ModBlocks.SLUDGE_BRICKS_PEDESTAL.get()
            )
    );

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITY_TYPES.register(eventBus);
    }

}
