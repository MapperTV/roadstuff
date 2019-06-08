package tv.mapper.roadstuff.network;

import java.util.function.Supplier;

import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent;
import tv.mapper.roadstuff.item.ItemBrush;

public class BrushPacket
{
    private int pattern;
    private int paint;

    public BrushPacket(int pattern, int paint)
    {
        this.pattern = pattern;
        this.paint = paint;
    }

    public static void encode(BrushPacket packet, PacketBuffer buffer)
    {
        buffer.writeInt(packet.pattern);
        buffer.writeInt(packet.paint);
    }

    public static BrushPacket decode(PacketBuffer buffer)
    {
        int pattern = buffer.readInt();
        int paint = buffer.readInt();
        BrushPacket instance = new BrushPacket(pattern, paint);
        return instance;
    }

    public static void handle(BrushPacket packet, Supplier<NetworkEvent.Context> context)
    {
        context.get().setPacketHandled(true);
        ServerPlayerEntity sender = context.get().getSender();

        if(sender.getHeldItemMainhand().getItem() instanceof ItemBrush)
            sender.getHeldItemMainhand().getTag().putInt("pattern", packet.pattern);
        else if(sender.getHeldItemOffhand().getItem() instanceof ItemBrush)
            sender.getHeldItemOffhand().getTag().putInt("pattern", packet.pattern);
    }
}
