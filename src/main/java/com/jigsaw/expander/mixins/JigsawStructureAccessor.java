package com.jigsaw.expander.mixins;


import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.heightproviders.HeightProvider;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.minecraft.world.level.levelgen.structure.structures.JigsawStructure;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.Optional;

@Mixin(JigsawStructure.class)
public interface JigsawStructureAccessor {
    @Accessor Holder<StructureTemplatePool> getStartPool();
    @Accessor
    Optional<ResourceLocation> getStartJigsawName();
    @Accessor
    int getMaxDepth();
    @Accessor
    HeightProvider getStartHeight();
    @Accessor
    boolean getUseExpansionHack();
    @Accessor
    Optional<Heightmap.Types> getProjectStartToHeightmap();
    @Accessor
    int getMaxDistanceFromCenter();
}
