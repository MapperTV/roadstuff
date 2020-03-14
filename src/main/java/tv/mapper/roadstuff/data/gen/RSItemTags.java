package tv.mapper.roadstuff.data.gen;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.ItemTagsProvider;
import tv.mapper.mapperbase.item.BaseItems;
import tv.mapper.roadstuff.data.RSTags;
import tv.mapper.roadstuff.item.RSItemRegistry;

public class RSItemTags extends ItemTagsProvider
{
    public RSItemTags(DataGenerator generatorIn)
    {
        super(generatorIn);
    }

    public void registerTags()
    {
        this.getBuilder(RSTags.Items.ASPHALT_ROAD).add(BaseItems.ASPHALT_ITEM.get(), RSItemRegistry.ASPHALT_SLOPE_ITEM.get());
        this.getBuilder(RSTags.Items.CONCRETE_ROAD).add(BaseItems.CONCRETE_ITEM.get(), RSItemRegistry.CONCRETE_SLOPE_ITEM.get());
        copy(RSTags.Blocks.REFLECTORS, RSTags.Items.REFLECTORS);
    }
}