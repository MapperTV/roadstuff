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
import net.killermapper.roadstuff.common.blocks.asphalt.BlockSlabAsphaltLine;
import net.killermapper.roadstuff.common.blocks.concrete.BlockConcrete;
import net.killermapper.roadstuff.common.blocks.concrete.BlockConcreteArrow;
import net.killermapper.roadstuff.common.blocks.concrete.BlockConcreteCorner;
import net.killermapper.roadstuff.common.blocks.concrete.BlockConcreteLine;
import net.killermapper.roadstuff.common.blocks.concrete.BlockConcreteXCross;
import net.killermapper.roadstuff.common.blocks.concrete.BlockConcreteXCrossYellow;
import net.killermapper.roadstuff.common.blocks.concrete.BlockConcreteYCross;
import net.killermapper.roadstuff.common.blocks.concrete.BlockConcreteYCrossYellow;
import net.killermapper.roadstuff.common.items.ItemBlockCone;
import net.killermapper.roadstuff.common.items.ItemBlockTrafficLight;
import net.killermapper.roadstuff.common.items.ItemBlockTrafficSign;
import net.killermapper.roadstuff.common.items.asphalt.ItemBlockAsphaltArrows01;
import net.killermapper.roadstuff.common.items.asphalt.ItemBlockAsphaltBase01;
import net.killermapper.roadstuff.common.items.asphalt.ItemBlockAsphaltCorner01;
import net.killermapper.roadstuff.common.items.asphalt.ItemBlockAsphaltLines01;
import net.killermapper.roadstuff.common.items.asphalt.ItemBlockAsphaltLines02;
import net.killermapper.roadstuff.common.items.asphalt.ItemBlockAsphaltLines03;
import net.killermapper.roadstuff.common.items.asphalt.ItemBlockAsphaltLines04;
import net.killermapper.roadstuff.common.items.asphalt.ItemBlockAsphaltLines05;
import net.killermapper.roadstuff.common.items.asphalt.ItemBlockAsphaltWord1;
import net.killermapper.roadstuff.common.items.asphalt.ItemBlockSlabAsphaltBase01;
import net.killermapper.roadstuff.common.items.asphalt.ItemBlockSlabAsphaltLines01;
import net.killermapper.roadstuff.common.items.concrete.ItemBlockConcrete;
import net.killermapper.roadstuff.common.items.concrete.ItemBlockConcreteArrow;
import net.killermapper.roadstuff.common.items.concrete.ItemBlockConcreteCorner;
import net.killermapper.roadstuff.common.items.concrete.ItemBlockConcreteLine;
import net.killermapper.roadstuff.common.items.concrete.ItemBlockConcreteXCross;
import net.killermapper.roadstuff.common.items.concrete.ItemBlockConcreteXCrossYellow;
import net.killermapper.roadstuff.common.items.concrete.ItemBlockConcreteYCross;
import net.killermapper.roadstuff.common.items.concrete.ItemBlockConcreteYCrossYellow;
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

    // Concrete Blocks
    public static Block blockConcrete;
    public static Block blockConcreteLine;
    public static Block blockConcreteCorner;
    public static Block blockConcreteYCross;
    public static Block blockConcreteXCross;
    public static Block blockConcreteYCrossYellow;
    public static Block blockConcreteXCrossYellow;
    public static Block blockConcreteArrow;

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
        singleSlabAsphalt = new BlockSlabAsphalt(false, null).setBlockName("slabAsphalt").setHardness(1.0F).setResistance(5.0F);
        doubleSlabAsphalt = new BlockSlabAsphalt(true, null).setBlockName("slabAsphalt").setHardness(1.0F).setResistance(5.0F);
        singleSlabAsphaltLine = new BlockSlabAsphaltLine(false, null).setBlockName("slabAsphaltLine").setHardness(1.0F).setResistance(5.0F);
        doubleSlabAsphaltLine = new BlockSlabAsphaltLine(true, null).setBlockName("slabAsphaltLine").setHardness(1.0F).setResistance(5.0F);
        blockAsphaltCorner = new BlockAsphaltCorner().setBlockName("asphaltCorner").setHardness(1.0F).setResistance(5.0F);
        blockAsphaltArrow = new BlockAsphaltArrow().setBlockName("asphaltArrow").setHardness(1.0F).setResistance(5.0F);
        blockAsphaltWordExit = new BlockAsphaltWordExit().setBlockName("asphaltWord1").setHardness(1.0F).setResistance(5.0F);

        // Concrete blocks
        blockConcrete = new BlockConcrete().setBlockName("concreteBlock").setHardness(1.0F).setResistance(5.0F);
        blockConcreteLine = new BlockConcreteLine().setBlockName("concreteLine").setHardness(1.0F).setResistance(5.0F);
        blockConcreteYCross = new BlockConcreteYCross().setBlockName("concreteYCross").setHardness(1.0F).setResistance(5.0F);
        blockConcreteXCross = new BlockConcreteXCross().setBlockName("concreteXCross").setHardness(1.0F).setResistance(5.0F);
        blockConcreteYCrossYellow = new BlockConcreteYCrossYellow().setBlockName("concreteYCrossYellow").setHardness(1.0F).setResistance(5.0F);
        blockConcreteXCrossYellow = new BlockConcreteXCrossYellow().setBlockName("concreteXCrossYellow").setHardness(1.0F).setResistance(5.0F);
        blockConcreteCorner = new BlockConcreteCorner().setBlockName("concreteCorner").setHardness(1.0F).setResistance(5.0F);
        blockConcreteArrow = new BlockConcreteArrow().setBlockName("concreteArrow").setHardness(1.0F).setResistance(5.0F);

        // Ore blocks
        blockBitumenOre = new BlockRoadstuffOre().setBlockName("bitumenOre").setHardness(1.5F).setResistance(10.0F).setBlockTextureName(RoadStuff.MODID + ":oreBitumen");

        // Misc. blocks
        blockCone = new BlockCone().setBlockName("cone").setHardness(1.0F).setResistance(1.0F);
        blockTrafficSign = new BlockTrafficSign().setBlockName("trafficSign").setHardness(1.0F).setResistance(1.0F);
        blockBitumenBlock = new BlockBase(Material.rock).setBlockName("bitumenBlock").setBlockTextureName(RoadStuff.MODID + ":bitumenBlock");

        // Test
        blockEntityTest = new TestEntityBlock().setHardness(1.0F).setResistance(10.0F).setBlockName("EntityTest").setBlockTextureName(RoadStuff.MODID + ":blockTest").setCreativeTab(RoadStuff.RoadStuffCreativeTabs);

        // TraficLight blocks
        blockTrafficLight = new BlockTrafficLigth().setBlockName("trafficLight");

        registerBlocks();
        setHarvestLevels();
    }

    public static void setHarvestLevels()
    {
        blockAsphaltLine.setHarvestLevel("pickaxe", 1);
        blockAsphaltYCross.setHarvestLevel("pickaxe", 1);
        blockAsphaltYCrossYellow.setHarvestLevel("pickaxe", 1);
        blockAsphaltXCrossYellow.setHarvestLevel("pickaxe", 1);
        blockAsphaltXCross.setHarvestLevel("pickaxe", 1);
        blockAsphalt.setHarvestLevel("pickaxe", 1);
        singleSlabAsphalt.setHarvestLevel("pickaxe", 1);
        doubleSlabAsphalt.setHarvestLevel("pickaxe", 1);
        singleSlabAsphaltLine.setHarvestLevel("pickaxe", 1);
        doubleSlabAsphaltLine.setHarvestLevel("pickaxe", 1);
        blockAsphaltCorner.setHarvestLevel("pickaxe", 1);
        blockAsphaltArrow.setHarvestLevel("pickaxe", 1);
        blockCone.setHarvestLevel("pickaxe", 0);
        blockConcrete.setHarvestLevel("pickaxe", 1);
        blockConcreteLine.setHarvestLevel("pickaxe", 1);
        blockConcreteYCross.setHarvestLevel("pickaxe", 1);
        blockConcreteXCross.setHarvestLevel("pickaxe", 1);
        blockConcreteYCrossYellow.setHarvestLevel("pickaxe", 1);
        blockConcreteXCrossYellow.setHarvestLevel("pickaxe", 1);
        blockConcreteCorner.setHarvestLevel("pickaxe", 1);
        blockConcreteArrow.setHarvestLevel("pickaxe", 1);
        blockBitumenOre.setHarvestLevel("pickaxe", 0);
        blockBitumenBlock.setHarvestLevel("pickaxe", 0);
        blockAsphaltWordExit.setHarvestLevel("pickaxe", 1);
        blockTrafficSign.setHarvestLevel("pickaxe", 1);
    }

    public static void registerBlocks()
    {
        // Asphalt Blocks
        GameRegistry.registerBlock(blockAsphaltLine, ItemBlockAsphaltLines01.class, "asphaltLine");
        GameRegistry.registerBlock(blockAsphaltYCross, ItemBlockAsphaltLines02.class, "asphaltYCross");
        GameRegistry.registerBlock(blockAsphaltYCrossYellow, ItemBlockAsphaltLines03.class, "asphaltYCrossYellow");
        GameRegistry.registerBlock(blockAsphaltXCrossYellow, ItemBlockAsphaltLines04.class, "asphaltXCrossYellow");
        GameRegistry.registerBlock(blockAsphaltXCross, ItemBlockAsphaltLines05.class, "asphaltXCross");
        GameRegistry.registerBlock(blockAsphalt, ItemBlockAsphaltBase01.class, "asphaltBlock");
        GameRegistry.registerBlock(blockAsphaltCorner, ItemBlockAsphaltCorner01.class, "asphaltCorner");
        GameRegistry.registerBlock(blockAsphaltArrow, ItemBlockAsphaltArrows01.class, "asphaltArrow");
        GameRegistry.registerBlock(blockAsphaltWordExit, ItemBlockAsphaltWord1.class, "asphaltWordExit");

        GameRegistry.registerBlock(singleSlabAsphalt, ItemBlockSlabAsphaltBase01.class, "singleSlabAsphalt");
        GameRegistry.registerBlock(doubleSlabAsphalt, ItemBlockSlabAsphaltBase01.class, "doubleSlabAsphalt");
        GameRegistry.registerBlock(singleSlabAsphaltLine, ItemBlockSlabAsphaltLines01.class, "singleSlabAsphaltLine");
        GameRegistry.registerBlock(doubleSlabAsphaltLine, ItemBlockSlabAsphaltLines01.class, "doubleSlabAsphaltLine");

        // Concrete Blocks
        GameRegistry.registerBlock(blockConcrete, ItemBlockConcrete.class, "concreteBlock");
        GameRegistry.registerBlock(blockConcreteLine, ItemBlockConcreteLine.class, "concreteLine");
        GameRegistry.registerBlock(blockConcreteYCross, ItemBlockConcreteYCross.class, "concreteYCross");
        GameRegistry.registerBlock(blockConcreteXCross, ItemBlockConcreteXCross.class, "concreteXCross");
        GameRegistry.registerBlock(blockConcreteYCrossYellow, ItemBlockConcreteYCrossYellow.class, "concreteYCrossYellow");
        GameRegistry.registerBlock(blockConcreteXCrossYellow, ItemBlockConcreteXCrossYellow.class, "concreteXCrossYellow");
        GameRegistry.registerBlock(blockConcreteCorner, ItemBlockConcreteCorner.class, "concreteCorner");
        GameRegistry.registerBlock(blockConcreteArrow, ItemBlockConcreteArrow.class, "concreteArrow");

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
