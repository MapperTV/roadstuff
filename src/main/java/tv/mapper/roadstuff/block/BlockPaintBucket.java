package tv.mapper.roadstuff.block;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import tv.mapper.roadstuff.item.ItemBrush;

public class BlockPaintBucket extends Block
{

    public BlockPaintBucket(Properties properties)
    {
        super(properties);

    }

    public boolean isSolid(IBlockState state)
    {
        return false;
    }

    public boolean isFullCube(IBlockState state)
    {
        return false;
    }

    public BlockRenderLayer getRenderLayer()
    {
        return BlockRenderLayer.CUTOUT;
    }

    public boolean onBlockActivated(IBlockState state, World worldIn, BlockPos pos, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ)
    {
        if(player.getActiveItemStack().getItem() instanceof ItemBrush)
        {
            System.out.println("Player clicked on bucket with brush!");
            return true;
        }
        
        return false;
    }
}
