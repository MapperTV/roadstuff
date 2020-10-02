package tv.mapper.roadstuff.state.properties;

import net.minecraft.util.IStringSerializable;
import net.minecraft.util.text.TranslationTextComponent;

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

    public String getString()
    {
        return this.name;
    }

    public String getNameTranslated()
    {
        return new TranslationTextComponent("roadstuff.message.paint.color." + this.name).getString();
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