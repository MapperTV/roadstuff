package net.killermapper.roadstuff.common.items;

import cpw.mods.fml.common.registry.GameRegistry;
import net.killermapper.roadstuff.common.RoadStuff;
import net.minecraft.item.Item;

public class RoadStuffItems
{
    public static Item itemBitumen;
    public static Item itemPaint;

    public static void initItems()
    {
        itemBitumen = new ItemBitumen().setUnlocalizedName("bitumen").setTextureName(RoadStuff.MODID + ":itemBitumen").setCreativeTab(RoadStuff.RoadStuffCreativeTabs);
        itemPaint = new ItemPaintbrush().setUnlocalizedName("paint").setTextureName(RoadStuff.MODID + ":itemPaint").setCreativeTab(RoadStuff.RoadStuffCreativeTabs);

        RoadStuffItems.registerItems();
    }

    public static void registerItems()
    {
        GameRegistry.registerItem(itemBitumen, "itemBitumen");
        GameRegistry.registerItem(itemPaint, "itemPaint");
    }

}
