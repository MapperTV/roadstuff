package tv.mapper.roadstuff.data.gen;

import java.util.Arrays;
import java.util.function.Consumer;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.data.recipes.UpgradeRecipeBuilder;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.Tags;
import tv.mapper.mapperbase.data.BaseTags;
import tv.mapper.mapperbase.data.gen.BaseRecipes;
import tv.mapper.roadstuff.RoadStuff;
import tv.mapper.roadstuff.block.RSBlockRegistry;
import tv.mapper.roadstuff.data.RSTags;
import tv.mapper.roadstuff.item.RSItemRegistry;

public class RSRecipes extends BaseRecipes
{
    public RSRecipes(DataGenerator generatorIn)
    {
        super(generatorIn);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer)
    {
        ShapedRecipeBuilder.shaped(RSBlockRegistry.ASPHALT_SLOPE.get(), 8).pattern("i ").pattern(" i").define('i', RSTags.Items.ASPHALT).unlockedBy("has_asphalt", has(RSTags.Items.ASPHALT)).save(consumer);
        ShapedRecipeBuilder.shaped(RSBlockRegistry.CONCRETE_SLOPE.get(), 8).pattern("i ").pattern(" i").define('i', RSTags.Items.CONCRETE).unlockedBy("has_concrete", has(RSTags.Items.CONCRETE)).save(consumer);
        // Asphalt

        ShapedRecipeBuilder.shaped(RSBlockRegistry.ASPHALT.get(), 4).define('G', Tags.Items.GRAVEL).define('B', RSTags.ForgeItems.BITUMEN).define('S', Tags.Items.SAND).pattern("SB").pattern("BG").unlockedBy("has_raw_bitumen", has(RSTags.ForgeItems.BITUMEN)).group("asphalt").save(consumer, RoadStuff.MODID + ":asphalt1");
        ShapedRecipeBuilder.shaped(RSBlockRegistry.ASPHALT.get(), 4).define('G', Tags.Items.GRAVEL).define('B', RSTags.ForgeItems.BITUMEN).define('S', Tags.Items.SAND).pattern("BS").pattern("GB").unlockedBy("has_raw_bitumen", has(RSTags.ForgeItems.BITUMEN)).group("asphalt").save(consumer, RoadStuff.MODID + ":asphalt2");
        ShapedRecipeBuilder.shaped(RSBlockRegistry.ASPHALT.get(), 4).define('G', Tags.Items.GRAVEL).define('B', RSTags.ForgeItems.BITUMEN).define('S', Tags.Items.SAND).pattern("GB").pattern("BS").unlockedBy("has_raw_bitumen", has(RSTags.ForgeItems.BITUMEN)).group("asphalt").save(consumer, RoadStuff.MODID + ":asphalt3");
        ShapedRecipeBuilder.shaped(RSBlockRegistry.ASPHALT.get(), 4).define('G', Tags.Items.GRAVEL).define('B', RSTags.ForgeItems.BITUMEN).define('S', Tags.Items.SAND).pattern("BG").pattern("SB").unlockedBy("has_raw_bitumen", has(RSTags.ForgeItems.BITUMEN)).group("asphalt").save(consumer, RoadStuff.MODID + ":asphalt4");
        ShapedRecipeBuilder.shaped(RSBlockRegistry.ASPHALT.get()).pattern("i").pattern("i").define('i', RSBlockRegistry.ASPHALT_SLAB.get()).unlockedBy("has_asphalt_slab", has(RSBlockRegistry.ASPHALT_SLAB.get())).save(consumer, RoadStuff.MODID + ":asphalt_block_from_slabs");
        ShapedRecipeBuilder.shaped(RSBlockRegistry.ASPHALT_SLAB.get(), 6).pattern("iii").define('i', RSTags.Items.ASPHALT).unlockedBy("has_asphalt_block", has(RSTags.Items.ASPHALT)).save(consumer);
        ShapedRecipeBuilder.shaped(RSBlockRegistry.ASPHALT_STAIRS.get(), 4).define('#', RSTags.Items.ASPHALT).pattern("#  ").pattern("## ").pattern("###").unlockedBy("has_asphalt_block", has(RSTags.Items.ASPHALT)).save(consumer);
        ShapedRecipeBuilder.shaped(RSBlockRegistry.ASPHALT_PRESSURE_PLATE.get()).define('#', RSTags.Items.ASPHALT).pattern("##").unlockedBy("has_asphalt_block", has(RSTags.Items.ASPHALT)).save(consumer);
        basicRecipes(consumer, RSBlockRegistry.ASPHALT.get(), RSBlockRegistry.ASPHALT_SLAB.get(), RSBlockRegistry.ASPHALT_STAIRS.get(), null, RSBlockRegistry.ASPHALT_PRESSURE_PLATE.get(), null, null, null);

        // Concrete blocks
        ShapedRecipeBuilder.shaped(RSBlockRegistry.CONCRETE.get(), 4).define('G', Tags.Items.GRAVEL).define('S', Tags.Items.SAND).pattern("GS").pattern("SG").unlockedBy("has_sand", has(Tags.Items.SAND)).unlockedBy("has_gravel", has(Tags.Items.GRAVEL)).save(consumer, RoadStuff.MODID + ":concrete_1");
        ShapedRecipeBuilder.shaped(RSBlockRegistry.CONCRETE.get(), 4).define('G', Tags.Items.GRAVEL).define('S', Tags.Items.SAND).pattern("GS").pattern("SG").unlockedBy("has_sand", has(Tags.Items.SAND)).unlockedBy("has_gravel", has(Tags.Items.GRAVEL)).save(consumer, RoadStuff.MODID + ":concrete_2");
        ShapedRecipeBuilder.shaped(RSBlockRegistry.CONCRETE_SLAB.get(), 6).pattern("iii").define('i', RSTags.Items.CONCRETE).unlockedBy("has_concrete_block", has(RSTags.Items.CONCRETE)).save(consumer);
        ShapedRecipeBuilder.shaped(RSBlockRegistry.CONCRETE.get()).pattern("i").pattern("i").define('i', RSBlockRegistry.CONCRETE_SLAB.get()).unlockedBy("has_concrete_slab", has(RSBlockRegistry.CONCRETE_SLAB.get())).save(consumer, RoadStuff.MODID + ":concrete_block_from_slabs");
        ShapedRecipeBuilder.shaped(RSBlockRegistry.CONCRETE_STAIRS.get(), 4).define('#', RSTags.Items.CONCRETE).pattern("#  ").pattern("## ").pattern("###").unlockedBy("has_concrete_block", has(RSTags.Items.CONCRETE)).save(consumer);
        ShapedRecipeBuilder.shaped(RSBlockRegistry.CONCRETE_WALL.get(), 6).define('#', RSTags.Items.CONCRETE).pattern("###").pattern("###").unlockedBy("has_concrete_block", has(RSTags.Items.CONCRETE)).save(consumer);
        ShapedRecipeBuilder.shaped(RSBlockRegistry.CONCRETE_PRESSURE_PLATE.get()).define('#', RSTags.Items.CONCRETE).pattern("##").unlockedBy("has_concrete_block", has(RSTags.Items.CONCRETE)).save(consumer);
        ShapedRecipeBuilder.shaped(RSBlockRegistry.CONCRETE_FENCE.get(), 3).pattern("isi").pattern("isi").define('i', RSTags.Items.CONCRETE).define('s', RSBlockRegistry.CONCRETE_SLAB.get()).unlockedBy("has_concrete", has(RSTags.Items.CONCRETE)).unlockedBy("has_concrete_slab", has(RSBlockRegistry.CONCRETE_SLAB.get())).save(consumer);
        ShapedRecipeBuilder.shaped(RSBlockRegistry.CONCRETE_FENCE_GATE.get()).pattern("sis").pattern("sis").define('i', RSTags.Items.CONCRETE).define('s', RSBlockRegistry.CONCRETE_SLAB.get()).unlockedBy("has_concrete", has(RSTags.Items.CONCRETE)).unlockedBy("has_concrete_slab", has(RSBlockRegistry.CONCRETE_SLAB.get())).save(consumer);
        basicRecipes(consumer, RSBlockRegistry.CONCRETE.get(), RSBlockRegistry.CONCRETE_SLAB.get(), RSBlockRegistry.CONCRETE_STAIRS.get(), RSBlockRegistry.CONCRETE_WALL.get(), RSBlockRegistry.CONCRETE_PRESSURE_PLATE.get(), null, RSBlockRegistry.CONCRETE_FENCE.get(), RSBlockRegistry.CONCRETE_FENCE_GATE.get());

        for(int i = 0; i < Arrays.stream(DyeColor.values()).count(); i++)
        {
            ShapedRecipeBuilder.shaped(RSBlockRegistry.TRAFFIC_CONE_BLOCKS.get(DyeColor.byId(i)).get()).pattern(" D ").pattern("D D").pattern("BBB").define('B', RSTags.ForgeItems.BITUMEN).define('D', DyeColor.byId(i).getTag()).unlockedBy("has_bitumen", has(RSTags.ForgeItems.BITUMEN)).save(consumer);
            ShapedRecipeBuilder.shaped(RSBlockRegistry.TRAFFIC_BARREL_BLOCKS.get(DyeColor.byId(i)).get()).pattern("DDD").pattern("D D").pattern("BBB").define('B', RSTags.ForgeItems.BITUMEN).define('D', DyeColor.byId(i).getTag()).unlockedBy("has_bitumen", has(RSTags.ForgeItems.BITUMEN)).save(consumer);
            ShapedRecipeBuilder.shaped(RSBlockRegistry.TRAFFIC_BOLLARD_BLOCKS.get(DyeColor.byId(i)).get()).pattern(" D ").pattern(" D ").pattern("BBB").define('B', RSTags.ForgeItems.BITUMEN).define('D', DyeColor.byId(i).getTag()).unlockedBy("has_bitumen", has(RSTags.ForgeItems.BITUMEN)).save(consumer);

            ShapedRecipeBuilder.shaped(RSBlockRegistry.CYLINDRICAL_BOLLARD_BLOCKS.get(DyeColor.byId(i)).get()).pattern("D").pattern("R").pattern("D").define('R', RSTags.Items.REFLECTORS).define('D', DyeColor.byId(i).getTag()).unlockedBy("has_reflector", has(RSTags.Items.REFLECTORS)).save(consumer);

            ShapelessRecipeBuilder.shapeless(RSBlockRegistry.REFLECTOR_BLOCKS.get(DyeColor.byId(i)).get(), 4).requires(Tags.Items.GEMS_QUARTZ).requires(RSItemRegistry.RAW_BITUMEN.get()).requires(DyeColor.byId(i).getTag()).unlockedBy("has_reflector", has(RSTags.Items.REFLECTORS)).save(consumer);
            ShapelessRecipeBuilder.shapeless(RSBlockRegistry.LUMINESCENT_REFLECTOR_BLOCKS.get(DyeColor.byId(i)).get()).requires(RSBlockRegistry.REFLECTOR_BLOCKS.get(DyeColor.byId(i)).get()).requires(Tags.Items.DUSTS_GLOWSTONE).unlockedBy("has_" + DyeColor.byId(i).getSerializedName() + "_reflector", has(RSBlockRegistry.LUMINESCENT_REFLECTOR_BLOCKS.get(DyeColor.byId(i)).get())).save(consumer);

            ShapelessRecipeBuilder.shapeless(RSBlockRegistry.GUARDRAIL_BLOCKS.get(DyeColor.byId(i)).get()).requires(RSBlockRegistry.STEEL_GUARDRAIL.get()).requires(DyeColor.byId(i).getTag()).unlockedBy("has_steel_reflector", has(RSBlockRegistry.STEEL_GUARDRAIL.get())).save(consumer);
        }

        ShapedRecipeBuilder.shaped(RSBlockRegistry.STEEL_GUARDRAIL.get(), 8).pattern("PPP").pattern(" R ").define('P', BaseTags.ForgeItems.PLATES_STEEL).define('R', BaseTags.ForgeItems.RODS_STEEL).unlockedBy("has_steel_plate", has(BaseTags.ForgeItems.PLATES_STEEL)).save(consumer);

        ShapedRecipeBuilder.shaped(RSBlockRegistry.RED_BOLLARD.get()).pattern("R").pattern("S").pattern("S").define('S', Tags.Items.RODS_WOODEN).define('R', RSBlockRegistry.REFLECTOR_BLOCKS.get(DyeColor.RED).get()).unlockedBy("has_stick", has(Tags.Items.RODS_WOODEN)).save(consumer);
        ShapedRecipeBuilder.shaped(RSBlockRegistry.WHITE_BOLLARD.get()).pattern("R").pattern("S").pattern("S").define('S', Tags.Items.RODS_WOODEN).define('R', RSBlockRegistry.REFLECTOR_BLOCKS.get(DyeColor.WHITE).get()).unlockedBy("has_stick", has(Tags.Items.RODS_WOODEN)).save(consumer);
        ShapedRecipeBuilder.shaped(RSBlockRegistry.YELLOW_BOLLARD.get()).pattern("R").pattern("S").pattern("S").define('S', Tags.Items.RODS_WOODEN).define('R', RSBlockRegistry.REFLECTOR_BLOCKS.get(DyeColor.YELLOW).get()).unlockedBy("has_stick", has(Tags.Items.RODS_WOODEN)).save(consumer);

        ShapedRecipeBuilder.shaped(RSBlockRegistry.RED_SMALL_BOLLARD.get()).pattern("R").pattern("S").define('S', Tags.Items.RODS_WOODEN).define('R', RSBlockRegistry.REFLECTOR_BLOCKS.get(DyeColor.RED).get()).unlockedBy("has_stick", has(Tags.Items.RODS_WOODEN)).save(consumer);
        ShapedRecipeBuilder.shaped(RSBlockRegistry.WHITE_SMALL_BOLLARD.get()).pattern("R").pattern("S").define('S', Tags.Items.RODS_WOODEN).define('R', RSBlockRegistry.REFLECTOR_BLOCKS.get(DyeColor.WHITE).get()).unlockedBy("has_stick", has(Tags.Items.RODS_WOODEN)).save(consumer);
        ShapedRecipeBuilder.shaped(RSBlockRegistry.YELLOW_SMALL_BOLLARD.get()).pattern("R").pattern("S").define('S', Tags.Items.RODS_WOODEN).define('R', RSBlockRegistry.REFLECTOR_BLOCKS.get(DyeColor.YELLOW).get()).unlockedBy("has_stick", has(Tags.Items.RODS_WOODEN)).save(consumer);

        ShapedRecipeBuilder.shaped(RSBlockRegistry.PAINT_BUCKET.get()).pattern("I I").pattern("I I").pattern(" I ").define('I', Tags.Items.INGOTS_IRON).unlockedBy("has_iron_ingot", has(Tags.Items.INGOTS_IRON)).save(consumer);

        ShapedRecipeBuilder.shaped(RSItemRegistry.WOODEN_PAINT_BRUSH.get()).pattern(" W").pattern("S ").define('W', ItemTags.WOOL).define('S', Tags.Items.RODS_WOODEN).unlockedBy("has_wool", has(ItemTags.WOOL)).save(consumer);
        ShapedRecipeBuilder.shaped(RSItemRegistry.STONE_PAINT_BRUSH.get()).pattern(" W").pattern("S ").define('W', RSItemRegistry.WOODEN_PAINT_BRUSH.get()).define('S', Tags.Items.COBBLESTONE).unlockedBy("has_cobblestone", has(Tags.Items.COBBLESTONE)).save(consumer);
        ShapedRecipeBuilder.shaped(RSItemRegistry.IRON_PAINT_BRUSH.get()).pattern(" W").pattern("S ").define('W', RSItemRegistry.STONE_PAINT_BRUSH.get()).define('S', Tags.Items.INGOTS_IRON).unlockedBy("has_iron", has(Tags.Items.INGOTS_IRON)).save(consumer);
        ShapedRecipeBuilder.shaped(RSItemRegistry.GOLDEN_PAINT_BRUSH.get()).pattern(" W").pattern("S ").define('W', RSItemRegistry.IRON_PAINT_BRUSH.get()).define('S', Tags.Items.INGOTS_GOLD).unlockedBy("has_gold", has(Tags.Items.INGOTS_GOLD)).save(consumer);
        ShapedRecipeBuilder.shaped(RSItemRegistry.STEEL_PAINT_BRUSH.get()).pattern(" W").pattern("S ").define('W', RSItemRegistry.IRON_PAINT_BRUSH.get()).define('S', BaseTags.ForgeItems.INGOTS_STEEL).unlockedBy("has_steel", has(BaseTags.ForgeItems.INGOTS_STEEL)).save(consumer);
        ShapedRecipeBuilder.shaped(RSItemRegistry.DIAMOND_PAINT_BRUSH.get()).pattern(" W").pattern("S ").define('W', RSItemRegistry.GOLDEN_PAINT_BRUSH.get()).define('S', Tags.Items.GEMS_DIAMOND).unlockedBy("has_diamond", has(Tags.Items.GEMS_DIAMOND)).save(consumer);
        ShapedRecipeBuilder.shaped(RSItemRegistry.DIAMOND_PAINT_BRUSH.get()).pattern(" W").pattern("S ").define('W', RSItemRegistry.STEEL_PAINT_BRUSH.get()).define('S', Tags.Items.GEMS_DIAMOND).unlockedBy("has_diamond", has(Tags.Items.GEMS_DIAMOND)).save(consumer, "diamond_brush_from_steel");

        UpgradeRecipeBuilder.smithing(Ingredient.of(RSItemRegistry.DIAMOND_PAINT_BRUSH.get()), Ingredient.of(Items.NETHERITE_INGOT), RSItemRegistry.NETHERITE_PAINT_BRUSH.get()).unlocks("has_netherite_ingot", has(Items.NETHERITE_INGOT)).save(consumer, "netherite_brush_smithing");

        for(int j = 1; j < Arrays.stream(DyeColor.values()).count(); j++)
        {
            ShapelessRecipeBuilder.shapeless(RSBlockRegistry.TRAFFIC_CONE_BLOCKS.get(DyeColor.byId(j)).get()).requires(RSBlockRegistry.TRAFFIC_CONE_BLOCKS.get(DyeColor.WHITE).get()).requires(DyeColor.byId(j).getTag()).unlockedBy("has_white_traffic_cone", has(RSBlockRegistry.TRAFFIC_CONE_BLOCKS.get(DyeColor.WHITE).get())).save(consumer, DyeColor.byId(j).getSerializedName() + "_traffic_cone_from_white");
            ShapelessRecipeBuilder.shapeless(RSBlockRegistry.TRAFFIC_BARREL_BLOCKS.get(DyeColor.byId(j)).get()).requires(RSBlockRegistry.TRAFFIC_BARREL_BLOCKS.get(DyeColor.WHITE).get()).requires(DyeColor.byId(j).getTag()).unlockedBy("has_white_traffic_barrel", has(RSBlockRegistry.TRAFFIC_BARREL_BLOCKS.get(DyeColor.WHITE).get())).save(consumer, DyeColor.byId(j).getSerializedName() + "_traffic_barrel_from_white");
            ShapelessRecipeBuilder.shapeless(RSBlockRegistry.TRAFFIC_BOLLARD_BLOCKS.get(DyeColor.byId(j)).get()).requires(RSBlockRegistry.TRAFFIC_BOLLARD_BLOCKS.get(DyeColor.WHITE).get()).requires(DyeColor.byId(j).getTag()).unlockedBy("has_white_traffic_bollard", has(RSBlockRegistry.TRAFFIC_BOLLARD_BLOCKS.get(DyeColor.WHITE).get())).save(consumer, DyeColor.byId(j).getSerializedName() + "_traffic_bollard_from_white");
            ShapelessRecipeBuilder.shapeless(RSBlockRegistry.CYLINDRICAL_BOLLARD_BLOCKS.get(DyeColor.byId(j)).get()).requires(RSBlockRegistry.CYLINDRICAL_BOLLARD_BLOCKS.get(DyeColor.WHITE).get()).requires(DyeColor.byId(j).getTag()).unlockedBy("has_white_cylindrical_bollard", has(RSBlockRegistry.CYLINDRICAL_BOLLARD_BLOCKS.get(DyeColor.WHITE).get())).save(consumer, DyeColor.byId(j).getSerializedName() + "_cylindrical_bollard_from_white");
            ShapelessRecipeBuilder.shapeless(RSBlockRegistry.REFLECTOR_BLOCKS.get(DyeColor.byId(j)).get()).requires(RSBlockRegistry.REFLECTOR_BLOCKS.get(DyeColor.WHITE).get()).requires(DyeColor.byId(j).getTag()).unlockedBy("has_white_reflector", has(RSBlockRegistry.REFLECTOR_BLOCKS.get(DyeColor.WHITE).get())).save(consumer, DyeColor.byId(j).getSerializedName() + "_reflector_from_white");
            ShapelessRecipeBuilder.shapeless(RSBlockRegistry.LUMINESCENT_REFLECTOR_BLOCKS.get(DyeColor.byId(j)).get()).requires(RSBlockRegistry.LUMINESCENT_REFLECTOR_BLOCKS.get(DyeColor.WHITE).get()).requires(DyeColor.byId(j).getTag()).unlockedBy("has_white_luminescent_reflector", has(RSBlockRegistry.LUMINESCENT_REFLECTOR_BLOCKS.get(DyeColor.WHITE).get())).save(consumer, DyeColor.byId(j).getSerializedName() + "_luminescent_reflector_from_white");
            ShapelessRecipeBuilder.shapeless(RSBlockRegistry.GUARDRAIL_BLOCKS.get(DyeColor.byId(j)).get()).requires(RSBlockRegistry.GUARDRAIL_BLOCKS.get(DyeColor.WHITE).get()).requires(DyeColor.byId(j).getTag()).unlockedBy("has_white_guardrail", has(RSBlockRegistry.GUARDRAIL_BLOCKS.get(DyeColor.WHITE).get())).save(consumer, DyeColor.byId(j).getSerializedName() + "_guardrail_from_white");
        }

        ShapedRecipeBuilder.shaped(RSBlockRegistry.BITUMEN_BLOCK.get()).pattern("xxx").pattern("xxx").pattern("xxx").define('x', RSTags.ForgeItems.BITUMEN).unlockedBy("has_raw_bitumen", has(RSTags.ForgeItems.BITUMEN)).save(consumer);
        ShapelessRecipeBuilder.shapeless(RSItemRegistry.RAW_BITUMEN.get(), 9).requires(RSTags.ForgeItems.STORAGE_BLOCKS_BITUMEN).unlockedBy("has_bitumen_block", has(RSTags.ForgeItems.STORAGE_BLOCKS_BITUMEN)).save(consumer, RoadStuff.MODID + ":raw_bitumen_from_block");

        // Ore
        SimpleCookingRecipeBuilder.blasting(Ingredient.of(RSItemRegistry.BITUMEN_ORE_ITEM.get()), RSItemRegistry.RAW_BITUMEN.get(), 0.1f, 100).unlockedBy("has_bitumen_ore", has(RSItemRegistry.BITUMEN_ORE_ITEM.get())).save(consumer, RoadStuff.MODID + ":raw_bitumen_from_blasting");
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(RSItemRegistry.BITUMEN_ORE_ITEM.get()), RSItemRegistry.RAW_BITUMEN.get(), 0.1f, 200).unlockedBy("has_bitumen_ore", has(RSItemRegistry.BITUMEN_ORE_ITEM.get())).save(consumer, RoadStuff.MODID + ":raw_bitumen_from_smelting");

        // Others
        ShapedRecipeBuilder.shaped(RSItemRegistry.BITUMINOUS_COAL.get(), 8).pattern("xxx").pattern("xyx").pattern("xxx").define('x', RSTags.ForgeItems.BITUMEN).define('y', Items.COAL).unlockedBy("has_raw_bitumen", has(RSTags.ForgeItems.BITUMEN)).unlockedBy("has_coal", has(Items.COAL)).save(consumer);
    }
}