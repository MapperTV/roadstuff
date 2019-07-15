package tv.mapper.roadstuff.util;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Direction;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.LeftClickBlock;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import tv.mapper.roadstuff.RoadStuff;
import tv.mapper.roadstuff.block.PaintableBlock;
import tv.mapper.roadstuff.init.ModItems;
import tv.mapper.roadstuff.item.BrushItem;

@EventBusSubscriber
public class EventHandler
{
    @SubscribeEvent
    public static void onLeftClickBlock(LeftClickBlock event)
    {
        PlayerEntity player = event.getEntityPlayer();
        ItemStack heldItem = ItemStack.EMPTY;

        long timer = System.currentTimeMillis();

        if(player.getHeldItemMainhand().getItem() == ModItems.PAINT_BRUSH)
            heldItem = player.getHeldItemMainhand();
        else if(player.getHeldItemOffhand().getItem() == ModItems.PAINT_BRUSH)
            heldItem = player.getHeldItemOffhand();

        if(heldItem.getItem() == ModItems.PAINT_BRUSH)
        {
            if(event.getFace() == Direction.UP && event.getWorld().getBlockState(event.getPos()).getBlock() instanceof PaintableBlock)
            {
                event.setCanceled(true);
                System.out.println(timer - RoadStuff.clickInterval);
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