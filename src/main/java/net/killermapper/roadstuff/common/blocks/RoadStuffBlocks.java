/*
Road Stuff - A Minecraft MODification by KillerMapper - 2015

The MIT License (MIT)

Copyright (c) 2015 KillerMapper

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
*/

package net.killermapper.roadstuff.common.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import net.killermapper.roadstuff.common.RoadStuff;
import net.killermapper.roadstuff.common.blocks.asphalt.BlockAsphalt;
import net.killermapper.roadstuff.common.blocks.asphalt.BlockAsphaltArrow;
import net.killermapper.roadstuff.common.blocks.asphalt.BlockAsphaltCorner;
import net.killermapper.roadstuff.common.blocks.asphalt.BlockAsphaltLine;
import net.killermapper.roadstuff.common.blocks.asphalt.BlockAsphaltWordExit;
import net.killermapper.roadstuff.common.blocks.asphalt.BlockAsphaltXCross;
import net.killermapper.roadstuff.common.blocks.asphalt.BlockAsphaltXCrossYellow;
import net.killermapper.roadstuff.common.blocks.asphalt.BlockAsphaltYCross;
import net.killermapper.roadstuff.common.blocks.asphalt.BlockAsphaltYCrossYellow;
import net.killermapper.roadstuff.common.blocks.asphalt.BlockSlabAsphalt;
import net.killermapper.roadstuff.common.blocks.asphalt.BlockSlabAsphaltCorner;
import net.killermapper.roadstuff.common.blocks.asphalt.BlockSlabAsphaltCornerDouble;
import net.killermapper.roadstuff.common.blocks.asphalt.BlockSlabAsphaltLine;
import net.killermapper.roadstuff.common.blocks.concrete.BlockConcrete;
import net.killermapper.roadstuff.common.blocks.concrete.BlockConcreteArrow;
import net.killermapper.roadstuff.common.blocks.concrete.BlockConcreteCorner;
import net.killermapper.roadstuff.common.blocks.concrete.BlockConcreteLine;
import net.killermapper.roadstuff.common.blocks.concrete.BlockConcreteXCross;
import net.killermapper.roadstuff.common.blocks.concrete.BlockConcreteXCrossYellow;
import net.killermapper.roadstuff.common.blocks.concrete.BlockConcreteYCross;
import net.killermapper.roadstuff.common.blocks.concrete.BlockConcreteYCrossYellow;
import net.killermapper.roadstuff.common.blocks.concrete.BlockSlabConcrete;
import net.killermapper.roadstuff.common.blocks.concrete.BlockSlabConcreteCorner;
import net.killermapper.roadstuff.common.blocks.concrete.BlockSlabConcreteCornerDouble;
import net.killermapper.roadstuff.common.blocks.concrete.BlockSlabConcreteLine;
import net.killermapper.roadstuff.common.items.ItemBlockCone;
import net.killermapper.roadstuff.common.items.ItemBlockTrafficLight;
import net.killermapper.roadstuff.common.items.ItemBlockTrafficSign;
import net.killermapper.roadstuff.common.items.asphalt.ItemBlockAsphaltArrow;
import net.killermapper.roadstuff.common.items.asphalt.ItemBlockAsphalt;
import net.killermapper.roadstuff.common.items.asphalt.ItemBlockAsphaltCorner;
import net.killermapper.roadstuff.common.items.asphalt.ItemBlockAsphaltLine;
import net.killermapper.roadstuff.common.items.asphalt.ItemBlockAsphaltYCross;
import net.killermapper.roadstuff.common.items.asphalt.ItemBlockAsphaltYCrossYellow;
import net.killermapper.roadstuff.common.items.asphalt.ItemBlockAsphaltXCrossYellow;
import net.killermapper.roadstuff.common.items.asphalt.ItemBlockAsphaltXCross;
import net.killermapper.roadstuff.common.items.asphalt.ItemBlockAsphaltWordExit;
import net.killermapper.roadstuff.common.items.asphalt.ItemBlockSlabAsphalt;
import net.killermapper.roadstuff.common.items.asphalt.ItemBlockSlabAsphaltCorner;
import net.killermapper.roadstuff.common.items.asphalt.ItemBlockSlabAsphaltCornerDouble;
import net.killermapper.roadstuff.common.items.asphalt.ItemBlockSlabAsphaltLine;
import net.killermapper.roadstuff.common.items.concrete.ItemBlockConcrete;
import net.killermapper.roadstuff.common.items.concrete.ItemBlockConcreteArrow;
import net.killermapper.roadstuff.common.items.concrete.ItemBlockConcreteCorner;
import net.killermapper.roadstuff.common.items.concrete.ItemBlockConcreteLine;
import net.killermapper.roadstuff.common.items.concrete.ItemBlockConcreteXCross;
import net.killermapper.roadstuff.common.items.concrete.ItemBlockConcreteXCrossYellow;
import net.killermapper.roadstuff.common.items.concrete.ItemBlockConcreteYCross;
import net.killermapper.roadstuff.common.items.concrete.ItemBlockConcreteYCrossYellow;
import net.killermapper.roadstuff.common.items.concrete.ItemBlockSlabConcrete;
import net.killermapper.roadstuff.common.items.concrete.ItemBlockSlabConcreteCorner;
import net.killermapper.roadstuff.common.items.concrete.ItemBlockSlabConcreteCornerDouble;
import net.killermapper.roadstuff.common.items.concrete.ItemBlockSlabConcreteLine;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class RoadStuffBlocks
{
    // Asphalt Blocks
    public static Block blockAsphaltLine;
    public static Block blockAsphalt;
    public static Block blockAsphaltCorner;
    public static Block blockAsphaltArrow;
    public static Block blockAsphaltYCross;
    public static Block blockAsphaltYCrossYellow;
    public static Block blockAsphaltXCrossYellow;
    public static Block blockAsphaltXCross;
    public static Block blockAsphaltWordExit;

    public static Block singleSlabAsphalt;
    public static Block doubleSlabAsphalt;
    public static Block singleSlabAsphaltLine;
    public static Block doubleSlabAsphaltLine;
    public static Block singleSlabAsphaltCorner;
    public static Block doubleSlabAsphaltCorner;
    public static Block singleSlabAsphaltCornerDouble;
    public static Block doubleSlabAsphaltCornerDouble;

    // Concrete Blocks
    public static Block blockConcrete;
    public static Block blockConcreteLine;
    public static Block blockConcreteCorner;
    public static Block blockConcreteYCross;
    public static Block blockConcreteXCross;
    public static Block blockConcreteYCrossYellow;
    public static Block blockConcreteXCrossYellow;
    public static Block blockConcreteArrow;

    public static Block singleSlabConcrete;
    public static Block doubleSlabConcrete;
    public static Block singleSlabConcreteLine;
    public static Block doubleSlabConcreteLine;
    public static Block singleSlabConcreteCorner;
    public static Block doubleSlabConcreteCorner;
    public static Block singleSlabConcreteCornerDouble;
    public static Block doubleSlabConcreteCornerDouble;

    // Ore Blocks
    public static Block blockBitumenOre;
    public static Block blockBitumenBlock;

    // Misc. Blocks
    public static Block blockCone;
    public static Block blockTrafficLight;
    public static Block blockTrafficSign;

    // Test Blocks
    public static Block blockEntityTest;

    public static void initBlocks()
    {
        // Asphalt blocks
        blockAsphalt = new BlockAsphalt().setBlockName("asphaltBlock").setHardness(1.0F).setResistance(5.0F);
        blockAsphaltLine = new BlockAsphaltLine().setBlockName("asphaltLine").setHardness(1.0F).setResistance(5.0F);
        blockAsphaltYCross = new BlockAsphaltYCross().setBlockName("asphaltYCross").setHardness(1.0F).setResistance(5.0F);
        blockAsphaltYCrossYellow = new BlockAsphaltYCrossYellow().setBlockName("asphaltYCrossYellow").setHardness(1.0F).setResistance(5.0F);
        blockAsphaltXCrossYellow = new BlockAsphaltXCrossYellow().setBlockName("asphaltXCrossYellow").setHardness(1.0F).setResistance(5.0F);
        blockAsphaltXCross = new BlockAsphaltXCross().setBlockName("asphaltXCross").setHardness(1.0F).setResistance(5.0F);
        blockAsphaltWordExit = new BlockAsphaltWordExit().setBlockName("asphaltWord1").setHardness(1.0F).setResistance(5.0F);
        blockAsphaltCorner = new BlockAsphaltCorner().setBlockName("asphaltCorner").setHardness(1.0F).setResistance(5.0F);
        blockAsphaltArrow = new BlockAsphaltArrow().setBlockName("asphaltArrow").setHardness(1.0F).setResistance(5.0F);

        singleSlabAsphalt = new BlockSlabAsphalt(false, null).setBlockName("slabAsphalt").setHardness(1.0F).setResistance(5.0F);
        doubleSlabAsphalt = new BlockSlabAsphalt(true, null).setBlockName("slabAsphalt").setHardness(1.0F).setResistance(5.0F);
        singleSlabAsphaltLine = new BlockSlabAsphaltLine(false, null).setBlockName("slabAsphaltLine").setHardness(1.0F).setResistance(5.0F);
        doubleSlabAsphaltLine = new BlockSlabAsphaltLine(true, null).setBlockName("slabAsphaltLine").setHardness(1.0F).setResistance(5.0F);
        singleSlabAsphaltCorner = new BlockSlabAsphaltCorner(false, null).setBlockName("slabAsphaltCorner").setHardness(1.0F).setResistance(5.0F);
        doubleSlabAsphaltCorner = new BlockSlabAsphaltCorner(true, null).setBlockName("slabAsphaltCorner").setHardness(1.0F).setResistance(5.0F);
        singleSlabAsphaltCornerDouble = new BlockSlabAsphaltCornerDouble(false, null).setBlockName("slabAsphaltCornerDouble").setHardness(1.0F).setResistance(5.0F);
        doubleSlabAsphaltCornerDouble = new BlockSlabAsphaltCornerDouble(true, null).setBlockName("slabAsphaltCornerDouble").setHardness(1.0F).setResistance(5.0F);

        // Concrete blocks
        blockConcrete = new BlockConcrete().setBlockName("concreteBlock").setHardness(1.0F).setResistance(5.0F);
        blockConcreteLine = new BlockConcreteLine().setBlockName("concreteLine").setHardness(1.0F).setResistance(5.0F);
        blockConcreteYCross = new BlockConcreteYCross().setBlockName("concreteYCross").setHardness(1.0F).setResistance(5.0F);
        blockConcreteXCross = new BlockConcreteXCross().setBlockName("concreteXCross").setHardness(1.0F).setResistance(5.0F);
        blockConcreteYCrossYellow = new BlockConcreteYCrossYellow().setBlockName("concreteYCrossYellow").setHardness(1.0F).setResistance(5.0F);
        blockConcreteXCrossYellow = new BlockConcreteXCrossYellow().setBlockName("concreteXCrossYellow").setHardness(1.0F).setResistance(5.0F);
        blockConcreteCorner = new BlockConcreteCorner().setBlockName("concreteCorner").setHardness(1.0F).setResistance(5.0F);
        blockConcreteArrow = new BlockConcreteArrow().setBlockName("concreteArrow").setHardness(1.0F).setResistance(5.0F);

        singleSlabConcrete = new BlockSlabConcrete(false, null).setBlockName("slabConcrete").setHardness(1.0F).setResistance(5.0F);
        doubleSlabConcrete = new BlockSlabConcrete(true, null).setBlockName("slabConcrete").setHardness(1.0F).setResistance(5.0F);
        singleSlabConcreteLine = new BlockSlabConcreteLine(false, null).setBlockName("slabConcreteLine").setHardness(1.0F).setResistance(5.0F);
        doubleSlabConcreteLine = new BlockSlabConcreteLine(true, null).setBlockName("slabConcreteLine").setHardness(1.0F).setResistance(5.0F);
        singleSlabConcreteCorner = new BlockSlabConcreteCorner(false, null).setBlockName("slabConcreteCorner").setHardness(1.0F).setResistance(5.0F);
        doubleSlabConcreteCorner = new BlockSlabConcreteCorner(true, null).setBlockName("slabConcreteCorner").setHardness(1.0F).setResistance(5.0F);
        singleSlabConcreteCornerDouble = new BlockSlabConcreteCornerDouble(false, null).setBlockName("slabConcreteCornerDouble").setHardness(1.0F).setResistance(5.0F);
        doubleSlabConcreteCornerDouble = new BlockSlabConcreteCornerDouble(true, null).setBlockName("slabConcreteCornerDouble").setHardness(1.0F).setResistance(5.0F);

        // Ore blocks
        blockBitumenOre = new BlockRoadstuffOre().setBlockName("bitumenOre").setHardness(1.5F).setResistance(10.0F).setBlockTextureName(RoadStuff.MODID + ":oreBitumen");

        // Misc. blocks
        blockCone = new BlockCone().setBlockName("cone").setHardness(1.0F).setResistance(1.0F);
        blockTrafficSign = new BlockTrafficSign().setBlockName("trafficSign").setHardness(1.0F).setResistance(1.0F);
        blockBitumenBlock = new BlockBase(Material.rock).setBlockName("bitumenBlock").setBlockTextureName(RoadStuff.MODID + ":bitumenBlock");
        blockTrafficLight = new BlockTrafficLigth().setBlockName("trafficLight");

        // Test
        blockEntityTest = new TestEntityBlock().setHardness(1.0F).setResistance(10.0F).setBlockName("EntityTest").setBlockTextureName(RoadStuff.MODID + ":blockTest").setCreativeTab(RoadStuff.RoadStuffCreativeTabs);

        registerBlocks();
        setHarvestLevels();
    }

    public static void setHarvestLevels()
    {
        // Asphalt Blocks
        blockAsphalt.setHarvestLevel("pickaxe", 1);
        blockAsphaltLine.setHarvestLevel("pickaxe", 1);
        blockAsphaltYCross.setHarvestLevel("pickaxe", 1);
        blockAsphaltYCrossYellow.setHarvestLevel("pickaxe", 1);
        blockAsphaltXCrossYellow.setHarvestLevel("pickaxe", 1);
        blockAsphaltXCross.setHarvestLevel("pickaxe", 1);
        blockAsphaltCorner.setHarvestLevel("pickaxe", 1);
        blockAsphaltArrow.setHarvestLevel("pickaxe", 1);
        blockAsphaltWordExit.setHarvestLevel("pickaxe", 1);

        singleSlabAsphalt.setHarvestLevel("pickaxe", 1);
        doubleSlabAsphalt.setHarvestLevel("pickaxe", 1);
        singleSlabAsphaltLine.setHarvestLevel("pickaxe", 1);
        doubleSlabAsphaltLine.setHarvestLevel("pickaxe", 1);
        singleSlabAsphaltCorner.setHarvestLevel("pickaxe", 1);
        doubleSlabAsphaltCorner.setHarvestLevel("pickaxe", 1);
        singleSlabAsphaltCornerDouble.setHarvestLevel("pickaxe", 1);
        doubleSlabAsphaltCornerDouble.setHarvestLevel("pickaxe", 1);

        // Concrete Blocks
        blockConcrete.setHarvestLevel("pickaxe", 1);
        blockConcreteLine.setHarvestLevel("pickaxe", 1);
        blockConcreteYCross.setHarvestLevel("pickaxe", 1);
        blockConcreteXCross.setHarvestLevel("pickaxe", 1);
        blockConcreteYCrossYellow.setHarvestLevel("pickaxe", 1);
        blockConcreteXCrossYellow.setHarvestLevel("pickaxe", 1);
        blockConcreteCorner.setHarvestLevel("pickaxe", 1);
        blockConcreteArrow.setHarvestLevel("pickaxe", 1);

        singleSlabConcrete.setHarvestLevel("pickaxe", 1);
        doubleSlabConcrete.setHarvestLevel("pickaxe", 1);
        singleSlabConcreteLine.setHarvestLevel("pickaxe", 1);
        doubleSlabConcreteLine.setHarvestLevel("pickaxe", 1);
        singleSlabConcreteCorner.setHarvestLevel("pickaxe", 1);
        doubleSlabConcreteCorner.setHarvestLevel("pickaxe", 1);
        singleSlabConcreteCornerDouble.setHarvestLevel("pickaxe", 1);
        doubleSlabConcreteCornerDouble.setHarvestLevel("pickaxe", 1);

        // Ore Blocks
        blockBitumenOre.setHarvestLevel("pickaxe", 0);
        blockBitumenBlock.setHarvestLevel("pickaxe", 0);

        // Misc. Blocks
        blockCone.setHarvestLevel("pickaxe", 0);
        blockTrafficSign.setHarvestLevel("pickaxe", 1);

        // Tests
    }

    public static void registerBlocks()
    {
        // Asphalt Blocks
        GameRegistry.registerBlock(blockAsphaltLine, ItemBlockAsphaltLine.class, "asphaltLine");
        GameRegistry.registerBlock(blockAsphaltYCross, ItemBlockAsphaltYCross.class, "asphaltYCross");
        GameRegistry.registerBlock(blockAsphaltYCrossYellow, ItemBlockAsphaltYCrossYellow.class, "asphaltYCrossYellow");
        GameRegistry.registerBlock(blockAsphaltXCrossYellow, ItemBlockAsphaltXCrossYellow.class, "asphaltXCrossYellow");
        GameRegistry.registerBlock(blockAsphaltXCross, ItemBlockAsphaltXCross.class, "asphaltXCross");
        GameRegistry.registerBlock(blockAsphalt, ItemBlockAsphalt.class, "asphaltBlock");
        GameRegistry.registerBlock(blockAsphaltCorner, ItemBlockAsphaltCorner.class, "asphaltCorner");
        GameRegistry.registerBlock(blockAsphaltArrow, ItemBlockAsphaltArrow.class, "asphaltArrow");
        GameRegistry.registerBlock(blockAsphaltWordExit, ItemBlockAsphaltWordExit.class, "asphaltWordExit");

        GameRegistry.registerBlock(singleSlabAsphalt, ItemBlockSlabAsphalt.class, "singleSlabAsphalt");
        GameRegistry.registerBlock(doubleSlabAsphalt, ItemBlockSlabAsphalt.class, "doubleSlabAsphalt");
        GameRegistry.registerBlock(singleSlabAsphaltLine, ItemBlockSlabAsphaltLine.class, "singleSlabAsphaltLine");
        GameRegistry.registerBlock(doubleSlabAsphaltLine, ItemBlockSlabAsphaltLine.class, "doubleSlabAsphaltLine");
        GameRegistry.registerBlock(singleSlabAsphaltCorner, ItemBlockSlabAsphaltCorner.class, "singleSlabAsphaltCorner");
        GameRegistry.registerBlock(doubleSlabAsphaltCorner, ItemBlockSlabAsphaltCorner.class, "doubleSlabAsphaltCorner");
        GameRegistry.registerBlock(singleSlabAsphaltCornerDouble, ItemBlockSlabAsphaltCornerDouble.class, "singleSlabAsphaltCornerDouble");
        GameRegistry.registerBlock(doubleSlabAsphaltCornerDouble, ItemBlockSlabAsphaltCornerDouble.class, "doubleSlabAsphaltCornerDouble");

        // Concrete Blocks
        GameRegistry.registerBlock(blockConcrete, ItemBlockConcrete.class, "concreteBlock");
        GameRegistry.registerBlock(blockConcreteLine, ItemBlockConcreteLine.class, "concreteLine");
        GameRegistry.registerBlock(blockConcreteYCross, ItemBlockConcreteYCross.class, "concreteYCross");
        GameRegistry.registerBlock(blockConcreteXCross, ItemBlockConcreteXCross.class, "concreteXCross");
        GameRegistry.registerBlock(blockConcreteYCrossYellow, ItemBlockConcreteYCrossYellow.class, "concreteYCrossYellow");
        GameRegistry.registerBlock(blockConcreteXCrossYellow, ItemBlockConcreteXCrossYellow.class, "concreteXCrossYellow");
        GameRegistry.registerBlock(blockConcreteCorner, ItemBlockConcreteCorner.class, "concreteCorner");
        GameRegistry.registerBlock(blockConcreteArrow, ItemBlockConcreteArrow.class, "concreteArrow");

        GameRegistry.registerBlock(singleSlabConcrete, ItemBlockSlabConcrete.class, "singleSlabConcrete");
        GameRegistry.registerBlock(doubleSlabConcrete, ItemBlockSlabConcrete.class, "doubleSlabConcrete");
        GameRegistry.registerBlock(singleSlabConcreteLine, ItemBlockSlabConcreteLine.class, "singleSlabConcreteLine");
        GameRegistry.registerBlock(doubleSlabConcreteLine, ItemBlockSlabConcreteLine.class, "doubleSlabConcreteLine");
        GameRegistry.registerBlock(singleSlabConcreteCorner, ItemBlockSlabConcreteCorner.class, "singleSlabConcreteCorner");
        GameRegistry.registerBlock(doubleSlabConcreteCorner, ItemBlockSlabConcreteCorner.class, "doubleSlabConcreteCorner");
        GameRegistry.registerBlock(singleSlabConcreteCornerDouble, ItemBlockSlabConcreteCornerDouble.class, "singleSlabConcreteCornerDouble");
        GameRegistry.registerBlock(doubleSlabConcreteCornerDouble, ItemBlockSlabConcreteCornerDouble.class, "doubleSlabConcreteCornerDouble");

        // Ore Blocks
        GameRegistry.registerBlock(blockBitumenOre, "bitumenOre");

        // Misc. Blocks
        GameRegistry.registerBlock(blockCone, ItemBlockCone.class, "cone");
        GameRegistry.registerBlock(blockBitumenBlock, "bitumenBlock");
        GameRegistry.registerBlock(blockTrafficLight, ItemBlockTrafficLight.class, "trafficLigth");
        GameRegistry.registerBlock(blockTrafficSign, ItemBlockTrafficSign.class, "trafficSign");

        // Test Blocks
        GameRegistry.registerBlock(blockEntityTest, "entityTest");
    }
}
