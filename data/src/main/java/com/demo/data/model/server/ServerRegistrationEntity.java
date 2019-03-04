package com.demo.data.model.server;

import com.google.gson.annotations.SerializedName;

public class ServerRegistrationEntity {
    @SerializedName("employeeid")
    private String mEmployeeid;

    @SerializedName("nickname")
    private String mNickname;

    @SerializedName("emailaddress")
    private String mEmailaddress;

    @SerializedName("points")
    private String mPoints;
}
