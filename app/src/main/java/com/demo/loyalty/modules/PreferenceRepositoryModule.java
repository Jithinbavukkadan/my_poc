package com.demo.loyalty.modules;

import com.demo.data.repo.PreferenceRepo;
import com.demo.data.repo.PreferenceRepoImpl;

public class PreferenceRepositoryModule {
    private static PreferenceRepo sPreferenceRepo;

    public static PreferenceRepo preferenceRepo() {
        if (sPreferenceRepo == null) {
            sPreferenceRepo = new PreferenceRepoImpl(ApplicationModule.applicationContext());
        }
        return sPreferenceRepo;
    }
}
