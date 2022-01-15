package tv.mapper.roadstuff.world.level.block;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.lang3.tuple.Pair;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import tv.mapper.mapperbase.world.level.block.CustomBlock;
import tv.mapper.mapperbase.world.level.block.CustomFenceBlock;
import tv.mapper.mapperbase.world.level.block.CustomFenceGateBlock;
import tv.mapper.mapperbase.world.level.block.CustomOreBlock;
import tv.mapper.mapperbase.world.level.block.CustomPressurePlateBlock;
import tv.mapper.mapperbase.world.level.block.CustomSlabBlock;
import tv.mapper.mapperbase.world.level.block.CustomStairsBlock;
import tv.mapper.mapperbase.world.level.block.CustomWallBlock;
import tv.mapper.mapperbase.world.level.block.ToolTypes;
import tv.mapper.roadstuff.RoadStuff;
import tv.mapper.roadstuff.util.ModConstants;
import tv.mapper.roadstuff.world.level.block.ConeBlock.EnumConeType;

public class RSBlockRegistry
{
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, RoadStuff.MODID);
    public static Set<RegistryObject<Block>> MOD_PAINTABLEBLOCKS = new LinkedHashSet<>();

    private static Properties concreteProperties = Block.Properties.of(Material.STONE, MaterialColor.STONE).strength(1.5F, 6.0F).sound(SoundType.STONE).requiresCorrectToolForDrops();
    private static Properties asphaltProperties = Block.Properties.of(Material.STONE, MaterialColor.COLOR_BLACK).strength(1.5F, 6.0F).sound(SoundType.STONE).requiresCorrectToolForDrops();
    private static Properties bollardProperties = Block.Properties.of(Material.DECORATION, MaterialColor.QUARTZ).strength(0.1F, 3.0F).sound(SoundType.BAMBOO).requiresCorrectToolForDrops();

    public static final RegistryObject<PaintableRoadBlock> CONCRETE = BLOCKS.register("concrete", () -> new PaintableRoadBlock(concreteProperties, ToolTypes.PICKAXE, 1));
    public static final RegistryObject<CustomStairsBlock> CONCRETE_STAIRS = BLOCKS.register("concrete_stairs", () -> new CustomStairsBlock(() -> CONCRETE.get().defaultBlockState(), concreteProperties, ToolTypes.PICKAXE));
    public static final RegistryObject<CustomSlabBlock> CONCRETE_SLAB = BLOCKS.register("concrete_slab", () -> new CustomSlabBlock(concreteProperties, ToolTypes.PICKAXE));
    public static final RegistryObject<CustomWallBlock> CONCRETE_WALL = BLOCKS.register("concrete_wall", () -> new CustomWallBlock(concreteProperties, ToolTypes.PICKAXE));
    public static final RegistryObject<CustomFenceBlock> CONCRETE_FENCE = BLOCKS.register("concrete_fence", () -> new CustomFenceBlock(concreteProperties, ToolTypes.PICKAXE));
    public static final RegistryObject<CustomFenceGateBlock> CONCRETE_FENCE_GATE = BLOCKS.register("concrete_fence_gate", () -> new CustomFenceGateBlock(concreteProperties, ToolTypes.PICKAXE));

    public static final RegistryObject<PaintableRoadBlock> ASPHALT = BLOCKS.register("asphalt", () -> new PaintableRoadBlock(asphaltProperties, ToolTypes.PICKAXE, 0));
    public static final RegistryObject<CustomStairsBlock> ASPHALT_STAIRS = BLOCKS.register("asphalt_stairs", () -> new CustomStairsBlock(() -> ASPHALT.get().defaultBlockState(), asphaltProperties, ToolTypes.PICKAXE));
    public static final RegistryObject<CustomSlabBlock> ASPHALT_SLAB = BLOCKS.register("asphalt_slab", () -> new CustomSlabBlock(asphaltProperties, ToolTypes.PICKAXE));

    public static final RegistryObject<PaintableSlopeBlock> ASPHALT_SLOPE = BLOCKS.register("asphalt_slope", () -> new PaintableSlopeBlock(asphaltProperties, ToolTypes.PICKAXE, 0));
    public static final RegistryObject<PaintableSlopeBlock> CONCRETE_SLOPE = BLOCKS.register("concrete_slope", () -> new PaintableSlopeBlock(concreteProperties, ToolTypes.PICKAXE, 1));

    static
    {
        for(int i = 1; i < ModConstants.PATTERNS; i++)
        {
            MOD_PAINTABLEBLOCKS.add(BLOCKS.register("asphalt_white_line_" + i, () -> new RotatablePaintBlock(asphaltProperties, ToolTypes.PICKAXE, 0)));
            MOD_PAINTABLEBLOCKS.add(BLOCKS.register("asphalt_yellow_line_" + i, () -> new RotatablePaintBlock(asphaltProperties, ToolTypes.PICKAXE, 0)));
            MOD_PAINTABLEBLOCKS.add(BLOCKS.register("concrete_white_line_" + i, () -> new RotatablePaintBlock(concreteProperties, ToolTypes.PICKAXE, 1)));
            MOD_PAINTABLEBLOCKS.add(BLOCKS.register("concrete_yellow_line_" + i, () -> new RotatablePaintBlock(concreteProperties, ToolTypes.PICKAXE, 1)));

            MOD_PAINTABLEBLOCKS.add(BLOCKS.register("asphalt_slope_white_line_" + i, () -> new RotatableSlopeBlock(asphaltProperties, ASPHALT_SLOPE.get(), ToolTypes.PICKAXE, 0)));
            MOD_PAINTABLEBLOCKS.add(BLOCKS.register("asphalt_slope_yellow_line_" + i, () -> new RotatableSlopeBlock(asphaltProperties, ASPHALT_SLOPE.get(), ToolTypes.PICKAXE, 0)));
            MOD_PAINTABLEBLOCKS.add(BLOCKS.register("concrete_slope_white_line_" + i, () -> new RotatableSlopeBlock(concreteProperties, CONCRETE_SLOPE.get(), ToolTypes.PICKAXE, 1)));
            MOD_PAINTABLEBLOCKS.add(BLOCKS.register("concrete_slope_yellow_line_" + i, () -> new RotatableSlopeBlock(concreteProperties, CONCRETE_SLOPE.get(), ToolTypes.PICKAXE, 1)));
        }
    }

    public static final RegistryObject<CustomBlock> BITUMEN_BLOCK = BLOCKS.register("bitumen_block", () -> new CustomBlock(Block.Properties.of(Material.STONE, MaterialColor.COLOR_BLACK).strength(3.0F).requiresCorrectToolForDrops(), ToolTypes.PICKAXE));
    public static final RegistryObject<CustomOreBlock> BITUMEN_ORE = BLOCKS.register("bitumen_ore", () -> new CustomOreBlock(Block.Properties.of(Material.STONE, MaterialColor.COLOR_BLACK).strength(3.0F).requiresCorrectToolForDrops(), UniformInt.of(0, 1), ToolTypes.PICKAXE));

    public static final Map<DyeColor, RegistryObject<ConeBlock>> TRAFFIC_CONE_BLOCKS = Arrays.stream(DyeColor.values()).map(type -> Pair.of(type, BLOCKS.register(type.getSerializedName() + "_traffic_cone", () -> new ConeBlock(Block.Properties.of(Material.DECORATION, type.getMaterialColor()).strength(0.1F, 3.0F).sound(SoundType.BAMBOO), ToolTypes.NONE, EnumConeType.CONE)))).collect(Collectors.toMap(Pair::getKey, Pair::getValue));
    public static final Map<DyeColor, RegistryObject<ConeBlock>> TRAFFIC_BARREL_BLOCKS = Arrays.stream(DyeColor.values()).map(type -> Pair.of(type, BLOCKS.register(type.getSerializedName() + "_traffic_barrel", () -> new ConeBlock(Block.Properties.of(Material.DECORATION, type.getMaterialColor()).strength(0.1F, 3.0F).sound(SoundType.BAMBOO), ToolTypes.NONE, EnumConeType.BARREL)))).collect(Collectors.toMap(Pair::getKey, Pair::getValue));
    public static final Map<DyeColor, RegistryObject<ConeBlock>> TRAFFIC_BOLLARD_BLOCKS = Arrays.stream(DyeColor.values()).map(type -> Pair.of(type, BLOCKS.register(type.getSerializedName() + "_traffic_bollard", () -> new ConeBlock(Block.Properties.of(Material.DECORATION, type.getMaterialColor()).strength(0.1F, 3.0F).sound(SoundType.BAMBOO), ToolTypes.NONE, EnumConeType.BOLLARD)))).collect(Collectors.toMap(Pair::getKey, Pair::getValue));

    public static final Map<DyeColor, RegistryObject<CylindricalBollardBlock>> CYLINDRICAL_BOLLARD_BLOCKS = Arrays.stream(DyeColor.values()).map(type -> Pair.of(type, BLOCKS.register(type.getSerializedName() + "_cylindrical_bollard", () -> new CylindricalBollardBlock(Block.Properties.of(Material.DECORATION, type.getMaterialColor()).strength(0.1F, 3.0F).sound(SoundType.BAMBOO), ToolTypes.NONE)))).collect(Collectors.toMap(Pair::getKey, Pair::getValue));

    public static final RegistryObject<BollardBlock> YELLOW_BOLLARD = BLOCKS.register("yellow_bollard", () -> new BollardBlock(bollardProperties, ToolTypes.NONE, false));
    public static final RegistryObject<BollardBlock> WHITE_BOLLARD = BLOCKS.register("white_bollard", () -> new BollardBlock(bollardProperties, ToolTypes.NONE, false));
    public static final RegistryObject<BollardBlock> RED_BOLLARD = BLOCKS.register("red_bollard", () -> new BollardBlock(bollardProperties, ToolTypes.NONE, false));

    public static final RegistryObject<BollardBlock> YELLOW_SMALL_BOLLARD = BLOCKS.register("yellow_small_bollard", () -> new BollardBlock(bollardProperties, ToolTypes.NONE, true));
    public static final RegistryObject<BollardBlock> WHITE_SMALL_BOLLARD = BLOCKS.register("white_small_bollard", () -> new BollardBlock(bollardProperties, ToolTypes.NONE, true));
    public static final RegistryObject<BollardBlock> RED_SMALL_BOLLARD = BLOCKS.register("red_small_bollard", () -> new BollardBlock(bollardProperties, ToolTypes.NONE, true));

    // public static final Map<DyeColor, RegistryObject<BollardBlock>> BOLLARD_BLOCKS = Arrays.stream(DyeColor.values()).map(type -> Pair.of(type, BLOCKS.register(type.getName() + "_bollard", () ->
    // new BollardBlock(bollardProperties, false)))).collect(Collectors.toMap(Pair::getKey, Pair::getValue));
    // public static final Map<DyeColor, RegistryObject<BollardBlock>> SMALL_BOLLARD_BLOCKS = Arrays.stream(DyeColor.values()).map(type -> Pair.of(type, BLOCKS.register(type.getName() +
    // "_small_bollard", () -> new BollardBlock(bollardProperties, true)))).collect(Collectors.toMap(Pair::getKey, Pair::getValue));

    public static final Map<DyeColor, RegistryObject<ReflectorBlock>> REFLECTOR_BLOCKS = Arrays.stream(DyeColor.values()).map(type -> Pair.of(type, BLOCKS.register(type.getSerializedName() + "_reflector", () -> new ReflectorBlock(Block.Properties.of(Material.DECORATION, type.getMaterialColor()).strength(0.1F, 3.0F).sound(SoundType.METAL), ToolTypes.NONE, false)))).collect(Collectors.toMap(Pair::getKey, Pair::getValue));
    public static final Map<DyeColor, RegistryObject<ReflectorBlock>> LUMINESCENT_REFLECTOR_BLOCKS = Arrays.stream(DyeColor.values()).map(type -> Pair.of(type, BLOCKS.register(type.getSerializedName() + "_luminescent_reflector", () -> new ReflectorBlock(Block.Properties.of(Material.DECORATION, type.getMaterialColor()).strength(0.1F, 3.0F).lightLevel((state) -> 14).sound(SoundType.METAL), ToolTypes.NONE, true)))).collect(Collectors.toMap(Pair::getKey, Pair::getValue));

    public static final RegistryObject<GuardrailBlock> STEEL_GUARDRAIL = BLOCKS.register("steel_guardrail", () -> new GuardrailBlock(Block.Properties.of(Material.METAL, MaterialColor.COLOR_GRAY).strength(3.0F).sound(SoundType.LANTERN), ToolTypes.PICKAXE));
    public static final Map<DyeColor, RegistryObject<GuardrailBlock>> GUARDRAIL_BLOCKS = Arrays.stream(DyeColor.values()).map(type -> Pair.of(type, BLOCKS.register(type.getSerializedName() + "_guardrail", () -> new GuardrailBlock(Block.Properties.of(Material.METAL, type.getMaterialColor()).strength(3.0F).sound(SoundType.LANTERN), ToolTypes.PICKAXE)))).collect(Collectors.toMap(Pair::getKey, Pair::getValue));

    public static final RegistryObject<PaintBucketBlock> PAINT_BUCKET = BLOCKS.register("paint_bucket", () -> new PaintBucketBlock(Block.Properties.of(Material.METAL, MaterialColor.COLOR_GRAY).strength(0.5F, 3.0F).sound(SoundType.LANTERN), ToolTypes.PICKAXE));

    public static final RegistryObject<CustomPressurePlateBlock> ASPHALT_PRESSURE_PLATE = BLOCKS.register("asphalt_pressure_plate", () -> new CustomPressurePlateBlock(PressurePlateBlock.Sensitivity.MOBS, asphaltProperties.noCollission(), ToolTypes.PICKAXE));
    public static final RegistryObject<CustomPressurePlateBlock> CONCRETE_PRESSURE_PLATE = BLOCKS.register("concrete_pressure_plate", () -> new CustomPressurePlateBlock(PressurePlateBlock.Sensitivity.MOBS, concreteProperties.noCollission(), ToolTypes.PICKAXE));

    public static void init()
    {
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}