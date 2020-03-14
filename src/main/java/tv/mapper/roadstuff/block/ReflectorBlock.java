package tv.mapper.roadstuff.block;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.IFluidState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;

public class ReflectorBlock extends Block implements IWaterLoggable
{
    public static final DirectionProperty DIRECTION = HorizontalBlock.HORIZONTAL_FACING;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    @SuppressWarnings("unused")
    private boolean isLuminescent;

    private static final VoxelShape SHAPE_EW = Block.makeCuboidShape(4.0D, 0.0D, 5.0D, 12.0D, 2.0D, 11.0D);
    private static final VoxelShape SHAPE_NS = Block.makeCuboidShape(5.0D, 0.0D, 4.0D, 11.0D, 2.0D, 12.0D);

    public ReflectorBlock(Properties properties, boolean isLuminescent)
    {
        super(properties);
        this.setDefaultState(this.stateContainer.getBaseState().with(DIRECTION, Direction.NORTH).with(WATERLOGGED, Boolean.valueOf(false)));
        this.isLuminescent = isLuminescent;
    }

    @Override
    public boolean canSpawnInBlock()
    {
        return true;
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context)
    {
        switch((Direction)state.get(DIRECTION))
        {
            case NORTH:
                return SHAPE_NS;
            case SOUTH:
                return SHAPE_NS;
            case WEST:
                return SHAPE_EW;
            case EAST:
                return SHAPE_EW;
            default:
                return SHAPE_NS;
        }
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context)
    {
        return VoxelShapes.empty();
    }

    public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos)
    {
        return hasEnoughSolidSide(worldIn, pos.down(), Direction.UP);
    }

    @Nullable
    public BlockState getStateForPlacement(BlockItemUseContext context)
    {
        BlockPos blockpos = context.getPos();
        IFluidState ifluidstate = context.getWorld().getFluidState(blockpos);

        return this.getDefaultState().with(DIRECTION, context.getPlacementHorizontalFacing()).with(WATERLOGGED, Boolean.valueOf(Boolean.valueOf(ifluidstate.getFluid() == Fluids.WATER)));
    }

    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder)
    {
        builder.add(DIRECTION).add(WATERLOGGED);
    }

    @SuppressWarnings("deprecation")
    public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos)
    {
        if(stateIn.get(WATERLOGGED))
        {
            worldIn.getPendingFluidTicks().scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickRate(worldIn));
        }

        if(facing == Direction.DOWN && !this.isValidPosition(stateIn, worldIn, currentPos))
            return Blocks.AIR.getDefaultState();

        return super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);
    }

    @SuppressWarnings("deprecation")
    public IFluidState getFluidState(BlockState state)
    {
        return state.get(WATERLOGGED) ? Fluids.WATER.getStillFluidState(false) : super.getFluidState(state);
    }
}
