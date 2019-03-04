package com.demo.data.api;

import com.demo.data.model.request.RegistrationRequest;
import com.demo.data.model.server.ServerRegistrationEntity;

import retrofit2.Retrofit;

public class NetworkManagerImpl implements NetworkManager {
    private final ApiService mApiService;

    public NetworkManagerImpl(ApiService apiService) {
        mApiService = apiService;
    }

    @Override
    public void register(RegistrationRequest registrationRequest, ApiCallback<ServerRegistrationEntity> apiCallback) {
        mApiService.register(registrationRequest).enqueue(getApiCallbackWrapper(apiCallback));
    }

    @Override
    public void collect(String userId, ApiCallback<Object> apiCallback) {

    }

    @Override
    public void redeem(String userId, ApiCallback<Object> apiCallback) {

    }

    @Override
    public void getUserDetails(String userId, ApiCallback<Object> apiCallback) {

    }

    @Override
    public void getTransactions(String userId, ApiCallback<Object> apiCallback) {

    }

    private <T> ApiCallbackWrapper<T> getApiCallbackWrapper(ApiCallback<T> callback) {
        return new ApiCallbackWrapper<>(callback);
    }

}
