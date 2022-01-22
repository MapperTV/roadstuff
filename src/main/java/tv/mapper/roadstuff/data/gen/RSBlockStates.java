package tv.mapper.roadstuff.data.gen;

import java.util.Arrays;

import net.minecraft.core.Direction;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CrossCollisionBlock;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.PipeBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.WallBlock;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.client.model.generators.ModelFile.UncheckedModelFile;
import net.minecraftforge.client.model.generators.MultiPartBlockStateBuilder;
import net.minecraftforge.client.model.generators.VariantBlockStateBuilder;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import tv.mapper.mapperbase.data.gen.BaseBlockStates;
import tv.mapper.roadstuff.RoadStuff;
import tv.mapper.roadstuff.world.level.block.PaintBucketBlock;
import tv.mapper.roadstuff.world.level.block.PaintSystem;
import tv.mapper.roadstuff.world.level.block.RSBlockRegistry;
import tv.mapper.roadstuff.world.level.block.RotatableSlopeBlock;
import tv.mapper.roadstuff.world.level.block.state.properties.EnumPaintColor;

public class RSBlockStates extends BaseBlockStates
{
    public RSBlockStates(DataGenerator gen, String modid, ExistingFileHelper exFileHelper)
    {
        super(gen, modid, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels()
    {
        simpleBlock(RSBlockRegistry.CONCRETE.get());
        slopeBlock(RSBlockRegistry.CONCRETE_SLOPE.get(), "concrete", RoadStuff.MODID);
        slabBlock((SlabBlock)RSBlockRegistry.CONCRETE_SLAB.get(), modLoc("block/concrete"), modLoc("block/concrete"), modLoc("block/concrete"), modLoc("block/concrete"));
        stairsBlock((StairBlock)RSBlockRegistry.CONCRETE_STAIRS.get(), modLoc("block/concrete"), modLoc("block/concrete"), modLoc("block/concrete"));
        newWallBlock((WallBlock)RSBlockRegistry.CONCRETE_WALL.get(), new UncheckedModelFile(RoadStuff.MODID + ":block/concrete_wall_post"), new UncheckedModelFile(RoadStuff.MODID + ":block/concrete_wall_side"), new UncheckedModelFile(RoadStuff.MODID + ":block/concrete_wall_side_tall"));
        pressurePlateBlock(RSBlockRegistry.CONCRETE_PRESSURE_PLATE.get(), new UncheckedModelFile(RoadStuff.MODID + ":block/concrete_pressure_plate"), new UncheckedModelFile(RoadStuff.MODID + ":block/concrete_pressure_plate_down"));
        fenceBlock((FenceBlock)RSBlockRegistry.CONCRETE_FENCE.get(), modLoc("block/concrete"));
        fenceGateBlock(RSBlockRegistry.CONCRETE_FENCE_GATE.get(), modLoc("block/concrete"));

        simpleBlock(RSBlockRegistry.ASPHALT.get());
        slopeBlock(RSBlockRegistry.ASPHALT_SLOPE.get(), "asphalt", RoadStuff.MODID);
        slabBlock((SlabBlock)RSBlockRegistry.ASPHALT_SLAB.get(), modLoc("block/asphalt"), modLoc("block/asphalt"), modLoc("block/asphalt"), modLoc("block/asphalt"));
        stairsBlock((StairBlock)RSBlockRegistry.ASPHALT_STAIRS.get(), modLoc("block/asphalt"), modLoc("block/asphalt"), modLoc("block/asphalt"));
        pressurePlateBlock(RSBlockRegistry.ASPHALT_PRESSURE_PLATE.get(), new UncheckedModelFile(RoadStuff.MODID + ":block/asphalt_pressure_plate"), new UncheckedModelFile(RoadStuff.MODID + ":block/asphalt_pressure_plate_down"));

        for(RegistryObject<Block> block : RSBlockRegistry.MOD_PAINTABLEBLOCKS)
        {
            if(block.get() instanceof PaintSystem)
            {
                String mat, number;

                String[] raw = block.get().getDescriptionId().split("_");

                if(raw[0].contains("asphalt"))
                    mat = "asphalt";
                else
                    mat = "concrete";

                if(raw[1].equals("slope"))
                    number = raw[4];
                else
                    number = raw[3];

                if(block.get() instanceof RotatableSlopeBlock)
                    rotatableSlopeBlock(block.get(), mat, number, 180);
                else
                    horizontalBlock(block.get(), new UncheckedModelFile(RoadStuff.MODID + ":block/" + mat + "_line_" + number), 180);
            }
        }

        simpleBlock(RSBlockRegistry.BITUMEN_ORE.get());
        simpleBlock(RSBlockRegistry.BITUMEN_BLOCK.get());

        for(int i = 0; i < Arrays.stream(DyeColor.values()).count(); i++)
        {
            simpleBlock(RSBlockRegistry.TRAFFIC_CONE_BLOCKS.get(DyeColor.byId(i)).get(), new UncheckedModelFile(RoadStuff.MODID + ":block/" + DyeColor.byId(i).getSerializedName() + "_traffic_cone"));
            simpleBlock(RSBlockRegistry.TRAFFIC_BARREL_BLOCKS.get(DyeColor.byId(i)).get(), new UncheckedModelFile(RoadStuff.MODID + ":block/" + DyeColor.byId(i).getSerializedName() + "_traffic_barrel"));
            simpleBlock(RSBlockRegistry.TRAFFIC_BOLLARD_BLOCKS.get(DyeColor.byId(i)).get(), new UncheckedModelFile(RoadStuff.MODID + ":block/" + DyeColor.byId(i).getSerializedName() + "_traffic_bollard"));
            simpleBlock(RSBlockRegistry.CYLINDRICAL_BOLLARD_BLOCKS.get(DyeColor.byId(i)).get(), new UncheckedModelFile(RoadStuff.MODID + ":block/" + DyeColor.byId(i).getSerializedName() + "_cylindrical_bollard"));
            horizontalBlock(RSBlockRegistry.REFLECTOR_BLOCKS.get(DyeColor.byId(i)).get(), new UncheckedModelFile(RoadStuff.MODID + ":block/" + DyeColor.byId(i).getSerializedName() + "_reflector"), 0);
            horizontalBlock(RSBlockRegistry.LUMINESCENT_REFLECTOR_BLOCKS.get(DyeColor.byId(i)).get(), new UncheckedModelFile(RoadStuff.MODID + ":block/" + DyeColor.byId(i).getSerializedName() + "_reflector"), 0);
            guardrailBlock(RSBlockRegistry.GUARDRAIL_BLOCKS.get(DyeColor.byId(i)).get(), new UncheckedModelFile(RoadStuff.MODID + ":block/" + DyeColor.byId(i).getSerializedName() + "_guardrail_post"), new UncheckedModelFile(RoadStuff.MODID + ":block/" + DyeColor.byId(i).getSerializedName() + "_guardrail_side"));
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

    protected void rotatableSlopeBlock(Block block, String name, String pattern, int offset)
    {
        VariantBlockStateBuilder builder = getVariantBuilder(block);
        String modelName = "";

        for(Direction dir : Direction.Plane.HORIZONTAL)
        {
            for(int i = 1; i < 9; i++)
            {
                modelName = i == 8 ? RoadStuff.MODID + ":block/" + name + "_line_" + pattern : RoadStuff.MODID + ":block/" + name + "_slope_" + i * 2 + "_line_" + pattern;

                builder.partialState().with(RotatableSlopeBlock.DIRECTION, dir).with(RotatableSlopeBlock.LAYERS, i).modelForState().modelFile(new UncheckedModelFile(modelName)).rotationY((int)((dir.toYRot() + offset) % 360)).addModel();
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
                builder.partialState().with(PaintBucketBlock.COLOR, EnumPaintColor.WHITE).with(PaintBucketBlock.DIRECTION, dir).with(PaintBucketBlock.PAINT, i).modelForState().modelFile(new UncheckedModelFile(modelName)).rotationY((int)((dir.toYRot() + offset) % 360)).addModel();

                modelName = i == 0 ? RoadStuff.MODID + ":block/paint_bucket" : RoadStuff.MODID + ":block/paint_bucket_yellow_" + i;
                builder.partialState().with(PaintBucketBlock.COLOR, EnumPaintColor.YELLOW).with(PaintBucketBlock.DIRECTION, dir).with(PaintBucketBlock.PAINT, i).modelForState().modelFile(new UncheckedModelFile(modelName)).rotationY((int)((dir.toYRot() + offset) % 360)).addModel();
            }
        }
    }

    public void guardrailBlock(CrossCollisionBlock block, ModelFile post, ModelFile side)
    {
        MultiPartBlockStateBuilder builder = getMultipartBuilder(block).part().modelFile(post).addModel().end();
        guardrailBlock(builder, side);
    }

    public void guardrailBlock(MultiPartBlockStateBuilder builder, ModelFile side)
    {
        PipeBlock.PROPERTY_BY_DIRECTION.entrySet().forEach(e ->
        {
            Direction dir = e.getKey();
            if(dir.getAxis().isHorizontal())
            {
                builder.part().modelFile(side).rotationY((((int)dir.toYRot()) + 180) % 360).addModel().condition(e.getValue(), true);
            }
        });
    }
}