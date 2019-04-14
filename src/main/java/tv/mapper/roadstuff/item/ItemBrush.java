package tv.mapper.roadstuff.item;

import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import tv.mapper.roadstuff.client.gui.GuiBrush;

public class ItemBrush extends Item
{
    public int pattern = 0;
    public int paint = 0;

    public ItemBrush(Properties properties)
    {
        super(properties);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand)
    {
        ItemStack stack = player.getHeldItem(hand);
        if(!stack.hasTag())
        {
            stack.setTag(new NBTTagCompound());
            stack.getTag().setInt("pattern", 0);
            stack.getTag().setInt("paint", 100);
        }

        if(world.isRemote && player.isSneaking())
        {
            Minecraft.getInstance().displayGuiScreen(new GuiBrush());
        }
        return new ActionResult<>(EnumActionResult.SUCCESS, stack);
    }

    @Override
    public void addInformation(ItemStack stack, World player, List<ITextComponent> list, ITooltipFlag flag)
    {
        super.addInformation(stack, player, list, flag);
        if(stack.hasTag())
        {
            list.add(new TextComponentString("Pattern: " + stack.getTag().getInt("pattern") + ", paint: " + stack.getTag().getInt("paint")));
        }
    }
}
