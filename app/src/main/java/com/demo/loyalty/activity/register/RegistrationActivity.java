package com.demo.loyalty.activity.register;

import com.google.android.material.textfield.TextInputEditText;

import com.demo.data.api.ApiError;
import com.demo.data.model.request.RegistrationRequest;
import com.demo.loyalty.R;
import com.demo.loyalty.activity.landing.LandingActivity;
import com.demo.loyalty.modules.EventBusModule;
import com.demo.loyalty.modules.LoaderModule;

import org.greenrobot.eventbus.EventBus;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegistrationActivity extends AppCompatActivity implements RegisterMvpContract.View {
    @BindView(R.id.nickname)
    public TextInputEditText mNickName;

    @BindView(R.id.employeeid)
    public TextInputEditText mEmployeeId;

    @BindView(R.id.email)
    public TextInputEditText mEmail;

    @BindView(R.id.progress_bar)
    public View mProgressView;

    private RegisterMvpContract.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        ButterKnife.bind(this);

        mPresenter = new RegistrationPresenter(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mPresenter.register();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mPresenter.unregister();
    }

    @OnClick(R.id.signup_btn)
    public void OnClickSignUp() {
        mPresenter.OnClickSignUp();
    }

    @Override
    public void showError(ApiError error) {
        Toast.makeText(this, error.getMessage(), Toast.LENGTH_SHORT).show();
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

    @Override
    public void showLoading() {
        mProgressView.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        mProgressView.setVisibility(View.GONE);
    }
}
