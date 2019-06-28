package tv.mapper.roadstuff.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.BlockRenderLayer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class PaintableBlock extends Block
{
    private int materialType = 0;

    public PaintableBlock(Properties properties, int materialType)
    {
        super(properties);
        this.materialType = materialType;
    }

    @OnlyIn(Dist.CLIENT)
    public BlockRenderLayer getRenderLayer()
    {
        return BlockRenderLayer.CUTOUT;
    }

    public int getMaterialType()
    {
        return this.materialType;
    }

    @Override
    public boolean isSolid(BlockState state)
    {
        return true;
    }
}