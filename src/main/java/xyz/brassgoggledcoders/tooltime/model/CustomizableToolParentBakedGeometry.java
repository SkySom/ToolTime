package xyz.brassgoggledcoders.tooltime.model;

import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.ItemOverrides;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collections;
import java.util.List;

public class CustomizableToolParentBakedGeometry implements BakedModel {
    @Override
    @NotNull
    public List<BakedQuad> getQuads(@Nullable BlockState pState, @Nullable Direction pDirection, @NotNull RandomSource pRandom) {
        return Collections.emptyList();
    }

    @Override
    public boolean useAmbientOcclusion() {
        return false;
    }

    @Override
    public boolean isGui3d() {
        return false;
    }

    @Override
    public boolean usesBlockLight() {
        return false;
    }

    @Override
    public boolean isCustomRenderer() {
        return false;
    }

    @Override
    @NotNull
    public TextureAtlasSprite getParticleIcon() {
        return ModelBakery.FIRE_0.sprite();
    }

    @Override
    @NotNull
    public ItemOverrides getOverrides() {
        return new CustomizableToolItemOverrides();
    }
}
