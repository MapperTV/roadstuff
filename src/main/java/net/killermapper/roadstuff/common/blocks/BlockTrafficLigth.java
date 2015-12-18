package net.killermapper.roadstuff.common.blocks;

import net.killermapper.roadstuff.common.RoadStuff;
import net.killermapper.roadstuff.common.tiles.TileEntityTrafficLigth;
import net.killermapper.roadstuff.proxy.ClientProxy;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockTrafficLigth extends Block implements ITileEntityProvider {
	
	private IIcon greenIcon;

	public BlockTrafficLigth() {
		super(Material.rock);
		this.setResistance(5.0F);
		this.setHardness(3.0F);
		this.setCreativeTab(RoadStuff.RoadStuffCreativeTabs);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int metadata) {
		return new TileEntityTrafficLigth();
	}
	
	@Override
	public boolean hasTileEntity()
	{
		return true;
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitx, float hity, float hitz)
    {
        if (world.isRemote)
        {
        	player.openGui(RoadStuff.instance, 1, world, x, y, z);
            return true;
        }
        else
        {
            return true;
        }
    }
	
	@SideOnly(Side.CLIENT)
	public int getRenderType()
	{
		return ClientProxy.renderTrafficLigthId;
	}
	
	@Override
    public boolean isOpaqueCube() {
        return false;
    }
	
	@Override
	@SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister register)
    {
		this.greenIcon = register.registerIcon(RoadStuff.MODID + ":test.png");
	}
	
	@SideOnly(Side.CLIENT)
	public IIcon getIcon()
	{
		return this.greenIcon;
	}

}
