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

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.killermapper.roadstuff.common.RoadStuff;
import net.killermapper.roadstuff.proxy.ClientProxy;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.IconFlipped;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class TestRotateBlock extends Block {

	public static String[] subBlock = new String[] { "simplewhiteline", "simpleyellowline", "largewhiteline", "largeyellowline", "doublewhiteline", "doubleyellowline" };
	private IIcon asphaltBase, simpleWhiteLine, simpleYellowLine, largeWhiteLine, largeYellowLine, doubleWhiteLine, doubleYellowLine;
	
	public TestRotateBlock() {
		super(Material.rock);
	}
	
	@SideOnly(Side.CLIENT)
	public int getRenderType()
	{
		return ClientProxy.renderAsphaltLinesId;
	}
	
	public int damageDropped(int metadata) {
		if(metadata == 8)
			return 0;
		if(metadata == 9)
			return 1;
		if(metadata == 10)
			return 2;
		if(metadata == 11)
			return 3;
		if(metadata == 12)
			return 4;
		if(metadata == 13)
			return 5;
		return metadata;
	}
	
		public void getSubBlocks(Item item, CreativeTabs tabs, List list) {
			for (int i = 0; i < subBlock.length; i++) {
				list.add(new ItemStack(item, 1, i));
			}
		}
	
	public void registerBlockIcons(IIconRegister iconRegister)
    {
    	this.asphaltBase = iconRegister.registerIcon(RoadStuff.MODID + ":asphaltBase");
		this.simpleWhiteLine = iconRegister.registerIcon(RoadStuff.MODID + ":asphaltSimpleWhiteLine");
		this.simpleYellowLine = iconRegister.registerIcon(RoadStuff.MODID + ":asphaltSimpleYellowLine");
		this.largeWhiteLine = iconRegister.registerIcon(RoadStuff.MODID + ":asphaltLargeWhiteLine");
		this.largeYellowLine = iconRegister.registerIcon(RoadStuff.MODID + ":asphaltLargeYellowLine");
		this.doubleWhiteLine = iconRegister.registerIcon(RoadStuff.MODID + ":asphaltDoubleWhiteLine");
		this.doubleYellowLine = iconRegister.registerIcon(RoadStuff.MODID + ":asphaltDoubleYellowLine");
    	//this.top2 = new IconFlipped(this.top2, true, false); Keeping this as reminder for corners
    	
    }
	
	public IIcon getIcon(int side, int metadata)
    {
		if (side == 1) {
			if(metadata == 0 || metadata == 8){
				return this.simpleWhiteLine;
			}
			if(metadata == 1 || metadata == 9){
				return this.simpleYellowLine;
			}
			if(metadata == 2 || metadata == 10){
				return this.largeWhiteLine;
			}
			if(metadata == 3 || metadata == 11){
				return this.largeYellowLine;
			}
			if(metadata == 4 || metadata == 12){
				return this.doubleWhiteLine;
			}
			if(metadata == 5 || metadata == 13){
				return this.doubleYellowLine;
			}
		}
		return this.asphaltBase;
    }
		
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase living, ItemStack stack)
    {
        int meta = 0;
		int direction = MathHelper.floor_double((double)(living.rotationYaw * 4.0F / 360.0F) + 2.5D) & 3;
        if(stack.getItemDamage() == 0)
        {
        	if(direction == 0 || direction == 2)
        		meta = 0;
        	if(direction == 1 || direction == 3)
        		meta = 8;
        }
        if(stack.getItemDamage() == 1)
        {
        	if(direction == 0 || direction == 2)
        		meta = 1;
        	if(direction == 1 || direction == 3)
        		meta = 9;
        }
        if(stack.getItemDamage() == 2)
        {
        	if(direction == 0 || direction == 2)
        		meta = 2;
        	if(direction == 1 || direction == 3)
        		meta = 10;
        }
        if(stack.getItemDamage() == 3)
        {
        	if(direction == 0 || direction == 2)
        		meta = 3;
        	if(direction == 1 || direction == 3)
        		meta = 11;
        }
        if(stack.getItemDamage() == 4)
        {
        	if(direction == 0 || direction == 2)
        		meta = 4;
        	if(direction == 1 || direction == 3)
        		meta = 12;
        }
        if(stack.getItemDamage() == 5)
        {
        	if(direction == 0 || direction == 2)
        		meta = 5;
        	if(direction == 1 || direction == 3)
        		meta = 13;
        }
        world.setBlockMetadataWithNotify(x, y, z, meta, 2);
    }
}
