package xyz.brassgoggledcoders.tooltime;

import com.google.common.base.Suppliers;
import com.mojang.logging.LogUtils;
import com.tterrag.registrate.Registrate;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;
import xyz.brassgoggledcoders.tooltime.content.ToolTimeItems;
import xyz.brassgoggledcoders.tooltime.content.ToolTimePieceTypes;

import java.util.function.Supplier;

@Mod(ToolTime.MODID)
public class ToolTime {

    public static final String MODID = "tooltime";
    public static final Logger LOGGER = LogUtils.getLogger();

    private static final Supplier<Registrate> REGISTRATE = Suppliers.memoize(() -> Registrate.create(MODID));

    public ToolTime() {
        ToolTimeItems.setup();
        ToolTimePieceTypes.setup();
    }

    public static Registrate getRegistrate() {
        return REGISTRATE.get();
    }

    public static ResourceLocation rl(String path) {
        return new ResourceLocation(MODID, path);
    }
}
