package tv.mapper.roadstuff.data.gen;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;
import tv.mapper.roadstuff.RoadStuff;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class RSGenerators
{
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event)
    {
        String modid = RoadStuff.MODID;
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

        generator.addProvider(new RSRecipes(generator));
        generator.addProvider(new RSLootTables(generator));
        generator.addProvider(new RSBlockStates(generator, existingFileHelper));
        generator.addProvider(new RSBlockModels(generator, modid, existingFileHelper));
        generator.addProvider(new RSItemModels(generator, modid, existingFileHelper));

        RSBlockTags rsBlockTags = new RSBlockTags(generator, existingFileHelper);

        generator.addProvider(rsBlockTags);
        generator.addProvider(new RSItemTags(generator, rsBlockTags, existingFileHelper));
        generator.addProvider(new RSLang(generator, modid, "en_us"));
        generator.addProvider(new RSLang(generator, modid, "fr_fr"));
    }
}