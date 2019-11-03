package tv.mapper.roadstuff.block;

import javax.annotation.Nullable;

import net.minecraft.block.BlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.ToolType;
import tv.mapper.roadstuff.tileentity.SignWorkshopTileEntity;

public class SignWorkshopBlock extends CustomBlock
{

    public SignWorkshopBlock(Properties properties, ToolType toolType)
    {
        super(properties, toolType);

    }

    @Override
    public boolean hasTileEntity(BlockState state)
    {
        return true;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world)
    {
        return new SignWorkshopTileEntity(null);
    }
}
