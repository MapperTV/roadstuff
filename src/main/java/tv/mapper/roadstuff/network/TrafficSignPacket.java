package tv.mapper.roadstuff.network;

import java.util.function.Supplier;

import net.minecraft.inventory.container.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent;
import tv.mapper.roadstuff.init.ModBlocks;

public class TrafficSignPacket
{
    private int shape;
    private int shapeRotation;
    private int symbol;
    private int symbolColor;
    private int symbolRotation;
    private boolean symbolMirror;
    private int bgColor;
    private int borderColor;
    private boolean borderThin;
    private int detail;
    private int detailColor;

    public TrafficSignPacket(int shape, int shapeRotation, int symbol, int symbolColor, int symbolRotation, boolean symbolMirror, int bgColor, int borderColor, boolean borderThin, int detail, int detailColor)
    {
        this.shape = shape;
        this.shapeRotation = shapeRotation;
        this.symbol = symbol;
        this.symbolColor = symbolColor;
        this.symbolRotation = symbolRotation;
        this.symbolMirror = symbolMirror;
        this.bgColor = bgColor;
        this.borderColor = borderColor;
        this.borderThin = borderThin;
        this.detail = detail;
        this.detailColor = detailColor;
    }

    public static void encode(TrafficSignPacket packet, PacketBuffer buffer)
    {
        buffer.writeInt(packet.shape);
        buffer.writeInt(packet.shapeRotation);
        buffer.writeInt(packet.symbol);
        buffer.writeInt(packet.symbolColor);
        buffer.writeInt(packet.symbolRotation);
        buffer.writeBoolean(packet.symbolMirror);
        buffer.writeInt(packet.bgColor);
        buffer.writeInt(packet.borderColor);
        buffer.writeBoolean(packet.borderThin);
        buffer.writeInt(packet.detail);
        buffer.writeInt(packet.detailColor);
    }

    public static TrafficSignPacket decode(PacketBuffer buffer)
    {
        int shape = buffer.readInt();
        int shapeRotation = buffer.readInt();
        int symbol = buffer.readInt();
        int symbolColor = buffer.readInt();
        int symbolRotation = buffer.readInt();
        boolean symbolMirror = buffer.readBoolean();
        int bgColor = buffer.readInt();
        int borderColor = buffer.readInt();
        boolean borderThin = buffer.readBoolean();
        int detail = buffer.readInt();
        int detailColor = buffer.readInt();

        TrafficSignPacket instance = new TrafficSignPacket(shape, shapeRotation, symbol, symbolColor, symbolRotation, symbolMirror, bgColor, borderColor, borderThin, detail, detailColor);
        return instance;
    }

    public static void handle(TrafficSignPacket packet, Supplier<NetworkEvent.Context> context)
    {
        CompoundNBT nbt = new CompoundNBT();
        ItemStack stack = new ItemStack(ModBlocks.TRAFFIC_SIGN);

        Container container = context.get().getSender().openContainer;
        ItemStack inputStack = container.getSlot(0).getStack();

        CompoundNBT outputNbt;

        int inputCount = container.getSlot(0).getStack().getCount();
        int outputCount = container.getSlot(1).getStack().getCount();

        if(inputCount > 64)
            inputCount = 64;
        else if(inputCount < 0)
            inputCount = 0;

        if(inputCount > 0 && outputCount < 64)
        {
            nbt.putInt("shape", packet.shape);
            nbt.putInt("shape_rotation", packet.shapeRotation);
            nbt.putInt("symbol", packet.symbol);
            nbt.putInt("symbol_color", packet.symbolColor);
            nbt.putInt("symbol_rotation", packet.symbolRotation);
            nbt.putBoolean("symbol_mirror", packet.symbolMirror);
            nbt.putInt("bg_color", packet.bgColor);
            nbt.putInt("border_color", packet.borderColor);
            nbt.putBoolean("border_thin", packet.borderThin);
            nbt.putInt("detail", packet.detail);
            nbt.putInt("detail_color", packet.detailColor);

            stack.setTag(nbt);

            if(outputCount <= 0)
                outputNbt = nbt;
            else
                outputNbt = container.getSlot(1).getStack().getTag();

            if(nbt.equals(outputNbt))
            {
                if(outputCount > 63)
                    outputCount = 63;
                else if(outputCount < 0)
                    outputCount = 0;
                stack.setCount(outputCount + 1);

                container.putStackInSlot(1, stack);
                inputStack.setCount(inputCount - 1);
                container.putStackInSlot(0, inputStack);
            }
        }

        context.get().setPacketHandled(true);
    }
}
