package com.jigsaw.expander.mixins;

import com.mojang.serialization.DataResult;
import net.minecraft.world.level.levelgen.structure.structures.JigsawStructure;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import static com.jigsaw.expander.JigsawMod.LOGGER;

@Mixin(JigsawStructure.class)
public abstract class JigsawStructureMixin {
    /**
     * @author paul
     * @reason because that's the point of the mod
     */
    @Overwrite
    private static DataResult<JigsawStructure> verifyRange(JigsawStructure jigsawStructure) {
        LOGGER.info("Jigsaw Returns Success");
        return DataResult.success(jigsawStructure);
    }
}
