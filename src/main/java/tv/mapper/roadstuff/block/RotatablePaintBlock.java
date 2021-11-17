package tv.mapper.roadstuff.block;

import javax.annotation.Nullable;

import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import tv.mapper.mapperbase.block.PaintableBlock;
import tv.mapper.mapperbase.block.ToolTiers;
import tv.mapper.mapperbase.block.ToolTypes;

public class RotatablePaintBlock extends PaintableBlock
{
    public static final DirectionProperty DIRECTION = HorizontalDirectionalBlock.FACING;

    public RotatablePaintBlock(Properties properties, ToolTypes tool, int materialType)
    {
        super(properties, tool, materialType);
        this.registerDefaultState(this.defaultBlockState().setValue(DIRECTION, Direction.NORTH));
    }

    public RotatablePaintBlock(Properties properties, ToolTypes tool, ToolTiers tier, int materialType)
    {
        super(properties, tool, tier, materialType);
        this.registerDefaultState(this.defaultBlockState().setValue(DIRECTION, Direction.NORTH));
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder)
    {
        builder.add(DIRECTION);
    }

    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext context)
    {
        return this.defaultBlockState().setValue(DIRECTION, context.getHorizontalDirection());
    }
}