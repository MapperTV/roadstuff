package tv.mapper.roadstuff.util;

import it.unimi.dsi.fastutil.ints.Int2ObjectArrayMap;
import net.minecraft.block.Block;
import tv.mapper.roadstuff.init.ModBlocks;

public class ConcretePaintMap extends Int2ObjectArrayMap<Block>
{
    private static final long serialVersionUID = -2560468416060236377L;
    private static final int patternAmount = 19;

    public ConcretePaintMap()
    {
        super();
        register(0, 0, ModBlocks.CONCRETE_BLOCK);
        register(0, 1, ModBlocks.CONCRETE_SIMPLE_WHITE_LINE_BLOCK);
        register(0, 2, ModBlocks.CONCRETE_DOUBLE_WHITE_LINE_BLOCK);
        register(0, 3, ModBlocks.CONCRETE_DASHED_WHITE_LINE_BLOCK);
        register(0, 4, ModBlocks.CONCRETE_LARGE_WHITE_LINE_BLOCK);
        register(0, 5, ModBlocks.CONCRETE_X_WHITE_LINE_BLOCK);
        register(0, 6, ModBlocks.CONCRETE_T_WHITE_LINE_BLOCK);
        register(0, 7, ModBlocks.CONCRETE_CORNER_WHITE_LINE_BLOCK);
        register(0, 8, ModBlocks.CONCRETE_END_DOUBLE_WHITE_LINE_BLOCK);
        register(0, 9, ModBlocks.CONCRETE_DIAGONAL_WHITE_LINE_BLOCK);
        register(0, 10, ModBlocks.CONCRETE_LARGE_DIAGONAL_WHITE_LINE_BLOCK);
        register(0, 11, ModBlocks.CONCRETE_DOUBLE_DIAGONAL_WHITE_LINE_BLOCK);
        register(0, 12, ModBlocks.CONCRETE_SIMPLE_LEFT_WHITE_LINE_BLOCK);
        register(0, 13, ModBlocks.CONCRETE_SIMPLE_RIGHT_WHITE_LINE_BLOCK);
        register(0, 14, ModBlocks.CONCRETE_SIMPLE_LEFT_RIGHT_WHITE_LINE_BLOCK);
        register(0, 15, ModBlocks.CONCRETE_SIMPLE_SEPARATOR_WHITE_LINE_BLOCK);
        register(0, 16, ModBlocks.CONCRETE_SIMPLE_WHITE_ARROW_BLOCK);
        register(0, 17, ModBlocks.CONCRETE_SIMPLE_YELLOW_LEFT_ARROW_BLOCK);
        register(0, 18, ModBlocks.CONCRETE_SIMPLE_WHITE_RIGHT_ARROW_BLOCK);
        register(1, 0, ModBlocks.CONCRETE_BLOCK);
        register(1, 1, ModBlocks.CONCRETE_SIMPLE_YELLOW_LINE_BLOCK);
        register(1, 2, ModBlocks.CONCRETE_DOUBLE_YELLOW_LINE_BLOCK);
        register(1, 3, ModBlocks.CONCRETE_DASHED_YELLOW_LINE_BLOCK);
        register(1, 4, ModBlocks.CONCRETE_LARGE_YELLOW_LINE_BLOCK);
        register(1, 5, ModBlocks.CONCRETE_X_YELLOW_LINE_BLOCK);
        register(1, 6, ModBlocks.CONCRETE_T_YELLOW_LINE_BLOCK);
        register(1, 7, ModBlocks.CONCRETE_CORNER_YELLOW_LINE_BLOCK);
        register(1, 8, ModBlocks.CONCRETE_END_DOUBLE_YELLOW_LINE_BLOCK);
        register(1, 9, ModBlocks.CONCRETE_DIAGONAL_YELLOW_LINE_BLOCK);
        register(1, 10, ModBlocks.CONCRETE_LARGE_DIAGONAL_YELLOW_LINE_BLOCK);
        register(1, 11, ModBlocks.CONCRETE_DOUBLE_DIAGONAL_YELLOW_LINE_BLOCK);
        register(1, 12, ModBlocks.CONCRETE_SIMPLE_LEFT_YELLOW_LINE_BLOCK);
        register(1, 13, ModBlocks.CONCRETE_SIMPLE_RIGHT_YELLOW_LINE_BLOCK);
        register(1, 14, ModBlocks.CONCRETE_SIMPLE_LEFT_RIGHT_YELLOW_LINE_BLOCK);
        register(1, 15, ModBlocks.CONCRETE_SIMPLE_SEPARATOR_YELLOW_LINE_BLOCK);
        register(1, 16, ModBlocks.CONCRETE_SIMPLE_YELLOW_ARROW_BLOCK);
        register(1, 17, ModBlocks.CONCRETE_SIMPLE_YELLOW_LEFT_ARROW_BLOCK);
        register(1, 18, ModBlocks.CONCRETE_SIMPLE_YELLOW_RIGHT_ARROW_BLOCK);
    }

    public void register(int color, int pattern, Block block)
    {
        int id = 0;
        if(color == 1)
            id += patternAmount;
        this.put(id + pattern, block);
    }

    public Block getBlockFor(int color, int pattern)
    {
        int id = 0;
        if(color == 1)
            id += patternAmount;
        return this.get(id + pattern);
    }
}
