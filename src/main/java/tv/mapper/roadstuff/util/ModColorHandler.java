package tv.mapper.roadstuff.util;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.color.BlockColors;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.client.renderer.color.ItemColors;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import tv.mapper.roadstuff.init.ModBlocks;

public class ModColorHandler
{
    public static void registerBlockColor()
    {
        final BlockColors blockColors = Minecraft.getInstance().getBlockColors();

        final IBlockColor yellowColor = (state, blockAccess, pos, tintIndex) ->
        {
            return 15118080;
        };

        for(Block block : ModBlocks.MOD_PAINTABLEBLOCKS)
        {
            if(block.getRegistryName().toString().contains("yellow_line"))
                blockColors.register(yellowColor, block);
        }
    }

    public static void registerItemColorHandlers()
    {
        final BlockColors blockColors = Minecraft.getInstance().getBlockColors();
        final ItemColors itemColors = Minecraft.getInstance().getItemColors();

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
