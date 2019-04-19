package tv.mapper.roadstuff.block;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import tv.mapper.roadstuff.item.ItemBrush;

public class BlockPaintBucket extends Block
{
    private static final VoxelShape BUCKET = Block.makeCuboidShape(4.0D, 0.0D, 4.0D, 12.0D, 10.0D, 12.0D);
    
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
    
    public VoxelShape getShape(IBlockState state, IBlockReader worldIn, BlockPos pos)
    {
        return BUCKET;
    }
    
    public VoxelShape getCollisionShape(IBlockState state, IBlockReader worldIn, BlockPos pos)
    {
        return BUCKET;
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
