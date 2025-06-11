package com.bmp.jigsaw.expander.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(net.minecraft.world.level.chunk.ChunkGenerator.class)
public class ChunkGenerator {

    @ModifyConstant(method = "createReferences", constant = @Constant(intValue = 8))
    private int replaceConstant(int value){
        return 32;
    }
}
