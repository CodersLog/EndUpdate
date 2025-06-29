package com.coders.endupdate.content.effect;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

public class ChorusBerryEffect extends MobEffect {



    public ChorusBerryEffect(MobEffectCategory category, int color) {
        super(category, color);
    }





    @Override
    public boolean applyEffectTick(ServerLevel level, LivingEntity entity, int amplifier) {
         if(entity instanceof Player){

             int randomx = entity.blockPosition().getX() + entity.getRandom().nextIntBetweenInclusive(-10,10);
             int randomz = entity.blockPosition().getZ() + entity.getRandom().nextIntBetweenInclusive(-10,10);

             entity.teleportTo(randomx, entity.getY(),randomz);
             return true;
        }


        return applyEffectTick(level, entity, amplifier);
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return duration == 1;
    }
}
