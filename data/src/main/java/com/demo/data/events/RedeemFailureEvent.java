package com.demo.data.events;

import com.demo.data.api.ApiError;

public class RedeemFailureEvent {
    private final ApiError mApiError;

    public RedeemFailureEvent(ApiError apiError) {
        mApiError = apiError;
    }

    public ApiError getApiError() {
        return mApiError;
    }
}
