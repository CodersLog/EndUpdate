package com.coders.endupdate.content.item;

import com.coders.endupdate.EndUpdate;
import com.coders.endupdate.content.block.ModBlocks;
import com.coders.endupdate.content.block.custom.ModFlammableRotatedPillarBlock;
import com.coders.endupdate.content.effect.ModEffects;
import com.coders.endupdate.content.item.custom.SunGemItem;
import com.coders.endupdate.content.item.food.ModFoodProperties;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;
import net.minecraft.world.item.consume_effects.ConsumeEffect;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(EndUpdate.MODID);

    public static final DeferredItem<Item> CHORUS_BERRIES = ITEMS.registerItem("chorus_berries",
            (properties) -> new BlockItem(ModBlocks.CHORUS_BERRY_BUSH.get(), properties.setId(ResourceKey.create
                    (Registries.ITEM, ResourceLocation.parse("endupdate:chorus_berries"))).food(ModFoodProperties.CHORUS_BERRY,
                    Consumable.builder().onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(ModEffects.CHORUS_BERRY_EFFECT, 200, 0), 0.3F)).build())));

    public static final DeferredItem<Item> CHORUS_WART = ITEMS.registerItem("chorus_wart",
            (properties) -> new BlockItem(ModBlocks.CHORUS_WARTS.get(), properties.setId(ResourceKey.create(Registries.ITEM, ResourceLocation.parse("endupdate:chorus_wart")))));

    public static final DeferredItem<Item> ZENILITE_RESIN = ITEMS.registerItem("zenilite_resin",
            (properties) -> new Item( properties.setId(ResourceKey.create(Registries.ITEM, ResourceLocation.parse("endupdate:zenilite_resin")))));

    public static final DeferredItem<Item> GEM_OF_THE_SUN = ITEMS.registerItem("sun_gem",
            (properties) -> new SunGemItem( properties.useCooldown(1.0F).stacksTo(1).setId(ResourceKey.create(Registries.ITEM, ResourceLocation.parse("endupdate:sun_gem")))));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
