package tv.mapper.roadstuff.item;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import tv.mapper.roadstuff.state.properties.EnumPaintColor;

public class BlockItemPaintBucket extends BlockItem
{
    public BlockItemPaintBucket(Block blockIn, Properties builder)
    {
        super(blockIn, builder);
        this.addPropertyOverride(new ResourceLocation("color"), (itemStack, world, entity) ->
        {
            if(itemStack.hasTag())
            {
                CompoundNBT nbt = itemStack.getTag();
                if(nbt.getInt("paint") == 0)
                    return 0.0f;
                else if(nbt.getInt("color") == 0)
                    return 0.5f;
                else if(nbt.getInt("color") == 1)
                    return 1.0f;
            }
            return 0.0f;
        });
    }

    @Override
    public void addInformation(ItemStack stack, World player, List<ITextComponent> list, ITooltipFlag flag)
    {
        super.addInformation(stack, player, list, flag);
        if(stack.hasTag())
        {
            String color = EnumPaintColor.getColorByID(stack.getTag().getInt("color")).getNameTranslated();

            int paint = (stack.getTag().getInt("paint") * 100) / 8;
            if(paint < 10)
                color = "X";
            list.add(new StringTextComponent(new TranslationTextComponent("roadstuff.message.brush.gui.color").getString() + color));
            list.add(new StringTextComponent(new TranslationTextComponent("roadstuff.message.brush.gui.paint").getString() + paint + "%"));
        }
    }
}