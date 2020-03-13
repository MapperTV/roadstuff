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
import tv.mapper.mapperbase.block.PaintableBlock;

public class RotatablePaintBlock extends PaintableBlock
{
    public static final DirectionProperty DIRECTION = HorizontalBlock.HORIZONTAL_FACING;

    public RotatablePaintBlock(Properties properties, ToolType toolType, int materialType)
    {
        super(properties, toolType, materialType);
        this.setDefaultState(this.getDefaultState().with(DIRECTION, Direction.NORTH));
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

    @Nullable
    @Override
    public ToolType getHarvestTool(BlockState state)
    {
        return ToolType.PICKAXE;
    }
}
