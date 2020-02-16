package tv.mapper.roadstuff.data.gen;

import net.minecraft.data.DataGenerator;
import tv.mapper.mapperbase.MapperBase;
import tv.mapper.mapperbase.data.gen.BaseLootTableProvider;
import tv.mapper.roadstuff.init.ModBlocks;

public class RSLootTables extends BaseLootTableProvider
{

    public RSLootTables(DataGenerator dataGeneratorIn)
    {
        super(dataGeneratorIn);
    }

    @Override
    protected void addTables()
    {
        lootTables.put(ModBlocks.BITUMEN_BLOCK, createStandardTable(MapperBase.MODID, ModBlocks.BITUMEN_BLOCK));

    }
}