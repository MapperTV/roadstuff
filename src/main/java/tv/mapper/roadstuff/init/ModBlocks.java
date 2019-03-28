package tv.mapper.roadstuff.init;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;
import tv.mapper.roadstuff.RoadStuff;
import tv.mapper.roadstuff.item.ModItemGroups;

@EventBusSubscriber(bus = Bus.MOD)
public class ModBlocks
{
    @ObjectHolder(RoadStuff.MODID + ":asphalt_block")
    public static Block ASPHALT_BLOCK;

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event)
    {
        event.getRegistry().register(new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5F, 6.0F)).setRegistryName("asphalt_block"));
    }
    
    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event)
    {
        event.getRegistry().register(new ItemBlock(ASPHALT_BLOCK, new Item.Properties().group(ModItemGroups.ROADSTUFF)).setRegistryName(ASPHALT_BLOCK.getRegistryName()));
    }
}
