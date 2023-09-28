package xyz.brassgoggledcoders.tooltime.piece;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;
import xyz.brassgoggledcoders.tooltime.api.IPiece;
import xyz.brassgoggledcoders.tooltime.api.PieceType;
import xyz.brassgoggledcoders.tooltime.content.ToolTimePieceTypes;

public class HiltPiece implements IPiece {
    private final Item item;

    public HiltPiece(Item item) {
        this.item = item;
    }

    @Override
    public void applyAttributes(@NotNull ItemStack itemStack) {

    }

    @Override
    @NotNull
    public PieceType getType() {
        return ToolTimePieceTypes.HILT_TYPE.get();
    }

    @Override
    @NotNull
    public Item asItem() {
        return this.item;
    }
}
