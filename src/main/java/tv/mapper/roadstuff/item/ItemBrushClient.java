package tv.mapper.roadstuff.item;

import net.minecraft.client.Minecraft;
import tv.mapper.roadstuff.client.gui.GuiBrush;

public class ItemBrushClient
{
    public static void displayBrushGui()
    {
        Minecraft.getInstance().displayGuiScreen(new GuiBrush());
    }
}
