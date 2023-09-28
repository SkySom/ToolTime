package xyz.brassgoggledcoders.tooltime.api;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import org.jetbrains.annotations.NotNull;

public interface IPiece extends ItemLike {
    void applyAttributes(@NotNull ItemStack itemStack);

    @NotNull
    PieceType getType();

    default boolean isValidRepairItem(ItemStack toRepair, ItemStack repairing) {
        return false;
    }
}
