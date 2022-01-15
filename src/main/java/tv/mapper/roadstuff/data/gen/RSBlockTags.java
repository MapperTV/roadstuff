package tv.mapper.roadstuff.data.gen;

import java.util.Arrays;

import net.minecraft.data.DataGenerator;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fmllegacy.RegistryObject;
import tv.mapper.mapperbase.data.BaseTags;
import tv.mapper.mapperbase.data.gen.BaseBlockTags;
import tv.mapper.roadstuff.data.RSTags;
import tv.mapper.roadstuff.world.level.block.RSBlockRegistry;

public class RSBlockTags extends BaseBlockTags
{
    public RSBlockTags(DataGenerator generatorIn, String modid, ExistingFileHelper existingFileHelper)
    {
        super(generatorIn, modid, existingFileHelper);
    }

    public void addTags()
    {
        this.tag(RSTags.Blocks.ASPHALT).add(RSBlockRegistry.ASPHALT.get());
        this.tag(RSTags.Blocks.ASPHALT_ROAD).add(RSBlockRegistry.ASPHALT.get(), RSBlockRegistry.ASPHALT_SLOPE.get());

        this.tag(RSTags.Blocks.CONCRETE).add(RSBlockRegistry.CONCRETE.get());
        this.tag(RSTags.Blocks.CONCRETE_ROAD).add(RSBlockRegistry.CONCRETE.get(), RSBlockRegistry.CONCRETE_SLOPE.get());

        this.tag(BlockTags.STAIRS).add(RSBlockRegistry.CONCRETE_STAIRS.get(), RSBlockRegistry.ASPHALT_STAIRS.get());
        this.tag(BlockTags.SLABS).add(RSBlockRegistry.CONCRETE_SLAB.get(), RSBlockRegistry.ASPHALT_SLAB.get());
        this.tag(BlockTags.WALLS).add(RSBlockRegistry.CONCRETE_WALL.get());
        this.tag(BlockTags.FENCES).add(RSBlockRegistry.CONCRETE_FENCE.get());
        this.tag(Tags.Blocks.FENCE_GATES).add(RSBlockRegistry.CONCRETE_FENCE_GATE.get());
        this.tag(Tags.Blocks.FENCES).add(RSBlockRegistry.CONCRETE_FENCE.get());
        this.tag(BaseTags.ForgeBlocks.PRESSURE_PLATES).add(RSBlockRegistry.CONCRETE_PRESSURE_PLATE.get(), RSBlockRegistry.ASPHALT_PRESSURE_PLATE.get());

        this.tag(RSTags.ForgeBlocks.ORES_BITUMEN).add(RSBlockRegistry.BITUMEN_ORE.get());
        this.tag(RSTags.ForgeBlocks.STORAGE_BLOCKS_BITUMEN).add(RSBlockRegistry.BITUMEN_BLOCK.get());
        this.tag(Tags.Blocks.ORES).add(RSBlockRegistry.BITUMEN_ORE.get());
        this.tag(Tags.Blocks.STORAGE_BLOCKS).add(RSBlockRegistry.BITUMEN_BLOCK.get());

        for(RegistryObject<Block> block : RSBlockRegistry.MOD_PAINTABLEBLOCKS)
        {
            String[] raw = block.get().getDescriptionId().split("_");

            if(raw[0].contains("asphalt"))
            {
                this.tag(RSTags.Blocks.ASPHALT).add(block.get());
                this.tag(RSTags.Blocks.ASPHALT_ROAD).add(block.get());
            }
            else
            {
                this.tag(RSTags.Blocks.CONCRETE).add(block.get());
                this.tag(RSTags.Blocks.CONCRETE_ROAD).add(block.get());
            }
        }

        for(int i = 0; i < Arrays.stream(DyeColor.values()).count(); i++)
        {
            this.tag(RSTags.Blocks.REFLECTORS).add(RSBlockRegistry.REFLECTOR_BLOCKS.get(DyeColor.byId(i)).get());
            this.tag(RSTags.Blocks.REFLECTORS).add(RSBlockRegistry.LUMINESCENT_REFLECTOR_BLOCKS.get(DyeColor.byId(i)).get());
        }

        // Tool system
        registerToolTags(RSBlockRegistry.BLOCKS);

    }
}