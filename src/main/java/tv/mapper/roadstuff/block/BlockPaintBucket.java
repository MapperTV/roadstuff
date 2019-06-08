package tv.mapper.roadstuff.block;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.DyeColor;
import net.minecraft.item.DyeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.Hand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import tv.mapper.roadstuff.item.ItemBrush;
import tv.mapper.roadstuff.state.properties.EnumPaintColor;

public class BlockPaintBucket extends Block
{
    private static final int MAX_PAINT = 8;

    public static final IntegerProperty PAINT = IntegerProperty.create("paint", 0, MAX_PAINT);
    public static final EnumProperty<EnumPaintColor> COLOR = EnumProperty.create("color", EnumPaintColor.class);
    private static final VoxelShape BUCKET = Block.makeCuboidShape(4.0D, 0.0D, 4.0D, 12.0D, 10.0D, 12.0D);

    public BlockPaintBucket(Properties properties)
    {
        super(properties);
        this.setDefaultState(this.getDefaultState().with(PAINT, 0).with(COLOR, EnumPaintColor.WHITE));
    }

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
        return BUCKET;
    }

    public VoxelShape getCollisionShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context)
    {
        return BUCKET;
    }

    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder)
    {
        builder.add(PAINT).add(COLOR);
    }

    @Nullable
    public BlockState getStateForPlacement(BlockItemUseContext context)
    {
        ItemStack stack = context.getItem();

        CompoundNBT tagCompound = stack.getTag();
        if(tagCompound != null)
        {
            return this.getDefaultState().with(PAINT, stack.getTag().getInt("paint")).with(COLOR, EnumPaintColor.values()[stack.getTag().getInt("color")]);
        }
        return this.getDefaultState().with(PAINT, 0).with(COLOR, EnumPaintColor.WHITE);
    }

    public boolean onBlockActivated(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult result)
    {
        ItemStack item = player.getHeldItem(hand);

        if(item.getItem() instanceof ItemBrush)
        {
            int paint = state.get(PAINT);

            if(!world.isRemote && paint <= 0)
            {
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
                    world.playSound(player, pos, SoundEvents.ITEM_BUCKET_FILL_LAVA, SoundCategory.BLOCKS, .8F, 1.0F);
                return true;
            }
        }
        return false;
    }

    // @Override
    public void getDrops(BlockState state, NonNullList<ItemStack> drops, World world, BlockPos pos, int fortune)
    {
        @SuppressWarnings("deprecation")
        ItemStack stack = new ItemStack(Item.getItemFromBlock(this));
        CompoundNBT nbt = new CompoundNBT();
        nbt.putInt("paint", state.getBlockState().get(PAINT));
        nbt.putInt("color", state.getBlockState().get(COLOR).ordinal());

        stack.setTag(nbt);
        drops.add(stack);
    }
}
