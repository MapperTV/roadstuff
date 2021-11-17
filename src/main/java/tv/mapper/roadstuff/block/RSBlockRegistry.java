package tv.mapper.roadstuff.block;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.lang3.tuple.Pair;

import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import tv.mapper.mapperbase.block.PaintableBlock;
import tv.mapper.mapperbase.block.ToolTypes;
import tv.mapper.roadstuff.RoadStuff;
import tv.mapper.roadstuff.block.ConeBlock.EnumConeType;
import tv.mapper.roadstuff.util.ModConstants;

public class RSBlockRegistry
{
    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, RoadStuff.MODID);
    public static Set<RegistryObject<PaintableBlock>> MOD_PAINTABLEBLOCKS = new LinkedHashSet<>();

    private static Properties concreteProperties = Block.Properties.of(Material.STONE, MaterialColor.STONE).strength(1.5F, 6.0F).sound(SoundType.STONE).requiresCorrectToolForDrops();
    private static Properties asphaltProperties = Block.Properties.of(Material.STONE, MaterialColor.COLOR_BLACK).strength(1.5F, 6.0F).sound(SoundType.STONE).requiresCorrectToolForDrops();
    private static Properties bollardProperties = Block.Properties.of(Material.DECORATION, MaterialColor.QUARTZ).strength(0.1F, 3.0F).sound(SoundType.BAMBOO).requiresCorrectToolForDrops();

    public static final RegistryObject<SlopeBlock> ASPHALT_SLOPE = BLOCKS.register("asphalt_slope", () -> new SlopeBlock(asphaltProperties, ToolTypes.PICKAXE, 0));
    public static final RegistryObject<SlopeBlock> CONCRETE_SLOPE = BLOCKS.register("concrete_slope", () -> new SlopeBlock(concreteProperties, ToolTypes.PICKAXE, 1));

    static
    {
        for(int i = 1; i < ModConstants.PATTERNS; i++)
        {
            MOD_PAINTABLEBLOCKS.add(BLOCKS.register("asphalt_white_line_" + i, () -> new RotatablePaintBlock(asphaltProperties, ToolTypes.PICKAXE, 0)));
            MOD_PAINTABLEBLOCKS.add(BLOCKS.register("asphalt_yellow_line_" + i, () -> new RotatablePaintBlock(asphaltProperties, ToolTypes.PICKAXE, 0)));
            MOD_PAINTABLEBLOCKS.add(BLOCKS.register("concrete_white_line_" + i, () -> new RotatablePaintBlock(concreteProperties, ToolTypes.PICKAXE, 1)));
            MOD_PAINTABLEBLOCKS.add(BLOCKS.register("concrete_yellow_line_" + i, () -> new RotatablePaintBlock(concreteProperties, ToolTypes.PICKAXE, 1)));

            MOD_PAINTABLEBLOCKS.add(BLOCKS.register("asphalt_slope_white_line_" + i, () -> new RotatableSlopeBlock(asphaltProperties, ToolTypes.PICKAXE, 0)));
            MOD_PAINTABLEBLOCKS.add(BLOCKS.register("asphalt_slope_yellow_line_" + i, () -> new RotatableSlopeBlock(asphaltProperties, ToolTypes.PICKAXE, 0)));
            MOD_PAINTABLEBLOCKS.add(BLOCKS.register("concrete_slope_white_line_" + i, () -> new RotatableSlopeBlock(concreteProperties, ToolTypes.PICKAXE, 1)));
            MOD_PAINTABLEBLOCKS.add(BLOCKS.register("concrete_slope_yellow_line_" + i, () -> new RotatableSlopeBlock(concreteProperties, ToolTypes.PICKAXE, 1)));
        }
    }

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

    public static void init()
    {
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}