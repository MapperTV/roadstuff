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
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;

public class BlockCone extends Block
{
    public static String[] subBlock = new String[] {"cone01", "cone02", "cone03"};
    private IIcon top, sides, bottom, base, top2;

    public BlockCone()
    {
        super(Material.ground);
        this.setCreativeTab(RoadStuff.RoadStuffCreativeTabs);
        this.setStepSound(soundTypeMetal);
    }

    public void registerBlockIcons(IIconRegister iiconRegister)
    {
        this.top = iiconRegister.registerIcon(RoadStuff.MODID + ":blockCone01Top");
        this.sides = iiconRegister.registerIcon(RoadStuff.MODID + ":blockCone01");
        this.bottom = iiconRegister.registerIcon(RoadStuff.MODID + ":blockConeBottom");
        this.base = iiconRegister.registerIcon(RoadStuff.MODID + ":blockConeBase");
        this.top2 = iiconRegister.registerIcon(RoadStuff.MODID + ":blockCone02Top");
    }

    public int damageDropped(int metadata)
    {
        return metadata;
    }

    public void getSubBlocks(Item item, CreativeTabs tabs, List list)
    {
        for(int i = 0; i < subBlock.length; i++)
        {
            list.add(new ItemStack(item, 1, i));
        }
    }

    public boolean renderAsNormalBlock()
    {
        return false;
    }

    public boolean isOpaqueCube()
    {
        return false;
    }

    @SideOnly(Side.CLIENT)
    public int getRenderType()
    {
        return ClientProxy.renderCone01Id;
    }

    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockAccess blockAccess, int x, int y, int z, int side)
    {
        return true;
    }

    public IIcon getIcon(int side, int metadata)
    {
        if(metadata == 2)
        {
            if(side == 1)
                return this.base;
        }
        if(metadata == 0)
        {
            if(side == 1)
                return this.top;
        }
        if(metadata == 1)
        {
            if(side == 1)
                return this.top2;
        }
        if(side == 0)
            return this.bottom;
        return this.sides;
    }

}