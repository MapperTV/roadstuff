package tv.mapper.roadstuff.block;

import net.minecraft.block.Block;
import net.minecraft.util.BlockRenderLayer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class BlockPaintable extends Block implements IPaintable
{

    public BlockPaintable(Properties properties)
    {
        super(properties);
    }

    @OnlyIn(Dist.CLIENT)
    public BlockRenderLayer getRenderLayer()
    {
        return BlockRenderLayer.CUTOUT;
    }
}