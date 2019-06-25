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
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import tv.mapper.roadstuff.RoadStuff;
import tv.mapper.roadstuff.block.RotatablePaintBlock;
import tv.mapper.roadstuff.block.PaintableBlock;
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
            if(!world.isRemote && state.getBlock() instanceof PaintableBlock)
            {
                player.sendStatusMessage(new StringTextComponent(TextFormatting.WHITE + "Clicked on paintable block!"), true);
            }
            else if(world.isRemote)
                ItemBrushClient.displayBrushGui(stack.getTag().getInt("pattern"), stack.getTag().getInt("paint"), stack.getTag().getInt("color"));
            return ActionResultType.SUCCESS;
        }

        if(state != null && nbt.contains("paint"))
        {
            if(context.getFace() == Direction.UP && state.getBlock() instanceof PaintableBlock)
            {
                switch(((PaintableBlock)state.getBlock()).getMaterialType())
                {
                    case 0:
                        newBlock = RoadStuff.asphaltMap.getBlockFor(color, pattern);
                        break;
                    case 1:
                        newBlock = RoadStuff.concreteMap.getBlockFor(color, pattern);
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
                    if(newBlock instanceof RotatablePaintBlock && !world.isRemote)
                    {
                        switch(state.get(RotatablePaintBlock.DIRECTION))
                        {
                            case NORTH:
                                if(player.getHeldItemMainhand() == stack)
                                    world.setBlockState(pos, newBlock.getDefaultState().with(RotatablePaintBlock.DIRECTION, Direction.EAST));
                                else
                                    world.setBlockState(pos, newBlock.getDefaultState().with(RotatablePaintBlock.DIRECTION, Direction.WEST));
                                break;
                            case EAST:
                                if(player.getHeldItemMainhand() == stack)
                                    world.setBlockState(pos, newBlock.getDefaultState().with(RotatablePaintBlock.DIRECTION, Direction.SOUTH));
                                else
                                    world.setBlockState(pos, newBlock.getDefaultState().with(RotatablePaintBlock.DIRECTION, Direction.NORTH));
                                break;
                            case SOUTH:
                                if(player.getHeldItemMainhand() == stack)
                                    world.setBlockState(pos, newBlock.getDefaultState().with(RotatablePaintBlock.DIRECTION, Direction.WEST));
                                else
                                    world.setBlockState(pos, newBlock.getDefaultState().with(RotatablePaintBlock.DIRECTION, Direction.EAST));
                                break;
                            case WEST:
                                if(player.getHeldItemMainhand() == stack)
                                    world.setBlockState(pos, newBlock.getDefaultState().with(RotatablePaintBlock.DIRECTION, Direction.NORTH));
                                else
                                    world.setBlockState(pos, newBlock.getDefaultState().with(RotatablePaintBlock.DIRECTION, Direction.SOUTH));
                                break;
                            default:
                                if(player.getHeldItemMainhand() == stack)
                                    world.setBlockState(pos, newBlock.getDefaultState().with(RotatablePaintBlock.DIRECTION, Direction.EAST));
                                else
                                    world.setBlockState(pos, newBlock.getDefaultState().with(RotatablePaintBlock.DIRECTION, Direction.WEST));
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
                            if(newBlock instanceof RotatablePaintBlock)
                            {
                                world.setBlockState(pos, newBlock.getDefaultState().with(RotatablePaintBlock.DIRECTION, context.getPlacementHorizontalFacing().getOpposite()));
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
