//This class is a test and will be deleted later. Credit to MinecraftForgeFrance.

package net.killermapper.roadstuff.common.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.killermapper.roadstuff.proxy.ClientProxy;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;

public class TestISBRH extends Block {

	public TestISBRH() {
		super(Material.wood);
	}
	
	public boolean renderAsNormalBlock(){
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
		return Blocks.planks.getIcon(side, 0);
	}

}
