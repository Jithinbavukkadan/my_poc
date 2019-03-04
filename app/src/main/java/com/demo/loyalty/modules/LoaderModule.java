package com.demo.loyalty.modules;

import com.demo.data.api.NetworkManager;
import com.demo.data.api.NetworkManagerImpl;
import com.demo.data.loaders.LoyaltyLoader;
import com.demo.data.loaders.RegistrationLoader;
import com.demo.data.model.request.RegistrationRequest;

public class LoaderModule {

    public static LoyaltyLoader<RegistrationRequest> registerLoader() {
        return new RegistrationLoader(networkManager(), EventBusModule.eventBus(), ApplicationModule.resources());
    }

    public static NetworkManager networkManager() {
        return new NetworkManagerImpl(ApiServiceModule.getApiService());
    }

}
