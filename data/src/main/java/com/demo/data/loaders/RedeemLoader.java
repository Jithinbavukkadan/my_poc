package com.demo.data.loaders;

import com.demo.data.R;
import com.demo.data.api.ApiCallback;
import com.demo.data.api.ApiError;
import com.demo.data.api.NetworkManager;
import com.demo.data.events.RedeemFailureEvent;
import com.demo.data.events.RedeemSuccessEvent;
import com.demo.data.model.request.CollectOrRedeemRequest;
import com.demo.data.model.server.UserDetails;

import org.greenrobot.eventbus.EventBus;

import android.content.res.Resources;

import androidx.annotation.NonNull;

public class RedeemLoader implements LoyaltyLoader<CollectOrRedeemRequest>, ApiCallback<UserDetails> {
    private final NetworkManager mNetworkManager;
    private final EventBus mEventBus;
    private final Resources mRes;

    public RedeemLoader(NetworkManager networkManager, EventBus eventBus, Resources res) {
        mNetworkManager = networkManager;
        mEventBus = eventBus;
        mRes = res;
    }

    @Override
    public void requestData(CollectOrRedeemRequest data) {
        mNetworkManager.redeem(data.getEmployeeId(), data.getShopName(), this);
    }

    @Override
    public void onSuccess(@NonNull UserDetails successType) {
        mEventBus.post(new RedeemSuccessEvent(successType));
    }

    @Override
    public void onError(@NonNull ApiError apiError) {
        mEventBus.post(new RedeemFailureEvent(apiError));
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
