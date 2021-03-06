package com.demo.loyalty.view;

import com.demo.data.model.server.UserDetails;
import com.demo.data.repo.PreferenceRepo;
import com.demo.loyalty.R;
import com.demo.loyalty.modules.PreferenceRepositoryModule;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.Locale;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import butterknife.BindView;
import butterknife.ButterKnife;

public class HeaderView extends FrameLayout {

    private UserDetails mUserDetails;
    private PreferenceRepo mPreferenceRepo;

    @BindView(R.id.welcome_msg)
    TextView mWelcomeMessage;

    @BindView(R.id.points_tv)
    TextView mPoints;

    @BindView(R.id.collect_or_redeem_points)
    CollectOrRedeemPointsView mCollectOrRedeemPointsView;

    public HeaderView(@androidx.annotation.NonNull Context context) {
        this(context, null);
    }

    public HeaderView(@androidx.annotation.NonNull Context context,
            @androidx.annotation.Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public HeaderView(@androidx.annotation.NonNull Context context,
            @androidx.annotation.Nullable AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0, PreferenceRepositoryModule.preferenceRepo());
    }

    public HeaderView(@androidx.annotation.NonNull Context context,
            @androidx.annotation.Nullable AttributeSet attrs, int defStyleAttr,
            int defStyleRes, PreferenceRepo preferenceRepo) {
        super(context, attrs, defStyleAttr, defStyleRes);
        mPreferenceRepo = preferenceRepo;
        LayoutInflater.from(context).inflate(R.layout.header_view, this);
        ButterKnife.bind(this);
        mWelcomeMessage.setText("Hello " + preferenceRepo.getNickName() + " \nWelcome to iLoyalty");
        countAnimation(0, preferenceRepo.getTotalPoints(), mPoints);
    }

    public UserDetails getUserDetails() {
        return mUserDetails;
    }

    public void setUserDetails(UserDetails userDetails) {
        mUserDetails = userDetails;
        countAnimation(mPreferenceRepo.getTotalPoints(), Integer.parseInt(mUserDetails.getPoints()), mPoints);
        mCollectOrRedeemPointsView.setUserDetails(userDetails);
    }


    private void countAnimation(int start, final int end, final TextView view) {
        ValueAnimator animator = ValueAnimator.ofInt(start, end);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                Object animatedValue = animation.getAnimatedValue();
                view.setText(NumberFormat.getNumberInstance(Locale.US).format(animatedValue));
            }
        });
        animator.setDuration(1000);
        animator.start();
    }
}
