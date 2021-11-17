package tv.mapper.roadstuff.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import tv.mapper.mapperbase.block.PaintableBlock;
import tv.mapper.mapperbase.block.ToolTiers;
import tv.mapper.mapperbase.block.ToolTypes;

public class SlopeBlock extends PaintableBlock implements SimpleWaterloggedBlock
{
    public static final IntegerProperty LAYERS = IntegerProperty.create("layers", 1, 4);
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    protected static final VoxelShape[] SHAPES = new VoxelShape[] {Shapes.empty(), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 4.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 12.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D)};

    public SlopeBlock(Properties properties, ToolTypes tool, int materialType)
    {
        super(properties, tool, materialType);
        this.registerDefaultState(this.stateDefinition.any().setValue(LAYERS, Integer.valueOf(1)).setValue(WATERLOGGED, Boolean.valueOf(false)));
    }

    public SlopeBlock(Properties properties, ToolTypes tool, ToolTiers tier, int materialType)
    {
        super(properties, tool, tier, materialType);
        this.registerDefaultState(this.stateDefinition.any().setValue(LAYERS, Integer.valueOf(1)).setValue(WATERLOGGED, Boolean.valueOf(false)));
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder)
    {
        builder.add(LAYERS, WATERLOGGED);
    }

    public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context)
    {
        return SHAPES[state.getValue(LAYERS)];
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context)
    {
        BlockPos blockpos = context.getClickedPos();
        FluidState FluidState = context.getLevel().getFluidState(blockpos);

        return this.defaultBlockState().setValue(WATERLOGGED, Boolean.valueOf(Boolean.valueOf(FluidState.getType() == Fluids.WATER)));
    }

    @Override
    public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player player, InteractionHand handIn, BlockHitResult hit)
    {
        if(hit.getDirection() == Direction.UP)
        {
            Item itemCheck = null;

            switch(getMaterialType())
            {
                case 0:
                    itemCheck = RSBlockRegistry.ASPHALT_SLOPE.get().asItem();
                    break;
                case 1:
                    itemCheck = RSBlockRegistry.CONCRETE_SLOPE.get().asItem();
                    break;
                default:
                    itemCheck = RSBlockRegistry.ASPHALT_SLOPE.get().asItem();
                    break;
            }

            if(!player.isShiftKeyDown() && state.getValue(LAYERS) < 4)
            {
                ItemStack stack = ItemStack.EMPTY;
                if(player.getMainHandItem().getItem() == itemCheck)
                    stack = player.getMainHandItem();
                else if(player.getOffhandItem().getItem() == itemCheck)
                    stack = player.getOffhandItem();

                if(stack.getItem() == itemCheck)
                {
                    worldIn.setBlockAndUpdate(pos, state.setValue(LAYERS, state.getValue(LAYERS) + 1));
                    if(!worldIn.isClientSide)
                        worldIn.playSound(null, pos, SoundEvents.STONE_PLACE, SoundSource.BLOCKS, 1.0F, 1.0F);

                    if(!player.isCreative())
                        stack.setCount(stack.getCount() - 1);
                    return InteractionResult.SUCCESS;
                }

            }
        }
        return InteractionResult.PASS;
    }

    @SuppressWarnings("deprecation")
    public BlockState updateShape(BlockState stateIn, Direction facing, BlockState facingState, LevelAccessor worldIn, BlockPos currentPos, BlockPos facingPos)
    {
        if(stateIn.getValue(WATERLOGGED))
        {
            worldIn.getLiquidTicks().scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(worldIn));
        }
        return super.updateShape(stateIn, facing, facingState, worldIn, currentPos, facingPos);
    }

    @Override
    public ItemStack getCloneItemStack(BlockGetter worldIn, BlockPos pos, BlockState state)
    {
        switch(materialType)
        {
            case 0:
                return new ItemStack(RSBlockRegistry.ASPHALT_SLOPE.get());
            case 1:
                return new ItemStack(RSBlockRegistry.CONCRETE_SLOPE.get());
            default:
                return null;
        }
    }

    @SuppressWarnings("deprecation")
    public FluidState getFluidState(BlockState state)
    {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }
}