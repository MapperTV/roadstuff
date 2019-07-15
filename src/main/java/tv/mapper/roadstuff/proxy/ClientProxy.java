package tv.mapper.roadstuff.proxy;

import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import tv.mapper.roadstuff.util.ModColorHandler;

public class ClientProxy implements IProxy
{
    @Override
    public void setup(FMLCommonSetupEvent event)
    {
        ModColorHandler.registerBlockColor();
        ModColorHandler.registerItemColorHandlers();
    }
}
