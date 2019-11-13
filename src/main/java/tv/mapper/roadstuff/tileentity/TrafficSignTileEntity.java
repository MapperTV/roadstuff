package tv.mapper.roadstuff.tileentity;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.TileEntity;
import tv.mapper.roadstuff.RoadStuff;
import tv.mapper.roadstuff.init.ModTileEntityType;

public class TrafficSignTileEntity extends TileEntity
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

    public TrafficSignTileEntity()
    {
        super(ModTileEntityType.SIGN_WORKSHOP);
        RoadStuff.LOGGER.debug("create TE");
    }

    @Override
    public void read(CompoundNBT nbt)
    {
        RoadStuff.LOGGER.debug("read nbt");
        super.read(nbt);

        this.shape = nbt.getInt("shape");
        this.shapeRotation = nbt.getInt("shape_rotation");
        this.symbol = nbt.getInt("symbol");
        this.symbolColor = nbt.getInt("symbol_color");
        this.symbolRotation = nbt.getInt("symbol_rotation");
        this.symbolMirror = nbt.getBoolean("symbol_mirror");
        this.bgColor = nbt.getInt("bg_color");
        this.borderColor = nbt.getInt("border_color");
        this.borderThin = nbt.getBoolean("border_thin");
        this.detail = nbt.getInt("detail");
        this.detailColor = nbt.getInt("detail_color");
    }

    @Override
    public CompoundNBT write(CompoundNBT nbt)
    {
        RoadStuff.LOGGER.debug("write nbt");

        nbt.putInt("shape", shape);
        nbt.putInt("shape_rotation", shapeRotation);
        nbt.putInt("symbol", symbol);
        nbt.putInt("symbol_color", symbolColor);
        nbt.putInt("symbol_rotation", symbolRotation);
        nbt.putBoolean("symbol_mirror", symbolMirror);
        nbt.putInt("bg_color", bgColor);
        nbt.putInt("border_color", borderColor);
        nbt.putBoolean("border_thin", borderThin);
        nbt.putInt("detail", detail);
        nbt.putInt("detail_color", detailColor);

        return super.write(nbt);
    }
}
