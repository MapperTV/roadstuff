package tv.mapper.roadstuff.init;

import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;
import tv.mapper.roadstuff.RoadStuff;
import tv.mapper.roadstuff.item.ModItemGroups;

@Mod.EventBusSubscriber(modid = RoadStuff.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModItems
{
    @ObjectHolder(RoadStuff.MODID + ":raw_bitumen")
    public static Item RAW_BITUMEN;
    
    @ObjectHolder(RoadStuff.MODID + ":paint_brush")
    public static Item PAINT_BRUSH;
    
    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().register(new Item(new Item.Properties().group(ModItemGroups.ROADSTUFF)).setRegistryName("raw_bitumen"));
        event.getRegistry().register(new Item(new Item.Properties().group(ModItemGroups.ROADSTUFF)).setRegistryName("paint_brush"));
    }
}
