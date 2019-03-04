package com.demo.data.loaders;

import com.demo.data.R;
import com.demo.data.api.ApiCallback;
import com.demo.data.api.ApiError;
import com.demo.data.api.NetworkManager;
import com.demo.data.events.TransactionsFailureEvent;
import com.demo.data.events.TransactionsSuccessEvent;
import com.demo.data.model.server.TransactionSingleEntity;

import org.greenrobot.eventbus.EventBus;

import android.content.res.Resources;

import java.util.List;

import androidx.annotation.NonNull;

public class TransactionsLoader implements LoyaltyLoader<String>, ApiCallback<List<TransactionSingleEntity>> {
    private final NetworkManager mNetworkManager;
    private final EventBus mEventBus;
    private final Resources mRes;

    public TransactionsLoader(NetworkManager networkManager, EventBus eventBus, Resources res) {
        mNetworkManager = networkManager;
        mEventBus = eventBus;
        mRes = res;
    }

    @Override
    public void requestData(String employeeId) {
        mNetworkManager.getTransactions(employeeId, this);
    }


    @Override
    public void onSuccess(@NonNull List<TransactionSingleEntity> successType) {
        mEventBus.post(new TransactionsSuccessEvent(successType));
    }

    @Override
    public void onError(@NonNull ApiError apiError) {
        mEventBus.post(new TransactionsFailureEvent(apiError));
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
