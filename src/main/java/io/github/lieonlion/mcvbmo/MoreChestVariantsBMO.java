package io.github.lieonlion.mcvbmo;

import io.github.lieonlion.mcvbmo.init.MoreChestBMOInit;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.CommonLifecycleEvents;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class MoreChestVariantsBMO implements ModInitializer {
    public static final String MODID = "lolmcvbmo";

    @Override
    public void onInitialize() {
        MoreChestBMOInit.register();
    }
}