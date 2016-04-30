/*
Road Stuff - A Minecraft MODification by KillerMapper - 2015-2016
The MIT License (MIT)
Copyright (c) 2015-2016 KillerMapper
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
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockReflector extends Block
{

    public static String[] subBlock = new String[] {"whitereflector", "yellowreflector", "illuminatedwhitereflector", "illuminatedyellowreflector"};
    private IIcon reflectorWhite, reflectorYellow;

    public BlockReflector()
    {
        super(Material.iron);
        this.setBlockBounds(0.3125F, 0.0F, 0.3125F, 0.6875F, 0.1F, 0.6875F);
        this.setCreativeTab(RoadStuff.RoadStuffCreativeTabs);
    }

    @SideOnly(Side.CLIENT)
    public int getRenderType()
    {
        return ClientProxy.renderReflectorId;
    }

    public int damageDropped(int metadata)
    {
        if(metadata == 8)
            return 0;
        if(metadata == 9)
            return 1;
        if(metadata == 10)
            return 2;
        if(metadata == 11)
            return 3;
        if(metadata == 12)
            return 0;
        if(metadata == 13)
            return 0;
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
        this.reflectorWhite = iconRegister.registerIcon(RoadStuff.MODID + ":reflectorWhite");
        this.reflectorYellow = iconRegister.registerIcon(RoadStuff.MODID + ":reflectorYellow");
    }

    public IIcon getIcon(int side, int metadata)
    {
        if(metadata == 0 || metadata == 8 || metadata == 2 || metadata == 10)
        {
            return this.reflectorWhite;
        }
        if(metadata == 1 || metadata == 9 || metadata == 3 || metadata == 11)
        {
            return this.reflectorYellow;
        }
        return this.reflectorWhite;
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

    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockAccess blockAccess, int x, int y, int z, int side)
    {
        return true;
    }

    public boolean renderAsNormalBlock()
    {
        return false;
    }

    public boolean isOpaqueCube()
    {
        return false;
    }

    // Remove collision for entities (like the Player) because it's annoying
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_)
    {
        return null;
    }

    // Prevents placing reflectors above weird things like slabs or void
    public boolean canPlaceBlockAt(World world_, int x, int y, int z)
    {
        return World.doesBlockHaveSolidTopSurface(world_, x, y - 1, z);
    }

    // Check if the block under the reflector is broken, so the reflector drops
    public void onNeighborBlockChange(World world, int x, int y, int z, Block block)
    {
        int l = world.getBlockMetadata(x, y, z);
        boolean mustDrop = !World.doesBlockHaveSolidTopSurface(world, x, y - 1, z);

        if(mustDrop)
        {
            this.dropBlockAsItem(world, x, y, z, l, 0);
            world.setBlockToAir(x, y, z);
        }
    }

    @Override
    public int getLightValue(IBlockAccess world, int x, int y, int z)
    {
        Block block = world.getBlock(x, y, z);
        int metadata = world.getBlockMetadata(x, y, z);
        if(metadata == 2 || metadata == 3 || metadata == 10 || metadata == 11)
        {
            return 15;
        }
        return 0;
    }
}