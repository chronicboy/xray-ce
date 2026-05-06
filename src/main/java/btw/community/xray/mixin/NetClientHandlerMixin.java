package btw.community.xray.mixin;

import btw.community.xray.XrayMod;
import net.minecraft.src.NetClientHandler;
import net.minecraft.src.Packet250CustomPayload;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(NetClientHandler.class)
public class NetClientHandlerMixin {
    
    @Inject(method = "<init>", at = @At("RETURN"))
    private void resetAuthOnConnect(CallbackInfo ci) {
        XrayMod.isAuthorized = false;
        XrayMod.enabled = false;
        
        // In Singleplayer (Integrated Server), we are always authorized
        // We check this in a tick handler or here if possible
    }

    @Inject(method = "handleCustomPayload", at = @At("HEAD"), cancellable = true)
    private void handleXrayAuth(Packet250CustomPayload packet, CallbackInfo ci) {
        if ("XRAY|ACK".equals(packet.channel)) {
            if (packet.data != null && packet.data.length > 0 && packet.data[0] == 1) {
                XrayMod.isAuthorized = true;
                XrayMod.LOGGER.info("Xray authorized by server.");
            }
            ci.cancel();
        }
    }
}
