package btw.community.xray.mixin;

import btw.community.xray.XrayMod;
import net.minecraft.src.EntityPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(EntityPlayer.class)
public class EntityPlayerMixin {
    @Inject(method = "getGloomLevel", at = @At("HEAD"), cancellable = true)
    private void xrayGetGloomLevel(CallbackInfoReturnable<Integer> cir) {
        if (XrayMod.enabled) {
            cir.setReturnValue(0);
        }
    }
}
