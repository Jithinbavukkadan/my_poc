package com.demo.loyalty;

import com.demo.data.repo.PreferenceRepo;
import com.demo.loyalty.activity.landing.LandingActivity;
import com.demo.loyalty.modules.PreferenceRepositoryModule;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.ButterKnife;
import butterknife.OnClick;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class LaunchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);
        ButterKnife.bind(this);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                PreferenceRepo preferenceRepo = PreferenceRepositoryModule.preferenceRepo();
                preferenceRepo.setEmployeeId("708408");
                preferenceRepo.setNickName("Jithu");
                preferenceRepo.setTotalPoints(100);
                startActivity(new Intent(getApplicationContext(), LandingActivity.class));
            }
        }, 1000);
    }

    @OnClick(R.id.register_btn)
    public void register() {
        startActivity(new Intent(getApplicationContext(), RegistrationActivity.class));
    }
}
