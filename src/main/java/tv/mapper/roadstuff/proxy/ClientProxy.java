package tv.mapper.roadstuff.proxy;

import java.util.function.Predicate;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.registries.RegistryObject;
import tv.mapper.roadstuff.util.ModColorHandler;
import tv.mapper.roadstuff.world.item.BrushItem;
import tv.mapper.roadstuff.world.item.RSItemRegistry;
import tv.mapper.roadstuff.world.level.block.RSBlockRegistry;

public class ClientProxy implements IProxy
{
    @Override
    public void setup(FMLCommonSetupEvent event)
    {
        ModColorHandler.registerBlockColor();

        Predicate<RenderType> cutoutPredicate = renderType -> renderType == RenderType.cutout();

        for(RegistryObject<Block> block : RSBlockRegistry.MOD_PAINTABLEBLOCKS)
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

        for(RegistryObject<Item> item : RSItemRegistry.MOD_PAINTBRUSHES)
        {
            ItemProperties.register(item.get(), new ResourceLocation("color"), (itemStack, world, entity, id) ->
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
}