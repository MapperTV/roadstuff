//This class is a test and will be deleted later. Credit to MinecraftForgeFrance.

package net.killermapper.roadstuff.common.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.killermapper.roadstuff.common.RoadStuff;
import net.killermapper.roadstuff.proxy.ClientProxy;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;

public class TestISBRH extends Block
{    
    private IIcon top, sides, bottom;
    
    public TestISBRH()
    {
        super(Material.rock);
        this.setCreativeTab(RoadStuff.RoadStuffCreativeTabs);
    }
    
    public void registerBlockIcons(IIconRegister iiconRegister)
    {
        this.top = iiconRegister.registerIcon(RoadStuff.MODID + ":blockCone01Top");
        this.sides = iiconRegister.registerIcon(RoadStuff.MODID + ":blockCone01");
        this.bottom = iiconRegister.registerIcon(RoadStuff.MODID + ":blockConeBottom");
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
        return ClientProxy.renderTestId;
    }

    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockAccess blockAccess, int x, int y, int z, int side)
    {
        return true;
    }
    
    public IIcon getIcon(int side, int metadata)
    {
        if(side == 1)
            return this.top;
        if(side == 0)
            return this.bottom;
        return this.sides;
    }

}
