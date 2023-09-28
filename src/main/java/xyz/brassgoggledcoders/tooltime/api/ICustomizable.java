package xyz.brassgoggledcoders.tooltime.api;

import net.minecraft.world.item.ItemStack;

import java.util.Collection;

public interface ICustomizable {
    Collection<IPiece> getPieces(ItemStack itemStack);
}
