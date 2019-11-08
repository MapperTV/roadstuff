package tv.mapper.roadstuff.tileentity;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import tv.mapper.roadstuff.init.ModTileEntityType;
import tv.mapper.roadstuff.inventory.container.SignWorkshopContainer;

public class SignWorkshopTileEntity extends TileEntity implements INamedContainerProvider
{
    private LazyOptional<IItemHandler> handler = LazyOptional.of(this::createHandler);

    public SignWorkshopTileEntity()
    {
        super(ModTileEntityType.SIGN_WORKSHOP);
    }

    @Override
    public Container createMenu(int i, PlayerInventory playerInventory, PlayerEntity playerEntity)
    {
        return new SignWorkshopContainer(i, world, pos, playerInventory, playerEntity);
    }

    @Override
    public ITextComponent getDisplayName()
    {
        return new StringTextComponent(getType().getRegistryName().getPath());
    }

    @SuppressWarnings("unchecked")
    @Override
    public void read(CompoundNBT tag)
    {
        CompoundNBT invTag = tag.getCompound("inv");
        handler.ifPresent(h -> ((INBTSerializable<CompoundNBT>)h).deserializeNBT(invTag));

        super.read(tag);
    }

    @Override
    public CompoundNBT write(CompoundNBT tag)
    {
        handler.ifPresent(h ->
        {
            @SuppressWarnings("unchecked")
            CompoundNBT compound = ((INBTSerializable<CompoundNBT>)h).serializeNBT();
            tag.put("inv", compound);
        });

        return super.write(tag);
    }

    private IItemHandler createHandler()
    {
        return new ItemStackHandler(3)
        {

            @Override
            protected void onContentsChanged(int slot)
            {
                markDirty();
            }

            @Override
            public boolean isItemValid(int slot, @Nonnull ItemStack stack)
            {
                switch(slot)
                {
                    case 0:
                        return stack.getItem() == Items.IRON_INGOT;
                    case 1:
                        return stack.getItem() == Items.STICK;
                    case 2:
                        return false;
                    default:
                        return stack.getItem() == Items.IRON_INGOT;
                }

            }

            @Nonnull
            @Override
            public ItemStack insertItem(int slot, @Nonnull ItemStack stack, boolean simulate)
            {
                if(slot == 0 && stack.getItem() != Items.IRON_INGOT)
                    return stack;
                else if(slot == 1 && stack.getItem() != Items.STICK)
                    return stack;

                return super.insertItem(slot, stack, simulate);
            }
        };
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side)
    {
        if(cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)
        {
            return handler.cast();
        }
        return super.getCapability(cap, side);
    }
}
