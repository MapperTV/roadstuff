package tv.mapper.roadstuff.proxy;

import java.util.function.Predicate;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.item.ItemModelsProperties;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import tv.mapper.mapperbase.block.PaintableBlock;
import tv.mapper.roadstuff.block.RSBlockRegistry;
import tv.mapper.roadstuff.item.BrushItem;
import tv.mapper.roadstuff.item.RSItemRegistry;
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

        ItemModelsProperties.func_239418_a_(RSItemRegistry.PAINT_BUCKET_ITEM.get(), new ResourceLocation("color"), (itemStack, world, entity) ->
        {
            if(itemStack.hasTag())
            {
                CompoundNBT nbt = itemStack.getTag();
                if(nbt.getInt("paint") == 0)
                    return 0.0f;
                else if(nbt.getInt("color") == 0)
                    return 0.5f;
                else if(nbt.getInt("color") == 1)
                    return 1.0f;
            }
            return 0.0f;
        });

        ItemModelsProperties.func_239418_a_(RSItemRegistry.PAINT_BRUSH.get(), new ResourceLocation("color"), (itemStack, world, entity) ->
        {
            CompoundNBT nbt = BrushItem.checkNBT(itemStack);
            if(nbt.getInt("paint") == 0)
                return 0.0f;
            else if(nbt.getInt("color") == 0)
                return 0.5f;
            else if(nbt.getInt("color") == 1)
                return 1.0f;
            return 0.0f;
        });
    }
}