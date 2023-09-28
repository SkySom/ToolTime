package xyz.brassgoggledcoders.tooltime.event;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ModelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import xyz.brassgoggledcoders.tooltime.ToolTime;
import xyz.brassgoggledcoders.tooltime.model.CustomizableToolGeometryLoader;

@EventBusSubscriber(modid = ToolTime.MODID, value = Dist.CLIENT, bus = Bus.MOD)
public class ModClientEventHandler {

    @SubscribeEvent
    public static void registerLoader(ModelEvent.RegisterGeometryLoaders registerGeometryLoaders) {
        registerGeometryLoaders.register(
                CustomizableToolGeometryLoader.ID.getPath(),
                new CustomizableToolGeometryLoader()
        );
    }
}
