package tv.mapper.roadstuff.util;

import it.unimi.dsi.fastutil.ints.Int2ObjectArrayMap;
import net.minecraft.block.Block;
import net.minecraftforge.fml.RegistryObject;
import tv.mapper.mapperbase.block.BaseBlocks;
import tv.mapper.mapperbase.block.PaintableBlock;
import tv.mapper.roadstuff.block.RSBlockRegistry;

public class ConcretePaintMap extends Int2ObjectArrayMap<PaintableBlock>
{
    private static final long serialVersionUID = -2560468416060236377L;

    public ConcretePaintMap(boolean slope)
    {
        super();
        if(!slope)
            register(0, 0, BaseBlocks.CONCRETE.get());
        else if(slope)
            register(0, 0, RSBlockRegistry.CONCRETE_SLOPE.get());

        int index = 1;

        PaintableBlock block;

        for(RegistryObject<PaintableBlock> object : RSBlockRegistry.MOD_PAINTABLEBLOCKS)
        {
            block = object.get();

            if(block.getRegistryName().toString().contains("concrete_"))
            {
                if(block.getRegistryName().toString().contains("_white_"))
                {
                    if(block.getRegistryName().toString().contains("slope") && slope)
                    {
                        register(0, index, block);
                        index++;
                    }
                    else if(!block.getRegistryName().toString().contains("slope") && !slope)
                    {
                        register(0, index, block);
                        index++;
                    }
                }

            }
        }

        if(!slope)
            register(1, 0, BaseBlocks.CONCRETE.get());
        else if(slope)
            register(1, 0, RSBlockRegistry.CONCRETE_SLOPE.get());

        index = 1;
        for(RegistryObject<PaintableBlock> object : RSBlockRegistry.MOD_PAINTABLEBLOCKS)
        {
            block = object.get();

            if(block.getRegistryName().toString().contains("concrete_"))
            {
                if(block.getRegistryName().toString().contains("_yellow_"))
                {
                    if(block.getRegistryName().toString().contains("slope") && slope)
                    {
                        register(1, index, block);
                        index++;
                    }
                    else if(!block.getRegistryName().toString().contains("slope") && !slope)
                    {
                        register(1, index, block);
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