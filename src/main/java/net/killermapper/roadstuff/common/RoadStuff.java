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

package net.killermapper.roadstuff.common;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.killermapper.roadstuff.common.blocks.BlockAsphaltArrows01;
import net.killermapper.roadstuff.common.blocks.BlockAsphaltBase01;
import net.killermapper.roadstuff.common.blocks.BlockAsphaltLines01;
import net.killermapper.roadstuff.common.blocks.BlockAsphaltLines02;
import net.killermapper.roadstuff.common.blocks.BlockAsphaltLines03;
import net.killermapper.roadstuff.common.blocks.BlockAsphaltLines04;
import net.killermapper.roadstuff.common.blocks.BlockAsphaltLines05;
import net.killermapper.roadstuff.common.blocks.BlockAsphaltLinesCorner01;
import net.killermapper.roadstuff.common.blocks.BlockCone01;
import net.killermapper.roadstuff.common.blocks.TestEntityBlock;
import net.killermapper.roadstuff.common.blocks.TileEntityTest;
import net.killermapper.roadstuff.common.items.ItemBitumen;
import net.killermapper.roadstuff.common.items.ItemBlockAsphaltArrows01;
import net.killermapper.roadstuff.common.items.ItemBlockAsphaltBase01;
import net.killermapper.roadstuff.common.items.ItemBlockAsphaltCorner01;
import net.killermapper.roadstuff.common.items.ItemBlockAsphaltLines01;
import net.killermapper.roadstuff.common.items.ItemBlockAsphaltLines02;
import net.killermapper.roadstuff.common.items.ItemBlockAsphaltLines03;
import net.killermapper.roadstuff.common.items.ItemBlockAsphaltLines04;
import net.killermapper.roadstuff.common.items.ItemBlockAsphaltLines05;
import net.killermapper.roadstuff.common.items.ItemPaintbrush;
import net.killermapper.roadstuff.proxy.CommonProxy;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

@Mod(modid = RoadStuff.MODID, name = "Road Stuff", version = "0.1")

public class RoadStuff
{

    public static final String MODID = "roadstuff";
    @Instance("MODID")
    public static RoadStuff instance;

    @SidedProxy(clientSide = "net.killermapper.roadstuff.proxy.ClientProxy", serverSide = "net.killermapper.roadstuff.proxy.CommonProxy")
    public static CommonProxy proxy;

    public static CreativeTabs RoadStuffCreativeTabs = new CreativeTabs("RoadStuff")
    {
        @Override
        public Item getTabIconItem()
        {
            return Item.getItemFromBlock(RoadStuff.blockAsphaltLines01);
        }

        @SideOnly(Side.CLIENT)
        public int func_151243_f()
        {
            return 0;
        }
    };

    public static Item itemBitumen, itemPaint;
    public static Block blockAsphaltLines01, blockAsphaltBase01, blockEntityTest, blockCone01, blockAsphaltLinesCorner01, blockAsphaltLinesArrows01, blockAsphaltLines02, blockAsphaltLines03, blockAsphaltLines04, blockAsphaltLines05;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        // Item Creation
        itemBitumen = new ItemBitumen().setUnlocalizedName("bitumen").setTextureName(MODID + ":itemBitumen").setCreativeTab(RoadStuff.RoadStuffCreativeTabs);
        itemPaint = new ItemPaintbrush().setUnlocalizedName("paint").setTextureName(MODID + ":itemPaint").setCreativeTab(RoadStuff.RoadStuffCreativeTabs);

        GameRegistry.registerItem(itemBitumen, "itemBitumen");
        GameRegistry.registerItem(itemPaint, "itemPaint");

        // Block Creation
        blockAsphaltLines01 = new BlockAsphaltLines01().setBlockName("asphaltLines01").setHardness(1.0F).setResistance(5.0F);
        blockAsphaltLines02 = new BlockAsphaltLines02().setBlockName("asphaltLines02").setHardness(1.0F).setResistance(5.0F);
        blockAsphaltLines03 = new BlockAsphaltLines03().setBlockName("asphaltLines03").setHardness(1.0F).setResistance(5.0F);
        blockAsphaltLines04 = new BlockAsphaltLines04().setBlockName("asphaltLines04").setHardness(1.0F).setResistance(5.0F);
        blockAsphaltLines05 = new BlockAsphaltLines05().setBlockName("asphaltLines05").setHardness(1.0F).setResistance(5.0F);
        blockAsphaltBase01 = new BlockAsphaltBase01().setBlockName("asphaltBase01").setHardness(1.0F).setResistance(5.0F);
        blockAsphaltLinesCorner01 = new BlockAsphaltLinesCorner01().setBlockName("asphaltLinesCorner01").setHardness(1.0F).setResistance(5.0F);
        blockAsphaltLinesArrows01 = new BlockAsphaltArrows01().setBlockName("asphaltLinesArrows01").setHardness(1.0F).setResistance(5.0F);
        blockCone01 = new BlockCone01().setHardness(1.0F).setResistance(1.0F).setBlockName("cone01");

        // Tests
        blockEntityTest = new TestEntityBlock(Material.wood).setHardness(1.0F).setResistance(10.0F).setBlockName("EntityTest").setBlockTextureName(MODID + ":asphaltSewerManhole").setCreativeTab(RoadStuff.RoadStuffCreativeTabs);
        

        GameRegistry.registerBlock(blockAsphaltLines01, ItemBlockAsphaltLines01.class, "asphaltLines01");
        GameRegistry.registerBlock(blockAsphaltLines02, ItemBlockAsphaltLines02.class, "asphaltLines02");
        GameRegistry.registerBlock(blockAsphaltLines03, ItemBlockAsphaltLines03.class, "asphaltLines03");
        GameRegistry.registerBlock(blockAsphaltLines04, ItemBlockAsphaltLines04.class, "asphaltLines04");
        GameRegistry.registerBlock(blockAsphaltLines05, ItemBlockAsphaltLines05.class, "asphaltLines05");
        GameRegistry.registerBlock(blockAsphaltBase01, ItemBlockAsphaltBase01.class, "asphaltBase01");
        GameRegistry.registerBlock(blockAsphaltLinesCorner01, ItemBlockAsphaltCorner01.class, "asphaltLinesCorner01");
        GameRegistry.registerBlock(blockAsphaltLinesArrows01, ItemBlockAsphaltArrows01.class, "asphaltLinesArrows01");
        GameRegistry.registerBlock(blockEntityTest, "entityTest");
        GameRegistry.registerBlock(blockCone01, "cone01");

    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {

        GameRegistry.registerTileEntity(TileEntityTest.class, "roadstuff:entityTest");

        proxy.registerRender();
    }

    @EventHandler
    public void PostInit(FMLPostInitializationEvent event)
    {

    }

}
