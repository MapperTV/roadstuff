package tv.mapper.roadstuff.data.gen;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ExistingFileHelper;
import tv.mapper.mapperbase.MapperBase;

public class RSBlockStates extends BlockStateProvider
{

    public RSBlockStates(DataGenerator gen, ExistingFileHelper exFileHelper)
    {
        super(gen, MapperBase.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels()
    {
        // simpleBlock(BaseBlocks.STEEL_BLOCK);
        // slabBlock((SlabBlock)BaseBlocks.STEEL_SLAB, modLoc("block/steel_block"), modLoc("block/steel_slab_side"), modLoc("block/steel_block"), modLoc("block/steel_block"));
        // stairsBlock((StairsBlock)BaseBlocks.STEEL_STAIRS, modLoc("block/steel_block"), modLoc("block/steel_block"), modLoc("block/steel_block"));
        // wallBlock((WallBlock)BaseBlocks.STEEL_WALL, modLoc("block/steel_block"));
        // pressurePlateBlock(BaseBlocks.STEEL_PRESSURE_PLATE, new UncheckedModelFile(MapperBase.MODID + ":block/steel_pressure_plate"),
        // new UncheckedModelFile(MapperBase.MODID + ":block/steel_pressure_plate_down"));
        // fenceBlock((FenceBlock)BaseBlocks.STEEL_FENCE, modLoc("block/steel_block"));
        //
        // simpleBlock(BaseBlocks.CONCRETE);
        // slabBlock((SlabBlock)BaseBlocks.CONCRETE_SLAB, modLoc("block/concrete"), modLoc("block/concrete"), modLoc("block/concrete"), modLoc("block/concrete"));
        // stairsBlock((StairsBlock)BaseBlocks.CONCRETE_STAIRS, modLoc("block/concrete"), modLoc("block/concrete"), modLoc("block/concrete"));
        // wallBlock((WallBlock)BaseBlocks.CONCRETE_WALL, modLoc("block/concrete"));
        // pressurePlateBlock(BaseBlocks.CONCRETE_PRESSURE_PLATE, new UncheckedModelFile(MapperBase.MODID + ":block/concrete_pressure_plate"),
        // new UncheckedModelFile(MapperBase.MODID + ":block/concrete_pressure_plate_down"));
    }
}
