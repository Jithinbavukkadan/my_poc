package com.demo.loyalty.activity.launch;

import com.demo.data.repo.PreferenceRepo;
import com.demo.loyalty.R;
import com.demo.loyalty.activity.landing.LandingActivity;
import com.demo.loyalty.modules.PreferenceRepositoryModule;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import com.demo.loyalty.activity.register.RegistrationActivity;

public class LaunchActivity extends AppCompatActivity implements LaunchScreenMvpContract.View {

    @BindView(R.id.register_btn)
    AppCompatButton registerBtn;

    private LaunchScreenMvpContract.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);
        ButterKnife.bind(this);

        mPresenter = new LaunchScreenPresenter(this);

        enableOrDisableRegisterButton(!mPresenter.isRegistered());

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (mPresenter.isRegistered()) {
                    navigateHomeScreen();
                }
            }
        }, 1000);
    }

    @OnClick(R.id.register_btn)
    @Override
    public void navigateRegister() {
        startActivity(new Intent(getApplicationContext(), RegistrationActivity.class));
        finish();
    }

    @Override
    public void navigateHomeScreen() {
        startActivity(new Intent(getApplicationContext(), LandingActivity.class));
        finish();
    }

    @Override
    public void enableOrDisableRegisterButton(boolean enable) {
        registerBtn.setVisibility(enable ? View.VISIBLE : View.GONE);
    }
}
