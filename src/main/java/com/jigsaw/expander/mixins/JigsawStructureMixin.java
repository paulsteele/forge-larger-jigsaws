package com.jigsaw.expander.mixins;

import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.heightproviders.HeightProvider;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.minecraft.world.level.levelgen.structure.structures.JigsawStructure;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

import static com.jigsaw.expander.JigsawMod.LOGGER;
import static net.minecraft.world.level.levelgen.structure.Structure.settingsCodec;

@Mixin(JigsawStructure.class)
public abstract class JigsawStructureMixin {
    @Shadow
    @Final
    public static final int MAX_TOTAL_STRUCTURE_RANGE = 512;
    /**
     * @author paul
     * @reason because that's the point of the mod
     */
    @Overwrite
    private static DataResult<JigsawStructure> verifyRange(JigsawStructure jigsawStructure) {
        LOGGER.info("Jigsaw Returns Success");
        return DataResult.success(jigsawStructure);
    }

    @Shadow
    @Final
    public static final Codec<JigsawStructure> CODEC = ExtraCodecs.validate(RecordCodecBuilder.mapCodec((p_227640_) -> {
        return p_227640_.group(settingsCodec(p_227640_), StructureTemplatePool.CODEC.fieldOf("start_pool").forGetter((obj) -> {
            return ((JigsawStructureAccessor)(Object)obj).getStartPool();
        }), ResourceLocation.CODEC.optionalFieldOf("start_jigsaw_name").forGetter((obj) -> {
            return ((JigsawStructureAccessor)(Object) obj).getStartJigsawName();
        }), Codec.intRange(0, 7).fieldOf("size").forGetter((obj) -> {
            return ((JigsawStructureAccessor)(Object) obj).getMaxDepth();
        }), HeightProvider.CODEC.fieldOf("start_height").forGetter((obj) -> {
            return ((JigsawStructureAccessor)(Object) obj).getStartHeight();
        }), Codec.BOOL.fieldOf("use_expansion_hack").forGetter((obj) -> {
            return ((JigsawStructureAccessor)(Object) obj).getUseExpansionHack();
        }), Heightmap.Types.CODEC.optionalFieldOf("project_start_to_heightmap").forGetter((obj) -> {
            return ((JigsawStructureAccessor)(Object) obj).getProjectStartToHeightmap();
        }), Codec.intRange(1, 512).fieldOf("max_distance_from_center").forGetter((obj) -> {
            return ((JigsawStructureAccessor)(Object) obj).getMaxDistanceFromCenter();
        })).apply(p_227640_, JigsawStructure::new);
    }), JigsawStructureMixin::verifyRange).codec();
}
