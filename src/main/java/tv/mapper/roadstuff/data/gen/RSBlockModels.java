package tv.mapper.roadstuff.data.gen;

import java.util.Arrays;

import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeColor;
import net.minecraftforge.common.data.ExistingFileHelper;
import tv.mapper.mapperbase.data.gen.BaseBlockModels;
import tv.mapper.roadstuff.util.ModConstants;

public class RSBlockModels extends BaseBlockModels
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
        buildWall("concrete", modLoc("block/concrete"));
        getBuilder("concrete_pressure_plate").parent(getExistingFile(mcLoc("block/pressure_plate_up"))).texture("texture", modLoc("block/concrete"));
        getBuilder("concrete_pressure_plate_down").parent(getExistingFile(mcLoc("block/pressure_plate_down"))).texture("texture", modLoc("block/concrete"));
        getBuilder("concrete_fence_inventory").parent(getExistingFile(mcLoc("block/fence_inventory"))).texture("texture", modLoc("block/concrete"));

        getBuilder("asphalt_pressure_plate").parent(getExistingFile(mcLoc("block/pressure_plate_up"))).texture("texture", modLoc("block/asphalt"));
        getBuilder("asphalt_pressure_plate_down").parent(getExistingFile(mcLoc("block/pressure_plate_down"))).texture("texture", modLoc("block/asphalt"));

        for(int i = 1; i < 8; i++)
        {
            getBuilder("asphalt_slope_" + i * 2).parent(getExistingFile(new ResourceLocation("mapperbase", "block/slope_" + i * 2))).texture("base", modLoc("block/asphalt")).texture("particle", modLoc("block/asphalt"));
            getBuilder("concrete_slope_" + i * 2).parent(getExistingFile(new ResourceLocation("mapperbase", "block/slope_" + i * 2))).texture("base", modLoc("block/concrete")).texture("particle", modLoc("block/concrete"));

            for(int j = 1; j < ModConstants.PATTERNS; j++)
            {
                getBuilder("asphalt_slope_" + i * 2 + "_line_" + j).parent(getExistingFile(modLoc("block/painted_slope_" + i * 2))).texture("base", modLoc("block/asphalt")).texture("overlay", modLoc("block/" + j)).texture("particle", modLoc("block/asphalt"));
                getBuilder("concrete_slope_" + i * 2 + "_line_" + j).parent(getExistingFile(modLoc("block/painted_slope_" + i * 2))).texture("base", modLoc("block/concrete")).texture("overlay", modLoc("block/" + j)).texture("particle", modLoc("block/concrete"));
            }
        }

        for(int j = 1; j < ModConstants.PATTERNS; j++)
        {
            getBuilder("asphalt_line_" + j).parent(getExistingFile(modLoc("block/cube_line"))).texture("base", modLoc("block/asphalt")).texture("overlay", modLoc("block/" + j)).texture("particle", modLoc("block/asphalt"));
            getBuilder("concrete_line_" + j).parent(getExistingFile(modLoc("block/cube_line"))).texture("base", modLoc("block/concrete")).texture("overlay", modLoc("block/" + j)).texture("particle", modLoc("block/concrete"));
        }

        for(int i = 0; i < Arrays.stream(DyeColor.values()).count(); i++)
        {
            getBuilder(DyeColor.byId(i).getSerializedName() + "_traffic_cone").parent(getExistingFile(modLoc("block/traffic_cone"))).texture("bottom", modLoc("block/cone_bottom")).texture("side", modLoc("block/" + DyeColor.byId(i).getSerializedName() + "_cone_side")).texture("top", modLoc("block/" + DyeColor.byId(i).getSerializedName() + "_cone_top")).texture("particle", modLoc("block/" + DyeColor.byId(i).getSerializedName() + "_cone_side"));
            getBuilder(DyeColor.byId(i).getSerializedName() + "_traffic_bollard").parent(getExistingFile(modLoc("block/traffic_bollard"))).texture("bottom", modLoc("block/cone_bottom")).texture("side", modLoc("block/" + DyeColor.byId(i).getSerializedName() + "_cone_side")).texture("top", modLoc("block/" + DyeColor.byId(i).getSerializedName() + "_cone_top")).texture("particle", modLoc("block/" + DyeColor.byId(i).getSerializedName() + "_cone_side"));
            getBuilder(DyeColor.byId(i).getSerializedName() + "_traffic_barrel").parent(getExistingFile(modLoc("block/traffic_barrel"))).texture("bottom", modLoc("block/cone_bottom")).texture("side", modLoc("block/" + DyeColor.byId(i).getSerializedName() + "_cone_side")).texture("top", modLoc("block/" + DyeColor.byId(i).getSerializedName() + "_cone_top")).texture("particle", modLoc("block/" + DyeColor.byId(i).getSerializedName() + "_cone_side"));
            getBuilder(DyeColor.byId(i).getSerializedName() + "_cylindrical_bollard").parent(getExistingFile(modLoc("block/cylindrical_bollard"))).texture("all", modLoc("block/" + DyeColor.byId(i).getSerializedName() + "_cylindrical_bollard"));
            getBuilder(DyeColor.byId(i).getSerializedName() + "_reflector").parent(getExistingFile(modLoc("block/reflector"))).texture("texture", modLoc("block/" + DyeColor.byId(i).getSerializedName() + "_reflector")).texture("particle", modLoc("block/" + DyeColor.byId(i).getSerializedName() + "_reflector"));

            getBuilder(DyeColor.byId(i).getSerializedName() + "_guardrail_post").parent(getExistingFile(modLoc("block/guardrail_post"))).texture("all", modLoc("block/" + DyeColor.byId(i).getSerializedName() + "_guardrail")).texture("particle", modLoc("block/" + DyeColor.byId(i).getSerializedName() + "_guardrail"));
            getBuilder(DyeColor.byId(i).getSerializedName() + "_guardrail_side").parent(getExistingFile(modLoc("block/guardrail_side"))).texture("all", modLoc("block/" + DyeColor.byId(i).getSerializedName() + "_guardrail")).texture("particle", modLoc("block/" + DyeColor.byId(i).getSerializedName() + "_guardrail"));
            getBuilder(DyeColor.byId(i).getSerializedName() + "_guardrail_inventory").parent(getExistingFile(modLoc("block/guardrail_inventory"))).texture("all", modLoc("block/" + DyeColor.byId(i).getSerializedName() + "_guardrail")).texture("particle", modLoc("block/" + DyeColor.byId(i).getSerializedName() + "_guardrail"));
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
            getBuilder("paint_bucket_white_" + i).parent(getExistingFile(modLoc("block/paint_bucket_" + i))).texture("all", modLoc("block/paint_bucket_white")).texture("particle", modLoc("block/paint_bucket_white"));
            getBuilder("paint_bucket_yellow_" + i).parent(getExistingFile(modLoc("block/paint_bucket_" + i))).texture("all", modLoc("block/paint_bucket_yellow")).texture("particle", modLoc("block/paint_bucket_yellow"));
        }
    }
}