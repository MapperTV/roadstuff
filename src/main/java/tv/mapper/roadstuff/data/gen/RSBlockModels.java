package tv.mapper.roadstuff.data.gen;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockModelProvider;
import net.minecraftforge.client.model.generators.ExistingFileHelper;
import tv.mapper.mapperbase.MapperBase;

public class RSBlockModels extends BlockModelProvider
{

    public RSBlockModels(DataGenerator generator, ExistingFileHelper existingFileHelper)
    {
        super(generator, MapperBase.MODID, existingFileHelper);
    }

    @Override
    public String getName()
    {
        return "Mapper Base Block Models";
    }

    @Override
    protected void registerModels()
    {
        // getBuilder("steel_wall_inventory").parent(getExistingFile(mcLoc("block/wall_inventory"))).texture("wall", modLoc("block/steel_block"));
        // getBuilder("steel_pressure_plate").parent(getExistingFile(mcLoc("block/pressure_plate_up"))).texture("texture", modLoc("block/steel_block"));
        // getBuilder("steel_pressure_plate_down").parent(getExistingFile(mcLoc("block/pressure_plate_down"))).texture("texture", modLoc("block/steel_block"));
        // getBuilder("steel_fence_inventory").parent(getExistingFile(mcLoc("block/fence_inventory"))).texture("texture", modLoc("block/steel_block"));
        //
        // getBuilder("concrete_wall_inventory").parent(getExistingFile(mcLoc("block/wall_inventory"))).texture("wall", modLoc("block/concrete"));
        // getBuilder("concrete_pressure_plate").parent(getExistingFile(mcLoc("block/pressure_plate_up"))).texture("texture", modLoc("block/concrete"));
        // getBuilder("concrete_pressure_plate_down").parent(getExistingFile(mcLoc("block/pressure_plate_down"))).texture("texture", modLoc("block/concrete"));
    }

}
