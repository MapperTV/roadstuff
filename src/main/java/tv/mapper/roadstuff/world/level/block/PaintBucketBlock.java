package tv.mapper.roadstuff.world.level.block;

import java.util.Optional;

import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.DyeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import tv.mapper.mapperbase.world.level.block.CustomBlock;
import tv.mapper.mapperbase.world.level.block.ToolTiers;
import tv.mapper.mapperbase.world.level.block.ToolTypes;
import tv.mapper.roadstuff.world.item.BrushItem;
import tv.mapper.roadstuff.world.level.block.state.properties.EnumPaintColor;

public class PaintBucketBlock extends CustomBlock implements SimpleWaterloggedBlock
{
    private static final int MAX_PAINT = 8;

    public static final IntegerProperty PAINT = IntegerProperty.create("paint", 0, MAX_PAINT);
    public static final EnumProperty<EnumPaintColor> COLOR = EnumProperty.create("color", EnumPaintColor.class);
    public static final DirectionProperty DIRECTION = HorizontalDirectionalBlock.FACING;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    private static final VoxelShape PAINT_BUCKET = Block.box(4.0D, 0.0D, 4.0D, 12.0D, 10.0D, 12.0D);

    public PaintBucketBlock(Properties properties, ToolTypes tool)
    {
        super(properties, tool);
        this.registerDefaultState(this.defaultBlockState().setValue(PAINT, 0).setValue(COLOR, EnumPaintColor.WHITE).setValue(DIRECTION, Direction.NORTH).setValue(WATERLOGGED, Boolean.valueOf(false)));
    }

    public PaintBucketBlock(Properties properties, ToolTypes tool, ToolTiers tier)
    {
        super(properties, tool, tier);
        this.registerDefaultState(this.defaultBlockState().setValue(PAINT, 0).setValue(COLOR, EnumPaintColor.WHITE).setValue(DIRECTION, Direction.NORTH).setValue(WATERLOGGED, Boolean.valueOf(false)));
    }

    public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context)
    {
        return PAINT_BUCKET;
    }

    public VoxelShape getCollisionShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context)
    {
        return PAINT_BUCKET;
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder)
    {
        builder.add(PAINT, COLOR, DIRECTION, WATERLOGGED);
    }

    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext context)
    {
        ItemStack stack = context.getItemInHand();
        BlockPos blockpos = context.getClickedPos();
        FluidState FluidState = context.getLevel().getFluidState(blockpos);

        CompoundTag tagCompound = stack.getTag();
        if(tagCompound != null)
        {
            return this.defaultBlockState().setValue(PAINT, stack.getTag().getInt("paint")).setValue(COLOR, EnumPaintColor.values()[stack.getTag().getInt("color")]).setValue(DIRECTION, context.getHorizontalDirection()).setValue(WATERLOGGED, Boolean.valueOf(Boolean.valueOf(FluidState.getType() == Fluids.WATER)));
        }
        return this.defaultBlockState().setValue(PAINT, 0).setValue(COLOR, EnumPaintColor.WHITE).setValue(DIRECTION, context.getHorizontalDirection()).setValue(WATERLOGGED, Boolean.valueOf(Boolean.valueOf(FluidState.getType() == Fluids.WATER)));
    }

    @Override
    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result)
    {
        if(state.getValue(WATERLOGGED))
        {
            player.displayClientMessage(new TranslatableComponent("roadstuff.message.bucket.underwater"), true);
            return InteractionResult.FAIL;
        }

        ItemStack item = player.getItemInHand(hand);

        if(item.getItem() instanceof BrushItem)
        {
            int paint = state.getValue(PAINT);

            if(paint <= 0)
            {
                if(!world.isClientSide)
                    player.displayClientMessage(new TranslatableComponent("roadstuff.message.bucket.empty"), true);
                return InteractionResult.FAIL;
            }

            if(!item.hasTag())
                item.setTag(BrushItem.checkNBT(item));

            if((item.getTag().getInt("paint") < ((BrushItem)item.getItem()).getMaxPaint() && paint > 0) || (item.getTag().getInt("paint") == ((BrushItem)item.getItem()).getMaxPaint() && item.getTag().getInt("color") != state.getValue(COLOR).getId()))
            {
                if(!world.isClientSide)
                {
                    if(!player.isCreative())
                        world.setBlockAndUpdate(pos, state.setValue(PAINT, state.getValue(PAINT) - 1));

                    item.getTag().putInt("paint", ((BrushItem)item.getItem()).getMaxPaint());
                    item.getTag().putInt("color", state.getValue(COLOR).getId());
                    world.playSound(null, pos, SoundEvents.BUCKET_EMPTY_LAVA, SoundSource.BLOCKS, .8F, 1.0F);
                }
                return InteractionResult.SUCCESS;
            }
        }
        if(item.getItem() instanceof DyeItem && !world.isClientSide)
        {
            DyeItem dye = (DyeItem)item.getItem();

            if(state.getValue(PAINT) != 0)
            {
                if(dye.getDyeColor() == DyeColor.WHITE && state.getValue(COLOR) == EnumPaintColor.YELLOW)
                {
                    player.displayClientMessage(new TranslatableComponent("roadstuff.message.bucket.yellow"), true);
                    return InteractionResult.FAIL;
                }
                else if(dye.getDyeColor() == DyeColor.YELLOW && state.getValue(COLOR) == EnumPaintColor.WHITE)
                {
                    player.displayClientMessage(new TranslatableComponent("roadstuff.message.bucket.white"), true);
                    return InteractionResult.FAIL;
                }
            }

            if(state.getValue(PAINT) >= MAX_PAINT)
            {
                player.displayClientMessage(new TranslatableComponent("roadstuff.message.bucket.full"), true);
                return InteractionResult.FAIL;
            }

            if(state.getValue(PAINT) < MAX_PAINT)
            {
                if(dye.getDyeColor() == DyeColor.WHITE)
                    world.setBlockAndUpdate(pos, state.setValue(PAINT, state.getValue(PAINT) + 1).setValue(COLOR, EnumPaintColor.WHITE));
                else if(dye.getDyeColor() == DyeColor.YELLOW)
                    world.setBlockAndUpdate(pos, state.setValue(PAINT, state.getValue(PAINT) + 1).setValue(COLOR, EnumPaintColor.YELLOW));
                if(dye.getDyeColor() == DyeColor.WHITE || dye.getDyeColor() == DyeColor.YELLOW)
                {
                    if(!player.isCreative())
                        player.getItemInHand(hand).shrink(1);
                    world.playSound(null, pos, SoundEvents.BUCKET_FILL_LAVA, SoundSource.BLOCKS, .8F, 0.9F);
                }
                return InteractionResult.SUCCESS;
            }
        }
        return InteractionResult.FAIL;
    }

    @Override
    public void playerWillDestroy(Level world, BlockPos pos, BlockState state, Player player)
    {
        if(!world.isClientSide && !player.isCreative())
        {
            @SuppressWarnings("deprecation")
            ItemStack stack = new ItemStack(Item.byBlock(this));
            CompoundTag nbt = new CompoundTag();
            nbt.putInt("paint", state.getValue(PAINT));
            nbt.putInt("color", state.getValue(COLOR).ordinal());

            stack.setTag(nbt);

            ItemEntity itementity = new ItemEntity(world, (double)pos.getX() + 0.5, (double)pos.getY() + 0.5, (double)pos.getZ() + 0.5, stack);
            itementity.setDefaultPickUpDelay();
            world.addFreshEntity(itementity);
        }

        super.playerWillDestroy(world, pos, state, player);
    }

    public boolean canSurvive(BlockState state, LevelReader worldIn, BlockPos pos)
    {
        return canSupportCenter(worldIn, pos.below(), Direction.UP);
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

    public Fluid takeLiquid(LevelAccessor worldIn, BlockPos pos, BlockState state)
    {
        if(state.getValue(WATERLOGGED))
        {
            worldIn.setBlock(pos, state.setValue(WATERLOGGED, Boolean.valueOf(false)), 3);
            return Fluids.WATER;
        }
        else
        {
            return Fluids.EMPTY;
        }
    }

    @SuppressWarnings("deprecation")
    public FluidState getFluidState(BlockState state)
    {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    public boolean canPlaceLiquid(BlockGetter worldIn, BlockPos pos, BlockState state, Fluid fluidIn)
    {
        return !state.getValue(WATERLOGGED) && fluidIn == Fluids.WATER;
    }

    public boolean placeLiquid(LevelAccessor worldIn, BlockPos pos, BlockState state, FluidState fluidStateIn)
    {
        if(!state.getValue(WATERLOGGED) && fluidStateIn.getType() == Fluids.WATER)
        {
            if(!worldIn.isClientSide())
            {
                worldIn.setBlock(pos, state.setValue(WATERLOGGED, Boolean.valueOf(true)), 3);
                worldIn.getLiquidTicks().scheduleTick(pos, fluidStateIn.getType(), fluidStateIn.getType().getTickDelay(worldIn));
            }

            return true;
        }
        else
        {
            return false;
        }
    }

    @Override
    public ToolTiers getTier()
    {
        return this.tier;
    }

    @Override
    public ToolTypes getTool()
    {
        return this.tool;
    }

    @Override
    public ItemStack pickupBlock(LevelAccessor p_152719_, BlockPos p_152720_, BlockState p_152721_)
    {
        return null;
    }

    @Override
    public Optional<SoundEvent> getPickupSound()
    {
        return null;
    }
}