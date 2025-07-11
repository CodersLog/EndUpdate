package com.coders.endupdate.content.item.custom;

import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class SunGemItem extends Item {
    public SunGemItem(Item.Properties properties) {
        super(properties);


    }

    @Override
    public InteractionResult use(Level level, Player player, InteractionHand hand) {

        Entity bolt = new LightningBolt(EntityType.LIGHTNING_BOLT,level);

        ItemStack stack = player.getItemInHand(hand);
        player.displayClientMessage(Component.literal("THE GODS SHALL BE WITH YOU!"),true);
        level.getLevelData().setRaining(false);
        stack.setCount(stack.getCount()-1);
        level.addFreshEntity(bolt);



        return super.use(level, player, hand);
    }
}
