package tv.mapper.roadstuff.item;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import tv.mapper.roadstuff.block.BlockFourAxis;
import tv.mapper.roadstuff.block.BlockPaintable;
import tv.mapper.roadstuff.block.BlockTwoAxis;
import tv.mapper.roadstuff.init.ModBlocks;
import tv.mapper.roadstuff.state.properties.EnumPaintColor;

public class ItemBrush extends Item
{
    public static final int MAX_PAINT = 16;

    public ItemBrush(Properties properties)
    {
        super(properties);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand)
    {
        ItemStack stack = player.getHeldItem(hand);

        NBTTagCompound nbt = checkNBT(stack);
        stack.setTag(nbt);

        if(world.isRemote && player.isSneaking())
        {
            ItemBrushClient.displayBrushGui(stack.getTag().getInt("pattern"), stack.getTag().getInt("paint"), EnumPaintColor.getColorByID(stack.getTag().getInt("color")).getName());
        }

        return new ActionResult<>(EnumActionResult.SUCCESS, stack);
    }

    public EnumActionResult onItemUse(ItemUseContext context)
    {
        World world = context.getWorld();
        BlockPos pos = context.getPos();
        EntityPlayer player = context.getPlayer();
        ItemStack stack = context.getItem();
        IBlockState state = world.getBlockState(pos);
        NBTTagCompound nbt = checkNBT(stack);

        int pattern = nbt.getInt("pattern");

        Block newBlock = null;
        boolean playSound = true;

        if(state != null && nbt.hasKey("paint"))
        {
            if(context.getFace() == EnumFacing.UP && state.getBlock() instanceof BlockPaintable)
            {
                switch(pattern)
                {
                    case 0:
                        newBlock = ModBlocks.ASPHALT_BLOCK;
                        break;
                    case 1:
                        newBlock = ModBlocks.ASPHALT_SIMPLE_WHITE_LINE_BLOCK;
                        break;
                    case 2:
                        newBlock = ModBlocks.ASPHALT_DOUBLE_WHITE_LINE_BLOCK;
                        break;
                    case 3:
                        newBlock = ModBlocks.ASPHALT_DASHED_WHITE_LINE_BLOCK;
                        break;
                    case 4:
                        newBlock = ModBlocks.ASPHALT_LARGE_WHITE_LINE_BLOCK;
                        break;
                    case 5:
                        newBlock = ModBlocks.ASPHALT_X_WHITE_LINE_BLOCK;
                        break;
                    case 6:
                        newBlock = ModBlocks.ASPHALT_T_WHITE_LINE_BLOCK;
                        break;
                    case 7:
                        newBlock = ModBlocks.ASPHALT_CORNER_WHITE_LINE_BLOCK;
                        break;
                    case 8:
                        newBlock = ModBlocks.ASPHALT_END_DOUBLE_WHITE_LINE_BLOCK;
                        break;
                    case 9:
                        newBlock = ModBlocks.ASPHALT_DIAGONAL_WHITE_LINE_BLOCK;
                        break;
                    case 10:
                        newBlock = ModBlocks.ASPHALT_LARGE_DIAGONAL_WHITE_LINE_BLOCK;
                        break;
                    default:
                        newBlock = ModBlocks.ASPHALT_BLOCK;
                        break;
                }

                if(pattern == 0)
                {
                    if(!world.isRemote)
                        world.setBlockState(pos, newBlock.getDefaultState());
                    playSound = false;
                }
                else if(state.getBlock() == newBlock)
                {

                    if(newBlock instanceof BlockTwoAxis && !world.isRemote)
                    {
                        player.sendStatusMessage(new TextComponentString(TextFormatting.WHITE + "Same block detected; rotating..."), true);
                        if(state.get(BlockTwoAxis.ROTATION))
                            world.setBlockState(pos, newBlock.getDefaultState().with(BlockTwoAxis.ROTATION, Boolean.valueOf(false)));
                        else
                            world.setBlockState(pos, newBlock.getDefaultState().with(BlockTwoAxis.ROTATION, Boolean.valueOf(true)));
                    }
                    else if(newBlock instanceof BlockFourAxis && !world.isRemote)
                    {
                        player.sendStatusMessage(new TextComponentString(TextFormatting.WHITE + "Same block detected; rotating 90°..."), true);
                        switch(state.get(BlockFourAxis.DIRECTION))
                        {
                            case NORTH:
                                world.setBlockState(pos, newBlock.getDefaultState().with(BlockFourAxis.DIRECTION, EnumFacing.EAST));
                                break;
                            case EAST:
                                world.setBlockState(pos, newBlock.getDefaultState().with(BlockFourAxis.DIRECTION, EnumFacing.SOUTH));
                                break;
                            case SOUTH:
                                world.setBlockState(pos, newBlock.getDefaultState().with(BlockFourAxis.DIRECTION, EnumFacing.WEST));
                                break;
                            case WEST:
                                world.setBlockState(pos, newBlock.getDefaultState().with(BlockFourAxis.DIRECTION, EnumFacing.NORTH));
                                break;
                            default:
                                world.setBlockState(pos, newBlock.getDefaultState().with(BlockFourAxis.DIRECTION, EnumFacing.NORTH));
                                break;
                        }
                    }
                    else
                    {
                        playSound = false;
                    }
                }
                else
                {
                    if(nbt.getInt("paint") > 0 && !world.isRemote)
                    {
                        world.setBlockState(pos, newBlock.getDefaultState());
                        nbt.setInt("paint", nbt.getInt("paint") - 1);
                    }
                }

                if(!world.isRemote && nbt.getInt("paint") == 0)
                    nbt.setInt("color", 0);

                if(playSound && nbt.getInt("paint") > 0)
                    world.playSound(player, pos, SoundEvents.BLOCK_SLIME_BLOCK_FALL, SoundCategory.BLOCKS, .8F, 1.0F);
            }

            stack.setTag(nbt);
            return EnumActionResult.SUCCESS;
        }

        return EnumActionResult.PASS;
    }

    @Override
    public void addInformation(ItemStack stack, World player, List<ITextComponent> list, ITooltipFlag flag)
    {
        super.addInformation(stack, player, list, flag);
        if(stack.hasTag())
        {
            list.add(new TextComponentString("Pattern: " + stack.getTag().getInt("pattern") + ", paint: " + stack.getTag().getInt("paint") + ", color: " + stack.getTag().getInt("color")));
        }
    }

    private NBTTagCompound checkNBT(ItemStack stack)
    {
        NBTTagCompound nbt;

        if(stack.hasTag())
        {
            nbt = stack.getTag();
        }
        else
        {
            nbt = new NBTTagCompound();
            nbt.setInt("paint", 0);
            nbt.setInt("pattern", 0);
            nbt.setInt("color", EnumPaintColor.NONE.getId());
        }
        return nbt;
    }
}
