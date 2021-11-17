package tv.mapper.roadstuff.proxy;

import java.util.function.Predicate;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fmllegacy.RegistryObject;
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

        Predicate<RenderType> cutoutPredicate = renderType -> renderType == RenderType.cutout();

        for(RegistryObject<PaintableBlock> block : RSBlockRegistry.MOD_PAINTABLEBLOCKS)
        {
            ItemBlockRenderTypes.setRenderLayer(block.get(), cutoutPredicate);
        }

        ItemBlockRenderTypes.setRenderLayer(RSBlockRegistry.PAINT_BUCKET.get(), cutoutPredicate);

        ItemProperties.register(RSItemRegistry.PAINT_BUCKET_ITEM.get(), new ResourceLocation("color"), (itemStack, world, entity, id) ->
        {
            if(itemStack.hasTag())
            {
                CompoundTag nbt = itemStack.getTag();
                if(nbt.getInt("paint") == 0)
                    return 0.0f;
                else if(nbt.getInt("color") == 0)
                    return 0.5f;
                else if(nbt.getInt("color") == 1)
                    return 1.0f;
            }
            return 0.0f;
        });

        ItemProperties.register(RSItemRegistry.PAINT_BRUSH.get(), new ResourceLocation("color"), (itemStack, world, entity, id) ->
        {
            CompoundTag nbt = BrushItem.checkNBT(itemStack);
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