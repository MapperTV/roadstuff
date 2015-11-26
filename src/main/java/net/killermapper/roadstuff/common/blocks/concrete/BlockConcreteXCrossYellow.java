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

package net.killermapper.roadstuff.common.blocks.concrete;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.killermapper.roadstuff.common.RoadStuff;
import net.killermapper.roadstuff.proxy.ClientProxy;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockConcreteXCrossYellow extends Block
{
    public static String[] subBlock = new String[] {"concretesimpleyellowxsidecross", "concretesimpleyellowxdoublecross", "concretesimpleyellowxcornercross", "concretesimpleyellowxcross"};
    private IIcon concreteBase, simpleYellowXsideCross, simpleYellowXdoubleCross, simpleYellowXcornerCross, simpleYellowXCross;

    public BlockConcreteXCrossYellow()
    {
        super(Material.rock);
        this.setCreativeTab(RoadStuff.RoadStuffCreativeTabs);
    }

    @SideOnly(Side.CLIENT)
    public int getRenderType()
    {
        return ClientProxy.renderAsphaltArrowsId;
    }

    public int damageDropped(int metadata)
    {
        if(metadata == 4 || metadata == 8 || metadata == 12)
            return 0;
        if(metadata == 5 || metadata == 9 || metadata == 13)
            return 1;
        if(metadata == 6 || metadata == 10 || metadata == 14)
            return 2;
        return metadata;
    }

    public void getSubBlocks(Item item, CreativeTabs tabs, List list)
    {
        for(int i = 0; i < subBlock.length; i++)
        {
            list.add(new ItemStack(item, 1, i));
        }
    }

    public void registerBlockIcons(IIconRegister iconRegister)
    {
        this.concreteBase = iconRegister.registerIcon(RoadStuff.MODID + ":concrete/concreteBase");
        this.simpleYellowXsideCross = iconRegister.registerIcon(RoadStuff.MODID + ":concrete/concreteSYLXsideCross");
        this.simpleYellowXdoubleCross = iconRegister.registerIcon(RoadStuff.MODID + ":concrete/concreteSYLXdoubleCross");
        this.simpleYellowXcornerCross = iconRegister.registerIcon(RoadStuff.MODID + ":concrete/concreteSYLXcornerCross");
        this.simpleYellowXCross = iconRegister.registerIcon(RoadStuff.MODID + ":concrete/concreteSYLXfullCross");
    }

    public IIcon getIcon(int side, int metadata)
    {
        if(side == 1)
        {
            if(metadata == 0 || metadata == 4 || metadata == 8 || metadata == 12)
            {
                return this.simpleYellowXsideCross;
            }
            if(metadata == 1 || metadata == 5 || metadata == 9 || metadata == 13)
            {
                return this.simpleYellowXdoubleCross;
            }
            if(metadata == 2 || metadata == 6 || metadata == 10 || metadata == 14)
            {
                return this.simpleYellowXcornerCross;
            }
            if(metadata == 3)
            {
                return this.simpleYellowXCross;
            }
        }
        return this.concreteBase;
    }

    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase living, ItemStack stack)
    {
        int meta = 0;
        int direction = MathHelper.floor_double((double)(living.rotationYaw * 4.0F / 360.0F) + 2.5D) & 3;
        if(stack.getItemDamage() == 0)
        {
            if(direction == 0)
                meta = 0;
            if(direction == 1)
                meta = 4;
            if(direction == 2)
                meta = 8;
            if(direction == 3)
                meta = 12;
        }
        if(stack.getItemDamage() == 1)
        {
            if(direction == 0)
                meta = 1;
            if(direction == 1)
                meta = 5;
            if(direction == 2)
                meta = 9;
            if(direction == 3)
                meta = 13;
        }
        if(stack.getItemDamage() == 2)
        {
            if(direction == 0)
                meta = 2;
            if(direction == 1)
                meta = 6;
            if(direction == 2)
                meta = 10;
            if(direction == 3)
                meta = 14;
        }
        if(stack.getItemDamage() == 3)
            meta = 3;
        world.setBlockMetadataWithNotify(x, y, z, meta, 2);
    }

}