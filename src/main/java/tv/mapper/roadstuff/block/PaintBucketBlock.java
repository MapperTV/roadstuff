package tv.mapper.roadstuff.block;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.IBucketPickupHandler;
import net.minecraft.block.ILiquidContainer;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.IFluidState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.DyeColor;
import net.minecraft.item.DyeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import tv.mapper.roadstuff.item.ItemBrush;
import tv.mapper.roadstuff.state.properties.EnumPaintColor;

public class PaintBucketBlock extends Block implements IBucketPickupHandler, ILiquidContainer
{
    private static final int MAX_PAINT = 8;

    public static final IntegerProperty PAINT = IntegerProperty.create("paint", 0, MAX_PAINT);
    public static final EnumProperty<EnumPaintColor> COLOR = EnumProperty.create("color", EnumPaintColor.class);
    public static final DirectionProperty DIRECTION = HorizontalBlock.HORIZONTAL_FACING;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    private static final VoxelShape PAINT_BUCKET = Block.makeCuboidShape(4.0D, 0.0D, 4.0D, 12.0D, 10.0D, 12.0D);

    public PaintBucketBlock(Properties properties)
    {
        super(properties);
        this.setDefaultState(this.getDefaultState().with(PAINT, 0).with(COLOR, EnumPaintColor.WHITE).with(DIRECTION, Direction.NORTH).with(WATERLOGGED, Boolean.valueOf(false)));
    }

    @Override
    public boolean isSolid(BlockState state)
    {
        return false;
    }

    public BlockRenderLayer getRenderLayer()
    {
        return BlockRenderLayer.CUTOUT;
    }

    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context)
    {
        return PAINT_BUCKET;
    }

    public VoxelShape getCollisionShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context)
    {
        return PAINT_BUCKET;
    }

    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder)
    {
        builder.add(PAINT, COLOR, DIRECTION, WATERLOGGED);
    }

    @Nullable
    public BlockState getStateForPlacement(BlockItemUseContext context)
    {
        ItemStack stack = context.getItem();

        CompoundNBT tagCompound = stack.getTag();
        if(tagCompound != null)
        {
            return this.getDefaultState().with(PAINT, stack.getTag().getInt("paint")).with(COLOR, EnumPaintColor.values()[stack.getTag().getInt("color")]).with(DIRECTION, context.getPlacementHorizontalFacing());
        }
        return this.getDefaultState().with(PAINT, 0).with(COLOR, EnumPaintColor.WHITE).with(DIRECTION, context.getPlacementHorizontalFacing());
    }

    public boolean onBlockActivated(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult result)
    {
        if(state.get(WATERLOGGED))
        {
            player.sendStatusMessage(new StringTextComponent(TextFormatting.WHITE + "You can't interact with a bucket under water!"), true);
            return false;
        }

        ItemStack item = player.getHeldItem(hand);

        if(item.getItem() instanceof ItemBrush)
        {
            int paint = state.get(PAINT);

            if(paint <= 0)
            {
                if(!world.isRemote)
                    player.sendStatusMessage(new StringTextComponent(TextFormatting.WHITE + "This bucket is empty!"), true);
                return false;
            }

            if(!item.hasTag())
                item.setTag(ItemBrush.checkNBT(item));

            if((item.getTag().getInt("paint") < ItemBrush.MAX_PAINT && paint > 0) || (item.getTag().getInt("paint") == ItemBrush.MAX_PAINT && item.getTag().getInt("color") != state.get(COLOR).getId()))
            {
                if(!world.isRemote)
                {
                    world.setBlockState(pos, state.with(PAINT, state.get(PAINT) - 1));

                    item.getTag().putInt("paint", ItemBrush.MAX_PAINT);
                    item.getTag().putInt("color", state.get(COLOR).getId());
                }
                else
                    world.playSound(player, pos, SoundEvents.ITEM_BUCKET_EMPTY_LAVA, SoundCategory.BLOCKS, .8F, 1.0F);
                return true;
            }
        }
        if(item.getItem() instanceof DyeItem)
        {
            DyeItem dye = (DyeItem)item.getItem();

            if(state.get(PAINT) != 0)
            {
                if(dye.getDyeColor() == DyeColor.WHITE && state.get(COLOR) == EnumPaintColor.YELLOW)
                {
                    if(!world.isRemote)
                        player.sendStatusMessage(new StringTextComponent(TextFormatting.WHITE + "This bucket is already filled with yellow paint!"), true);
                    return false;
                }
                else if(dye.getDyeColor() == DyeColor.YELLOW && state.get(COLOR) == EnumPaintColor.WHITE)
                {
                    if(!world.isRemote)
                        player.sendStatusMessage(new StringTextComponent(TextFormatting.WHITE + "This bucket is already filled with white paint!"), true);
                    return false;
                }
            }

            if(state.get(PAINT) >= MAX_PAINT)
            {
                if(!world.isRemote)
                    player.sendStatusMessage(new StringTextComponent(TextFormatting.WHITE + "This bucket is full!"), true);
                return false;
            }

            if(state.get(PAINT) < MAX_PAINT)
            {
                if(!world.isRemote)
                {
                    if(dye.getDyeColor() == DyeColor.WHITE)
                        world.setBlockState(pos, state.with(PAINT, state.get(PAINT) + 1).with(COLOR, EnumPaintColor.WHITE));
                    else if(dye.getDyeColor() == DyeColor.YELLOW)
                        world.setBlockState(pos, state.with(PAINT, state.get(PAINT) + 1).with(COLOR, EnumPaintColor.YELLOW));
                    if(!player.isCreative())
                        player.getHeldItem(hand).shrink(1);
                }
                else
                    world.playSound(player, pos, SoundEvents.ITEM_BUCKET_FILL_LAVA, SoundCategory.BLOCKS, .8F, 0.9F);
                return true;
            }
        }
        return false;
    }

    @Override
    public void onBlockHarvested(World world, BlockPos pos, BlockState state, PlayerEntity player)
    {
        if(!world.isRemote && !player.isCreative())
        {
            @SuppressWarnings("deprecation")
            ItemStack stack = new ItemStack(Item.getItemFromBlock(this));
            CompoundNBT nbt = new CompoundNBT();
            nbt.putInt("paint", state.getBlockState().get(PAINT));
            nbt.putInt("color", state.getBlockState().get(COLOR).ordinal());

            stack.setTag(nbt);

            ItemEntity itementity = new ItemEntity(world, (double)pos.getX() + 0.5, (double)pos.getY() + 0.5, (double)pos.getZ() + 0.5, stack);
            itementity.setDefaultPickupDelay();
            world.addEntity(itementity);
        }

        super.onBlockHarvested(world, pos, state, player);
    }

    public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos)
    {
        BlockPos blockpos = pos.down();
        BlockState blockstate = worldIn.getBlockState(blockpos);
        if(blockstate.getBlock() instanceof PaintBucketBlock || !blockstate.isSolid())
            return false;
        return true;
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
