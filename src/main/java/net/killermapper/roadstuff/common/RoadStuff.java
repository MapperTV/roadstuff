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
import net.killermapper.roadstuff.common.blocks.BlockAsphaltBase01;
import net.killermapper.roadstuff.common.blocks.BlockAsphaltLines01;
import net.killermapper.roadstuff.common.blocks.TestEntityBlock;
import net.killermapper.roadstuff.common.blocks.TestISBRH;
import net.killermapper.roadstuff.common.blocks.TestRotateBlock;
import net.killermapper.roadstuff.common.blocks.TileEntityTest;
import net.killermapper.roadstuff.common.items.ItemBitumen;
import net.killermapper.roadstuff.common.items.ItemBlockAsphaltLines01;
import net.killermapper.roadstuff.common.items.ItemPaintbrush;
import net.killermapper.roadstuff.common.items.ItemTestRotateBlock;
import net.killermapper.roadstuff.proxy.CommonProxy;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

@Mod(modid = RoadStuff.MODID, name = "Road Stuff", version = "0.1")

public class RoadStuff {

	public static final String MODID = "roadstuff";
	@Instance("MODID")
	public static RoadStuff instance;

	@SidedProxy(clientSide = "net.killermapper.roadstuff.proxy.ClientProxy", serverSide = "net.killermapper.roadstuff.proxy.CommonProxy")
	public static CommonProxy proxy;

	public static Item itemBitumen, itemPaint;
	public static Block blockAsphaltLines01, blockAsphaltBase01, blockEntityTest, blockRotateTest, renderTest;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		//Item Creation
		itemBitumen = new ItemBitumen().setUnlocalizedName("bitumen").setTextureName(MODID + ":itemBitumen")
				.setCreativeTab(CreativeTabs.tabMaterials);
		itemPaint = new ItemPaintbrush().setUnlocalizedName("paint").setTextureName(MODID + ":itemPaint")
				.setCreativeTab(CreativeTabs.tabMaterials);

		GameRegistry.registerItem(itemBitumen, "itemBitumen");
		GameRegistry.registerItem(itemPaint, "itemPaint");
		
		//Block Creation
		blockAsphaltLines01 = new BlockAsphaltLines01().setBlockName("asphaltLines01").setHardness(1.5F).setResistance(10.0F)
				.setCreativeTab(CreativeTabs.tabBlock);
		blockAsphaltBase01 = new BlockAsphaltBase01().setBlockName("asphaltBase01").setHardness(1.5F).setResistance(10.0F)
				.setCreativeTab(CreativeTabs.tabBlock);
		//Tests
		blockEntityTest = new TestEntityBlock(Material.wood).setHardness(1.5F).setResistance(10.0F).setBlockName("EntityTest").setBlockTextureName(MODID + ":asphaltSewerManhole").setCreativeTab(CreativeTabs.tabBlock);
		blockRotateTest = new TestRotateBlock().setHardness(1.5F).setResistance(10.0F).setBlockName("RotateTest").setCreativeTab(CreativeTabs.tabBlock);
		renderTest = new TestISBRH().setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundTypeWood).setBlockName("table").setCreativeTab(CreativeTabs.tabBlock);

		GameRegistry.registerBlock(blockAsphaltLines01, ItemBlockAsphaltLines01.class, "asphaltLines01");
		GameRegistry.registerBlock(blockAsphaltBase01, ItemBlockAsphaltLines01.class, "asphaltBase01");
		GameRegistry.registerBlock(blockEntityTest, "entityTest");
		GameRegistry.registerBlock(blockRotateTest, ItemTestRotateBlock.class, "rotateTest");
		GameRegistry.registerBlock(renderTest, "table");

	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		
		GameRegistry.registerTileEntity(TileEntityTest.class, "roadstuff:entityTest");
		
		proxy.registerRender();
	}

	@EventHandler
	public void PostInit(FMLPostInitializationEvent event) {

	}

}
