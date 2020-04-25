package tv.mapper.roadstuff.util;

import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.LeftClickBlock;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.common.Mod;
import tv.mapper.mapperbase.block.PaintableBlock;
import tv.mapper.roadstuff.RoadStuff;
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
            World world = event.getWorld();
            BlockState state = world.getBlockState(pos);

            if(state.getBlock() instanceof PaintableBlock)
            {
                PlayerEntity player = event.getPlayer();
                ItemStack heldItem = ItemStack.EMPTY;

                long timer = System.currentTimeMillis();

                if(player.getHeldItemMainhand().getItem() == RSItemRegistry.PAINT_BRUSH.get())
                    heldItem = player.getHeldItemMainhand();
                else if(player.getHeldItemOffhand().getItem() == RSItemRegistry.PAINT_BRUSH.get())
                    heldItem = player.getHeldItemOffhand();

                if(heldItem.getItem() == RSItemRegistry.PAINT_BRUSH.get())
                {
                    if(player.isCreative())
                    {
                        event.setCanceled(true);
                    }

                    if(timer - RoadStuff.clickInterval > ModConstants.CLICK_DELAY && event.getSide() == LogicalSide.SERVER)
                    {
                        if(player.isSneaking())
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