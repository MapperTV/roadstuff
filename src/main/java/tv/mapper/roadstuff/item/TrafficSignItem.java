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
            Color bgColor = new Color(nbt.getInt("bg_color"));
            Color symbolColor = new Color(nbt.getInt("symbol_color"));
            Color borderColor = new Color(nbt.getInt("border_color"));
            Color detailColor = new Color(nbt.getInt("detail_color"));

            String bgHex = String.format("#%02X%02X%02X", bgColor.getRed(), bgColor.getGreen(), bgColor.getBlue());
            String symbolHex = String.format("#%02X%02X%02X", symbolColor.getRed(), symbolColor.getGreen(), symbolColor.getBlue());
            String borderHex = String.format("#%02X%02X%02X", borderColor.getRed(), borderColor.getGreen(), borderColor.getBlue());
            String detailHex = String.format("#%02X%02X%02X", detailColor.getRed(), detailColor.getGreen(), detailColor.getBlue());

            list.add(new StringTextComponent("Shape: " + nbt.getInt("shape") + " (" + nbt.getInt("shape_rotation") + "°); Color: " + bgHex));
            list.add(new StringTextComponent("Symbol: " + nbt.getInt("symbol") + " (" + nbt.getInt("symbol_rotation") + "°, mirror: " + nbt.getBoolean("symbol_mirror") + "), Color: " + symbolHex));
            list.add(new StringTextComponent("Border: Color: " + borderHex + " (thin: " + nbt.getBoolean("border_thin") + ")"));
            list.add(new StringTextComponent("Detail: " + nbt.getInt("detail") + ", Color: " + detailHex));
        }
    }
}
