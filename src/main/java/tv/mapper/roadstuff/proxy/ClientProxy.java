package tv.mapper.roadstuff.proxy;

import java.util.function.Predicate;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import tv.mapper.mapperbase.block.PaintableBlock;
import tv.mapper.roadstuff.block.RSBlockRegistry;
import tv.mapper.roadstuff.util.ModColorHandler;

public class ClientProxy implements IProxy
{
    @Override
    public void setup(FMLCommonSetupEvent event)
    {
        ModColorHandler.registerBlockColor();

        Predicate<RenderType> cutoutPredicate = renderType -> renderType == RenderType.getCutout();

        for(RegistryObject<PaintableBlock> block : RSBlockRegistry.MOD_PAINTABLEBLOCKS)
        {
            RenderTypeLookup.setRenderLayer(block.get(), cutoutPredicate);
        }
        
        RenderTypeLookup.setRenderLayer(RSBlockRegistry.PAINT_BUCKET.get(), cutoutPredicate);

    }
}
