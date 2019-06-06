package tv.mapper.roadstuff.block;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.EnumFacing;

public class BlockFourAxis extends BlockPaintable
{
    public static final DirectionProperty DIRECTION = BlockHorizontal.HORIZONTAL_FACING;

    public BlockFourAxis(Properties properties, int materialType)
    {
        super(properties, materialType);
        this.setDefaultState(this.getDefaultState().with(DIRECTION, EnumFacing.NORTH));
    }

    protected void fillStateContainer(StateContainer.Builder<Block, IBlockState> builder)
    {
        builder.add(DIRECTION);
    }

    @Nullable
    public IBlockState getStateForPlacement(BlockItemUseContext context)
    {
        return this.getDefaultState().with(DIRECTION, context.getPlacementHorizontalFacing().getOpposite());
    }
}
