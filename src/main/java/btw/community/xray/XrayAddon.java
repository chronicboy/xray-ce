package btw.community.xray;

import api.AddonHandler;
import api.BTWAddon;

public class XrayAddon extends BTWAddon {
    private static XrayAddon instance;

    public XrayAddon() {
        // Enforce that this mod must be present on both client and server
        this.isRequiredClientAndServer = true;
    }

    @Override
    public void initialize() {
        AddonHandler.logMessage(this.getName() + " Version " + this.getVersionString() + " Initializing...");
        XrayMod.initFilter();
    }

    public static XrayAddon getInstance() {
        if (instance == null)
            instance = new XrayAddon();
        return instance;
    }
}