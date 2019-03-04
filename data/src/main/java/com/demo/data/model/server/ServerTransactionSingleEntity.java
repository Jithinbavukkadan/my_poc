package com.demo.data.model.server;

import com.google.gson.annotations.SerializedName;

public class ServerTransactionSingleEntity {

    @SerializedName("id")
    private String id;

    @SerializedName("employeeid")
    private String mEmployeeid;

    @SerializedName("transtype")
    private String mTranstype;

    @SerializedName("transdate")
    private String mTransdate;

    @SerializedName("points")
    private String mPoints;

    public String getId() {
        return id;
    }

    public String getEmployeeid() {
        return mEmployeeid;
    }

    public String getTranstype() {
        return mTranstype;
    }

    public String getTransdate() {
        return mTransdate;
    }

    public String getPoints() {
        return mPoints;
    }
}
