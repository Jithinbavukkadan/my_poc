package com.demo.loyalty.activity.register;

import com.demo.data.events.RegisterFailureEvent;
import com.demo.data.events.RegistrationSuccessEvent;
import com.demo.data.model.server.UserDetails;
import com.demo.data.repo.PreferenceRepo;
import com.demo.loyalty.modules.EventBusModule;
import com.demo.loyalty.modules.PreferenceRepositoryModule;
import com.demo.loyalty.util.EmailValidator;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class RegistrationPresenter implements RegisterMvpContract.Presenter {
    private RegisterMvpContract.View view;
    private RegisterMvpContract.Model model;
    private EventBus mEventBus;
    private PreferenceRepo mPreferenceRepo;

    public RegistrationPresenter(RegisterMvpContract.View view) {
        this(view, new RegistrationModel(), EventBusModule.eventBus(), PreferenceRepositoryModule.preferenceRepo());
    }

    private RegistrationPresenter(RegisterMvpContract.View view, RegisterMvpContract.Model model, EventBus eventBus,
            PreferenceRepo preferenceRepo) {
        this.view = view;
        this.model = model;
        this.mEventBus = eventBus;
        this.mPreferenceRepo = preferenceRepo;
    }

    @Override
    public void OnClickSignUp() {
        String email = view.getEmail();
        String employeeId = view.getEmployeeNumber();
        String nickName = view.getNickName();
        if (EmailValidator.isValidEmailAddress(email)) {
            view.showLoading();
            model.doRegister(email, employeeId, nickName);
        } else {
            view.showError("Invalid email address");
        }
    }

    @Override
    @Subscribe
    public void onRegistrationSuccess(RegistrationSuccessEvent event) {
        view.hideLoading();
        UserDetails userDetails = event.getEntity();
        if (userDetails != null) {
            mPreferenceRepo.setUserDetails(userDetails);
            view.navigateToHomeScreen();
        }
    }

    @Override
    @Subscribe
    public void onRegistrationFailure(RegisterFailureEvent event) {
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
