package com.demo.data.model.request;

public class CollectOrRedeemRequest {
    private final String employeeId;
    private final String shopName;

    public CollectOrRedeemRequest(String employeeId, String shopName) {
        this.employeeId = employeeId;
        this.shopName = shopName;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getShopName() {
        return shopName;
    }
}
