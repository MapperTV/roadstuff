package tv.mapper.roadstuff.data.gen;

import java.util.Arrays;

import net.minecraft.advancements.criterion.StatePropertiesPredicate;
import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraft.item.DyeColor;
import net.minecraft.loot.ConstantRange;
import net.minecraft.loot.ItemLootEntry;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.conditions.BlockStateProperty;
import net.minecraft.loot.conditions.SurvivesExplosion;
import net.minecraft.loot.functions.SetCount;
import net.minecraftforge.fml.RegistryObject;
import tv.mapper.mapperbase.block.BaseBlocks;
import tv.mapper.mapperbase.block.PaintableBlock;
import tv.mapper.mapperbase.data.gen.BaseLootTableProvider;
import tv.mapper.roadstuff.RoadStuff;
import tv.mapper.roadstuff.block.RSBlockRegistry;
import tv.mapper.roadstuff.block.RotatableSlopeBlock;
import tv.mapper.roadstuff.block.SlopeBlock;

public class RSLootTables extends BaseLootTableProvider
{
    public RSLootTables(DataGenerator dataGeneratorIn)
    {
        super(dataGeneratorIn);
    }

    @Override
    protected void addTables()
    {
        lootTables.put(RSBlockRegistry.ASPHALT_SLOPE.get(), createSlopeTable(RoadStuff.MODID, RSBlockRegistry.ASPHALT_SLOPE.get(), RSBlockRegistry.ASPHALT_SLOPE.get().getMaterialType()));
        lootTables.put(RSBlockRegistry.CONCRETE_SLOPE.get(), createSlopeTable(RoadStuff.MODID, RSBlockRegistry.CONCRETE_SLOPE.get(), RSBlockRegistry.CONCRETE_SLOPE.get().getMaterialType()));

        for(RegistryObject<PaintableBlock> object : RSBlockRegistry.MOD_PAINTABLEBLOCKS)
        {
            Block block = object.get();

            if(block instanceof RotatableSlopeBlock)
                lootTables.put(block, createSlopeTable(RoadStuff.MODID, block, ((RotatableSlopeBlock)block).getMaterialType()));
            else
                lootTables.put(block, createRoadBlockTable(RoadStuff.MODID, block, ((PaintableBlock)block).getMaterialType()));
        }

        for(int i = 0; i < Arrays.stream(DyeColor.values()).count(); i++)
        {
            lootTables.put(RSBlockRegistry.TRAFFIC_CONE_BLOCKS.get(DyeColor.byId(i)).get(), createStandardTable(RoadStuff.MODID, RSBlockRegistry.TRAFFIC_CONE_BLOCKS.get(DyeColor.byId(i)).get()));
            lootTables.put(RSBlockRegistry.TRAFFIC_BARREL_BLOCKS.get(DyeColor.byId(i)).get(), createStandardTable(RoadStuff.MODID, RSBlockRegistry.TRAFFIC_BARREL_BLOCKS.get(DyeColor.byId(i)).get()));
            lootTables.put(RSBlockRegistry.TRAFFIC_BOLLARD_BLOCKS.get(DyeColor.byId(i)).get(), createStandardTable(RoadStuff.MODID, RSBlockRegistry.TRAFFIC_BOLLARD_BLOCKS.get(DyeColor.byId(i)).get()));
            lootTables.put(RSBlockRegistry.CYLINDRICAL_BOLLARD_BLOCKS.get(DyeColor.byId(i)).get(), createStandardTable(RoadStuff.MODID, RSBlockRegistry.CYLINDRICAL_BOLLARD_BLOCKS.get(DyeColor.byId(i)).get()));
            lootTables.put(RSBlockRegistry.REFLECTOR_BLOCKS.get(DyeColor.byId(i)).get(), createStandardTable(RoadStuff.MODID, RSBlockRegistry.REFLECTOR_BLOCKS.get(DyeColor.byId(i)).get()));
            lootTables.put(RSBlockRegistry.LUMINESCENT_REFLECTOR_BLOCKS.get(DyeColor.byId(i)).get(),
                createStandardTable(RoadStuff.MODID, RSBlockRegistry.LUMINESCENT_REFLECTOR_BLOCKS.get(DyeColor.byId(i)).get()));
            lootTables.put(RSBlockRegistry.GUARDRAIL_BLOCKS.get(DyeColor.byId(i)).get(), createStandardTable(RoadStuff.MODID, RSBlockRegistry.GUARDRAIL_BLOCKS.get(DyeColor.byId(i)).get()));
        }

        lootTables.put(RSBlockRegistry.STEEL_GUARDRAIL.get(), createStandardTable(RoadStuff.MODID, RSBlockRegistry.STEEL_GUARDRAIL.get()));

        lootTables.put(RSBlockRegistry.YELLOW_BOLLARD.get(), createStandardTable(RoadStuff.MODID, RSBlockRegistry.YELLOW_BOLLARD.get()));
        lootTables.put(RSBlockRegistry.WHITE_BOLLARD.get(), createStandardTable(RoadStuff.MODID, RSBlockRegistry.WHITE_BOLLARD.get()));
        lootTables.put(RSBlockRegistry.RED_BOLLARD.get(), createStandardTable(RoadStuff.MODID, RSBlockRegistry.RED_BOLLARD.get()));
        lootTables.put(RSBlockRegistry.YELLOW_SMALL_BOLLARD.get(), createStandardTable(RoadStuff.MODID, RSBlockRegistry.YELLOW_SMALL_BOLLARD.get()));
        lootTables.put(RSBlockRegistry.WHITE_SMALL_BOLLARD.get(), createStandardTable(RoadStuff.MODID, RSBlockRegistry.WHITE_SMALL_BOLLARD.get()));
        lootTables.put(RSBlockRegistry.RED_SMALL_BOLLARD.get(), createStandardTable(RoadStuff.MODID, RSBlockRegistry.RED_SMALL_BOLLARD.get()));
    }

    protected LootTable.Builder createRoadBlockTable(String modid, Block block, int mat)
    {
        Block drop;
        if(mat == 0)
            drop = BaseBlocks.ASPHALT.get();
        else
            drop = BaseBlocks.CONCRETE.get();

        String name = block.getRegistryName().toString().replace(modid + ":", "");
        LootPool.Builder builder = LootPool.builder().name(name).rolls(ConstantRange.of(1)).addEntry(ItemLootEntry.builder(drop)).acceptCondition(SurvivesExplosion.builder());
        return LootTable.builder().addLootPool(builder);
    }

    protected LootTable.Builder createSlopeTable(String modid, Block block, int mat)
    {
        String name = block.getRegistryName().toString().replace(modid + ":", "");
        Block drop;

        if(mat == 0)
            drop = RSBlockRegistry.ASPHALT_SLOPE.get();
        else
            drop = RSBlockRegistry.CONCRETE_SLOPE.get();

        LootPool.Builder builder = LootPool.builder().name(name).rolls(ConstantRange.of(1)).addEntry(withExplosionDecay(block,
            ItemLootEntry.builder(drop).acceptFunction(SetCount.builder(ConstantRange.of(2)).acceptCondition(
                BlockStateProperty.builder(block).fromProperties(StatePropertiesPredicate.Builder.newBuilder().withIntProp(SlopeBlock.LAYERS, 2)))).acceptFunction(
                    SetCount.builder(ConstantRange.of(3)).acceptCondition(
                        BlockStateProperty.builder(block).fromProperties(StatePropertiesPredicate.Builder.newBuilder().withIntProp(SlopeBlock.LAYERS, 3)))).acceptFunction(
                            SetCount.builder(ConstantRange.of(4)).acceptCondition(
                                BlockStateProperty.builder(block).fromProperties(StatePropertiesPredicate.Builder.newBuilder().withIntProp(SlopeBlock.LAYERS, 4))))));
        return LootTable.builder().addLootPool(builder);
    }
}