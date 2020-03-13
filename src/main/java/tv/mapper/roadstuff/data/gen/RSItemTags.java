package tv.mapper.roadstuff.data.gen;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.ItemTagsProvider;
import tv.mapper.roadstuff.data.RSTags;

public class RSItemTags extends ItemTagsProvider
{

    public RSItemTags(DataGenerator generatorIn)
    {
        super(generatorIn);
    }

    public void registerTags()
    {
        copy(RSTags.Blocks.ASPHALT_ROAD, RSTags.Items.ASPHALT_ROAD);
        copy(RSTags.Blocks.CONCRETE_ROAD, RSTags.Items.CONCRETE_ROAD);
    }
}
