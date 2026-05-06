package btw.community.xray;

import api.AddonHandler;
import api.BTWAddon;

public class XrayAddon extends BTWAddon {
    private static XrayAddon instance;

    public XrayAddon() {
        // This mod is client-only and does not need to be on the server
        this.isRequiredClientAndServer = false;
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