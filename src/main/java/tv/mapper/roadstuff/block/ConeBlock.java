package tv.mapper.roadstuff.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.StringRepresentable;
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
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import tv.mapper.mapperbase.block.CustomBlock;
import tv.mapper.mapperbase.block.ToolTiers;
import tv.mapper.mapperbase.block.ToolTypes;

public class ConeBlock extends CustomBlock implements SimpleWaterloggedBlock
{
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    private static final VoxelShape CONE_BASE = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 1.0D, 14.0D);
    private static final VoxelShape CONE1 = Block.box(3.0D, 1.0D, 3.0D, 13.0D, 4.0D, 13.0D);
    private static final VoxelShape CONE2 = Block.box(4.0D, 4.0D, 4.0D, 12.0D, 7.0D, 12.0D);
    private static final VoxelShape CONE3 = Block.box(5.0D, 6.0D, 5.0D, 11.0D, 10.0D, 11.0D);
    private static final VoxelShape CONE4 = Block.box(6.0D, 9.0D, 6.0D, 10.0D, 13.0D, 10.0D);
    private static final VoxelShape CONE5 = Block.box(7.0D, 13.0D, 7.0D, 9.0D, 16.0D, 9.0D);

    private static final VoxelShape CONE = Shapes.or(CONE_BASE, Shapes.or(CONE1, Shapes.or(CONE2, Shapes.or(CONE3, Shapes.or(CONE4, CONE5)))));

    private static final VoxelShape CONE_COL = Block.box(4.0D, 0.0D, 4.0D, 10.0D, 18.0D, 10.0D);

    private static final VoxelShape BARREL_BASE = Block.box(1.0D, 0.0D, 1.0D, 15.0D, 1.0D, 15.0D);
    private static final VoxelShape BARREL_MAIN = Block.box(4.0D, 1.0D, 4.0D, 12.0D, 14.0D, 12.0D);
    private static final VoxelShape BARREL_HANDLE = Block.box(5.0D, 14.0D, 7.0D, 11.0D, 16.0D, 9.0D);

    private static final VoxelShape BARREL = Shapes.or(BARREL_BASE, Shapes.or(BARREL_MAIN, BARREL_HANDLE));

    private static final VoxelShape BARREL_COL = Block.box(5.0D, 0.0D, 5.0D, 11.0D, 18.0D, 11.0D);

    private static final VoxelShape BOLLARD_BOTTOM = Block.box(4.0D, 0.0D, 4.0D, 12.0D, 1.0D, 12.0D);
    private static final VoxelShape BOLLARD_BASE = Block.box(6.0D, 1.0D, 6.0D, 10.0D, 2.0D, 10.0D);
    private static final VoxelShape BOLLARD_PORT = Block.box(7.0D, 2.0D, 7.0D, 9.0D, 16.0D, 9.0D);

    private static final VoxelShape BOLLARD = Shapes.or(BOLLARD_BOTTOM, Shapes.or(BOLLARD_BASE, BOLLARD_PORT));

    private static final VoxelShape BOLLARD_COL = Block.box(6.0D, 0.0D, 6.0D, 10.0D, 18.0D, 10.0D);

    private EnumConeType type;

    public ConeBlock(Properties properties, ToolTypes tool, EnumConeType type)
    {
        super(properties, tool);
        this.type = type;
        this.registerDefaultState(this.defaultBlockState().setValue(WATERLOGGED, Boolean.valueOf(false)));
    }

    public ConeBlock(Properties properties, ToolTypes tool, ToolTiers tier, EnumConeType type)
    {
        super(properties, tool, tier);
        this.type = type;
        this.registerDefaultState(this.defaultBlockState().setValue(WATERLOGGED, Boolean.valueOf(false)));
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context)
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
    public VoxelShape getCollisionShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context)
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

    public boolean canSurvive(BlockState state, LevelReader worldIn, BlockPos pos)
    {
        return canSupportCenter(worldIn, pos.below(), Direction.UP);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context)
    {
        BlockPos blockpos = context.getClickedPos();
        FluidState FluidState = context.getLevel().getFluidState(blockpos);

        return this.defaultBlockState().setValue(WATERLOGGED, Boolean.valueOf(Boolean.valueOf(FluidState.getType() == Fluids.WATER)));
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder)
    {
        builder.add(WATERLOGGED);
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

    public enum EnumConeType implements StringRepresentable
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

        public String getSerializedName()
        {
            return this.name;
        }

        public int getId()
        {
            return this.id;
        }
    }
}