package xyz.brassgoggledcoders.tooltime.model;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.model.generators.CustomLoaderBuilder;
import net.minecraftforge.client.model.generators.ModelBuilder;
import net.minecraftforge.client.model.geometry.IGeometryLoader;
import net.minecraftforge.common.data.ExistingFileHelper;
import xyz.brassgoggledcoders.tooltime.ToolTime;

public class CustomizableToolGeometryLoader implements IGeometryLoader<CustomizableToolUnbakedGeometry> {
    public static ResourceLocation ID = ToolTime.rl("customizable_tool");
    @Override
    public CustomizableToolUnbakedGeometry read(JsonObject jsonObject, JsonDeserializationContext deserializationContext) throws JsonParseException {
        return new CustomizableToolUnbakedGeometry();
    }

    public static <T extends ModelBuilder<T>> CustomLoaderBuilder<T> builder(T parent, ExistingFileHelper existingFileHelper) {
        return new CustomLoaderBuilder<>(ID, parent, existingFileHelper) {
        };
    }
}
