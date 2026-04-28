package btw.community.xray.mixin;

import btw.community.xray.XrayMod;
import net.minecraft.src.Block;
import net.minecraft.src.IBlockAccess;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Block.class)
public class BlockMixin {
    @Inject(method = "getMixedBrightnessForBlock", at = @At("HEAD"), cancellable = true)
    private void xrayGetBrightness(IBlockAccess blockAccess, int x, int y, int z, CallbackInfoReturnable<Integer> cir) {
        if (XrayMod.enabled) {
            cir.setReturnValue(0xF000F0); // Maximum brightness for both sky and block light
        }
    }

    @Inject(method = "shouldSideBeRendered", at = @At("HEAD"), cancellable = true)
    private void xrayShouldSideBeRendered(IBlockAccess blockAccess, int neighborX, int neighborY, int neighborZ, int side, CallbackInfoReturnable<Boolean> cir) {
        if (XrayMod.enabled) {
            cir.setReturnValue(true);
        }
    }
}
