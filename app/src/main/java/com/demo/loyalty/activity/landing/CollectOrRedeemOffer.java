package com.demo.loyalty.activity.landing;

import com.demo.data.loaders.LoyaltyLoader;
import com.demo.data.model.request.CollectOrRedeemRequest;
import com.demo.loyalty.modules.LoaderModule;

public class CollectOrRedeemOffer {
    private LoyaltyLoader<CollectOrRedeemRequest> collectLoader;
    private LoyaltyLoader<CollectOrRedeemRequest> redeemLoader;

    public CollectOrRedeemOffer() {
        this(LoaderModule.collectsLoader(), LoaderModule.redeeemLoader());
    }

    private CollectOrRedeemOffer(LoyaltyLoader<CollectOrRedeemRequest> collectLoader, LoyaltyLoader<CollectOrRedeemRequest> redeemLoader) {
        this.collectLoader = collectLoader;
        this.redeemLoader = redeemLoader;
    }

    public void collect(String employeeId, String shopName) {
        collectLoader.requestData(new CollectOrRedeemRequest(employeeId, shopName));
    }

    public void redeem(String employeeId, String shopName) {
        redeemLoader.requestData(new CollectOrRedeemRequest(employeeId, shopName));
    }
}
