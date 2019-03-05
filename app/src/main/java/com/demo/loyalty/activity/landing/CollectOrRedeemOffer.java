package com.demo.loyalty.activity.landing;

import com.demo.data.loaders.LoyaltyLoader;
import com.demo.loyalty.modules.LoaderModule;

public class CollectOrRedeemOffer {
    private LoyaltyLoader<String> collectLoader;
    private LoyaltyLoader<String> redeemLoader;

    public CollectOrRedeemOffer() {
        this(LoaderModule.collectsLoader(), LoaderModule.redeeemLoader());
    }

    private CollectOrRedeemOffer(LoyaltyLoader<String> collectLoader, LoyaltyLoader<String> redeemLoader) {
        this.collectLoader = collectLoader;
        this.redeemLoader = redeemLoader;
    }

    public void collect(String employeeId) {
        collectLoader.requestData(employeeId);
    }

    public void redeem(String employeeId) {
        redeemLoader.requestData(employeeId);
    }
}
