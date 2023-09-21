package io.github.lieonlion.mcvbmo.blocks;

import io.github.lieonlion.mcvbmo.init.MoreChestBMOInit;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.ChestBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class MoreChestBMOBlockEntity extends ChestBlockEntity {
    private MoreChestBMOEnum chestType;

    public MoreChestBMOBlockEntity(BlockPos pos, BlockState state) {
        this(MoreChestBMOEnum.BLIGHTED_BALSA, pos, state);
    }

    public MoreChestBMOBlockEntity(MoreChestBMOEnum chestType, BlockPos pos, BlockState state) {
        super(MoreChestBMOInit.chest_entity.get(), pos, state);
        this.chestType = chestType;
    }

    public MoreChestBMOEnum getChestType() {
        return chestType;
    }
}
