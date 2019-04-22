package tv.mapper.roadstuff.item;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

public class ItemBlockPaintBucket extends ItemBlock
{
    public ItemBlockPaintBucket(Block blockIn, Properties builder)
    {
        super(blockIn, builder);
    }

    @Override
    public void addInformation(ItemStack stack, World player, List<ITextComponent> list, ITooltipFlag flag)
    {
        super.addInformation(stack, player, list, flag);
        if(stack.hasTag())
        {
            list.add(new TextComponentString("Paint: " + stack.getTag().getInt("paint") + ", color: " + stack.getTag().getInt("color")));
        }
    }
    
    public void test()
    {
        
    }
}
