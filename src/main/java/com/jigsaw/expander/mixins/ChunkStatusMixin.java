package com.jigsaw.expander.mixins;

import com.google.common.collect.ImmutableList;
import net.minecraft.world.level.chunk.ChunkStatus;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import java.util.List;

import static net.minecraft.world.level.chunk.ChunkStatus.*;

@Mixin(ChunkStatus.class)
public class ChunkStatusMixin {

    @ModifyVariable(method = "registerSimple", at = @At("HEAD"), argsOnly = true, index = 2)
    private static int updateChunkDistance(int originalDistance)
    {
        if (originalDistance == 8){
            return 32;
        }
        return originalDistance;
    }

    @ModifyVariable(method = "register*", at = @At("HEAD"), argsOnly = true, index = 2)
    private static int updateChunkDistanceThing(int originalDistance)
    {
        if (originalDistance == 8){
            return 32;
        }
        return originalDistance;
    }


    @Shadow
    @Final
    private static final List<ChunkStatus> STATUS_BY_RANGE = ImmutableList.of(
            FULL,
            INITIALIZE_LIGHT,
            CARVERS,
            BIOMES,
            STRUCTURE_STARTS,
            STRUCTURE_STARTS,
            STRUCTURE_STARTS,
            STRUCTURE_STARTS,
            STRUCTURE_STARTS,
            STRUCTURE_STARTS,
            STRUCTURE_STARTS,
            STRUCTURE_STARTS,
            STRUCTURE_STARTS,
            STRUCTURE_STARTS,
            STRUCTURE_STARTS,
            STRUCTURE_STARTS,
            STRUCTURE_STARTS,
            STRUCTURE_STARTS,
            STRUCTURE_STARTS,
            STRUCTURE_STARTS,
            STRUCTURE_STARTS,
            STRUCTURE_STARTS,
            STRUCTURE_STARTS,
            STRUCTURE_STARTS,
            STRUCTURE_STARTS,
            STRUCTURE_STARTS,
            STRUCTURE_STARTS,
            STRUCTURE_STARTS,
            STRUCTURE_STARTS,
            STRUCTURE_STARTS,
            STRUCTURE_STARTS,
            STRUCTURE_STARTS,
            STRUCTURE_STARTS,
            STRUCTURE_STARTS,
            STRUCTURE_STARTS,
            STRUCTURE_STARTS,
            STRUCTURE_STARTS,
            STRUCTURE_STARTS
    );
}
