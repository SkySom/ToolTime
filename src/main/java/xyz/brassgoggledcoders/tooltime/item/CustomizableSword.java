package xyz.brassgoggledcoders.tooltime.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Vanishable;
import org.jetbrains.annotations.NotNull;
import xyz.brassgoggledcoders.tooltime.api.ICustomizable;
import xyz.brassgoggledcoders.tooltime.api.IPiece;
import xyz.brassgoggledcoders.tooltime.content.ToolTimeItems;
import xyz.brassgoggledcoders.tooltime.piece.BladePiece;
import xyz.brassgoggledcoders.tooltime.piece.HiltPiece;

import java.util.Collection;
import java.util.List;

public class CustomizableSword extends Item implements Vanishable, ICustomizable {
    public CustomizableSword(Item.Properties pProperties) {
        super(pProperties);
    }

    @Override
    public boolean isValidRepairItem(@NotNull ItemStack toRepair, @NotNull ItemStack repairing) {
        return this.getPieces(toRepair)
                .stream()
                .anyMatch(piece -> piece.isValidRepairItem(toRepair, repairing));
    }

    @Override
    public Collection<IPiece> getPieces(ItemStack itemStack) {
        return List.of(
                new BladePiece(ToolTimeItems.IRON_BLADE.get()),
                new HiltPiece(ToolTimeItems.DIAMOND_HILT.get())
        );
    }
}
