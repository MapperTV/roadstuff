package tv.mapper.roadstuff.world;

import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import tv.mapper.mapperbase.world.BaseOreGenerator;
import tv.mapper.mapperbase.world.CustomOre;
import tv.mapper.mapperbase.world.OreList;
import tv.mapper.roadstuff.config.RSConfig.CommonConfig;
import tv.mapper.roadstuff.world.level.block.RSBlockRegistry;

public class RSOres
{
    public static PlacedFeature BITUMEN = PlacementUtils.register("bitumen", FeatureUtils.register("bitumen", Feature.ORE.configured(new OreConfiguration(OreFeatures.STONE_ORE_REPLACEABLES, RSBlockRegistry.BITUMEN_ORE.get().defaultBlockState(), CommonConfig.BITUMEN_SIZE.get()))).placed(BaseOreGenerator.commonOrePlacement(CommonConfig.BITUMEN_CHANCE.get(), HeightRangePlacement.uniform(VerticalAnchor.absolute(CommonConfig.BITUMEN_MIN_HEIGHT.get()), VerticalAnchor.absolute(CommonConfig.BITUMEN_MAX_HEIGHT.get())))));

    public static final CustomOre bitumen = new CustomOre("bitumen", BITUMEN, CommonConfig.BITUMEN_GENERATION.get(), CommonConfig.BITUMEN_WHITELIST_MODE.get(), CommonConfig.BITUMEN_BIOME_LIST.get());

    public static void initOres()
    {
        OreList.addOre(bitumen);
    }
}