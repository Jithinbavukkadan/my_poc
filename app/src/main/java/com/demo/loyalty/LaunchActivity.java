package com.demo.loyalty;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.ButterKnife;
import butterknife.OnClick;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.demo.loyalty.activity.register.RegistrationActivity;

public class LaunchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);
        ButterKnife.bind(this);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(), LandingActivity.class));
            }
        }, 1000);
    }

    @OnClick(R.id.register_btn)
    public void register(){
        startActivity(new Intent(getApplicationContext(), RegistrationActivity.class));
    }
}
