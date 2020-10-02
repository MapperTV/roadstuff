package tv.mapper.roadstuff.util;

import it.unimi.dsi.fastutil.ints.Int2ObjectArrayMap;
import net.minecraftforge.fml.RegistryObject;
import tv.mapper.mapperbase.block.BaseBlocks;
import tv.mapper.mapperbase.block.PaintableBlock;
import tv.mapper.roadstuff.block.RSBlockRegistry;

public class AsphaltPaintMap extends Int2ObjectArrayMap<PaintableBlock>
{
    private static final long serialVersionUID = 6932027980822532932L;

    public AsphaltPaintMap(boolean slope)
    {
        super();
        if(!slope)
            register(0, 0, BaseBlocks.ASPHALT.get());
        else if(slope)
            register(0, 0, RSBlockRegistry.ASPHALT_SLOPE.get());

        int index = 1;

        PaintableBlock block;

        for(RegistryObject<PaintableBlock> object : RSBlockRegistry.MOD_PAINTABLEBLOCKS)
        {
            block = object.get();

            if(block.getRegistryName().toString().contains("asphalt_"))
            {
                if(block.getRegistryName().toString().contains("_white_"))
                {
                    if(block.getRegistryName().toString().contains("_slope_") && slope)
                    {
                        register(0, index, block);
                        index++;
                    }
                    else if(!block.getRegistryName().toString().contains("_slope_") && !slope)
                    {
                        register(0, index, block);
                        index++;
                    }
                }
            }
        }

        if(!slope)
            register(1, 0, BaseBlocks.ASPHALT.get());
        else if(slope)
            register(1, 0, RSBlockRegistry.ASPHALT_SLOPE.get());

        index = 1;
        for(RegistryObject<PaintableBlock> object : RSBlockRegistry.MOD_PAINTABLEBLOCKS)
        {
            block = object.get();

            if(block.getRegistryName().toString().contains("asphalt_"))
            {
                if(block.getRegistryName().toString().contains("_yellow_"))
                {
                    if(block.getRegistryName().toString().contains("_slope_") && slope)
                    {
                        register(1, index, block);
                        index++;
                    }
                    else if(!block.getRegistryName().toString().contains("_slope_") && !slope)
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
        PaintableBlock block;
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