package tv.mapper.roadstuff.item;

import net.minecraft.item.DyeColor;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import tv.mapper.roadstuff.block.RSBlockRegistry;

public class ModItemGroups
{
    public static final ItemGroup ROADSTUFF = new ItemGroup("roadstuff_group")
    {
        @Override
        public ItemStack createIcon()
        {
            return new ItemStack(RSBlockRegistry.TRAFFIC_CONE_BLOCKS.get(DyeColor.ORANGE).get());
        }
    };
}