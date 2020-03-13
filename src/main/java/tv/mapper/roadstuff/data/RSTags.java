package tv.mapper.roadstuff.data;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.Tag;
import net.minecraft.util.ResourceLocation;
import tv.mapper.roadstuff.RoadStuff;

public class RSTags
{
    public static class Blocks
    {
        public static final Tag<Block> CONCRETE_ROAD = tag("concrete_road");
        public static final Tag<Block> ASPHALT_ROAD = tag("asphalt_road");

        private static Tag<Block> tag(String name)
        {
            return new BlockTags.Wrapper(new ResourceLocation(RoadStuff.MODID, name));
        }
    }

    public static class Items
    {
        public static final Tag<Item> CONCRETE_ROAD = tag("concrete_road");
        public static final Tag<Item> ASPHALT_ROAD = tag("asphalt_road");

        private static Tag<Item> tag(String name)
        {
            return new ItemTags.Wrapper(new ResourceLocation(RoadStuff.MODID, name));
        }
    }

    public static class ForgeBlocks
    {

        @SuppressWarnings("unused")
        private static Tag<Block> tag(String name)
        {
            return new BlockTags.Wrapper(new ResourceLocation("forge", name));
        }
    }

    public static class ForgeItems
    {

        @SuppressWarnings("unused")
        private static Tag<Item> tag(String name)
        {
            return new ItemTags.Wrapper(new ResourceLocation("forge", name));
        }
    }
}