package tv.mapper.roadstuff.item;

import java.awt.Color;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

public class TrafficSignItem extends BlockItem
{
    private CompoundNBT nbt;

    public TrafficSignItem(Block block, Properties properties)
    {
        super(block, properties);
    }

    public ActionResultType onItemUse(ItemUseContext context)
    {
        ItemStack stack = context.getPlayer().getActiveItemStack();
        checkNBT(stack);
        return super.onItemUse(context);
    }

    public CompoundNBT checkNBT(ItemStack stack)
    {
        if(stack.hasTag())
        {
            this.nbt = stack.getTag();
        }
        else
        {
            this.nbt = new CompoundNBT();

            this.nbt.putInt("shape", 0);
            this.nbt.putInt("shape_rotation", 0);
            this.nbt.putInt("symbol", 0);
            this.nbt.putInt("symbol_color", 0);
            this.nbt.putInt("symbol_rotation", 0);
            this.nbt.putBoolean("symbol_mirror", false);
            this.nbt.putInt("bg_color", 0);
            this.nbt.putInt("border_color", 0);
            this.nbt.putBoolean("border_thin", false);
            this.nbt.putInt("detail", 0);
            this.nbt.putInt("detail_color", 0);

        }
        return this.nbt;
    }

    @Override
    public void addInformation(ItemStack stack, World world, List<ITextComponent> list, ITooltipFlag flag)
    {
        super.addInformation(stack, world, list, flag);

        if(stack.hasTag())
        {
            CompoundNBT nbt = stack.getTag();
            Color bg_color = new Color(nbt.getInt("bg_color"));
            Color symbol_color = new Color(nbt.getInt("symbol_color"));
            Color border_color = new Color(nbt.getInt("border_color"));
            Color detail_color = new Color(nbt.getInt("detail_color"));

            list.add(new StringTextComponent("Shape: " + nbt.getInt("shape") + " (" + nbt.getInt("shape_rotation") + "°); Color: R" + bg_color.getRed() + ", G" + bg_color.getGreen() + ", B" + bg_color.getBlue()));
            list.add(new StringTextComponent("Symbol: " + nbt.getInt("symbol") + " (" + nbt.getInt("symbol_rotation") + "°, mirror: " + nbt.getBoolean("symbol_mirror") + "), Color: R" + symbol_color.getRed() + ", G" + symbol_color.getGreen() + ", B" + symbol_color.getBlue()));
            list.add(new StringTextComponent("Border: Color: R" + border_color.getRed() + ", G" + border_color.getGreen() + ", B" + border_color.getBlue() + " (thin: " + nbt.getBoolean("border_thin") + ")"));
            list.add(new StringTextComponent("Detail: " + nbt.getInt("detail") + ", Color: R" + detail_color.getRed() + ", G" + detail_color.getGreen() + ", B" + detail_color.getBlue()));
        }
    }
}
