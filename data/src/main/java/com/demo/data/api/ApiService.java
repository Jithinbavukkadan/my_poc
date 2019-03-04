package com.demo.data.api;

import com.demo.data.model.request.RegistrationRequest;
import com.demo.data.model.server.ServerRegistrationEntity;
import com.demo.data.model.server.ServerTransactionsResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ApiService {
    String ACCEPT_JSON = "Accept: application/json";

    @Headers({ACCEPT_JSON})
    @POST("user")
    Call<ServerRegistrationEntity> register(@Body RegistrationRequest request);

    @Headers({ACCEPT_JSON})
    @PUT("user/redeem/{employee_id}")
    Call<ServerRegistrationEntity> redeem(@Path("employee_id") String employeeId);

    @Headers({ACCEPT_JSON})
    @PUT("user/collect/{employee_id}")
    Call<ServerRegistrationEntity> collect(@Path("employee_id") String employeeId);

    @Headers({ACCEPT_JSON})
    @PUT("user/{employee_id}")
    Call<ServerRegistrationEntity> userInfo(@Path("employee_id") String employeeId);

    @Headers({ACCEPT_JSON})
    @PUT("user/transaction/{employee_id}")
    Call<ServerTransactionsResponse> transactions(@Path("employee_id") String employeeId);
}
