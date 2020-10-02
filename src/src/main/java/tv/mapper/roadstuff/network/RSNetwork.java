package tv.mapper.roadstuff.network;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;
import tv.mapper.roadstuff.RoadStuff;

public class RSNetwork
{
    public static final String PROTOCOL_VERSION = String.valueOf(1);

    public static final SimpleChannel ROADSTUFF_CHANNEL = NetworkRegistry.ChannelBuilder.named(new ResourceLocation(RoadStuff.MODID, "roadstuff_channel")).networkProtocolVersion(
        () -> PROTOCOL_VERSION).clientAcceptedVersions(PROTOCOL_VERSION::equals).serverAcceptedVersions(PROTOCOL_VERSION::equals).simpleChannel();

    public static void registerNetworkPackets()
    {
        ROADSTUFF_CHANNEL.messageBuilder(BrushPacket.class, 0).encoder(BrushPacket::encode).decoder(BrushPacket::decode).consumer(BrushPacket::handle).add();
    }
}