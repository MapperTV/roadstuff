package tv.mapper.roadstuff.world;

import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import tv.mapper.mapperbase.MapperBase;
import tv.mapper.mapperbase.config.BaseConfig.ClientConfig;
import tv.mapper.roadstuff.config.RSConfig.CommonConfig;
import tv.mapper.roadstuff.world.level.block.RSBlockRegistry;

public class RSFeatures
{
    public static final ConfiguredFeature<?, ?> ORE_BITUMEN = Feature.ORE.configured(new OreConfiguration(OreConfiguration.Predicates.NATURAL_STONE, RSBlockRegistry.BITUMEN_ORE.get().defaultBlockState(), CommonConfig.BITUMEN_SIZE.get())).rangeUniform(VerticalAnchor.absolute(CommonConfig.BITUMEN_MIN_HEIGHT.get()), VerticalAnchor.absolute(CommonConfig.BITUMEN_MAX_HEIGHT.get())).squared().count(CommonConfig.BITUMEN_CHANCE.get());

    public static void registerFeatures()
    {
        Registry<ConfiguredFeature<?, ?>> registry = BuiltinRegistries.CONFIGURED_FEATURE;

        Registry.register(registry, new ResourceLocation(MapperBase.MODID, "bitumen_ore"), ORE_BITUMEN);

        if(ClientConfig.ENABLE_GEN_LOGS.get())
            MapperBase.LOGGER.debug("Registered feature " + ORE_BITUMEN.toString());
    }
}
