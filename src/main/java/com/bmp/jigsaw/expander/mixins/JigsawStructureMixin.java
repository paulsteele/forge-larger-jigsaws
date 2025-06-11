package com.bmp.jigsaw.expander.mixins;

import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.heightproviders.HeightProvider;
import net.minecraft.world.level.levelgen.structure.pools.DimensionPadding;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.minecraft.world.level.levelgen.structure.pools.alias.PoolAliasBinding;
import net.minecraft.world.level.levelgen.structure.structures.JigsawStructure;
import net.minecraft.world.level.levelgen.structure.templatesystem.LiquidSettings;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

import java.util.List;

import static com.bmp.jigsaw.expander.JigsawMod.LOGGER;
import static net.minecraft.world.level.levelgen.structure.Structure.settingsCodec;
import static net.minecraft.world.level.levelgen.structure.structures.JigsawStructure.DEFAULT_DIMENSION_PADDING;
import static net.minecraft.world.level.levelgen.structure.structures.JigsawStructure.DEFAULT_LIQUID_SETTINGS;

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
    public static final Codec<JigsawStructure> CODEC = RecordCodecBuilder.<JigsawStructure>mapCodec(
            p_227640_ -> p_227640_.group(
                        settingsCodec(p_227640_),
                        StructureTemplatePool.CODEC.fieldOf("start_pool").forGetter(p_227656_ -> ((JigsawStructureAccessor)(Object)p_227656_).getStartPool()),
                        ResourceLocation.CODEC.optionalFieldOf("start_jigsaw_name").forGetter(p_227654_ -> ((JigsawStructureAccessor)(Object) p_227654_).getStartJigsawName()),
                        Codec.intRange(0, 20).fieldOf("size").forGetter(p_227652_ -> ((JigsawStructureAccessor)(Object)p_227652_).getMaxDepth()),
                        HeightProvider.CODEC.fieldOf("start_height").forGetter(p_227649_ -> ((JigsawStructureAccessor)(Object)p_227649_).getStartHeight()),
                        Codec.BOOL.fieldOf("use_expansion_hack").forGetter(p_227646_ -> ((JigsawStructureAccessor)(Object)p_227646_).getUseExpansionHack()),
                        Heightmap.Types.CODEC.optionalFieldOf("project_start_to_heightmap").forGetter(p_227644_ -> ((JigsawStructureAccessor)(Object)p_227644_).getProjectStartToHeightmap()),
                        Codec.intRange(1, 512).fieldOf("max_distance_from_center").forGetter(p_227642_ -> ((JigsawStructureAccessor)(Object)p_227642_).getMaxDistanceFromCenter()),
                        Codec.list(PoolAliasBinding.CODEC).optionalFieldOf("pool_aliases", List.of()).forGetter(p_307187_ -> ((JigsawStructureAccessor)(Object)p_307187_).getPoolAliases()),
                        DimensionPadding.CODEC.optionalFieldOf("dimension_padding", DEFAULT_DIMENSION_PADDING).forGetter(p_348455_ -> ((JigsawStructureAccessor)(Object)p_348455_).getDimensionPadding()),
                        LiquidSettings.CODEC.optionalFieldOf("liquid_settings", DEFAULT_LIQUID_SETTINGS).forGetter(p_352036_ -> ((JigsawStructureAccessor)(Object)(p_352036_)).getLiquidSettings())
                    ).apply(p_227640_, JigsawStructure::new)
        )
        .validate(JigsawStructureAccessor::verifyRange).codec();
}
