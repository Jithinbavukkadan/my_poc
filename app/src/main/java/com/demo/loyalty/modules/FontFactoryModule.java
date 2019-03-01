
package com.demo.loyalty.modules;

import com.demo.loyalty.font.AssetsFontFactory;
import com.demo.loyalty.font.FontFactory;


public class FontFactoryModule {
    private static FontFactory sAssetsFontFactory;

    public static FontFactory assetsFontFactory() {
        // Added a check for the existence of the application, so that we can allow injecting this into views, and watch them in previews
        if (sAssetsFontFactory == null && ApplicationModule.application() != null) {
            sAssetsFontFactory = new AssetsFontFactory(ApplicationModule.resources());
        }
        return sAssetsFontFactory;
    }
}
