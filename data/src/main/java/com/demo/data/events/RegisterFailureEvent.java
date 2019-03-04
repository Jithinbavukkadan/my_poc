package com.demo.data.events;

import com.demo.data.api.ApiError;

public class RegisterFailureEvent {
    private final ApiError mApiError;

    public RegisterFailureEvent(ApiError apiError) {
        mApiError = apiError;
    }
}
