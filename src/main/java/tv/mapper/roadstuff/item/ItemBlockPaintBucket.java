package tv.mapper.roadstuff.item;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

public class ItemBlockPaintBucket extends BlockItem
{
    public ItemBlockPaintBucket(Block blockIn, Properties builder)
    {
        super(blockIn, builder);
        this.addPropertyOverride(new ResourceLocation("color"), (itemStack, world, entity) ->
        {
            if(itemStack.hasTag())
            {
            CompoundNBT nbt = itemStack.getTag();
            if(nbt.getInt("paint") == 0)
                return 0.0f;
            else if(nbt.getInt("color") == 0)
                return 0.5f;
            else if(nbt.getInt("color") == 1)
                return 1.0f;
            }
            return 0.0f;
        });
    }

    @Override
    public void addInformation(ItemStack stack, World player, List<ITextComponent> list, ITooltipFlag flag)
    {
        super.addInformation(stack, player, list, flag);
        if(stack.hasTag())
        {
            list.add(new StringTextComponent("Paint: " + stack.getTag().getInt("paint") + ", color: " + stack.getTag().getInt("color")));
        }
    }
}
