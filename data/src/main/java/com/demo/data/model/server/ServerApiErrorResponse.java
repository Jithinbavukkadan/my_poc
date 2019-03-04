package com.demo.data.model.server;

import com.google.gson.annotations.SerializedName;

public class ServerApiErrorResponse {
    @SerializedName("status")
    private int mStatus;

    @SerializedName("message")
    private String mMessage;


    public int getStatus() {
        return mStatus;
    }

    public String getMessage() {
        return mMessage;
    }
}
