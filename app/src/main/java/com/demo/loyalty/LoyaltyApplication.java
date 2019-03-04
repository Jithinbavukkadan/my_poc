package com.demo.loyalty;

import com.demo.loyalty.modules.ApplicationModule;

import android.app.Application;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

public class LoyaltyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/Roboto-RobotoRegular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build());
        ApplicationModule.setApplication(this);
    }
}
