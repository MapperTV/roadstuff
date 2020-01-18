package tv.mapper.roadstuff.config;

import org.apache.commons.lang3.tuple.Pair;

import net.minecraftforge.common.ForgeConfigSpec;

public class RoadStuffConfig
{
    public static final CommonConfig COMMON;
    public static final ForgeConfigSpec COMMON_CONFIG;

    static
    {
        final Pair<CommonConfig, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(CommonConfig::new);

        COMMON = specPair.getLeft();
        COMMON_CONFIG = specPair.getRight();
    }

    public static class CommonConfig
    {
        public static ForgeConfigSpec.BooleanValue BITUMEN_GENERATION;
        public static ForgeConfigSpec.IntValue BITUMEN_CHANCE;
        public static ForgeConfigSpec.IntValue BITUMEN_SIZE;
        public static ForgeConfigSpec.IntValue BITUMEN_MIN_HEIGHT;
        public static ForgeConfigSpec.IntValue BITUMEN_MAX_HEIGHT;

        CommonConfig(ForgeConfigSpec.Builder COMMON_BUILDER)
        {
            COMMON_BUILDER.comment("Bitumen Generation").push("bitumen");

            BITUMEN_GENERATION = COMMON_BUILDER.comment("Generate bitumen in the world [true / false]").define("bitumenGeneration", true);
            BITUMEN_SIZE = COMMON_BUILDER.comment("Size of bitumen pockets [0-100, default: 18]").defineInRange("bitumenSize", 18, 0, 100);
            BITUMEN_CHANCE = COMMON_BUILDER.comment("Chances of bitumen pocket being generated [0-100, default: 25]").defineInRange("bitumenChance", 25, 0, 100);
            BITUMEN_MIN_HEIGHT = COMMON_BUILDER.comment("Minimal height for bitumen pocket generation, [0-255, default: 40]").defineInRange("bitumenMinHeight", 40, 0, 255);
            BITUMEN_MAX_HEIGHT = COMMON_BUILDER.comment("Maximal height for bitumen pocket generation [0-255, default: 160]").defineInRange("bitumenMaxHeight", 160, 0, 255);

            COMMON_BUILDER.pop();
        }
    }
}
