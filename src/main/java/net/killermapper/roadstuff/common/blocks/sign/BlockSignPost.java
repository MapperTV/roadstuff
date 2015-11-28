package net.killermapper.roadstuff.common.blocks.sign;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.killermapper.roadstuff.common.RoadStuff;
import net.killermapper.roadstuff.proxy.ClientProxy;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.IBlockAccess;

public class BlockSignPost extends Block
{

    public BlockSignPost()
    {
        super(Material.iron);
        this.setCreativeTab(RoadStuff.RoadStuffCreativeTabs);
    }
    
    @SideOnly(Side.CLIENT)
    public int getRenderType()
    {
        return ClientProxy.renderSignPostId;
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
            this.minZ = 0.3F;
            this.maxX = 0.7F;
            this.maxY = 1F;
            this.maxZ = 0.7F;
    }

}
