package xyz.brassgoggledcoders.tooltime.model;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.ItemOverrides;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.ChunkRenderTypeSet;
import net.minecraftforge.client.model.data.ModelData;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CustomizableToolChildBakedGeometry implements BakedModel {
    private final List<BakedModel> childrenModels;

    public CustomizableToolChildBakedGeometry(List<BakedModel> childrenModels) {
        this.childrenModels = childrenModels;
    }

    @Override
    @NotNull
    @SuppressWarnings("deprecation")
    public List<BakedQuad> getQuads(@Nullable BlockState pState, @Nullable Direction pDirection, @NotNull RandomSource pRandom) {
        List<BakedQuad> bakedQuads = new ArrayList<>();
        for (BakedModel bakedModel: childrenModels) {
            bakedQuads.addAll(bakedModel.getQuads(pState, pDirection, pRandom));
        }
        return bakedQuads;
    }

    @Override
    @NotNull
    public List<BakedQuad> getQuads(@Nullable BlockState state, @Nullable Direction side, @NotNull RandomSource rand, @NotNull ModelData data, @Nullable RenderType renderType) {
        List<BakedQuad> bakedQuads = new ArrayList<>();
        for (BakedModel bakedModel: childrenModels) {
            bakedQuads.addAll(bakedModel.getQuads(state, side, rand, data, renderType));
        }
        return bakedQuads;
    }

    @Override
    @NotNull
    public ChunkRenderTypeSet getRenderTypes(@NotNull BlockState state, @NotNull RandomSource rand, @NotNull ModelData data) {
        Set<ChunkRenderTypeSet> chunkRenderTypeSets = new HashSet<>();
        for (BakedModel bakedModel: childrenModels) {
            chunkRenderTypeSets.add(bakedModel.getRenderTypes(state, rand, data));
        }
        return ChunkRenderTypeSet.union(chunkRenderTypeSets);
    }

    @Override
    public boolean useAmbientOcclusion() {
        return this.childrenModels.stream()
                .anyMatch(BakedModel::useAmbientOcclusion);
    }

    @Override
    public boolean isGui3d() {
        return this.childrenModels.stream()
                .anyMatch(BakedModel::isGui3d);
    }

    @Override
    public boolean usesBlockLight() {
        return this.childrenModels.stream()
                .anyMatch(BakedModel::usesBlockLight);
    }

    @Override
    public boolean isCustomRenderer() {
        return this.childrenModels.stream()
                .anyMatch(BakedModel::isCustomRenderer);
    }


    @Override
    @NotNull
    @SuppressWarnings("deprecation")
    public TextureAtlasSprite getParticleIcon() {
        if (this.childrenModels.isEmpty()) {
            return ModelBakery.FIRE_0.sprite();
        } else {
            return this.childrenModels.get(0).getParticleIcon();
        }
    }

    @Override
    @NotNull
    public TextureAtlasSprite getParticleIcon(@NotNull ModelData modelData) {
        if (this.childrenModels.isEmpty()) {
            return ModelBakery.FIRE_0.sprite();
        } else {
            return this.childrenModels.get(0).getParticleIcon(modelData);
        }
    }

    @Override
    @NotNull
    public ItemOverrides getOverrides() {
        return new ItemOverrides() {};
    }
}
