package com.coders.endupdate.content.worldgen.Features.tree;

import com.coders.endupdate.EndUpdate;
import com.coders.endupdate.content.worldgen.Features.ModConfiguredFeatures;
import net.minecraft.world.level.block.grower.TreeGrower;

import java.util.Optional;

public class ModTreeGrowers {
    public static final TreeGrower CHORUSTREE = new TreeGrower(EndUpdate.MODID + ":bloodwood",
            Optional.empty(), Optional.of(ModConfiguredFeatures.CHORUS_WOOD_KEY), Optional.empty());
}
