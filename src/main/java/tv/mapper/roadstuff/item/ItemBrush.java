package tv.mapper.roadstuff.item;

import java.util.List;

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
import net.minecraft.world.World;
import tv.mapper.roadstuff.block.BlockPaintBucket;
import tv.mapper.roadstuff.block.IPaintable;

public class ItemBrush extends Item
{
    private static final int MAX_PAINT = 8;

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
            ItemBrushClient.displayBrushGui(stack.getTag().getInt("pattern"), stack.getTag().getInt("paint"));
        }

        return new ActionResult<>(EnumActionResult.SUCCESS, stack);
    }

    public EnumActionResult onItemUse(ItemUseContext context)
    {
        World world = context.getWorld();
        BlockPos blockpos = context.getPos();
        EntityPlayer entityplayer = context.getPlayer();
        ItemStack stack = context.getItem();

        NBTTagCompound nbt = checkNBT(stack);

        IBlockState state = world.getBlockState(blockpos);
        if(state != null && nbt.hasKey("paint"))
        {
            if(nbt.getInt("paint") > 0 && context.getFace() == EnumFacing.UP && state.getBlock() instanceof IPaintable)
            {

                nbt.setInt("paint", nbt.getInt("paint") - 1);
                world.playSound(entityplayer, blockpos, SoundEvents.BLOCK_SLIME_BLOCK_FALL, SoundCategory.BLOCKS, .8F, 1.0F);

                stack.setTag(nbt);
                return EnumActionResult.SUCCESS;

            }
            else if(nbt.getInt("paint") < MAX_PAINT && state.getBlock() instanceof BlockPaintBucket)
            {

                nbt.setInt("paint", MAX_PAINT);
                world.playSound(entityplayer, blockpos, SoundEvents.ITEM_BUCKET_EMPTY_LAVA, SoundCategory.BLOCKS, .8F, 1.0F);

                stack.setTag(nbt);
                return EnumActionResult.SUCCESS;
            }
        }

        return EnumActionResult.PASS;
    }

    @Override
    public void addInformation(ItemStack stack, World player, List<ITextComponent> list, ITooltipFlag flag)
    {
        super.addInformation(stack, player, list, flag);
        if(stack.hasTag())
        {
            list.add(new TextComponentString("Pattern: " + stack.getTag().getInt("pattern") + ", paint: " + stack.getTag().getInt("paint")));
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
            nbt.setInt("paint", MAX_PAINT);
            nbt.setInt("pattern", 0);
        }
        return nbt;
    }
}
