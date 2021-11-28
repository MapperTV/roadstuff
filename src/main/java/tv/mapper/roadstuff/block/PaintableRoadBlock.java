package tv.mapper.roadstuff.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;
import tv.mapper.mapperbase.world.level.block.CustomBlock;
import tv.mapper.mapperbase.world.level.block.ToolTiers;
import tv.mapper.mapperbase.world.level.block.ToolTypes;

/*
 *  PaintableBlock
 *  
 *  This block can be painted using the paintbrush.
 *  
 */
public class PaintableRoadBlock extends CustomBlock implements PaintSystem
{
    protected int materialType = 0;

    public PaintableRoadBlock(Properties properties, ToolTypes tool, int materialType)
    {
        super(properties, tool);
        this.materialType = materialType;
    }

    public PaintableRoadBlock(Properties properties, ToolTypes tool, ToolTiers tier, int materialType)
    {
        super(properties, tool, tier);
        this.materialType = materialType;
    }

    public int getMaterialType()
    {
        return this.materialType;
    }

    @Override
    public ItemStack getCloneItemStack(BlockGetter worldIn, BlockPos pos, BlockState state)
    {
        switch(materialType)
        {
            case 0:
                return new ItemStack(RSBlockRegistry.ASPHALT.get());
            case 1:
                return new ItemStack(RSBlockRegistry.CONCRETE.get());
            default:
                return null;
        }
    }
}