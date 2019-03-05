package com.demo.loyalty.activity.register;

import com.demo.data.events.RegisterFailureEvent;
import com.demo.data.events.RegistrationSuccessEvent;
import com.demo.loyalty.modules.EventBusModule;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class RegistrationPresenter implements RegisterMvpContract.Presenter {
    private RegisterMvpContract.View view;
    private RegisterMvpContract.Model model;
    private EventBus mEventBus;

    public RegistrationPresenter(RegisterMvpContract.View view) {
        this(view, new RegistrationModel(), EventBusModule.eventBus());
    }

    private RegistrationPresenter(RegisterMvpContract.View view, RegisterMvpContract.Model model, EventBus eventBus) {
        this.view = view;
        this.model = model;
        this.mEventBus = eventBus;
    }

    @Override
    public void OnClickSignUp() {
        String email = view.getEmail();
        String employeeId = view.getEmployeeNumber();
        String nickName = view.getNickName();
        //email validation,
        view.showLoading();
        model.doRegister(email, employeeId, nickName);
    }

    @Override
    @Subscribe
    public void onRegistrationSuccess(RegistrationSuccessEvent event) {
        view.hideLoading();
        view.navigateToHomeScreen();
    }

    @Override
    @Subscribe
    public void onRegistrationFailure(RegisterFailureEvent event)
    {
        view.hideLoading();
        view.showError(event.getApiError());
    }

    @Override
    public void register() {
        mEventBus.register(this);
    }

    @Override
    public void unregister() {
        mEventBus.unregister(this);
    }
}
