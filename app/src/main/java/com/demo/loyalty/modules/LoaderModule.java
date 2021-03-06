package com.demo.loyalty.modules;

import com.demo.data.api.NetworkManager;
import com.demo.data.api.NetworkManagerImpl;
import com.demo.data.loaders.CollectLoader;
import com.demo.data.loaders.LoyaltyLoader;
import com.demo.data.loaders.RedeemLoader;
import com.demo.data.loaders.RegistrationLoader;
import com.demo.data.loaders.TransactionsLoader;
import com.demo.data.loaders.UserInfoLoader;
import com.demo.data.loaders.VoucherLoader;
import com.demo.data.model.request.CollectOrRedeemRequest;
import com.demo.data.model.request.RegistrationRequest;

public class LoaderModule {

    public static LoyaltyLoader<RegistrationRequest> registerLoader() {
        return new RegistrationLoader(networkManager(), EventBusModule.eventBus(), ApplicationModule.resources());
    }

    public static LoyaltyLoader<String> userInfoLoader() {
        return new UserInfoLoader(networkManager(), EventBusModule.eventBus(), ApplicationModule.resources());
    }

    public static LoyaltyLoader<String> transactionsLoader() {
        return new TransactionsLoader(networkManager(), EventBusModule.eventBus(), ApplicationModule.resources());
    }

    public static LoyaltyLoader<CollectOrRedeemRequest> collectsLoader() {
        return new CollectLoader(networkManager(), EventBusModule.eventBus(), ApplicationModule.resources());
    }

    public static LoyaltyLoader<CollectOrRedeemRequest> redeeemLoader() {
        return new RedeemLoader(networkManager(), EventBusModule.eventBus(), ApplicationModule.resources());
    }

    public static LoyaltyLoader<String> voucherLoader() {
        return new VoucherLoader(networkManager(), EventBusModule.eventBus(), ApplicationModule.resources());
    }

    public static NetworkManager networkManager() {
        return new NetworkManagerImpl(ApiServiceModule.getApiService());
    }

}
