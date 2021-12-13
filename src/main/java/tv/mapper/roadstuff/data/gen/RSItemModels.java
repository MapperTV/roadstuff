package tv.mapper.roadstuff.data.gen;

import java.util.Arrays;

import net.minecraft.data.DataGenerator;
import net.minecraft.world.item.DyeColor;
import net.minecraftforge.client.model.generators.ModelFile.UncheckedModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import tv.mapper.mapperbase.data.gen.BaseItemModels;

public class RSItemModels extends BaseItemModels
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
        registerBlockBasics("asphalt", true, true, true, false, true, false);
        registerBlockBasics("concrete", true, true, true, true, true, true);

        getBuilder("asphalt_slope").parent(new UncheckedModelFile(modid + ":block/asphalt_slope_2"));
        getBuilder("concrete_slope").parent(new UncheckedModelFile(modid + ":block/concrete_slope_2"));

        getBuilder("concrete_fence_gate").parent(new UncheckedModelFile(modid + ":block/concrete_fence_gate"));

        for(int i = 0; i < Arrays.stream(DyeColor.values()).count(); i++)
        {
            getBuilder(DyeColor.byId(i).getSerializedName() + "_traffic_cone").parent(new UncheckedModelFile(modid + ":block/" + DyeColor.byId(i).getSerializedName() + "_traffic_cone"));
            getBuilder(DyeColor.byId(i).getSerializedName() + "_traffic_barrel").parent(new UncheckedModelFile(modid + ":block/" + DyeColor.byId(i).getSerializedName() + "_traffic_barrel"));
            getBuilder(DyeColor.byId(i).getSerializedName() + "_traffic_bollard").parent(new UncheckedModelFile(modid + ":block/" + DyeColor.byId(i).getSerializedName() + "_traffic_bollard"));
            getBuilder(DyeColor.byId(i).getSerializedName() + "_cylindrical_bollard").parent(new UncheckedModelFile(modid + ":block/" + DyeColor.byId(i).getSerializedName() + "_cylindrical_bollard"));
            getBuilder(DyeColor.byId(i).getSerializedName() + "_reflector").parent(new UncheckedModelFile("item/generated")).texture("layer0", modLoc("item/" + DyeColor.byId(i).getSerializedName() + "_reflector"));
            getBuilder(DyeColor.byId(i).getSerializedName() + "_luminescent_reflector").parent(new UncheckedModelFile("item/generated")).texture("layer0", modLoc("item/" + DyeColor.byId(i).getSerializedName() + "_reflector"));
            getBuilder(DyeColor.byId(i).getSerializedName() + "_guardrail").parent(new UncheckedModelFile(modid + ":block/" + DyeColor.byId(i).getSerializedName() + "_guardrail_inventory"));
        }

        getBuilder("bitumen_block").parent(new UncheckedModelFile(modid + ":block/bitumen_block"));
        getBuilder("bitumen_ore").parent(new UncheckedModelFile(modid + ":block/bitumen_ore"));
        getBuilder("raw_bitumen").parent(new UncheckedModelFile("item/generated")).texture("layer0", modLoc("item/raw_bitumen"));
        getBuilder("bituminous_coal").parent(new UncheckedModelFile("item/generated")).texture("layer0", modLoc("item/bituminous_coal"));

        getBuilder("white_bollard").parent(new UncheckedModelFile(modid + ":block/white_bollard"));
        getBuilder("yellow_bollard").parent(new UncheckedModelFile(modid + ":block/yellow_bollard"));
        getBuilder("red_bollard").parent(new UncheckedModelFile(modid + ":block/red_bollard"));
        getBuilder("white_small_bollard").parent(new UncheckedModelFile(modid + ":block/white_small_bollard"));
        getBuilder("yellow_small_bollard").parent(new UncheckedModelFile(modid + ":block/yellow_small_bollard"));
        getBuilder("red_small_bollard").parent(new UncheckedModelFile(modid + ":block/red_small_bollard"));

        getBuilder("steel_guardrail").parent(new UncheckedModelFile(modid + ":block/steel_guardrail_inventory"));
    }
}