package tv.mapper.roadstuff.util;

import net.minecraft.block.BlockState;
import net.minecraft.client.renderer.color.BlockColors;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.client.renderer.color.ItemColors;
import net.minecraft.item.BlockItem;
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
        final BlockColors blockColors = event.getBlockColors();

        final IBlockColor lineColorHandler = (state, blockAccess, pos, tintIndex) ->
        {
            return 16762880;
        };

        blockColors.register(lineColorHandler, ModBlocks.ASPHALT_DOUBLE_YELLOW_LINE_BLOCK);
        blockColors.register(lineColorHandler, ModBlocks.ASPHALT_SIMPLE_YELLOW_LINE_BLOCK);
        blockColors.register(lineColorHandler, ModBlocks.ASPHALT_DASHED_YELLOW_LINE_BLOCK);
        blockColors.register(lineColorHandler, ModBlocks.ASPHALT_LARGE_YELLOW_LINE_BLOCK);
        blockColors.register(lineColorHandler, ModBlocks.ASPHALT_X_YELLOW_LINE_BLOCK);
        blockColors.register(lineColorHandler, ModBlocks.ASPHALT_T_YELLOW_LINE_BLOCK);
        blockColors.register(lineColorHandler, ModBlocks.ASPHALT_CORNER_YELLOW_LINE_BLOCK);
        blockColors.register(lineColorHandler, ModBlocks.ASPHALT_END_DOUBLE_YELLOW_LINE_BLOCK);
        blockColors.register(lineColorHandler, ModBlocks.ASPHALT_DIAGONAL_YELLOW_LINE_BLOCK);
        blockColors.register(lineColorHandler, ModBlocks.ASPHALT_LARGE_DIAGONAL_YELLOW_LINE_BLOCK);
        blockColors.register(lineColorHandler, ModBlocks.ASPHALT_DOUBLE_DIAGONAL_YELLOW_LINE_BLOCK);
        blockColors.register(lineColorHandler, ModBlocks.ASPHALT_SIMPLE_LEFT_YELLOW_LINE_BLOCK);
        blockColors.register(lineColorHandler, ModBlocks.ASPHALT_SIMPLE_RIGHT_YELLOW_LINE_BLOCK);
        blockColors.register(lineColorHandler, ModBlocks.ASPHALT_SIMPLE_LEFT_RIGHT_YELLOW_LINE_BLOCK);
        blockColors.register(lineColorHandler, ModBlocks.ASPHALT_SIMPLE_SEPARATOR_YELLOW_LINE_BLOCK);
        blockColors.register(lineColorHandler, ModBlocks.ASPHALT_SIMPLE_YELLOW_ARROW_BLOCK);
        blockColors.register(lineColorHandler, ModBlocks.ASPHALT_SIMPLE_YELLOW_LEFT_ARROW_BLOCK);
        blockColors.register(lineColorHandler, ModBlocks.ASPHALT_SIMPLE_YELLOW_RIGHT_ARROW_BLOCK);
        
        blockColors.register(lineColorHandler, ModBlocks.CONCRETE_DOUBLE_YELLOW_LINE_BLOCK);
        blockColors.register(lineColorHandler, ModBlocks.CONCRETE_SIMPLE_YELLOW_LINE_BLOCK);
        blockColors.register(lineColorHandler, ModBlocks.CONCRETE_DASHED_YELLOW_LINE_BLOCK);
        blockColors.register(lineColorHandler, ModBlocks.CONCRETE_LARGE_YELLOW_LINE_BLOCK);
        blockColors.register(lineColorHandler, ModBlocks.CONCRETE_X_YELLOW_LINE_BLOCK);
        blockColors.register(lineColorHandler, ModBlocks.CONCRETE_T_YELLOW_LINE_BLOCK);
        blockColors.register(lineColorHandler, ModBlocks.CONCRETE_CORNER_YELLOW_LINE_BLOCK);
        blockColors.register(lineColorHandler, ModBlocks.CONCRETE_END_DOUBLE_YELLOW_LINE_BLOCK);
        blockColors.register(lineColorHandler, ModBlocks.CONCRETE_DIAGONAL_YELLOW_LINE_BLOCK);
        blockColors.register(lineColorHandler, ModBlocks.CONCRETE_LARGE_DIAGONAL_YELLOW_LINE_BLOCK);
        blockColors.register(lineColorHandler, ModBlocks.CONCRETE_DOUBLE_DIAGONAL_YELLOW_LINE_BLOCK);
        blockColors.register(lineColorHandler, ModBlocks.CONCRETE_SIMPLE_LEFT_YELLOW_LINE_BLOCK);
        blockColors.register(lineColorHandler, ModBlocks.CONCRETE_SIMPLE_RIGHT_YELLOW_LINE_BLOCK);
        blockColors.register(lineColorHandler, ModBlocks.CONCRETE_SIMPLE_LEFT_RIGHT_YELLOW_LINE_BLOCK);
        blockColors.register(lineColorHandler, ModBlocks.CONCRETE_SIMPLE_SEPARATOR_YELLOW_LINE_BLOCK);
        blockColors.register(lineColorHandler, ModBlocks.CONCRETE_SIMPLE_YELLOW_ARROW_BLOCK);
        blockColors.register(lineColorHandler, ModBlocks.CONCRETE_SIMPLE_YELLOW_LEFT_ARROW_BLOCK);
        blockColors.register(lineColorHandler, ModBlocks.CONCRETE_SIMPLE_YELLOW_RIGHT_ARROW_BLOCK);
    }

    @SubscribeEvent
    @OnlyIn(Dist.CLIENT)
    public static void registerItemColorHandlers(final ColorHandlerEvent.Item event)
    {
        final BlockColors blockColors = event.getBlockColors();
        final ItemColors itemColors = event.getItemColors();

        final IItemColor itemBlockColorHandler = (stack, tintIndex) ->
        {
            final BlockState state = ((BlockItem)stack.getItem()).getBlock().getDefaultState();
            return blockColors.getColor(state, null, null, tintIndex);
        };

        itemColors.register(itemBlockColorHandler, ModBlocks.ASPHALT_SIMPLE_YELLOW_LINE_BLOCK);
        itemColors.register(itemBlockColorHandler, ModBlocks.ASPHALT_DOUBLE_YELLOW_LINE_BLOCK);
        itemColors.register(itemBlockColorHandler, ModBlocks.ASPHALT_DASHED_YELLOW_LINE_BLOCK);
        itemColors.register(itemBlockColorHandler, ModBlocks.ASPHALT_LARGE_YELLOW_LINE_BLOCK);
        itemColors.register(itemBlockColorHandler, ModBlocks.ASPHALT_X_YELLOW_LINE_BLOCK);
        itemColors.register(itemBlockColorHandler, ModBlocks.ASPHALT_T_YELLOW_LINE_BLOCK);
        itemColors.register(itemBlockColorHandler, ModBlocks.ASPHALT_CORNER_YELLOW_LINE_BLOCK);
        itemColors.register(itemBlockColorHandler, ModBlocks.ASPHALT_END_DOUBLE_YELLOW_LINE_BLOCK);
        itemColors.register(itemBlockColorHandler, ModBlocks.ASPHALT_DIAGONAL_YELLOW_LINE_BLOCK);
        itemColors.register(itemBlockColorHandler, ModBlocks.ASPHALT_LARGE_DIAGONAL_YELLOW_LINE_BLOCK);
        itemColors.register(itemBlockColorHandler, ModBlocks.ASPHALT_DOUBLE_DIAGONAL_YELLOW_LINE_BLOCK);
        itemColors.register(itemBlockColorHandler, ModBlocks.ASPHALT_SIMPLE_LEFT_YELLOW_LINE_BLOCK);
        itemColors.register(itemBlockColorHandler, ModBlocks.ASPHALT_SIMPLE_RIGHT_YELLOW_LINE_BLOCK);
        itemColors.register(itemBlockColorHandler, ModBlocks.ASPHALT_SIMPLE_LEFT_RIGHT_YELLOW_LINE_BLOCK);
        itemColors.register(itemBlockColorHandler, ModBlocks.ASPHALT_SIMPLE_SEPARATOR_YELLOW_LINE_BLOCK);
        itemColors.register(itemBlockColorHandler, ModBlocks.ASPHALT_SIMPLE_YELLOW_ARROW_BLOCK);
        itemColors.register(itemBlockColorHandler, ModBlocks.ASPHALT_SIMPLE_YELLOW_LEFT_ARROW_BLOCK);
        itemColors.register(itemBlockColorHandler, ModBlocks.ASPHALT_SIMPLE_YELLOW_RIGHT_ARROW_BLOCK);
        
        itemColors.register(itemBlockColorHandler, ModBlocks.CONCRETE_SIMPLE_YELLOW_LINE_BLOCK);
        itemColors.register(itemBlockColorHandler, ModBlocks.CONCRETE_DOUBLE_YELLOW_LINE_BLOCK);
        itemColors.register(itemBlockColorHandler, ModBlocks.CONCRETE_DASHED_YELLOW_LINE_BLOCK);
        itemColors.register(itemBlockColorHandler, ModBlocks.CONCRETE_LARGE_YELLOW_LINE_BLOCK);
        itemColors.register(itemBlockColorHandler, ModBlocks.CONCRETE_X_YELLOW_LINE_BLOCK);
        itemColors.register(itemBlockColorHandler, ModBlocks.CONCRETE_T_YELLOW_LINE_BLOCK);
        itemColors.register(itemBlockColorHandler, ModBlocks.CONCRETE_CORNER_YELLOW_LINE_BLOCK);
        itemColors.register(itemBlockColorHandler, ModBlocks.CONCRETE_END_DOUBLE_YELLOW_LINE_BLOCK);
        itemColors.register(itemBlockColorHandler, ModBlocks.CONCRETE_DIAGONAL_YELLOW_LINE_BLOCK);
        itemColors.register(itemBlockColorHandler, ModBlocks.CONCRETE_LARGE_DIAGONAL_YELLOW_LINE_BLOCK);
        itemColors.register(itemBlockColorHandler, ModBlocks.CONCRETE_DOUBLE_DIAGONAL_YELLOW_LINE_BLOCK);
        itemColors.register(itemBlockColorHandler, ModBlocks.CONCRETE_SIMPLE_LEFT_YELLOW_LINE_BLOCK);
        itemColors.register(itemBlockColorHandler, ModBlocks.CONCRETE_SIMPLE_RIGHT_YELLOW_LINE_BLOCK);
        itemColors.register(itemBlockColorHandler, ModBlocks.CONCRETE_SIMPLE_LEFT_RIGHT_YELLOW_LINE_BLOCK);
        itemColors.register(itemBlockColorHandler, ModBlocks.CONCRETE_SIMPLE_SEPARATOR_YELLOW_LINE_BLOCK);
        itemColors.register(itemBlockColorHandler, ModBlocks.CONCRETE_SIMPLE_YELLOW_ARROW_BLOCK);
        itemColors.register(itemBlockColorHandler, ModBlocks.CONCRETE_SIMPLE_YELLOW_LEFT_ARROW_BLOCK);
        itemColors.register(itemBlockColorHandler, ModBlocks.CONCRETE_SIMPLE_YELLOW_RIGHT_ARROW_BLOCK);
    }
}
