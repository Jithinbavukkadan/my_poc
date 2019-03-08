package com.demo.loyalty.activity.landing;

import com.demo.data.api.ApiError;
import com.demo.data.events.CollectFailureEvent;
import com.demo.data.events.CollectSuccessEvent;
import com.demo.data.events.RedeemFailureEvent;
import com.demo.data.events.RedeemSuccessEvent;
import com.demo.data.events.TransactionsFailureEvent;
import com.demo.data.events.TransactionsSuccessEvent;
import com.demo.data.events.UserInfoFailureEvent;
import com.demo.data.events.UserInfoSuccessEvent;
import com.demo.data.model.server.UserDetails;
import com.demo.data.model.server.TransactionSingleEntity;

import org.greenrobot.eventbus.Subscribe;

import java.util.List;

public interface LandingMvpContract {
    interface Model {
        void loadUserInfo(String employeeId);

        void loadTransactions(String employeeId);
    }

    interface View {
        void showLoading();

        void hideLoading();

        void updateUserDetails(UserDetails entity);

        void showError(ApiError error);

        void showError(String error);

        void updateTransactions(List<TransactionSingleEntity> entities);

        void navigateToSettings();

        void navigateToCollectOrRedeem();

        void navigateToVouchers();

        void navigateToLaunchScreen();

        void initializeNavigationDrawer();

        void initializeView();

        void showConfirmationDialog(String type,String shopName,LandingActivity.ConfirmationListener listener);

        void showWarningDialog(String message);
    }

    interface Presenter {

        void register();

        void unregister();

        void logout();

        void onUserInfoSuccessEvent(UserInfoSuccessEvent event);

        void onUserInfoFailuresEvent(UserInfoFailureEvent event);

        void onTransactionsSuccessEvent(TransactionsSuccessEvent event);

        void onTransactionsFailuresEvent(TransactionsFailureEvent event);

        void onCollectSuccessEvent(CollectSuccessEvent event);

        void onCollectFailuresEvent(CollectFailureEvent event);

        void onRedeemSuccessEvent(RedeemSuccessEvent event);

        void onRedeemFailuresEvent(RedeemFailureEvent event);

        void loadUserInfo();

        void loadTransactions();

        void collect(String shopName);

        void redeem(String shopName);

        String[] processBarcodeData(String barcodeData);
    }
}
