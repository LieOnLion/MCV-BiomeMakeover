package io.github.lieonlion.mcvbmo.block;

import io.github.lieonlion.mcvbmo.init.MoreChestBMOInit;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.ChestBlockEntity;
import net.minecraft.util.math.BlockPos;

public class MoreChestBMOBlockEntity extends ChestBlockEntity {
    private final MoreChestBMOEnum chestType;

    public MoreChestBMOBlockEntity(BlockPos pos, BlockState state) {
        this(MoreChestBMOEnum.SWAMP_CYPRESS, pos, state);
    }

    public MoreChestBMOBlockEntity(MoreChestBMOEnum chestType, BlockPos blockPos, BlockState blockState) {
        super(MoreChestBMOInit.chest_entity, blockPos, blockState);
        this.chestType = chestType;
    }

    public MoreChestBMOEnum getChestType() {return chestType;}
}