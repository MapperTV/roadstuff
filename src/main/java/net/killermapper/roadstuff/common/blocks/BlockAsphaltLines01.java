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

import java.util.List;

import net.killermapper.roadstuff.common.RoadStuff;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class BlockAsphaltLines01 extends Block {

	public static String[] subBlock = new String[] { "simplewhiteline", "simpleyellowline", "largewhiteline", "largeyellowline", "doublewhiteline", "doubleyellowline" };
	private IIcon asphaltBase, simpleWhiteLine, simpleYellowLine, largeWhiteLine, largeYellowLine, doubleWhiteLine, doubleYellowLine;
	
	public BlockAsphaltLines01() {
		super(Material.rock);
	}
	
	public int damageDropped(int metadata) {
		return metadata;
	}
	
	public void getSubBlocks(Item item, CreativeTabs tabs, List list) {
		for (int i = 0; i < subBlock.length; i++) {
			list.add(new ItemStack(item, 1, i));
		}
	}
	
	public void registerBlockIcons(IIconRegister iconRegister) {
		this.asphaltBase = iconRegister.registerIcon(RoadStuff.MODID + ":asphaltBase");
		this.simpleWhiteLine = iconRegister.registerIcon(RoadStuff.MODID + ":asphaltSimpleWhiteLine");
		this.simpleYellowLine = iconRegister.registerIcon(RoadStuff.MODID + ":asphaltSimpleYellowLine");
		this.largeWhiteLine = iconRegister.registerIcon(RoadStuff.MODID + ":asphaltLargeWhiteLine");
		this.largeYellowLine = iconRegister.registerIcon(RoadStuff.MODID + ":asphaltLargeYellowLine");
		this.doubleWhiteLine = iconRegister.registerIcon(RoadStuff.MODID + ":asphaltDoubleWhiteLine");
		this.doubleYellowLine = iconRegister.registerIcon(RoadStuff.MODID + ":asphaltDoubleYellowLine");
	}
	
	public IIcon getIcon(int side, int metadata) {
		switch (metadata) {
		case 0:
			if (side == 1) {
				return this.simpleWhiteLine;
			}
			return this.asphaltBase;
		case 1:
			if (side == 1) {
				return this.simpleYellowLine;
			}
			return this.asphaltBase;
		case 2:
			if (side == 1) {
				return this.largeWhiteLine;
			}
			return this.asphaltBase;
		case 3:
			if (side == 1) {
				return this.largeYellowLine;
			}
			return this.asphaltBase;
		case 4:
			if (side == 1) {
				return this.doubleWhiteLine;
			}
			return this.asphaltBase;
		case 5:
			if (side == 1) {
				return this.doubleYellowLine;
			}
			return this.asphaltBase;
		default:
			return this.asphaltBase;
		}
	}
}
