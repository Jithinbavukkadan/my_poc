package com.demo.data.events;

import com.demo.data.api.ApiError;

public class TransactionsFailureEvent {
    private final ApiError mApiError;

    public TransactionsFailureEvent(ApiError apiError) {
        mApiError = apiError;
    }

    public ApiError getApiError() {
        return mApiError;
    }
}
