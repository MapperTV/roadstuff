package tv.mapper.roadstuff.block;

import javax.annotation.Nullable;

import net.minecraft.block.BlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraftforge.common.ToolType;
import tv.mapper.roadstuff.tileentity.TrafficSignTileEntity;

public class TrafficSignBlock extends CustomBlock
{
    public TrafficSignBlock(Properties properties)
    {
        super(properties);
    }

    public TrafficSignBlock(Properties properties, ToolType toolType)
    {
        super(properties);
        this.toolType = toolType;
    }

    @Override
    public boolean isSolid(BlockState state)
    {
        return false;
    }

    @Override
    public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos)
    {
        if(!worldIn.getBlockState(pos.down()).isSolid())
            return false;
        return true;
    }

    @Override
    public boolean hasTileEntity(BlockState state)
    {
        return true;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world)
    {
        return new TrafficSignTileEntity();
    }
}
