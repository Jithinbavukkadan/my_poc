package com.demo.loyalty.activity.launch;

import com.demo.data.repo.PreferenceRepo;
import com.demo.loyalty.modules.PreferenceRepositoryModule;

public class LaunchScreenPresenter implements LaunchScreenMvpContract.Presenter {
    private PreferenceRepo mPreferenceRepo;
    private LaunchScreenMvpContract.View mView;

    public LaunchScreenPresenter(LaunchScreenMvpContract.View view) {
        this(view, PreferenceRepositoryModule.preferenceRepo());
    }

    private LaunchScreenPresenter(LaunchScreenMvpContract.View view, PreferenceRepo preferenceRepo) {
        mPreferenceRepo = preferenceRepo;
        mView = view;
    }

    @Override
    public void onClickRegister() {
        mView.navigateRegister();
    }

    @Override
    public boolean isRegistered() {
        return mPreferenceRepo.getEmployeeId() != null;
    }
}
