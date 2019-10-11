package tv.mapper.roadstuff.util;

import it.unimi.dsi.fastutil.ints.Int2ObjectArrayMap;
import net.minecraft.block.Block;
import tv.mapper.roadstuff.block.PaintableBlock;
import tv.mapper.roadstuff.init.ModBlocks;

public class ConcretePaintMap extends Int2ObjectArrayMap<PaintableBlock>
{
    private static final long serialVersionUID = -2560468416060236377L;

    public ConcretePaintMap(boolean slope)
    {
        super();
        if(!slope)
            register(0, 0, ModBlocks.CONCRETE);
        else if(slope)
            register(0, 0, ModBlocks.CONCRETE_SLOPE);

        int index = 1;
        for(PaintableBlock blockWhite : ModBlocks.MOD_PAINTABLEBLOCKS)
        {
            if(blockWhite.getRegistryName().toString().contains("concrete_"))
            {
                if(blockWhite.getRegistryName().toString().contains("_white_"))
                {
                    if(blockWhite.getRegistryName().toString().contains("slope") && slope)
                    {
                        register(0, index, blockWhite);
                        index++;
                    }
                    else if(!blockWhite.getRegistryName().toString().contains("slope") && !slope)
                    {
                        register(0, index, blockWhite);
                        index++;
                    }
                }

            }
        }

        if(!slope)
            register(1, 0, ModBlocks.CONCRETE);
        else if(slope)
            register(1, 0, ModBlocks.CONCRETE_SLOPE);

        index = 1;
        for(PaintableBlock blockYellow : ModBlocks.MOD_PAINTABLEBLOCKS)
        {
            if(blockYellow.getRegistryName().toString().contains("concrete_"))
            {
                if(blockYellow.getRegistryName().toString().contains("_yellow_"))
                {
                    if(blockYellow.getRegistryName().toString().contains("slope") && slope)
                    {
                        register(1, index, blockYellow);
                        index++;
                    }
                    else if(!blockYellow.getRegistryName().toString().contains("slope") && !slope)
                    {
                        register(1, index, blockYellow);
                        index++;
                    }
                }
            }
        }
    }

    public void register(int color, int pattern, PaintableBlock block)
    {
        int id = 0;
        if(color == 1)
            id += ModConstants.PATTERNS;
        this.put(id + pattern, block);
    }

    public PaintableBlock getBlockFor(int color, int pattern)
    {
        int id = 0;
        if(color == 1)
            id += ModConstants.PATTERNS;
        return this.get(id + pattern);
    }

    public int[] getParamsFor(PaintableBlock blockIn)
    {
        int i = 0;
        int color = 0, pattern = 0;
        Block block;
        while(i < this.size())
        {
            block = this.get(i);
            if(block == blockIn)
            {
                if(i >= ModConstants.PATTERNS)
                {
                    color = 1;
                    pattern = i - ModConstants.PATTERNS;
                }
                else
                    pattern = i;
            }
            i++;
        }
        return new int[] {color, pattern};
    }
}
