package com.demo.loyalty.activity.register;

import com.demo.data.api.ApiError;
import com.demo.data.events.RegisterFailureEvent;
import com.demo.data.events.RegistrationSuccessEvent;

public interface RegisterMvpContract {
    interface Model {
        void doRegister(String email, String employeeId, String nickName);
    }

    interface View {
        void showError(ApiError error);

        void showError(String error);

        String getEmail();

        String getNickName();

        String getEmployeeNumber();

        void navigateToHomeScreen();

        void showLoading();

        void hideLoading();
    }

    interface Presenter {
        void OnClickSignUp();

        void onRegistrationSuccess(RegistrationSuccessEvent event);

        void onRegistrationFailure(RegisterFailureEvent event);

        void register();

        void unregister();
    }
}
