package tv.mapper.roadstuff.data.gen;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.ItemTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraftforge.common.Tags;
import tv.mapper.mapperbase.data.BaseTags;
import tv.mapper.mapperbase.item.BaseItems;

public class RSItemTags extends ItemTagsProvider
{

    public RSItemTags(DataGenerator generatorIn)
    {
        super(generatorIn);
    }

    public void registerTags()
    {
        copy(BlockTags.STAIRS, ItemTags.STAIRS);
        copy(BlockTags.SLABS, ItemTags.SLABS);
        copy(BlockTags.WALLS, ItemTags.WALLS);
        copy(BlockTags.FENCES, ItemTags.FENCES);
        copy(Tags.Blocks.FENCES, Tags.Items.FENCES);
        copy(Tags.Blocks.STORAGE_BLOCKS, Tags.Items.STORAGE_BLOCKS);
        copy(BaseTags.ForgeBlocks.STORAGE_BLOCKS_STEEL, BaseTags.ForgeItems.STORAGE_BLOCKS_STEEL);
        copy(BaseTags.ForgeBlocks.PRESSURE_PLATES, BaseTags.ForgeItems.PRESSURE_PLATES);
        copy(BaseTags.Blocks.CONCRETE, BaseTags.Items.CONCRETE);

        getBuilder(BaseTags.ForgeItems.INGOTS_STEEL).add(BaseItems.STEEL_INGOT);
        getBuilder(BaseTags.ForgeItems.NUGGETS_STEEL).add(BaseItems.STEEL_NUGGET);
        getBuilder(BaseTags.ForgeItems.PLATES_STEEL).add(BaseItems.STEEL_PLATE);
        getBuilder(BaseTags.ForgeItems.RODS_STEEL).add(BaseItems.STEEL_ROD);

        getBuilder(Tags.Items.NUGGETS).add(BaseItems.STEEL_NUGGET);
        getBuilder(Tags.Items.RODS).add(BaseItems.STEEL_ROD);
        getBuilder(Tags.Items.INGOTS).add(BaseItems.STEEL_INGOT);

        getBuilder(BaseTags.ForgeItems.PLATES_IRON).add(BaseItems.IRON_PLATE);
        getBuilder(BaseTags.ForgeItems.RODS_IRON).add(BaseItems.IRON_ROD);

        getBuilder(BaseTags.ForgeItems.PLATES).add(BaseItems.IRON_PLATE);
        getBuilder(BaseTags.ForgeItems.PLATES).add(BaseItems.STEEL_PLATE);
    }
}
