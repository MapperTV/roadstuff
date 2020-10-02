package tv.mapper.roadstuff.block;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.lang3.tuple.Pair;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.DyeColor;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import tv.mapper.mapperbase.block.PaintableBlock;
import tv.mapper.roadstuff.RoadStuff;
import tv.mapper.roadstuff.block.ConeBlock.EnumConeType;
import tv.mapper.roadstuff.util.ModConstants;

public class RSBlockRegistry
{
    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, RoadStuff.MODID);
    public static Set<RegistryObject<PaintableBlock>> MOD_PAINTABLEBLOCKS = new LinkedHashSet<>();

    public static final RegistryObject<SlopeBlock> ASPHALT_SLOPE = BLOCKS.register("asphalt_slope",
        () -> new SlopeBlock(Block.Properties.create(Material.ROCK, MaterialColor.BLACK).hardnessAndResistance(1.0F, 6.0F), ToolType.PICKAXE, 0));
    public static final RegistryObject<SlopeBlock> CONCRETE_SLOPE = BLOCKS.register("concrete_slope",
        () -> new SlopeBlock(Block.Properties.create(Material.ROCK, MaterialColor.GRAY).hardnessAndResistance(1.0F, 6.0F), ToolType.PICKAXE, 1));

    static
    {
        for(int i = 1; i < ModConstants.PATTERNS; i++)
        {
            MOD_PAINTABLEBLOCKS.add(
                BLOCKS.register("asphalt_white_line_" + i, () -> new RotatablePaintBlock(Block.Properties.create(Material.ROCK, MaterialColor.BLACK).hardnessAndResistance(1.0F, 6.0F), ToolType.PICKAXE, 0)));
            MOD_PAINTABLEBLOCKS.add(
                BLOCKS.register("asphalt_yellow_line_" + i, () -> new RotatablePaintBlock(Block.Properties.create(Material.ROCK, MaterialColor.BLACK).hardnessAndResistance(1.0F, 6.0F), ToolType.PICKAXE, 0)));
            MOD_PAINTABLEBLOCKS.add(
                BLOCKS.register("concrete_white_line_" + i, () -> new RotatablePaintBlock(Block.Properties.create(Material.ROCK, MaterialColor.GRAY).hardnessAndResistance(1.0F, 6.0F), ToolType.PICKAXE, 1)));
            MOD_PAINTABLEBLOCKS.add(
                BLOCKS.register("concrete_yellow_line_" + i, () -> new RotatablePaintBlock(Block.Properties.create(Material.ROCK, MaterialColor.GRAY).hardnessAndResistance(1.0F, 6.0F), ToolType.PICKAXE, 1)));

            MOD_PAINTABLEBLOCKS.add(BLOCKS.register("asphalt_slope_white_line_" + i,
                () -> new RotatableSlopeBlock(Block.Properties.create(Material.ROCK, MaterialColor.BLACK).hardnessAndResistance(1.0F, 6.0F), ToolType.PICKAXE, 0)));
            MOD_PAINTABLEBLOCKS.add(BLOCKS.register("asphalt_slope_yellow_line_" + i,
                () -> new RotatableSlopeBlock(Block.Properties.create(Material.ROCK, MaterialColor.BLACK).hardnessAndResistance(1.0F, 6.0F), ToolType.PICKAXE, 0)));
            MOD_PAINTABLEBLOCKS.add(BLOCKS.register("concrete_slope_white_line_" + i,
                () -> new RotatableSlopeBlock(Block.Properties.create(Material.ROCK, MaterialColor.GRAY).hardnessAndResistance(1.0F, 6.0F), ToolType.PICKAXE, 1)));
            MOD_PAINTABLEBLOCKS.add(BLOCKS.register("concrete_slope_yellow_line_" + i,
                () -> new RotatableSlopeBlock(Block.Properties.create(Material.ROCK, MaterialColor.GRAY).hardnessAndResistance(1.0F, 6.0F), ToolType.PICKAXE, 1)));
        }
    }

    public static final Map<DyeColor, RegistryObject<ConeBlock>> TRAFFIC_CONE_BLOCKS = Arrays.stream(DyeColor.values()).map(type -> Pair.of(type,
        BLOCKS.register(type.getString() + "_traffic_cone",
            () -> new ConeBlock(Block.Properties.create(Material.MISCELLANEOUS, type.getMapColor()).hardnessAndResistance(0.1F, 3.0F).sound(SoundType.BAMBOO), EnumConeType.CONE)))).collect(
                Collectors.toMap(Pair::getKey, Pair::getValue));
    public static final Map<DyeColor, RegistryObject<ConeBlock>> TRAFFIC_BARREL_BLOCKS = Arrays.stream(DyeColor.values()).map(type -> Pair.of(type,
        BLOCKS.register(type.getString() + "_traffic_barrel",
            () -> new ConeBlock(Block.Properties.create(Material.MISCELLANEOUS, type.getMapColor()).hardnessAndResistance(0.1F, 3.0F).sound(SoundType.BAMBOO), EnumConeType.BARREL)))).collect(
                Collectors.toMap(Pair::getKey, Pair::getValue));
    public static final Map<DyeColor, RegistryObject<ConeBlock>> TRAFFIC_BOLLARD_BLOCKS = Arrays.stream(DyeColor.values()).map(type -> Pair.of(type,
        BLOCKS.register(type.getString() + "_traffic_bollard",
            () -> new ConeBlock(Block.Properties.create(Material.MISCELLANEOUS, type.getMapColor()).hardnessAndResistance(0.1F, 3.0F).sound(SoundType.BAMBOO), EnumConeType.BOLLARD)))).collect(
                Collectors.toMap(Pair::getKey, Pair::getValue));

    public static final Map<DyeColor, RegistryObject<CylindricalBollardBlock>> CYLINDRICAL_BOLLARD_BLOCKS = Arrays.stream(DyeColor.values()).map(type -> Pair.of(type,
        BLOCKS.register(type.getString() + "_cylindrical_bollard",
            () -> new CylindricalBollardBlock(Block.Properties.create(Material.MISCELLANEOUS, type.getMapColor()).hardnessAndResistance(0.1F, 3.0F).sound(SoundType.BAMBOO))))).collect(
                Collectors.toMap(Pair::getKey, Pair::getValue));

    public static final RegistryObject<BollardBlock> YELLOW_BOLLARD = BLOCKS.register("yellow_bollard",
        () -> new BollardBlock(Block.Properties.create(Material.MISCELLANEOUS, MaterialColor.QUARTZ).hardnessAndResistance(0.1F, 3.0F).sound(SoundType.BAMBOO), false));
    public static final RegistryObject<BollardBlock> WHITE_BOLLARD = BLOCKS.register("white_bollard",
        () -> new BollardBlock(Block.Properties.create(Material.MISCELLANEOUS, MaterialColor.QUARTZ).hardnessAndResistance(0.1F, 3.0F).sound(SoundType.BAMBOO), false));
    public static final RegistryObject<BollardBlock> RED_BOLLARD = BLOCKS.register("red_bollard",
        () -> new BollardBlock(Block.Properties.create(Material.MISCELLANEOUS, MaterialColor.QUARTZ).hardnessAndResistance(0.1F, 3.0F).sound(SoundType.BAMBOO), false));

    public static final RegistryObject<BollardBlock> YELLOW_SMALL_BOLLARD = BLOCKS.register("yellow_small_bollard",
        () -> new BollardBlock(Block.Properties.create(Material.MISCELLANEOUS, MaterialColor.QUARTZ).hardnessAndResistance(0.1F, 3.0F).sound(SoundType.BAMBOO), true));
    public static final RegistryObject<BollardBlock> WHITE_SMALL_BOLLARD = BLOCKS.register("white_small_bollard",
        () -> new BollardBlock(Block.Properties.create(Material.MISCELLANEOUS, MaterialColor.QUARTZ).hardnessAndResistance(0.1F, 3.0F).sound(SoundType.BAMBOO), true));
    public static final RegistryObject<BollardBlock> RED_SMALL_BOLLARD = BLOCKS.register("red_small_bollard",
        () -> new BollardBlock(Block.Properties.create(Material.MISCELLANEOUS, MaterialColor.QUARTZ).hardnessAndResistance(0.1F, 3.0F).sound(SoundType.BAMBOO), true));

    // public static final Map<DyeColor, RegistryObject<BollardBlock>> BOLLARD_BLOCKS = Arrays.stream(DyeColor.values()).map(type -> Pair.of(type,
    // BLOCKS.register(type.getName() + "_bollard",
    // () -> new BollardBlock(Block.Properties.create(Material.MISCELLANEOUS, MaterialColor.QUARTZ).hardnessAndResistance(0.1F, 3.0F).sound(SoundType.BAMBOO), false)))).collect(
    // Collectors.toMap(Pair::getKey, Pair::getValue));
    // public static final Map<DyeColor, RegistryObject<BollardBlock>> SMALL_BOLLARD_BLOCKS = Arrays.stream(DyeColor.values()).map(type -> Pair.of(type,
    // BLOCKS.register(type.getName() + "_small_bollard",
    // () -> new BollardBlock(Block.Properties.create(Material.MISCELLANEOUS, MaterialColor.QUARTZ).hardnessAndResistance(0.1F, 3.0F).sound(SoundType.BAMBOO), true)))).collect(
    // Collectors.toMap(Pair::getKey, Pair::getValue));

    public static final Map<DyeColor, RegistryObject<ReflectorBlock>> REFLECTOR_BLOCKS = Arrays.stream(DyeColor.values()).map(type -> Pair.of(type,
        BLOCKS.register(type.getString() + "_reflector",
            () -> new ReflectorBlock(Block.Properties.create(Material.MISCELLANEOUS, type.getMapColor()).hardnessAndResistance(0.1F, 3.0F).sound(SoundType.METAL), false)))).collect(
                Collectors.toMap(Pair::getKey, Pair::getValue));
    public static final Map<DyeColor, RegistryObject<ReflectorBlock>> LUMINESCENT_REFLECTOR_BLOCKS = Arrays.stream(DyeColor.values()).map(type -> Pair.of(type,
        BLOCKS.register(type.getString() + "_luminescent_reflector",
            () -> new ReflectorBlock(Block.Properties.create(Material.MISCELLANEOUS, type.getMapColor()).hardnessAndResistance(0.1F, 3.0F).setLightLevel((state) -> 14).sound(SoundType.METAL), true)))).collect(
                Collectors.toMap(Pair::getKey, Pair::getValue));

    public static final RegistryObject<GuardrailBlock> STEEL_GUARDRAIL = BLOCKS.register("steel_guardrail",
        () -> new GuardrailBlock(Block.Properties.create(Material.IRON, MaterialColor.BLACK).hardnessAndResistance(3.0F).sound(SoundType.LANTERN), ToolType.PICKAXE));
    public static final Map<DyeColor, RegistryObject<GuardrailBlock>> GUARDRAIL_BLOCKS = Arrays.stream(DyeColor.values()).map(type -> Pair.of(type,
        BLOCKS.register(type.getString() + "_guardrail",
            () -> new GuardrailBlock(Block.Properties.create(Material.IRON, type.getMapColor()).hardnessAndResistance(3.0F).sound(SoundType.LANTERN), ToolType.PICKAXE)))).collect(
                Collectors.toMap(Pair::getKey, Pair::getValue));

    public static final RegistryObject<PaintBucketBlock> PAINT_BUCKET = BLOCKS.register("paint_bucket",
        () -> new PaintBucketBlock(Block.Properties.create(Material.IRON, MaterialColor.GRAY).hardnessAndResistance(0.5F, 3.0F).sound(SoundType.LANTERN)));

    public static void init()
    {
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}