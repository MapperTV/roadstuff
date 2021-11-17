package tv.mapper.roadstuff.state.properties;

import net.minecraft.util.StringRepresentable;
import net.minecraft.network.chat.TranslatableComponent;

public enum EnumPaintColor implements StringRepresentable
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

    public String getSerializedName()
    {
        return this.name;
    }

    public String getNameTranslated()
    {
        return new TranslatableComponent("roadstuff.message.paint.color." + this.name).getString();
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