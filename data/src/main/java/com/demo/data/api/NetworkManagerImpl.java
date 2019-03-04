package com.demo.data.api;

import com.demo.data.model.request.RegistrationRequest;
import com.demo.data.model.server.UserDetails;
import com.demo.data.model.server.TransactionsResponse;

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
    public void collect(String userId, ApiCallback<UserDetails> apiCallback) {

    }

    @Override
    public void redeem(String userId, ApiCallback<UserDetails> apiCallback) {

    }

    @Override
    public void getUserDetails(String userId, ApiCallback<UserDetails> apiCallback) {

    }

    @Override
    public void getTransactions(String userId, ApiCallback<TransactionsResponse> apiCallback) {

    }

    private <T> ApiCallbackWrapper<T> getApiCallbackWrapper(ApiCallback<T> callback) {
        return new ApiCallbackWrapper<>(callback);
    }

}
