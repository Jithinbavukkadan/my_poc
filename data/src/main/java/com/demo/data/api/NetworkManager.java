package com.demo.data.api;

import com.demo.data.model.request.RegistrationRequest;
import com.demo.data.model.server.UserDetails;
import com.demo.data.model.server.TransactionsResponse;

public interface NetworkManager {

    public void register(RegistrationRequest registrationRequest, ApiCallback<UserDetails> apiCallback);

    public void collect(String userId, ApiCallback<UserDetails> apiCallback);

    public void redeem(String userId, ApiCallback<UserDetails> apiCallback);

    public void getUserDetails(String userId, ApiCallback<UserDetails> apiCallback);

    public void getTransactions(String userId, ApiCallback<TransactionsResponse> apiCallback);

}
