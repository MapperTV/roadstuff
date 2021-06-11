package tv.mapper.roadstuff.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;

public class ConeBlock extends Block implements IWaterLoggable
{
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    private static final VoxelShape CONE_BASE = Block.makeCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 1.0D, 14.0D);
    private static final VoxelShape CONE1 = Block.makeCuboidShape(3.0D, 2.0D, 3.0D, 13.0D, 4.0D, 13.0D);
    private static final VoxelShape CONE2 = Block.makeCuboidShape(4.0D, 4.0D, 4.0D, 12.0D, 7.0D, 12.0D);
    private static final VoxelShape CONE3 = Block.makeCuboidShape(5.0D, 6.0D, 5.0D, 11.0D, 10.0D, 11.0D);
    private static final VoxelShape CONE4 = Block.makeCuboidShape(6.0D, 9.0D, 6.0D, 10.0D, 13.0D, 10.0D);
    private static final VoxelShape CONE5 = Block.makeCuboidShape(7.0D, 13.0D, 7.0D, 9.0D, 16.0D, 9.0D);
    
    private static final VoxelShape CONE = VoxelShapes.or(CONE_BASE, VoxelShapes.or(CONE1, VoxelShapes.or(CONE2, VoxelShapes.or(CONE3, VoxelShapes.or(CONE4, CONE5)))));

    private static final VoxelShape CONE_COL = Block.makeCuboidShape(4.0D, 0.0D, 4.0D, 10.0D, 18.0D, 10.0D);

    private static final VoxelShape BARREL_BASE = Block.makeCuboidShape(1.0D, 0.0D, 1.0D, 15.0D, 1.0D, 15.0D);
    private static final VoxelShape BARREL_MAIN = Block.makeCuboidShape(4.0D, 1.0D, 4.0D, 12.0D, 14.0D, 12.0D);
    private static final VoxelShape BARREL_HANDLE = Block.makeCuboidShape(5.0D, 14.0D, 7.0D, 11.0D, 16.0D, 9.0D);

    private static final VoxelShape BARREL = VoxelShapes.or(BARREL_BASE, VoxelShapes.or(BARREL_MAIN, BARREL_HANDLE));

    private static final VoxelShape BARREL_COL = Block.makeCuboidShape(5.0D, 0.0D, 5.0D, 11.0D, 18.0D, 11.0D);

    private static final VoxelShape BOLLARD_BOTTOM = Block.makeCuboidShape(4.0D, 0.0D, 4.0D, 12.0D, 1.0D, 12.0D);
    private static final VoxelShape BOLLARD_BASE = Block.makeCuboidShape(6.0D, 1.0D, 6.0D, 10.0D, 2.0D, 10.0D);
    private static final VoxelShape BOLLARD_PORT = Block.makeCuboidShape(7.0D, 2.0D, 7.0D, 9.0D, 16.0D, 9.0D);

    private static final VoxelShape BOLLARD = VoxelShapes.or(BOLLARD_BOTTOM, VoxelShapes.or(BOLLARD_BASE, BOLLARD_PORT));
    
    private static final VoxelShape BOLLARD_COL = Block.makeCuboidShape(6.0D, 0.0D, 6.0D, 10.0D, 18.0D, 10.0D);

    private EnumConeType type;

    public ConeBlock(Properties properties, EnumConeType type)
    {
        super(properties);
        this.type = type;
        this.setDefaultState(this.getDefaultState().with(WATERLOGGED, Boolean.valueOf(false)));
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context)
    {
        switch(type)
        {
            case CONE:
                return CONE;
            case BARREL:
                return BARREL;
            case BOLLARD:
                return BOLLARD;
            default:
                return CONE;
        }
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context)
    {
        switch(type)
        {
            case CONE:
                return CONE_COL;
            case BARREL:
                return BARREL_COL;
            case BOLLARD:
                return BOLLARD_COL;
            default:
                return CONE;
        }
    }

    public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos)
    {
        return hasEnoughSolidSide(worldIn, pos.down(), Direction.UP);
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context)
    {
        BlockPos blockpos = context.getPos();
        FluidState FluidState = context.getWorld().getFluidState(blockpos);

        return this.getDefaultState().with(WATERLOGGED, Boolean.valueOf(Boolean.valueOf(FluidState.getFluid() == Fluids.WATER)));
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

        if(facing == Direction.DOWN && !this.isValidPosition(stateIn, worldIn, currentPos))
            return Blocks.AIR.getDefaultState();

        return super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);
    }

    @SuppressWarnings("deprecation")
    public FluidState getFluidState(BlockState state)
    {
        return state.get(WATERLOGGED) ? Fluids.WATER.getStillFluidState(false) : super.getFluidState(state);
    }

    public enum EnumConeType implements IStringSerializable
    {
        CONE(0, "cone"),
        BARREL(1, "barrel"),
        BOLLARD(2, "bollard");

        private final int id;
        private final String name;

        private EnumConeType(int id, String name)
        {
            this.id = id;
            this.name = name;
        }

        public String getString()
        {
            return this.name;
        }

        public int getId()
        {
            return this.id;
        }
    }
}