package tv.mapper.roadstuff.data.gen;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import tv.mapper.mapperbase.item.BaseItems;
import tv.mapper.roadstuff.RoadStuff;
import tv.mapper.roadstuff.data.RSTags;
import tv.mapper.roadstuff.item.RSItemRegistry;

public class RSItemTags extends ItemTagsProvider
{
    public RSItemTags(DataGenerator generatorIn, RSBlockTags provider, ExistingFileHelper existingFileHelper)
    {
        super(generatorIn, provider, RoadStuff.MODID, existingFileHelper);
    }

    public void addTags()
    {
        this.tag(RSTags.Items.ASPHALT_ROAD).add(BaseItems.ASPHALT_ITEM.get(), RSItemRegistry.ASPHALT_SLOPE_ITEM.get());
        this.tag(RSTags.Items.CONCRETE_ROAD).add(BaseItems.CONCRETE_ITEM.get(), RSItemRegistry.CONCRETE_SLOPE_ITEM.get());
        copy(RSTags.Blocks.REFLECTORS, RSTags.Items.REFLECTORS);
    }
}