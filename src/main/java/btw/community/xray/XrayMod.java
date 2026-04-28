package btw.community.xray;

import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import net.minecraft.src.Block;

public class XrayMod implements ModInitializer {
    public static final String MOD_ID = "xray-ce";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

    public static boolean enabled = false;
    
    // O(1) lookup for block filtering in hot loops
    public static final boolean[] blockBlacklist = new boolean[4096];

    @Override
    public void onInitialize() {
        LOGGER.info("Xray CE Initialized");
    }
    
    public static void initFilter() {
        // Initialize common blocks to hide
        add(Block.stone);
        add(Block.dirt);
        add(Block.grass);
        add(Block.gravel);
        add(Block.sand);
        add(Block.bedrock);
        add(Block.netherrack);
        add(Block.slowSand);
        add(Block.whiteStone); // End stone
        
        // Hide water and lava by default for clearer view
        add(Block.waterMoving);
        add(Block.waterStill);
        add(Block.lavaMoving);
        add(Block.lavaStill);
    }
    
    private static void add(Block block) {
        if (block != null) {
            blockBlacklist[block.blockID] = true;
        }
    }
}
