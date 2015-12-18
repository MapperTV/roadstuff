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

package net.killermapper.roadstuff.common.blocks.asphalt;

import java.util.List;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.killermapper.roadstuff.common.RoadStuff;
import net.killermapper.roadstuff.common.init.RoadStuffBlocks;
import net.killermapper.roadstuff.proxy.ClientProxy;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockSlabAsphaltLine extends BlockSlab
{
    public static final String[] StepTypes = new String[] {"simplewhiteline", "simpleyellowline", "doublewhiteline", "doubleyellowline"};

    public BlockSlabAsphaltLine(boolean isdouble, Material material)
    {
        super(isdouble, Material.rock);
        this.setCreativeTab(RoadStuff.RoadStuffCreativeTabs);
        if(!this.field_150004_a)
        {
            this.setLightOpacity(0);
        }
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int metadata)
    {
        int k = metadata & 7;
        return k == 0 ? RoadStuffBlocks.blockAsphaltLine.getIcon(side, 0) : k == 1 ? RoadStuffBlocks.blockAsphaltLine.getIcon(side, 1) : k == 2 ? RoadStuffBlocks.blockAsphaltLine.getIcon(side, 4) : k == 3 ? RoadStuffBlocks.blockAsphaltLine.getIcon(side, 5) : k == 4 ? RoadStuffBlocks.blockAsphaltLine.getIcon(side, 0) : k == 5 ? RoadStuffBlocks.blockAsphaltLine.getIcon(side, 1) : k == 6 ? RoadStuffBlocks.blockAsphaltLine.getIcon(side, 4) : k == 7 ? RoadStuffBlocks.blockAsphaltLine.getIcon(side, 5) : RoadStuffBlocks.blockAsphalt.getIcon(side, 0);
    }

    @SideOnly(Side.CLIENT)
    public int getRenderType()
    {
        return ClientProxy.renderSlabAsphaltLineId;
    }

    @SideOnly(Side.CLIENT)
    private static boolean func_150003_a(Block block)
    {
        return block == RoadStuffBlocks.singleSlabAsphaltLine;
    }

    @SideOnly(Side.CLIENT)
    public Item getItem(World p_149694_1_, int p_149694_2_, int p_149694_3_, int p_149694_4_)
    {
        return func_150003_a(this) ? Item.getItemFromBlock(RoadStuffBlocks.singleSlabAsphaltLine) : Item.getItemFromBlock(RoadStuffBlocks.doubleSlabAsphaltLine);
    }

    public Item getItemDropped(int metadata, Random rand, int fortune)
    {
        return Item.getItemFromBlock(RoadStuffBlocks.singleSlabAsphaltLine);
    }

    public int damageDropped(int metadata)
    {
        if(metadata == 4 || metadata == 8 || metadata == 12)
            return 0;
        if(metadata == 5 || metadata == 9 || metadata == 13)
            return 1;
        if(metadata == 6 || metadata == 10 || metadata == 14)
            return 2;
        if(metadata == 7 || metadata == 11 || metadata == 15)
            return 3;
        return metadata;
    }

    protected ItemStack createStackedBlock(int metadata)
    {
        return new ItemStack(RoadStuffBlocks.singleSlabAsphaltLine, 2, metadata & 7);
    }

    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item item, CreativeTabs creativeTabs, List list)
    {
        if(item != Item.getItemFromBlock(RoadStuffBlocks.doubleSlabAsphaltLine))
        {
            for(int i = 0; i < StepTypes.length; i++)
            {
                list.add(new ItemStack(item, 1, i));
            }
        }
    }

    @Override
    public String func_150002_b(int metadata)
    {
        if(metadata < 0 || metadata >= StepTypes.length)
        {
            metadata = 0;
        }
        return super.getUnlocalizedName() + "." + StepTypes[metadata];
    }
}
