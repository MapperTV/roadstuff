package tv.mapper.roadstuff.block;

import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import tv.mapper.mapperbase.block.ToolTiers;
import tv.mapper.mapperbase.block.ToolTypes;

public class BollardBlock extends RotatableBlock implements SimpleWaterloggedBlock
{
    private static final VoxelShape EUR_BOLLARD_N = Block.box(7.0D, 0.0D, 7.0D, 10.0D, 16.0D, 9.0D);
    private static final VoxelShape EUR_BOLLARD_E = Block.box(7.0D, 0.0D, 7.0D, 9.0D, 16.0D, 10.0D);
    private static final VoxelShape EUR_BOLLARD_S = Block.box(6.0D, 0.0D, 7.0D, 9.0D, 16.0D, 9.0D);
    private static final VoxelShape EUR_BOLLARD_W = Block.box(7.0D, 0.0D, 6.0D, 9.0D, 16.0D, 9.0D);

    private static final VoxelShape EUR_SMALL_BOLLARD_N = Block.box(7.0D, 0.0D, 7.0D, 9.0D, 8.0D, 8.0D);
    private static final VoxelShape EUR_SMALL_BOLLARD_E = Block.box(8.0D, 0.0D, 7.0D, 9.0D, 8.0D, 9.0D);
    private static final VoxelShape EUR_SMALL_BOLLARD_S = Block.box(7.0D, 0.0D, 8.0D, 9.0D, 8.0D, 9.0D);
    private static final VoxelShape EUR_SMALL_BOLLARD_W = Block.box(7.0D, 0.0D, 7.0D, 8.0D, 8.0D, 9.0D);

    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    private boolean small = false;

    public BollardBlock(Properties properties, ToolTypes tool, boolean small)
    {
        super(properties, tool);
        this.registerDefaultState(this.defaultBlockState().setValue(DIRECTION, Direction.NORTH).setValue(WATERLOGGED, Boolean.valueOf(false)));
        this.small = small;
    }

    public BollardBlock(Properties properties, ToolTypes tool, ToolTiers tier, boolean small)
    {
        super(properties, tool, tier);
        this.registerDefaultState(this.defaultBlockState().setValue(DIRECTION, Direction.NORTH).setValue(WATERLOGGED, Boolean.valueOf(false)));
        this.small = small;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context)
    {
        if(small)
            switch((Direction)state.getValue(DIRECTION))
            {
                case NORTH:
                    return EUR_SMALL_BOLLARD_N;
                case EAST:
                    return EUR_SMALL_BOLLARD_E;
                case SOUTH:
                    return EUR_SMALL_BOLLARD_S;
                case WEST:
                    return EUR_SMALL_BOLLARD_W;
                default:
                    return EUR_SMALL_BOLLARD_N;
            }
        else
            switch((Direction)state.getValue(DIRECTION))
            {
                case NORTH:
                    return EUR_BOLLARD_N;
                case EAST:
                    return EUR_BOLLARD_E;
                case SOUTH:
                    return EUR_BOLLARD_S;
                case WEST:
                    return EUR_BOLLARD_W;
                default:
                    return EUR_BOLLARD_N;
            }
    }

    public boolean canSurvive(BlockState state, LevelReader worldIn, BlockPos pos)
    {
        return canSupportCenter(worldIn, pos.below(), Direction.UP);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context)
    {
        BlockPos blockpos = context.getClickedPos();
        FluidState FluidState = context.getLevel().getFluidState(blockpos);

        return this.defaultBlockState().setValue(DIRECTION, context.getHorizontalDirection()).setValue(WATERLOGGED, Boolean.valueOf(Boolean.valueOf(FluidState.getType() == Fluids.WATER)));
    }

    @SuppressWarnings("deprecation")
    public BlockState updateShape(BlockState stateIn, Direction facing, BlockState facingState, LevelAccessor worldIn, BlockPos currentPos, BlockPos facingPos)
    {
        if(stateIn.getValue(WATERLOGGED))
        {
            worldIn.getLiquidTicks().scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(worldIn));
        }

        if(facing == Direction.DOWN && !this.canSurvive(stateIn, worldIn, currentPos))
            return Blocks.AIR.defaultBlockState();

        return super.updateShape(stateIn, facing, facingState, worldIn, currentPos, facingPos);
    }

    @SuppressWarnings("deprecation")
    public FluidState getFluidState(BlockState state)
    {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder)
    {
        builder.add(DIRECTION).add(WATERLOGGED);
    }
}