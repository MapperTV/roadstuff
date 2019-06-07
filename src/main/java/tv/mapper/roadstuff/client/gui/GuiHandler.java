package tv.mapper.roadstuff.client.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import tv.mapper.roadstuff.item.ItemBrush;

public class GuiHandler implements IGuiHandler
{
    public static int GUI_BRUSH = 1;

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        if(ID == GUI_BRUSH)
        {
            ItemStack item = player.getHeldItemMainhand();
            if(item.getItem() instanceof ItemBrush)
            {
                return new GuiBrush(item.getTag().getInt("pattern"), item.getTag().getInt("paint"), item.getTag().getInt("color"));
            }
            return new GuiBrush(0, 0, 0);
        }
        else
        {
            return null;
        }
    }

}
