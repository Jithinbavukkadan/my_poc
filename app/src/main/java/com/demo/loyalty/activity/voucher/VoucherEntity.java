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
                add(new VoucherEntity("Title One",
                        "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                        "QTD66D"));
                add(new VoucherEntity("Title Two",
                        "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                        "QTD66D"));

            }
        };
        return list;
    }
}
