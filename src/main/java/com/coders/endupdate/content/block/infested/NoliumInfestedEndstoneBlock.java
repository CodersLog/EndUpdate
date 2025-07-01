package com.coders.endupdate.content.block.infested;

import com.coders.endupdate.content.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.lighting.LightEngine;
import net.neoforged.neoforge.common.ItemAbility;
import org.jetbrains.annotations.Nullable;

public class NoliumInfestedEndstoneBlock extends Block {
    public NoliumInfestedEndstoneBlock(Properties properties) {
        super(properties);
    }

    private static boolean canBeInfested(BlockState state, LevelReader reader, BlockPos pos) {
        BlockPos blockpos = pos.above();
        BlockState blockstate = reader.getBlockState(blockpos);
        int i = LightEngine.getLightBlockInto(state, blockstate, Direction.UP, blockstate.getLightBlock());
        return i < 15;
    }

    @Override
    protected void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {



        if (!level.getBlockState(pos.above()).is(Blocks.AIR) && !canBeInfested(state, level, pos)) {
            level.setBlockAndUpdate(pos, Blocks.END_STONE.defaultBlockState());
        }
        super.randomTick(state, level, pos, random);
    }

    @Override
    public @Nullable BlockState getToolModifiedState(BlockState state, UseOnContext context, ItemAbility itemAbility, boolean simulate) {

        if (context.getItemInHand().getItem() instanceof ShovelItem) {

            if (state.is(ModBlocks.NOLIUM_ENDSTONE)) {
                return Blocks.END_STONE.defaultBlockState();
            }

        }

        return super.getToolModifiedState(state, context, itemAbility, simulate);
    }

}