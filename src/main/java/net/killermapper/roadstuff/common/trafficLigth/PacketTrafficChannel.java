package net.killermapper.roadstuff.common.trafficLigth;

import io.netty.buffer.ByteBuf;
import net.killermapper.roadstuff.common.tileentity.TileEntityTrafficLigth;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.tileentity.TileEntity;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class PacketTrafficChannel implements IMessage, IMessageHandler<PacketTrafficChannel, IMessage> {

	private int channel, x, y, z, delay;
	private boolean reversed;
	
	public PacketTrafficChannel() {}
	
	public PacketTrafficChannel(int channel, int x, int y, int z, boolean reversed, int delay) {
			this.channel = channel;
			this.x = x;
			this.y = y;
			this.z = z;
			this.reversed = reversed;
			this.delay = delay;
	}
	
	@Override
	public IMessage onMessage(PacketTrafficChannel message, MessageContext ctx) {
		EntityPlayerMP player = ctx.getServerHandler().playerEntity;
		TileEntity t = player.worldObj.getTileEntity(message.x, message.y, message.z);
		if(t instanceof TileEntityTrafficLigth)
		{
			TileEntityTrafficLigth tile = (TileEntityTrafficLigth)t;
			tile.setChannel(message.channel);
			tile.setReversed(message.reversed);
			TrafficLigthParamatersRegister.setChannelParam(message.channel, new TrafficLigthParameters(message.delay));
			tile.markDirty();
		}
		return null;
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		this.channel = buf.readInt();
		this.x = buf.readInt();
		this.y = buf.readInt();
		this.z = buf.readInt();
		this.reversed = buf.readBoolean();
		this.delay = buf.readInt();
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(this.channel);
		buf.writeInt(this.x);
		buf.writeInt(this.y);
		buf.writeInt(this.z);
		buf.writeBoolean(this.reversed);
		buf.writeInt(this.delay);
	}

}
