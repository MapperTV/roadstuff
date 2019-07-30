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
import tv.mapper.roadstuff.block.PaintableBlock;
import tv.mapper.roadstuff.block.RotatablePaintBlock;
import tv.mapper.roadstuff.init.ModBlocks;
import tv.mapper.roadstuff.state.properties.EnumPaintColor;

public class BrushItem extends Item
{
    public static final int MAX_PAINT = 128;

    public BrushItem(Properties properties)
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

        // ToDo: remove sneak condition when events will be back
        if(world.isRemote && player.isSneaking())
        {
            BrushItemClient.displayBrushGui(stack.getTag().getInt("pattern"), stack.getTag().getInt("paint"), stack.getTag().getInt("color"), stack.getTag().getFloat("scroll"));
        }

        return new ActionResult<>(ActionResultType.SUCCESS, stack);
    }

    public ActionResultType onItemUse(ItemUseContext context)
    {
        CompoundNBT nbt = checkNBT(context.getItem());
        context.getItem().setTag(nbt);

        // Temp fix for lack of events

        ItemStack heldItem = context.getItem();
        PlayerEntity player = context.getPlayer();

        if(player.isSneaking())
        {
            if(context.getWorld().getBlockState(context.getPos()).getBlock() instanceof PaintableBlock && (context.getWorld().getBlockState(context.getPos()).getBlock() != ModBlocks.ASPHALT && context.getWorld().getBlockState(context.getPos()).getBlock() != ModBlocks.CONCRETE))
                return copyPattern(context.getWorld().getBlockState(context.getPos()), context.getWorld(), nbt, context.getPlayer());
            else if(context.getWorld().isRemote)
                BrushItemClient.displayBrushGui(heldItem.getTag().getInt("pattern"), heldItem.getTag().getInt("paint"), heldItem.getTag().getInt("color"), heldItem.getTag().getFloat("scroll"));
        }
        else
            return paintLine(context.getFace(), context.getWorld().getBlockState(context.getPos()), context.getWorld(), context.getPos(), player, heldItem);

        // ***

        /*
         * if(context.getPlayer().isSneaking())
         * {
         * if(context.getWorld().getBlockState(context.getPos()).getBlock() instanceof PaintableBlock && (context.getWorld().getBlockState(context.getPos()).getBlock() != ModBlocks.ASPHALT &&
         * context.getWorld().getBlockState(context.getPos()).getBlock() != ModBlocks.CONCRETE))
         * {
         * return copyPattern(context.getWorld().getBlockState(context.getPos()), context.getWorld(), nbt, context.getPlayer());
         * }
         * }
         */
        return ActionResultType.PASS;

    }

    @Override
    public void addInformation(ItemStack stack, World player, List<ITextComponent> list, ITooltipFlag flag)
    {
        super.addInformation(stack, player, list, flag);
        if(stack.hasTag())
        {
            String color = EnumPaintColor.getColorByID(stack.getTag().getInt("color")).getName();
            list.add(new StringTextComponent("Pattern: " + stack.getTag().getInt("pattern") + "; Paint: " + stack.getTag().getInt("paint") + "; Color: " + color));
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
            nbt.putFloat("scroll", 0.0f);
        }
        return nbt;
    }

    public static ActionResultType paintLine(Direction face, BlockState state, World world, BlockPos pos, PlayerEntity player, ItemStack stack)
    {
        Block newBlock;

        CompoundNBT nbt = checkNBT(stack);
        stack.setTag(nbt);

        int pattern = nbt.getInt("pattern");
        int color = nbt.getInt("color");

        if(face == Direction.UP && state.getBlock() instanceof PaintableBlock)
        {
            if(pattern == 0)
            {
                return removeLine(world, pos, player);
            }

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

            if(state.getBlock() == newBlock)
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
                            if(player.getHeldItemMainhand() == stack)
                                world.setBlockState(pos, newBlock.getDefaultState().with(RotatablePaintBlock.DIRECTION, player.getHorizontalFacing()));
                            else
                                world.setBlockState(pos, newBlock.getDefaultState().with(RotatablePaintBlock.DIRECTION, player.getHorizontalFacing().getOpposite()));
                        }
                        else
                            world.setBlockState(pos, newBlock.getDefaultState());
                        if(!player.isCreative())
                            nbt.putInt("paint", nbt.getInt("paint") - 1);
                        world.playSound(null, pos, SoundEvents.BLOCK_SLIME_BLOCK_PLACE, SoundCategory.BLOCKS, .8F, 2.0F);
                    }
                }
            }
        }

        stack.setTag(nbt);
        return ActionResultType.SUCCESS;
    }

    public static ActionResultType removeLine(World world, BlockPos pos, PlayerEntity player)
    {
        BlockState state = world.getBlockState(pos);

        if(state.getBlock() instanceof PaintableBlock && state.getBlock() != ModBlocks.ASPHALT && state.getBlock() != ModBlocks.CONCRETE)
        {
            Block newBlock = getPaintableBlockFromMaterial(state);

            if(newBlock == null)
            {
                return ActionResultType.PASS;
            }
            else
            {
                if(!world.isRemote)
                {
                    world.setBlockState(pos, newBlock.getDefaultState());
                    world.playSound(null, pos, SoundEvents.BLOCK_COMPOSTER_FILL, SoundCategory.BLOCKS, 1.0F, 1.5F);
                }
            }
        }
        return ActionResultType.SUCCESS;
    }

    private ActionResultType copyPattern(BlockState state, World world, CompoundNBT nbt, PlayerEntity player)
    {
        PaintableBlock block = (PaintableBlock)state.getBlock();

        if(!world.isRemote)
        {
            int[] params = {0, 0};
            if(((PaintableBlock)state.getBlock()).getMaterialType() == 0)
                params = RoadStuff.asphaltMap.getParamsFor(block);
            else if(((PaintableBlock)state.getBlock()).getMaterialType() == 1)
                params = RoadStuff.concreteMap.getParamsFor(block);
            nbt.putInt("pattern", params[1]);
            player.sendStatusMessage(new StringTextComponent(TextFormatting.WHITE + "Copied pattern " + params[1] + " into brush"), true);
        }
        return ActionResultType.SUCCESS;
    }

    private static PaintableBlock getPaintableBlockFromMaterial(BlockState state)
    {
        switch(((PaintableBlock)state.getBlock()).getMaterialType())
        {
            case 0:
                return ModBlocks.ASPHALT;
            case 1:
                return ModBlocks.CONCRETE;
            default:
                return null;
        }
    }
}