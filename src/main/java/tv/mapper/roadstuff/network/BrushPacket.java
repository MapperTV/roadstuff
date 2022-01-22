package tv.mapper.roadstuff.network;

import java.util.function.Supplier;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;
import tv.mapper.roadstuff.world.item.BrushItem;

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

    public static void encode(BrushPacket packet, FriendlyByteBuf buffer)
    {
        buffer.writeInt(packet.pattern);
        buffer.writeFloat(packet.scroll);
        buffer.writeVarIntArray(packet.favs);
    }

    public static BrushPacket decode(FriendlyByteBuf buffer)
    {
        int pattern = buffer.readInt();
        float scroll = buffer.readFloat();
        int favs[] = buffer.readVarIntArray();

        BrushPacket instance = new BrushPacket(pattern, scroll, favs);
        return instance;
    }

    public static void handle(BrushPacket packet, Supplier<NetworkEvent.Context> context)
    {
        context.get().enqueueWork(() ->
        {
            ServerPlayer sender = context.get().getSender();

            if(sender.getMainHandItem().getItem() instanceof BrushItem)
            {
                CompoundTag nbt = sender.getMainHandItem().getTag();

                nbt.putInt("pattern", packet.pattern);
                nbt.putFloat("scroll", packet.scroll);
                nbt.putIntArray("favs", packet.favs);
            }
            else if(sender.getOffhandItem().getItem() instanceof BrushItem)
            {
                CompoundTag nbt = sender.getOffhandItem().getTag();

                nbt.putInt("pattern", packet.pattern);
                nbt.putFloat("scroll", packet.scroll);
                nbt.putIntArray("favs", packet.favs);
            }
        });
        context.get().setPacketHandled(true);
    }
}