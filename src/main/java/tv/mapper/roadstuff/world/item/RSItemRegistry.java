package tv.mapper.roadstuff.world.item;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.lang3.tuple.Pair;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import tv.mapper.mapperbase.world.item.FuelItem;
import tv.mapper.roadstuff.RoadStuff;
import tv.mapper.roadstuff.world.level.block.RSBlockRegistry;

public class RSItemRegistry
{
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, RoadStuff.MODID);

    public static Set<RegistryObject<Item>> MOD_PAINTBRUSHES = new LinkedHashSet<>();

    public static final RegistryObject<Item> CONCRETE_ITEM = ITEMS.register("concrete", () -> new BlockItem(RSBlockRegistry.CONCRETE.get(), new Item.Properties().tab(ModItemGroups.ROADSTUFF)));
    public static final RegistryObject<Item> CONCRETE_STAIRS_ITEM = ITEMS.register("concrete_stairs", () -> new BlockItem(RSBlockRegistry.CONCRETE_STAIRS.get(), new Item.Properties().tab(ModItemGroups.ROADSTUFF)));
    public static final RegistryObject<Item> CONCRETE_SLAB_ITEM = ITEMS.register("concrete_slab", () -> new BlockItem(RSBlockRegistry.CONCRETE_SLAB.get(), new Item.Properties().tab(ModItemGroups.ROADSTUFF)));
    public static final RegistryObject<Item> CONCRETE_WALL_ITEM = ITEMS.register("concrete_wall", () -> new BlockItem(RSBlockRegistry.CONCRETE_WALL.get(), new Item.Properties().tab(ModItemGroups.ROADSTUFF)));
    public static final RegistryObject<Item> CONCRETE_PRESSURE_PLATE_ITEM = ITEMS.register("concrete_pressure_plate", () -> new BlockItem(RSBlockRegistry.CONCRETE_PRESSURE_PLATE.get(), new Item.Properties().tab(ModItemGroups.ROADSTUFF)));
    public static final RegistryObject<Item> CONCRETE_FENCE_ITEM = ITEMS.register("concrete_fence", () -> new BlockItem(RSBlockRegistry.CONCRETE_FENCE.get(), new Item.Properties().tab(ModItemGroups.ROADSTUFF)));
    public static final RegistryObject<Item> CONCRETE_FENCE_GATE_ITEM = ITEMS.register("concrete_fence_gate", () -> new BlockItem(RSBlockRegistry.CONCRETE_FENCE_GATE.get(), new Item.Properties().tab(ModItemGroups.ROADSTUFF)));

    public static final RegistryObject<Item> ASPHALT_ITEM = ITEMS.register("asphalt", () -> new BlockItem(RSBlockRegistry.ASPHALT.get(), new Item.Properties().tab(ModItemGroups.ROADSTUFF)));
    public static final RegistryObject<Item> ASPHALT_STAIRS_ITEM = ITEMS.register("asphalt_stairs", () -> new BlockItem(RSBlockRegistry.ASPHALT_STAIRS.get(), new Item.Properties().tab(ModItemGroups.ROADSTUFF)));
    public static final RegistryObject<Item> ASPHALT_SLAB_ITEM = ITEMS.register("asphalt_slab", () -> new BlockItem(RSBlockRegistry.ASPHALT_SLAB.get(), new Item.Properties().tab(ModItemGroups.ROADSTUFF)));
    public static final RegistryObject<Item> ASPHALT_PRESSURE_PLATE_ITEM = ITEMS.register("asphalt_pressure_plate", () -> new BlockItem(RSBlockRegistry.ASPHALT_PRESSURE_PLATE.get(), new Item.Properties().tab(ModItemGroups.ROADSTUFF)));

    public static final RegistryObject<BlockItem> ASPHALT_SLOPE_ITEM = ITEMS.register("asphalt_slope", () -> new BlockItem(RSBlockRegistry.ASPHALT_SLOPE.get(), new Item.Properties().tab(ModItemGroups.ROADSTUFF)));
    public static final RegistryObject<BlockItem> CONCRETE_SLOPE_ITEM = ITEMS.register("concrete_slope", () -> new BlockItem(RSBlockRegistry.CONCRETE_SLOPE.get(), new Item.Properties().tab(ModItemGroups.ROADSTUFF)));

    public static final RegistryObject<Item> RAW_BITUMEN = ITEMS.register("raw_bitumen", () -> new Item(new Item.Properties().tab(ModItemGroups.ROADSTUFF)));
    public static final RegistryObject<Item> BITUMEN_ORE_ITEM = ITEMS.register("bitumen_ore", () -> new BlockItem(RSBlockRegistry.BITUMEN_ORE.get(), new Item.Properties().tab(ModItemGroups.ROADSTUFF)));
    public static final RegistryObject<Item> BITUMEN_ITEM = ITEMS.register("bitumen_block", () -> new BlockItem(RSBlockRegistry.BITUMEN_BLOCK.get(), new Item.Properties().tab(ModItemGroups.ROADSTUFF)));
    public static final RegistryObject<Item> BITUMINOUS_COAL = ITEMS.register("bituminous_coal", () -> new FuelItem(new Item.Properties().tab(ModItemGroups.ROADSTUFF), 250));

    public static final Map<DyeColor, RegistryObject<BlockItem>> TRAFFIC_CONE_ITEMS = Arrays.stream(DyeColor.values()).map(type -> Pair.of(type, ITEMS.register(type.getSerializedName() + "_traffic_cone", () -> new BlockItem(RSBlockRegistry.TRAFFIC_CONE_BLOCKS.get(type).get(), new Item.Properties().tab(ModItemGroups.ROADSTUFF))))).collect(Collectors.toMap(Pair::getKey, Pair::getValue));
    public static final Map<DyeColor, RegistryObject<BlockItem>> TRAFFIC_BARREL_ITEMS = Arrays.stream(DyeColor.values()).map(type -> Pair.of(type, ITEMS.register(type.getSerializedName() + "_traffic_barrel", () -> new BlockItem(RSBlockRegistry.TRAFFIC_BARREL_BLOCKS.get(type).get(), new Item.Properties().tab(ModItemGroups.ROADSTUFF))))).collect(Collectors.toMap(Pair::getKey, Pair::getValue));
    public static final Map<DyeColor, RegistryObject<BlockItem>> TRAFFIC_BOLLARD_ITEMS = Arrays.stream(DyeColor.values()).map(type -> Pair.of(type, ITEMS.register(type.getSerializedName() + "_traffic_bollard", () -> new BlockItem(RSBlockRegistry.TRAFFIC_BOLLARD_BLOCKS.get(type).get(), new Item.Properties().tab(ModItemGroups.ROADSTUFF))))).collect(Collectors.toMap(Pair::getKey, Pair::getValue));

    public static final Map<DyeColor, RegistryObject<BlockItem>> CYLINDRICAL_BOLLARD_ITEMS = Arrays.stream(DyeColor.values()).map(type -> Pair.of(type, ITEMS.register(type.getSerializedName() + "_cylindrical_bollard", () -> new BlockItem(RSBlockRegistry.CYLINDRICAL_BOLLARD_BLOCKS.get(type).get(), new Item.Properties().tab(ModItemGroups.ROADSTUFF))))).collect(Collectors.toMap(Pair::getKey, Pair::getValue));

    public static final RegistryObject<BlockItem> WHITE_BOLLARD_ITEM = ITEMS.register("white_bollard", () -> new BlockItem(RSBlockRegistry.WHITE_BOLLARD.get(), new Item.Properties().tab(ModItemGroups.ROADSTUFF)));
    public static final RegistryObject<BlockItem> YELLOW_BOLLARD_ITEM = ITEMS.register("yellow_bollard", () -> new BlockItem(RSBlockRegistry.YELLOW_BOLLARD.get(), new Item.Properties().tab(ModItemGroups.ROADSTUFF)));
    public static final RegistryObject<BlockItem> RED_BOLLARD_ITEM = ITEMS.register("red_bollard", () -> new BlockItem(RSBlockRegistry.RED_BOLLARD.get(), new Item.Properties().tab(ModItemGroups.ROADSTUFF)));

    public static final RegistryObject<BlockItem> WHITE_SMALL_BOLLARD_ITEM = ITEMS.register("white_small_bollard", () -> new BlockItem(RSBlockRegistry.WHITE_SMALL_BOLLARD.get(), new Item.Properties().tab(ModItemGroups.ROADSTUFF)));
    public static final RegistryObject<BlockItem> YELLOW_SMALL_BOLLARD_ITEM = ITEMS.register("yellow_small_bollard", () -> new BlockItem(RSBlockRegistry.YELLOW_SMALL_BOLLARD.get(), new Item.Properties().tab(ModItemGroups.ROADSTUFF)));
    public static final RegistryObject<BlockItem> RED_SMALL_BOLLARD_ITEM = ITEMS.register("red_small_bollard", () -> new BlockItem(RSBlockRegistry.RED_SMALL_BOLLARD.get(), new Item.Properties().tab(ModItemGroups.ROADSTUFF)));

    // public static final Map<DyeColor, RegistryObject<BlockItem>> BOLLARD_ITEMS = Arrays.stream(DyeColor.values()).map(
    // type -> Pair.of(type, ITEMS.register(type.getString() + "_bollard", () -> new BlockItem(RSBlockRegistry.BOLLARD_BLOCKS.get(type).get(), new
    // Item.Properties().group(ModItemGroups.ROADSTUFF))))).collect(
    // Collectors.toMap(Pair::getKey, Pair::getValue));
    // public static final Map<DyeColor, RegistryObject<BlockItem>> SMALL_BOLLARD_ITEMS = Arrays.stream(DyeColor.values()).map(type -> Pair.of(type,
    // ITEMS.register(type.getString() + "_small_bollard", () -> new BlockItem(RSBlockRegistry.SMALL_BOLLARD_BLOCKS.get(type).get(), new Item.Properties().group(ModItemGroups.ROADSTUFF))))).collect(
    // Collectors.toMap(Pair::getKey, Pair::getValue));

    public static final Map<DyeColor, RegistryObject<ReflectorBlockItem>> REFLECTOR_ITEMS = Arrays.stream(DyeColor.values()).map(type -> Pair.of(type, ITEMS.register(type.getSerializedName() + "_reflector", () -> new ReflectorBlockItem(RSBlockRegistry.REFLECTOR_BLOCKS.get(type).get(), new Item.Properties().tab(ModItemGroups.ROADSTUFF), false)))).collect(Collectors.toMap(Pair::getKey, Pair::getValue));
    public static final Map<DyeColor, RegistryObject<ReflectorBlockItem>> LUMINESCENT_REFLECTOR_ITEMS = Arrays.stream(DyeColor.values()).map(type -> Pair.of(type, ITEMS.register(type.getSerializedName() + "_luminescent_reflector", () -> new ReflectorBlockItem(RSBlockRegistry.LUMINESCENT_REFLECTOR_BLOCKS.get(type).get(), new Item.Properties().tab(ModItemGroups.ROADSTUFF).rarity(Rarity.UNCOMMON), true)))).collect(Collectors.toMap(Pair::getKey, Pair::getValue));

    public static final RegistryObject<BlockItem> STEEL_GUARDRAIL_ITEM = ITEMS.register("steel_guardrail", () -> new BlockItem(RSBlockRegistry.STEEL_GUARDRAIL.get(), new Item.Properties().tab(ModItemGroups.ROADSTUFF)));
    public static final Map<DyeColor, RegistryObject<BlockItem>> GUARDRAIL_ITEMS = Arrays.stream(DyeColor.values()).map(type -> Pair.of(type, ITEMS.register(type.getSerializedName() + "_guardrail", () -> new BlockItem(RSBlockRegistry.GUARDRAIL_BLOCKS.get(type).get(), new Item.Properties().tab(ModItemGroups.ROADSTUFF))))).collect(Collectors.toMap(Pair::getKey, Pair::getValue));

    public static final RegistryObject<BlockItemPaintBucket> PAINT_BUCKET_ITEM = ITEMS.register("paint_bucket", () -> new BlockItemPaintBucket(RSBlockRegistry.PAINT_BUCKET.get(), new Item.Properties().tab(ModItemGroups.ROADSTUFF).stacksTo(1)));

    public static final RegistryObject<Item> WOODEN_PAINT_BRUSH = ITEMS.register("wooden_paint_brush", () -> new BrushItem(new Item.Properties().tab(ModItemGroups.ROADSTUFF).stacksTo(1), 32));
    public static final RegistryObject<Item> STONE_PAINT_BRUSH = ITEMS.register("stone_paint_brush", () -> new BrushItem(new Item.Properties().tab(ModItemGroups.ROADSTUFF).stacksTo(1), 64));
    public static final RegistryObject<Item> IRON_PAINT_BRUSH = ITEMS.register("iron_paint_brush", () -> new BrushItem(new Item.Properties().tab(ModItemGroups.ROADSTUFF).stacksTo(1), 128));
    public static final RegistryObject<Item> GOLDEN_PAINT_BRUSH = ITEMS.register("golden_paint_brush", () -> new BrushItem(new Item.Properties().tab(ModItemGroups.ROADSTUFF).stacksTo(1), 256));
    public static final RegistryObject<Item> STEEL_PAINT_BRUSH = ITEMS.register("steel_paint_brush", () -> new BrushItem(new Item.Properties().tab(ModItemGroups.ROADSTUFF).stacksTo(1), 384));
    public static final RegistryObject<Item> DIAMOND_PAINT_BRUSH = ITEMS.register("diamond_paint_brush", () -> new BrushItem(new Item.Properties().tab(ModItemGroups.ROADSTUFF).stacksTo(1), 512));
    public static final RegistryObject<Item> NETHERITE_PAINT_BRUSH = ITEMS.register("netherite_paint_brush", () -> new BrushItem(new Item.Properties().tab(ModItemGroups.ROADSTUFF).stacksTo(1), 1024));

    static
    {
        MOD_PAINTBRUSHES.add(WOODEN_PAINT_BRUSH);
        MOD_PAINTBRUSHES.add(STONE_PAINT_BRUSH);
        MOD_PAINTBRUSHES.add(IRON_PAINT_BRUSH);
        MOD_PAINTBRUSHES.add(GOLDEN_PAINT_BRUSH);
        MOD_PAINTBRUSHES.add(STEEL_PAINT_BRUSH);
        MOD_PAINTBRUSHES.add(DIAMOND_PAINT_BRUSH);
        MOD_PAINTBRUSHES.add(NETHERITE_PAINT_BRUSH);
    }

    public static void init()
    {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}