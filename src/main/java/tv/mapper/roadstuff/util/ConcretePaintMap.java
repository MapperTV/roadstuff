package tv.mapper.roadstuff.util;

import it.unimi.dsi.fastutil.ints.Int2ObjectArrayMap;
import net.minecraft.block.Block;
import tv.mapper.roadstuff.init.ModBlocks;

public class ConcretePaintMap extends Int2ObjectArrayMap<Block>
{
    private static final long serialVersionUID = -2560468416060236377L;

    public ConcretePaintMap()
    {
        super();
        register(0, 0, ModBlocks.CONCRETE);

        int index = 1;
        for(Block blockWhite : ModBlocks.MOD_BLOCKS)
        {
            if(blockWhite.getRegistryName().toString().contains("concrete_"))
            {
                if(blockWhite.getRegistryName().toString().contains("_white_"))
                {
                    register(0, index, blockWhite);
                    index++;
                }
            }
        }

        register(1, 0, ModBlocks.CONCRETE);

        index = 1;
        for(Block blockYellow : ModBlocks.MOD_BLOCKS)
        {
            if(blockYellow.getRegistryName().toString().contains("concrete_"))
            {
                if(blockYellow.getRegistryName().toString().contains("_yellow_"))
                {
                    register(1, index, blockYellow);
                    index++;
                }
            }
        }
    }

    public void register(int color, int pattern, Block block)
    {
        int id = 0;
        if(color == 1)
            id += ModConstants.PATTERNS;
        this.put(id + pattern, block);
    }

    public Block getBlockFor(int color, int pattern)
    {
        int id = 0;
        if(color == 1)
            id += ModConstants.PATTERNS;
        return this.get(id + pattern);
    }
    
    public int[] getParamsFor(Block blockIn)
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
