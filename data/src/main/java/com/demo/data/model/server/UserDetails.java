package com.demo.data.model.server;

import com.google.gson.annotations.SerializedName;

public class UserDetails {
    @SerializedName("employeeid")
    private String mEmployeeid;

    @SerializedName("nickname")
    private String mNickname;

    @SerializedName("emailaddress")
    private String mEmailaddress;

    @SerializedName("points")
    private String mPoints;

    public String getEmployeeid() {
        return mEmployeeid;
    }

    public String getNickname() {
        return mNickname;
    }

    public String getEmailaddress() {
        return mEmailaddress;
    }

    public String getPoints() {
        return mPoints;
    }
}
