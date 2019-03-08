package com.demo.loyalty.activity.voucher;

import com.demo.data.loaders.LoyaltyLoader;
import com.demo.data.loaders.RegistrationLoader;
import com.demo.data.model.request.RegistrationRequest;
import com.demo.loyalty.modules.ApplicationModule;
import com.demo.loyalty.modules.EventBusModule;
import com.demo.loyalty.modules.LoaderModule;

public class VoucherModel implements VouchersMvpContract.Model {

    private LoyaltyLoader<String> mLoader;

    public VoucherModel() {
        this(LoaderModule.voucherLoader());
    }

    private VoucherModel(LoyaltyLoader<String> loader) {
        mLoader = loader;
    }


    @Override
    public void redeemToVoucher(String employeeId) {
        mLoader.requestData(employeeId);
    }
}
