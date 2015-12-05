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

package net.killermapper.roadstuff.common.blocks.sign;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.killermapper.roadstuff.common.RoadStuff;
import net.killermapper.roadstuff.common.tiles.TileEntityBlockTrafficSign;
import net.killermapper.roadstuff.proxy.ClientProxy;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockTrafficSign extends Block
{
    public static String[] subBlock = new String[] {"signpost", "signround", "signtriangle", "signsquare", "signdiamond", "signrectangle"};
    private IIcon signPost, signBase, signSpeed50EU, signBaseCircle, signNoParkTop, signNoParkBottom;

    public BlockTrafficSign()
    {
        super(Material.iron);
        this.setCreativeTab(RoadStuff.RoadStuffCreativeTabs);
    }

    public int damageDropped(int metadata)
    {
        return metadata;
    }

    @SideOnly(Side.CLIENT)
    public int getRenderType()
    {
        return ClientProxy.renderSignPostId;
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
        this.signBase = iconRegister.registerIcon(RoadStuff.MODID + ":sign/signBase");
        this.signSpeed50EU = iconRegister.registerIcon(RoadStuff.MODID + ":sign/signSpeed50EU");
        this.signPost = iconRegister.registerIcon(RoadStuff.MODID + ":sign/signPost");
        this.signBaseCircle = iconRegister.registerIcon(RoadStuff.MODID + ":sign/signBaseCircle");
        this.signNoParkTop = iconRegister.registerIcon(RoadStuff.MODID + ":sign/signNoParkTop");
        this.signNoParkBottom = iconRegister.registerIcon(RoadStuff.MODID + ":sign/signNoParkBottom");
    }

    public IIcon getIcon(int side, int metadata)
    {
        if(side == 3)
        {
            if(metadata == 2)
                return this.signBase;
        }
        return this.signPost;
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(IBlockAccess world, int x, int y, int z, int side)
    {
        if(world.getBlockMetadata(x, y, z) == 1)
        {
            if(side == 3)
            {
                TileEntity tile = world.getTileEntity(x, y, z);
                if(tile instanceof TileEntityBlockTrafficSign)
                {
                    TileEntityBlockTrafficSign tileEntity = (TileEntityBlockTrafficSign)tile;
                    short type = ((TileEntityBlockTrafficSign)tile).getSignType();
                    switch(type)
                    {
                        case 0:
                            return this.signBase;
                        case 1:
                            return this.signNoParkTop;
                        case 2:
                            return this.signNoParkBottom;
                        case 3:
                            return this.signBaseCircle;
                        case 4:
                            return this.signSpeed50EU;
                        default:
                            return this.signBase;
                    }
                }
            }
        }
        return this.getIcon(side, world.getBlockMetadata(x, y, z));
    }

    public boolean renderAsNormalBlock()
    {
        return false;
    }

    public boolean isOpaqueCube()
    {
        return false;
    }

    public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z)
    {
        this.minX = 0.3F;
        this.minY = 0.0F;
        this.minZ = 0.5F;
        this.maxX = 0.7F;
        this.maxY = 1F;
        this.maxZ = 0.65F;

        if(world.getBlockMetadata(x, y, z) >= 1)
        {
            this.minX = 0.0F;
            this.minZ = 0.5F;
            this.maxX = 1F;
            this.maxZ = 0.65F;
        }
    }

    @Override
    public TileEntity createTileEntity(World world, int metadata)
    {
        return new TileEntityBlockTrafficSign();
    }

    @Override
    public boolean hasTileEntity(int metadata)
    {
        return true;
    }

    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase living, ItemStack stack)
    {
        TileEntity tile = world.getTileEntity(x, y, z);
        if(tile instanceof TileEntityBlockTrafficSign)
        {
            int direction = MathHelper.floor_double((double)(living.rotationYaw * 4.0F / 360.0F) + 2.5D) & 3;
            ((TileEntityBlockTrafficSign)tile).setDirection((byte)direction);
        }

    }

    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ)
    {
        System.out.println(((TileEntityBlockTrafficSign)world.getTileEntity(x, y, z)).getSignType() + ", client is " + world.isRemote);
        if(!world.isRemote)
        {
            TileEntity tile = world.getTileEntity(x, y, z);
            if(tile instanceof TileEntityBlockTrafficSign)
            {
                TileEntityBlockTrafficSign tileEntity = (TileEntityBlockTrafficSign)tile;
                player.addChatMessage(new ChatComponentTranslation("tile.signdirection.number", tileEntity.getDirection()));
                player.addChatMessage(new ChatComponentTranslation("tile.signtype.number", tileEntity.getSignType()));
            }
            return true;
        }
        else
        {
            if(world.getBlockMetadata(x, y, z) != 0)
                player.openGui(RoadStuff.instance, 0, world, x, y, z);
            return true;
        }
    }

}
