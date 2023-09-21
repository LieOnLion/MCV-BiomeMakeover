package io.github.lieonlion.mcvbmo.blocks;

import io.github.lieonlion.mcvbmo.init.MoreChestBMOInit;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ChestBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;

public class MoreChestBMOBlock extends ChestBlock {
    private final MoreChestBMOEnum chestType;

    public MoreChestBMOBlock(MoreChestBMOEnum chestType, MapColor colour) {
        super(Properties.copy(Blocks.CHEST).mapColor(colour), () -> MoreChestBMOInit.chest_entity.get());
        this.chestType = chestType;
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new MoreChestBMOBlockEntity(this.chestType, pos, state);
    }
}