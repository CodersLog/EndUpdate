package com.coders.endupdate.content.worldgen;

import com.coders.endupdate.EndUpdate;
import com.coders.endupdate.content.worldgen.structureclasses.placement.DistanceBasedStructurePlacement;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.structure.placement.StructurePlacement;
import net.minecraft.world.level.levelgen.structure.placement.StructurePlacementType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class EndUpdateStructurePlacement {

    public static final DeferredRegister<StructurePlacementType<?>> DEFERRED_REGISTRY_STRUCTURE_PLACEMENT_TYPE = DeferredRegister.create(Registries.STRUCTURE_PLACEMENT, EndUpdate.MODID);

    public static final DeferredHolder<StructurePlacementType<?>, StructurePlacementType<DistanceBasedStructurePlacement>> DISTANCE_BASED_STRUCTURE_PLACEMENT = DEFERRED_REGISTRY_STRUCTURE_PLACEMENT_TYPE.register("distance_based_structure_placement", () -> explicitStructureTypeTyping(DistanceBasedStructurePlacement.CODEC));


    private static <T extends StructurePlacement> StructurePlacementType<T> explicitStructureTypeTyping(MapCodec<T> structurePlacementTypeCodec) {
        return () -> structurePlacementTypeCodec;
    }





}
