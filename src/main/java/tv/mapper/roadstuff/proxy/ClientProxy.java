package tv.mapper.roadstuff.proxy;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.Screen;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import tv.mapper.roadstuff.client.gui.GuiBrush;

public class ClientProxy implements IProxy
{
    public static boolean ignoreNextGuiClose = false;

    @SubscribeEvent
    public void onGuiOpen(GuiOpenEvent event)
    {
        if(ignoreNextGuiClose)
        {
            Screen current = Minecraft.getInstance().field_71462_r;
            if(event.getGui() == null && (current instanceof GuiBrush))
            {
                ignoreNextGuiClose = false;
                event.setCanceled(true);
            }
        }
    }

    @Override
    public void setup(FMLCommonSetupEvent event)
    {

    }
}
