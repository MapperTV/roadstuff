package tv.mapper.roadstuff.proxy;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import tv.mapper.roadstuff.client.gui.SignWorkshopScreen;
import tv.mapper.roadstuff.init.ModContainers;
import tv.mapper.roadstuff.util.ModColorHandler;

public class ClientProxy implements IProxy
{
    @Override
    public void setup(FMLCommonSetupEvent event)
    {
        ModColorHandler.registerBlockColor();
        ScreenManager.registerFactory(ModContainers.SIGN_WORKSHOP, SignWorkshopScreen::new);
    }

    @Override
    public World getClientWorld()
    {
        return Minecraft.getInstance().world;
    }

    @Override
    public PlayerEntity getClientPlayer()
    {
        return Minecraft.getInstance().player;
    }
}
