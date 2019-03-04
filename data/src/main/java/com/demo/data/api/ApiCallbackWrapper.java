package com.demo.data.api;

import com.google.gson.Gson;

import com.demo.data.model.server.ServerApiErrorResponse;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApiCallbackWrapper<T> implements Callback<T> {
    private final ApiCallback<T> mApiCallback;

    public ApiCallbackWrapper(ApiCallback<T> apiCallback) {
        mApiCallback = apiCallback;
    }

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        if (response.isSuccessful()) {
            if (response.body() != null) {
                mApiCallback.onSuccess(response.body());
            } else {
                mApiCallback.onNoContentAvailable();
            }
        } else {
            try {
                mApiCallback.onError(convertError(response.errorBody()));
            } catch (Exception e) {
                mApiCallback.onUnknownError();
            }
        }
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        if (t instanceof IOException) {
            mApiCallback.onNetworkError();
        } else {
            mApiCallback.onUnknownError();
        }
    }

    private ApiError convertError(ResponseBody errorBody) {
        Gson gson=new Gson();
        ServerApiErrorResponse response = gson.fromJson(errorBody.charStream(), ServerApiErrorResponse.class);
        return ApiError.newBuilder().message(response.getMessage()).errorCode(response.getStatus()).build();
    }
}
