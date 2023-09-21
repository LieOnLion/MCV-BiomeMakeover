package io.github.lieonlion.mcvbmo.init;

import io.github.lieonlion.mcvbmo.MoreChestVariantsBMO;
import io.github.lieonlion.mcvbmo.block.MoreChestBMOBlock;
import io.github.lieonlion.mcvbmo.block.MoreChestBMOBlockEntity;
import io.github.lieonlion.mcvbmo.block.MoreChestBMOEnum;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import java.util.Arrays;

public class MoreChestBMOInit {
    public static MoreChestBMOBlock[] chests = new MoreChestBMOBlock[MoreChestBMOEnum.VALUES.length];
    public static BlockEntityType<MoreChestBMOBlockEntity> chest_entity;

    public static void register() {
        for (MoreChestBMOEnum type : MoreChestBMOEnum.VALUES) {
            MoreChestBMOBlock chest_block = Registry.register(Registries.BLOCK, type.getId(), new MoreChestBMOBlock(type));
            chests[type.ordinal()] = chest_block;

            Item item = Registry.register(Registries.ITEM, type.getId(), new BlockItem(chest_block, (new Item.Settings())));
            ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(entries -> entries.add(item));
            ItemGroupEvents.modifyEntriesEvent(ItemGroups.REDSTONE).register(entries -> entries.add(item));
        }

        chest_entity = Registry.register(Registries.BLOCK_ENTITY_TYPE, MoreChestVariantsBMO.MODID + ":chest_entity",
                FabricBlockEntityTypeBuilder.create(MoreChestBMOBlockEntity::new, Arrays.stream(chests).toArray(Block[]::new)).build(null));
    }
}