package tv.mapper.roadstuff.block;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;
import net.minecraftforge.common.ToolType;

public class TrafficSignPostBlock extends CustomBlock
{

    public TrafficSignPostBlock(Properties properties)
    {
        super(properties);
    }

    public TrafficSignPostBlock(Properties properties, ToolType toolType)
    {
        super(properties, toolType);
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
}
