package tv.mapper.roadstuff.block;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.IFluidState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;
import tv.mapper.roadstuff.init.ModBlocks;

public class SlopeBlock extends PaintableBlock implements IWaterLoggable
{
    public static final IntegerProperty LAYERS = IntegerProperty.create("layers", 1, 4);
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    protected static final VoxelShape[] SHAPES = new VoxelShape[] {VoxelShapes.empty(), Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 4.0D, 16.0D), Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D), Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 12.0D, 16.0D), Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D)};

    public SlopeBlock(Properties properties, int materialType)
    {
        super(properties, materialType);
        this.setDefaultState(this.stateContainer.getBaseState().with(LAYERS, Integer.valueOf(1)).with(WATERLOGGED, Boolean.valueOf(false)));
    }

    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder)
    {
        builder.add(LAYERS, WATERLOGGED);
    }

    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context)
    {
        return SHAPES[state.get(LAYERS)];
    }

    @Override
    public boolean isSolid(BlockState state)
    {
        if(state.get(LAYERS) == 4)
            return true;
        else
            return false;
    }

    @Override
    public boolean onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit)
    {
        if(hit.getFace() == Direction.UP)
        {
            Item itemCheck = null;

            switch(getMaterialType())
            {
                case 0:
                    itemCheck = ModBlocks.ASPHALT_SLOPE.asItem();
                    break;
                case 1:
                    itemCheck = ModBlocks.CONCRETE_SLOPE.asItem();
                    break;
                default:
                    itemCheck = ModBlocks.ASPHALT_SLOPE.asItem();
                    break;
            }

            if(!player.isSneaking() && state.get(LAYERS) < 4)
            {
                ItemStack stack = ItemStack.EMPTY;
                if(player.getHeldItemMainhand().getItem() == itemCheck)
                    stack = player.getHeldItemMainhand();
                else if(player.getHeldItemOffhand().getItem() == itemCheck)
                    stack = player.getHeldItemOffhand();

                if(stack.getItem() == itemCheck)
                {
                    worldIn.setBlockState(pos, state.with(LAYERS, state.get(LAYERS) + 1));
                    if(!worldIn.isRemote)
                        worldIn.playSound(null, pos, SoundEvents.BLOCK_STONE_PLACE, SoundCategory.BLOCKS, 1.0F, 1.0F);

                    if(!player.isCreative())
                        stack.setCount(stack.getCount() - 1);
                    return true;
                }

            }
        }
        return false;
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

    @SuppressWarnings("deprecation")
    public IFluidState getFluidState(BlockState state)
    {
        return state.get(WATERLOGGED) ? Fluids.WATER.getStillFluidState(false) : super.getFluidState(state);
    }

    @Nullable
    @Override
    public ToolType getHarvestTool(BlockState state)
    {
        return ToolType.PICKAXE;
    }
}
