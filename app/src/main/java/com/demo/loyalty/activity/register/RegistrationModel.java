package com.demo.loyalty.activity.register;

import com.demo.data.loaders.LoyaltyLoader;
import com.demo.data.loaders.RegistrationLoader;
import com.demo.data.model.request.RegistrationRequest;
import com.demo.loyalty.modules.ApplicationModule;
import com.demo.loyalty.modules.EventBusModule;
import com.demo.loyalty.modules.LoaderModule;

public class RegistrationModel implements RegisterMvpContract.Model {

    private LoyaltyLoader<RegistrationRequest> mLoader;

    public RegistrationModel() {
        this(new RegistrationLoader(LoaderModule.networkManager(), EventBusModule.eventBus(), ApplicationModule.resources()));
    }

    private RegistrationModel(LoyaltyLoader<RegistrationRequest> loader) {
        mLoader = loader;
    }

    @Override
    public void doRegister(String email, String employeeId, String nickName) {
        mLoader.requestData(new RegistrationRequest(email, employeeId, nickName));
    }
}
