package com.demo.data.api;

import com.demo.data.model.request.RegistrationRequest;
import com.demo.data.model.server.TransactionSingleEntity;
import com.demo.data.model.server.UserDetails;

import java.util.List;

public class NetworkManagerImpl implements NetworkManager {
    private final ApiService mApiService;

    public NetworkManagerImpl(ApiService apiService) {
        mApiService = apiService;
    }

    @Override
    public void register(RegistrationRequest registrationRequest, ApiCallback<UserDetails> apiCallback) {
        mApiService.register(registrationRequest).enqueue(getApiCallbackWrapper(apiCallback));
    }

    @Override
    public void collect(String userId, String shopName, ApiCallback<UserDetails> apiCallback) {
        mApiService.collect(userId, shopName).enqueue(getApiCallbackWrapper(apiCallback));
    }

    @Override
    public void redeem(String userId, String shopName, ApiCallback<UserDetails> apiCallback) {
        mApiService.redeem(userId, shopName).enqueue(getApiCallbackWrapper(apiCallback));
    }

    @Override
    public void getUserDetails(String userId, ApiCallback<UserDetails> apiCallback) {
        mApiService.userInfo(userId).enqueue(getApiCallbackWrapper(apiCallback));
    }

    @Override
    public void getTransactions(String userId, ApiCallback<List<TransactionSingleEntity>> apiCallback) {
        mApiService.transactions(userId).enqueue(getApiCallbackWrapper(apiCallback));
    }

    @Override
    public void redeemToVoucher(String userId, ApiCallback<UserDetails> apiCallback) {
        mApiService.redeemToVoucher(userId).enqueue(getApiCallbackWrapper(apiCallback));
    }

    private <T> ApiCallbackWrapper<T> getApiCallbackWrapper(ApiCallback<T> callback) {
        return new ApiCallbackWrapper<>(callback);
    }

}
