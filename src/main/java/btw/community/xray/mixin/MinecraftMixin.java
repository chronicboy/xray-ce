package btw.community.xray.mixin;

import btw.community.xray.XrayMod;
import net.minecraft.src.Minecraft;
import org.lwjgl.input.Keyboard;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Minecraft.class)
public class MinecraftMixin {
    private boolean wasXPressed = false;

    @Inject(method = "runTick", at = @At("HEAD"))
    private void onTick(CallbackInfo ci) {
        Minecraft mc = (Minecraft) (Object) this;
        
        if (mc.theWorld != null && mc.thePlayer != null && mc.currentScreen == null) {
            if (Keyboard.isKeyDown(Keyboard.KEY_X)) {
                if (!wasXPressed) {
                    wasXPressed = true;
                    XrayMod.enabled = !XrayMod.enabled;
                    
                    // Force re-render of all chunks
                    if (mc.renderGlobal != null) {
                        mc.renderGlobal.loadRenderers();
                    }
                }
            } else {
                wasXPressed = false;
            }
        }
    }
}
