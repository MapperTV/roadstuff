package tv.mapper.roadstuff.world;

import tv.mapper.mapperbase.world.CustomOre;
import tv.mapper.mapperbase.world.OreList;
import tv.mapper.roadstuff.config.RSConfig.CommonConfig;

public class RSOres
{
    public static final CustomOre bitumen = new CustomOre("bitumen", RSFeatures.ORE_BITUMEN, CommonConfig.BITUMEN_GENERATION.get(), CommonConfig.BITUMEN_WHITELIST_MODE.get(), CommonConfig.BITUMEN_BIOME_LIST.get());

    public static void initOres()
    {
        OreList.addOre(bitumen);
    }
}