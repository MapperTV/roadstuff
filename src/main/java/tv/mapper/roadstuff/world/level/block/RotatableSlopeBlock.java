package tv.mapper.roadstuff.world.level.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import tv.mapper.mapperbase.world.level.block.ToolTiers;
import tv.mapper.mapperbase.world.level.block.ToolTypes;

public class RotatableSlopeBlock extends PaintableSlopeBlock
{
    public static final DirectionProperty DIRECTION = HorizontalDirectionalBlock.FACING;
    private Block pickBlock;

    public RotatableSlopeBlock(Properties properties, Block pickBlock, ToolTypes tool, int materialType)
    {
        super(properties, tool, materialType);
        this.pickBlock = pickBlock;
        this.registerDefaultState(this.stateDefinition.any().setValue(LAYERS, Integer.valueOf(1)).setValue(DIRECTION, Direction.NORTH).setValue(WATERLOGGED, Boolean.valueOf(false)));
    }

    public RotatableSlopeBlock(Properties properties, Block pickBlock, ToolTypes tool, ToolTiers tier, int materialType)
    {
        super(properties, tool, tier, materialType);
        this.pickBlock = pickBlock;
        this.registerDefaultState(this.stateDefinition.any().setValue(LAYERS, Integer.valueOf(1)).setValue(DIRECTION, Direction.NORTH).setValue(WATERLOGGED, Boolean.valueOf(false)));
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder)
    {
        builder.add(LAYERS, DIRECTION, WATERLOGGED);
    }

    @Override
    public ItemStack getCloneItemStack(BlockGetter worldIn, BlockPos pos, BlockState state)
    {
        return new ItemStack(this.pickBlock);
    }
}