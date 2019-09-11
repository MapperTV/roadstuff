package tv.mapper.roadstuff.network;

import java.util.function.Supplier;

import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent;
import tv.mapper.roadstuff.item.BrushItem;

public class BrushPacket
{
    private int pattern;
    private float scroll;
    private int favs[];

    public BrushPacket(int pattern, float scroll, int favs[])
    {
        this.pattern = pattern;
        this.scroll = scroll;
        this.favs = favs;
    }

    public static void encode(BrushPacket packet, PacketBuffer buffer)
    {
        buffer.writeInt(packet.pattern);
        buffer.writeFloat(packet.scroll);
        buffer.writeVarIntArray(packet.favs);
    }

    public static BrushPacket decode(PacketBuffer buffer)
    {
        int pattern = buffer.readInt();
        float scroll = buffer.readFloat();
        int favs[] = buffer.readVarIntArray();

        BrushPacket instance = new BrushPacket(pattern, scroll, favs);
        return instance;
    }

    public static void handle(BrushPacket packet, Supplier<NetworkEvent.Context> context)
    {
        context.get().setPacketHandled(true);
        ServerPlayerEntity sender = context.get().getSender();

        if(sender.getHeldItemMainhand().getItem() instanceof BrushItem)
        {
            CompoundNBT nbt = sender.getHeldItemMainhand().getTag();

            nbt.putInt("pattern", packet.pattern);
            nbt.putFloat("scroll", packet.scroll);
            nbt.putIntArray("favs", packet.favs);
        }
        else if(sender.getHeldItemOffhand().getItem() instanceof BrushItem)
        {
            CompoundNBT nbt = sender.getHeldItemOffhand().getTag();

            nbt.putInt("pattern", packet.pattern);
            nbt.putFloat("scroll", packet.scroll);
            nbt.putIntArray("favs", packet.favs);
        }
    }
}
