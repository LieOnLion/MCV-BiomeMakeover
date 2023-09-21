package io.github.lieonlion.mcvbmo.blocks;

import net.minecraft.world.level.material.MapColor;

public enum MoreChestBMOEnum {
      BLIGHTED_BALSA,
      WILLOW,
      SWAMP_CYPRESS,
      ANCIENT_OAK;

      public static final MoreChestBMOEnum[] VALUES = values();

      public String getId() {
            return this.name().toLowerCase() + "_chest";
      }

      public MapColor getMapColour() {
            return switch (this) {
                  case BLIGHTED_BALSA -> MapColor.WOOL;
                  case WILLOW -> MapColor.SAND;
                  case SWAMP_CYPRESS -> MapColor.TERRACOTTA_ORANGE;
                  case ANCIENT_OAK -> MapColor.TERRACOTTA_BROWN;
            };
      }
}