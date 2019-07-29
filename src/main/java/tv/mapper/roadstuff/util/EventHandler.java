package tv.mapper.roadstuff.util;

import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class EventHandler
{
    // ToDo: restore back when events are back
    
    // @SubscribeEvent
    // public static void onLeftClickBlock(LeftClickBlock event)
    // {
    // PlayerEntity player = event.getEntityPlayer();
    // ItemStack heldItem = ItemStack.EMPTY;
    //
    // long timer = System.currentTimeMillis();
    //
    // if(player.getHeldItemMainhand().getItem() == ModItems.PAINT_BRUSH)
    // heldItem = player.getHeldItemMainhand();
    // else if(player.getHeldItemOffhand().getItem() == ModItems.PAINT_BRUSH)
    // heldItem = player.getHeldItemOffhand();
    //
    // if(heldItem.getItem() == ModItems.PAINT_BRUSH)
    // {
    // if(event.getFace() == Direction.UP && event.getWorld().getBlockState(event.getPos()).getBlock() instanceof PaintableBlock)
    // {
    // event.setCanceled(true);
    // System.out.println(timer - RoadStuff.clickInterval);
    // if(timer - RoadStuff.clickInterval > ModConstants.CLICK_DELAY)
    // {
    // if(player.isSneaking())
    // BrushItem.removeLine(event.getWorld(), event.getPos(), player);
    // else
    // BrushItem.paintLine(event.getFace(), event.getWorld().getBlockState(event.getPos()), event.getWorld(), event.getPos(), player, heldItem);
    // RoadStuff.clickInterval = timer;
    // }
    // }
    // }
    // }
}