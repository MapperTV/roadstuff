package tv.mapper.roadstuff.util;

import net.minecraft.client.Minecraft;
import net.minecraft.client.color.block.BlockColor;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;
import tv.mapper.roadstuff.world.level.block.RSBlockRegistry;

public class ModColorHandler
{
    public static void registerBlockColor()
    {
        final BlockColors blockColors = Minecraft.getInstance().getBlockColors();

        final BlockColor yellowColor = (state, blockAccess, pos, tintIndex) ->
        {
            return ModConstants.YELLOW_COLOR;
        };

        for(RegistryObject<Block> block : RSBlockRegistry.MOD_PAINTABLEBLOCKS)
        {
            if(block.get().getRegistryName().toString().contains("yellow_line"))
                blockColors.register(yellowColor, block.get());
        }
    }
}