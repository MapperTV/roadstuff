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
import net.killermapper.roadstuff.common.blocks.asphalt.BlockAsphaltArrows01;
import net.killermapper.roadstuff.common.blocks.asphalt.BlockAsphaltBase01;
import net.killermapper.roadstuff.common.blocks.asphalt.BlockAsphaltLines01;
import net.killermapper.roadstuff.common.blocks.asphalt.BlockAsphaltLines02;
import net.killermapper.roadstuff.common.blocks.asphalt.BlockAsphaltLines03;
import net.killermapper.roadstuff.common.blocks.asphalt.BlockAsphaltLines04;
import net.killermapper.roadstuff.common.blocks.asphalt.BlockAsphaltLines05;
import net.killermapper.roadstuff.common.blocks.asphalt.BlockAsphaltLinesCorner01;
import net.killermapper.roadstuff.common.blocks.asphalt.BlockAsphaltWord1;
import net.killermapper.roadstuff.common.blocks.asphalt.BlockSlabAsphaltBase01;
import net.killermapper.roadstuff.common.blocks.asphalt.BlockSlabAsphaltLines01;
import net.killermapper.roadstuff.common.blocks.concrete.BlockConcrete;
import net.killermapper.roadstuff.common.blocks.concrete.BlockConcreteArrow;
import net.killermapper.roadstuff.common.blocks.concrete.BlockConcreteCorner;
import net.killermapper.roadstuff.common.blocks.concrete.BlockConcreteLine;
import net.killermapper.roadstuff.common.blocks.concrete.BlockConcreteXCross;
import net.killermapper.roadstuff.common.blocks.concrete.BlockConcreteXCrossYellow;
import net.killermapper.roadstuff.common.blocks.concrete.BlockConcreteYCross;
import net.killermapper.roadstuff.common.blocks.concrete.BlockConcreteYCrossYellow;
import net.killermapper.roadstuff.common.items.ItemBlockCone;
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

    public static Block blockAsphaltLines01;
    public static Block blockAsphaltBase01;
    public static Block blockEntityTest;
    public static Block blockCone;
    public static Block blockAsphaltLinesCorner01;
    public static Block blockAsphaltArrows01;
    public static Block blockAsphaltLines02;
    public static Block blockAsphaltLines03;
    public static Block blockAsphaltLines04;
    public static Block blockAsphaltLines05;
    public static Block singleSlabAsphaltBase01;
    public static Block doubleSlabAsphaltBase01;
    public static Block singleSlabAsphaltLines01;
    public static Block doubleSlabAsphaltLines01;
    public static Block blockConcrete;
    public static Block blockConcreteLine;
    public static Block blockConcreteCorner;
    public static Block blockConcreteYCross;
    public static Block blockConcreteXCross;
    public static Block blockConcreteYCrossYellow;
    public static Block blockConcreteXCrossYellow;
    public static Block blockConcreteArrow;
    public static Block blockBitumenOre;
    public static Block blockBitumenBlock;
    public static Block blockAsphaltWord1;
    public static Block blockTrafficLight;

    public static void initBlocks()
    {
        // Asphalt blocks
        blockAsphaltBase01 = new BlockAsphaltBase01().setBlockName("asphaltBase01").setHardness(1.0F).setResistance(5.0F);
        blockAsphaltLines01 = new BlockAsphaltLines01().setBlockName("asphaltLines01").setHardness(1.0F).setResistance(5.0F);
        blockAsphaltLines02 = new BlockAsphaltLines02().setBlockName("asphaltLines02").setHardness(1.0F).setResistance(5.0F);
        blockAsphaltLines03 = new BlockAsphaltLines03().setBlockName("asphaltLines03").setHardness(1.0F).setResistance(5.0F);
        blockAsphaltLines04 = new BlockAsphaltLines04().setBlockName("asphaltLines04").setHardness(1.0F).setResistance(5.0F);
        blockAsphaltLines05 = new BlockAsphaltLines05().setBlockName("asphaltLines05").setHardness(1.0F).setResistance(5.0F);
        singleSlabAsphaltBase01 = new BlockSlabAsphaltBase01(false, null).setBlockName("slabAsphaltBase01").setHardness(1.0F).setResistance(5.0F);
        doubleSlabAsphaltBase01 = new BlockSlabAsphaltBase01(true, null).setBlockName("slabAsphaltBase01").setHardness(1.0F).setResistance(5.0F);
        singleSlabAsphaltLines01 = new BlockSlabAsphaltLines01(false, null).setBlockName("slabAsphaltLines01").setHardness(1.0F).setResistance(5.0F);
        doubleSlabAsphaltLines01 = new BlockSlabAsphaltLines01(true, null).setBlockName("slabAsphaltLines01").setHardness(1.0F).setResistance(5.0F);
        blockAsphaltLinesCorner01 = new BlockAsphaltLinesCorner01().setBlockName("asphaltLinesCorner01").setHardness(1.0F).setResistance(5.0F);
        blockAsphaltArrows01 = new BlockAsphaltArrows01().setBlockName("asphaltArrows01").setHardness(1.0F).setResistance(5.0F);
        blockAsphaltWord1 = new BlockAsphaltWord1().setBlockName("asphaltWord1").setHardness(1.0F).setResistance(5.0F);

        // Concrete blocks
        blockConcrete = new BlockConcrete().setBlockName("concreteBase").setHardness(1.0F).setResistance(5.0F);
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
        blockCone = new BlockCone().setBlockName("blockCone").setHardness(1.0F).setResistance(1.0F);
        blockBitumenBlock = new BlockBase(Material.rock).setBlockName("bitumenBlock").setBlockTextureName(RoadStuff.MODID + ":bitumenBlock");
        

        // Test
        blockEntityTest = new TestEntityBlock().setHardness(1.0F).setResistance(10.0F).setBlockName("EntityTest").setBlockTextureName(RoadStuff.MODID + ":blockTest").setCreativeTab(RoadStuff.RoadStuffCreativeTabs);

        //TraficLight blocks
        blockTrafficLight = new BlockTrafficLigth().setBlockName("traficLight");
        
        registerBlocks();
        setHarvestLevels();
    }

    public static void setHarvestLevels()
    {
        blockAsphaltLines01.setHarvestLevel("pickaxe", 1);
        blockAsphaltLines02.setHarvestLevel("pickaxe", 1);
        blockAsphaltLines03.setHarvestLevel("pickaxe", 1);
        blockAsphaltLines04.setHarvestLevel("pickaxe", 1);
        blockAsphaltLines05.setHarvestLevel("pickaxe", 1);
        blockAsphaltBase01.setHarvestLevel("pickaxe", 1);
        singleSlabAsphaltBase01.setHarvestLevel("pickaxe", 1);
        doubleSlabAsphaltBase01.setHarvestLevel("pickaxe", 1);
        singleSlabAsphaltLines01.setHarvestLevel("pickaxe", 1);
        doubleSlabAsphaltLines01.setHarvestLevel("pickaxe", 1);
        blockAsphaltLinesCorner01.setHarvestLevel("pickaxe", 1);
        blockAsphaltArrows01.setHarvestLevel("pickaxe", 1);
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
        blockAsphaltWord1.setHarvestLevel("pickaxe", 1);
    }

    public static void registerBlocks()
    {
        GameRegistry.registerBlock(blockAsphaltLines01, ItemBlockAsphaltLines01.class, "asphaltLines01");
        GameRegistry.registerBlock(blockAsphaltLines02, ItemBlockAsphaltLines02.class, "asphaltLines02");
        GameRegistry.registerBlock(blockAsphaltLines03, ItemBlockAsphaltLines03.class, "asphaltLines03");
        GameRegistry.registerBlock(blockAsphaltLines04, ItemBlockAsphaltLines04.class, "asphaltLines04");
        GameRegistry.registerBlock(blockAsphaltLines05, ItemBlockAsphaltLines05.class, "asphaltLines05");
        GameRegistry.registerBlock(blockAsphaltBase01, ItemBlockAsphaltBase01.class, "asphaltBase01");
        GameRegistry.registerBlock(singleSlabAsphaltBase01, ItemBlockSlabAsphaltBase01.class, "singleSlabAsphaltBase01");
        GameRegistry.registerBlock(doubleSlabAsphaltBase01, ItemBlockSlabAsphaltBase01.class, "doubleSlabAsphaltBase01");
        GameRegistry.registerBlock(singleSlabAsphaltLines01, ItemBlockSlabAsphaltLines01.class, "singleSlabAsphaltLines01");
        GameRegistry.registerBlock(doubleSlabAsphaltLines01, ItemBlockSlabAsphaltLines01.class, "doubleSlabAsphaltLines01");
        GameRegistry.registerBlock(blockAsphaltLinesCorner01, ItemBlockAsphaltCorner01.class, "asphaltLinesCorner01");
        GameRegistry.registerBlock(blockAsphaltArrows01, ItemBlockAsphaltArrows01.class, "asphaltArrows01");
        GameRegistry.registerBlock(blockEntityTest, "entityTest");
        GameRegistry.registerBlock(blockCone, ItemBlockCone.class, "cone01");
        GameRegistry.registerBlock(blockConcrete, ItemBlockConcrete.class, "concreteBase");
        GameRegistry.registerBlock(blockConcreteLine, ItemBlockConcreteLine.class, "concreteLine");
        GameRegistry.registerBlock(blockConcreteYCross, ItemBlockConcreteYCross.class, "concreteYCross");
        GameRegistry.registerBlock(blockConcreteXCross, ItemBlockConcreteXCross.class, "concreteXCross");
        GameRegistry.registerBlock(blockConcreteYCrossYellow, ItemBlockConcreteYCrossYellow.class, "concreteYCrossYellow");
        GameRegistry.registerBlock(blockConcreteXCrossYellow, ItemBlockConcreteXCrossYellow.class, "concreteXCrossYellow");
        GameRegistry.registerBlock(blockConcreteCorner, ItemBlockConcreteCorner.class, "concreteCorner");
        GameRegistry.registerBlock(blockConcreteArrow, ItemBlockConcreteArrow.class, "concreteArrow");
        GameRegistry.registerBlock(blockAsphaltWord1, ItemBlockAsphaltWord1.class, "asphaltWord1");
        GameRegistry.registerBlock(blockBitumenOre, "bitumenOre");
        GameRegistry.registerBlock(blockBitumenBlock, "bitumenBlock");
        GameRegistry.registerBlock(blockTrafficLight, "trafficLigth");
    }
}
