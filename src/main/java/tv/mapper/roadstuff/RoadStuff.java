package tv.mapper.roadstuff;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLDedicatedServerSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import tv.mapper.roadstuff.network.RSNetwork;
import tv.mapper.roadstuff.proxy.ClientProxy;
import tv.mapper.roadstuff.proxy.IProxy;
import tv.mapper.roadstuff.proxy.ServerProxy;

@Mod(RoadStuff.MODID)
public class RoadStuff
{
    public static final String MODID = "roadstuff";

    public static IProxy proxy = DistExecutor.runForDist(() -> () -> new ClientProxy(), () -> () -> new ServerProxy());

    public static final Logger LOGGER = LogManager.getLogger();

    public RoadStuff()
    {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::serverSetup);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        LOGGER.info("RoadStuff setup");
        proxy.setup(event);
        RSNetwork.registerNetworkPackets();
    }

    private void clientSetup(final FMLClientSetupEvent event)
    {
        LOGGER.info("RoadStuff client setup");
        //ModColorHandler.registerColorHandlers();
    }

    private void serverSetup(final FMLDedicatedServerSetupEvent event)
    {
        LOGGER.info("RoadStuff server setup");
    }
}
