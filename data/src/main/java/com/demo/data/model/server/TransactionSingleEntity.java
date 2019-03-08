package com.demo.data.model.server;

import com.google.gson.annotations.SerializedName;

public class TransactionSingleEntity {
    public static final String COLLECT = "COLLECT";
    public static final String VOUCHER = "VOUCHERS";
    public static final String REDEEM = "REDEEM";

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

    @SerializedName("location")
    private String mLocation;

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

    public String getLocation() {
        return mLocation;
    }

    @Override
    public String toString() {
        String displayText = "";
        if (getTranstype().equalsIgnoreCase(COLLECT)) {
            displayText = getPoints() + "pts Collected from " + getLocation();
        } else if (getTranstype().equalsIgnoreCase(VOUCHER)) {
            displayText = "Points redeemed to vouchers";
        } else {
            displayText = getPoints() + "pts Redeemed from " + getLocation();
        }
        return displayText;
    }
}
