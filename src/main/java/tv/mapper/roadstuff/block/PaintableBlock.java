package tv.mapper.roadstuff.block;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.ToolType;
import tv.mapper.roadstuff.init.ModBlocks;

public class PaintableBlock extends Block
{
    protected int materialType = 0;

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

    @Override
    public ItemStack getItem(IBlockReader worldIn, BlockPos pos, BlockState state)
    {
        switch(materialType)
        {
            case 0:
                return new ItemStack(ModBlocks.ASPHALT);
            case 1:
                return new ItemStack(ModBlocks.CONCRETE);
            default:
                return null;
        }
    }

    @Nullable
    @Override
    public ToolType getHarvestTool(BlockState state)
    {
        return ToolType.PICKAXE;
    }
}