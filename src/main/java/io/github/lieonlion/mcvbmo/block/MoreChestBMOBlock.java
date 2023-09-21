package io.github.lieonlion.mcvbmo.block;

import io.github.lieonlion.mcvbmo.init.MoreChestBMOInit;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;

public class MoreChestBMOBlock extends ChestBlock {
    public final MoreChestBMOEnum chestType;

    public MoreChestBMOBlock(MoreChestBMOEnum chestType) {
        super(Settings.copy(Blocks.CHEST).mapColor(chestType.getMapColour()), () -> MoreChestBMOInit.chest_entity);
        this.chestType = chestType;
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return this.chestType.getBlockEntity(pos, state);
    }

    public MoreChestBMOEnum getType(){return chestType;}
}
