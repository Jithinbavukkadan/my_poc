package com.demo.loyalty.activity.launch;

public interface LaunchScreenMvpContract {
    interface View {
        void navigateRegister();

        void navigateHomeScreen();

        void enableOrDisableRegisterButton(boolean enable);
    }

    interface Presenter {
        void onClickRegister();

        boolean isRegistered();
    }
}
