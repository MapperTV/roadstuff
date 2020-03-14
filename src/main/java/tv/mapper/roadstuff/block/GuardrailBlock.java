package tv.mapper.roadstuff.block;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FourWayBlock;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.IFluidState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraftforge.common.ToolType;

public class GuardrailBlock extends FourWayBlock
{
    protected ToolType toolType = null;

    public GuardrailBlock(Properties properties)
    {
        super(2.0F, 2.0F, 16.0F, 16.0F, 16.0F, properties);
        this.setDefaultState(
            this.stateContainer.getBaseState().with(NORTH, Boolean.valueOf(false)).with(EAST, Boolean.valueOf(false)).with(SOUTH, Boolean.valueOf(false)).with(WEST, Boolean.valueOf(false)).with(WATERLOGGED,
                Boolean.valueOf(false)));
    }

    public GuardrailBlock(Properties properties, ToolType toolType)
    {
        super(2.0F, 2.0F, 16.0F, 16.0F, 16.0F, properties);
        this.setDefaultState(
            this.stateContainer.getBaseState().with(NORTH, Boolean.valueOf(false)).with(EAST, Boolean.valueOf(false)).with(SOUTH, Boolean.valueOf(false)).with(WEST, Boolean.valueOf(false)).with(WATERLOGGED,
                Boolean.valueOf(false)));
        this.toolType = toolType;
    }

    public BlockState getStateForPlacement(BlockItemUseContext context)
    {
        IBlockReader iblockreader = context.getWorld();
        BlockPos blockpos = context.getPos();
        IFluidState ifluidstate = context.getWorld().getFluidState(context.getPos());
        BlockPos blockpos1 = blockpos.north();
        BlockPos blockpos2 = blockpos.east();
        BlockPos blockpos3 = blockpos.south();
        BlockPos blockpos4 = blockpos.west();
        BlockState blockstate = iblockreader.getBlockState(blockpos1);
        BlockState blockstate1 = iblockreader.getBlockState(blockpos2);
        BlockState blockstate2 = iblockreader.getBlockState(blockpos3);
        BlockState blockstate3 = iblockreader.getBlockState(blockpos4);
        return super.getStateForPlacement(context).with(NORTH, Boolean.valueOf(this.func_220111_a(blockstate, blockstate.canBeConnectedTo(iblockreader, blockpos1, Direction.SOUTH), Direction.SOUTH))).with(EAST,
            Boolean.valueOf(this.func_220111_a(blockstate1, blockstate1.canBeConnectedTo(iblockreader, blockpos2, Direction.WEST), Direction.WEST))).with(SOUTH,
                Boolean.valueOf(this.func_220111_a(blockstate2, blockstate2.canBeConnectedTo(iblockreader, blockpos3, Direction.NORTH), Direction.NORTH))).with(WEST,
                    Boolean.valueOf(this.func_220111_a(blockstate3, blockstate3.canBeConnectedTo(iblockreader, blockpos4, Direction.EAST), Direction.EAST))).with(WATERLOGGED,
                        Boolean.valueOf(ifluidstate.getFluid() == Fluids.WATER));
    }

    @SuppressWarnings("deprecation")
    public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos)
    {
        if(stateIn.get(WATERLOGGED))
        {
            worldIn.getPendingFluidTicks().scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickRate(worldIn));
        }

        return facing.getAxis().getPlane() == Direction.Plane.HORIZONTAL ? stateIn.with(FACING_TO_PROPERTY_MAP.get(facing),
            Boolean.valueOf(this.func_220111_a(facingState, facingState.canBeConnectedTo(worldIn, facingPos, facing.getOpposite()), facing.getOpposite()))) : super.updatePostPlacement(stateIn, facing,
                facingState, worldIn, currentPos, facingPos);
    }

    public boolean func_220111_a(BlockState p_220111_1_, boolean p_220111_2_, Direction p_220111_3_)
    {
        Block block = p_220111_1_.getBlock();
        boolean flag = block instanceof GuardrailBlock && p_220111_1_.getMaterial() == this.material;
        return !cannotAttach(block) && p_220111_2_ || flag;
    }

    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder)
    {
        builder.add(NORTH, EAST, WEST, SOUTH, WATERLOGGED);
    }

    @Nullable
    @Override
    public ToolType getHarvestTool(BlockState state)
    {
        if(toolType != null)
            return this.toolType;
        else
            return super.getHarvestTool(state);
    }
}