package io.github.lieonlion.mcvbmo.block;

import io.github.lieonlion.mcvbmo.MoreChestVariantsBMO;
import net.minecraft.block.BlockState;
import net.minecraft.block.MapColor;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

public enum MoreChestBMOEnum {
    BLIGHTED_BALSA,
    WILLOW,
    SWAMP_CYPRESS,
    ANCIENT_OAK;

    public static final MoreChestBMOEnum[] VALUES = values();

    public Identifier getId(){
        return new Identifier(MoreChestVariantsBMO.MODID, this.name().toLowerCase() + "_chest");
    }

    public MapColor getMapColour() {
        return switch (this) {
            case BLIGHTED_BALSA -> MapColor.WHITE_GRAY;
            case WILLOW -> MapColor.PALE_YELLOW;
            case SWAMP_CYPRESS -> MapColor.TERRACOTTA_ORANGE;
            case ANCIENT_OAK -> MapColor.TERRACOTTA_BROWN;
        };
    }

    public MoreChestBMOBlockEntity getBlockEntity(BlockPos pos, BlockState state) {
        return new MoreChestBMOBlockEntity(this, pos, state);
    }
}
