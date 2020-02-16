package tv.mapper.roadstuff.data.gen;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class RSGenerators
{
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event)
    {
        DataGenerator generator = event.getGenerator();
        generator.addProvider(new RSRecipes(generator));
        generator.addProvider(new RSLootTables(generator));
        generator.addProvider(new RSBlockStates(generator, event.getExistingFileHelper()));
        generator.addProvider(new RSBlockModels(generator, event.getExistingFileHelper()));
        generator.addProvider(new RSItemModels(generator, event.getExistingFileHelper()));

        generator.addProvider(new RSBlockTags(generator));
        generator.addProvider(new RSItemTags(generator));

        generator.addProvider(new RSLang(generator, "en_us"));
        generator.addProvider(new RSLang(generator, "fr_fr"));
    }
}