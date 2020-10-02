package tv.mapper.roadstuff.block;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;
import net.minecraftforge.common.ToolType;
import tv.mapper.mapperbase.block.CustomBlock;

public class RotatableBlock extends CustomBlock
{
    public static final DirectionProperty DIRECTION = HorizontalBlock.HORIZONTAL_FACING;

    public RotatableBlock(Properties properties)
    {
        super(properties);
        this.setDefaultState(this.getDefaultState().with(DIRECTION, Direction.NORTH));
    }

    public RotatableBlock(Properties properties, ToolType toolType)
    {
        super(properties);
        this.toolType = toolType;
    }

    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder)
    {
        builder.add(DIRECTION);
    }

    @Nullable
    public BlockState getStateForPlacement(BlockItemUseContext context)
    {
        return this.getDefaultState().with(DIRECTION, context.getPlacementHorizontalFacing());
    }
}