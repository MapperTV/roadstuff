package tv.mapper.roadstuff.init;

import java.util.LinkedHashSet;
import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.ObjectHolder;
import tv.mapper.roadstuff.RoadStuff;
import tv.mapper.roadstuff.block.PaintBucketBlock;
import tv.mapper.roadstuff.block.PaintableBlock;
import tv.mapper.roadstuff.block.RotatablePaintBlock;
import tv.mapper.roadstuff.item.ItemBlockPaintBucket;
import tv.mapper.roadstuff.item.ModItemGroups;
import tv.mapper.roadstuff.util.ModConstants;

@EventBusSubscriber(bus = Bus.MOD)
public class ModBlocks
{
    public static Set<Block> MOD_BLOCKS = new LinkedHashSet<>();
    public static Set<Item> MOD_ITEMS = new LinkedHashSet<>();
    
    @ObjectHolder(RoadStuff.MODID + ":asphalt_block")
    public static Block ASPHALT_BLOCK;
    @ObjectHolder(RoadStuff.MODID + ":concrete_block")
    public static Block CONCRETE_BLOCK;
    
    @ObjectHolder(RoadStuff.MODID + ":paint_bucket_block")
    public static Block PAINT_BUCKET_BLOCK;

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event)
    {
        IForgeRegistry<Block> registry = event.getRegistry();
        
        event.getRegistry().register(new PaintableBlock(Block.Properties.create(Material.IRON).hardnessAndResistance(1.0F, 6.0F), 0).setRegistryName("asphalt_block"));
        event.getRegistry().register(new PaintableBlock(Block.Properties.create(Material.IRON).hardnessAndResistance(1.0F, 6.0F), 1).setRegistryName("concrete_block"));
        
        for(int i = 1; i < ModConstants.PATTERNS; i++)
        {
            registerBlock(new RotatablePaintBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.0F, 6.0F), 0), "asphalt_white_line_" + i + "_block", registry);
            registerBlock(new RotatablePaintBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.0F, 6.0F), 0), "asphalt_yellow_line_" + i + "_block", registry);
            registerBlock(new RotatablePaintBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.0F, 6.0F), 1), "concrete_white_line_" + i + "_block", registry);
            registerBlock(new RotatablePaintBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.0F, 6.0F), 1), "concrete_yellow_line_" + i + "_block", registry);
        }

        event.getRegistry().register(new PaintBucketBlock(Block.Properties.create(Material.IRON).hardnessAndResistance(0.5F)).setRegistryName("paint_bucket_block"));

    }

    private static void registerBlock(Block block, String name, IForgeRegistry<Block> registry)
    {
        block.setRegistryName(name);
        MOD_BLOCKS.add(block);
        registry.register(block);
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event)
    {
        IForgeRegistry<Item> registry = event.getRegistry();
        
        event.getRegistry().register(new BlockItem(ASPHALT_BLOCK, new Item.Properties().group(ModItemGroups.ROADSTUFF)).setRegistryName(ASPHALT_BLOCK.getRegistryName()));
        event.getRegistry().register(new BlockItem(CONCRETE_BLOCK, new Item.Properties().group(ModItemGroups.ROADSTUFF)).setRegistryName(CONCRETE_BLOCK.getRegistryName()));
        
        for(Block block : MOD_BLOCKS)
        {
            registerItem(new BlockItem(block, new Item.Properties().group(ModItemGroups.ROADSTUFF)), block.getRegistryName().toString(), registry);
        }

        event.getRegistry().register(new ItemBlockPaintBucket(PAINT_BUCKET_BLOCK, new Item.Properties().group(ModItemGroups.ROADSTUFF).maxStackSize(1)).setRegistryName(PAINT_BUCKET_BLOCK.getRegistryName()));

    }
    
    private static void registerItem(Item item, String name, IForgeRegistry<Item> registry)
    {
        item.setRegistryName(name);
        MOD_ITEMS.add(item);
        registry.register(item);
    }
    
    
}
