package com.demo.loyalty.activity.voucher;

import java.util.ArrayList;
import java.util.List;

public class VoucherEntity {
    private final String mVoucherTitle;
    private final String mVoucherDetails;
    private final String mVoucherCode;

    public VoucherEntity(String voucherTitle, String voucherDetails, String voucherCode) {
        mVoucherTitle = voucherTitle;
        mVoucherDetails = voucherDetails;
        mVoucherCode = voucherCode;
    }

    public String getVoucherDetails() {
        return mVoucherDetails;
    }

    public String getVoucherTitle() {
        return mVoucherTitle;
    }

    public String getVoucherCode() {
        return mVoucherCode;
    }

    public static List<VoucherEntity> getVouchersData() {
        List<VoucherEntity> list = new ArrayList<VoucherEntity>() {
            {
                add(new VoucherEntity("Offer code",
                        "Avail 20% off on buying Denim jeans at Fashion store",
                        "QTD66L"));
                add(new VoucherEntity("Offer code",
                        "Avail 20% off on buying groceries at Grocery store",
                        "QTD66D"));

            }
        };
        return list;
    }
}
