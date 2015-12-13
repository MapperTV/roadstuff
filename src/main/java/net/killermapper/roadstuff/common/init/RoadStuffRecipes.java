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
        GameRegistry.addRecipe(new ItemStack(RoadStuffBlocks.blockAsphalt, 4, 0), new Object[] {"XY", "ZX", 'X', new ItemStack(RoadStuffItems.itemBitumen, 1, 1), 'Y', Blocks.sand, 'Z', Blocks.gravel});
        GameRegistry.addRecipe(new ItemStack(RoadStuffBlocks.blockAsphalt, 1, 1), new Object[] {"Y", "X", 'X', new ItemStack(RoadStuffBlocks.blockAsphalt, 1, 0), 'Y', Blocks.heavy_weighted_pressure_plate});
        GameRegistry.addRecipe(new ItemStack(RoadStuffBlocks.blockConcrete, 1, 1), new Object[] {"Y", "X", 'X', new ItemStack(RoadStuffBlocks.blockConcrete, 1, 0), 'Y', Blocks.heavy_weighted_pressure_plate});

        // Line blocks to base block
        for(int i = 0; i <= 5; i++)
        {
            GameRegistry.addRecipe(new ItemStack(RoadStuffBlocks.blockAsphalt, 1, 0), new Object[] {"X", 'X', new ItemStack(RoadStuffBlocks.blockAsphaltLine, 1, i)});
            GameRegistry.addRecipe(new ItemStack(RoadStuffBlocks.blockConcrete, 1, 0), new Object[] {"X", 'X', new ItemStack(RoadStuffBlocks.blockConcreteLine, 1, i)});
        }

        for(int i = 0; i <= 3; i++)
        {
            GameRegistry.addRecipe(new ItemStack(RoadStuffBlocks.blockAsphalt, 1, 0), new Object[] {"X", 'X', new ItemStack(RoadStuffBlocks.blockAsphaltYCross, 1, i)});
            GameRegistry.addRecipe(new ItemStack(RoadStuffBlocks.blockAsphalt, 1, 0), new Object[] {"X", 'X', new ItemStack(RoadStuffBlocks.blockAsphaltYCrossYellow, 1, i)});
            GameRegistry.addRecipe(new ItemStack(RoadStuffBlocks.blockAsphalt, 1, 0), new Object[] {"X", 'X', new ItemStack(RoadStuffBlocks.blockAsphaltXCrossYellow, 1, i)});
            GameRegistry.addRecipe(new ItemStack(RoadStuffBlocks.blockAsphalt, 1, 0), new Object[] {"X", 'X', new ItemStack(RoadStuffBlocks.blockAsphaltXCross, 1, i)});
            GameRegistry.addRecipe(new ItemStack(RoadStuffBlocks.blockAsphalt, 1, 0), new Object[] {"X", 'X', new ItemStack(RoadStuffBlocks.blockAsphaltCorner, 1, i)});

            GameRegistry.addRecipe(new ItemStack(RoadStuffBlocks.blockConcrete, 1, 0), new Object[] {"X", 'X', new ItemStack(RoadStuffBlocks.blockConcreteCorner, 1, i)});
            GameRegistry.addRecipe(new ItemStack(RoadStuffBlocks.blockConcrete, 1, 0), new Object[] {"X", 'X', new ItemStack(RoadStuffBlocks.blockConcreteXCross, 1, i)});
            GameRegistry.addRecipe(new ItemStack(RoadStuffBlocks.blockConcrete, 1, 0), new Object[] {"X", 'X', new ItemStack(RoadStuffBlocks.blockConcreteXCrossYellow, 1, i)});
            GameRegistry.addRecipe(new ItemStack(RoadStuffBlocks.blockConcrete, 1, 0), new Object[] {"X", 'X', new ItemStack(RoadStuffBlocks.blockConcreteYCross, 1, i)});
            GameRegistry.addRecipe(new ItemStack(RoadStuffBlocks.blockConcrete, 1, 0), new Object[] {"X", 'X', new ItemStack(RoadStuffBlocks.blockConcreteYCrossYellow, 1, i)});
        }

        // Line Variants
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RoadStuffBlocks.blockAsphaltLine, 1, 0), new Object[] {"Y", "X", 'Y', "dyeWhite", 'X', new ItemStack(RoadStuffBlocks.blockAsphalt, 1, 0)}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RoadStuffBlocks.blockAsphaltLine, 1, 1), new Object[] {"Y", "X", 'Y', "dyeOrange", 'X', new ItemStack(RoadStuffBlocks.blockAsphalt, 1, 0)}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RoadStuffBlocks.blockAsphaltLine, 1, 2), new Object[] {"YY", "X ", 'Y', "dyeWhite", 'X', new ItemStack(RoadStuffBlocks.blockAsphalt, 1, 0)}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RoadStuffBlocks.blockAsphaltLine, 1, 3), new Object[] {"YY", "X ", 'Y', "dyeOrange", 'X', new ItemStack(RoadStuffBlocks.blockAsphalt, 1, 0)}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RoadStuffBlocks.blockAsphaltLine, 1, 4), new Object[] {"Y", "Y", "X", 'Y', "dyeWhite", 'X', new ItemStack(RoadStuffBlocks.blockAsphalt, 1, 0)}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RoadStuffBlocks.blockAsphaltLine, 1, 5), new Object[] {"Y", "Y", "X", 'Y', "dyeOrange", 'X', new ItemStack(RoadStuffBlocks.blockAsphalt, 1, 0)}));
        
        //Cross Variants
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RoadStuffBlocks.blockAsphaltYCross, 5, 0), new Object[] {"X X", "XX ", "X  ", 'X', new ItemStack(RoadStuffBlocks.blockAsphaltLine, 1, 0)}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RoadStuffBlocks.blockAsphaltYCross, 5, 1), new Object[] {"X X", " XX", "  X", 'X', new ItemStack(RoadStuffBlocks.blockAsphaltLine, 1, 0)}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RoadStuffBlocks.blockAsphaltYCross, 5, 2), new Object[] {"XXX", " X ", " X ", 'X', new ItemStack(RoadStuffBlocks.blockAsphaltLine, 1, 0)}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RoadStuffBlocks.blockAsphaltYCross, 3, 3), new Object[] {"X X", " X ", 'X', new ItemStack(RoadStuffBlocks.blockAsphaltLine, 1, 0)}));
        
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RoadStuffBlocks.blockAsphaltXCross, 4, 0), new Object[] {"X  ", "XX ", "X  ", 'X', new ItemStack(RoadStuffBlocks.blockAsphaltLine, 1, 0)}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RoadStuffBlocks.blockAsphaltXCross, 3, 1), new Object[] {"XX ", "X  ", 'X', new ItemStack(RoadStuffBlocks.blockAsphaltLine, 1, 0)}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RoadStuffBlocks.blockAsphaltXCross, 4, 2), new Object[] {"X  ", "XY ", "X  ", 'X', new ItemStack(RoadStuffBlocks.blockAsphaltLine, 1, 0), 'Y', new ItemStack(RoadStuffBlocks.blockAsphaltLine, 1, 4)}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RoadStuffBlocks.blockAsphaltXCross, 5, 3), new Object[] {" X ", "XXX", " X ", 'X', new ItemStack(RoadStuffBlocks.blockAsphaltLine, 1, 0)}));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RoadStuffBlocks.blockAsphaltYCrossYellow, 5, 0), new Object[] {"X X", "XX ", "X  ", 'X', new ItemStack(RoadStuffBlocks.blockAsphaltLine, 1, 1)}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RoadStuffBlocks.blockAsphaltYCrossYellow, 5, 1), new Object[] {"X X", " XX", "  X", 'X', new ItemStack(RoadStuffBlocks.blockAsphaltLine, 1, 1)}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RoadStuffBlocks.blockAsphaltYCrossYellow, 5, 2), new Object[] {"XXX", " X ", " X ", 'X', new ItemStack(RoadStuffBlocks.blockAsphaltLine, 1, 1)}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RoadStuffBlocks.blockAsphaltYCrossYellow, 3, 3), new Object[] {"X X", " X ", 'X', new ItemStack(RoadStuffBlocks.blockAsphaltLine, 1, 1)}));
        
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RoadStuffBlocks.blockAsphaltXCrossYellow, 4, 0), new Object[] {"X  ", "XX ", "X  ", 'X', new ItemStack(RoadStuffBlocks.blockAsphaltLine, 1, 1)}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RoadStuffBlocks.blockAsphaltXCrossYellow, 3, 1), new Object[] {"XX ", "X  ", 'X', new ItemStack(RoadStuffBlocks.blockAsphaltLine, 1, 1)}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RoadStuffBlocks.blockAsphaltXCrossYellow, 4, 2), new Object[] {"X  ", "XY ", "X  ", 'X', new ItemStack(RoadStuffBlocks.blockAsphaltLine, 1, 1), 'Y', new ItemStack(RoadStuffBlocks.blockAsphaltLine, 1, 5)}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RoadStuffBlocks.blockAsphaltXCrossYellow, 5, 3), new Object[] {" X ", "XXX", " X ", 'X', new ItemStack(RoadStuffBlocks.blockAsphaltLine, 1, 1)}));
        
        //Arrows
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RoadStuffBlocks.blockAsphaltArrow, 5, 0), new Object[] {" X ", " X ", "XXX", 'X', new ItemStack(RoadStuffBlocks.blockAsphaltLine, 1, 0)}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RoadStuffBlocks.blockAsphaltArrow, 4, 2), new Object[] {"Y Y", " X ", " X ", 'X', new ItemStack(RoadStuffBlocks.blockAsphaltLine, 1, 0), 'Y', new ItemStack(RoadStuffBlocks.blockAsphaltArrow, 1, 0)}));
        
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RoadStuffBlocks.blockAsphaltArrow, 5, 1), new Object[] {" X ", " X ", "XXX", 'X', new ItemStack(RoadStuffBlocks.blockAsphaltLine, 1, 1)}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RoadStuffBlocks.blockAsphaltArrow, 4, 3), new Object[] {"Y Y", " X ", " X ", 'X', new ItemStack(RoadStuffBlocks.blockAsphaltLine, 1, 1), 'Y', new ItemStack(RoadStuffBlocks.blockAsphaltArrow, 1, 1)}));
        
        // Slabs
        GameRegistry.addRecipe(new ItemStack(RoadStuffBlocks.singleSlabAsphalt, 6, 0), new Object[] {"XXX", 'X', new ItemStack(RoadStuffBlocks.blockAsphalt, 1, 0)});
        GameRegistry.addRecipe(new ItemStack(RoadStuffBlocks.singleSlabAsphalt, 6, 1), new Object[] {"XXX", 'X', new ItemStack(RoadStuffBlocks.blockAsphalt, 1, 1)});
        GameRegistry.addRecipe(new ItemStack(RoadStuffBlocks.singleSlabAsphaltLine, 6, 0), new Object[] {"XXX", 'X', new ItemStack(RoadStuffBlocks.blockAsphaltLine, 1, 0)});
        GameRegistry.addRecipe(new ItemStack(RoadStuffBlocks.singleSlabAsphaltLine, 6, 1), new Object[] {"XXX", 'X', new ItemStack(RoadStuffBlocks.blockAsphaltLine, 1, 1)});
        GameRegistry.addRecipe(new ItemStack(RoadStuffBlocks.singleSlabAsphaltLine, 6, 2), new Object[] {"XXX", 'X', new ItemStack(RoadStuffBlocks.blockAsphaltLine, 1, 4)});
        GameRegistry.addRecipe(new ItemStack(RoadStuffBlocks.singleSlabAsphaltLine, 6, 3), new Object[] {"XXX", 'X', new ItemStack(RoadStuffBlocks.blockAsphaltLine, 1, 5)});

        // Slabs rotated to 90° - Temporary way until I fix rotating slabs
        // GameRegistry.addRecipe(new ItemStack(RoadStuffBlocks.singleSlabAsphaltLine, 1, 4), new Object[] {"X", 'X', new ItemStack(RoadStuffBlocks.singleSlabAsphaltLine, 1, 0)});
        // GameRegistry.addRecipe(new ItemStack(RoadStuffBlocks.singleSlabAsphaltLine, 1, 5), new Object[] {"X", 'X', new ItemStack(RoadStuffBlocks.singleSlabAsphaltLine, 1, 1)});
        // GameRegistry.addRecipe(new ItemStack(RoadStuffBlocks.singleSlabAsphaltLine, 1, 6), new Object[] {"X", 'X', new ItemStack(RoadStuffBlocks.singleSlabAsphaltLine, 1, 2)});
        // GameRegistry.addRecipe(new ItemStack(RoadStuffBlocks.singleSlabAsphaltLine, 1, 7), new Object[] {"X", 'X', new ItemStack(RoadStuffBlocks.singleSlabAsphaltLine, 1, 3)});

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
