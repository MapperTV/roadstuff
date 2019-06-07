package tv.mapper.roadstuff.state.properties;

import net.minecraft.util.IStringSerializable;

public enum EnumPaintColor implements IStringSerializable
{
    WHITE(0, "white"),
    YELLOW(1, "yellow");

    private final int id;
    private final String name;

    private EnumPaintColor(int id, String name)
    {
        this.id = id;
        this.name = name;
    }

    public String getName()
    {
        return this.name;
    }
    
    public int getId()
    {
        return this.id;
    }
    
    public static EnumPaintColor getColorByID(int id)
    {
        for(EnumPaintColor color : values())
        {
            if(color.getId() == id)
                return color;
        }
        return null;
    }
}