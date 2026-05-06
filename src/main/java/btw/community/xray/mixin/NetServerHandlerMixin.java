package btw.community.xray.mixin;

import btw.community.xray.XrayMod;
import net.minecraft.src.EntityPlayerMP;
import net.minecraft.src.NetServerHandler;
import net.minecraft.src.Packet250CustomPayload;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(NetServerHandler.class)
public class NetServerHandlerMixin {
    @Shadow
    public EntityPlayerMP playerEntity;

    @Inject(method = "<init>", at = @At("RETURN"))
    private void sendXrayAuthOnJoin(CallbackInfo ci) {
        // Send a custom payload packet to the client to authorize Xray
        // This only runs if the mod is installed on the server
        Packet250CustomPayload packet = new Packet250CustomPayload();
        packet.channel = "XRAY|ACK";
        packet.data = new byte[]{1}; // 1 = Authorized
        packet.length = packet.data.length;
        
        this.playerEntity.playerNetServerHandler.sendPacketToPlayer(packet);
        XrayMod.LOGGER.info("Sent Xray authorization to " + this.playerEntity.username);
    }
}
