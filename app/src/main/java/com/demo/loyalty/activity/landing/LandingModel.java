package com.demo.loyalty.activity.landing;

import com.demo.data.loaders.LoyaltyLoader;
import com.demo.loyalty.modules.LoaderModule;

public class LandingModel implements LandingMvpContract.Model {
    private LoyaltyLoader<String> mTransactionLoader;
    private LoyaltyLoader<String> mUserInfoLoader;

    public LandingModel() {
        this(LoaderModule.transactionsLoader(), LoaderModule.userInfoLoader());
    }

    private LandingModel(LoyaltyLoader<String> transactionLoader, LoyaltyLoader<String> userInfoLoader) {
        mTransactionLoader = transactionLoader;
        mUserInfoLoader = userInfoLoader;
    }

    @Override
    public void loadUserInfo(String employeeId) {
        mUserInfoLoader.requestData(employeeId);
    }

    @Override
    public void loadTransactions(String employeeId) {
        mTransactionLoader.requestData(employeeId);
    }
}
