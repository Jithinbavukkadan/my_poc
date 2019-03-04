package com.demo.data.api;

import com.demo.data.model.request.RegistrationRequest;
import com.demo.data.model.server.ServerRegistrationEntity;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ApiService {
    String ACCEPT_JSON = "Accept: application/json";

    @Headers({ACCEPT_JSON})
    @POST("user")
    Call<ServerRegistrationEntity> register(@Body RegistrationRequest request);
}
