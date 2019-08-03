package tv.mapper.roadstuff.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class GlobalConfig
{
    public static ForgeConfigSpec.BooleanValue BRUSH_ALTERNATIVE_MODE;
    
    public static void init(ForgeConfigSpec.Builder CLIENT_BUILDER)
    {
        CLIENT_BUILDER.comment("Paintbrush Mode").push("paintbrush");

        BRUSH_ALTERNATIVE_MODE = CLIENT_BUILDER.comment("Default paiting mode uses left click to paint. Set to true to use alternative mode which only uses right clicks.").define("alternativeMode", false);

        CLIENT_BUILDER.pop();
    }
}
