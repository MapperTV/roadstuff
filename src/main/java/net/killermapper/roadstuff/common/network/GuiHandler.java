package net.killermapper.roadstuff.common.network;

import net.killermapper.roadstuff.client.gui.GuiTrafficLigth;
import net.killermapper.roadstuff.common.tiles.TileEntityTrafficLigth;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		//TileEntity tile = world.getTileEntity(x, y, z);
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity tile = world.getTileEntity(x, y, z);
		if(tile instanceof TileEntityTrafficLigth)
		{
			return new GuiTrafficLigth((TileEntityTrafficLigth)tile);
		}
		return null;
	}

}
