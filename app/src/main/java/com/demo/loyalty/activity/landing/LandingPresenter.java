package com.demo.loyalty.activity.landing;

import com.demo.data.events.TransactionsFailureEvent;
import com.demo.data.events.TransactionsSuccessEvent;
import com.demo.data.events.UserInfoFailureEvent;
import com.demo.data.events.UserInfoSuccessEvent;
import com.demo.data.repo.PreferenceRepo;
import com.demo.loyalty.modules.EventBusModule;
import com.demo.loyalty.modules.PreferenceRepositoryModule;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class LandingPresenter implements LandingMvpContract.Presenter {
    private LandingMvpContract.Model mModel;
    private LandingMvpContract.View mView;
    private PreferenceRepo mPreferenceRepo;
    private EventBus mEventBus;

    public LandingPresenter(LandingMvpContract.View view) {
        this(new LandingModel(), view, PreferenceRepositoryModule.preferenceRepo(), EventBusModule.eventBus());
    }

    private LandingPresenter(LandingMvpContract.Model model, LandingMvpContract.View view, PreferenceRepo preferenceRepo,
            EventBus eventBus) {
        mModel = model;
        mView = view;
        mPreferenceRepo = preferenceRepo;
        mEventBus = eventBus;
    }
    
    @Override
    public void register() {
        mEventBus.register(this);
    }

    @Override
    public void unregister() {
        mEventBus.unregister(this);
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
