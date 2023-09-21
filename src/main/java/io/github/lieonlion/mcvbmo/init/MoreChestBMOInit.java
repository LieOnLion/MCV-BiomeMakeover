package io.github.lieonlion.mcvbmo.init;

import io.github.lieonlion.mcvbmo.MoreChestVariantsBMO;
import io.github.lieonlion.mcvbmo.blocks.MoreChestBMOBlock;
import io.github.lieonlion.mcvbmo.blocks.MoreChestBMOEnum;
import io.github.lieonlion.mcvbmo.blocks.MoreChestBMOBlockEntity;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.Arrays;

public class MoreChestBMOInit {
    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MoreChestVariantsBMO.MODID);
    private static final DeferredRegister<BlockEntityType<?>> TILE_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, MoreChestVariantsBMO.MODID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MoreChestVariantsBMO.MODID);

    public static RegistryObject<MoreChestBMOBlock>[] chests = new RegistryObject[MoreChestBMOEnum.VALUES.length];
    public static RegistryObject<BlockEntityType<MoreChestBMOBlockEntity>> chest_entity;

    public static void register() {
        for (MoreChestBMOEnum type : MoreChestBMOEnum.VALUES) {
            RegistryObject<MoreChestBMOBlock> chest_block = BLOCKS.register(type.getId(), () -> new MoreChestBMOBlock(type, type.getMapColour()));
            chests[type.ordinal()] = chest_block;

            ITEMS.register(type.getId(), () -> new BlockItem(chest_block.get(), new Item.Properties()));
        }

        chest_entity = TILE_ENTITIES.register(MoreChestVariantsBMO.MODID + ":chest_tile", () -> BlockEntityType.Builder.of(MoreChestBMOBlockEntity::new, Arrays.stream(chests).map(RegistryObject::get).toArray(Block[]::new)).build(null));

        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        TILE_ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
