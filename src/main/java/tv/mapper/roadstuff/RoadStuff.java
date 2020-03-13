package tv.mapper.roadstuff;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLDedicatedServerSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import tv.mapper.roadstuff.block.RSBlockRegistry;
import tv.mapper.roadstuff.config.RoadStuffConfig;
import tv.mapper.roadstuff.item.RSItemRegistry;
import tv.mapper.roadstuff.network.RSNetwork;
import tv.mapper.roadstuff.proxy.ClientProxy;
import tv.mapper.roadstuff.proxy.IProxy;
import tv.mapper.roadstuff.proxy.ServerProxy;
import tv.mapper.roadstuff.util.AsphaltPaintMap;
import tv.mapper.roadstuff.util.ConcretePaintMap;

@Mod(RoadStuff.MODID)
public class RoadStuff
{
    public static final String MODID = "roadstuff";
    public static IProxy proxy = DistExecutor.runForDist(() -> () -> new ClientProxy(), () -> () -> new ServerProxy());

    public static AsphaltPaintMap asphaltMap;
    public static ConcretePaintMap concreteMap;

    public static AsphaltPaintMap asphaltSlopeMap;
    public static ConcretePaintMap concreteSlopeMap;

    public static long clickInterval = System.currentTimeMillis();

    public static final Logger LOGGER = LogManager.getLogger();

    public RoadStuff()
    {
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, RoadStuffConfig.COMMON_CONFIG);

        RSBlockRegistry.init();
        RSItemRegistry.init();
        
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::serverSetup);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        LOGGER.info("RoadStuff setup started!");
        proxy.setup(event);

        RSNetwork.registerNetworkPackets();

        asphaltMap = new AsphaltPaintMap(false);
        concreteMap = new ConcretePaintMap(false);
        asphaltSlopeMap = new AsphaltPaintMap(true);
        concreteSlopeMap = new ConcretePaintMap(true);

        // OreGenerator.setupOregen();
    }

    private void clientSetup(final FMLClientSetupEvent event)
    {
        // LOGGER.info("RoadStuff client setup");
    }

    private void serverSetup(final FMLDedicatedServerSetupEvent event)
    {
        // LOGGER.info("RoadStuff server setup");
    }
}
