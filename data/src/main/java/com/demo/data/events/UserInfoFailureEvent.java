package com.demo.data.events;

import com.demo.data.api.ApiError;

public class UserInfoFailureEvent {
    private final ApiError mApiError;

    public UserInfoFailureEvent(ApiError apiError) {
        mApiError = apiError;
    }

    public ApiError getApiError() {
        return mApiError;
    }
}
