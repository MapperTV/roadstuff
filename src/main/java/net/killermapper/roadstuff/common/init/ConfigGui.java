package net.killermapper.roadstuff.common.init;

import cpw.mods.fml.client.config.GuiConfig;
import net.killermapper.roadstuff.common.RoadStuff;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;

public class ConfigGui extends GuiConfig
{

    public ConfigGui(GuiScreen screen)
    {
        super(screen, new ConfigElement(RoadStuff.config.getCategory(Configuration.CATEGORY_GENERAL)).getChildElements(), RoadStuff.MODID, false, false, GuiConfig.getAbridgedConfigPath(RoadStuff.config.toString()));
    }

}
