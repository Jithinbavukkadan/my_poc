package com.demo.loyalty.activity.voucher;

import com.demo.data.api.ApiError;
import com.demo.data.events.RegisterFailureEvent;
import com.demo.data.events.RegistrationSuccessEvent;
import com.demo.data.events.VouchersFailureEvent;
import com.demo.data.events.VouchersSuccessEvent;

public interface VouchersMvpContract {
    interface Model {
        void redeemToVoucher(String employeeId);
    }

    interface View {
        void showError(ApiError error);

        void showError(String error);

        void showLoading();

        void hideLoading();

        void navigateToLandingScreen();

        void startRedeemToVoucher(VoucherActivity.ConfirmationListener listener);

        public void showWarningDialog(String message);

        void showNoVoucher();

        void loadVoucherInfo();
    }

    interface Presenter {
        void redeemToVoucher();

        void onVoucherSuccess(VouchersSuccessEvent event);

        void onVoucherFailure(VouchersFailureEvent event);

        void register();

        void unregister();
    }
}
