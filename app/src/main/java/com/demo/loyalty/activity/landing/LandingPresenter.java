package com.demo.loyalty.activity.landing;

import com.demo.data.events.TransactionsFailureEvent;
import com.demo.data.events.TransactionsSuccessEvent;
import com.demo.data.events.UserInfoFailureEvent;
import com.demo.data.events.UserInfoSuccessEvent;
import com.demo.data.repo.PreferenceRepo;
import com.demo.loyalty.modules.PreferenceRepositoryModule;

import org.greenrobot.eventbus.Subscribe;

public class LandingPresenter implements LandingMvpContract.Presenter {
    LandingMvpContract.Model mModel;
    LandingMvpContract.View mView;
    PreferenceRepo mPreferenceRepo;

    public LandingPresenter(LandingMvpContract.View view) {
        this(new LandingModel(), view, PreferenceRepositoryModule.preferenceRepo());
    }

    private LandingPresenter(LandingMvpContract.Model model, LandingMvpContract.View view, PreferenceRepo preferenceRepo) {
        mModel = model;
        mView = view;
        mPreferenceRepo = preferenceRepo;
    }

    @Override
    @Subscribe
    public void onUserInfoSuccessEvent(UserInfoSuccessEvent event) {
        mView.updateUserDetails(event.getEntity());
    }

    @Override
    @Subscribe
    public void onUserInfoFailuresEvent(UserInfoFailureEvent event) {
        mView.showError(event.getApiError());
    }

    @Override
    @Subscribe
    public void onTransactionsSuccessEvent(TransactionsSuccessEvent event) {
        mView.updateTransactions(event.getResponse().getEntities());
    }

    @Override
    @Subscribe
    public void onTransactionsFailuresEvent(TransactionsFailureEvent event) {
        mView.showError(event.getApiError());
    }

    @Override
    public void loadUserInfo() {
        mModel.loadUserInfo(mPreferenceRepo.getEmployeeId());
    }

    @Override
    public void loadTransactions() {
        mModel.loadTransactions(mPreferenceRepo.getEmployeeId());
    }
}
