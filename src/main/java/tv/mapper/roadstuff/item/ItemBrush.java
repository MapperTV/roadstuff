package tv.mapper.roadstuff.item;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
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
        this.addPropertyOverride(new ResourceLocation("color"), (itemStack, world, entity) ->
        {
            CompoundNBT nbt = checkNBT(itemStack);
            if(nbt.getInt("paint") == 0)
                return 0.0f;
            else if(nbt.getInt("color") == 0)
                return 0.5f;
            else if(nbt.getInt("color") == 1)
                return 1.0f;
            return 0.0f;
        });
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand hand)
    {
        ItemStack stack = player.getHeldItem(hand);

        CompoundNBT nbt = checkNBT(stack);
        stack.setTag(nbt);

        if(world.isRemote && player.isSneaking())
        {
            ItemBrushClient.displayBrushGui(stack.getTag().getInt("pattern"), stack.getTag().getInt("paint"), stack.getTag().getInt("color"));
        }

        return new ActionResult<>(ActionResultType.SUCCESS, stack);
    }

    public ActionResultType onItemUse(ItemUseContext context)
    {
        World world = context.getWorld();
        BlockPos pos = context.getPos();
        PlayerEntity player = context.getPlayer();
        ItemStack stack = context.getItem();
        BlockState state = world.getBlockState(pos);
        CompoundNBT nbt = checkNBT(stack);
        stack.setTag(nbt);

        int pattern = nbt.getInt("pattern");
        int color = nbt.getInt("color");

        Block newBlock = null;
        boolean playSound = false;

        if(player.isSneaking())
        {
            if(world.isRemote)
                ItemBrushClient.displayBrushGui(stack.getTag().getInt("pattern"), stack.getTag().getInt("paint"), stack.getTag().getInt("color"));
            return ActionResultType.SUCCESS;
        }

        if(state != null && nbt.contains("paint"))
        {
            if(context.getFace() == Direction.UP && state.getBlock() instanceof BlockPaintable)
            {
                switch(pattern)
                {
                    case 0:
                        newBlock = ModBlocks.ASPHALT_BLOCK;
                        break;
                    case 1:
                        if(color == 0)
                            newBlock = ModBlocks.ASPHALT_SIMPLE_WHITE_LINE_BLOCK;
                        else if(color == 1)
                            newBlock = ModBlocks.ASPHALT_SIMPLE_YELLOW_LINE_BLOCK;
                        break;
                    case 2:
                        if(color == 0)
                            newBlock = ModBlocks.ASPHALT_DOUBLE_WHITE_LINE_BLOCK;
                        else if(color == 1)
                            newBlock = ModBlocks.ASPHALT_DOUBLE_YELLOW_LINE_BLOCK;
                        break;
                    case 3:
                        if(color == 0)
                            newBlock = ModBlocks.ASPHALT_DASHED_WHITE_LINE_BLOCK;
                        else if(color == 1)
                            newBlock = ModBlocks.ASPHALT_DASHED_YELLOW_LINE_BLOCK;
                        break;
                    case 4:
                        if(color == 0)
                            newBlock = ModBlocks.ASPHALT_LARGE_WHITE_LINE_BLOCK;
                        else if(color == 1)
                            newBlock = ModBlocks.ASPHALT_LARGE_YELLOW_LINE_BLOCK;
                        break;
                    case 5:
                        if(color == 0)
                            newBlock = ModBlocks.ASPHALT_X_WHITE_LINE_BLOCK;
                        else if(color == 1)
                            newBlock = ModBlocks.ASPHALT_X_YELLOW_LINE_BLOCK;
                        break;
                    case 6:
                        if(color == 0)
                            newBlock = ModBlocks.ASPHALT_T_WHITE_LINE_BLOCK;
                        else if(color == 1)
                            newBlock = ModBlocks.ASPHALT_T_YELLOW_LINE_BLOCK;
                        break;
                    case 7:
                        if(color == 0)
                            newBlock = ModBlocks.ASPHALT_CORNER_WHITE_LINE_BLOCK;
                        else if(color == 1)
                            newBlock = ModBlocks.ASPHALT_CORNER_YELLOW_LINE_BLOCK;
                        break;
                    case 8:
                        if(color == 0)
                            newBlock = ModBlocks.ASPHALT_END_DOUBLE_WHITE_LINE_BLOCK;
                        else if(color == 1)
                            newBlock = ModBlocks.ASPHALT_END_DOUBLE_YELLOW_LINE_BLOCK;
                        break;
                    case 9:
                        if(color == 0)
                            newBlock = ModBlocks.ASPHALT_DIAGONAL_WHITE_LINE_BLOCK;
                        else if(color == 1)
                            newBlock = ModBlocks.ASPHALT_DIAGONAL_YELLOW_LINE_BLOCK;
                        break;
                    case 10:
                        if(color == 0)
                            newBlock = ModBlocks.ASPHALT_LARGE_DIAGONAL_WHITE_LINE_BLOCK;
                        else if(color == 1)
                            newBlock = ModBlocks.ASPHALT_LARGE_DIAGONAL_YELLOW_LINE_BLOCK;
                        break;
                    case 11:
                        if(color == 0)
                            newBlock = ModBlocks.ASPHALT_DOUBLE_DIAGONAL_WHITE_LINE_BLOCK;
                        else if(color == 1)
                            newBlock = ModBlocks.ASPHALT_DOUBLE_DIAGONAL_YELLOW_LINE_BLOCK;
                        break;
                    case 12:
                        if(color == 0)
                            newBlock = ModBlocks.ASPHALT_SIMPLE_LEFT_WHITE_LINE_BLOCK;
                        else if(color == 1)
                            newBlock = ModBlocks.ASPHALT_SIMPLE_LEFT_YELLOW_LINE_BLOCK;
                        break;
                    case 13:
                        if(color == 0)
                            newBlock = ModBlocks.ASPHALT_SIMPLE_RIGHT_WHITE_LINE_BLOCK;
                        else if(color == 1)
                            newBlock = ModBlocks.ASPHALT_SIMPLE_RIGHT_YELLOW_LINE_BLOCK;
                        break;
                    case 14:
                        if(color == 0)
                            newBlock = ModBlocks.ASPHALT_SIMPLE_LEFT_RIGHT_WHITE_LINE_BLOCK;
                        else if(color == 1)
                            newBlock = ModBlocks.ASPHALT_SIMPLE_LEFT_RIGHT_YELLOW_LINE_BLOCK;
                        break;
                    case 15:
                        if(color == 0)
                            newBlock = ModBlocks.ASPHALT_SIMPLE_SEPARATOR_WHITE_LINE_BLOCK;
                        else if(color == 1)
                            newBlock = ModBlocks.ASPHALT_SIMPLE_SEPARATOR_YELLOW_LINE_BLOCK;
                        break;
                    case 16:
                        if(color == 0)
                            newBlock = ModBlocks.ASPHALT_SIMPLE_WHITE_ARROW_BLOCK;
                        else if(color == 1)
                            newBlock = ModBlocks.ASPHALT_SIMPLE_YELLOW_ARROW_BLOCK;
                        break;
                    case 17:
                        if(color == 0)
                            newBlock = ModBlocks.ASPHALT_SIMPLE_WHITE_LEFT_ARROW_BLOCK;
                        else if(color == 1)
                            newBlock = ModBlocks.ASPHALT_SIMPLE_YELLOW_LEFT_ARROW_BLOCK;
                        break;
                    case 18:
                        if(color == 0)
                            newBlock = ModBlocks.ASPHALT_SIMPLE_WHITE_RIGHT_ARROW_BLOCK;
                        else if(color == 1)
                            newBlock = ModBlocks.ASPHALT_SIMPLE_YELLOW_RIGHT_ARROW_BLOCK;
                        break;
                    default:
                        return ActionResultType.PASS;
                }

                if(pattern == 0 && !world.isRemote)
                {
                    world.setBlockState(pos, newBlock.getDefaultState());
                }
                else if(state.getBlock() == newBlock)
                {
                    if(newBlock instanceof BlockTwoAxis && !world.isRemote)
                    {
                        if(state.get(BlockTwoAxis.ROTATION))
                            world.setBlockState(pos, newBlock.getDefaultState().with(BlockTwoAxis.ROTATION, Boolean.valueOf(false)));
                        else
                            world.setBlockState(pos, newBlock.getDefaultState().with(BlockTwoAxis.ROTATION, Boolean.valueOf(true)));
                    }
                    else if(newBlock instanceof BlockFourAxis && !world.isRemote)
                    {
                        switch(state.get(BlockFourAxis.DIRECTION))
                        {
                            case NORTH:
                                if(player.getHeldItemMainhand() == stack)
                                    world.setBlockState(pos, newBlock.getDefaultState().with(BlockFourAxis.DIRECTION, Direction.EAST));
                                else
                                    world.setBlockState(pos, newBlock.getDefaultState().with(BlockFourAxis.DIRECTION, Direction.WEST));
                                break;
                            case EAST:
                                if(player.getHeldItemMainhand() == stack)
                                    world.setBlockState(pos, newBlock.getDefaultState().with(BlockFourAxis.DIRECTION, Direction.SOUTH));
                                else
                                    world.setBlockState(pos, newBlock.getDefaultState().with(BlockFourAxis.DIRECTION, Direction.NORTH));
                                break;
                            case SOUTH:
                                if(player.getHeldItemMainhand() == stack)
                                    world.setBlockState(pos, newBlock.getDefaultState().with(BlockFourAxis.DIRECTION, Direction.WEST));
                                else
                                    world.setBlockState(pos, newBlock.getDefaultState().with(BlockFourAxis.DIRECTION, Direction.EAST));
                                break;
                            case WEST:
                                if(player.getHeldItemMainhand() == stack)
                                    world.setBlockState(pos, newBlock.getDefaultState().with(BlockFourAxis.DIRECTION, Direction.NORTH));
                                else
                                    world.setBlockState(pos, newBlock.getDefaultState().with(BlockFourAxis.DIRECTION, Direction.SOUTH));
                                break;
                            default:
                                if(player.getHeldItemMainhand() == stack)
                                    world.setBlockState(pos, newBlock.getDefaultState().with(BlockFourAxis.DIRECTION, Direction.EAST));
                                else
                                    world.setBlockState(pos, newBlock.getDefaultState().with(BlockFourAxis.DIRECTION, Direction.WEST));
                                break;
                        }
                    }
                }
                else
                {
                    if(nbt.getInt("paint") > 0)
                    {
                        if(!world.isRemote)
                        {
                            if(newBlock instanceof BlockTwoAxis)
                            {
                                int direction = MathHelper.floor((double)(context.getPlacementYaw() * 4.0F / 360.0F) + 2.5D) & 3;
                                if(direction == 1 || direction == 3)
                                    world.setBlockState(pos, newBlock.getDefaultState().with(BlockTwoAxis.ROTATION, true));
                                else
                                    world.setBlockState(pos, newBlock.getDefaultState().with(BlockTwoAxis.ROTATION, false));
                            }
                            else if(newBlock instanceof BlockFourAxis)
                            {
                                world.setBlockState(pos, newBlock.getDefaultState().with(BlockFourAxis.DIRECTION, context.getPlacementHorizontalFacing().getOpposite()));
                            }
                            else
                                world.setBlockState(pos, newBlock.getDefaultState());
                            nbt.putInt("paint", nbt.getInt("paint") - 1);
                        }
                        if(pattern != 0)
                            playSound = true;
                    }
                }

                if(playSound)
                    world.playSound(player, pos, SoundEvents.BLOCK_SLIME_BLOCK_FALL, SoundCategory.BLOCKS, .8F, 1.0F);
            }

            stack.setTag(nbt);
            return ActionResultType.SUCCESS;
        }

        return ActionResultType.PASS;
    }

    @Override
    public void addInformation(ItemStack stack, World player, List<ITextComponent> list, ITooltipFlag flag)
    {
        super.addInformation(stack, player, list, flag);
        if(stack.hasTag())
        {
            list.add(new StringTextComponent("Pattern: " + stack.getTag().getInt("pattern") + ", paint: " + stack.getTag().getInt("paint") + ", color: " + stack.getTag().getInt("color")));
        }
    }

    public static CompoundNBT checkNBT(ItemStack stack)
    {
        CompoundNBT nbt;

        if(stack.hasTag())
        {
            nbt = stack.getTag();
        }
        else
        {
            nbt = new CompoundNBT();
            nbt.putInt("paint", 0);
            nbt.putInt("pattern", 0);
            nbt.putInt("color", EnumPaintColor.WHITE.getId());
        }
        return nbt;
    }
}
