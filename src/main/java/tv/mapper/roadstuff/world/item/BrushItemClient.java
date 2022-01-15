package tv.mapper.roadstuff.world.item;

import net.minecraft.client.Minecraft;
import tv.mapper.roadstuff.client.gui.screens.GuiBrush;

public class BrushItemClient
{
    public static void displayBrushGui(int pattern, int paint, int color, float scroll, int[] favs)
    {
        Minecraft.getInstance().setScreen(new GuiBrush(pattern, paint, color, scroll, favs));
    }
}