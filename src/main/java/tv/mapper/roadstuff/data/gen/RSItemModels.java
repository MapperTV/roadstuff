package tv.mapper.roadstuff.data.gen;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ExistingFileHelper;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile.UncheckedModelFile;
import tv.mapper.mapperbase.MapperBase;

public class RSItemModels extends ItemModelProvider
{
    public RSItemModels(DataGenerator generator, ExistingFileHelper existingFileHelper)
    {
        super(generator, MapperBase.MODID, existingFileHelper);
    }

    @Override
    public String getName()
    {
        return "Mapper Base Item Models";
    }

    @Override
    protected void registerModels()
    {
        getBuilder("flatter_hammer").parent(new UncheckedModelFile("item/handheld")).texture("layer0", modLoc("item/flatter_hammer"));
        getBuilder("steel_nugget").parent(new UncheckedModelFile("item/generated")).texture("layer0", modLoc("item/steel_nugget"));
        getBuilder("steel_ingot").parent(new UncheckedModelFile("item/generated")).texture("layer0", modLoc("item/steel_ingot"));
        getBuilder("steel_plate").parent(new UncheckedModelFile("item/generated")).texture("layer0", modLoc("item/steel_plate"));
        getBuilder("steel_rod").parent(new UncheckedModelFile("item/generated")).texture("layer0", modLoc("item/steel_rod"));

        getBuilder("iron_plate").parent(new UncheckedModelFile("item/generated")).texture("layer0", modLoc("item/iron_plate"));
        getBuilder("iron_rod").parent(new UncheckedModelFile("item/generated")).texture("layer0", modLoc("item/iron_rod"));

        getBuilder("bolt").parent(new UncheckedModelFile("item/generated")).texture("layer0", modLoc("item/bolt"));

        getBuilder("steel_block").parent(new UncheckedModelFile(modid + ":block/steel_block"));
        getBuilder("steel_slab").parent(new UncheckedModelFile(modid + ":block/steel_slab"));
        getBuilder("steel_stairs").parent(new UncheckedModelFile(modid + ":block/steel_stairs"));
        getBuilder("steel_wall").parent(new UncheckedModelFile(modid + ":block/steel_wall_inventory"));
        getBuilder("steel_pressure_plate").parent(new UncheckedModelFile(modid + ":block/steel_pressure_plate"));
        getBuilder("steel_fence").parent(new UncheckedModelFile(modid + ":block/steel_fence_inventory"));
        
        getBuilder("concrete").parent(new UncheckedModelFile(modid + ":block/concrete"));
        getBuilder("concrete_slab").parent(new UncheckedModelFile(modid + ":block/concrete_slab"));
        getBuilder("concrete_stairs").parent(new UncheckedModelFile(modid + ":block/concrete_stairs"));
        getBuilder("concrete_wall").parent(new UncheckedModelFile(modid + ":block/concrete_wall_inventory"));
        getBuilder("concrete_pressure_plate").parent(new UncheckedModelFile(modid + ":block/concrete_pressure_plate"));

        getBuilder("steel_axe").parent(new UncheckedModelFile("item/handheld")).texture("layer0", modLoc("item/steel_axe"));
        getBuilder("steel_pickaxe").parent(new UncheckedModelFile("item/handheld")).texture("layer0", modLoc("item/steel_pickaxe"));
        getBuilder("steel_shovel").parent(new UncheckedModelFile("item/handheld")).texture("layer0", modLoc("item/steel_shovel"));
        getBuilder("steel_hoe").parent(new UncheckedModelFile("item/handheld")).texture("layer0", modLoc("item/steel_hoe"));
        getBuilder("steel_sword").parent(new UncheckedModelFile("item/handheld")).texture("layer0", modLoc("item/steel_sword"));

        getBuilder("steel_helmet").parent(new UncheckedModelFile("item/generated")).texture("layer0", modLoc("item/steel_helmet"));
        getBuilder("steel_chestplate").parent(new UncheckedModelFile("item/generated")).texture("layer0", modLoc("item/steel_chestplate"));
        getBuilder("steel_leggings").parent(new UncheckedModelFile("item/generated")).texture("layer0", modLoc("item/steel_leggings"));
        getBuilder("steel_boots").parent(new UncheckedModelFile("item/generated")).texture("layer0", modLoc("item/steel_boots"));

        getBuilder("steel_horse_armor").parent(new UncheckedModelFile("item/generated")).texture("layer0", modLoc("item/steel_horse_armor"));
    }

}
