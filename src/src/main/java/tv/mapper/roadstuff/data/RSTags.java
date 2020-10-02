package tv.mapper.roadstuff.data;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ResourceLocation;
import tv.mapper.roadstuff.RoadStuff;

public class RSTags
{
    public static class Blocks
    {
        public static final ITag.INamedTag<Block> CONCRETE_ROAD = tag("concrete_road");
        public static final ITag.INamedTag<Block> ASPHALT_ROAD = tag("asphalt_road");
        public static final ITag.INamedTag<Block> REFLECTORS = tag("reflectors");

        private static ITag.INamedTag<Block> tag(String name)
        {
            return BlockTags.makeWrapperTag(new ResourceLocation(RoadStuff.MODID, name).toString());
        }
    }

    public static class Items
    {
        public static final ITag.INamedTag<Item> CONCRETE_ROAD = tag("concrete_road");
        public static final ITag.INamedTag<Item> ASPHALT_ROAD = tag("asphalt_road");
        public static final ITag.INamedTag<Item> REFLECTORS = tag("reflectors");

        private static ITag.INamedTag<Item> tag(String name)
        {
            return ItemTags.makeWrapperTag(new ResourceLocation(RoadStuff.MODID, name).toString());
        }
    }

    public static class ForgeBlocks
    {

        @SuppressWarnings("unused")
        private static ITag.INamedTag<Block> tag(String name)
        {
            return BlockTags.makeWrapperTag(new ResourceLocation("forge", name).toString());
        }
    }

    public static class ForgeItems
    {

        @SuppressWarnings("unused")
        private static ITag.INamedTag<Item> tag(String name)
        {
            return ItemTags.makeWrapperTag(new ResourceLocation("forge", name).toString());
        }
    }
}