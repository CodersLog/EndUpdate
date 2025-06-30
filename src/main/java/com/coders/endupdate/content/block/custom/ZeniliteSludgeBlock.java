package com.coders.endupdate.content.block.custom;

import com.coders.endupdate.content.block.ModBlocks;
import com.coders.endupdate.content.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.lighting.LightEngine;
import net.neoforged.neoforge.common.ItemAbility;
import org.jetbrains.annotations.Nullable;

public class ZeniliteSludgeBlock extends Block {
    public ZeniliteSludgeBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }



    @Override
    protected void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {

        if (level.getBlockState(pos.north()).is(ModBlocks.SLUDGE)) {
            level.setBlockAndUpdate(pos.north(), ModBlocks.ZENILITE_SLUDGE.get().defaultBlockState());
        }
        if (level.getBlockState(pos.east()).is(ModBlocks.SLUDGE)) {
            level.setBlockAndUpdate(pos.east(), ModBlocks.ZENILITE_SLUDGE.get().defaultBlockState());
        }
        if (level.getBlockState(pos.south()).is(ModBlocks.SLUDGE)) {
            level.setBlockAndUpdate(pos.south(), ModBlocks.ZENILITE_SLUDGE.get().defaultBlockState());
        }
        if (level.getBlockState(pos.west()).is(ModBlocks.SLUDGE)) {
            level.setBlockAndUpdate(pos.west(), ModBlocks.ZENILITE_SLUDGE.get().defaultBlockState());
        }




        super.randomTick(state, level, pos, random);
    }

    @Override
    public @Nullable BlockState getToolModifiedState(BlockState state, UseOnContext context, ItemAbility itemAbility, boolean simulate) {

        if (context.getItemInHand().getItem() instanceof HoeItem) {

            if (state.is(ModBlocks.ZENILITE_SLUDGE)) {
                popResource(context.getLevel(), context.getClickedPos(), new ItemStack(ModItems.ZENILITE_RESIN.get()));
                return ModBlocks.SLUDGE.get().defaultBlockState();
            }

        }

        return super.getToolModifiedState(state, context, itemAbility, simulate);
    }

    @Override
    public boolean canHarvestBlock(BlockState state, BlockGetter level, BlockPos pos, Player player) {
        return true;
    }
}
