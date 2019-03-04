package com.demo.data.api;

import com.demo.data.model.request.RegistrationRequest;
import com.demo.data.model.server.UserDetails;
import com.demo.data.model.server.TransactionsResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ApiService {
    String ACCEPT_JSON = "Accept: application/json";

    @Headers({ACCEPT_JSON})
    @POST("user")
    Call<UserDetails> register(@Body RegistrationRequest request);

    @Headers({ACCEPT_JSON})
    @PUT("user/redeem/{employee_id}")
    Call<UserDetails> redeem(@Path("employee_id") String employeeId);

    @Headers({ACCEPT_JSON})
    @PUT("user/collect/{employee_id}")
    Call<UserDetails> collect(@Path("employee_id") String employeeId);

    @Headers({ACCEPT_JSON})
    @PUT("user/{employee_id}")
    Call<UserDetails> userInfo(@Path("employee_id") String employeeId);

    @Headers({ACCEPT_JSON})
    @PUT("user/transaction/{employee_id}")
    Call<TransactionsResponse> transactions(@Path("employee_id") String employeeId);
}
