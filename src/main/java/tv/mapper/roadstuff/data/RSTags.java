package tv.mapper.roadstuff.data;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.Tag;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import tv.mapper.roadstuff.RoadStuff;

public class RSTags
{
    public static class Blocks
    {
        public static final Tag.Named<Block> CONCRETE_ROAD = tag("concrete_road");
        public static final Tag.Named<Block> ASPHALT_ROAD = tag("asphalt_road");
        public static final Tag.Named<Block> REFLECTORS = tag("reflectors");
        public static final Tag.Named<Block> CONCRETE = tag("concrete");
        public static final Tag.Named<Block> ASPHALT = tag("asphalt");

        private static Tag.Named<Block> tag(String name)
        {
            return BlockTags.bind(new ResourceLocation(RoadStuff.MODID, name).toString());
        }
    }

    public static class Items
    {
        public static final Tag.Named<Item> CONCRETE_ROAD = tag("concrete_road");
        public static final Tag.Named<Item> ASPHALT_ROAD = tag("asphalt_road");
        public static final Tag.Named<Item> REFLECTORS = tag("reflectors");
        public static final Tag.Named<Item> CONCRETE = tag("concrete");
        public static final Tag.Named<Item> ASPHALT = tag("asphalt");

        private static Tag.Named<Item> tag(String name)
        {
            return ItemTags.bind(new ResourceLocation(RoadStuff.MODID, name).toString());
        }
    }

    public static class ForgeBlocks
    {
        public static final Tag.Named<Block> STORAGE_BLOCKS_BITUMEN = tag("storage_blocks/bitumen");
        public static final Tag.Named<Block> ORES_BITUMEN = tag("ores/bitumen");

        private static Tag.Named<Block> tag(String name)
        {
            return BlockTags.bind(new ResourceLocation("forge", name).toString());
        }
    }

    public static class ForgeItems
    {
        public static final Tag.Named<Item> STORAGE_BLOCKS_BITUMEN = tag("storage_blocks/bitumen");
        public static final Tag.Named<Item> ORES_BITUMEN = tag("ores/bitumen");

        public static final Tag.Named<Item> BITUMEN = tag("bitumen");

        private static Tag.Named<Item> tag(String name)
        {
            return ItemTags.bind(new ResourceLocation("forge", name).toString());
        }
    }
}