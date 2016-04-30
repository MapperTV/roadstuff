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

import net.killermapper.roadstuff.client.gui.RoadStuffGuiHandler;
import net.killermapper.roadstuff.common.command.CommandReloadConfig;
import net.killermapper.roadstuff.common.events.EventPlayer;
import net.killermapper.roadstuff.common.init.Chisel;
import net.killermapper.roadstuff.common.init.ConfigurationLoader;
import net.killermapper.roadstuff.common.init.RoadStuffAchievements;
import net.killermapper.roadstuff.common.init.RoadStuffBlocks;
import net.killermapper.roadstuff.common.init.RoadStuffItems;
import net.killermapper.roadstuff.common.init.RoadStuffRecipes;
import net.killermapper.roadstuff.common.network.PacketSignType;
import net.killermapper.roadstuff.common.tiles.TileEntityBlockTrafficSign;
import net.killermapper.roadstuff.common.tiles.TileEntityBoundingBlock;
import net.killermapper.roadstuff.common.tiles.TileEntityTrafficLigth;
import net.killermapper.roadstuff.common.trafficLigth.PacketTrafficChannel;
import net.killermapper.roadstuff.common.world.OreGeneration;
import net.killermapper.roadstuff.proxy.CommonProxy;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import org.apache.logging.log4j.Logger;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@Mod(modid = RoadStuff.MODID, name = "Road Stuff", version = "0.2.0")

public class RoadStuff
{
    @Instance("roadstuff")
    public static RoadStuff instance;

    public static final String MODID = "roadstuff";

    public static Logger logger;

    public static SimpleNetworkWrapper network;

    OreGeneration oreGen = new OreGeneration();

    @SidedProxy(clientSide = "net.killermapper.roadstuff.proxy.ClientProxy", serverSide = "net.killermapper.roadstuff.proxy.CommonProxy")
    public static CommonProxy proxy;

    public static CreativeTabs RoadStuffCreativeTabs = new CreativeTabs("RoadStuff")
    {
        @Override
        public Item getTabIconItem()
        {
            return Item.getItemFromBlock(RoadStuffBlocks.blockCone);
        }

        @SideOnly(Side.CLIENT)
        public int func_151243_f()
        {
            return 0;
        }
    };

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();

        RoadStuffBlocks.initBlocks();
        RoadStuffItems.initItems();
        GameRegistry.registerWorldGenerator(oreGen, 0);

        RoadStuffAchievements.initAchievements();

        ConfigurationLoader.load(event.getModConfigurationDirectory());

        network = NetworkRegistry.INSTANCE.newSimpleChannel(MODID);
        network.registerMessage(PacketSignType.Handler.class, PacketSignType.class, 0, Side.SERVER);
        network.registerMessage(PacketTrafficChannel.class, PacketTrafficChannel.class, 1, Side.SERVER);

        if(Loader.isModLoaded("chisel"))
        {
            Chisel.sendIMC();
        }
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        GameRegistry.registerTileEntity(TileEntityTrafficLigth.class, RoadStuff.MODID + ":tileTrafficLigth");
        GameRegistry.registerTileEntity(TileEntityBlockTrafficSign.class, RoadStuff.MODID + ":entityBlockSign");
        GameRegistry.registerTileEntity(TileEntityBoundingBlock.class, RoadStuff.MODID + ":tileBoundingBlock");

        FMLCommonHandler.instance().bus().register(new EventPlayer());
        // MinecraftForge.EVENT_BUS.register(new EventPlayer());

        NetworkRegistry.INSTANCE.registerGuiHandler(instance, new RoadStuffGuiHandler());

        proxy.registerRender();

        RoadStuffRecipes.initRecipes();

    }

    @EventHandler
    public void PostInit(FMLPostInitializationEvent event)
    {

    }

    @EventHandler
    public void onServerStart(FMLServerStartingEvent event)
    {
        event.registerServerCommand(new CommandReloadConfig());
    }

}