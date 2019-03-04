package com.demo.data.events;

import com.demo.data.api.ApiError;

public class CollectFailureEvent {
    private final ApiError mApiError;

    public CollectFailureEvent(ApiError apiError) {
        mApiError = apiError;
    }

    public ApiError getApiError() {
        return mApiError;
    }
}
