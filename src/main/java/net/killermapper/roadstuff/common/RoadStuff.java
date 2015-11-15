/*
Road Stuff - A Minecraft MODification by KillerMapper - 2015

The MIT License (MIT)

Copyright (c) 2015 KillerMapper

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
*/

package net.killermapper.roadstuff.common;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.killermapper.roadstuff.common.blocks.RoadStuffBlocks;
import net.killermapper.roadstuff.common.blocks.TileEntityTest;
import net.killermapper.roadstuff.common.items.ItemBitumen;
import net.killermapper.roadstuff.common.items.ItemPaintbrush;
import net.killermapper.roadstuff.proxy.CommonProxy;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

@Mod(modid = RoadStuff.MODID, name = "Road Stuff", version = "0.1")

public class RoadStuff
{

    public static final String MODID = "roadstuff";
    @Instance("MODID")
    public static RoadStuff instance;

    @SidedProxy(clientSide = "net.killermapper.roadstuff.proxy.ClientProxy", serverSide = "net.killermapper.roadstuff.proxy.CommonProxy")
    public static CommonProxy proxy;

    public static CreativeTabs RoadStuffCreativeTabs = new CreativeTabs("RoadStuff")
    {
        @Override
        public Item getTabIconItem()
        {
            return Item.getItemFromBlock(RoadStuffBlocks.blockAsphaltLines01);
        }

        @SideOnly(Side.CLIENT)
        public int func_151243_f()
        {
            return 0;
        }
    };

    public static Item itemBitumen, itemPaint;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        // Item Creation
        itemBitumen = new ItemBitumen().setUnlocalizedName("bitumen").setTextureName(MODID + ":itemBitumen").setCreativeTab(RoadStuff.RoadStuffCreativeTabs);
        itemPaint = new ItemPaintbrush().setUnlocalizedName("paint").setTextureName(MODID + ":itemPaint").setCreativeTab(RoadStuff.RoadStuffCreativeTabs);

        GameRegistry.registerItem(itemBitumen, "itemBitumen");
        GameRegistry.registerItem(itemPaint, "itemPaint");

        RoadStuffBlocks.initBlocks();

    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {

        GameRegistry.registerTileEntity(TileEntityTest.class, "roadstuff:entityTest");

        proxy.registerRender();
    }

    @EventHandler
    public void PostInit(FMLPostInitializationEvent event)
    {

    }

}
