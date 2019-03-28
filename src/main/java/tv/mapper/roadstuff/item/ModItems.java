package tv.mapper.roadstuff.item;

import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;
import tv.mapper.roadstuff.RoadStuff;

@Mod.EventBusSubscriber(modid = RoadStuff.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModItems
{
    @ObjectHolder(RoadStuff.MODID + ":raw_bitumen")
    public static Item RAW_BITUMEN;
    
    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().register(new Item(new Item.Properties().group(ModItemGroups.ROADSTUFF)).setRegistryName("raw_bitumen"));
    }
}
