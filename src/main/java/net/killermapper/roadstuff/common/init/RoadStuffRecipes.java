package net.killermapper.roadstuff.common.init;

import cpw.mods.fml.common.registry.GameRegistry;
import net.killermapper.roadstuff.common.blocks.RoadStuffBlocks;
import net.killermapper.roadstuff.common.items.RoadStuffItems;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class RoadStuffRecipes
{
    public static void initRecipes()
    {
        initOreDict();

        // Base blocs
        GameRegistry.addRecipe(new ItemStack(RoadStuffBlocks.blockAsphaltBase01, 4, 0), new Object[] {"XY", "ZX", 'X', new ItemStack(RoadStuffItems.itemBitumen, 1, 1), 'Y', Blocks.sand, 'Z', Blocks.gravel});
        GameRegistry.addRecipe(new ItemStack(RoadStuffBlocks.blockAsphaltBase01, 1, 1), new Object[] {"Y", "X", 'X', new ItemStack(RoadStuffBlocks.blockAsphaltBase01, 1, 0), 'Y', Blocks.heavy_weighted_pressure_plate});
        GameRegistry.addRecipe(new ItemStack(RoadStuffBlocks.blockConcrete, 1, 1), new Object[] {"Y", "X", 'X', new ItemStack(RoadStuffBlocks.blockConcrete, 1, 0), 'Y', Blocks.heavy_weighted_pressure_plate});

        // Line blocks to base block
        for(int i = 0; i <= 5; i++)
        {
            GameRegistry.addRecipe(new ItemStack(RoadStuffBlocks.blockAsphaltBase01, 1, 0), new Object[] {"X", 'X', new ItemStack(RoadStuffBlocks.blockAsphaltLines01, 1, i)});
            GameRegistry.addRecipe(new ItemStack(RoadStuffBlocks.blockConcrete, 1, 0), new Object[] {"X", 'X', new ItemStack(RoadStuffBlocks.blockConcreteLine, 1, i)});
        }

        for(int i = 0; i <= 3; i++)
        {
            GameRegistry.addRecipe(new ItemStack(RoadStuffBlocks.blockAsphaltBase01, 1, 0), new Object[] {"X", 'X', new ItemStack(RoadStuffBlocks.blockAsphaltLines02, 1, i)});
            GameRegistry.addRecipe(new ItemStack(RoadStuffBlocks.blockAsphaltBase01, 1, 0), new Object[] {"X", 'X', new ItemStack(RoadStuffBlocks.blockAsphaltLines03, 1, i)});
            GameRegistry.addRecipe(new ItemStack(RoadStuffBlocks.blockAsphaltBase01, 1, 0), new Object[] {"X", 'X', new ItemStack(RoadStuffBlocks.blockAsphaltLines04, 1, i)});
            GameRegistry.addRecipe(new ItemStack(RoadStuffBlocks.blockAsphaltBase01, 1, 0), new Object[] {"X", 'X', new ItemStack(RoadStuffBlocks.blockAsphaltLines05, 1, i)});
            GameRegistry.addRecipe(new ItemStack(RoadStuffBlocks.blockAsphaltBase01, 1, 0), new Object[] {"X", 'X', new ItemStack(RoadStuffBlocks.blockAsphaltLinesCorner01, 1, i)});
            GameRegistry.addRecipe(new ItemStack(RoadStuffBlocks.blockConcrete, 1, 0), new Object[] {"X", 'X', new ItemStack(RoadStuffBlocks.blockConcreteCorner, 1, i)});
            GameRegistry.addRecipe(new ItemStack(RoadStuffBlocks.blockConcrete, 1, 0), new Object[] {"X", 'X', new ItemStack(RoadStuffBlocks.blockConcreteXCross, 1, i)});
            GameRegistry.addRecipe(new ItemStack(RoadStuffBlocks.blockConcrete, 1, 0), new Object[] {"X", 'X', new ItemStack(RoadStuffBlocks.blockConcreteXCrossYellow, 1, i)});
            GameRegistry.addRecipe(new ItemStack(RoadStuffBlocks.blockConcrete, 1, 0), new Object[] {"X", 'X', new ItemStack(RoadStuffBlocks.blockConcreteYCross, 1, i)});
            GameRegistry.addRecipe(new ItemStack(RoadStuffBlocks.blockConcrete, 1, 0), new Object[] {"X", 'X', new ItemStack(RoadStuffBlocks.blockConcreteYCrossYellow, 1, i)});
        }

        // Slabs
        GameRegistry.addRecipe(new ItemStack(RoadStuffBlocks.singleSlabAsphaltBase01, 6, 0), new Object[] {"XXX", 'X', new ItemStack(RoadStuffBlocks.blockAsphaltBase01, 1, 0)});
        GameRegistry.addRecipe(new ItemStack(RoadStuffBlocks.singleSlabAsphaltBase01, 6, 1), new Object[] {"XXX", 'X', new ItemStack(RoadStuffBlocks.blockAsphaltBase01, 1, 1)});
        GameRegistry.addRecipe(new ItemStack(RoadStuffBlocks.singleSlabAsphaltLines01, 6, 0), new Object[] {"XXX", 'X', new ItemStack(RoadStuffBlocks.blockAsphaltLines01, 1, 0)});
        GameRegistry.addRecipe(new ItemStack(RoadStuffBlocks.singleSlabAsphaltLines01, 6, 1), new Object[] {"XXX", 'X', new ItemStack(RoadStuffBlocks.blockAsphaltLines01, 1, 1)});
        GameRegistry.addRecipe(new ItemStack(RoadStuffBlocks.singleSlabAsphaltLines01, 6, 2), new Object[] {"XXX", 'X', new ItemStack(RoadStuffBlocks.blockAsphaltLines01, 1, 4)});
        GameRegistry.addRecipe(new ItemStack(RoadStuffBlocks.singleSlabAsphaltLines01, 6, 3), new Object[] {"XXX", 'X', new ItemStack(RoadStuffBlocks.blockAsphaltLines01, 1, 5)});

        // Slabs rotated to 90° - Temporary way until I fix rotating slabs
        GameRegistry.addRecipe(new ItemStack(RoadStuffBlocks.singleSlabAsphaltLines01, 1, 4), new Object[] {"X", 'X', new ItemStack(RoadStuffBlocks.singleSlabAsphaltLines01, 1, 0)});
        GameRegistry.addRecipe(new ItemStack(RoadStuffBlocks.singleSlabAsphaltLines01, 1, 5), new Object[] {"X", 'X', new ItemStack(RoadStuffBlocks.singleSlabAsphaltLines01, 1, 1)});
        GameRegistry.addRecipe(new ItemStack(RoadStuffBlocks.singleSlabAsphaltLines01, 1, 6), new Object[] {"X", 'X', new ItemStack(RoadStuffBlocks.singleSlabAsphaltLines01, 1, 2)});
        GameRegistry.addRecipe(new ItemStack(RoadStuffBlocks.singleSlabAsphaltLines01, 1, 7), new Object[] {"X", 'X', new ItemStack(RoadStuffBlocks.singleSlabAsphaltLines01, 1, 3)});

        // Other crafts
        GameRegistry.addRecipe(new ItemStack(RoadStuffBlocks.blockBitumenBlock, 1, 0), new Object[] {"XXX", "XXX", "XXX", 'X', new ItemStack(RoadStuffItems.itemBitumen, 1, 0)});
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RoadStuffBlocks.blockCone, 4, 0), new Object[] {" Z ", "ZYZ", "XXX", 'Z', "dyeOrange", 'Y', "dyeWhite", 'X', new ItemStack(RoadStuffItems.itemBitumen, 1, 1)}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RoadStuffBlocks.blockCone, 4, 1), new Object[] {"ZZZ", "YYY", "XXX", 'Z', "dyeOrange", 'Y', "dyeWhite", 'X', new ItemStack(RoadStuffItems.itemBitumen, 1, 1)}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RoadStuffBlocks.blockCone, 4, 2), new Object[] {" Z ", " Y ", "XXX", 'Z', "dyeOrange", 'Y', "dyeWhite", 'X', new ItemStack(RoadStuffItems.itemBitumen, 1, 1)}));
        GameRegistry.addRecipe(new ItemStack(RoadStuffItems.itemBitumen, 9, 0), new Object[] {"X", 'X', new ItemStack(RoadStuffBlocks.blockBitumenBlock, 1, 0)});

        // Furnace recipes
        GameRegistry.addSmelting(new ItemStack(RoadStuffItems.itemBitumen, 1, 0), new ItemStack(RoadStuffItems.itemBitumen, 1, 1), 0.35F);
        GameRegistry.addSmelting(new ItemStack(Blocks.gravel, 1), new ItemStack(RoadStuffBlocks.blockConcrete, 1, 0), 0.35F);

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RoadStuffBlocks.blockConcreteLine, 1, 0), new Object[] {"F F", 'F', "concrete"}));

    }

    public static void initOreDict()
    {
        OreDictionary.registerOre("concrete", new ItemStack(RoadStuffBlocks.blockConcrete, 0, 0));
        OreDictionary.registerOre("dustBitumen", new ItemStack(RoadStuffItems.itemBitumen, 0, 0));
        OreDictionary.registerOre("oreBitumen", new ItemStack(RoadStuffBlocks.blockBitumenOre));
        OreDictionary.registerOre("blockBitumen", new ItemStack(RoadStuffBlocks.blockBitumenBlock));
    }

}
