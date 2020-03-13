package tv.mapper.roadstuff.data.gen;

import java.util.Arrays;

import net.minecraft.data.DataGenerator;
import net.minecraft.item.DyeColor;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.BlockModelProvider;
import net.minecraftforge.client.model.generators.ExistingFileHelper;
import tv.mapper.mapperbase.MapperBase;
import tv.mapper.roadstuff.util.ModConstants;

public class RSBlockModels extends BlockModelProvider
{
    public RSBlockModels(DataGenerator generator, String modid, ExistingFileHelper existingFileHelper)
    {
        super(generator, modid, existingFileHelper);
    }

    @Override
    public String getName()
    {
        return "RoadStuff Block Models";
    }

    @Override
    protected void registerModels()
    {
        for(int i = 1; i < 4; i++)
        {
            getBuilder("asphalt_slope_" + i * 4).parent(getExistingFile(modLoc("block/slope_" + i * 4))).texture("base", new ResourceLocation(MapperBase.MODID, "block/asphalt")).texture("particle",
                new ResourceLocation(MapperBase.MODID, "block/asphalt"));
            getBuilder("concrete_slope_" + i * 4).parent(getExistingFile(modLoc("block/slope_" + i * 4))).texture("base", new ResourceLocation(MapperBase.MODID, "block/concrete")).texture("particle",
                new ResourceLocation(MapperBase.MODID, "block/concrete"));

            for(int j = 1; j < ModConstants.PATTERNS; j++)
            {
                getBuilder("asphalt_slope_" + i * 4 + "_line_" + j).parent(getExistingFile(modLoc("block/painted_slope_" + i * 4))).texture("base",
                    new ResourceLocation(MapperBase.MODID, "block/asphalt")).texture("overlay", modLoc("block/" + j)).texture("particle", new ResourceLocation(MapperBase.MODID, "block/asphalt"));
                getBuilder("concrete_slope_" + i * 4 + "_line_" + j).parent(getExistingFile(modLoc("block/painted_slope_" + i * 4))).texture("base",
                    new ResourceLocation(MapperBase.MODID, "block/concrete")).texture("overlay", modLoc("block/" + j)).texture("particle", new ResourceLocation(MapperBase.MODID, "block/concrete"));
            }
        }

        for(int j = 1; j < ModConstants.PATTERNS; j++)
        {
            getBuilder("asphalt_line_" + j).parent(getExistingFile(modLoc("block/cube_line"))).texture("base", new ResourceLocation(MapperBase.MODID, "block/asphalt")).texture("overlay",
                modLoc("block/" + j)).texture("particle", new ResourceLocation(MapperBase.MODID, "block/asphalt"));
            getBuilder("concrete_line_" + j).parent(getExistingFile(modLoc("block/cube_line"))).texture("base", new ResourceLocation(MapperBase.MODID, "block/concrete")).texture("overlay",
                modLoc("block/" + j)).texture("particle", new ResourceLocation(MapperBase.MODID, "block/concrete"));
        }

        for(int i = 0; i < Arrays.stream(DyeColor.values()).count(); i++)
        {
            getBuilder(DyeColor.byId(i).getName() + "_traffic_cone").parent(getExistingFile(modLoc("block/traffic_cone"))).texture("bottom", modLoc("block/cone_bottom")).texture("side",
                modLoc("block/" + DyeColor.byId(i).getName() + "_cone_side")).texture("top", modLoc("block/" + DyeColor.byId(i).getName() + "_cone_top")).texture("particle",
                    modLoc("block/" + DyeColor.byId(i).getName() + "_cone_side"));
            getBuilder(DyeColor.byId(i).getName() + "_traffic_bollard").parent(getExistingFile(modLoc("block/traffic_bollard"))).texture("bottom", modLoc("block/cone_bottom")).texture("side",
                modLoc("block/" + DyeColor.byId(i).getName() + "_cone_side")).texture("top", modLoc("block/" + DyeColor.byId(i).getName() + "_cone_top")).texture("particle",
                    modLoc("block/" + DyeColor.byId(i).getName() + "_cone_side"));
            getBuilder(DyeColor.byId(i).getName() + "_traffic_barrel").parent(getExistingFile(modLoc("block/traffic_barrel"))).texture("bottom", modLoc("block/cone_bottom")).texture("side",
                modLoc("block/" + DyeColor.byId(i).getName() + "_cone_side")).texture("top", modLoc("block/" + DyeColor.byId(i).getName() + "_cone_top")).texture("particle",
                    modLoc("block/" + DyeColor.byId(i).getName() + "_cone_side"));
            getBuilder(DyeColor.byId(i).getName() + "_cylindrical_bollard").parent(getExistingFile(modLoc("block/cylindrical_bollard"))).texture("all",
                modLoc("block/" + DyeColor.byId(i).getName() + "_cylindrical_bollard"));
            getBuilder(DyeColor.byId(i).getName() + "_reflector").parent(getExistingFile(modLoc("block/reflector"))).texture("texture", modLoc("block/" + DyeColor.byId(i).getName() + "_reflector")).texture(
                "particle", modLoc("block/" + DyeColor.byId(i).getName() + "_reflector"));

            getBuilder(DyeColor.byId(i).getName() + "_guardrail_post").parent(getExistingFile(modLoc("block/guardrail_post"))).texture("all",
                modLoc("block/" + DyeColor.byId(i).getName() + "_guardrail")).texture("particle", modLoc("block/" + DyeColor.byId(i).getName() + "_guardrail"));
            getBuilder(DyeColor.byId(i).getName() + "_guardrail_side").parent(getExistingFile(modLoc("block/guardrail_side"))).texture("all",
                modLoc("block/" + DyeColor.byId(i).getName() + "_guardrail")).texture("particle", modLoc("block/" + DyeColor.byId(i).getName() + "_guardrail"));
            getBuilder(DyeColor.byId(i).getName() + "_guardrail_inventory").parent(getExistingFile(modLoc("block/guardrail_inventory"))).texture("all",
                modLoc("block/" + DyeColor.byId(i).getName() + "_guardrail")).texture("particle", modLoc("block/" + DyeColor.byId(i).getName() + "_guardrail"));
        }

        getBuilder("steel_guardrail_post").parent(getExistingFile(modLoc("block/guardrail_post"))).texture("all", modLoc("block/steel_guardrail")).texture("particle", modLoc("block/steel_guardrail"));
        getBuilder("steel_guardrail_side").parent(getExistingFile(modLoc("block/guardrail_side"))).texture("all", modLoc("block/steel_guardrail")).texture("particle", modLoc("block/steel_guardrail"));
        getBuilder("steel_guardrail_inventory").parent(getExistingFile(modLoc("block/guardrail_inventory"))).texture("all", modLoc("block/steel_guardrail")).texture("particle", modLoc("block/steel_guardrail"));

        getBuilder("white_bollard").parent(getExistingFile(modLoc("block/eur_bollard"))).texture("all", modLoc("block/white_bollard"));
        getBuilder("yellow_bollard").parent(getExistingFile(modLoc("block/eur_bollard"))).texture("all", modLoc("block/yellow_bollard"));
        getBuilder("red_bollard").parent(getExistingFile(modLoc("block/rect_bollard"))).texture("all", modLoc("block/red_bollard"));

        getBuilder("white_small_bollard").parent(getExistingFile(modLoc("block/small_eur_bollard"))).texture("all", modLoc("block/white_bollard"));
        getBuilder("yellow_small_bollard").parent(getExistingFile(modLoc("block/small_eur_bollard"))).texture("all", modLoc("block/yellow_bollard"));
        getBuilder("red_small_bollard").parent(getExistingFile(modLoc("block/small_eur_bollard"))).texture("all", modLoc("block/red_bollard"));

        for(int i = 1; i < 9; i++)
        {
            getBuilder("paint_bucket_white_" + i).parent(getExistingFile(modLoc("block/paint_bucket_" + i))).texture("all", modLoc("block/paint_bucket_white")).texture("particle",
                modLoc("block/paint_bucket_white"));
            getBuilder("paint_bucket_yellow_" + i).parent(getExistingFile(modLoc("block/paint_bucket_" + i))).texture("all", modLoc("block/paint_bucket_yellow")).texture("particle",
                modLoc("block/paint_bucket_yellow"));
        }
    }
}
