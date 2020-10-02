package tv.mapper.roadstuff.util;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.color.BlockColors;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraftforge.fml.RegistryObject;
import tv.mapper.mapperbase.block.PaintableBlock;
import tv.mapper.roadstuff.block.RSBlockRegistry;

public class ModColorHandler
{
    public static void registerBlockColor()
    {
        final BlockColors blockColors = Minecraft.getInstance().getBlockColors();

        final IBlockColor yellowColor = (state, blockAccess, pos, tintIndex) ->
        {
            return ModConstants.YELLOW_COLOR;
        };

        for(RegistryObject<PaintableBlock> block : RSBlockRegistry.MOD_PAINTABLEBLOCKS)
        {
            if(block.get().getRegistryName().toString().contains("yellow_line"))
                blockColors.register(yellowColor, block.get());
        }
    }
}