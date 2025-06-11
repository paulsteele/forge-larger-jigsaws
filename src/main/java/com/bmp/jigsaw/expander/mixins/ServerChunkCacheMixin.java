package com.bmp.jigsaw.expander.mixins;

import net.minecraft.server.level.ServerChunkCache;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.chunk.status.ChunkStatus;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(ServerChunkCache.class)
public class ServerChunkCacheMixin {

    @Shadow
    @Final
    private final long[] lastChunkPos = new long[16];

    @Shadow
    @Final
    private final ChunkStatus[] lastChunkStatus = new ChunkStatus[16];

    @Shadow
    @Final
    private final ChunkAccess[] lastChunk = new ChunkAccess[16];

    @ModifyConstant(method = "storeInCache", constant = @Constant(intValue = 3))
    private int replaceStoreInCache(int value) {
        return 15;
    }

    @ModifyConstant(method = "getChunk", constant = @Constant(intValue = 4))
    private int replaceGetChunk(int value) {
        return 16;
    }

    @ModifyConstant(method = "getChunkNow", constant = @Constant(intValue = 4))
    private int replaceGetChunkNow(int value) {
        return 16;
    }
}
