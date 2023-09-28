package xyz.brassgoggledcoders.tooltime.model;

import net.minecraft.client.renderer.block.model.ItemOverrides;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.resources.model.Material;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelState;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.model.geometry.IGeometryBakingContext;
import net.minecraftforge.client.model.geometry.IUnbakedGeometry;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import java.util.function.Function;

public class CustomizableToolUnbakedGeometry implements IUnbakedGeometry<CustomizableToolUnbakedGeometry> {
    @Override
    public BakedModel bake(IGeometryBakingContext context, ModelBakery bakery, Function spriteGetter, ModelState modelState, ItemOverrides overrides, ResourceLocation modelLocation) {
        return new CustomizableToolParentBakedGeometry();
    }

    @Override
    public Collection<Material> getMaterials(IGeometryBakingContext context, Function modelGetter, Set missingTextureErrors) {
        return Collections.emptyList();
    }
}
