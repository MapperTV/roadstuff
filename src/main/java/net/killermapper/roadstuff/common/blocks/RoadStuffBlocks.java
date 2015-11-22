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
import net.killermapper.roadstuff.common.blocks.concrete.BlockConcrete;
import net.killermapper.roadstuff.common.blocks.concrete.BlockConcreteCorner;
import net.killermapper.roadstuff.common.blocks.concrete.BlockConcreteLine;
import net.killermapper.roadstuff.common.blocks.concrete.BlockConcreteYCross;
import net.killermapper.roadstuff.common.items.ItemBlockAsphaltArrows01;
import net.killermapper.roadstuff.common.items.ItemBlockAsphaltBase01;
import net.killermapper.roadstuff.common.items.ItemBlockAsphaltCorner01;
import net.killermapper.roadstuff.common.items.ItemBlockAsphaltLines01;
import net.killermapper.roadstuff.common.items.ItemBlockAsphaltLines02;
import net.killermapper.roadstuff.common.items.ItemBlockAsphaltLines03;
import net.killermapper.roadstuff.common.items.ItemBlockAsphaltLines04;
import net.killermapper.roadstuff.common.items.ItemBlockAsphaltLines05;
import net.killermapper.roadstuff.common.items.ItemBlockCone01;
import net.killermapper.roadstuff.common.items.ItemBlockSlabAsphaltBase01;
import net.killermapper.roadstuff.common.items.ItemBlockSlabAsphaltLines01;
import net.killermapper.roadstuff.common.items.concrete.ItemBlockConcrete;
import net.killermapper.roadstuff.common.items.concrete.ItemBlockConcreteCorner;
import net.killermapper.roadstuff.common.items.concrete.ItemBlockConcreteLine;
import net.killermapper.roadstuff.common.items.concrete.ItemBlockConcreteYCross;
import net.minecraft.block.Block;

public class RoadStuffBlocks
{

    public static Block blockAsphaltLines01;
    public static Block blockAsphaltBase01;
    public static Block blockEntityTest;
    public static Block blockCone01;
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
    public static Block blockBitumenOre;

    public static void initBlocks()
    {
        //Asphalt blocks
        RoadStuffBlocks.blockAsphaltLines01 = new BlockAsphaltLines01().setBlockName("asphaltLines01").setHardness(1.0F).setResistance(5.0F);
        RoadStuffBlocks.blockAsphaltLines02 = new BlockAsphaltLines02().setBlockName("asphaltLines02").setHardness(1.0F).setResistance(5.0F);
        RoadStuffBlocks.blockAsphaltLines03 = new BlockAsphaltLines03().setBlockName("asphaltLines03").setHardness(1.0F).setResistance(5.0F);
        RoadStuffBlocks.blockAsphaltLines04 = new BlockAsphaltLines04().setBlockName("asphaltLines04").setHardness(1.0F).setResistance(5.0F);
        RoadStuffBlocks.blockAsphaltLines05 = new BlockAsphaltLines05().setBlockName("asphaltLines05").setHardness(1.0F).setResistance(5.0F);
        RoadStuffBlocks.blockAsphaltBase01 = new BlockAsphaltBase01().setBlockName("asphaltBase01").setHardness(1.0F).setResistance(5.0F);
        RoadStuffBlocks.singleSlabAsphaltBase01 = new BlockSlabAsphaltBase01(false, null).setBlockName("slabAsphaltBase01").setHardness(1.0F).setResistance(5.0F);
        RoadStuffBlocks.doubleSlabAsphaltBase01 = new BlockSlabAsphaltBase01(true, null).setBlockName("slabAsphaltBase01").setHardness(1.0F).setResistance(5.0F);
        RoadStuffBlocks.singleSlabAsphaltLines01 = new BlockSlabAsphaltLines01(false, null).setBlockName("slabAsphaltLines01").setHardness(1.0F).setResistance(5.0F);
        RoadStuffBlocks.doubleSlabAsphaltLines01 = new BlockSlabAsphaltLines01(true, null).setBlockName("slabAsphaltLines01").setHardness(1.0F).setResistance(5.0F);
        RoadStuffBlocks.blockAsphaltLinesCorner01 = new BlockAsphaltLinesCorner01().setBlockName("asphaltLinesCorner01").setHardness(1.0F).setResistance(5.0F);
        RoadStuffBlocks.blockAsphaltArrows01 = new BlockAsphaltArrows01().setBlockName("asphaltLinesArrows01").setHardness(1.0F).setResistance(5.0F);
        
        //Concrete blocks
        RoadStuffBlocks.blockConcrete = new BlockConcrete().setBlockName("concreteBase").setHardness(1.0F).setResistance(5.0F);
        RoadStuffBlocks.blockConcreteLine = new BlockConcreteLine().setBlockName("concreteLine").setHardness(1.0F).setResistance(5.0F);
        RoadStuffBlocks.blockConcreteYCross = new BlockConcreteYCross().setBlockName("concreteYCross").setHardness(1.0F).setResistance(5.0F);
        RoadStuffBlocks.blockConcreteCorner = new BlockConcreteCorner().setBlockName("concreteCorner").setHardness(1.0F).setResistance(5.0F);
        
        //Ore blocks
        RoadStuffBlocks.blockBitumenOre = new BlockRoadstuffOre().setBlockName("bitumenOre").setHardness(1.5F).setResistance(10.0F).setBlockTextureName(RoadStuff.MODID + ":oreBitumen");
        
        //Misc. blocks
        RoadStuffBlocks.blockCone01 = new BlockCone01().setBlockName("cone01").setHardness(1.0F).setResistance(1.0F);

        // Test
        RoadStuffBlocks.blockEntityTest = new TestEntityBlock().setHardness(1.0F).setResistance(10.0F).setBlockName("EntityTest").setBlockTextureName(RoadStuff.MODID + ":asphaltSewerManhole").setCreativeTab(RoadStuff.RoadStuffCreativeTabs);

        RoadStuffBlocks.registerBlocks();
        RoadStuffBlocks.setHarvestLevels();
    }

    public static void setHarvestLevels()
    {
        RoadStuffBlocks.blockAsphaltLines01.setHarvestLevel("pickaxe", 1);
        RoadStuffBlocks.blockAsphaltLines02.setHarvestLevel("pickaxe", 1);
        RoadStuffBlocks.blockAsphaltLines03.setHarvestLevel("pickaxe", 1);
        RoadStuffBlocks.blockAsphaltLines04.setHarvestLevel("pickaxe", 1);
        RoadStuffBlocks.blockAsphaltLines05.setHarvestLevel("pickaxe", 1);
        RoadStuffBlocks.blockAsphaltBase01.setHarvestLevel("pickaxe", 1);
        RoadStuffBlocks.singleSlabAsphaltBase01.setHarvestLevel("pickaxe", 1);
        RoadStuffBlocks.doubleSlabAsphaltBase01.setHarvestLevel("pickaxe", 1);
        RoadStuffBlocks.singleSlabAsphaltLines01.setHarvestLevel("pickaxe", 1);
        RoadStuffBlocks.doubleSlabAsphaltLines01.setHarvestLevel("pickaxe", 1);
        RoadStuffBlocks.blockAsphaltLinesCorner01.setHarvestLevel("pickaxe", 1);
        RoadStuffBlocks.blockAsphaltArrows01.setHarvestLevel("pickaxe", 1);
        RoadStuffBlocks.blockCone01.setHarvestLevel("pickaxe", 0);
        RoadStuffBlocks.blockConcrete.setHarvestLevel("pickaxe", 1);
        RoadStuffBlocks.blockConcreteLine.setHarvestLevel("pickaxe", 1);
        RoadStuffBlocks.blockConcreteYCross.setHarvestLevel("pickaxe", 1);
        RoadStuffBlocks.blockConcreteCorner.setHarvestLevel("pickaxe", 1);
        RoadStuffBlocks.blockBitumenOre.setHarvestLevel("pickaxe", 0);

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
        GameRegistry.registerBlock(blockAsphaltArrows01, ItemBlockAsphaltArrows01.class, "asphaltLinesArrows01");
        GameRegistry.registerBlock(blockEntityTest, "entityTest");
        GameRegistry.registerBlock(blockCone01, ItemBlockCone01.class, "cone01");
        GameRegistry.registerBlock(blockConcrete, ItemBlockConcrete.class, "concreteBase");
        GameRegistry.registerBlock(blockConcreteLine, ItemBlockConcreteLine.class, "concreteLine");
        GameRegistry.registerBlock(blockConcreteYCross, ItemBlockConcreteYCross.class, "concreteYCross");
        GameRegistry.registerBlock(blockConcreteCorner, ItemBlockConcreteCorner.class, "concreteCorner");
        GameRegistry.registerBlock(blockBitumenOre, "bitumenOre");
    }

}
