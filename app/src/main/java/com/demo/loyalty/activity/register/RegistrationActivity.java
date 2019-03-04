package com.demo.loyalty.activity.register;

import android.content.Intent;
import android.os.Bundle;

import com.demo.data.api.ApiError;
import com.demo.loyalty.LandingActivity;
import com.demo.loyalty.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

import com.demo.data.events.RegisterFailureEvent;
import com.demo.data.events.RegistrationSuccessEvent;
import com.demo.data.model.request.RegistrationRequest;
import com.demo.loyalty.modules.EventBusModule;
import com.demo.loyalty.modules.LoaderModule;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import android.util.Log;
import android.view.View;

public class RegistrationActivity extends AppCompatActivity implements RegisterMvpContract.View {
    @BindView(R.id.nickname)
    public TextInputEditText mNickName;

    @BindView(R.id.employeeid)
    public TextInputEditText mEmployeeId;

    @BindView(R.id.email)
    public TextInputEditText mEmail;

    private final EventBus mEventBus;

    public RegistrationActivity(EventBus eventBus) {
        mEventBus = eventBus;
    }

    public RegistrationActivity() {
        this(EventBusModule.eventBus());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        ButterKnife.bind(this);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }
/*
    @Override
    protected void onStart() {
        super.onStart();
        mEventBus.register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mEventBus.unregister(this);
    }*/

    @OnClick(R.id.signup_btn)
    public void register() {
        LoaderModule.registerLoader().requestData(
                new RegistrationRequest(mEmail.getText().toString().trim(), mEmployeeId.getText().toString().trim(),
                        mNickName.getText().toString().trim()));
    }
/*
    @Subscribe
    public void onEvent(RegistrationSuccessEvent event) {
        Log.d("RegisterSuccessEvent", "<>" + event.getEntity().getPoints());
    }

    @Subscribe
    public void onEvent(RegisterFailureEvent event) {
        Log.d("RegisterFailEvent", event.getApiError().getMessage());
    }*/

    @Override
    public void showError(ApiError error) {

    }

    @Override
    public String getEmail() {
        return mEmail.getText().toString().trim();
    }

    @Override
    public String getNickName() {
        return mNickName.getText().toString().trim();
    }

    @Override
    public String getEmployeeNumber() {
        return mEmployeeId.getText().toString().trim();
    }

    @Override
    public void navigateToHomeScreen() {
        startActivity(new Intent(this, LandingActivity.class));
    }
}
