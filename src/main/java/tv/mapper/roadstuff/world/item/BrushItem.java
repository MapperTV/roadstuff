package tv.mapper.roadstuff.world.item;

import java.util.List;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import tv.mapper.mapperbase.world.level.block.SlopeBlock;
import tv.mapper.roadstuff.RoadStuff;
import tv.mapper.roadstuff.util.AsphaltPaintMap;
import tv.mapper.roadstuff.util.ConcretePaintMap;
import tv.mapper.roadstuff.util.ModConstants;
import tv.mapper.roadstuff.world.level.block.PaintSystem;
import tv.mapper.roadstuff.world.level.block.PaintableRoadBlock;
import tv.mapper.roadstuff.world.level.block.PaintableSlopeBlock;
import tv.mapper.roadstuff.world.level.block.RSBlockRegistry;
import tv.mapper.roadstuff.world.level.block.RotatablePaintBlock;
import tv.mapper.roadstuff.world.level.block.RotatableSlopeBlock;
import tv.mapper.roadstuff.world.level.block.state.properties.EnumPaintColor;

public class BrushItem extends Item
{
    private int paintQuantity;

    public BrushItem(Properties properties, int paintQuantity)
    {
        super(properties);
        this.paintQuantity = paintQuantity;
    }

    @Override
    public boolean canAttackBlock(BlockState state, Level worldIn, BlockPos pos, Player player)
    {
        if(player.isCreative() && state.getBlock() instanceof PaintableRoadBlock)
            return false;
        return true;
    }

    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker)
    {
        CompoundTag nbt = checkNBT(stack);

        if(nbt.getInt("paint") > 0)
        {
            target.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 50));
            nbt.putInt("paint", nbt.getInt("paint") - 1);
            stack.setTag(nbt);
        }
        return true;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand)
    {
        ItemStack stack = player.getItemInHand(hand);

        CompoundTag nbt = checkNBT(stack);
        stack.setTag(nbt);

        if(world.isClientSide)
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

        return new InteractionResultHolder<>(InteractionResult.SUCCESS, stack);
    }

    public InteractionResult useOn(UseOnContext context)
    {
        CompoundTag nbt = checkNBT(context.getItemInHand());
        context.getItemInHand().setTag(nbt);

        if(ModConstants.ALTERNATE_BRUSH)
        {
            ItemStack heldItem = context.getItemInHand();
            Player player = context.getPlayer();

            if(player.isShiftKeyDown())
            {
                if(context.getLevel().getBlockState(context.getClickedPos()).getBlock() instanceof PaintSystem)
                    return copyPattern(context.getLevel().getBlockState(context.getClickedPos()), context.getLevel(), nbt, context.getPlayer());
                else if(context.getLevel().isClientSide)
                    BrushItemClient.displayBrushGui(nbt.getInt("pattern"), nbt.getInt("paint"), nbt.getInt("color"), nbt.getFloat("scroll"), nbt.getIntArray("favs"));
            }
            else
                return paintLine(context.getClickedFace(), context.getLevel().getBlockState(context.getClickedPos()), context.getLevel(), context.getClickedPos(), player, heldItem);
        }
        else
        {
            if(context.getPlayer().isShiftKeyDown())
            {
                if(context.getLevel().getBlockState(context.getClickedPos()).getBlock() instanceof PaintSystem)
                {
                    return copyPattern(context.getLevel().getBlockState(context.getClickedPos()), context.getLevel(), nbt, context.getPlayer());
                }
            }
        }
        return InteractionResult.PASS;

    }

    @Override
    public void appendHoverText(ItemStack stack, Level player, List<Component> list, TooltipFlag flag)
    {
        super.appendHoverText(stack, player, list, flag);
        if(stack.hasTag())
        {
            String color = EnumPaintColor.getColorByID(stack.getTag().getInt("color")).getNameTranslated();

            if(stack.getTag().getInt("paint") == 0)
                color = "X";
            list.add(new TextComponent(new TranslatableComponent("roadstuff.message.brush.gui.pattern").getString() + stack.getTag().getInt("pattern") + "; " + new TranslatableComponent("roadstuff.message.brush.gui.color").getString() + color));
            list.add(new TextComponent(new TranslatableComponent("roadstuff.message.brush.gui.paint").getString() + stack.getTag().getInt("paint")));
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
        return 1 - ((double)checkNBT(stack).getInt("paint") / paintQuantity);
    }

    public static CompoundTag checkNBT(ItemStack stack)
    {
        CompoundTag nbt;

        if(stack.hasTag())
        {
            nbt = stack.getTag();
        }
        else
        {
            int favorites[] = {0, 0, 0, 0, 0, 0, 0, 0};

            nbt = new CompoundTag();
            nbt.putInt("paint", 0);
            nbt.putInt("pattern", 0);
            nbt.putInt("color", EnumPaintColor.WHITE.getId());
            nbt.putFloat("scroll", 0.0f);
            nbt.putIntArray("favs", favorites);
        }
        return nbt;
    }

    public static InteractionResult paintLine(Direction face, BlockState state, Level world, BlockPos pos, Player player, ItemStack stack)
    {
        Block newBlock;

        CompoundTag nbt = checkNBT(stack);
        stack.setTag(nbt);

        int pattern = nbt.getInt("pattern");
        int color = nbt.getInt("color");

        if(!world.isClientSide && face == Direction.UP)
        {
            if(pattern == 0)
            {
                return removeLine(world, pos, player);
            }

            if(state.getBlock() instanceof PaintableSlopeBlock)
            {
                switch(((PaintSystem)state.getBlock()).getMaterialType())
                {
                    case 0:
                        newBlock = RoadStuff.asphaltSlopeMap.getBlockFor(color, pattern);
                        break;
                    case 1:
                        newBlock = RoadStuff.concreteSlopeMap.getBlockFor(color, pattern);
                        break;
                    default:
                        return InteractionResult.PASS;
                }

                if(state.getBlock() == newBlock)
                {
                    if(newBlock instanceof RotatableSlopeBlock && !world.isClientSide)
                    {
                        switch(state.getValue(RotatableSlopeBlock.DIRECTION))
                        {
                            case NORTH:
                                if(player.getMainHandItem() == stack)
                                    world.setBlockAndUpdate(pos, newBlock.defaultBlockState().setValue(RotatableSlopeBlock.DIRECTION, Direction.EAST).setValue(SlopeBlock.LAYERS, state.getValue(SlopeBlock.LAYERS)).setValue(SlopeBlock.WATERLOGGED, state.getValue(SlopeBlock.WATERLOGGED)));
                                else
                                    world.setBlockAndUpdate(pos, newBlock.defaultBlockState().setValue(RotatableSlopeBlock.DIRECTION, Direction.WEST).setValue(SlopeBlock.LAYERS, state.getValue(SlopeBlock.LAYERS)).setValue(SlopeBlock.WATERLOGGED, state.getValue(SlopeBlock.WATERLOGGED)));
                                break;
                            case EAST:
                                if(player.getMainHandItem() == stack)
                                    world.setBlockAndUpdate(pos, newBlock.defaultBlockState().setValue(RotatableSlopeBlock.DIRECTION, Direction.SOUTH).setValue(SlopeBlock.LAYERS, state.getValue(SlopeBlock.LAYERS)).setValue(SlopeBlock.WATERLOGGED, state.getValue(SlopeBlock.WATERLOGGED)));
                                else
                                    world.setBlockAndUpdate(pos, newBlock.defaultBlockState().setValue(RotatableSlopeBlock.DIRECTION, Direction.NORTH).setValue(SlopeBlock.LAYERS, state.getValue(SlopeBlock.LAYERS)).setValue(SlopeBlock.WATERLOGGED, state.getValue(SlopeBlock.WATERLOGGED)));
                                break;
                            case SOUTH:
                                if(player.getMainHandItem() == stack)
                                    world.setBlockAndUpdate(pos, newBlock.defaultBlockState().setValue(RotatableSlopeBlock.DIRECTION, Direction.WEST).setValue(SlopeBlock.LAYERS, state.getValue(SlopeBlock.LAYERS)).setValue(SlopeBlock.WATERLOGGED, state.getValue(SlopeBlock.WATERLOGGED)));
                                else
                                    world.setBlockAndUpdate(pos, newBlock.defaultBlockState().setValue(RotatableSlopeBlock.DIRECTION, Direction.EAST).setValue(SlopeBlock.LAYERS, state.getValue(SlopeBlock.LAYERS)).setValue(SlopeBlock.WATERLOGGED, state.getValue(SlopeBlock.WATERLOGGED)));
                                break;
                            case WEST:
                                if(player.getMainHandItem() == stack)
                                    world.setBlockAndUpdate(pos, newBlock.defaultBlockState().setValue(RotatableSlopeBlock.DIRECTION, Direction.NORTH).setValue(SlopeBlock.LAYERS, state.getValue(SlopeBlock.LAYERS)).setValue(SlopeBlock.WATERLOGGED, state.getValue(SlopeBlock.WATERLOGGED)));
                                else
                                    world.setBlockAndUpdate(pos, newBlock.defaultBlockState().setValue(RotatableSlopeBlock.DIRECTION, Direction.SOUTH).setValue(SlopeBlock.LAYERS, state.getValue(SlopeBlock.LAYERS)).setValue(SlopeBlock.WATERLOGGED, state.getValue(SlopeBlock.WATERLOGGED)));
                                break;
                            default:
                                if(player.getMainHandItem() == stack)
                                    world.setBlockAndUpdate(pos, newBlock.defaultBlockState().setValue(RotatableSlopeBlock.DIRECTION, Direction.EAST).setValue(SlopeBlock.LAYERS, state.getValue(SlopeBlock.LAYERS)).setValue(SlopeBlock.WATERLOGGED, state.getValue(SlopeBlock.WATERLOGGED)));
                                else
                                    world.setBlockAndUpdate(pos, newBlock.defaultBlockState().setValue(RotatableSlopeBlock.DIRECTION, Direction.WEST).setValue(SlopeBlock.LAYERS, state.getValue(SlopeBlock.LAYERS)).setValue(SlopeBlock.WATERLOGGED, state.getValue(SlopeBlock.WATERLOGGED)));
                                break;
                        }
                    }
                }
                else
                {
                    if(nbt.getInt("paint") > 0)
                    {
                        if(!world.isClientSide)
                        {
                            if(newBlock instanceof RotatableSlopeBlock)
                            {
                                if(player.getMainHandItem() == stack)
                                    world.setBlockAndUpdate(pos, newBlock.defaultBlockState().setValue(RotatableSlopeBlock.DIRECTION, player.getDirection()).setValue(SlopeBlock.LAYERS, state.getValue(SlopeBlock.LAYERS)).setValue(SlopeBlock.WATERLOGGED, state.getValue(SlopeBlock.WATERLOGGED)));
                                else
                                    world.setBlockAndUpdate(pos, newBlock.defaultBlockState().setValue(RotatableSlopeBlock.DIRECTION, player.getDirection().getOpposite()).setValue(SlopeBlock.LAYERS, state.getValue(SlopeBlock.LAYERS)).setValue(SlopeBlock.WATERLOGGED, state.getValue(SlopeBlock.WATERLOGGED)));
                            }
                            else
                                world.setBlockAndUpdate(pos, newBlock.defaultBlockState());
                            if(!player.isCreative())
                                nbt.putInt("paint", nbt.getInt("paint") - 1);
                            world.playSound(null, pos, SoundEvents.SLIME_BLOCK_PLACE, SoundSource.BLOCKS, .8F, 2.0F);
                        }
                    }
                }
            }
            else if(state.getBlock() instanceof PaintSystem)
            {
                switch(((PaintSystem)state.getBlock()).getMaterialType())
                {
                    case 0:
                        newBlock = RoadStuff.asphaltMap.getBlockFor(color, pattern);
                        break;
                    case 1:
                        newBlock = RoadStuff.concreteMap.getBlockFor(color, pattern);
                        break;
                    default:
                        return InteractionResult.PASS;
                }

                if(state.getBlock() == newBlock)
                {
                    if(newBlock instanceof RotatablePaintBlock && !world.isClientSide)
                    {
                        switch(state.getValue(RotatablePaintBlock.DIRECTION))
                        {
                            case NORTH:
                                if(player.getMainHandItem() == stack)
                                    world.setBlockAndUpdate(pos, newBlock.defaultBlockState().setValue(RotatablePaintBlock.DIRECTION, Direction.EAST));
                                else
                                    world.setBlockAndUpdate(pos, newBlock.defaultBlockState().setValue(RotatablePaintBlock.DIRECTION, Direction.WEST));
                                break;
                            case EAST:
                                if(player.getMainHandItem() == stack)
                                    world.setBlockAndUpdate(pos, newBlock.defaultBlockState().setValue(RotatablePaintBlock.DIRECTION, Direction.SOUTH));
                                else
                                    world.setBlockAndUpdate(pos, newBlock.defaultBlockState().setValue(RotatablePaintBlock.DIRECTION, Direction.NORTH));
                                break;
                            case SOUTH:
                                if(player.getMainHandItem() == stack)
                                    world.setBlockAndUpdate(pos, newBlock.defaultBlockState().setValue(RotatablePaintBlock.DIRECTION, Direction.WEST));
                                else
                                    world.setBlockAndUpdate(pos, newBlock.defaultBlockState().setValue(RotatablePaintBlock.DIRECTION, Direction.EAST));
                                break;
                            case WEST:
                                if(player.getMainHandItem() == stack)
                                    world.setBlockAndUpdate(pos, newBlock.defaultBlockState().setValue(RotatablePaintBlock.DIRECTION, Direction.NORTH));
                                else
                                    world.setBlockAndUpdate(pos, newBlock.defaultBlockState().setValue(RotatablePaintBlock.DIRECTION, Direction.SOUTH));
                                break;
                            default:
                                if(player.getMainHandItem() == stack)
                                    world.setBlockAndUpdate(pos, newBlock.defaultBlockState().setValue(RotatablePaintBlock.DIRECTION, Direction.EAST));
                                else
                                    world.setBlockAndUpdate(pos, newBlock.defaultBlockState().setValue(RotatablePaintBlock.DIRECTION, Direction.WEST));
                                break;
                        }
                    }
                }
                else
                {
                    if(nbt.getInt("paint") > 0)
                    {
                        if(!world.isClientSide)
                        {
                            if(newBlock instanceof RotatablePaintBlock)
                            {
                                if(player.getMainHandItem() == stack)
                                    world.setBlockAndUpdate(pos, newBlock.defaultBlockState().setValue(RotatablePaintBlock.DIRECTION, player.getDirection()));
                                else
                                    world.setBlockAndUpdate(pos, newBlock.defaultBlockState().setValue(RotatablePaintBlock.DIRECTION, player.getDirection().getOpposite()));
                            }
                            else
                                world.setBlockAndUpdate(pos, newBlock.defaultBlockState());
                            if(!player.isCreative())
                                nbt.putInt("paint", nbt.getInt("paint") - 1);
                            world.playSound(null, pos, SoundEvents.SLIME_BLOCK_PLACE, SoundSource.BLOCKS, .8F, 2.0F);
                        }
                    }
                }
            }
        }

        stack.setTag(nbt);
        return InteractionResult.SUCCESS;
    }

    public static InteractionResult removeLine(Level world, BlockPos pos, Player player)
    {
        BlockState state = world.getBlockState(pos);

        if(state.getBlock() instanceof SlopeBlock && state.getBlock() != RSBlockRegistry.ASPHALT_SLOPE.get() && state.getBlock() != RSBlockRegistry.CONCRETE_SLOPE.get())
        {
            BlockState newBlock = getPaintableBlockFromMaterial(state);

            if(newBlock == null)
            {
                return InteractionResult.PASS;
            }
            else
            {
                if(!world.isClientSide)
                {
                    world.setBlockAndUpdate(pos, newBlock.setValue(SlopeBlock.WATERLOGGED, state.getValue(SlopeBlock.WATERLOGGED)));
                    world.playSound(null, pos, SoundEvents.COMPOSTER_FILL, SoundSource.BLOCKS, 1.0F, 1.5F);
                }
            }
        }
        else if(state.getBlock() instanceof PaintSystem && !(state.getBlock() instanceof SlopeBlock) && state.getBlock() != RSBlockRegistry.ASPHALT.get() && state.getBlock() != RSBlockRegistry.CONCRETE.get())
        {
            BlockState newBlock = getPaintableBlockFromMaterial(state);

            if(newBlock == null)
            {
                return InteractionResult.PASS;
            }
            else
            {
                if(!world.isClientSide)
                {
                    world.setBlockAndUpdate(pos, newBlock);
                    world.playSound(null, pos, SoundEvents.COMPOSTER_FILL, SoundSource.BLOCKS, 1.0F, 1.5F);
                }
            }
        }
        return InteractionResult.SUCCESS;
    }

    private InteractionResult copyPattern(BlockState state, Level world, CompoundTag nbt, Player player)
    {
        Block block = state.getBlock();
        int materialType = ((PaintSystem)block).getMaterialType();

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
            if(!world.isClientSide)
            {
                int[] params = {0, 0};
                if(((PaintSystem)state.getBlock()).getMaterialType() == 0)
                    params = asphaltMap.getParamsFor(block);
                else if(((PaintSystem)state.getBlock()).getMaterialType() == 1)
                    params = concreteMap.getParamsFor(block);
                nbt.putInt("pattern", params[1]);
                player.displayClientMessage(new TextComponent(ChatFormatting.WHITE + "Copied pattern " + params[1] + " into brush"), true);
            }
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.PASS;
    }

    private static BlockState getPaintableBlockFromMaterial(BlockState state)
    {
        if(state.getBlock() instanceof PaintableSlopeBlock)
        {
            switch(((PaintSystem)state.getBlock()).getMaterialType())
            {
                case 0:
                    return RSBlockRegistry.ASPHALT_SLOPE.get().defaultBlockState().setValue(SlopeBlock.LAYERS, state.getValue(SlopeBlock.LAYERS));
                case 1:
                    return RSBlockRegistry.CONCRETE_SLOPE.get().defaultBlockState().setValue(SlopeBlock.LAYERS, state.getValue(SlopeBlock.LAYERS));
                default:
                    return null;
            }
        }
        else
        {
            switch(((PaintSystem)state.getBlock()).getMaterialType())
            {
                case 0:
                    return RSBlockRegistry.ASPHALT.get().defaultBlockState();
                case 1:
                    return RSBlockRegistry.CONCRETE.get().defaultBlockState();
                default:
                    return null;
            }
        }
    }

    public int getMaxPaint()
    {
        return this.paintQuantity;
    }

}