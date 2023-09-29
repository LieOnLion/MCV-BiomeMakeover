package io.github.lieonlion.mcvbmo.client;

import io.github.lieonlion.mcv.client.MoreChestRenderer;
import io.github.lieonlion.mcvbmo.MoreChestVariantsBMO;
import io.github.lieonlion.mcvbmo.blocks.MoreChestBMOEnum;
import io.github.lieonlion.mcvbmo.blocks.MoreChestBMOBlockEntity;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.blockentity.ChestRenderer;
import net.minecraft.client.resources.model.Material;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.properties.ChestType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Calendar;
import java.util.Locale;

@OnlyIn(Dist.CLIENT)
public class MoreChestBMORenderer extends ChestRenderer<MoreChestBMOBlockEntity> {
    public static Material[] single = new Material[MoreChestBMOEnum.VALUES.length];
    public static Material[] left = new Material[MoreChestBMOEnum.VALUES.length];
    public static Material[] right = new Material[MoreChestBMOEnum.VALUES.length];
    private static boolean christmas;
    private static boolean starwarsday;

    static {
        for (MoreChestBMOEnum type : MoreChestBMOEnum.VALUES) {
            single[type.ordinal()] = getChestMaterial(type.name().toLowerCase(Locale.ENGLISH));
            left[type.ordinal()] = getChestMaterial(type.name().toLowerCase(Locale.ENGLISH) + "_left");
            right[type.ordinal()] = getChestMaterial(type.name().toLowerCase(Locale.ENGLISH) + "_right");
        }
    }

    public MoreChestBMORenderer(BlockEntityRendererProvider.Context context) {
        super(context);
        Calendar calendar = Calendar.getInstance();
        if (calendar.get(2) + 1 == 12 && calendar.get(5) >= 24 && calendar.get(5) <= 26) {
            christmas = true;
        }
        if (calendar.get(2) + 1 == 5 && calendar.get(5) >= 3 && calendar.get(5) <= 5) {
            starwarsday = true;
        }
    }

    @Override
    protected Material getMaterial(MoreChestBMOBlockEntity blockEntity, ChestType chestType) {
        return getChestMaterial(blockEntity, chestType);
    }

    public static Material getChestMaterial(String path) {
        return new Material(Sheets.CHEST_SHEET, new ResourceLocation(MoreChestVariantsBMO.MODID, "entity/chest/" + path));
    }

    private Material getChestMaterial(MoreChestBMOBlockEntity tile, ChestType type) {
        if (christmas) {
            return Sheets.chooseMaterial(tile, type, christmas);
        } else if (starwarsday) {
            return MoreChestRenderer.chooseMaterial(type, MoreChestRenderer.getChestMaterial("starwars_left"), MoreChestRenderer.getChestMaterial("starwars_right"), MoreChestRenderer.getChestMaterial("starwars"));
        } else {
            return MoreChestRenderer.chooseMaterial(type, left[tile.getChestType().ordinal()], right[tile.getChestType().ordinal()], single[tile.getChestType().ordinal()]);
        }
    }
}
