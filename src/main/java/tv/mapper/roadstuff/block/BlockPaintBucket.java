package tv.mapper.roadstuff.block;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import tv.mapper.roadstuff.item.ItemBrush;
import tv.mapper.roadstuff.state.properties.EnumPaintColor;

public class BlockPaintBucket extends Block
{
    public static final IntegerProperty PAINT = IntegerProperty.create("paint", 0, 8);
    public static final EnumProperty<EnumPaintColor> COLOR = EnumProperty.create("color", EnumPaintColor.class);
    private static final VoxelShape BUCKET = Block.makeCuboidShape(4.0D, 0.0D, 4.0D, 12.0D, 10.0D, 12.0D);

    public BlockPaintBucket(Properties properties)
    {
        super(properties);
        this.setDefaultState(this.getDefaultState().with(PAINT, 0).with(COLOR, EnumPaintColor.NONE));
    }

    public boolean isSolid(IBlockState state)
    {
        return false;
    }

    public boolean isFullCube(IBlockState state)
    {
        return false;
    }

    public BlockRenderLayer getRenderLayer()
    {
        return BlockRenderLayer.CUTOUT;
    }

    public VoxelShape getShape(IBlockState state, IBlockReader worldIn, BlockPos pos)
    {
        return BUCKET;
    }

    public VoxelShape getCollisionShape(IBlockState state, IBlockReader worldIn, BlockPos pos)
    {
        return BUCKET;
    }

    protected void fillStateContainer(StateContainer.Builder<Block, IBlockState> builder)
    {
        builder.add(PAINT).add(COLOR);
    }

    @Nullable
    public IBlockState getStateForPlacement(BlockItemUseContext context)
    {
        ItemStack stack = context.getItem();

        NBTTagCompound tagCompound = stack.getTag();
        if(tagCompound != null)
        {
            return this.getDefaultState().with(PAINT, stack.getTag().getInt("paint")).with(COLOR, EnumPaintColor.values()[stack.getTag().getInt("color")]);
        }
        return this.getDefaultState().with(PAINT, 0).with(COLOR, EnumPaintColor.NONE);
    }

    public boolean onBlockActivated(IBlockState state, World world, BlockPos pos, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ)
    {
        ItemStack item = player.getHeldItem(hand);

        if(item.getItem() instanceof ItemBrush)
        {
            int paint = state.get(PAINT);

            if(!world.isRemote && paint <= 0)
            {
                player.sendStatusMessage(new TextComponentString(TextFormatting.WHITE + "This bucket is empty!"), true);
                return false;
            }

            if(!item.hasTag())
                item.setTag(ItemBrush.checkNBT(item));

            if(item.getTag().getInt("paint") < ItemBrush.MAX_PAINT && paint > 0)
            {
                if(!world.isRemote)
                {
                    System.out.println("Player clicked on bucket with brush! Paint: " + item.getTag().getInt("paint"));

                    if(paint == 1)

                        world.setBlockState(pos, state.with(PAINT, state.get(PAINT) - 1).with(COLOR, EnumPaintColor.NONE));
                    else
                        world.setBlockState(pos, state.with(PAINT, state.get(PAINT) - 1));

                    item.getTag().setInt("paint", ItemBrush.MAX_PAINT);
                    item.getTag().setInt("color", state.get(COLOR).getId());
                }
                else
                {
                    world.playSound(player, pos, SoundEvents.ITEM_BUCKET_EMPTY_LAVA, SoundCategory.BLOCKS, .8F, 1.0F);
                }
                return true;
            }
        }
        if(item.getItem() instanceof ItemDye)
        {
            ItemDye dye = (ItemDye)item.getItem();

            if(dye.getDyeColor() == EnumDyeColor.WHITE && state.get(COLOR) == EnumPaintColor.YELLOW)
            {
                if(!world.isRemote)
                    player.sendStatusMessage(new TextComponentString(TextFormatting.WHITE + "This bucket is already filled with yellow paint!"), true);
                return false;
            }
            if(dye.getDyeColor() == EnumDyeColor.YELLOW && state.get(COLOR) == EnumPaintColor.WHITE)
            {
                if(!world.isRemote)
                    player.sendStatusMessage(new TextComponentString(TextFormatting.WHITE + "This bucket is already filled with white paint!"), true);
                return false;
            }
            if(state.get(PAINT) >= 8)
            {
                if(!world.isRemote)
                    player.sendStatusMessage(new TextComponentString(TextFormatting.WHITE + "This bucket is full!"), true);
                return false;
            }

            if(state.get(PAINT) < 8)
            {
                if(!world.isRemote)
                {
                    if(dye.getDyeColor() == EnumDyeColor.WHITE)
                    {
                        System.out.println("Player clicked on bucket with white dye!");
                        world.setBlockState(pos, state.with(PAINT, state.get(PAINT) + 1).with(COLOR, EnumPaintColor.WHITE));
                    }
                    else if(dye.getDyeColor() == EnumDyeColor.YELLOW)
                    {
                        System.out.println("Player clicked on bucket with yellow dye!");
                        world.setBlockState(pos, state.with(PAINT, state.get(PAINT) + 1).with(COLOR, EnumPaintColor.YELLOW));
                    }
                    if(!player.isCreative())
                        player.getHeldItem(hand).shrink(1);
                }
                else
                {
                    world.playSound(player, pos, SoundEvents.ITEM_BUCKET_FILL_LAVA, SoundCategory.BLOCKS, .8F, 1.0F);
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public void getDrops(IBlockState state, NonNullList<ItemStack> drops, World world, BlockPos pos, int fortune)
    {
        @SuppressWarnings("deprecation")
        ItemStack stack = new ItemStack(Item.getItemFromBlock(this));
        NBTTagCompound nbt = new NBTTagCompound();
        nbt.setInt("paint", state.getBlockState().get(PAINT));
        nbt.setInt("color", state.getBlockState().get(COLOR).ordinal());

        stack.setTag(nbt);
        drops.add(stack);
    }
}
