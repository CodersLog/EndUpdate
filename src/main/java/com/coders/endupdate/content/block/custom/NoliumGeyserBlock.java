package com.coders.endupdate.content.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

public class NoliumGeyserBlock extends Block{
    public NoliumGeyserBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }


    @Override
    protected void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {

        level.sendParticles(ParticleTypes.PORTAL,pos.getX(),pos.getY() +1,pos.getZ(),30,0.5,0.5,0.5,10);

        super.tick(state, level, pos, random);
    }

    @Override
    public void stepOn(Level level, BlockPos pos, BlockState state, Entity entity) {
        Vec3 vec3 = entity.getDeltaMovement();
        if(entity instanceof Player){

            entity.setDeltaMovement(vec3.x,5,vec3.z);

        }

        super.stepOn(level, pos, state, entity);
    }
}
