package com.demo.data.events;

import com.demo.data.api.ApiError;

public class VouchersFailureEvent {
    private final ApiError mApiError;

    public VouchersFailureEvent(ApiError apiError) {
        mApiError = apiError;
    }

    public ApiError getApiError() {
        return mApiError;
    }
}
