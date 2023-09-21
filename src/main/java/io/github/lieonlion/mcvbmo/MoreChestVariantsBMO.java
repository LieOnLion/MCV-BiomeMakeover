package io.github.lieonlion.mcvbmo;

import io.github.lieonlion.mcvbmo.init.MoreChestBMOInit;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.RegistryObject;

@Mod(MoreChestVariantsBMO.MODID)
public class MoreChestVariantsBMO {
    public static final String MODID = "lolmcvbmo";

    /*
        most code for this mod is taken from DoctorFTB's Stone Chest
        Copyright (c) 2018
     */

    public MoreChestVariantsBMO() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        MoreChestBMOInit.register();

        modEventBus.addListener((BuildCreativeModeTabContentsEvent event) -> {
            if (event.getTabKey() == CreativeModeTabs.FUNCTIONAL_BLOCKS || event.getTabKey() == CreativeModeTabs.REDSTONE_BLOCKS) {
                MoreChestBMOInit.ITEMS.getEntries().stream().map(RegistryObject::get).forEach(event::accept);
            }
        });

        MinecraftForge.EVENT_BUS.register(this);
    }
}