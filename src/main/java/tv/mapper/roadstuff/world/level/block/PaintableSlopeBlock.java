package tv.mapper.roadstuff.world.level.block;

import tv.mapper.mapperbase.world.level.block.SlopeBlock;
import tv.mapper.mapperbase.world.level.block.ToolTiers;
import tv.mapper.mapperbase.world.level.block.ToolTypes;

public class PaintableSlopeBlock extends SlopeBlock
{
    protected int materialType = 0;

    public PaintableSlopeBlock(Properties properties, ToolTypes tool, int materialType)
    {
        super(properties, tool);
        this.materialType = materialType;
    }

    public PaintableSlopeBlock(Properties properties, ToolTypes tool, ToolTiers tier, int materialType)
    {
        super(properties, tool, tier);
        this.materialType = materialType;
    }

    public int getMaterialType()
    {
        return this.materialType;
    }
}