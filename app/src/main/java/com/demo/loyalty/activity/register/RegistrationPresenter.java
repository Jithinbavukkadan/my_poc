package com.demo.loyalty.activity.register;

import com.demo.data.events.RegisterFailureEvent;
import com.demo.data.events.RegistrationSuccessEvent;

import org.greenrobot.eventbus.Subscribe;

public class RegistrationPresenter implements RegisterMvpContract.Presenter {
    private RegisterMvpContract.View view;
    private RegisterMvpContract.Model model;

    public RegistrationPresenter(RegisterMvpContract.View view) {
        this.view = view;
    }

    @Override
    public void OnClickSignUp() {
        String email = view.getEmail();
        String employeeId = view.getEmployeeNumber();
        String nickName = view.getNickName();
        //email validation,
        model.doRegister(email, employeeId, nickName);
    }

    @Override
    @Subscribe
    public void onRegistrationSuccess(RegistrationSuccessEvent event) {
        view.navigateToHomeScreen();
    }

    @Override
    @Subscribe
    public void onRegistrationFailure(RegisterFailureEvent event) {
        view.showError(event.getApiError());
    }
}
