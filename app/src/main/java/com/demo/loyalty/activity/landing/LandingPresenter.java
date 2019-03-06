package com.demo.loyalty.activity.landing;

import com.demo.data.events.CollectFailureEvent;
import com.demo.data.events.CollectSuccessEvent;
import com.demo.data.events.RedeemFailureEvent;
import com.demo.data.events.RedeemSuccessEvent;
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
    private CollectOrRedeemOffer mCollectOrRedeemOffer;
    private LandingMvpContract.View mView;
    private PreferenceRepo mPreferenceRepo;
    private EventBus mEventBus;

    public LandingPresenter(LandingMvpContract.View view) {
        this(new LandingModel(), view, PreferenceRepositoryModule.preferenceRepo(), EventBusModule.eventBus(), new CollectOrRedeemOffer());
    }

    private LandingPresenter(LandingMvpContract.Model model, LandingMvpContract.View view, PreferenceRepo preferenceRepo,
            EventBus eventBus, CollectOrRedeemOffer collectOrRedeemOffer) {
        mModel = model;
        mView = view;
        mPreferenceRepo = preferenceRepo;
        mEventBus = eventBus;
        mCollectOrRedeemOffer = collectOrRedeemOffer;
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
    public void loadUserInfo() {
        mModel.loadUserInfo(mPreferenceRepo.getEmployeeId());
    }

    @Override
    public void loadTransactions() {
        mView.showLoading();
        mModel.loadTransactions(mPreferenceRepo.getEmployeeId());
    }

    @Override
    public void collect(String shopName) {
        mView.showLoading();
        mCollectOrRedeemOffer.collect(mPreferenceRepo.getEmployeeId(), shopName);
    }

    @Override
    public void redeem(String shopName) {
        mView.showLoading();
        mCollectOrRedeemOffer.redeem(mPreferenceRepo.getEmployeeId(), shopName);
    }

    @Override
    public String[] processBarcodeData(String barcodeData) {
        String[] data = barcodeData.split(",");
        return data;
    }

    @Subscribe
    @Override
    public void onUserInfoSuccessEvent(UserInfoSuccessEvent event) {
        mView.updateUserDetails(event.getEntity());
    }

    @Subscribe
    @Override
    public void onUserInfoFailuresEvent(UserInfoFailureEvent event) {
        mView.showError(event.getApiError());
    }

    @Subscribe
    @Override
    public void onTransactionsSuccessEvent(TransactionsSuccessEvent event) {
        mView.hideLoading();
        mView.updateTransactions(event.getResponse());
    }

    @Subscribe
    @Override
    public void onTransactionsFailuresEvent(TransactionsFailureEvent event) {
        mView.hideLoading();
        mView.showError(event.getApiError());
    }

    @Subscribe
    @Override
    public void onCollectSuccessEvent(CollectSuccessEvent event) {
        mView.hideLoading();
        mView.updateUserDetails(event.getEntity());
        this.loadTransactions();
    }

    @Subscribe
    @Override
    public void onCollectFailuresEvent(CollectFailureEvent event) {
        mView.hideLoading();
        mView.showError(event.getApiError());
    }

    @Subscribe
    @Override
    public void onRedeemSuccessEvent(RedeemSuccessEvent event) {
        mView.hideLoading();
        mView.updateUserDetails(event.getEntity());
        this.loadTransactions();
    }

    @Subscribe
    @Override
    public void onRedeemFailuresEvent(RedeemFailureEvent event) {
        mView.hideLoading();
        mView.showError(event.getApiError());
    }

    @Override
    public void logout() {
        mPreferenceRepo.reset();
        mView.navigateToLaunchScreen();
    }
}
