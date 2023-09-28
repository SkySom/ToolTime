package xyz.brassgoggledcoders.tooltime.api;

import net.minecraft.Util;
import net.minecraft.core.Registry;
import net.minecraft.network.chat.Component;
import xyz.brassgoggledcoders.tooltime.content.ToolTimePieceTypes;

import javax.annotation.Nullable;

public class PieceType {
    @Nullable
    private String descriptionId;

    public Component getDescription() {
        return Component.translatable(this.getDescriptionId());
    }

    protected String getOrCreateDescriptionId() {
        if (this.descriptionId == null) {
            this.descriptionId = Util.makeDescriptionId("piece_type", ToolTimePieceTypes.getRegistry().getKey(this));
        }

        return this.descriptionId;
    }

    public String getDescriptionId() {
        return this.getOrCreateDescriptionId();
    }
}
