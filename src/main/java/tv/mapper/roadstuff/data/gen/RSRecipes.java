package tv.mapper.roadstuff.data.gen;

import java.util.function.Consumer;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.RecipeProvider;

public class RSRecipes extends RecipeProvider
{
    public RSRecipes(DataGenerator generatorIn)
    {
        super(generatorIn);
    }

    @Override
    protected void registerRecipes(Consumer<IFinishedRecipe> consumer)
    {
        // ShapedRecipeBuilder.shapedRecipe(BaseItems.BOLT).patternLine("x").patternLine("x").key('x', BaseTags.ForgeItems.NUGGETS_STEEL).addCriterion("has_steel_nugget",
        // this.hasItem(BaseTags.ForgeItems.NUGGETS_STEEL)).build(consumer);
        // ShapedRecipeBuilder.shapedRecipe(BaseItems.FLATTER_HAMMER).patternLine("i").patternLine("/").key('i', BaseTags.ForgeItems.INGOTS_STEEL).key('/', Items.STICK).addCriterion("has_steel_ingot",
        // this.hasItem(BaseTags.ForgeItems.INGOTS_STEEL)).addCriterion("has_stick", this.hasItem(Items.STICK)).build(consumer);
        //
        // // Steel blocks
        // ShapedRecipeBuilder.shapedRecipe(BaseBlocks.STEEL_SLAB, 6).patternLine("iii").key('i', BaseTags.ForgeItems.STORAGE_BLOCKS_STEEL).addCriterion("has_steel_block",
        // this.hasItem(BaseTags.ForgeItems.STORAGE_BLOCKS_STEEL)).build(consumer);
        // ShapedRecipeBuilder.shapedRecipe(BaseBlocks.STEEL_BLOCK).patternLine("i").patternLine("i").key('i', BaseBlocks.STEEL_SLAB).addCriterion("has_steel_slab",
        // this.hasItem(BaseBlocks.STEEL_SLAB)).build(consumer, "mapperbase:steel_block_from_slabs");
        // ShapedRecipeBuilder.shapedRecipe(BaseBlocks.STEEL_STAIRS, 4).key('#', BaseTags.ForgeItems.STORAGE_BLOCKS_STEEL).patternLine("# ").patternLine("## ").patternLine("###").addCriterion(
        // "has_steel_block", this.hasItem(BaseTags.ForgeItems.STORAGE_BLOCKS_STEEL)).build(consumer);
        // ShapedRecipeBuilder.shapedRecipe(BaseBlocks.STEEL_WALL, 6).key('#', BaseTags.ForgeItems.STORAGE_BLOCKS_STEEL).patternLine("###").patternLine("###").addCriterion("has_steel_block",
        // this.hasItem(BaseTags.ForgeItems.STORAGE_BLOCKS_STEEL)).build(consumer);
        // ShapedRecipeBuilder.shapedRecipe(BaseBlocks.STEEL_PRESSURE_PLATE).key('#', BaseTags.ForgeItems.STORAGE_BLOCKS_STEEL).patternLine("##").addCriterion("has_steel_block",
        // this.hasItem(BaseTags.ForgeItems.STORAGE_BLOCKS_STEEL)).build(consumer);
        // ShapedRecipeBuilder.shapedRecipe(BaseBlocks.STEEL_FENCE, 3).patternLine("isi").patternLine("isi").key('i', BaseTags.ForgeItems.INGOTS_STEEL).key('s',
        // BaseTags.ForgeItems.RODS_STEEL).addCriterion("has_steel_ingot", this.hasItem(BaseTags.ForgeItems.INGOTS_STEEL)).addCriterion("has_steel_rod",
        // this.hasItem(BaseTags.ForgeItems.RODS_STEEL)).build(consumer);
        //
        // // Concrete blocks
        // ShapedRecipeBuilder.shapedRecipe(BaseBlocks.CONCRETE, 4).key('G', Tags.Items.GRAVEL).key('S', Tags.Items.SAND).patternLine("GS").patternLine("SG").addCriterion("has_sand",
        // this.hasItem(Tags.Items.SAND)).addCriterion("has_gravel", this.hasItem(Tags.Items.GRAVEL)).build(consumer, MapperBase.MODID + ":concrete_1");
        // ShapedRecipeBuilder.shapedRecipe(BaseBlocks.CONCRETE, 4).key('G', Tags.Items.GRAVEL).key('S', Tags.Items.SAND).patternLine("GS").patternLine("SG").addCriterion("has_sand",
        // this.hasItem(Tags.Items.SAND)).addCriterion("has_gravel", this.hasItem(Tags.Items.GRAVEL)).build(consumer, MapperBase.MODID + ":concrete_2");
        // ShapedRecipeBuilder.shapedRecipe(BaseBlocks.CONCRETE_SLAB, 6).patternLine("iii").key('i', BaseTags.Items.CONCRETE).addCriterion("has_concrete_block",
        // this.hasItem(BaseTags.Items.CONCRETE)).build(consumer);
        // ShapedRecipeBuilder.shapedRecipe(BaseBlocks.CONCRETE).patternLine("i").patternLine("i").key('i', BaseBlocks.CONCRETE_SLAB).addCriterion("has_concrete_slab",
        // this.hasItem(BaseBlocks.CONCRETE_SLAB)).build(consumer, MapperBase.MODID + ":concrete_block_from_slabs");
        // ShapedRecipeBuilder.shapedRecipe(BaseBlocks.CONCRETE_STAIRS, 4).key('#', BaseTags.Items.CONCRETE).patternLine("# ").patternLine("## ").patternLine("###").addCriterion("has_concrete_block",
        // this.hasItem(BaseTags.Items.CONCRETE)).build(consumer);
        // ShapedRecipeBuilder.shapedRecipe(BaseBlocks.CONCRETE_WALL, 6).key('#', BaseTags.Items.CONCRETE).patternLine("###").patternLine("###").addCriterion("has_concrete_block",
        // this.hasItem(BaseTags.Items.CONCRETE)).build(consumer);
        // ShapedRecipeBuilder.shapedRecipe(BaseBlocks.CONCRETE_PRESSURE_PLATE).key('#', BaseTags.Items.CONCRETE).patternLine("##").addCriterion("has_concrete_block",
        // this.hasItem(BaseTags.Items.CONCRETE)).build(consumer);
        //
        // // Rods
        // ShapedRecipeBuilder.shapedRecipe(BaseItems.IRON_ROD, 4).patternLine("x").patternLine("x").key('x', Tags.Items.INGOTS_IRON).addCriterion("has_iron_ingot",
        // this.hasItem(Items.IRON_INGOT)).build(
        // consumer);
        // ShapedRecipeBuilder.shapedRecipe(BaseItems.STEEL_ROD, 4).patternLine("x").patternLine("x").key('x', BaseTags.ForgeItems.INGOTS_STEEL).addCriterion("has_steel_ingot",
        // this.hasItem(BaseTags.ForgeItems.INGOTS_STEEL)).build(consumer);
        //
        // // Blasting iron to steel
        // CookingRecipeBuilder.blastingRecipe(Ingredient.fromTag(Tags.Items.INGOTS_IRON), BaseItems.STEEL_INGOT, 1.0f, 120).addCriterion("has_iron_ingot", this.hasItem(Tags.Items.INGOTS_IRON)).build(
        // consumer, MapperBase.MODID + ":steel_ingot_from_blasting");
        // CookingRecipeBuilder.blastingRecipe(Ingredient.fromTag(Tags.Items.STORAGE_BLOCKS_IRON), BaseBlocks.STEEL_BLOCK, 2.0f, 960).addCriterion("has_iron_block",
        // this.hasItem(Tags.Items.STORAGE_BLOCKS_IRON)).build(consumer, MapperBase.MODID + ":steel_block_from_blasting");
        // CookingRecipeBuilder.blastingRecipe(Ingredient.fromTag(BaseTags.ForgeItems.PLATES_IRON), BaseItems.STEEL_PLATE, 1.0f, 120).addCriterion("has_iron_plate",
        // this.hasItem(BaseTags.ForgeItems.PLATES_IRON)).build(consumer, MapperBase.MODID + ":steel_plate_from_blasting");
        // CookingRecipeBuilder.blastingRecipe(Ingredient.fromTag(BaseTags.ForgeItems.RODS_IRON), BaseItems.STEEL_ROD, 1.0f, 120).addCriterion("has_iron_rod",
        // this.hasItem(BaseTags.ForgeItems.RODS_IRON)).build(consumer, MapperBase.MODID + ":steel_rod_from_blasting");
        //
        // // Metal plates
        // ShapelessRecipeBuilder.shapelessRecipe(BaseItems.IRON_PLATE).addIngredient(Tags.Items.INGOTS_IRON).addIngredient(BaseItems.FLATTER_HAMMER).addCriterion("has_iron_ingot",
        // this.hasItem(Tags.Items.INGOTS_IRON)).build(consumer);
        // ShapelessRecipeBuilder.shapelessRecipe(BaseItems.STEEL_PLATE).addIngredient(BaseTags.ForgeItems.INGOTS_STEEL).addIngredient(BaseItems.FLATTER_HAMMER).addCriterion("has_steel_ingot",
        // this.hasItem(BaseTags.ForgeItems.INGOTS_STEEL)).build(consumer);
        //
        // // Nugget to ingot and vice-versa
        // ShapedRecipeBuilder.shapedRecipe(BaseItems.STEEL_INGOT).patternLine("xxx").patternLine("xxx").patternLine("xxx").key('x', BaseTags.ForgeItems.NUGGETS_STEEL).addCriterion("has_steel_nugget",
        // this.hasItem(BaseTags.ForgeItems.NUGGETS_STEEL)).setGroup("steel_ingot").build(consumer);
        // ShapelessRecipeBuilder.shapelessRecipe(BaseItems.STEEL_NUGGET, 9).addIngredient(BaseTags.ForgeItems.INGOTS_STEEL).addCriterion("has_steel_ingot",
        // this.hasItem(BaseTags.ForgeItems.INGOTS_STEEL)).build(consumer, MapperBase.MODID + ":steel_nugget_from_ingot");
        //
        // // Ingot to block and vice-versa
        // ShapedRecipeBuilder.shapedRecipe(BaseBlocks.STEEL_BLOCK).patternLine("xxx").patternLine("xxx").patternLine("xxx").key('x', BaseTags.ForgeItems.INGOTS_STEEL).addCriterion("has_steel_ingot",
        // this.hasItem(BaseTags.ForgeItems.INGOTS_STEEL)).build(consumer);
        // ShapelessRecipeBuilder.shapelessRecipe(BaseItems.STEEL_INGOT, 9).addIngredient(BaseTags.ForgeItems.STORAGE_BLOCKS_STEEL).addCriterion("has_steel_block",
        // this.hasItem(BaseTags.ForgeItems.STORAGE_BLOCKS_STEEL)).setGroup("steel_ingot").build(consumer, MapperBase.MODID + ":steel_ingot_from_block");
        //
        // // Tools
        //
        // ShapedRecipeBuilder.shapedRecipe(BaseItems.STEEL_AXE).key('#', Items.STICK).key('X', BaseTags.ForgeItems.INGOTS_STEEL).patternLine("XX").patternLine("X#").patternLine(" #").addCriterion(
        // "has_steel_ingot", this.hasItem(BaseTags.ForgeItems.INGOTS_STEEL)).build(consumer);
        // ShapedRecipeBuilder.shapedRecipe(BaseItems.STEEL_PICKAXE).key('#', Items.STICK).key('X', BaseTags.ForgeItems.INGOTS_STEEL).patternLine("XXX").patternLine(" # ").patternLine(
        // " # ").addCriterion("has_steel_ingot", this.hasItem(BaseTags.ForgeItems.INGOTS_STEEL)).build(consumer);
        // ShapedRecipeBuilder.shapedRecipe(BaseItems.STEEL_SHOVEL).key('#', Items.STICK).key('X', BaseTags.ForgeItems.INGOTS_STEEL).patternLine("X").patternLine("#").patternLine("#").addCriterion(
        // "has_steel_ingot", this.hasItem(BaseTags.ForgeItems.INGOTS_STEEL)).build(consumer);
        // ShapedRecipeBuilder.shapedRecipe(BaseItems.STEEL_SWORD).key('#', Items.STICK).key('X', BaseTags.ForgeItems.INGOTS_STEEL).patternLine("X").patternLine("X").patternLine("#").addCriterion(
        // "has_steel_ingot", this.hasItem(BaseTags.ForgeItems.INGOTS_STEEL)).build(consumer);
        // ShapedRecipeBuilder.shapedRecipe(BaseItems.STEEL_HOE).key('#', Items.STICK).key('X', BaseTags.ForgeItems.INGOTS_STEEL).patternLine("XX").patternLine(" #").patternLine(" #").addCriterion(
        // "has_steel_ingot", this.hasItem(BaseTags.ForgeItems.INGOTS_STEEL)).build(consumer);
        //
        // ShapedRecipeBuilder.shapedRecipe(BaseItems.STEEL_BOOTS).key('X', BaseTags.ForgeItems.INGOTS_STEEL).patternLine("X X").patternLine("X X").addCriterion("has_steel",
        // this.hasItem(BaseTags.ForgeItems.INGOTS_STEEL)).build(consumer);
        // ShapedRecipeBuilder.shapedRecipe(BaseItems.STEEL_CHESTPLATE).key('X', BaseTags.ForgeItems.INGOTS_STEEL).patternLine("X X").patternLine("XXX").patternLine("XXX").addCriterion("has_steel",
        // this.hasItem(BaseTags.ForgeItems.INGOTS_STEEL)).build(consumer);
        // ShapedRecipeBuilder.shapedRecipe(BaseItems.STEEL_HELMET).key('X', BaseTags.ForgeItems.INGOTS_STEEL).patternLine("XXX").patternLine("X X").addCriterion("has_steel",
        // this.hasItem(BaseTags.ForgeItems.INGOTS_STEEL)).build(consumer);
        // ShapedRecipeBuilder.shapedRecipe(BaseItems.STEEL_LEGGINGS).key('X', BaseTags.ForgeItems.INGOTS_STEEL).patternLine("XXX").patternLine("X X").patternLine("X X").addCriterion("has_steel",
        // this.hasItem(BaseTags.ForgeItems.INGOTS_STEEL)).build(consumer);
        //
        // CookingRecipeBuilder.blastingRecipe(Ingredient.fromItems(Items.IRON_NUGGET, BaseItems.STEEL_PICKAXE, BaseItems.STEEL_SHOVEL, BaseItems.STEEL_AXE, BaseItems.STEEL_HOE, BaseItems.STEEL_SWORD,
        // BaseItems.STEEL_HELMET, BaseItems.STEEL_CHESTPLATE, BaseItems.STEEL_LEGGINGS, BaseItems.STEEL_BOOTS, BaseItems.STEEL_HORSE_ARMOR), BaseItems.STEEL_NUGGET, 0.1F, 100).addCriterion(
        // "has_iron_nugget", this.hasItem(Items.IRON_NUGGET)).addCriterion("has_steel_pickaxe", this.hasItem(BaseItems.STEEL_PICKAXE)).addCriterion("has_steel_shovel",
        // this.hasItem(BaseItems.STEEL_SHOVEL)).addCriterion("has_steel_axe", this.hasItem(BaseItems.STEEL_AXE)).addCriterion("has_steel_hoe",
        // this.hasItem(BaseItems.STEEL_HOE)).addCriterion("has_steel_sword", this.hasItem(BaseItems.STEEL_SWORD)).addCriterion("has_steel_helmet",
        // this.hasItem(BaseItems.STEEL_HELMET)).addCriterion("has_steel_chestplate", this.hasItem(BaseItems.STEEL_CHESTPLATE)).addCriterion("has_steel_leggings",
        // this.hasItem(BaseItems.STEEL_LEGGINGS)).addCriterion("has_steel_boots", this.hasItem(BaseItems.STEEL_BOOTS)).addCriterion("has_steel_horse_armor",
        // this.hasItem(BaseItems.STEEL_HORSE_ARMOR)).build(consumer, MapperBase.MODID + ":steel_nugget_from_blasting");

    }

}
