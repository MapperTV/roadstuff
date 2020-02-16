package tv.mapper.roadstuff.item;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
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
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import tv.mapper.roadstuff.RoadStuff;
import tv.mapper.roadstuff.block.PaintableBlock;
import tv.mapper.roadstuff.block.RotatablePaintBlock;
import tv.mapper.roadstuff.block.RotatableSlopeBlock;
import tv.mapper.roadstuff.block.SlopeBlock;
import tv.mapper.roadstuff.init.ModBlocks;
import tv.mapper.roadstuff.state.properties.EnumPaintColor;
import tv.mapper.roadstuff.util.AsphaltPaintMap;
import tv.mapper.roadstuff.util.ConcretePaintMap;
import tv.mapper.roadstuff.util.ModConstants;

public class BrushItem extends Item
{
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
    public boolean canPlayerBreakBlockWhileHolding(BlockState state, World worldIn, BlockPos pos, PlayerEntity player)
    {
        if(player.isCreative() && state.getBlock() instanceof PaintableBlock)
            return false;
        return true;
    }

    public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker)
    {
        CompoundNBT nbt = checkNBT(stack);

        if(nbt.getInt("paint") > 0)
        {
            target.addPotionEffect(new EffectInstance(Effects.BLINDNESS, 50));
            nbt.putInt("paint", nbt.getInt("paint") - 1);
            stack.setTag(nbt);
        }
        return true;
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand hand)
    {
        ItemStack stack = player.getHeldItem(hand);

        CompoundNBT nbt = checkNBT(stack);
        stack.setTag(nbt);

        if(world.isRemote)
        {
            if(ModConstants.ALTERNATE_BRUSH)
            {
                if(player.isShiftKeyDown())
                    BrushItemClient.displayBrushGui(nbt.getInt("pattern"), nbt.getInt("paint"), nbt.getInt("color"), nbt.getFloat("scroll"), nbt.getIntArray("favs"));
            }
            else
            {
                if(!player.isShiftKeyDown())
                    BrushItemClient.displayBrushGui(nbt.getInt("pattern"), nbt.getInt("paint"), nbt.getInt("color"), nbt.getFloat("scroll"), nbt.getIntArray("favs"));
            }
        }

        return new ActionResult<>(ActionResultType.SUCCESS, stack);
    }

    public ActionResultType onItemUse(ItemUseContext context)
    {
        CompoundNBT nbt = checkNBT(context.getItem());
        context.getItem().setTag(nbt);

        if(ModConstants.ALTERNATE_BRUSH)
        {
            ItemStack heldItem = context.getItem();
            PlayerEntity player = context.getPlayer();

            if(player.isShiftKeyDown())
            {
                if(context.getWorld().getBlockState(context.getPos()).getBlock() instanceof PaintableBlock && (context.getWorld().getBlockState(
                    context.getPos()).getBlock() != ModBlocks.ASPHALT && context.getWorld().getBlockState(context.getPos()).getBlock() != ModBlocks.CONCRETE))
                    return copyPattern(context.getWorld().getBlockState(context.getPos()), context.getWorld(), nbt, context.getPlayer());
                else if(context.getWorld().isRemote)
                    BrushItemClient.displayBrushGui(nbt.getInt("pattern"), nbt.getInt("paint"), nbt.getInt("color"), nbt.getFloat("scroll"), nbt.getIntArray("favs"));
            }
            else
                return paintLine(context.getFace(), context.getWorld().getBlockState(context.getPos()), context.getWorld(), context.getPos(), player, heldItem);
        }
        else
        {
            if(context.getPlayer().isShiftKeyDown())
            {
                if(context.getWorld().getBlockState(context.getPos()).getBlock() instanceof PaintableBlock && (context.getWorld().getBlockState(
                    context.getPos()).getBlock() != ModBlocks.ASPHALT && context.getWorld().getBlockState(context.getPos()).getBlock() != ModBlocks.CONCRETE))
                {
                    return copyPattern(context.getWorld().getBlockState(context.getPos()), context.getWorld(), nbt, context.getPlayer());
                }
            }
        }
        return ActionResultType.PASS;

    }

    @Override
    public void addInformation(ItemStack stack, World player, List<ITextComponent> list, ITooltipFlag flag)
    {
        super.addInformation(stack, player, list, flag);
        if(stack.hasTag())
        {
            String color = EnumPaintColor.getColorByID(stack.getTag().getInt("color")).getNameTranslated();

            if(stack.getTag().getInt("paint") == 0)
                color = "X";
            list.add(new StringTextComponent(new TranslationTextComponent("roadstuff.message.brush.gui.pattern").getString() + stack.getTag().getInt(
                "pattern") + "; " + new TranslationTextComponent("roadstuff.message.brush.gui.color").getString() + color));
            list.add(new StringTextComponent(new TranslationTextComponent("roadstuff.message.brush.gui.paint").getString() + stack.getTag().getInt("paint")));
        }
    }

    @Override
    public boolean showDurabilityBar(ItemStack stack)
    {
        if(checkNBT(stack).getInt("paint") > 0)
            return true;
        else
            return false;
    }

    @Override
    public double getDurabilityForDisplay(ItemStack stack)
    {
        return 1 - ((double)checkNBT(stack).getInt("paint") / (double)ModConstants.BRUSH_MAX_PAINT);
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
            int favorites[] = {0, 0, 0, 0, 0, 0, 0, 0};

            nbt = new CompoundNBT();
            nbt.putInt("paint", 0);
            nbt.putInt("pattern", 0);
            nbt.putInt("color", EnumPaintColor.WHITE.getId());
            nbt.putFloat("scroll", 0.0f);
            nbt.putIntArray("favs", favorites);
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

        if(!world.isRemote && face == Direction.UP)
        {
            if(pattern == 0)
            {
                return removeLine(world, pos, player);
            }

            if(state.getBlock() instanceof SlopeBlock)
            {
                switch(((SlopeBlock)state.getBlock()).getMaterialType())
                {
                    case 0:
                        newBlock = RoadStuff.asphaltSlopeMap.getBlockFor(color, pattern);
                        break;
                    case 1:
                        newBlock = RoadStuff.concreteSlopeMap.getBlockFor(color, pattern);
                        break;
                    default:
                        return ActionResultType.PASS;
                }

                if(state.getBlock() == newBlock)
                {
                    if(newBlock instanceof RotatableSlopeBlock && !world.isRemote)
                    {
                        switch(state.get(RotatableSlopeBlock.DIRECTION))
                        {
                            case NORTH:
                                if(player.getHeldItemMainhand() == stack)
                                    world.setBlockState(pos, newBlock.getDefaultState().with(RotatableSlopeBlock.DIRECTION, Direction.EAST).with(SlopeBlock.LAYERS, state.get(SlopeBlock.LAYERS)).with(
                                        SlopeBlock.WATERLOGGED, state.get(SlopeBlock.WATERLOGGED)));
                                else
                                    world.setBlockState(pos, newBlock.getDefaultState().with(RotatableSlopeBlock.DIRECTION, Direction.WEST).with(SlopeBlock.LAYERS, state.get(SlopeBlock.LAYERS)).with(
                                        SlopeBlock.WATERLOGGED, state.get(SlopeBlock.WATERLOGGED)));
                                break;
                            case EAST:
                                if(player.getHeldItemMainhand() == stack)
                                    world.setBlockState(pos, newBlock.getDefaultState().with(RotatableSlopeBlock.DIRECTION, Direction.SOUTH).with(SlopeBlock.LAYERS, state.get(SlopeBlock.LAYERS)).with(
                                        SlopeBlock.WATERLOGGED, state.get(SlopeBlock.WATERLOGGED)));
                                else
                                    world.setBlockState(pos, newBlock.getDefaultState().with(RotatableSlopeBlock.DIRECTION, Direction.NORTH).with(SlopeBlock.LAYERS, state.get(SlopeBlock.LAYERS)).with(
                                        SlopeBlock.WATERLOGGED, state.get(SlopeBlock.WATERLOGGED)));
                                break;
                            case SOUTH:
                                if(player.getHeldItemMainhand() == stack)
                                    world.setBlockState(pos, newBlock.getDefaultState().with(RotatableSlopeBlock.DIRECTION, Direction.WEST).with(SlopeBlock.LAYERS, state.get(SlopeBlock.LAYERS)).with(
                                        SlopeBlock.WATERLOGGED, state.get(SlopeBlock.WATERLOGGED)));
                                else
                                    world.setBlockState(pos, newBlock.getDefaultState().with(RotatableSlopeBlock.DIRECTION, Direction.EAST).with(SlopeBlock.LAYERS, state.get(SlopeBlock.LAYERS)).with(
                                        SlopeBlock.WATERLOGGED, state.get(SlopeBlock.WATERLOGGED)));
                                break;
                            case WEST:
                                if(player.getHeldItemMainhand() == stack)
                                    world.setBlockState(pos, newBlock.getDefaultState().with(RotatableSlopeBlock.DIRECTION, Direction.NORTH).with(SlopeBlock.LAYERS, state.get(SlopeBlock.LAYERS)).with(
                                        SlopeBlock.WATERLOGGED, state.get(SlopeBlock.WATERLOGGED)));
                                else
                                    world.setBlockState(pos, newBlock.getDefaultState().with(RotatableSlopeBlock.DIRECTION, Direction.SOUTH).with(SlopeBlock.LAYERS, state.get(SlopeBlock.LAYERS)).with(
                                        SlopeBlock.WATERLOGGED, state.get(SlopeBlock.WATERLOGGED)));
                                break;
                            default:
                                if(player.getHeldItemMainhand() == stack)
                                    world.setBlockState(pos, newBlock.getDefaultState().with(RotatableSlopeBlock.DIRECTION, Direction.EAST).with(SlopeBlock.LAYERS, state.get(SlopeBlock.LAYERS)).with(
                                        SlopeBlock.WATERLOGGED, state.get(SlopeBlock.WATERLOGGED)));
                                else
                                    world.setBlockState(pos, newBlock.getDefaultState().with(RotatableSlopeBlock.DIRECTION, Direction.WEST).with(SlopeBlock.LAYERS, state.get(SlopeBlock.LAYERS)).with(
                                        SlopeBlock.WATERLOGGED, state.get(SlopeBlock.WATERLOGGED)));
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
                            if(newBlock instanceof RotatableSlopeBlock)
                            {
                                if(player.getHeldItemMainhand() == stack)
                                    world.setBlockState(pos,
                                        newBlock.getDefaultState().with(RotatableSlopeBlock.DIRECTION, player.getHorizontalFacing()).with(SlopeBlock.LAYERS, state.get(SlopeBlock.LAYERS)).with(
                                            SlopeBlock.WATERLOGGED, state.get(SlopeBlock.WATERLOGGED)));
                                else
                                    world.setBlockState(pos, newBlock.getDefaultState().with(RotatableSlopeBlock.DIRECTION, player.getHorizontalFacing().getOpposite()).with(SlopeBlock.LAYERS,
                                        state.get(SlopeBlock.LAYERS)).with(SlopeBlock.WATERLOGGED, state.get(SlopeBlock.WATERLOGGED)));
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
            else if(state.getBlock() instanceof PaintableBlock)
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
        }

        stack.setTag(nbt);
        return ActionResultType.SUCCESS;
    }

    public static ActionResultType removeLine(World world, BlockPos pos, PlayerEntity player)
    {
        BlockState state = world.getBlockState(pos);

        if(state.getBlock() instanceof SlopeBlock && state.getBlock() != ModBlocks.ASPHALT_SLOPE && state.getBlock() != ModBlocks.CONCRETE_SLOPE)
        {
            BlockState newBlock = getPaintableBlockFromMaterial(state);

            if(newBlock == null)
            {
                return ActionResultType.PASS;
            }
            else
            {
                if(!world.isRemote)
                {
                    world.setBlockState(pos, newBlock.with(SlopeBlock.WATERLOGGED, state.get(SlopeBlock.WATERLOGGED)));
                    world.playSound(null, pos, SoundEvents.BLOCK_COMPOSTER_FILL, SoundCategory.BLOCKS, 1.0F, 1.5F);
                }
            }
        }
        else if(state.getBlock() instanceof PaintableBlock && !(state.getBlock() instanceof SlopeBlock) && state.getBlock() != ModBlocks.ASPHALT && state.getBlock() != ModBlocks.CONCRETE)
        {
            BlockState newBlock = getPaintableBlockFromMaterial(state);

            if(newBlock == null)
            {
                return ActionResultType.PASS;
            }
            else
            {
                if(!world.isRemote)
                {
                    world.setBlockState(pos, newBlock);
                    world.playSound(null, pos, SoundEvents.BLOCK_COMPOSTER_FILL, SoundCategory.BLOCKS, 1.0F, 1.5F);
                }
            }
        }
        return ActionResultType.SUCCESS;
    }

    private ActionResultType copyPattern(BlockState state, World world, CompoundNBT nbt, PlayerEntity player)
    {
        PaintableBlock block = (PaintableBlock)state.getBlock();
        int materialType = block.getMaterialType();

        AsphaltPaintMap asphaltMap = null;
        ConcretePaintMap concreteMap = null;

        if(materialType == 0)
        {
            if(state.getBlock() instanceof SlopeBlock)
                asphaltMap = RoadStuff.asphaltSlopeMap;
            else
                asphaltMap = RoadStuff.asphaltMap;
        }
        else if(materialType == 1)
        {
            if(state.getBlock() instanceof SlopeBlock)
                concreteMap = RoadStuff.concreteSlopeMap;
            else
                concreteMap = RoadStuff.concreteMap;
        }

        if(asphaltMap != null || concreteMap != null)
        {
            if(!world.isRemote)
            {
                int[] params = {0, 0};
                if(((PaintableBlock)state.getBlock()).getMaterialType() == 0)
                    params = asphaltMap.getParamsFor(block);
                else if(((PaintableBlock)state.getBlock()).getMaterialType() == 1)
                    params = concreteMap.getParamsFor(block);
                nbt.putInt("pattern", params[1]);
                player.sendStatusMessage(new StringTextComponent(TextFormatting.WHITE + "Copied pattern " + params[1] + " into brush"), true);
            }
            return ActionResultType.SUCCESS;
        }
        return ActionResultType.PASS;
    }

    private static BlockState getPaintableBlockFromMaterial(BlockState state)
    {
        if(state.getBlock() instanceof SlopeBlock)
        {
            switch(((SlopeBlock)state.getBlock()).getMaterialType())
            {
                case 0:
                    return ModBlocks.ASPHALT_SLOPE.getDefaultState().with(SlopeBlock.LAYERS, state.get(SlopeBlock.LAYERS));
                case 1:
                    return ModBlocks.CONCRETE_SLOPE.getDefaultState().with(SlopeBlock.LAYERS, state.get(SlopeBlock.LAYERS));
                default:
                    return null;
            }
        }
        else
        {
            switch(((PaintableBlock)state.getBlock()).getMaterialType())
            {
                case 0:
                    return ModBlocks.ASPHALT.getDefaultState();
                case 1:
                    return ModBlocks.CONCRETE.getDefaultState();
                default:
                    return null;
            }
        }
    }
}