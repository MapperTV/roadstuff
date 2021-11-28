package tv.mapper.roadstuff.util;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.LeftClickBlock;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.common.Mod;
import tv.mapper.roadstuff.RoadStuff;
import tv.mapper.roadstuff.block.PaintSystem;
import tv.mapper.roadstuff.item.BrushItem;
import tv.mapper.roadstuff.item.RSItemRegistry;

@Mod.EventBusSubscriber
public class EventHandler
{
    @SubscribeEvent
    public static void onLeftClickBlock(LeftClickBlock event)
    {
        if(event.getFace() == Direction.UP && !ModConstants.ALTERNATE_BRUSH)
        {
            BlockPos pos = event.getPos();
            Level world = event.getWorld();
            BlockState state = world.getBlockState(pos);

            if(state.getBlock() instanceof PaintSystem)
            {
                Player player = event.getPlayer();
                ItemStack heldItem = ItemStack.EMPTY;

                long timer = System.currentTimeMillis();

                if(player.getMainHandItem().getItem() == RSItemRegistry.PAINT_BRUSH.get())
                    heldItem = player.getMainHandItem();
                else if(player.getOffhandItem().getItem() == RSItemRegistry.PAINT_BRUSH.get())
                    heldItem = player.getOffhandItem();

                if(heldItem.getItem() == RSItemRegistry.PAINT_BRUSH.get())
                {
                    if(player.isCreative())
                    {
                        event.setCanceled(true);
                    }

                    if(timer - RoadStuff.clickInterval > ModConstants.CLICK_DELAY && event.getSide() == LogicalSide.SERVER)
                    {
                        if(player.isShiftKeyDown())
                            BrushItem.removeLine(world, pos, player);
                        else
                            BrushItem.paintLine(event.getFace(), state, world, pos, player, heldItem);
                        RoadStuff.clickInterval = timer;
                    }
                }
            }
        }
    }
}