package btw.community.xray.mixin;

import btw.community.xray.XrayMod;
import net.minecraft.src.Block;
import net.minecraft.src.RenderBlocks;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(RenderBlocks.class)
public class RenderBlocksMixin {
    @Inject(method = "renderBlockByRenderType", at = @At("HEAD"), cancellable = true)
    private void xrayFilter(Block block, int x, int y, int z, CallbackInfoReturnable<Boolean> cir) {
        if (XrayMod.enabled) {
            // Optimized O(1) lookup
            if (XrayMod.blockBlacklist[block.blockID]) {
                cir.setReturnValue(false);
            }
        }
    }
}
