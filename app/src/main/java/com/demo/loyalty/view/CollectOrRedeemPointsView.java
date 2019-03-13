package com.demo.loyalty.view;

import com.demo.data.model.server.UserDetails;
import com.demo.data.repo.PreferenceRepo;
import com.demo.loyalty.R;
import com.demo.loyalty.modules.PreferenceRepositoryModule;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import butterknife.BindView;
import butterknife.ButterKnife;

public class CollectOrRedeemPointsView extends FrameLayout {
    private UserDetails mUserDetails;

    PreferenceRepo mPreferenceRepo;

    @BindView(R.id.collect_points)
    TextView mCollectPoints;

    @BindView(R.id.redeem_points)
    TextView mRedeemPoints;

    public CollectOrRedeemPointsView(@NonNull Context context) {
        this(context, null);
    }

    public CollectOrRedeemPointsView(@NonNull Context context,
            @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CollectOrRedeemPointsView(@NonNull Context context,
            @Nullable AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public CollectOrRedeemPointsView(@NonNull Context context,
            @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        this(context, attrs, defStyleAttr, defStyleRes, PreferenceRepositoryModule.preferenceRepo());

    }


    public CollectOrRedeemPointsView(@NonNull Context context,
            @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes, PreferenceRepo preferenceRepo) {
        super(context, attrs, defStyleAttr, defStyleRes);
        mPreferenceRepo = preferenceRepo;
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        LayoutInflater.from(getContext()).inflate(R.layout.collect_redeem_tot_points_view, this);
        ButterKnife.bind(this);
    }

    public UserDetails getUserDetails() {
        return mUserDetails;
    }

    public void setUserDetails(UserDetails userDetails) {
        mUserDetails = userDetails;
        String collectPointsTxt = "Collect points : " + mPreferenceRepo.getCollectedPoints();
        String redeemPointsTxt = "Redeem points : " + mPreferenceRepo.getRedeemedPoints();
        mCollectPoints.setText(collectPointsTxt);
        mRedeemPoints.setText(redeemPointsTxt);
    }
}
