package tv.mapper.roadstuff.world;

import static net.minecraft.world.gen.feature.OreFeatureConfig.FillerBlockType.NATURAL_STONE;
import static net.minecraft.world.gen.placement.Placement.COUNT_RANGE;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraftforge.registries.ForgeRegistries;
import tv.mapper.roadstuff.config.WorldgenConfig;
import tv.mapper.roadstuff.init.ModBlocks;

public class OreGenerator
{
    public static void setupOregen()
    {
        for(Biome biome : ForgeRegistries.BIOMES)
        {
            if(WorldgenConfig.BITUMEN_GENERATION.get())
                biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(NATURAL_STONE, ModBlocks.BITUMEN_ORE.getDefaultState(), WorldgenConfig.BITUMEN_SIZE.get().intValue()), COUNT_RANGE, new CountRangeConfig(WorldgenConfig.BITUMEN_CHANCE.get(), WorldgenConfig.BITUMEN_MIN_HEIGHT.get(), WorldgenConfig.BITUMEN_MIN_HEIGHT.get(), WorldgenConfig.BITUMEN_MAX_HEIGHT.get())));
        }
    }
}
