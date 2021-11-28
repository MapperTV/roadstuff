package tv.mapper.roadstuff.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import tv.mapper.mapperbase.world.level.block.SlopeBlock;
import tv.mapper.mapperbase.world.level.block.ToolTiers;
import tv.mapper.mapperbase.world.level.block.ToolTypes;

public class PaintableSlopeBlock extends SlopeBlock implements PaintSystem
{
    protected int materialType = 0;

    public PaintableSlopeBlock(Properties properties, ToolTypes tool, int materialType)
    {
        super(properties, tool);
        this.materialType = materialType;
    }

    public PaintableSlopeBlock(Properties properties, ToolTypes tool, ToolTiers tier, int materialType)
    {
        super(properties, tool, tier);
        this.materialType = materialType;
    }

    public int getMaterialType()
    {
        return this.materialType;
    }

    @Override
    public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player player, InteractionHand handIn, BlockHitResult hit)
    {
        if(hit.getDirection() == Direction.UP)
        {
            Item itemCheck = null;

            switch(getMaterialType())
            {
                case 0:
                    itemCheck = RSBlockRegistry.ASPHALT_SLOPE.get().asItem();
                    break;
                case 1:
                    itemCheck = RSBlockRegistry.CONCRETE_SLOPE.get().asItem();
                    break;
                default:
                    itemCheck = RSBlockRegistry.ASPHALT_SLOPE.get().asItem();
                    break;
            }

            if(!player.isShiftKeyDown() && state.getValue(LAYERS) < 8)
            {
                ItemStack stack = ItemStack.EMPTY;
                if(player.getMainHandItem().getItem() == itemCheck)
                    stack = player.getMainHandItem();
                else if(player.getOffhandItem().getItem() == itemCheck)
                    stack = player.getOffhandItem();

                if(stack.getItem() == itemCheck)
                {
                    worldIn.setBlockAndUpdate(pos, state.setValue(LAYERS, state.getValue(LAYERS) + 1));
                    if(!worldIn.isClientSide)
                        worldIn.playSound(null, pos, SoundEvents.STONE_PLACE, SoundSource.BLOCKS, 1.0F, 1.0F);

                    if(!player.isCreative())
                        stack.setCount(stack.getCount() - 1);
                    return InteractionResult.SUCCESS;
                }
            }
        }
        return InteractionResult.PASS;
    }

    @Override
    public ItemStack getCloneItemStack(BlockGetter worldIn, BlockPos pos, BlockState state)
    {
        switch(materialType)
        {
            case 0:
                return new ItemStack(RSBlockRegistry.ASPHALT_SLOPE.get());
            case 1:
                return new ItemStack(RSBlockRegistry.CONCRETE_SLOPE.get());
            default:
                return null;
        }
    }
}