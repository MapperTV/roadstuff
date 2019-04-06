package tv.mapper.roadstuff.item;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import tv.mapper.roadstuff.client.gui.GuiBrush;

public class ItemBrush extends Item
{

    public ItemBrush(Properties properties)
    {
        super(properties);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand)
    {
        ItemStack stack = player.getHeldItem(hand);
        if(world.isRemote && player.isSneaking())
        {
            Minecraft.getInstance().displayGuiScreen(new GuiBrush());
        }
        return new ActionResult<>(EnumActionResult.SUCCESS, stack);
    }
}
