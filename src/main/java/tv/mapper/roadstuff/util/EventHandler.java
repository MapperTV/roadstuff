package tv.mapper.roadstuff.util;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Direction;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.LeftClickBlock;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import tv.mapper.roadstuff.RoadStuff;
import tv.mapper.roadstuff.block.PaintableBlock;
import tv.mapper.roadstuff.config.GlobalConfig;
import tv.mapper.roadstuff.init.ModItems;
import tv.mapper.roadstuff.item.BrushItem;

@Mod.EventBusSubscriber
public class EventHandler
{
    @SubscribeEvent
    public static void onLeftClickBlock(LeftClickBlock event)
    {
        if(!GlobalConfig.BRUSH_ALTERNATIVE_MODE.get() && !event.getWorld().isRemote)
        {
            PlayerEntity player = event.getEntityPlayer();
            ItemStack heldItem = ItemStack.EMPTY;

            long timer = System.currentTimeMillis();

            if(player.getHeldItemMainhand().getItem() == ModItems.PAINT_BRUSH)
                heldItem = player.getHeldItemMainhand();
            else if(player.getHeldItemOffhand().getItem() == ModItems.PAINT_BRUSH)
                heldItem = player.getHeldItemOffhand();

            if(event.getFace() == Direction.UP && event.getWorld().getBlockState(event.getPos()).getBlock() instanceof PaintableBlock)
            {
                if(player.isCreative())
                    event.setCanceled(true);
                if(timer - RoadStuff.clickInterval > ModConstants.CLICK_DELAY)
                {
                    if(player.isSneaking())
                        BrushItem.removeLine(event.getWorld(), event.getPos(), player);
                    else
                        BrushItem.paintLine(event.getFace(), event.getWorld().getBlockState(event.getPos()), event.getWorld(), event.getPos(), player, heldItem);
                    RoadStuff.clickInterval = timer;
                }
            }

        }
    }
}