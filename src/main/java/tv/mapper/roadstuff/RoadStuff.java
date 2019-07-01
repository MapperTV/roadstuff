package tv.mapper.roadstuff;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLDedicatedServerSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;
import tv.mapper.roadstuff.config.RoadStuffConfig;
import tv.mapper.roadstuff.network.RSNetwork;
import tv.mapper.roadstuff.proxy.ClientProxy;
import tv.mapper.roadstuff.proxy.IProxy;
import tv.mapper.roadstuff.proxy.ServerProxy;
import tv.mapper.roadstuff.util.AsphaltPaintMap;
import tv.mapper.roadstuff.util.ConcretePaintMap;
import tv.mapper.roadstuff.world.OreGenerator;

@Mod(RoadStuff.MODID)
public class RoadStuff
{
    public static final String MODID = "roadstuff";
    public static IProxy proxy = DistExecutor.runForDist(() -> () -> new ClientProxy(), () -> () -> new ServerProxy());
    
    public static AsphaltPaintMap asphaltMap;
    public static ConcretePaintMap concreteMap;
    
    public static long clickInterval = System.currentTimeMillis();

    public static final Logger LOGGER = LogManager.getLogger();

    public RoadStuff()
    {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::serverSetup);

        RoadStuffConfig.loadConfig(RoadStuffConfig.SERVER_CONFIG, FMLPaths.CONFIGDIR.get().resolve("roadstuff-server.toml"));
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        LOGGER.info("RoadStuff setup");
        proxy.setup(event);
        RSNetwork.registerNetworkPackets();
        asphaltMap = new AsphaltPaintMap();
        concreteMap = new ConcretePaintMap();
        OreGenerator.setupOregen();
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
