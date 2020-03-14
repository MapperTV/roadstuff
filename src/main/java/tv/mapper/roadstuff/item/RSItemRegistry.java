package tv.mapper.roadstuff.item;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.lang3.tuple.Pair;

import net.minecraft.item.BlockItem;
import net.minecraft.item.DyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.Rarity;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import tv.mapper.roadstuff.RoadStuff;
import tv.mapper.roadstuff.block.RSBlockRegistry;

public class RSItemRegistry
{
    private static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, RoadStuff.MODID);

    public static final RegistryObject<BlockItem> ASPHALT_SLOPE_ITEM = ITEMS.register("asphalt_slope",
        () -> new BlockItem(RSBlockRegistry.ASPHALT_SLOPE.get(), new Item.Properties().group(ModItemGroups.ROADSTUFF)));
    public static final RegistryObject<BlockItem> CONCRETE_SLOPE_ITEM = ITEMS.register("concrete_slope",
        () -> new BlockItem(RSBlockRegistry.CONCRETE_SLOPE.get(), new Item.Properties().group(ModItemGroups.ROADSTUFF)));

    public static final Map<DyeColor, RegistryObject<BlockItem>> TRAFFIC_CONE_ITEMS = Arrays.stream(DyeColor.values()).map(type -> Pair.of(type,
        ITEMS.register(type.getName() + "_traffic_cone", () -> new BlockItem(RSBlockRegistry.TRAFFIC_CONE_BLOCKS.get(type).get(), new Item.Properties().group(ModItemGroups.ROADSTUFF))))).collect(
            Collectors.toMap(Pair::getKey, Pair::getValue));
    public static final Map<DyeColor, RegistryObject<BlockItem>> TRAFFIC_BARREL_ITEMS = Arrays.stream(DyeColor.values()).map(type -> Pair.of(type,
        ITEMS.register(type.getName() + "_traffic_barrel", () -> new BlockItem(RSBlockRegistry.TRAFFIC_BARREL_BLOCKS.get(type).get(), new Item.Properties().group(ModItemGroups.ROADSTUFF))))).collect(
            Collectors.toMap(Pair::getKey, Pair::getValue));
    public static final Map<DyeColor, RegistryObject<BlockItem>> TRAFFIC_BOLLARD_ITEMS = Arrays.stream(DyeColor.values()).map(type -> Pair.of(type,
        ITEMS.register(type.getName() + "_traffic_bollard", () -> new BlockItem(RSBlockRegistry.TRAFFIC_BOLLARD_BLOCKS.get(type).get(), new Item.Properties().group(ModItemGroups.ROADSTUFF))))).collect(
            Collectors.toMap(Pair::getKey, Pair::getValue));

    public static final Map<DyeColor, RegistryObject<BlockItem>> CYLINDRICAL_BOLLARD_ITEMS = Arrays.stream(DyeColor.values()).map(type -> Pair.of(type,
        ITEMS.register(type.getName() + "_cylindrical_bollard", () -> new BlockItem(RSBlockRegistry.CYLINDRICAL_BOLLARD_BLOCKS.get(type).get(), new Item.Properties().group(ModItemGroups.ROADSTUFF))))).collect(
            Collectors.toMap(Pair::getKey, Pair::getValue));

    public static final RegistryObject<BlockItem> WHITE_BOLLARD_ITEM = ITEMS.register("white_bollard",
        () -> new BlockItem(RSBlockRegistry.WHITE_BOLLARD.get(), new Item.Properties().group(ModItemGroups.ROADSTUFF)));
    public static final RegistryObject<BlockItem> YELLOW_BOLLARD_ITEM = ITEMS.register("yellow_bollard",
        () -> new BlockItem(RSBlockRegistry.YELLOW_BOLLARD.get(), new Item.Properties().group(ModItemGroups.ROADSTUFF)));
    public static final RegistryObject<BlockItem> RED_BOLLARD_ITEM = ITEMS.register("red_bollard", () -> new BlockItem(RSBlockRegistry.RED_BOLLARD.get(), new Item.Properties().group(ModItemGroups.ROADSTUFF)));

    public static final RegistryObject<BlockItem> WHITE_SMALL_BOLLARD_ITEM = ITEMS.register("white_small_bollard",
        () -> new BlockItem(RSBlockRegistry.WHITE_SMALL_BOLLARD.get(), new Item.Properties().group(ModItemGroups.ROADSTUFF)));
    public static final RegistryObject<BlockItem> YELLOW_SMALL_BOLLARD_ITEM = ITEMS.register("yellow_small_bollard",
        () -> new BlockItem(RSBlockRegistry.YELLOW_SMALL_BOLLARD.get(), new Item.Properties().group(ModItemGroups.ROADSTUFF)));
    public static final RegistryObject<BlockItem> RED_SMALL_BOLLARD_ITEM = ITEMS.register("red_small_bollard",
        () -> new BlockItem(RSBlockRegistry.RED_SMALL_BOLLARD.get(), new Item.Properties().group(ModItemGroups.ROADSTUFF)));

    // public static final Map<DyeColor, RegistryObject<BlockItem>> BOLLARD_ITEMS = Arrays.stream(DyeColor.values()).map(
    // type -> Pair.of(type, ITEMS.register(type.getName() + "_bollard", () -> new BlockItem(RSBlockRegistry.BOLLARD_BLOCKS.get(type).get(), new
    // Item.Properties().group(ModItemGroups.ROADSTUFF))))).collect(
    // Collectors.toMap(Pair::getKey, Pair::getValue));
    // public static final Map<DyeColor, RegistryObject<BlockItem>> SMALL_BOLLARD_ITEMS = Arrays.stream(DyeColor.values()).map(type -> Pair.of(type,
    // ITEMS.register(type.getName() + "_small_bollard", () -> new BlockItem(RSBlockRegistry.SMALL_BOLLARD_BLOCKS.get(type).get(), new Item.Properties().group(ModItemGroups.ROADSTUFF))))).collect(
    // Collectors.toMap(Pair::getKey, Pair::getValue));

    public static final Map<DyeColor, RegistryObject<ReflectorBlockItem>> REFLECTOR_ITEMS = Arrays.stream(DyeColor.values()).map(type -> Pair.of(type,
        ITEMS.register(type.getName() + "_reflector", () -> new ReflectorBlockItem(RSBlockRegistry.REFLECTOR_BLOCKS.get(type).get(), new Item.Properties().group(ModItemGroups.ROADSTUFF), false)))).collect(
            Collectors.toMap(Pair::getKey, Pair::getValue));
    public static final Map<DyeColor, RegistryObject<ReflectorBlockItem>> LUMINESCENT_REFLECTOR_ITEMS = Arrays.stream(DyeColor.values()).map(type -> Pair.of(type,
        ITEMS.register(type.getName() + "_luminescent_reflector",
            () -> new ReflectorBlockItem(RSBlockRegistry.LUMINESCENT_REFLECTOR_BLOCKS.get(type).get(), new Item.Properties().group(ModItemGroups.ROADSTUFF).rarity(Rarity.UNCOMMON), true)))).collect(
                Collectors.toMap(Pair::getKey, Pair::getValue));

    public static final RegistryObject<BlockItem> STEEL_GUARDRAIL_ITEM = ITEMS.register("steel_guardrail",
        () -> new BlockItem(RSBlockRegistry.STEEL_GUARDRAIL.get(), new Item.Properties().group(ModItemGroups.ROADSTUFF)));
    public static final Map<DyeColor, RegistryObject<BlockItem>> GUARDRAIL_ITEMS = Arrays.stream(DyeColor.values()).map(type -> Pair.of(type,
        ITEMS.register(type.getName() + "_guardrail", () -> new BlockItem(RSBlockRegistry.GUARDRAIL_BLOCKS.get(type).get(), new Item.Properties().group(ModItemGroups.ROADSTUFF))))).collect(
            Collectors.toMap(Pair::getKey, Pair::getValue));

    public static final RegistryObject<BlockItemPaintBucket> PAINT_BUCKET_ITEM = ITEMS.register("paint_bucket",
        () -> new BlockItemPaintBucket(RSBlockRegistry.PAINT_BUCKET.get(), new Item.Properties().group(ModItemGroups.ROADSTUFF).maxStackSize(1)));

    public static final RegistryObject<Item> PAINT_BRUSH = ITEMS.register("paint_brush", () -> new BrushItem(new Item.Properties().group(ModItemGroups.ROADSTUFF).maxStackSize(1)));

    public static void init()
    {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}