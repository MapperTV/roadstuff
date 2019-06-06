package tv.mapper.roadstuff.init;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;
import tv.mapper.roadstuff.RoadStuff;
import tv.mapper.roadstuff.block.BlockFourAxis;
import tv.mapper.roadstuff.block.BlockPaintBucket;
import tv.mapper.roadstuff.block.BlockPaintable;
import tv.mapper.roadstuff.block.BlockTwoAxis;
import tv.mapper.roadstuff.item.ItemBlockPaintBucket;
import tv.mapper.roadstuff.item.ModItemGroups;

@EventBusSubscriber(bus = Bus.MOD)
public class ModBlocks
{
    @ObjectHolder(RoadStuff.MODID + ":asphalt_block")
    public static Block ASPHALT_BLOCK;

    @ObjectHolder(RoadStuff.MODID + ":asphalt_simple_white_line")
    public static Block ASPHALT_SIMPLE_WHITE_LINE_BLOCK;
    @ObjectHolder(RoadStuff.MODID + ":asphalt_double_white_line")
    public static Block ASPHALT_DOUBLE_WHITE_LINE_BLOCK;
    @ObjectHolder(RoadStuff.MODID + ":asphalt_dashed_white_line")
    public static Block ASPHALT_DASHED_WHITE_LINE_BLOCK;
    @ObjectHolder(RoadStuff.MODID + ":asphalt_large_white_line")
    public static Block ASPHALT_LARGE_WHITE_LINE_BLOCK;
    @ObjectHolder(RoadStuff.MODID + ":asphalt_x_white_line")
    public static Block ASPHALT_X_WHITE_LINE_BLOCK;
    @ObjectHolder(RoadStuff.MODID + ":asphalt_t_white_line")
    public static Block ASPHALT_T_WHITE_LINE_BLOCK;
    @ObjectHolder(RoadStuff.MODID + ":asphalt_corner_white_line")
    public static Block ASPHALT_CORNER_WHITE_LINE_BLOCK;
    @ObjectHolder(RoadStuff.MODID + ":asphalt_end_double_white_line")
    public static Block ASPHALT_END_DOUBLE_WHITE_LINE_BLOCK;
    @ObjectHolder(RoadStuff.MODID + ":asphalt_diagonal_white_line")
    public static Block ASPHALT_DIAGONAL_WHITE_LINE_BLOCK;
    @ObjectHolder(RoadStuff.MODID + ":asphalt_large_diagonal_white_line")
    public static Block ASPHALT_LARGE_DIAGONAL_WHITE_LINE_BLOCK;

    @ObjectHolder(RoadStuff.MODID + ":paint_bucket_block")
    public static Block PAINT_BUCKET_BLOCK;

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event)
    {
        event.getRegistry().register(new BlockPaintable(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5F, 6.0F), 0).setRegistryName("asphalt_block"));
        event.getRegistry().register(new BlockTwoAxis(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5F, 6.0F), 0).setRegistryName("asphalt_simple_white_line"));
        event.getRegistry().register(new BlockTwoAxis(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5F, 6.0F), 0).setRegistryName("asphalt_double_white_line"));
        event.getRegistry().register(new BlockTwoAxis(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5F, 6.0F), 0).setRegistryName("asphalt_dashed_white_line"));
        event.getRegistry().register(new BlockTwoAxis(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5F, 6.0F), 0).setRegistryName("asphalt_large_white_line"));
        event.getRegistry().register(new BlockPaintable(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5F, 6.0F), 0).setRegistryName("asphalt_x_white_line"));
        event.getRegistry().register(new BlockFourAxis(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5F, 6.0F), 0).setRegistryName("asphalt_t_white_line"));
        event.getRegistry().register(new BlockFourAxis(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5F, 6.0F), 0).setRegistryName("asphalt_corner_white_line"));
        event.getRegistry().register(new BlockFourAxis(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5F, 6.0F), 0).setRegistryName("asphalt_end_double_white_line"));
        event.getRegistry().register(new BlockFourAxis(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5F, 6.0F), 0).setRegistryName("asphalt_diagonal_white_line"));
        event.getRegistry().register(new BlockFourAxis(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5F, 6.0F), 0).setRegistryName("asphalt_large_diagonal_white_line"));

        event.getRegistry().register(new BlockPaintBucket(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5F, 6.0F)).setRegistryName("paint_bucket_block"));
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event)
    {
        event.getRegistry().register(new ItemBlock(ASPHALT_BLOCK, new Item.Properties().group(ModItemGroups.ROADSTUFF)).setRegistryName(ASPHALT_BLOCK.getRegistryName()));
        event.getRegistry().register(new ItemBlock(ASPHALT_SIMPLE_WHITE_LINE_BLOCK, new Item.Properties().group(ModItemGroups.ROADSTUFF)).setRegistryName(ASPHALT_SIMPLE_WHITE_LINE_BLOCK.getRegistryName()));
        event.getRegistry().register(new ItemBlock(ASPHALT_DOUBLE_WHITE_LINE_BLOCK, new Item.Properties().group(ModItemGroups.ROADSTUFF)).setRegistryName(ASPHALT_DOUBLE_WHITE_LINE_BLOCK.getRegistryName()));
        event.getRegistry().register(new ItemBlock(ASPHALT_DASHED_WHITE_LINE_BLOCK, new Item.Properties().group(ModItemGroups.ROADSTUFF)).setRegistryName(ASPHALT_DASHED_WHITE_LINE_BLOCK.getRegistryName()));
        event.getRegistry().register(new ItemBlock(ASPHALT_LARGE_WHITE_LINE_BLOCK, new Item.Properties().group(ModItemGroups.ROADSTUFF)).setRegistryName(ASPHALT_LARGE_WHITE_LINE_BLOCK.getRegistryName()));
        event.getRegistry().register(new ItemBlock(ASPHALT_X_WHITE_LINE_BLOCK, new Item.Properties().group(ModItemGroups.ROADSTUFF)).setRegistryName(ASPHALT_X_WHITE_LINE_BLOCK.getRegistryName()));
        event.getRegistry().register(new ItemBlock(ASPHALT_T_WHITE_LINE_BLOCK, new Item.Properties().group(ModItemGroups.ROADSTUFF)).setRegistryName(ASPHALT_T_WHITE_LINE_BLOCK.getRegistryName()));
        event.getRegistry().register(new ItemBlock(ASPHALT_CORNER_WHITE_LINE_BLOCK, new Item.Properties().group(ModItemGroups.ROADSTUFF)).setRegistryName(ASPHALT_CORNER_WHITE_LINE_BLOCK.getRegistryName()));
        event.getRegistry().register(new ItemBlock(ASPHALT_END_DOUBLE_WHITE_LINE_BLOCK, new Item.Properties().group(ModItemGroups.ROADSTUFF)).setRegistryName(ASPHALT_END_DOUBLE_WHITE_LINE_BLOCK.getRegistryName()));
        event.getRegistry().register(new ItemBlock(ASPHALT_DIAGONAL_WHITE_LINE_BLOCK, new Item.Properties().group(ModItemGroups.ROADSTUFF)).setRegistryName(ASPHALT_DIAGONAL_WHITE_LINE_BLOCK.getRegistryName()));
        event.getRegistry().register(new ItemBlock(ASPHALT_LARGE_DIAGONAL_WHITE_LINE_BLOCK, new Item.Properties().group(ModItemGroups.ROADSTUFF)).setRegistryName(ASPHALT_LARGE_DIAGONAL_WHITE_LINE_BLOCK.getRegistryName()));
        event.getRegistry().register(new ItemBlockPaintBucket(PAINT_BUCKET_BLOCK, new Item.Properties().group(ModItemGroups.ROADSTUFF).maxStackSize(1)).setRegistryName(PAINT_BUCKET_BLOCK.getRegistryName()));

    }
}
