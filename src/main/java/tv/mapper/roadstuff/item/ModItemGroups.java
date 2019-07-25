package tv.mapper.roadstuff.item;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import tv.mapper.roadstuff.init.ModBlocks;

public class ModItemGroups
{
    public static final ItemGroup ROADSTUFF = new ItemGroup("roadstuff_group")
    {
        @Override
        public ItemStack createIcon()
        {
            return new ItemStack(ModBlocks.ORANGE_TRAFFIC_CONE);
        }
    };
}