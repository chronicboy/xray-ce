package btw.community.xray.mixin;

import btw.community.xray.XrayMod;
import net.minecraft.src.EntityRenderer;
import net.minecraft.src.WorldClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EntityRenderer.class)
public class EntityRendererMixin {
    @Shadow
    private int[] lightmapColors;

    @Inject(method = "updateLightmap", at = @At("RETURN"))
    private void xrayFullbright(float par1, CallbackInfo ci) {
        if (XrayMod.enabled) {
            fullbright();
        }
    }
    
    @Inject(method = "modUpdateLightmap", at = @At("RETURN"), remap = false, require = 0)
    private void xrayFullbrightMod(float fPartialTicks, CallbackInfo ci) {
        if (XrayMod.enabled) {
            fullbright();
        }
    }

    @Inject(method = "modUpdateLightmapOverworld", at = @At("RETURN"), remap = false, require = 0)
    private void xrayFullbrightModOverworld(WorldClient world, float fPartialTicks, CallbackInfo ci) {
        if (XrayMod.enabled) {
            fullbright();
        }
    }

    private void fullbright() {
        for (int i = 0; i < lightmapColors.length; i++) {
            lightmapColors[i] = 0xFFFFFFFF;
        }
    }
}
