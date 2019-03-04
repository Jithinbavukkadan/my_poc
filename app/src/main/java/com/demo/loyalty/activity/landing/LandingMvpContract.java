package com.demo.loyalty.activity.landing;

import com.demo.data.api.ApiError;
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

        void updateTransactions(List<TransactionSingleEntity> entities);

        void navigateToSettings();

        void navigateToCollectOrRedeem();

        void initializeNavigationDrawer();

        void initializeView();

    }

    interface Presenter {

        void register();

        void unregister();

        void onUserInfoSuccessEvent(UserInfoSuccessEvent event);

        void onUserInfoFailuresEvent(UserInfoFailureEvent event);

        void onTransactionsSuccessEvent(TransactionsSuccessEvent event);

        void onTransactionsFailuresEvent(TransactionsFailureEvent event);

        void loadUserInfo();

        void loadTransactions();


    }
}
