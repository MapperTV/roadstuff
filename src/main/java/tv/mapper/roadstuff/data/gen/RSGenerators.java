package tv.mapper.roadstuff.data.gen;

import java.util.Collections;

import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourcePackType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;
import tv.mapper.roadstuff.RoadStuff;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class RSGenerators
{
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event)
    {
        String modid = RoadStuff.MODID;
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper delegate = event.getExistingFileHelper();

        ExistingFileHelper helper = new ExistingFileHelper(Collections.emptyList(), true)
        {
            @Override
            public boolean exists(ResourceLocation loc, ResourcePackType type, String pathSuffix, String pathPrefix)
            {
                if(loc.getNamespace() == "mapperbase")
                {
                    return true;
                }
                return delegate.exists(loc, type, pathSuffix, pathPrefix);
            }
        };

        generator.addProvider(new RSRecipes(generator));
        generator.addProvider(new RSLootTables(generator));
        generator.addProvider(new RSBlockStates(generator, helper));
        generator.addProvider(new RSBlockModels(generator, modid, helper));
        generator.addProvider(new RSItemModels(generator, modid, helper));

        generator.addProvider(new RSBlockTags(generator));
        generator.addProvider(new RSItemTags(generator));

        generator.addProvider(new RSLang(generator, modid, "en_us"));
        generator.addProvider(new RSLang(generator, modid, "fr_fr"));
    }
}