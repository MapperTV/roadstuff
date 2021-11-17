package tv.mapper.roadstuff.data.gen;

import java.util.Arrays;
import java.util.function.Consumer;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.DyeColor;
import net.minecraftforge.common.Tags;
import tv.mapper.mapperbase.data.BaseTags;
import tv.mapper.mapperbase.item.BaseItems;
import tv.mapper.roadstuff.block.RSBlockRegistry;
import tv.mapper.roadstuff.data.RSTags;
import tv.mapper.roadstuff.item.RSItemRegistry;

public class RSRecipes extends RecipeProvider
{
    public RSRecipes(DataGenerator generatorIn)
    {
        super(generatorIn);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer)
    {
        ShapedRecipeBuilder.shaped(RSBlockRegistry.ASPHALT_SLOPE.get(), 8).pattern("i ").pattern(" i").define('i', BaseTags.Items.ASPHALT).unlockedBy("has_asphalt", has(BaseTags.Items.ASPHALT)).save(consumer);
        ShapedRecipeBuilder.shaped(RSBlockRegistry.CONCRETE_SLOPE.get(), 8).pattern("i ").pattern(" i").define('i', BaseTags.Items.CONCRETE).unlockedBy("has_concrete", has(BaseTags.Items.CONCRETE)).save(consumer);

        for(int i = 0; i < Arrays.stream(DyeColor.values()).count(); i++)
        {
            ShapedRecipeBuilder.shaped(RSBlockRegistry.TRAFFIC_CONE_BLOCKS.get(DyeColor.byId(i)).get()).pattern(" D ").pattern("D D").pattern("BBB").define('B', BaseTags.ForgeItems.BITUMEN).define('D', DyeColor.byId(i).getTag()).unlockedBy("has_bitumen", has(BaseTags.ForgeItems.BITUMEN)).save(consumer);
            ShapedRecipeBuilder.shaped(RSBlockRegistry.TRAFFIC_BARREL_BLOCKS.get(DyeColor.byId(i)).get()).pattern("DDD").pattern("D D").pattern("BBB").define('B', BaseTags.ForgeItems.BITUMEN).define('D', DyeColor.byId(i).getTag()).unlockedBy("has_bitumen", has(BaseTags.ForgeItems.BITUMEN)).save(consumer);
            ShapedRecipeBuilder.shaped(RSBlockRegistry.TRAFFIC_BOLLARD_BLOCKS.get(DyeColor.byId(i)).get()).pattern(" D ").pattern(" D ").pattern("BBB").define('B', BaseTags.ForgeItems.BITUMEN).define('D', DyeColor.byId(i).getTag()).unlockedBy("has_bitumen", has(BaseTags.ForgeItems.BITUMEN)).save(consumer);

            ShapedRecipeBuilder.shaped(RSBlockRegistry.CYLINDRICAL_BOLLARD_BLOCKS.get(DyeColor.byId(i)).get()).pattern("D").pattern("R").pattern("D").define('R', RSTags.Items.REFLECTORS).define('D', DyeColor.byId(i).getTag()).unlockedBy("has_reflector", has(RSTags.Items.REFLECTORS)).save(consumer);

            ShapedRecipeBuilder.shaped(RSBlockRegistry.REFLECTOR_BLOCKS.get(DyeColor.byId(i)).get()).pattern("D").pattern("G").pattern("B").define('G', Tags.Items.DUSTS_GLOWSTONE).define('B', BaseItems.ASPHALT_ITEM.get()).define('D', DyeColor.byId(i).getTag()).unlockedBy("has_reflector", has(RSTags.Items.REFLECTORS)).save(consumer);
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

        ShapedRecipeBuilder.shaped(RSItemRegistry.PAINT_BRUSH.get()).pattern(" W").pattern("S ").define('W', ItemTags.WOOL).define('S', Tags.Items.RODS_WOODEN).unlockedBy("has_wool", has(ItemTags.WOOL)).save(consumer);

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
    }
}