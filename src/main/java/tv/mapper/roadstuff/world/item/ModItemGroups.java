package tv.mapper.roadstuff.world.item;

import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import tv.mapper.roadstuff.world.level.block.RSBlockRegistry;

public class ModItemGroups
{
    public static final CreativeModeTab ROADSTUFF = new CreativeModeTab("roadstuff_group")
    {
        @Override
        public ItemStack makeIcon()
        {
            return new ItemStack(RSBlockRegistry.TRAFFIC_CONE_BLOCKS.get(DyeColor.ORANGE).get());
        }
    };
}