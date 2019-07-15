package tv.mapper.roadstuff.network;

import java.util.function.Supplier;

import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent;
import tv.mapper.roadstuff.item.BrushItem;

public class BrushPacket
{
    private int pattern;
    private int paint;
    private float scroll;

    public BrushPacket(int pattern, int paint, float scroll)
    {
        this.pattern = pattern;
        this.paint = paint;
        this.scroll = scroll;
    }

    public static void encode(BrushPacket packet, PacketBuffer buffer)
    {
        buffer.writeInt(packet.pattern);
        buffer.writeInt(packet.paint);
        buffer.writeFloat(packet.scroll);
    }

    public static BrushPacket decode(PacketBuffer buffer)
    {
        int pattern = buffer.readInt();
        int paint = buffer.readInt();
        float scroll = buffer.readFloat();
        BrushPacket instance = new BrushPacket(pattern, paint, scroll);
        return instance;
    }

    public static void handle(BrushPacket packet, Supplier<NetworkEvent.Context> context)
    {
        context.get().setPacketHandled(true);
        ServerPlayerEntity sender = context.get().getSender();

        if(sender.getHeldItemMainhand().getItem() instanceof BrushItem)
        {
            sender.getHeldItemMainhand().getTag().putInt("pattern", packet.pattern);
            sender.getHeldItemMainhand().getTag().putFloat("scroll", packet.scroll);
        }
        else if(sender.getHeldItemOffhand().getItem() instanceof BrushItem)
        {
            sender.getHeldItemOffhand().getTag().putInt("pattern", packet.pattern);
            sender.getHeldItemOffhand().getTag().putFloat("scroll", packet.scroll);
        }
    }
}
