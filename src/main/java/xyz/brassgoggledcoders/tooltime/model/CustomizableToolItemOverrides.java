package xyz.brassgoggledcoders.tooltime.model;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.block.model.ItemOverrides;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import xyz.brassgoggledcoders.tooltime.ToolTime;
import xyz.brassgoggledcoders.tooltime.api.ICustomizable;
import xyz.brassgoggledcoders.tooltime.api.IPiece;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class CustomizableToolItemOverrides extends ItemOverrides {
    private final Cache<Integer, CustomizableToolChildBakedGeometry> cache;

    public CustomizableToolItemOverrides() {
        this.cache = CacheBuilder.newBuilder()
                .expireAfterWrite(Duration.of(5, ChronoUnit.MINUTES))
                .build();
    }

    @Override
    @Nullable
    @ParametersAreNonnullByDefault
    public BakedModel resolve(BakedModel pModel, ItemStack pStack, @Nullable ClientLevel pLevel, @Nullable LivingEntity pEntity, int pSeed) {
        if (pStack.getItem() instanceof ICustomizable customizable) {
            Collection<IPiece> pieces = customizable.getPieces(pStack);
            try {
                return cache.get(pieces.size(), () -> {
                    List<BakedModel> pieceBakedModels = new ArrayList<>(pieces.size());
                    for (IPiece iPiece : pieces) {
                        pieceBakedModels.add(Minecraft.getInstance().getItemRenderer().getModel(
                                new ItemStack(iPiece.asItem()),
                                pLevel,
                                pEntity,
                                pSeed
                        ));
                    }
                    return new CustomizableToolChildBakedGeometry(pieceBakedModels);
                });
            } catch (ExecutionException e) {
                ToolTime.LOGGER.error("FAILED TO CREATE GEOMETRY FOR MODEL",e);
            }
        }
        return pModel;
    }
}
