package tv.mapper.roadstuff.init;

import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;
import tv.mapper.roadstuff.RoadStuff;
import tv.mapper.roadstuff.tileentity.SignWorkshopTileEntity;

@ObjectHolder(RoadStuff.MODID)
@EventBusSubscriber(bus = Bus.MOD)
public class ModTileEntityType
{
    public static final TileEntityType<SignWorkshopTileEntity> SIGN_WORKSHOP = null;
    
    @SubscribeEvent
    public static void registerTileEntities(final RegistryEvent.Register<TileEntityType<?>> event)
    {
        event.getRegistry().register(TileEntityType.Builder.create(SignWorkshopTileEntity::new, ModBlocks.SIGN_WORKSHOP).build(null).setRegistryName("sign_workshop"));
    }
}
