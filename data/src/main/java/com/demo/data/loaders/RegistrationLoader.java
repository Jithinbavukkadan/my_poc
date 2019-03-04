package com.demo.data.loaders;

import com.demo.data.R;
import com.demo.data.api.ApiCallback;
import com.demo.data.api.ApiError;
import com.demo.data.api.NetworkManager;
import com.demo.data.events.RegisterFailureEvent;
import com.demo.data.events.RegistrationSuccessEvent;
import com.demo.data.model.request.RegistrationRequest;
import com.demo.data.model.server.ServerRegistrationEntity;

import org.greenrobot.eventbus.EventBus;

import android.content.res.Resources;
import android.text.SpannableString;

import androidx.annotation.NonNull;

public class RegistrationLoader implements LoyaltyLoader<RegistrationRequest>, ApiCallback<ServerRegistrationEntity> {
    private final NetworkManager mNetworkManager;
    private final EventBus mEventBus;
    private final Resources mRes;

    public RegistrationLoader(NetworkManager networkManager, EventBus eventBus, Resources res) {
        mNetworkManager = networkManager;
        mEventBus = eventBus;
        mRes = res;
    }

    @Override
    public void requestData(RegistrationRequest data) {
        mNetworkManager.register(data, this);
    }

    @Override
    public void onSuccess(@NonNull ServerRegistrationEntity successType) {
        mEventBus.post(new RegistrationSuccessEvent(successType));
    }

    @Override
    public void onError(@NonNull ApiError apiError) {
        mEventBus.post(new RegisterFailureEvent(apiError));
    }

    @Override
    public void onNoContentAvailable() {
        onUnknownError();
    }

    @Override
    public void onNetworkError() {
        onUnknownError();
    }

    @Override
    public void onUnknownError() {
        onError(ApiError.newBuilder()
                .message(mRes.getString(R.string.global_network_error))
                .build());
    }
}
