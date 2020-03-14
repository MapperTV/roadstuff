package tv.mapper.roadstuff.data.gen;

import java.util.Arrays;

import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.item.DyeColor;
import net.minecraftforge.fml.RegistryObject;
import tv.mapper.mapperbase.block.BaseBlocks;
import tv.mapper.mapperbase.block.PaintableBlock;
import tv.mapper.roadstuff.block.RSBlockRegistry;
import tv.mapper.roadstuff.data.RSTags;

public class RSBlockTags extends BlockTagsProvider
{
    public RSBlockTags(DataGenerator generatorIn)
    {
        super(generatorIn);
    }

    public void registerTags()
    {
        this.getBuilder(RSTags.Blocks.ASPHALT_ROAD).add(BaseBlocks.ASPHALT.get(), RSBlockRegistry.ASPHALT_SLOPE.get());
        this.getBuilder(RSTags.Blocks.CONCRETE_ROAD).add(BaseBlocks.CONCRETE.get(), RSBlockRegistry.CONCRETE_SLOPE.get());

        for(RegistryObject<PaintableBlock> block : RSBlockRegistry.MOD_PAINTABLEBLOCKS)
        {
            String[] raw = block.get().getTranslationKey().split("_");

            if(raw[0].contains("asphalt"))
                this.getBuilder(RSTags.Blocks.ASPHALT_ROAD).add(block.get());
            else
                this.getBuilder(RSTags.Blocks.CONCRETE_ROAD).add(block.get());
        }

        for(int i = 0; i < Arrays.stream(DyeColor.values()).count(); i++)
        {
            this.getBuilder(RSTags.Blocks.REFLECTORS).add(RSBlockRegistry.REFLECTOR_BLOCKS.get(DyeColor.byId(i)).get());
        }
    }
}