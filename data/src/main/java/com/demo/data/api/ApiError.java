package com.demo.data.api;

import android.os.Bundle;
import android.text.SpannableString;

public class ApiError {
    private final String mMessage;
    private final int mErrorCode;

    public String getMessage() {
        return mMessage;
    }

    public int getErrorCode() {
        return mErrorCode;
    }

    private ApiError(Builder builder) {
        mMessage = builder.mMessage;
        mErrorCode = builder.mErrorCode;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static final class Builder {
        private String mMessage;
        private int mErrorCode;

        private Builder() {
        }

        public Builder message(String message) {
            mMessage = message;
            return this;
        }

        public Builder errorCode(int errorCode) {
            mErrorCode = errorCode;
            return this;
        }

        public ApiError build() {
            return new ApiError(this);
        }

    }
}
