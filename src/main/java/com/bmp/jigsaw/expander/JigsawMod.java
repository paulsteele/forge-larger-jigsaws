package com.bmp.jigsaw.expander;

import com.mojang.logging.LogUtils;
import net.neoforged.fml.common.Mod;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(JigsawMod.MODID)
public class JigsawMod
{
    // Define mod id in a common place for everything to reference
    public static final String MODID = "jigsawexpander";
    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();
    // Create a Deferred Register to hold Blocks which will all be registered under the "examplemod" namespace

    public JigsawMod()
    {
    }
}
