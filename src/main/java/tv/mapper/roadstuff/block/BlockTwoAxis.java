package tv.mapper.roadstuff.block;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.math.MathHelper;

public class BlockTwoAxis extends BlockPaintable
{
    public static final BooleanProperty ROTATION = BooleanProperty.create("rotation");

    public BlockTwoAxis(Properties properties, int materialType)
    {
        super(properties, materialType);
        this.setDefaultState(this.getDefaultState().with(ROTATION, Boolean.valueOf(false)));
    }

    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder)
    {
        builder.add(ROTATION);
    }

    @Nullable
    public BlockState getStateForPlacement(BlockItemUseContext context)
    {
        BlockState state = this.getDefaultState().with(ROTATION, Boolean.valueOf(false));
        int direction = MathHelper.floor((double)(context.getPlacementYaw() * 4.0F / 360.0F) + 2.5D) & 3;
        if(direction == 1 || direction == 3)
            return state.with(ROTATION, true);
        else
            return state;
    }
}
