package tv.mapper.roadstuff.util;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.renderer.color.BlockColors;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.client.renderer.color.ItemColors;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import tv.mapper.roadstuff.RoadStuff;
import tv.mapper.roadstuff.init.ModBlocks;

@Mod.EventBusSubscriber(modid = RoadStuff.MODID)
public class ModColorHandler
{
    @SubscribeEvent
    @OnlyIn(Dist.CLIENT)
    public static void registerBlockColorHandlers(final ColorHandlerEvent.Block event)
    {
        System.out.println("◘ COLOR HANDLER");

        final BlockColors blockColors = event.getBlockColors();

        final IBlockColor yellowColor = (state, blockAccess, pos, tintIndex) ->
        {
            return 16762880;
        };

        for(Block block : ModBlocks.MOD_BLOCKS)
        {
            if(block.getRegistryName().toString().contains("yellow_line"))
                blockColors.register(yellowColor, block);
        }
    }

    @SubscribeEvent
    @OnlyIn(Dist.CLIENT)
    public static void registerItemColorHandlers(final ColorHandlerEvent.Item event)
    {
        final BlockColors blockColors = event.getBlockColors();
        final ItemColors itemColors = event.getItemColors();

        final IItemColor yellowColor = (stack, tintIndex) ->
        {
            final BlockState state = ((BlockItem)stack.getItem()).getBlock().getDefaultState();
            return blockColors.getColor(state, null, null, tintIndex);
        };

        for(Item item : ModBlocks.MOD_ITEMS)
        {
            if(item.getRegistryName().toString().contains("yellow_line"))
                itemColors.register(yellowColor, item);
        }
    }
}
