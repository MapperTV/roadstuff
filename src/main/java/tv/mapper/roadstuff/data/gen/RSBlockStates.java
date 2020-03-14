package tv.mapper.roadstuff.data.gen;

import java.util.Arrays;

import net.minecraft.block.Block;
import net.minecraft.block.FourWayBlock;
import net.minecraft.block.SixWayBlock;
import net.minecraft.data.DataGenerator;
import net.minecraft.item.DyeColor;
import net.minecraft.util.Direction;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ExistingFileHelper;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.client.model.generators.ModelFile.UncheckedModelFile;
import net.minecraftforge.client.model.generators.MultiPartBlockStateBuilder;
import net.minecraftforge.client.model.generators.VariantBlockStateBuilder;
import net.minecraftforge.fml.RegistryObject;
import tv.mapper.mapperbase.MapperBase;
import tv.mapper.mapperbase.block.PaintableBlock;
import tv.mapper.roadstuff.RoadStuff;
import tv.mapper.roadstuff.block.PaintBucketBlock;
import tv.mapper.roadstuff.block.RSBlockRegistry;
import tv.mapper.roadstuff.block.RotatableSlopeBlock;
import tv.mapper.roadstuff.block.SlopeBlock;
import tv.mapper.roadstuff.state.properties.EnumPaintColor;

public class RSBlockStates extends BlockStateProvider
{
    public RSBlockStates(DataGenerator gen, ExistingFileHelper exFileHelper)
    {
        super(gen, MapperBase.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels()
    {
        slopeBlock(RSBlockRegistry.ASPHALT_SLOPE.get(), "asphalt");
        slopeBlock(RSBlockRegistry.CONCRETE_SLOPE.get(), "concrete");

        for(RegistryObject<PaintableBlock> block : RSBlockRegistry.MOD_PAINTABLEBLOCKS)
        {
            String mat, number;

            String[] raw = block.get().getTranslationKey().split("_");

            if(raw[0].contains("asphalt"))
                mat = "asphalt";
            else
                mat = "concrete";

            if(raw[1].equals("slope"))
                number = raw[4];
            else
                number = raw[3];

            if(block.get() instanceof RotatableSlopeBlock)
                rotatableSlopeBlock(block.get(), mat, number, 0);
            else
                horizontalBlock(block.get(), new UncheckedModelFile(RoadStuff.MODID + ":block/" + mat + "_line_" + number), 0);
        }

        for(int i = 0; i < Arrays.stream(DyeColor.values()).count(); i++)
        {
            simpleBlock(RSBlockRegistry.TRAFFIC_CONE_BLOCKS.get(DyeColor.byId(i)).get(), new UncheckedModelFile(RoadStuff.MODID + ":block/" + DyeColor.byId(i).getName() + "_traffic_cone"));
            simpleBlock(RSBlockRegistry.TRAFFIC_BARREL_BLOCKS.get(DyeColor.byId(i)).get(), new UncheckedModelFile(RoadStuff.MODID + ":block/" + DyeColor.byId(i).getName() + "_traffic_barrel"));
            simpleBlock(RSBlockRegistry.TRAFFIC_BOLLARD_BLOCKS.get(DyeColor.byId(i)).get(), new UncheckedModelFile(RoadStuff.MODID + ":block/" + DyeColor.byId(i).getName() + "_traffic_bollard"));
            simpleBlock(RSBlockRegistry.CYLINDRICAL_BOLLARD_BLOCKS.get(DyeColor.byId(i)).get(), new UncheckedModelFile(RoadStuff.MODID + ":block/" + DyeColor.byId(i).getName() + "_cylindrical_bollard"));
            horizontalBlock(RSBlockRegistry.REFLECTOR_BLOCKS.get(DyeColor.byId(i)).get(), new UncheckedModelFile(RoadStuff.MODID + ":block/" + DyeColor.byId(i).getName() + "_reflector"), 0);
            horizontalBlock(RSBlockRegistry.LUMINESCENT_REFLECTOR_BLOCKS.get(DyeColor.byId(i)).get(), new UncheckedModelFile(RoadStuff.MODID + ":block/" + DyeColor.byId(i).getName() + "_reflector"), 0);
            guardrailBlock(RSBlockRegistry.GUARDRAIL_BLOCKS.get(DyeColor.byId(i)).get(), new UncheckedModelFile(RoadStuff.MODID + ":block/" + DyeColor.byId(i).getName() + "_guardrail_post"),
                new UncheckedModelFile(RoadStuff.MODID + ":block/" + DyeColor.byId(i).getName() + "_guardrail_side"));
        }

        guardrailBlock(RSBlockRegistry.STEEL_GUARDRAIL.get(), new UncheckedModelFile(RoadStuff.MODID + ":block/steel_guardrail_post"), new UncheckedModelFile(RoadStuff.MODID + ":block/steel_guardrail_side"));

        horizontalBlock(RSBlockRegistry.YELLOW_BOLLARD.get(), new UncheckedModelFile(RoadStuff.MODID + ":block/yellow_bollard"), 180);
        horizontalBlock(RSBlockRegistry.WHITE_BOLLARD.get(), new UncheckedModelFile(RoadStuff.MODID + ":block/white_bollard"), 180);
        horizontalBlock(RSBlockRegistry.RED_BOLLARD.get(), new UncheckedModelFile(RoadStuff.MODID + ":block/red_bollard"), 180);

        horizontalBlock(RSBlockRegistry.YELLOW_SMALL_BOLLARD.get(), new UncheckedModelFile(RoadStuff.MODID + ":block/yellow_small_bollard"), 180);
        horizontalBlock(RSBlockRegistry.WHITE_SMALL_BOLLARD.get(), new UncheckedModelFile(RoadStuff.MODID + ":block/white_small_bollard"), 180);
        horizontalBlock(RSBlockRegistry.RED_SMALL_BOLLARD.get(), new UncheckedModelFile(RoadStuff.MODID + ":block/red_small_bollard"), 180);

        paintBucketBlock(RSBlockRegistry.PAINT_BUCKET.get(), 0);
    }

    protected void slopeBlock(Block block, String name)
    {
        VariantBlockStateBuilder builder = getVariantBuilder(block);
        String modelName = "";
        for(int i = 1; i < 5; i++)
        {
            modelName = i == 4 ? MapperBase.MODID + ":block/" + name : RoadStuff.MODID + ":block/" + name + "_slope_" + i * 4;
            builder.partialState().with(SlopeBlock.LAYERS, i).modelForState().modelFile(new UncheckedModelFile(modelName)).addModel();
        }
    }

    protected void rotatableSlopeBlock(Block block, String name, String pattern, int offset)
    {
        VariantBlockStateBuilder builder = getVariantBuilder(block);
        String modelName = "";

        for(Direction dir : Direction.Plane.HORIZONTAL)
        {
            for(int i = 1; i < 5; i++)
            {
                modelName = i == 4 ? RoadStuff.MODID + ":block/" + name + "_line_" + pattern : RoadStuff.MODID + ":block/" + name + "_slope_" + i * 4 + "_line_" + pattern;

                builder.partialState().with(RotatableSlopeBlock.DIRECTION, dir).with(RotatableSlopeBlock.LAYERS, i).modelForState().modelFile(new UncheckedModelFile(modelName)).rotationY(
                    (int)((dir.getHorizontalAngle() + offset) % 360)).addModel();
            }
        }
    }

    protected void paintBucketBlock(Block block, int offset)
    {
        VariantBlockStateBuilder builder = getVariantBuilder(block);
        String modelName = "";

        for(Direction dir : Direction.Plane.HORIZONTAL)
        {
            for(int i = 0; i < 9; i++)
            {
                modelName = i == 0 ? RoadStuff.MODID + ":block/paint_bucket" : RoadStuff.MODID + ":block/paint_bucket_white_" + i;
                builder.partialState().with(PaintBucketBlock.COLOR, EnumPaintColor.WHITE).with(PaintBucketBlock.DIRECTION, dir).with(PaintBucketBlock.PAINT, i).modelForState().modelFile(
                    new UncheckedModelFile(modelName)).rotationY((int)((dir.getHorizontalAngle() + offset) % 360)).addModel();

                modelName = i == 0 ? RoadStuff.MODID + ":block/paint_bucket" : RoadStuff.MODID + ":block/paint_bucket_yellow_" + i;
                builder.partialState().with(PaintBucketBlock.COLOR, EnumPaintColor.YELLOW).with(PaintBucketBlock.DIRECTION, dir).with(PaintBucketBlock.PAINT, i).modelForState().modelFile(
                    new UncheckedModelFile(modelName)).rotationY((int)((dir.getHorizontalAngle() + offset) % 360)).addModel();
            }
        }
    }

    public void guardrailBlock(FourWayBlock block, ModelFile post, ModelFile side)
    {
        MultiPartBlockStateBuilder builder = getMultipartBuilder(block).part().modelFile(post).addModel().end();
        guardrailBlock(builder, side);
    }

    public void guardrailBlock(MultiPartBlockStateBuilder builder, ModelFile side)
    {
        SixWayBlock.FACING_TO_PROPERTY_MAP.entrySet().forEach(e ->
        {
            Direction dir = e.getKey();
            if(dir.getAxis().isHorizontal())
            {
                builder.part().modelFile(side).rotationY((((int)dir.getHorizontalAngle()) + 180) % 360).addModel().condition(e.getValue(), true);
            }
        });
    }
}