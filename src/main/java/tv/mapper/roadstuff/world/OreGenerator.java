package tv.mapper.roadstuff.world;

import static net.minecraft.world.gen.feature.OreFeatureConfig.FillerBlockType.NATURAL_STONE;
import static net.minecraft.world.gen.placement.Placement.COUNT_RANGE;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraftforge.registries.ForgeRegistries;
import tv.mapper.roadstuff.config.RoadStuffConfig.CommonConfig;
import tv.mapper.roadstuff.init.ModBlocks;

public class OreGenerator
{
    public static void setupOregen()
    {
        for(Biome biome : ForgeRegistries.BIOMES)
        {
            if(CommonConfig.BITUMEN_GENERATION.get())
                biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
                    Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(NATURAL_STONE, ModBlocks.BITUMEN_ORE.getDefaultState(), CommonConfig.BITUMEN_SIZE.get().intValue()), COUNT_RANGE,
                        new CountRangeConfig(CommonConfig.BITUMEN_CHANCE.get(), CommonConfig.BITUMEN_MIN_HEIGHT.get(), CommonConfig.BITUMEN_MIN_HEIGHT.get(), CommonConfig.BITUMEN_MAX_HEIGHT.get())));
        }
    }
}
