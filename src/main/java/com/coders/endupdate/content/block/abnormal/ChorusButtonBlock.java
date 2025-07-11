package com.coders.endupdate.content.block.abnormal;

import com.coders.endupdate.content.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ButtonBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.neoforged.fml.common.Mod;
import org.jetbrains.annotations.Nullable;

public class ChorusButtonBlock extends ButtonBlock {
    public ChorusButtonBlock(BlockSetType darkOak, int i, BlockBehaviour.Properties properties) {
        super(darkOak,i,properties);
    }



    @Override
    public void press(BlockState state, Level level, BlockPos pos, @Nullable Player player) {

        assert player != null;
        int randomx = pos.getX() + player.getRandom().nextIntBetweenInclusive(-10,10);
        int randomz = pos.getZ() + player.getRandom().nextIntBetweenInclusive(-10,10);

        BlockPos randomPos = new BlockPos(randomx,pos.getY(),randomz);

        if(level.getBlockState(randomPos).is(Blocks.AIR)) {

            level.setBlock(randomPos, ModBlocks.CHORUS_BUTTON.get().defaultBlockState(),0);
            level.setBlock(pos, Blocks.AIR.defaultBlockState(),0);

        }

        super.press(state, level, pos, player);
    }
}
