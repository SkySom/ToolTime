package xyz.brassgoggledcoders.tooltime.content;

import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ModelFile;
import xyz.brassgoggledcoders.tooltime.ToolTime;
import xyz.brassgoggledcoders.tooltime.item.CustomizableSword;
import xyz.brassgoggledcoders.tooltime.model.CustomizableToolGeometryLoader;

public class ToolTimeItems {

    public static final ItemEntry<CustomizableSword> SWORD = ToolTime.getRegistrate()
            .object("sword")
            .item(CustomizableSword::new)
            .tab(() -> CreativeModeTab.TAB_TOOLS)
            .model((context, provider) -> provider.getBuilder(context.getId().getPath())
                    .parent(new ModelFile.UncheckedModelFile("item/generated"))
                    .customLoader(CustomizableToolGeometryLoader::builder)
                    .end()
            )
            .register();

    public static final ItemEntry<Item> DIAMOND_HILT = ToolTime.getRegistrate()
            .object("diamond_hilt")
            .item(Item::new)
            .tab(() -> CreativeModeTab.TAB_TOOLS)
            .register();

    public static final ItemEntry<Item> IRON_BLADE = ToolTime.getRegistrate()
            .object("iron_blade")
            .item(Item::new)
            .tab(() -> CreativeModeTab.TAB_TOOLS)
            .register();

    public static void setup() {

    }
}
