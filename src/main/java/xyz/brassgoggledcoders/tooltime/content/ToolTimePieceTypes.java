package xyz.brassgoggledcoders.tooltime.content;

import com.google.common.base.Suppliers;
import com.sun.jna.platform.win32.WinBase;
import com.tterrag.registrate.Registrate;
import com.tterrag.registrate.util.entry.RegistryEntry;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraftforge.registries.ForgeRegistry;
import net.minecraftforge.registries.RegistryBuilder;
import net.minecraftforge.registries.RegistryManager;
import xyz.brassgoggledcoders.tooltime.ToolTime;
import xyz.brassgoggledcoders.tooltime.api.PieceType;

import java.util.function.Supplier;

@SuppressWarnings("UnstableApiUsage")
public class ToolTimePieceTypes {
    public static ResourceKey<Registry<PieceType>> PIECE_TYPE_KEY = ToolTime.getRegistrate()
            .makeRegistry("piece_type", RegistryBuilder::new);

    public static RegistryEntry<PieceType> HILT_TYPE = ToolTime.getRegistrate()
            .object("hilt")
            .simple(PIECE_TYPE_KEY, PieceType::new);

    public static RegistryEntry<PieceType> BLADE_TYPE = ToolTime.getRegistrate()
            .object("blade")
            .simple(PIECE_TYPE_KEY, PieceType::new);

    private static final Supplier<ForgeRegistry<PieceType>> PIECE_TYPE_REGISTRY = Suppliers.memoize(
            () -> RegistryManager.ACTIVE.getRegistry(PIECE_TYPE_KEY)
    );

    public static ForgeRegistry<PieceType> getRegistry() {
        return PIECE_TYPE_REGISTRY.get();
    }

    public static void setup() {

    }
}
