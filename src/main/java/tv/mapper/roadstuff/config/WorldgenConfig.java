package tv.mapper.roadstuff.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class WorldgenConfig
{
    public static ForgeConfigSpec.BooleanValue BITUMEN_GENERATION;
    public static ForgeConfigSpec.IntValue BITUMEN_CHANCE;
    public static ForgeConfigSpec.IntValue BITUMEN_SIZE;
    public static ForgeConfigSpec.IntValue BITUMEN_MIN_HEIGHT;
    public static ForgeConfigSpec.IntValue BITUMEN_MAX_HEIGHT;

    public static void init(ForgeConfigSpec.Builder SERVER_BUILDER)
    {
        SERVER_BUILDER.comment("Bitumen Generation").push("bitumen");

        BITUMEN_GENERATION = SERVER_BUILDER.comment("Generate bitumen in the world [true / false]").define("bitumenGeneration", true);
        BITUMEN_SIZE = SERVER_BUILDER.comment("Size of bitumen pockets [0-100, default: 18]").defineInRange("bitumenSize", 18, 0, 100);
        BITUMEN_CHANCE = SERVER_BUILDER.comment("Chances of bitumen pocket being generated [0-100, default: 25]").defineInRange("bitumenChance", 25, 0, 100);
        BITUMEN_MIN_HEIGHT = SERVER_BUILDER.comment("Minimal height for bitumen pocket generation, [0-255, default: 40]").defineInRange("bitumenMinHeight", 40, 0, 255);
        BITUMEN_MAX_HEIGHT = SERVER_BUILDER.comment("Maximal height for bitumen pocket generation [0-255, default: 160]").defineInRange("bitumenMaxHeight", 160, 0, 255);

        SERVER_BUILDER.pop();
    }
}