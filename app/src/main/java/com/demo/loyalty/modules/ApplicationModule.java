package com.demo.loyalty.modules;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;

public class ApplicationModule {
    private static Application sApplication;

    public static void setApplication(Application application) {
        sApplication = application;
    }

    public static Application application() {
        return sApplication;
    }

    public static Context applicationContext() {
        return sApplication;
    }

    public static Resources resources() {
        return sApplication.getResources();
    }

}
