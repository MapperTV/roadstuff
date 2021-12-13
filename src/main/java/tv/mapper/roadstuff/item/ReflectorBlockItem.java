package tv.mapper.roadstuff.item;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
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
    public boolean isFoil(ItemStack stack)
    {
        if(isLuminescent)
            return true;
        else
            return false;
    }
}