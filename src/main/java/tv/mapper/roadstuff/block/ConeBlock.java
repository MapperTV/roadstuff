package tv.mapper.roadstuff.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.IFluidState;
import net.minecraft.state.BooleanProperty;
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

public class ConeBlock extends Block
{
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    private static final VoxelShape BASE = Block.makeCuboidShape(1.0D, 0.0D, 1.0D, 15.0D, 1.0D, 15.0D);
    private static final VoxelShape CONE1 = Block.makeCuboidShape(3.0D, 0.0D, 3.0D, 13.0D, 4.0D, 13.0D);
    private static final VoxelShape CONE2 = Block.makeCuboidShape(4.0D, 4.0D, 4.0D, 12.0D, 7.0D, 12.0D);
    private static final VoxelShape CONE3 = Block.makeCuboidShape(5.0D, 6.0D, 5.0D, 11.0D, 10.0D, 11.0D);
    private static final VoxelShape CONE4 = Block.makeCuboidShape(6.0D, 9.0D, 6.0D, 10.0D, 13.0D, 10.0D);
    private static final VoxelShape CONE5 = Block.makeCuboidShape(7.0D, 13.0D, 7.0D, 9.0D, 16.0D, 9.0D);

    private static final VoxelShape CONE = VoxelShapes.or(BASE, VoxelShapes.or(CONE1, VoxelShapes.or(CONE2, VoxelShapes.or(CONE3, VoxelShapes.or(CONE4, CONE5)))));

    public ConeBlock(Properties properties)
    {
        super(properties);
        this.setDefaultState(this.getDefaultState().with(WATERLOGGED, Boolean.valueOf(false)));
    }

    @Override
    public boolean isSolid(BlockState state)
    {
        return false;
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context)
    {
        return CONE;
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context)
    {
        return CONE;
    }

    public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos)
    {
        if(!worldIn.getBlockState(pos.down()).isSolid())
            return false;
        return true;
    }

    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder)
    {
        builder.add(WATERLOGGED);
    }

    @SuppressWarnings("deprecation")
    public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos)
    {
        if(stateIn.get(WATERLOGGED))
        {
            worldIn.getPendingFluidTicks().scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickRate(worldIn));
        }

        return super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);
    }

    public Fluid pickupFluid(IWorld worldIn, BlockPos pos, BlockState state)
    {
        if(state.get(WATERLOGGED))
        {
            worldIn.setBlockState(pos, state.with(WATERLOGGED, Boolean.valueOf(false)), 3);
            return Fluids.WATER;
        }
        else
        {
            return Fluids.EMPTY;
        }
    }

    @SuppressWarnings("deprecation")
    public IFluidState getFluidState(BlockState state)
    {
        return state.get(WATERLOGGED) ? Fluids.WATER.getStillFluidState(false) : super.getFluidState(state);
    }

    public boolean canContainFluid(IBlockReader worldIn, BlockPos pos, BlockState state, Fluid fluidIn)
    {
        return !state.get(WATERLOGGED) && fluidIn == Fluids.WATER;
    }

    public boolean receiveFluid(IWorld worldIn, BlockPos pos, BlockState state, IFluidState fluidStateIn)
    {
        if(!state.get(WATERLOGGED) && fluidStateIn.getFluid() == Fluids.WATER)
        {
            if(!worldIn.isRemote())
            {
                worldIn.setBlockState(pos, state.with(WATERLOGGED, Boolean.valueOf(true)), 3);
                worldIn.getPendingFluidTicks().scheduleTick(pos, fluidStateIn.getFluid(), fluidStateIn.getFluid().getTickRate(worldIn));
            }

            return true;
        }
        else
        {
            return false;
        }
    }
}
