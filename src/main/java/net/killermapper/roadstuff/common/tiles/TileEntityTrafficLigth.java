package net.killermapper.roadstuff.common.tiles;

import net.killermapper.roadstuff.common.trafficLigth.IChannelProvider;
import net.killermapper.roadstuff.common.trafficLigth.TrafficLigthParamatersRegister;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TileEntityTrafficLigth extends TileEntity implements IChannelProvider {

	private int channel = 0;
	private boolean isReversed = false;
	private int state = 3;
	private boolean isStarted = false;

	@Override
	public void writeToNBT(NBTTagCompound compound)
	{
		super.writeToNBT(compound);
		compound.setInteger("channel", this.channel);
		compound.setBoolean("reversed", this.isReversed);
		compound.setInteger("state", this.state);
		compound.setBoolean("started", this.isStarted);
	}

	@Override
	public void readFromNBT(NBTTagCompound compound)
	{
		super.readFromNBT(compound);
		this.channel = compound.getInteger("channel");
		this.isReversed = compound.getBoolean("reversed");
		this.state = compound.getInteger("state");
		this.isStarted = compound.getBoolean("started");
	}

	@Override
	public void updateEntity()
	{
		if(this.isReversed)
		{
			state = TrafficLigthParamatersRegister.getStateReversedFrom(this.channel);
		}
		else
		{
			state = TrafficLigthParamatersRegister.getStateFrom(this.channel);
		}
		this.markDirty();
	}

	@Override
	public int getChannel() {
		return this.channel;
	}

	@Override
	public void setChannel(int channel) {
		this.channel = channel;
	}

	@Override
	public Packet getDescriptionPacket()
	{
		NBTTagCompound nbttagcompound = new NBTTagCompound();
		this.writeToNBT(nbttagcompound);
		return new S35PacketUpdateTileEntity(this.xCoord, this.yCoord, this.zCoord, 1, nbttagcompound);
	}

	@Override
	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt)
	{
		this.readFromNBT(pkt.func_148857_g());
		this.worldObj.markBlockRangeForRenderUpdate(this.xCoord, this.yCoord, this.zCoord, this.xCoord, this.yCoord, this.zCoord);
	}

	@Override
	public boolean isReversed() {
		return this.isReversed;
	}

	@Override
	public void setReversed(boolean isReversed) {
		this.isReversed = isReversed;
	}

	@Override
	public int getState() {
		return this.state;
	}

	public void setStarted(boolean started)
	{
		this.isStarted = started;
	}

}
