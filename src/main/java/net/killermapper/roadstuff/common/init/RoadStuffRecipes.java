package net.killermapper.roadstuff.common.init;

import cpw.mods.fml.common.registry.GameRegistry;
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
        GameRegistry.addRecipe(new ItemStack(RoadStuffBlocks.blockConcrete, 4, 0), new Object[] {"XY", "YX", 'X', Blocks.sand, 'Y', Blocks.gravel});
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
            GameRegistry.addRecipe(new ItemStack(RoadStuffBlocks.blockAsphalt, 1, 0), new Object[] {"X", 'X', new ItemStack(RoadStuffBlocks.blockAsphaltCorner2, 1, i)});
            GameRegistry.addRecipe(new ItemStack(RoadStuffBlocks.blockAsphalt, 1, 0), new Object[] {"X", 'X', new ItemStack(RoadStuffBlocks.blockAsphaltCorner3, 1, i)});
            GameRegistry.addRecipe(new ItemStack(RoadStuffBlocks.blockAsphalt, 1, 0), new Object[] {"X", 'X', new ItemStack(RoadStuffBlocks.blockAsphaltArrow, 1, i)});
            
            
            GameRegistry.addRecipe(new ItemStack(RoadStuffBlocks.blockConcrete, 1, 0), new Object[] {"X", 'X', new ItemStack(RoadStuffBlocks.blockConcreteCorner, 1, i)});
            GameRegistry.addRecipe(new ItemStack(RoadStuffBlocks.blockConcrete, 1, 0), new Object[] {"X", 'X', new ItemStack(RoadStuffBlocks.blockConcreteCorner2, 1, i)});
            GameRegistry.addRecipe(new ItemStack(RoadStuffBlocks.blockConcrete, 1, 0), new Object[] {"X", 'X', new ItemStack(RoadStuffBlocks.blockConcreteCorner3, 1, i)});
            GameRegistry.addRecipe(new ItemStack(RoadStuffBlocks.blockConcrete, 1, 0), new Object[] {"X", 'X', new ItemStack(RoadStuffBlocks.blockConcreteXCross, 1, i)});
            GameRegistry.addRecipe(new ItemStack(RoadStuffBlocks.blockConcrete, 1, 0), new Object[] {"X", 'X', new ItemStack(RoadStuffBlocks.blockConcreteXCrossYellow, 1, i)});
            GameRegistry.addRecipe(new ItemStack(RoadStuffBlocks.blockConcrete, 1, 0), new Object[] {"X", 'X', new ItemStack(RoadStuffBlocks.blockConcreteYCross, 1, i)});
            GameRegistry.addRecipe(new ItemStack(RoadStuffBlocks.blockConcrete, 1, 0), new Object[] {"X", 'X', new ItemStack(RoadStuffBlocks.blockConcreteYCrossYellow, 1, i)});
            GameRegistry.addRecipe(new ItemStack(RoadStuffBlocks.blockConcrete, 1, 0), new Object[] {"X", 'X', new ItemStack(RoadStuffBlocks.blockConcreteArrow, 1, i)});
        }
        
        // Slabs to blocks
        
        GameRegistry.addRecipe(new ItemStack(RoadStuffBlocks.blockAsphalt, 1, 0), new Object[] {"X", "X", 'X', new ItemStack(RoadStuffBlocks.singleSlabAsphalt, 1, 0)});
        GameRegistry.addRecipe(new ItemStack(RoadStuffBlocks.blockAsphalt, 1, 1), new Object[] {"X", "X", 'X', new ItemStack(RoadStuffBlocks.singleSlabAsphalt, 1, 1)});
        GameRegistry.addRecipe(new ItemStack(RoadStuffBlocks.blockAsphaltLine, 1, 0), new Object[] {"X", "X", 'X', new ItemStack(RoadStuffBlocks.singleSlabAsphaltLine, 1, 0)});
        GameRegistry.addRecipe(new ItemStack(RoadStuffBlocks.blockAsphaltLine, 1, 1), new Object[] {"X", "X", 'X', new ItemStack(RoadStuffBlocks.singleSlabAsphaltLine, 1, 1)});
        GameRegistry.addRecipe(new ItemStack(RoadStuffBlocks.blockAsphaltLine, 1, 4), new Object[] {"X", "X", 'X', new ItemStack(RoadStuffBlocks.singleSlabAsphaltLine, 1, 2)});
        GameRegistry.addRecipe(new ItemStack(RoadStuffBlocks.blockAsphaltLine, 1, 5), new Object[] {"X", "X", 'X', new ItemStack(RoadStuffBlocks.singleSlabAsphaltLine, 1, 3)});
        GameRegistry.addRecipe(new ItemStack(RoadStuffBlocks.blockAsphaltCorner, 1, 0), new Object[] {"X", "X", 'X', new ItemStack(RoadStuffBlocks.singleSlabAsphaltCorner, 1, 0)});
        GameRegistry.addRecipe(new ItemStack(RoadStuffBlocks.blockAsphaltCorner, 1, 1), new Object[] {"X", "X", 'X', new ItemStack(RoadStuffBlocks.singleSlabAsphaltCorner, 1, 1)});
        GameRegistry.addRecipe(new ItemStack(RoadStuffBlocks.blockAsphaltCorner, 1, 2), new Object[] {"X", "X", 'X', new ItemStack(RoadStuffBlocks.singleSlabAsphaltCornerDouble, 1, 0)});
        GameRegistry.addRecipe(new ItemStack(RoadStuffBlocks.blockAsphaltCorner, 1, 3), new Object[] {"X", "X", 'X', new ItemStack(RoadStuffBlocks.singleSlabAsphaltCornerDouble, 1, 1)});
        
        GameRegistry.addRecipe(new ItemStack(RoadStuffBlocks.blockConcrete, 1, 0), new Object[] {"X", "X", 'X', new ItemStack(RoadStuffBlocks.singleSlabConcrete, 1, 0)});
        GameRegistry.addRecipe(new ItemStack(RoadStuffBlocks.blockConcrete, 1, 1), new Object[] {"X", "X", 'X', new ItemStack(RoadStuffBlocks.singleSlabConcrete, 1, 1)});
        GameRegistry.addRecipe(new ItemStack(RoadStuffBlocks.blockConcreteLine, 1, 0), new Object[] {"X", "X", 'X', new ItemStack(RoadStuffBlocks.singleSlabConcreteLine, 1, 0)});
        GameRegistry.addRecipe(new ItemStack(RoadStuffBlocks.blockConcreteLine, 1, 1), new Object[] {"X", "X", 'X', new ItemStack(RoadStuffBlocks.singleSlabConcreteLine, 1, 1)});
        GameRegistry.addRecipe(new ItemStack(RoadStuffBlocks.blockConcreteLine, 1, 4), new Object[] {"X", "X", 'X', new ItemStack(RoadStuffBlocks.singleSlabConcreteLine, 1, 2)});
        GameRegistry.addRecipe(new ItemStack(RoadStuffBlocks.blockConcreteLine, 1, 5), new Object[] {"X", "X", 'X', new ItemStack(RoadStuffBlocks.singleSlabConcreteLine, 1, 3)});
        GameRegistry.addRecipe(new ItemStack(RoadStuffBlocks.blockConcreteCorner, 1, 0), new Object[] {"X", "X", 'X', new ItemStack(RoadStuffBlocks.singleSlabConcreteCorner, 1, 0)});
        GameRegistry.addRecipe(new ItemStack(RoadStuffBlocks.blockConcreteCorner, 1, 1), new Object[] {"X", "X", 'X', new ItemStack(RoadStuffBlocks.singleSlabConcreteCorner, 1, 1)});
        GameRegistry.addRecipe(new ItemStack(RoadStuffBlocks.blockConcreteCorner, 1, 2), new Object[] {"X", "X", 'X', new ItemStack(RoadStuffBlocks.singleSlabConcreteCornerDouble, 1, 0)});
        GameRegistry.addRecipe(new ItemStack(RoadStuffBlocks.blockConcreteCorner, 1, 3), new Object[] {"X", "X", 'X', new ItemStack(RoadStuffBlocks.singleSlabConcreteCornerDouble, 1, 1)});
        
        // Line Variants
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RoadStuffBlocks.blockAsphaltLine, 1, 0), new Object[] {"Y", "X", 'Y', "dyeWhite", 'X', new ItemStack(RoadStuffBlocks.blockAsphalt, 1, 0)}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RoadStuffBlocks.blockAsphaltLine, 1, 1), new Object[] {"Y", "X", 'Y', "dyeOrange", 'X', new ItemStack(RoadStuffBlocks.blockAsphalt, 1, 0)}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RoadStuffBlocks.blockAsphaltLine, 1, 2), new Object[] {"YY", "X ", 'Y', "dyeWhite", 'X', new ItemStack(RoadStuffBlocks.blockAsphalt, 1, 0)}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RoadStuffBlocks.blockAsphaltLine, 1, 3), new Object[] {"YY", "X ", 'Y', "dyeOrange", 'X', new ItemStack(RoadStuffBlocks.blockAsphalt, 1, 0)}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RoadStuffBlocks.blockAsphaltLine, 1, 4), new Object[] {"Y", "Y", "X", 'Y', "dyeWhite", 'X', new ItemStack(RoadStuffBlocks.blockAsphalt, 1, 0)}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RoadStuffBlocks.blockAsphaltLine, 1, 5), new Object[] {"Y", "Y", "X", 'Y', "dyeOrange", 'X', new ItemStack(RoadStuffBlocks.blockAsphalt, 1, 0)}));
        GameRegistry.addRecipe(new ItemStack(RoadStuffBlocks.blockAsphaltCorner2, 2, 2), new Object[] {"X", "Y", 'X', new ItemStack(RoadStuffBlocks.blockAsphaltLine, 1, 4), 'Y', new ItemStack(RoadStuffBlocks.blockAsphalt, 1, 0)});
        GameRegistry.addRecipe(new ItemStack(RoadStuffBlocks.blockAsphaltCorner2, 2, 3), new Object[] {"X", "Y", 'X', new ItemStack(RoadStuffBlocks.blockAsphaltLine, 1, 5), 'Y', new ItemStack(RoadStuffBlocks.blockAsphalt, 1, 0)});
        
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RoadStuffBlocks.blockConcreteLine, 1, 0), new Object[] {"Y", "X", 'Y', "dyeWhite", 'X', new ItemStack(RoadStuffBlocks.blockConcrete, 1, 0)}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RoadStuffBlocks.blockConcreteLine, 1, 1), new Object[] {"Y", "X", 'Y', "dyeOrange", 'X', new ItemStack(RoadStuffBlocks.blockConcrete, 1, 0)}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RoadStuffBlocks.blockConcreteLine, 1, 2), new Object[] {"YY", "X ", 'Y', "dyeWhite", 'X', new ItemStack(RoadStuffBlocks.blockConcrete, 1, 0)}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RoadStuffBlocks.blockConcreteLine, 1, 3), new Object[] {"YY", "X ", 'Y', "dyeOrange", 'X', new ItemStack(RoadStuffBlocks.blockConcrete, 1, 0)}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RoadStuffBlocks.blockConcreteLine, 1, 4), new Object[] {"Y", "Y", "X", 'Y', "dyeWhite", 'X', new ItemStack(RoadStuffBlocks.blockConcrete, 1, 0)}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RoadStuffBlocks.blockConcreteLine, 1, 5), new Object[] {"Y", "Y", "X", 'Y', "dyeOrange", 'X', new ItemStack(RoadStuffBlocks.blockConcrete, 1, 0)}));
        GameRegistry.addRecipe(new ItemStack(RoadStuffBlocks.blockConcreteCorner2, 2, 2), new Object[] {"X", "Y", 'X', new ItemStack(RoadStuffBlocks.blockConcreteLine, 1, 4), 'Y', new ItemStack(RoadStuffBlocks.blockConcrete, 1, 0)});
        GameRegistry.addRecipe(new ItemStack(RoadStuffBlocks.blockConcreteCorner2, 2, 3), new Object[] {"X", "Y", 'X', new ItemStack(RoadStuffBlocks.blockConcreteLine, 1, 5), 'Y', new ItemStack(RoadStuffBlocks.blockConcrete, 1, 0)});
        
        // Cross Variants
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RoadStuffBlocks.blockAsphaltYCross, 5, 0), new Object[] {"X X", "XX ", "X  ", 'X', new ItemStack(RoadStuffBlocks.blockAsphaltLine, 1, 0)}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RoadStuffBlocks.blockAsphaltYCross, 5, 1), new Object[] {"X X", " XX", "  X", 'X', new ItemStack(RoadStuffBlocks.blockAsphaltLine, 1, 0)}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RoadStuffBlocks.blockAsphaltYCross, 5, 2), new Object[] {" X ", " X ", "XXX", 'X', new ItemStack(RoadStuffBlocks.blockAsphaltLine, 1, 0)}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RoadStuffBlocks.blockAsphaltYCross, 3, 3), new Object[] {"X X", " X ", 'X', new ItemStack(RoadStuffBlocks.blockAsphaltLine, 1, 0)}));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RoadStuffBlocks.blockAsphaltXCross, 4, 0), new Object[] {"X  ", "XX ", "X  ", 'X', new ItemStack(RoadStuffBlocks.blockAsphaltLine, 1, 0)}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RoadStuffBlocks.blockAsphaltXCross, 3, 1), new Object[] {"XX ", "X  ", 'X', new ItemStack(RoadStuffBlocks.blockAsphaltLine, 1, 0)}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RoadStuffBlocks.blockAsphaltXCross, 4, 2), new Object[] {"X  ", "XY ", "X  ", 'X', new ItemStack(RoadStuffBlocks.blockAsphaltLine, 1, 0), 'Y', new ItemStack(RoadStuffBlocks.blockAsphaltLine, 1, 4)}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RoadStuffBlocks.blockAsphaltXCross, 5, 3), new Object[] {" X ", "XXX", " X ", 'X', new ItemStack(RoadStuffBlocks.blockAsphaltLine, 1, 0)}));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RoadStuffBlocks.blockAsphaltYCrossYellow, 5, 0), new Object[] {"X X", "XX ", "X  ", 'X', new ItemStack(RoadStuffBlocks.blockAsphaltLine, 1, 1)}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RoadStuffBlocks.blockAsphaltYCrossYellow, 5, 1), new Object[] {"X X", " XX", "  X", 'X', new ItemStack(RoadStuffBlocks.blockAsphaltLine, 1, 1)}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RoadStuffBlocks.blockAsphaltYCrossYellow, 5, 2), new Object[] {" X ", " X ", "XXX", 'X', new ItemStack(RoadStuffBlocks.blockAsphaltLine, 1, 1)}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RoadStuffBlocks.blockAsphaltYCrossYellow, 3, 3), new Object[] {"X X", " X ", 'X', new ItemStack(RoadStuffBlocks.blockAsphaltLine, 1, 1)}));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RoadStuffBlocks.blockAsphaltXCrossYellow, 4, 0), new Object[] {"X  ", "XX ", "X  ", 'X', new ItemStack(RoadStuffBlocks.blockAsphaltLine, 1, 1)}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RoadStuffBlocks.blockAsphaltXCrossYellow, 3, 1), new Object[] {"XX ", "X  ", 'X', new ItemStack(RoadStuffBlocks.blockAsphaltLine, 1, 1)}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RoadStuffBlocks.blockAsphaltXCrossYellow, 4, 2), new Object[] {"X  ", "XY ", "X  ", 'X', new ItemStack(RoadStuffBlocks.blockAsphaltLine, 1, 1), 'Y', new ItemStack(RoadStuffBlocks.blockAsphaltLine, 1, 5)}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RoadStuffBlocks.blockAsphaltXCrossYellow, 5, 3), new Object[] {" X ", "XXX", " X ", 'X', new ItemStack(RoadStuffBlocks.blockAsphaltLine, 1, 1)}));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RoadStuffBlocks.blockConcreteYCross, 5, 0), new Object[] {"X X", "XX ", "X  ", 'X', new ItemStack(RoadStuffBlocks.blockConcreteLine, 1, 0)}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RoadStuffBlocks.blockConcreteYCross, 5, 1), new Object[] {"X X", " XX", "  X", 'X', new ItemStack(RoadStuffBlocks.blockConcreteLine, 1, 0)}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RoadStuffBlocks.blockConcreteYCross, 5, 2), new Object[] {" X ", " X ", "XXX", 'X', new ItemStack(RoadStuffBlocks.blockConcreteLine, 1, 0)}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RoadStuffBlocks.blockConcreteYCross, 3, 3), new Object[] {"X X", " X ", 'X', new ItemStack(RoadStuffBlocks.blockConcreteLine, 1, 0)}));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RoadStuffBlocks.blockConcreteXCross, 4, 0), new Object[] {"X  ", "XX ", "X  ", 'X', new ItemStack(RoadStuffBlocks.blockConcreteLine, 1, 0)}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RoadStuffBlocks.blockConcreteXCross, 3, 1), new Object[] {"XX ", "X  ", 'X', new ItemStack(RoadStuffBlocks.blockConcreteLine, 1, 0)}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RoadStuffBlocks.blockConcreteXCross, 4, 2), new Object[] {"X  ", "XY ", "X  ", 'X', new ItemStack(RoadStuffBlocks.blockConcreteLine, 1, 0), 'Y', new ItemStack(RoadStuffBlocks.blockConcreteLine, 1, 4)}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RoadStuffBlocks.blockConcreteXCross, 5, 3), new Object[] {" X ", "XXX", " X ", 'X', new ItemStack(RoadStuffBlocks.blockConcreteLine, 1, 0)}));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RoadStuffBlocks.blockConcreteYCrossYellow, 5, 0), new Object[] {"X X", "XX ", "X  ", 'X', new ItemStack(RoadStuffBlocks.blockConcreteLine, 1, 1)}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RoadStuffBlocks.blockConcreteYCrossYellow, 5, 1), new Object[] {"X X", " XX", "  X", 'X', new ItemStack(RoadStuffBlocks.blockConcreteLine, 1, 1)}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RoadStuffBlocks.blockConcreteYCrossYellow, 5, 2), new Object[] {" X ", " X ", "XXX", 'X', new ItemStack(RoadStuffBlocks.blockConcreteLine, 1, 1)}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RoadStuffBlocks.blockConcreteYCrossYellow, 3, 3), new Object[] {"X X", " X ", 'X', new ItemStack(RoadStuffBlocks.blockConcreteLine, 1, 1)}));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RoadStuffBlocks.blockConcreteXCrossYellow, 4, 0), new Object[] {"X  ", "XX ", "X  ", 'X', new ItemStack(RoadStuffBlocks.blockConcreteLine, 1, 1)}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RoadStuffBlocks.blockConcreteXCrossYellow, 3, 1), new Object[] {"XX ", "X  ", 'X', new ItemStack(RoadStuffBlocks.blockConcreteLine, 1, 1)}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RoadStuffBlocks.blockConcreteXCrossYellow, 4, 2), new Object[] {"X  ", "XY ", "X  ", 'X', new ItemStack(RoadStuffBlocks.blockConcreteLine, 1, 1), 'Y', new ItemStack(RoadStuffBlocks.blockConcreteLine, 1, 5)}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RoadStuffBlocks.blockConcreteXCrossYellow, 5, 3), new Object[] {" X ", "XXX", " X ", 'X', new ItemStack(RoadStuffBlocks.blockConcreteLine, 1, 1)}));

        // Corners Variants
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RoadStuffBlocks.blockAsphaltCorner, 3, 0), new Object[] {" X", "X ", 'X', new ItemStack(RoadStuffBlocks.blockAsphaltLine, 1, 0)}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RoadStuffBlocks.blockAsphaltCorner, 3, 1), new Object[] {" X", "X ", 'X', new ItemStack(RoadStuffBlocks.blockAsphaltLine, 1, 1)}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RoadStuffBlocks.blockAsphaltCorner, 3, 2), new Object[] {" X", "X ", 'X', new ItemStack(RoadStuffBlocks.blockAsphaltLine, 1, 4)}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RoadStuffBlocks.blockAsphaltCorner, 3, 3), new Object[] {" X", "X ", 'X', new ItemStack(RoadStuffBlocks.blockAsphaltLine, 1, 5)}));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RoadStuffBlocks.blockConcreteCorner, 3, 0), new Object[] {" X", "X ", 'X', new ItemStack(RoadStuffBlocks.blockConcreteLine, 1, 0)}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RoadStuffBlocks.blockConcreteCorner, 3, 1), new Object[] {" X", "X ", 'X', new ItemStack(RoadStuffBlocks.blockConcreteLine, 1, 1)}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RoadStuffBlocks.blockConcreteCorner, 3, 2), new Object[] {" X", "X ", 'X', new ItemStack(RoadStuffBlocks.blockConcreteLine, 1, 4)}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RoadStuffBlocks.blockConcreteCorner, 3, 3), new Object[] {" X", "X ", 'X', new ItemStack(RoadStuffBlocks.blockConcreteLine, 1, 5)}));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RoadStuffBlocks.blockAsphaltCorner2, 2, 0), new Object[] {" X", "X ", 'X', new ItemStack(RoadStuffBlocks.blockAsphaltLine, 1, 2)}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RoadStuffBlocks.blockAsphaltCorner2, 2, 1), new Object[] {" X", "X ", 'X', new ItemStack(RoadStuffBlocks.blockAsphaltLine, 1, 3)}));
        
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RoadStuffBlocks.blockConcreteCorner2, 2, 0), new Object[] {" X", "X ", 'X', new ItemStack(RoadStuffBlocks.blockConcreteLine, 1, 2)}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RoadStuffBlocks.blockConcreteCorner2, 2, 1), new Object[] {" X", "X ", 'X', new ItemStack(RoadStuffBlocks.blockConcreteLine, 1, 3)}));
        
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RoadStuffBlocks.blockAsphaltCorner3, 3, 0), new Object[] {"  X", " X ", "X  ", 'X', new ItemStack(RoadStuffBlocks.blockAsphaltCorner2, 1, 2)}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RoadStuffBlocks.blockAsphaltCorner3, 3, 1), new Object[] {"  X", " X ", "X  ", 'X', new ItemStack(RoadStuffBlocks.blockAsphaltCorner2, 1, 3)}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RoadStuffBlocks.blockAsphaltCorner3, 2, 2), new Object[] {" X", "X ", 'X', new ItemStack(RoadStuffBlocks.blockAsphaltCorner2, 1, 2)}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RoadStuffBlocks.blockAsphaltCorner3, 2, 3), new Object[] {" X", "X ", 'X', new ItemStack(RoadStuffBlocks.blockAsphaltCorner2, 1, 3)}));
        
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RoadStuffBlocks.blockConcreteCorner3, 3, 0), new Object[] {"  X", " X ", "X  ", 'X', new ItemStack(RoadStuffBlocks.blockConcreteCorner2, 1, 2)}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RoadStuffBlocks.blockConcreteCorner3, 3, 1), new Object[] {"  X", " X ", "X  ", 'X', new ItemStack(RoadStuffBlocks.blockConcreteCorner2, 1, 3)}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RoadStuffBlocks.blockConcreteCorner3, 2, 2), new Object[] {" X", "X ", 'X', new ItemStack(RoadStuffBlocks.blockConcreteCorner2, 1, 2)}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RoadStuffBlocks.blockConcreteCorner3, 2, 3), new Object[] {" X", "X ", 'X', new ItemStack(RoadStuffBlocks.blockConcreteCorner2, 1, 3)}));
        
        // Arrows
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RoadStuffBlocks.blockAsphaltArrow, 4, 0), new Object[] {" X ", "XXX", 'X', new ItemStack(RoadStuffBlocks.blockAsphaltLine, 1, 0)}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RoadStuffBlocks.blockAsphaltArrow, 4, 2), new Object[] {"Y Y", " X ", " X ", 'X', new ItemStack(RoadStuffBlocks.blockAsphaltLine, 1, 0), 'Y', new ItemStack(RoadStuffBlocks.blockAsphaltArrow, 1, 0)}));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RoadStuffBlocks.blockAsphaltArrow, 4, 1), new Object[] {" X ", "XXX", 'X', new ItemStack(RoadStuffBlocks.blockAsphaltLine, 1, 1)}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RoadStuffBlocks.blockAsphaltArrow, 4, 3), new Object[] {"Y Y", " X ", " X ", 'X', new ItemStack(RoadStuffBlocks.blockAsphaltLine, 1, 1), 'Y', new ItemStack(RoadStuffBlocks.blockAsphaltArrow, 1, 1)}));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RoadStuffBlocks.blockConcreteArrow, 4, 0), new Object[] {" X ", "XXX", 'X', new ItemStack(RoadStuffBlocks.blockConcreteLine, 1, 0)}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RoadStuffBlocks.blockConcreteArrow, 4, 2), new Object[] {"Y Y", " X ", " X ", 'X', new ItemStack(RoadStuffBlocks.blockConcreteLine, 1, 0), 'Y', new ItemStack(RoadStuffBlocks.blockConcreteArrow, 1, 0)}));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RoadStuffBlocks.blockConcreteArrow, 4, 1), new Object[] {" X ", "XXX", 'X', new ItemStack(RoadStuffBlocks.blockConcreteLine, 1, 1)}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RoadStuffBlocks.blockConcreteArrow, 4, 3), new Object[] {"Y Y", " X ", " X ", 'X', new ItemStack(RoadStuffBlocks.blockConcreteLine, 1, 1), 'Y', new ItemStack(RoadStuffBlocks.blockConcreteArrow, 1, 1)}));

        // Slabs
        GameRegistry.addRecipe(new ItemStack(RoadStuffBlocks.singleSlabAsphalt, 6, 0), new Object[] {"XXX", 'X', new ItemStack(RoadStuffBlocks.blockAsphalt, 1, 0)});
        GameRegistry.addRecipe(new ItemStack(RoadStuffBlocks.singleSlabAsphalt, 6, 1), new Object[] {"XXX", 'X', new ItemStack(RoadStuffBlocks.blockAsphalt, 1, 1)});
        GameRegistry.addRecipe(new ItemStack(RoadStuffBlocks.singleSlabAsphaltLine, 6, 0), new Object[] {"XXX", 'X', new ItemStack(RoadStuffBlocks.blockAsphaltLine, 1, 0)});
        GameRegistry.addRecipe(new ItemStack(RoadStuffBlocks.singleSlabAsphaltLine, 6, 1), new Object[] {"XXX", 'X', new ItemStack(RoadStuffBlocks.blockAsphaltLine, 1, 1)});
        GameRegistry.addRecipe(new ItemStack(RoadStuffBlocks.singleSlabAsphaltLine, 6, 2), new Object[] {"XXX", 'X', new ItemStack(RoadStuffBlocks.blockAsphaltLine, 1, 4)});
        GameRegistry.addRecipe(new ItemStack(RoadStuffBlocks.singleSlabAsphaltLine, 6, 3), new Object[] {"XXX", 'X', new ItemStack(RoadStuffBlocks.blockAsphaltLine, 1, 5)});

        GameRegistry.addRecipe(new ItemStack(RoadStuffBlocks.singleSlabConcrete, 6, 0), new Object[] {"XXX", 'X', new ItemStack(RoadStuffBlocks.blockConcrete, 1, 0)});
        GameRegistry.addRecipe(new ItemStack(RoadStuffBlocks.singleSlabConcrete, 6, 1), new Object[] {"XXX", 'X', new ItemStack(RoadStuffBlocks.blockConcrete, 1, 1)});
        GameRegistry.addRecipe(new ItemStack(RoadStuffBlocks.singleSlabConcreteLine, 6, 0), new Object[] {"XXX", 'X', new ItemStack(RoadStuffBlocks.blockConcreteLine, 1, 0)});
        GameRegistry.addRecipe(new ItemStack(RoadStuffBlocks.singleSlabConcreteLine, 6, 1), new Object[] {"XXX", 'X', new ItemStack(RoadStuffBlocks.blockConcreteLine, 1, 1)});
        GameRegistry.addRecipe(new ItemStack(RoadStuffBlocks.singleSlabConcreteLine, 6, 2), new Object[] {"XXX", 'X', new ItemStack(RoadStuffBlocks.blockConcreteLine, 1, 4)});
        GameRegistry.addRecipe(new ItemStack(RoadStuffBlocks.singleSlabConcreteLine, 6, 3), new Object[] {"XXX", 'X', new ItemStack(RoadStuffBlocks.blockConcreteLine, 1, 5)});

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RoadStuffBlocks.singleSlabAsphaltCorner, 3, 0), new Object[] {"  X", " X ", "X  ", 'X', new ItemStack(RoadStuffBlocks.singleSlabAsphaltLine, 1, 0)}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RoadStuffBlocks.singleSlabAsphaltCorner, 3, 1), new Object[] {"  X", " X ", "X  ", 'X', new ItemStack(RoadStuffBlocks.singleSlabAsphaltLine, 1, 1)}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RoadStuffBlocks.singleSlabAsphaltCornerDouble, 3, 0), new Object[] {"  X", " X ", "X  ", 'X', new ItemStack(RoadStuffBlocks.singleSlabAsphaltLine, 1, 2)}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RoadStuffBlocks.singleSlabAsphaltCornerDouble, 3, 1), new Object[] {"  X", " X ", "X  ", 'X', new ItemStack(RoadStuffBlocks.singleSlabAsphaltLine, 1, 3)}));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RoadStuffBlocks.singleSlabConcreteCorner, 3, 0), new Object[] {"  X", " X ", "X  ", 'X', new ItemStack(RoadStuffBlocks.singleSlabConcreteLine, 1, 0)}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RoadStuffBlocks.singleSlabConcreteCorner, 3, 1), new Object[] {"  X", " X ", "X  ", 'X', new ItemStack(RoadStuffBlocks.singleSlabConcreteLine, 1, 1)}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RoadStuffBlocks.singleSlabConcreteCornerDouble, 3, 0), new Object[] {"  X", " X ", "X  ", 'X', new ItemStack(RoadStuffBlocks.singleSlabConcreteLine, 1, 2)}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RoadStuffBlocks.singleSlabConcreteCornerDouble, 3, 1), new Object[] {"  X", " X ", "X  ", 'X', new ItemStack(RoadStuffBlocks.singleSlabConcreteLine, 1, 3)}));

        // Other crafts
        GameRegistry.addRecipe(new ItemStack(RoadStuffItems.itemBitumen, 9, 0), new Object[] {"X", 'X', new ItemStack(RoadStuffBlocks.blockBitumenBlock, 1, 0)});
        GameRegistry.addRecipe(new ItemStack(RoadStuffBlocks.blockBitumenBlock, 1, 0), new Object[] {"XXX", "XXX", "XXX", 'X', new ItemStack(RoadStuffItems.itemBitumen, 1, 0)});

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RoadStuffBlocks.blockCone, 4, 0), new Object[] {" Z ", "ZYZ", "XXX", 'Z', "dyeOrange", 'Y', "dyeWhite", 'X', new ItemStack(RoadStuffItems.itemBitumen, 1, 1)}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RoadStuffBlocks.blockCone, 4, 1), new Object[] {"ZZZ", "YYY", "XXX", 'Z', "dyeOrange", 'Y', "dyeWhite", 'X', new ItemStack(RoadStuffItems.itemBitumen, 1, 1)}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RoadStuffBlocks.blockCone, 4, 2), new Object[] {" Z ", " Y ", "XXX", 'Z', "dyeOrange", 'Y', "dyeWhite", 'X', new ItemStack(RoadStuffItems.itemBitumen, 1, 1)}));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RoadStuffItems.itemIronPart, 4, 0), new Object[] {"I", "I", 'I', "ingotIron"}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RoadStuffItems.itemIronPart, 4, 1), new Object[] {"I", "I", "I", 'I', "ingotIron"}));
        // GameRegistry.addRecipe(new ItemStack(RoadStuffBlocks.blockTrafficSign, 1, 0), new Object[] {"S", "S", 'S', new ItemStack(RoadStuffItems.itemIronPart, 1, 0)});
        // GameRegistry.addRecipe(new ItemStack(RoadStuffBlocks.blockTrafficSign, 1, 1), new Object[] {"P", "S", 'P', new ItemStack(RoadStuffItems.itemIronPart, 1, 1), 'S', new
        // ItemStack(RoadStuffItems.itemIronPart, 1, 0)});

        // Furnace recipes
        GameRegistry.addSmelting(new ItemStack(RoadStuffItems.itemBitumen, 1, 0), new ItemStack(RoadStuffItems.itemBitumen, 1, 1), 0.35F);
        //GameRegistry.addSmelting(new ItemStack(Blocks.gravel, 1), new ItemStack(RoadStuffBlocks.blockConcrete, 1, 0), 0.35F);
        GameRegistry.addSmelting(new ItemStack(RoadStuffBlocks.blockBitumenOre, 1, 0), new ItemStack(RoadStuffItems.itemBitumen, 8, 0), 0.35F);

        // Reflectors
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RoadStuffBlocks.blockReflector, 8, 0), new Object[] {"X ", "YZ", 'X', "ingotIron", 'Y', "gemQuartz", 'Z', "dyeWhite"}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RoadStuffBlocks.blockReflector, 8, 1), new Object[] {"X ", "YZ", 'X', "ingotIron", 'Y', "gemQuartz", 'Z', "dyeOrange"}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RoadStuffBlocks.blockReflector, 1, 2), new Object[] {"X", "Y", 'X', new ItemStack(RoadStuffBlocks.blockReflector, 1, 0), 'Y', "dustGlowstone"}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RoadStuffBlocks.blockReflector, 1, 3), new Object[] {"X", "Y", 'X', new ItemStack(RoadStuffBlocks.blockReflector, 1, 1), 'Y', "dustGlowstone"}));
    }

    public static void initOreDict()
    {
        //OreDictionary.registerOre("concrete", new ItemStack(RoadStuffBlocks.blockConcrete, 0, 0));
        OreDictionary.registerOre("dustBitumen", new ItemStack(RoadStuffItems.itemBitumen, 0, 0));
        OreDictionary.registerOre("oreBitumen", new ItemStack(RoadStuffBlocks.blockBitumenOre));
        OreDictionary.registerOre("blockBitumen", new ItemStack(RoadStuffBlocks.blockBitumenBlock));
        OreDictionary.registerOre("ironStick", new ItemStack(RoadStuffItems.itemIronPart, 0, 0));
        OreDictionary.registerOre("ironPlate", new ItemStack(RoadStuffItems.itemIronPart, 0, 1));
    }

}
