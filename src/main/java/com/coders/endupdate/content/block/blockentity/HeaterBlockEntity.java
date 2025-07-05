package com.coders.endupdate.content.block.blockentity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class HeaterBlockEntity extends BlockEntity {
    public HeaterBlockEntity(BlockPos pos, BlockState blockState) {
        super(BlockEntityRegistry.HEATER_BLOCK_ENTITY.get(), pos, blockState);
    }
}
