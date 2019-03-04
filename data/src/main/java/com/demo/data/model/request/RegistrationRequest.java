package com.demo.data.model.request;

import com.google.gson.annotations.SerializedName;

public class RegistrationRequest {
    @SerializedName("email")
    private final String email;

    @SerializedName("employeeId")
    private final String employeeId;

    @SerializedName("nickName")
    private final String nickName;

    public RegistrationRequest(String email, String employeeId, String nickName) {
        this.email = email;
        this.employeeId = employeeId;
        this.nickName = nickName;
    }

    public String getEmail() {
        return email;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getNickName() {
        return nickName;
    }
}
