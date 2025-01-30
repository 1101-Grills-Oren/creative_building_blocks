package code.creative_building_blocks;

import net.fabricmc.api.ModInitializer;
import code.creative_building_blocks.item.custom.end_gateway_placer;

public class Initialise implements ModInitializer {
   public static final String MOD_ID = "creativebuildingblocks";

   public void onInitialize() {ModRegistries.registerOxidizableBlocks();
   }
}
