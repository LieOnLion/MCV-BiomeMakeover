package io.github.lieonlion.mcvbmo.client;

import io.github.lieonlion.mcvbmo.init.MoreChestBMOInit;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;

@Environment(EnvType.CLIENT)
public class MoreChestVariantsBMOClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockEntityRendererRegistry.register(MoreChestBMOInit.chest_entity, MoreChestBMORenderer::new);
    }
}