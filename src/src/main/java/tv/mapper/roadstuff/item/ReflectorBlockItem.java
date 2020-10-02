package tv.mapper.roadstuff.item;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ReflectorBlockItem extends BlockItem
{
    private boolean isLuminescent;

    public ReflectorBlockItem(Block blockIn, Properties builder, boolean isLuminescent)
    {
        super(blockIn, builder);
        this.isLuminescent = isLuminescent;
    }

    @OnlyIn(Dist.CLIENT)
    public boolean hasEffect(ItemStack stack)
    {
        if(isLuminescent)
            return true;
        else
            return false;
    }
}