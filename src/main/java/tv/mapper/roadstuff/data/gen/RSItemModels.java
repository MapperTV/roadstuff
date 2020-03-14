package tv.mapper.roadstuff.data.gen;

import java.util.Arrays;

import net.minecraft.data.DataGenerator;
import net.minecraft.item.DyeColor;
import net.minecraftforge.client.model.generators.ExistingFileHelper;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile.UncheckedModelFile;

public class RSItemModels extends ItemModelProvider
{
    public RSItemModels(DataGenerator generator, String modid, ExistingFileHelper existingFileHelper)
    {
        super(generator, modid, existingFileHelper);
    }

    @Override
    public String getName()
    {
        return "RoadStuff Item Models";
    }

    @Override
    protected void registerModels()
    {
        getBuilder("asphalt_slope").parent(new UncheckedModelFile(modid + ":block/asphalt_slope_4"));
        getBuilder("concrete_slope").parent(new UncheckedModelFile(modid + ":block/concrete_slope_4"));

        for(int i = 0; i < Arrays.stream(DyeColor.values()).count(); i++)
        {
            getBuilder(DyeColor.byId(i).getName() + "_traffic_cone").parent(new UncheckedModelFile(modid + ":block/" + DyeColor.byId(i).getName() + "_traffic_cone"));
            getBuilder(DyeColor.byId(i).getName() + "_traffic_barrel").parent(new UncheckedModelFile(modid + ":block/" + DyeColor.byId(i).getName() + "_traffic_barrel"));
            getBuilder(DyeColor.byId(i).getName() + "_traffic_bollard").parent(new UncheckedModelFile(modid + ":block/" + DyeColor.byId(i).getName() + "_traffic_bollard"));
            getBuilder(DyeColor.byId(i).getName() + "_cylindrical_bollard").parent(new UncheckedModelFile(modid + ":block/" + DyeColor.byId(i).getName() + "_cylindrical_bollard"));
            getBuilder(DyeColor.byId(i).getName() + "_reflector").parent(new UncheckedModelFile(modid + ":block/" + DyeColor.byId(i).getName() + "_reflector"));
            getBuilder(DyeColor.byId(i).getName() + "_luminescent_reflector").parent(new UncheckedModelFile(modid + ":block/" + DyeColor.byId(i).getName() + "_reflector"));
            getBuilder(DyeColor.byId(i).getName() + "_guardrail").parent(new UncheckedModelFile(modid + ":block/" + DyeColor.byId(i).getName() + "_guardrail_inventory"));
        }

        getBuilder("white_bollard").parent(new UncheckedModelFile(modid + ":block/white_bollard"));
        getBuilder("yellow_bollard").parent(new UncheckedModelFile(modid + ":block/yellow_bollard"));
        getBuilder("red_bollard").parent(new UncheckedModelFile(modid + ":block/red_bollard"));
        getBuilder("white_small_bollard").parent(new UncheckedModelFile(modid + ":block/white_small_bollard"));
        getBuilder("yellow_small_bollard").parent(new UncheckedModelFile(modid + ":block/yellow_small_bollard"));
        getBuilder("red_small_bollard").parent(new UncheckedModelFile(modid + ":block/red_small_bollard"));

        getBuilder("steel_guardrail").parent(new UncheckedModelFile(modid + ":block/steel_guardrail_inventory"));
    }
}