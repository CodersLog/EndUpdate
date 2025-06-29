package com.coders.endupdate.content.worldgen;

import com.coders.endupdate.EndUpdate;
import com.coders.endupdate.content.worldgen.structureclasses.EndIslandStructures;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class EndUpdateStructures {

    public static final DeferredRegister<StructureType<?>> DEFERRED_REGISTRY_STRUCTURE = DeferredRegister.create(Registries.STRUCTURE_TYPE, EndUpdate.MODID);

    public static final DeferredHolder<StructureType<?>, StructureType<EndIslandStructures>> END_ISLAND_STRUCTURES = DEFERRED_REGISTRY_STRUCTURE.register("end_island_structures", () -> explicitStructureTypeTyping(EndIslandStructures.CODEC));

    private static <T extends Structure> StructureType<T> explicitStructureTypeTyping(MapCodec<T> structureCodec) {
        return () -> structureCodec;
    }
}
