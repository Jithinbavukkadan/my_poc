package com.demo.data.api;

import com.demo.data.model.request.RegistrationRequest;
import com.demo.data.model.server.ServerRegistrationEntity;
import com.demo.data.model.server.ServerTransactionsResponse;

public interface NetworkManager {

    public void register(RegistrationRequest registrationRequest, ApiCallback<ServerRegistrationEntity> apiCallback);

    public void collect(String userId, ApiCallback<ServerRegistrationEntity> apiCallback);

    public void redeem(String userId, ApiCallback<ServerRegistrationEntity> apiCallback);

    public void getUserDetails(String userId, ApiCallback<ServerRegistrationEntity> apiCallback);

    public void getTransactions(String userId, ApiCallback<ServerTransactionsResponse> apiCallback);

}
