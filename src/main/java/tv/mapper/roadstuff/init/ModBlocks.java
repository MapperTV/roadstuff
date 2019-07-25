package tv.mapper.roadstuff.init;

import java.util.LinkedHashSet;
import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.ObjectHolder;
import tv.mapper.roadstuff.RoadStuff;
import tv.mapper.roadstuff.block.ConeBlock;
import tv.mapper.roadstuff.block.ConeBlock.EnumConeType;
import tv.mapper.roadstuff.block.PaintBucketBlock;
import tv.mapper.roadstuff.block.PaintableBlock;
import tv.mapper.roadstuff.block.RotatablePaintBlock;
import tv.mapper.roadstuff.item.BlockItemPaintBucket;
import tv.mapper.roadstuff.item.ModItemGroups;
import tv.mapper.roadstuff.util.ModConstants;

@EventBusSubscriber(bus = Bus.MOD)
public class ModBlocks
{
    public static Set<PaintableBlock> MOD_PAINTABLEBLOCKS = new LinkedHashSet<>();
    public static Set<Item> MOD_ITEMS = new LinkedHashSet<>();

    @ObjectHolder(RoadStuff.MODID + ":bitumen_block")
    public static Block BITUMEN_BLOCK;
    @ObjectHolder(RoadStuff.MODID + ":bitumen_ore")
    public static Block BITUMEN_ORE;

    @ObjectHolder(RoadStuff.MODID + ":asphalt")
    public static PaintableBlock ASPHALT;
    @ObjectHolder(RoadStuff.MODID + ":concrete")
    public static PaintableBlock CONCRETE;

    @ObjectHolder(RoadStuff.MODID + ":paint_bucket")
    public static Block PAINT_BUCKET;

    @ObjectHolder(RoadStuff.MODID + ":traffic_cone")
    public static Block TRAFFIC_CONE;
    @ObjectHolder(RoadStuff.MODID + ":traffic_barrel")
    public static Block TRAFFIC_BARREL;
    @ObjectHolder(RoadStuff.MODID + ":traffic_bollard")
    public static Block TRAFFIC_BOLLARD;

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event)
    {
        IForgeRegistry<Block> registry = event.getRegistry();

        event.getRegistry().register(new PaintableBlock(Block.Properties.create(Material.IRON).hardnessAndResistance(1.0F, 6.0F), 0).setRegistryName("asphalt"));
        event.getRegistry().register(new PaintableBlock(Block.Properties.create(Material.IRON).hardnessAndResistance(1.0F, 6.0F), 1).setRegistryName("concrete"));

        for(int i = 1; i < ModConstants.PATTERNS; i++)
        {
            registerBlock(new RotatablePaintBlock(Block.Properties.create(Material.ROCK, MaterialColor.BLACK).hardnessAndResistance(1.0F, 6.0F), 0), "asphalt_white_line_" + i, registry);
            registerBlock(new RotatablePaintBlock(Block.Properties.create(Material.ROCK, MaterialColor.BLACK).hardnessAndResistance(1.0F, 6.0F), 0), "asphalt_yellow_line_" + i, registry);
            registerBlock(new RotatablePaintBlock(Block.Properties.create(Material.ROCK, MaterialColor.GRAY).hardnessAndResistance(1.0F, 6.0F), 1), "concrete_white_line_" + i, registry);
            registerBlock(new RotatablePaintBlock(Block.Properties.create(Material.ROCK, MaterialColor.GRAY).hardnessAndResistance(1.0F, 6.0F), 1), "concrete_yellow_line_" + i, registry);
        }

        event.getRegistry().register(new PaintBucketBlock(Block.Properties.create(Material.IRON).hardnessAndResistance(0.5F, 3.0F)).setRegistryName("paint_bucket"));

        event.getRegistry().register(new ConeBlock(Block.Properties.create(Material.IRON, MaterialColor.ORANGE_TERRACOTTA).hardnessAndResistance(0.5F, 3.0F), EnumConeType.CONE).setRegistryName("traffic_cone"));
        event.getRegistry().register(new ConeBlock(Block.Properties.create(Material.IRON, MaterialColor.ORANGE_TERRACOTTA).hardnessAndResistance(0.5F, 3.0F), EnumConeType.BARREL).setRegistryName("traffic_barrel"));
        event.getRegistry().register(new ConeBlock(Block.Properties.create(Material.IRON, MaterialColor.ORANGE_TERRACOTTA).hardnessAndResistance(0.5F, 3.0F), EnumConeType.BOLLARD).setRegistryName("traffic_bollard"));

        event.getRegistry().register(new Block(Block.Properties.create(Material.ROCK, MaterialColor.BLACK).hardnessAndResistance(3.0F, 3.0F)).setRegistryName("bitumen_block"));
        event.getRegistry().register(new Block(Block.Properties.create(Material.ROCK, MaterialColor.BLACK).hardnessAndResistance(3.0F, 3.0F)).setRegistryName("bitumen_ore"));

    }

    private static void registerBlock(PaintableBlock block, String name, IForgeRegistry<Block> registry)
    {
        block.setRegistryName(name);
        MOD_PAINTABLEBLOCKS.add(block);
        registry.register(block);
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event)
    {
        IForgeRegistry<Item> registry = event.getRegistry();

        event.getRegistry().register(new BlockItem(ASPHALT, new Item.Properties().group(ModItemGroups.ROADSTUFF)).setRegistryName(ASPHALT.getRegistryName()));
        event.getRegistry().register(new BlockItem(CONCRETE, new Item.Properties().group(ModItemGroups.ROADSTUFF)).setRegistryName(CONCRETE.getRegistryName()));

        for(Block block : MOD_PAINTABLEBLOCKS)
        {
            registerItem(new BlockItem(block, new Item.Properties().group(ModItemGroups.ROADSTUFF)), block.getRegistryName().toString(), registry);
        }

        event.getRegistry().register(new BlockItemPaintBucket(PAINT_BUCKET, new Item.Properties().group(ModItemGroups.ROADSTUFF).maxStackSize(1)).setRegistryName(PAINT_BUCKET.getRegistryName()));

        event.getRegistry().register(new BlockItem(TRAFFIC_CONE, new Item.Properties().group(ModItemGroups.ROADSTUFF)).setRegistryName(TRAFFIC_CONE.getRegistryName()));
        event.getRegistry().register(new BlockItem(TRAFFIC_BARREL, new Item.Properties().group(ModItemGroups.ROADSTUFF)).setRegistryName(TRAFFIC_BARREL.getRegistryName()));
        event.getRegistry().register(new BlockItem(TRAFFIC_BOLLARD, new Item.Properties().group(ModItemGroups.ROADSTUFF)).setRegistryName(TRAFFIC_BOLLARD.getRegistryName()));

        event.getRegistry().register(new BlockItem(BITUMEN_BLOCK, new Item.Properties().group(ModItemGroups.ROADSTUFF)).setRegistryName(BITUMEN_BLOCK.getRegistryName()));
        event.getRegistry().register(new BlockItem(BITUMEN_ORE, new Item.Properties().group(ModItemGroups.ROADSTUFF)).setRegistryName(BITUMEN_ORE.getRegistryName()));
    }

    private static void registerItem(Item item, String name, IForgeRegistry<Item> registry)
    {
        item.setRegistryName(name);
        MOD_ITEMS.add(item);
        registry.register(item);
    }

}
