package tv.mapper.roadstuff.init;

import java.util.LinkedHashSet;
import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.Rarity;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.ObjectHolder;
import tv.mapper.roadstuff.RoadStuff;
import tv.mapper.roadstuff.block.BollardBlock;
import tv.mapper.roadstuff.block.ConeBlock;
import tv.mapper.roadstuff.block.ConeBlock.EnumConeType;
import tv.mapper.roadstuff.block.CustomBlock;
import tv.mapper.roadstuff.block.CylindricalBollardBlock;
import tv.mapper.roadstuff.block.GuardrailBlock;
import tv.mapper.roadstuff.block.PaintBucketBlock;
import tv.mapper.roadstuff.block.PaintableBlock;
import tv.mapper.roadstuff.block.ReflectorBlock;
import tv.mapper.roadstuff.block.RotatablePaintBlock;
import tv.mapper.roadstuff.block.RotatableSlopeBlock;
import tv.mapper.roadstuff.block.SlopeBlock;
import tv.mapper.roadstuff.item.BlockItemPaintBucket;
import tv.mapper.roadstuff.item.ModItemGroups;
import tv.mapper.roadstuff.item.ReflectorBlockItem;
import tv.mapper.roadstuff.util.ModConstants;

@ObjectHolder(RoadStuff.MODID)
@EventBusSubscriber(bus = Bus.MOD)
public class ModBlocks
{
    public static Set<PaintableBlock> MOD_PAINTABLEBLOCKS = new LinkedHashSet<>();

    public static final Block BITUMEN_BLOCK = null;
    public static final Block BITUMEN_ORE = null;

    public static final PaintableBlock ASPHALT = null;
    public static final PaintableBlock CONCRETE = null;

    public static final SlopeBlock ASPHALT_SLOPE = null;
    public static final SlopeBlock CONCRETE_SLOPE = null;

    public static final Block WHITE_REFLECTOR = null;
    public static final Block YELLOW_REFLECTOR = null;
    public static final Block LUMINESCENT_WHITE_REFLECTOR = null;
    public static final Block LUMINESCENT_YELLOW_REFLECTOR = null;

    public static final Block PAINT_BUCKET = null;

    public static final Block WHITE_TRAFFIC_CONE = null;
    public static final Block WHITE_TRAFFIC_BARREL = null;
    public static final Block WHITE_TRAFFIC_BOLLARD = null;

    public static final Block ORANGE_TRAFFIC_CONE = null;
    public static final Block ORANGE_TRAFFIC_BARREL = null;
    public static final Block ORANGE_TRAFFIC_BOLLARD = null;

    public static final Block MAGENTA_TRAFFIC_CONE = null;
    public static final Block MAGENTA_TRAFFIC_BARREL = null;
    public static final Block MAGENTA_TRAFFIC_BOLLARD = null;

    public static final Block LIGHT_BLUE_TRAFFIC_CONE = null;
    public static final Block LIGHT_BLUE_TRAFFIC_BARREL = null;
    public static final Block LIGHT_BLUE_TRAFFIC_BOLLARD = null;

    public static final Block YELLOW_TRAFFIC_CONE = null;
    public static final Block YELLOW_TRAFFIC_BARREL = null;
    public static final Block YELLOW_TRAFFIC_BOLLARD = null;

    public static final Block LIME_TRAFFIC_CONE = null;
    public static final Block LIME_TRAFFIC_BARREL = null;
    public static final Block LIME_TRAFFIC_BOLLARD = null;

    public static final Block PINK_TRAFFIC_CONE = null;
    public static final Block PINK_TRAFFIC_BARREL = null;
    public static final Block PINK_TRAFFIC_BOLLARD = null;

    public static final Block GRAY_TRAFFIC_CONE = null;
    public static final Block GRAY_TRAFFIC_BARREL = null;
    public static final Block GRAY_TRAFFIC_BOLLARD = null;

    public static final Block LIGHT_GRAY_TRAFFIC_CONE = null;
    public static final Block LIGHT_GRAY_TRAFFIC_BARREL = null;
    public static final Block LIGHT_GRAY_TRAFFIC_BOLLARD = null;

    public static final Block CYAN_TRAFFIC_CONE = null;
    public static final Block CYAN_TRAFFIC_BARREL = null;
    public static final Block CYAN_TRAFFIC_BOLLARD = null;

    public static final Block PURPLE_TRAFFIC_CONE = null;
    public static final Block PURPLE_TRAFFIC_BARREL = null;
    public static final Block PURPLE_TRAFFIC_BOLLARD = null;

    public static final Block BLUE_TRAFFIC_CONE = null;
    public static final Block BLUE_TRAFFIC_BARREL = null;
    public static final Block BLUE_TRAFFIC_BOLLARD = null;

    public static final Block BROWN_TRAFFIC_CONE = null;
    public static final Block BROWN_TRAFFIC_BARREL = null;
    public static final Block BROWN_TRAFFIC_BOLLARD = null;

    public static final Block GREEN_TRAFFIC_CONE = null;
    public static final Block GREEN_TRAFFIC_BARREL = null;
    public static final Block GREEN_TRAFFIC_BOLLARD = null;

    public static final Block RED_TRAFFIC_CONE = null;
    public static final Block RED_TRAFFIC_BARREL = null;
    public static final Block RED_TRAFFIC_BOLLARD = null;

    public static final Block BLACK_TRAFFIC_CONE = null;
    public static final Block BLACK_TRAFFIC_BARREL = null;
    public static final Block BLACK_TRAFFIC_BOLLARD = null;

    public static final Block STEEL_GUARDRAIL = null;
    public static final Block BLACK_GUARDRAIL = null;
    public static final Block WHITE_GUARDRAIL = null;
    public static final Block YELLOW_GUARDRAIL = null;

    public static final Block WHITE_BOLLARD = null;
    public static final Block YELLOW_BOLLARD = null;
    public static final Block GREEN_CYLINDRICAL_BOLLARD = null;
    public static final Block BLACK_CYLINDRICAL_BOLLARD = null;

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event)
    {
        IForgeRegistry<Block> registry = event.getRegistry();

        event.getRegistry().register(new PaintableBlock(Block.Properties.create(Material.ROCK, MaterialColor.BLACK).hardnessAndResistance(1.0F, 6.0F), 0).setRegistryName("asphalt"));
        event.getRegistry().register(new PaintableBlock(Block.Properties.create(Material.ROCK, MaterialColor.GRAY).hardnessAndResistance(1.0F, 6.0F), 1).setRegistryName("concrete"));

        event.getRegistry().register(new SlopeBlock(Block.Properties.create(Material.ROCK, MaterialColor.BLACK).hardnessAndResistance(1.0F, 6.0F), 0).setRegistryName("asphalt_slope"));
        event.getRegistry().register(new SlopeBlock(Block.Properties.create(Material.ROCK, MaterialColor.GRAY).hardnessAndResistance(1.0F, 6.0F), 1).setRegistryName("concrete_slope"));

        event.getRegistry().register(new PaintBucketBlock(Block.Properties.create(Material.IRON, MaterialColor.GRAY).hardnessAndResistance(0.5F, 3.0F)).setRegistryName("paint_bucket"));

        event.getRegistry().register(new ReflectorBlock(Block.Properties.create(Material.MISCELLANEOUS, MaterialColor.QUARTZ).hardnessAndResistance(0.1F, 3.0F), false).setRegistryName("white_reflector"));
        event.getRegistry().register(new ReflectorBlock(Block.Properties.create(Material.MISCELLANEOUS, MaterialColor.YELLOW).hardnessAndResistance(0.1F, 3.0F), false).setRegistryName("yellow_reflector"));
        event.getRegistry().register(new ReflectorBlock(Block.Properties.create(Material.MISCELLANEOUS, MaterialColor.QUARTZ).hardnessAndResistance(0.1F, 3.0F).lightValue(14), true).setRegistryName("luminescent_white_reflector"));
        event.getRegistry().register(new ReflectorBlock(Block.Properties.create(Material.MISCELLANEOUS, MaterialColor.YELLOW).hardnessAndResistance(0.1F, 3.0F).lightValue(14), true).setRegistryName("luminescent_yellow_reflector"));

        event.getRegistry().register(new ConeBlock(Block.Properties.create(Material.MISCELLANEOUS, MaterialColor.WHITE_TERRACOTTA).hardnessAndResistance(0.1F, 3.0F), EnumConeType.CONE).setRegistryName("white_traffic_cone"));
        event.getRegistry().register(new ConeBlock(Block.Properties.create(Material.MISCELLANEOUS, MaterialColor.WHITE_TERRACOTTA).hardnessAndResistance(0.1F, 3.0F), EnumConeType.BARREL).setRegistryName("white_traffic_barrel"));
        event.getRegistry().register(new ConeBlock(Block.Properties.create(Material.MISCELLANEOUS, MaterialColor.WHITE_TERRACOTTA).hardnessAndResistance(0.1F, 3.0F), EnumConeType.BOLLARD).setRegistryName("white_traffic_bollard"));

        event.getRegistry().register(new ConeBlock(Block.Properties.create(Material.MISCELLANEOUS, MaterialColor.ORANGE_TERRACOTTA).hardnessAndResistance(0.1F, 3.0F), EnumConeType.CONE).setRegistryName("orange_traffic_cone"));
        event.getRegistry().register(new ConeBlock(Block.Properties.create(Material.MISCELLANEOUS, MaterialColor.ORANGE_TERRACOTTA).hardnessAndResistance(0.1F, 3.0F), EnumConeType.BARREL).setRegistryName("orange_traffic_barrel"));
        event.getRegistry().register(new ConeBlock(Block.Properties.create(Material.MISCELLANEOUS, MaterialColor.ORANGE_TERRACOTTA).hardnessAndResistance(0.1F, 3.0F), EnumConeType.BOLLARD).setRegistryName("orange_traffic_bollard"));

        event.getRegistry().register(new ConeBlock(Block.Properties.create(Material.MISCELLANEOUS, MaterialColor.MAGENTA_TERRACOTTA).hardnessAndResistance(0.1F, 3.0F), EnumConeType.CONE).setRegistryName("magenta_traffic_cone"));
        event.getRegistry().register(new ConeBlock(Block.Properties.create(Material.MISCELLANEOUS, MaterialColor.MAGENTA_TERRACOTTA).hardnessAndResistance(0.1F, 3.0F), EnumConeType.BARREL).setRegistryName("magenta_traffic_barrel"));
        event.getRegistry().register(new ConeBlock(Block.Properties.create(Material.MISCELLANEOUS, MaterialColor.MAGENTA_TERRACOTTA).hardnessAndResistance(0.1F, 3.0F), EnumConeType.BOLLARD).setRegistryName("magenta_traffic_bollard"));

        event.getRegistry().register(new ConeBlock(Block.Properties.create(Material.MISCELLANEOUS, MaterialColor.LIGHT_BLUE_TERRACOTTA).hardnessAndResistance(0.1F, 3.0F), EnumConeType.CONE).setRegistryName("light_blue_traffic_cone"));
        event.getRegistry().register(new ConeBlock(Block.Properties.create(Material.MISCELLANEOUS, MaterialColor.LIGHT_BLUE_TERRACOTTA).hardnessAndResistance(0.1F, 3.0F), EnumConeType.BARREL).setRegistryName("light_blue_traffic_barrel"));
        event.getRegistry().register(new ConeBlock(Block.Properties.create(Material.MISCELLANEOUS, MaterialColor.LIGHT_BLUE_TERRACOTTA).hardnessAndResistance(0.1F, 3.0F), EnumConeType.BOLLARD).setRegistryName("light_blue_traffic_bollard"));

        event.getRegistry().register(new ConeBlock(Block.Properties.create(Material.MISCELLANEOUS, MaterialColor.YELLOW_TERRACOTTA).hardnessAndResistance(0.1F, 3.0F), EnumConeType.CONE).setRegistryName("yellow_traffic_cone"));
        event.getRegistry().register(new ConeBlock(Block.Properties.create(Material.MISCELLANEOUS, MaterialColor.YELLOW_TERRACOTTA).hardnessAndResistance(0.1F, 3.0F), EnumConeType.BARREL).setRegistryName("yellow_traffic_barrel"));
        event.getRegistry().register(new ConeBlock(Block.Properties.create(Material.MISCELLANEOUS, MaterialColor.YELLOW_TERRACOTTA).hardnessAndResistance(0.1F, 3.0F), EnumConeType.BOLLARD).setRegistryName("yellow_traffic_bollard"));

        event.getRegistry().register(new ConeBlock(Block.Properties.create(Material.MISCELLANEOUS, MaterialColor.LIME_TERRACOTTA).hardnessAndResistance(0.1F, 3.0F), EnumConeType.CONE).setRegistryName("lime_traffic_cone"));
        event.getRegistry().register(new ConeBlock(Block.Properties.create(Material.MISCELLANEOUS, MaterialColor.LIME_TERRACOTTA).hardnessAndResistance(0.1F, 3.0F), EnumConeType.BARREL).setRegistryName("lime_traffic_barrel"));
        event.getRegistry().register(new ConeBlock(Block.Properties.create(Material.MISCELLANEOUS, MaterialColor.LIME_TERRACOTTA).hardnessAndResistance(0.1F, 3.0F), EnumConeType.BOLLARD).setRegistryName("lime_traffic_bollard"));

        event.getRegistry().register(new ConeBlock(Block.Properties.create(Material.MISCELLANEOUS, MaterialColor.PINK_TERRACOTTA).hardnessAndResistance(0.1F, 3.0F), EnumConeType.CONE).setRegistryName("pink_traffic_cone"));
        event.getRegistry().register(new ConeBlock(Block.Properties.create(Material.MISCELLANEOUS, MaterialColor.PINK_TERRACOTTA).hardnessAndResistance(0.1F, 3.0F), EnumConeType.BARREL).setRegistryName("pink_traffic_barrel"));
        event.getRegistry().register(new ConeBlock(Block.Properties.create(Material.MISCELLANEOUS, MaterialColor.PINK_TERRACOTTA).hardnessAndResistance(0.1F, 3.0F), EnumConeType.BOLLARD).setRegistryName("pink_traffic_bollard"));

        event.getRegistry().register(new ConeBlock(Block.Properties.create(Material.MISCELLANEOUS, MaterialColor.GRAY_TERRACOTTA).hardnessAndResistance(0.1F, 3.0F), EnumConeType.CONE).setRegistryName("gray_traffic_cone"));
        event.getRegistry().register(new ConeBlock(Block.Properties.create(Material.MISCELLANEOUS, MaterialColor.GRAY_TERRACOTTA).hardnessAndResistance(0.1F, 3.0F), EnumConeType.BARREL).setRegistryName("gray_traffic_barrel"));
        event.getRegistry().register(new ConeBlock(Block.Properties.create(Material.MISCELLANEOUS, MaterialColor.GRAY_TERRACOTTA).hardnessAndResistance(0.1F, 3.0F), EnumConeType.BOLLARD).setRegistryName("gray_traffic_bollard"));

        event.getRegistry().register(new ConeBlock(Block.Properties.create(Material.MISCELLANEOUS, MaterialColor.LIGHT_GRAY_TERRACOTTA).hardnessAndResistance(0.1F, 3.0F), EnumConeType.CONE).setRegistryName("light_gray_traffic_cone"));
        event.getRegistry().register(new ConeBlock(Block.Properties.create(Material.MISCELLANEOUS, MaterialColor.LIGHT_GRAY_TERRACOTTA).hardnessAndResistance(0.1F, 3.0F), EnumConeType.BARREL).setRegistryName("light_gray_traffic_barrel"));
        event.getRegistry().register(new ConeBlock(Block.Properties.create(Material.MISCELLANEOUS, MaterialColor.LIGHT_GRAY_TERRACOTTA).hardnessAndResistance(0.1F, 3.0F), EnumConeType.BOLLARD).setRegistryName("light_gray_traffic_bollard"));

        event.getRegistry().register(new ConeBlock(Block.Properties.create(Material.MISCELLANEOUS, MaterialColor.CYAN_TERRACOTTA).hardnessAndResistance(0.1F, 3.0F), EnumConeType.CONE).setRegistryName("cyan_traffic_cone"));
        event.getRegistry().register(new ConeBlock(Block.Properties.create(Material.MISCELLANEOUS, MaterialColor.CYAN_TERRACOTTA).hardnessAndResistance(0.1F, 3.0F), EnumConeType.BARREL).setRegistryName("cyan_traffic_barrel"));
        event.getRegistry().register(new ConeBlock(Block.Properties.create(Material.MISCELLANEOUS, MaterialColor.CYAN_TERRACOTTA).hardnessAndResistance(0.1F, 3.0F), EnumConeType.BOLLARD).setRegistryName("cyan_traffic_bollard"));

        event.getRegistry().register(new ConeBlock(Block.Properties.create(Material.MISCELLANEOUS, MaterialColor.PURPLE_TERRACOTTA).hardnessAndResistance(0.1F, 3.0F), EnumConeType.CONE).setRegistryName("purple_traffic_cone"));
        event.getRegistry().register(new ConeBlock(Block.Properties.create(Material.MISCELLANEOUS, MaterialColor.PURPLE_TERRACOTTA).hardnessAndResistance(0.1F, 3.0F), EnumConeType.BARREL).setRegistryName("purple_traffic_barrel"));
        event.getRegistry().register(new ConeBlock(Block.Properties.create(Material.MISCELLANEOUS, MaterialColor.PURPLE_TERRACOTTA).hardnessAndResistance(0.1F, 3.0F), EnumConeType.BOLLARD).setRegistryName("purple_traffic_bollard"));

        event.getRegistry().register(new ConeBlock(Block.Properties.create(Material.MISCELLANEOUS, MaterialColor.BLUE_TERRACOTTA).hardnessAndResistance(0.1F, 3.0F), EnumConeType.CONE).setRegistryName("blue_traffic_cone"));
        event.getRegistry().register(new ConeBlock(Block.Properties.create(Material.MISCELLANEOUS, MaterialColor.BLUE_TERRACOTTA).hardnessAndResistance(0.1F, 3.0F), EnumConeType.BARREL).setRegistryName("blue_traffic_barrel"));
        event.getRegistry().register(new ConeBlock(Block.Properties.create(Material.MISCELLANEOUS, MaterialColor.BLUE_TERRACOTTA).hardnessAndResistance(0.1F, 3.0F), EnumConeType.BOLLARD).setRegistryName("blue_traffic_bollard"));

        event.getRegistry().register(new ConeBlock(Block.Properties.create(Material.MISCELLANEOUS, MaterialColor.BROWN_TERRACOTTA).hardnessAndResistance(0.1F, 3.0F), EnumConeType.CONE).setRegistryName("brown_traffic_cone"));
        event.getRegistry().register(new ConeBlock(Block.Properties.create(Material.MISCELLANEOUS, MaterialColor.BROWN_TERRACOTTA).hardnessAndResistance(0.1F, 3.0F), EnumConeType.BARREL).setRegistryName("brown_traffic_barrel"));
        event.getRegistry().register(new ConeBlock(Block.Properties.create(Material.MISCELLANEOUS, MaterialColor.BROWN_TERRACOTTA).hardnessAndResistance(0.1F, 3.0F), EnumConeType.BOLLARD).setRegistryName("brown_traffic_bollard"));

        event.getRegistry().register(new ConeBlock(Block.Properties.create(Material.MISCELLANEOUS, MaterialColor.GREEN_TERRACOTTA).hardnessAndResistance(0.1F, 3.0F), EnumConeType.CONE).setRegistryName("green_traffic_cone"));
        event.getRegistry().register(new ConeBlock(Block.Properties.create(Material.MISCELLANEOUS, MaterialColor.GREEN_TERRACOTTA).hardnessAndResistance(0.1F, 3.0F), EnumConeType.BARREL).setRegistryName("green_traffic_barrel"));
        event.getRegistry().register(new ConeBlock(Block.Properties.create(Material.MISCELLANEOUS, MaterialColor.GREEN_TERRACOTTA).hardnessAndResistance(0.1F, 3.0F), EnumConeType.BOLLARD).setRegistryName("green_traffic_bollard"));

        event.getRegistry().register(new ConeBlock(Block.Properties.create(Material.MISCELLANEOUS, MaterialColor.RED_TERRACOTTA).hardnessAndResistance(0.1F, 3.0F), EnumConeType.CONE).setRegistryName("red_traffic_cone"));
        event.getRegistry().register(new ConeBlock(Block.Properties.create(Material.MISCELLANEOUS, MaterialColor.RED_TERRACOTTA).hardnessAndResistance(0.1F, 3.0F), EnumConeType.BARREL).setRegistryName("red_traffic_barrel"));
        event.getRegistry().register(new ConeBlock(Block.Properties.create(Material.MISCELLANEOUS, MaterialColor.RED_TERRACOTTA).hardnessAndResistance(0.1F, 3.0F), EnumConeType.BOLLARD).setRegistryName("red_traffic_bollard"));

        event.getRegistry().register(new ConeBlock(Block.Properties.create(Material.MISCELLANEOUS, MaterialColor.BLACK_TERRACOTTA).hardnessAndResistance(0.1F, 3.0F), EnumConeType.CONE).setRegistryName("black_traffic_cone"));
        event.getRegistry().register(new ConeBlock(Block.Properties.create(Material.MISCELLANEOUS, MaterialColor.BLACK_TERRACOTTA).hardnessAndResistance(0.1F, 3.0F), EnumConeType.BARREL).setRegistryName("black_traffic_barrel"));
        event.getRegistry().register(new ConeBlock(Block.Properties.create(Material.MISCELLANEOUS, MaterialColor.BLACK_TERRACOTTA).hardnessAndResistance(0.1F, 3.0F), EnumConeType.BOLLARD).setRegistryName("black_traffic_bollard"));

        event.getRegistry().register(new CustomBlock(Block.Properties.create(Material.ROCK, MaterialColor.BLACK).hardnessAndResistance(3.0F), ToolType.PICKAXE).setRegistryName("bitumen_block"));
        event.getRegistry().register(new CustomBlock(Block.Properties.create(Material.ROCK, MaterialColor.BLACK).hardnessAndResistance(3.0F), ToolType.PICKAXE).setRegistryName("bitumen_ore"));

        event.getRegistry().register(new GuardrailBlock(Block.Properties.create(Material.IRON, MaterialColor.GRAY).hardnessAndResistance(3.0F).sound(SoundType.LANTERN), ToolType.PICKAXE).setRegistryName("steel_guardrail"));
        event.getRegistry().register(new GuardrailBlock(Block.Properties.create(Material.IRON, MaterialColor.GRAY).hardnessAndResistance(3.0F).sound(SoundType.LANTERN), ToolType.PICKAXE).setRegistryName("black_guardrail"));
        event.getRegistry().register(new GuardrailBlock(Block.Properties.create(Material.IRON, MaterialColor.GRAY).hardnessAndResistance(3.0F).sound(SoundType.LANTERN), ToolType.PICKAXE).setRegistryName("white_guardrail"));
        event.getRegistry().register(new GuardrailBlock(Block.Properties.create(Material.IRON, MaterialColor.GRAY).hardnessAndResistance(3.0F).sound(SoundType.LANTERN), ToolType.PICKAXE).setRegistryName("yellow_guardrail"));

        event.getRegistry().register(new BollardBlock(Block.Properties.create(Material.MISCELLANEOUS, MaterialColor.SNOW).hardnessAndResistance(0.1F, 3.0F).sound(SoundType.METAL)).setRegistryName("white_bollard"));
        event.getRegistry().register(new BollardBlock(Block.Properties.create(Material.MISCELLANEOUS, MaterialColor.SNOW).hardnessAndResistance(0.1F, 3.0F).sound(SoundType.METAL)).setRegistryName("yellow_bollard"));
        event.getRegistry().register(new CylindricalBollardBlock(Block.Properties.create(Material.MISCELLANEOUS, MaterialColor.SNOW).hardnessAndResistance(0.1F, 3.0F).sound(SoundType.METAL)).setRegistryName("green_cylindrical_bollard"));
        event.getRegistry().register(new CylindricalBollardBlock(Block.Properties.create(Material.MISCELLANEOUS, MaterialColor.SNOW).hardnessAndResistance(0.1F, 3.0F).sound(SoundType.METAL)).setRegistryName("black_cylindrical_bollard"));

        for(int i = 1; i < ModConstants.PATTERNS; i++)
        {
            registerBlock(new RotatablePaintBlock(Block.Properties.create(Material.ROCK, MaterialColor.BLACK).hardnessAndResistance(1.0F, 6.0F), 0), "asphalt_white_line_" + i, registry);
            registerBlock(new RotatablePaintBlock(Block.Properties.create(Material.ROCK, MaterialColor.BLACK).hardnessAndResistance(1.0F, 6.0F), 0), "asphalt_yellow_line_" + i, registry);
            registerBlock(new RotatablePaintBlock(Block.Properties.create(Material.ROCK, MaterialColor.GRAY).hardnessAndResistance(1.0F, 6.0F), 1), "concrete_white_line_" + i, registry);
            registerBlock(new RotatablePaintBlock(Block.Properties.create(Material.ROCK, MaterialColor.GRAY).hardnessAndResistance(1.0F, 6.0F), 1), "concrete_yellow_line_" + i, registry);

            registerBlock(new RotatableSlopeBlock(Block.Properties.create(Material.ROCK, MaterialColor.BLACK).hardnessAndResistance(1.0F, 6.0F), 0), "asphalt_slope_white_line_" + i, registry);
            registerBlock(new RotatableSlopeBlock(Block.Properties.create(Material.ROCK, MaterialColor.BLACK).hardnessAndResistance(1.0F, 6.0F), 0), "asphalt_slope_yellow_line_" + i, registry);
            registerBlock(new RotatableSlopeBlock(Block.Properties.create(Material.ROCK, MaterialColor.GRAY).hardnessAndResistance(1.0F, 6.0F), 1), "concrete_slope_white_line_" + i, registry);
            registerBlock(new RotatableSlopeBlock(Block.Properties.create(Material.ROCK, MaterialColor.GRAY).hardnessAndResistance(1.0F, 6.0F), 1), "concrete_slope_yellow_line_" + i, registry);
        }
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
        event.getRegistry().register(new BlockItem(ASPHALT, new Item.Properties().group(ModItemGroups.ROADSTUFF)).setRegistryName(ASPHALT.getRegistryName()));
        event.getRegistry().register(new BlockItem(CONCRETE, new Item.Properties().group(ModItemGroups.ROADSTUFF)).setRegistryName(CONCRETE.getRegistryName()));

        event.getRegistry().register(new BlockItem(ASPHALT_SLOPE, new Item.Properties().group(ModItemGroups.ROADSTUFF)).setRegistryName(ASPHALT_SLOPE.getRegistryName()));
        event.getRegistry().register(new BlockItem(CONCRETE_SLOPE, new Item.Properties().group(ModItemGroups.ROADSTUFF)).setRegistryName(CONCRETE_SLOPE.getRegistryName()));

        event.getRegistry().register(new BlockItemPaintBucket(PAINT_BUCKET, new Item.Properties().group(ModItemGroups.ROADSTUFF).maxStackSize(1)).setRegistryName(PAINT_BUCKET.getRegistryName()));

        event.getRegistry().register(new ReflectorBlockItem(WHITE_REFLECTOR, new Item.Properties().group(ModItemGroups.ROADSTUFF), false).setRegistryName(WHITE_REFLECTOR.getRegistryName()));
        event.getRegistry().register(new ReflectorBlockItem(YELLOW_REFLECTOR, new Item.Properties().group(ModItemGroups.ROADSTUFF), false).setRegistryName(YELLOW_REFLECTOR.getRegistryName()));
        event.getRegistry().register(new ReflectorBlockItem(LUMINESCENT_WHITE_REFLECTOR, new Item.Properties().group(ModItemGroups.ROADSTUFF).rarity(Rarity.UNCOMMON), true).setRegistryName(LUMINESCENT_WHITE_REFLECTOR.getRegistryName()));
        event.getRegistry().register(new ReflectorBlockItem(LUMINESCENT_YELLOW_REFLECTOR, new Item.Properties().group(ModItemGroups.ROADSTUFF).rarity(Rarity.UNCOMMON), true).setRegistryName(LUMINESCENT_YELLOW_REFLECTOR.getRegistryName()));

        event.getRegistry().register(new BlockItem(WHITE_TRAFFIC_CONE, new Item.Properties().group(ModItemGroups.ROADSTUFF)).setRegistryName(WHITE_TRAFFIC_CONE.getRegistryName()));
        event.getRegistry().register(new BlockItem(WHITE_TRAFFIC_BARREL, new Item.Properties().group(ModItemGroups.ROADSTUFF)).setRegistryName(WHITE_TRAFFIC_BARREL.getRegistryName()));
        event.getRegistry().register(new BlockItem(WHITE_TRAFFIC_BOLLARD, new Item.Properties().group(ModItemGroups.ROADSTUFF)).setRegistryName(WHITE_TRAFFIC_BOLLARD.getRegistryName()));

        event.getRegistry().register(new BlockItem(ORANGE_TRAFFIC_CONE, new Item.Properties().group(ModItemGroups.ROADSTUFF)).setRegistryName(ORANGE_TRAFFIC_CONE.getRegistryName()));
        event.getRegistry().register(new BlockItem(ORANGE_TRAFFIC_BARREL, new Item.Properties().group(ModItemGroups.ROADSTUFF)).setRegistryName(ORANGE_TRAFFIC_BARREL.getRegistryName()));
        event.getRegistry().register(new BlockItem(ORANGE_TRAFFIC_BOLLARD, new Item.Properties().group(ModItemGroups.ROADSTUFF)).setRegistryName(ORANGE_TRAFFIC_BOLLARD.getRegistryName()));

        event.getRegistry().register(new BlockItem(MAGENTA_TRAFFIC_CONE, new Item.Properties().group(ModItemGroups.ROADSTUFF)).setRegistryName(MAGENTA_TRAFFIC_CONE.getRegistryName()));
        event.getRegistry().register(new BlockItem(MAGENTA_TRAFFIC_BARREL, new Item.Properties().group(ModItemGroups.ROADSTUFF)).setRegistryName(MAGENTA_TRAFFIC_BARREL.getRegistryName()));
        event.getRegistry().register(new BlockItem(MAGENTA_TRAFFIC_BOLLARD, new Item.Properties().group(ModItemGroups.ROADSTUFF)).setRegistryName(MAGENTA_TRAFFIC_BOLLARD.getRegistryName()));

        event.getRegistry().register(new BlockItem(LIGHT_BLUE_TRAFFIC_CONE, new Item.Properties().group(ModItemGroups.ROADSTUFF)).setRegistryName(LIGHT_BLUE_TRAFFIC_CONE.getRegistryName()));
        event.getRegistry().register(new BlockItem(LIGHT_BLUE_TRAFFIC_BARREL, new Item.Properties().group(ModItemGroups.ROADSTUFF)).setRegistryName(LIGHT_BLUE_TRAFFIC_BARREL.getRegistryName()));
        event.getRegistry().register(new BlockItem(LIGHT_BLUE_TRAFFIC_BOLLARD, new Item.Properties().group(ModItemGroups.ROADSTUFF)).setRegistryName(LIGHT_BLUE_TRAFFIC_BOLLARD.getRegistryName()));

        event.getRegistry().register(new BlockItem(YELLOW_TRAFFIC_CONE, new Item.Properties().group(ModItemGroups.ROADSTUFF)).setRegistryName(YELLOW_TRAFFIC_CONE.getRegistryName()));
        event.getRegistry().register(new BlockItem(YELLOW_TRAFFIC_BARREL, new Item.Properties().group(ModItemGroups.ROADSTUFF)).setRegistryName(YELLOW_TRAFFIC_BARREL.getRegistryName()));
        event.getRegistry().register(new BlockItem(YELLOW_TRAFFIC_BOLLARD, new Item.Properties().group(ModItemGroups.ROADSTUFF)).setRegistryName(YELLOW_TRAFFIC_BOLLARD.getRegistryName()));

        event.getRegistry().register(new BlockItem(LIME_TRAFFIC_CONE, new Item.Properties().group(ModItemGroups.ROADSTUFF)).setRegistryName(LIME_TRAFFIC_CONE.getRegistryName()));
        event.getRegistry().register(new BlockItem(LIME_TRAFFIC_BARREL, new Item.Properties().group(ModItemGroups.ROADSTUFF)).setRegistryName(LIME_TRAFFIC_BARREL.getRegistryName()));
        event.getRegistry().register(new BlockItem(LIME_TRAFFIC_BOLLARD, new Item.Properties().group(ModItemGroups.ROADSTUFF)).setRegistryName(LIME_TRAFFIC_BOLLARD.getRegistryName()));

        event.getRegistry().register(new BlockItem(PINK_TRAFFIC_CONE, new Item.Properties().group(ModItemGroups.ROADSTUFF)).setRegistryName(PINK_TRAFFIC_CONE.getRegistryName()));
        event.getRegistry().register(new BlockItem(PINK_TRAFFIC_BARREL, new Item.Properties().group(ModItemGroups.ROADSTUFF)).setRegistryName(PINK_TRAFFIC_BARREL.getRegistryName()));
        event.getRegistry().register(new BlockItem(PINK_TRAFFIC_BOLLARD, new Item.Properties().group(ModItemGroups.ROADSTUFF)).setRegistryName(PINK_TRAFFIC_BOLLARD.getRegistryName()));

        event.getRegistry().register(new BlockItem(GRAY_TRAFFIC_CONE, new Item.Properties().group(ModItemGroups.ROADSTUFF)).setRegistryName(GRAY_TRAFFIC_CONE.getRegistryName()));
        event.getRegistry().register(new BlockItem(GRAY_TRAFFIC_BARREL, new Item.Properties().group(ModItemGroups.ROADSTUFF)).setRegistryName(GRAY_TRAFFIC_BARREL.getRegistryName()));
        event.getRegistry().register(new BlockItem(GRAY_TRAFFIC_BOLLARD, new Item.Properties().group(ModItemGroups.ROADSTUFF)).setRegistryName(GRAY_TRAFFIC_BOLLARD.getRegistryName()));

        event.getRegistry().register(new BlockItem(LIGHT_GRAY_TRAFFIC_CONE, new Item.Properties().group(ModItemGroups.ROADSTUFF)).setRegistryName(LIGHT_GRAY_TRAFFIC_CONE.getRegistryName()));
        event.getRegistry().register(new BlockItem(LIGHT_GRAY_TRAFFIC_BARREL, new Item.Properties().group(ModItemGroups.ROADSTUFF)).setRegistryName(LIGHT_GRAY_TRAFFIC_BARREL.getRegistryName()));
        event.getRegistry().register(new BlockItem(LIGHT_GRAY_TRAFFIC_BOLLARD, new Item.Properties().group(ModItemGroups.ROADSTUFF)).setRegistryName(LIGHT_GRAY_TRAFFIC_BOLLARD.getRegistryName()));

        event.getRegistry().register(new BlockItem(CYAN_TRAFFIC_CONE, new Item.Properties().group(ModItemGroups.ROADSTUFF)).setRegistryName(CYAN_TRAFFIC_CONE.getRegistryName()));
        event.getRegistry().register(new BlockItem(CYAN_TRAFFIC_BARREL, new Item.Properties().group(ModItemGroups.ROADSTUFF)).setRegistryName(CYAN_TRAFFIC_BARREL.getRegistryName()));
        event.getRegistry().register(new BlockItem(CYAN_TRAFFIC_BOLLARD, new Item.Properties().group(ModItemGroups.ROADSTUFF)).setRegistryName(CYAN_TRAFFIC_BOLLARD.getRegistryName()));

        event.getRegistry().register(new BlockItem(PURPLE_TRAFFIC_CONE, new Item.Properties().group(ModItemGroups.ROADSTUFF)).setRegistryName(PURPLE_TRAFFIC_CONE.getRegistryName()));
        event.getRegistry().register(new BlockItem(PURPLE_TRAFFIC_BARREL, new Item.Properties().group(ModItemGroups.ROADSTUFF)).setRegistryName(PURPLE_TRAFFIC_BARREL.getRegistryName()));
        event.getRegistry().register(new BlockItem(PURPLE_TRAFFIC_BOLLARD, new Item.Properties().group(ModItemGroups.ROADSTUFF)).setRegistryName(PURPLE_TRAFFIC_BOLLARD.getRegistryName()));

        event.getRegistry().register(new BlockItem(BLUE_TRAFFIC_CONE, new Item.Properties().group(ModItemGroups.ROADSTUFF)).setRegistryName(BLUE_TRAFFIC_CONE.getRegistryName()));
        event.getRegistry().register(new BlockItem(BLUE_TRAFFIC_BARREL, new Item.Properties().group(ModItemGroups.ROADSTUFF)).setRegistryName(BLUE_TRAFFIC_BARREL.getRegistryName()));
        event.getRegistry().register(new BlockItem(BLUE_TRAFFIC_BOLLARD, new Item.Properties().group(ModItemGroups.ROADSTUFF)).setRegistryName(BLUE_TRAFFIC_BOLLARD.getRegistryName()));

        event.getRegistry().register(new BlockItem(BROWN_TRAFFIC_CONE, new Item.Properties().group(ModItemGroups.ROADSTUFF)).setRegistryName(BROWN_TRAFFIC_CONE.getRegistryName()));
        event.getRegistry().register(new BlockItem(BROWN_TRAFFIC_BARREL, new Item.Properties().group(ModItemGroups.ROADSTUFF)).setRegistryName(BROWN_TRAFFIC_BARREL.getRegistryName()));
        event.getRegistry().register(new BlockItem(BROWN_TRAFFIC_BOLLARD, new Item.Properties().group(ModItemGroups.ROADSTUFF)).setRegistryName(BROWN_TRAFFIC_BOLLARD.getRegistryName()));

        event.getRegistry().register(new BlockItem(GREEN_TRAFFIC_CONE, new Item.Properties().group(ModItemGroups.ROADSTUFF)).setRegistryName(GREEN_TRAFFIC_CONE.getRegistryName()));
        event.getRegistry().register(new BlockItem(GREEN_TRAFFIC_BARREL, new Item.Properties().group(ModItemGroups.ROADSTUFF)).setRegistryName(GREEN_TRAFFIC_BARREL.getRegistryName()));
        event.getRegistry().register(new BlockItem(GREEN_TRAFFIC_BOLLARD, new Item.Properties().group(ModItemGroups.ROADSTUFF)).setRegistryName(GREEN_TRAFFIC_BOLLARD.getRegistryName()));

        event.getRegistry().register(new BlockItem(RED_TRAFFIC_CONE, new Item.Properties().group(ModItemGroups.ROADSTUFF)).setRegistryName(RED_TRAFFIC_CONE.getRegistryName()));
        event.getRegistry().register(new BlockItem(RED_TRAFFIC_BARREL, new Item.Properties().group(ModItemGroups.ROADSTUFF)).setRegistryName(RED_TRAFFIC_BARREL.getRegistryName()));
        event.getRegistry().register(new BlockItem(RED_TRAFFIC_BOLLARD, new Item.Properties().group(ModItemGroups.ROADSTUFF)).setRegistryName(RED_TRAFFIC_BOLLARD.getRegistryName()));

        event.getRegistry().register(new BlockItem(BLACK_TRAFFIC_CONE, new Item.Properties().group(ModItemGroups.ROADSTUFF)).setRegistryName(BLACK_TRAFFIC_CONE.getRegistryName()));
        event.getRegistry().register(new BlockItem(BLACK_TRAFFIC_BARREL, new Item.Properties().group(ModItemGroups.ROADSTUFF)).setRegistryName(BLACK_TRAFFIC_BARREL.getRegistryName()));
        event.getRegistry().register(new BlockItem(BLACK_TRAFFIC_BOLLARD, new Item.Properties().group(ModItemGroups.ROADSTUFF)).setRegistryName(BLACK_TRAFFIC_BOLLARD.getRegistryName()));

        event.getRegistry().register(new BlockItem(BITUMEN_BLOCK, new Item.Properties().group(ModItemGroups.ROADSTUFF)).setRegistryName(BITUMEN_BLOCK.getRegistryName()));
        event.getRegistry().register(new BlockItem(BITUMEN_ORE, new Item.Properties().group(ModItemGroups.ROADSTUFF)).setRegistryName(BITUMEN_ORE.getRegistryName()));

        event.getRegistry().register(new BlockItem(STEEL_GUARDRAIL, new Item.Properties().group(ModItemGroups.ROADSTUFF)).setRegistryName(STEEL_GUARDRAIL.getRegistryName()));
        event.getRegistry().register(new BlockItem(BLACK_GUARDRAIL, new Item.Properties().group(ModItemGroups.ROADSTUFF)).setRegistryName(BLACK_GUARDRAIL.getRegistryName()));
        event.getRegistry().register(new BlockItem(WHITE_GUARDRAIL, new Item.Properties().group(ModItemGroups.ROADSTUFF)).setRegistryName(WHITE_GUARDRAIL.getRegistryName()));
        event.getRegistry().register(new BlockItem(YELLOW_GUARDRAIL, new Item.Properties().group(ModItemGroups.ROADSTUFF)).setRegistryName(YELLOW_GUARDRAIL.getRegistryName()));

        event.getRegistry().register(new BlockItem(WHITE_BOLLARD, new Item.Properties().group(ModItemGroups.ROADSTUFF)).setRegistryName(WHITE_BOLLARD.getRegistryName()));
        event.getRegistry().register(new BlockItem(YELLOW_BOLLARD, new Item.Properties().group(ModItemGroups.ROADSTUFF)).setRegistryName(YELLOW_BOLLARD.getRegistryName()));
        event.getRegistry().register(new BlockItem(GREEN_CYLINDRICAL_BOLLARD, new Item.Properties().group(ModItemGroups.ROADSTUFF)).setRegistryName(GREEN_CYLINDRICAL_BOLLARD.getRegistryName()));
        event.getRegistry().register(new BlockItem(BLACK_CYLINDRICAL_BOLLARD, new Item.Properties().group(ModItemGroups.ROADSTUFF)).setRegistryName(BLACK_CYLINDRICAL_BOLLARD.getRegistryName()));
    }
}
