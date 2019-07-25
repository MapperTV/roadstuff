package tv.mapper.roadstuff.init;

import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;
import tv.mapper.roadstuff.RoadStuff;
import tv.mapper.roadstuff.item.BrushItem;
import tv.mapper.roadstuff.item.ModItemGroups;

@ObjectHolder(RoadStuff.MODID)
@EventBusSubscriber(bus = Bus.MOD)
public class ModItems
{
    public static Item RAW_BITUMEN;
    public static Item PAINT_BRUSH;

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event)
    {
        event.getRegistry().register(new Item(new Item.Properties().group(ModItemGroups.ROADSTUFF)).setRegistryName("raw_bitumen"));
        event.getRegistry().register(new BrushItem(new Item.Properties().group(ModItemGroups.ROADSTUFF).maxStackSize(1)).setRegistryName("paint_brush"));
    }
}
