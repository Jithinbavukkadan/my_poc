package com.demo.loyalty.view;

import com.demo.loyalty.R;

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
    @BindView(R.id.points_tv)
    TextView mPoints;

    public HeaderView(@androidx.annotation.NonNull Context context) {
        this(context, null);
    }

    public HeaderView(@androidx.annotation.NonNull Context context,
            @androidx.annotation.Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public HeaderView(@androidx.annotation.NonNull Context context,
            @androidx.annotation.Nullable AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public HeaderView(@androidx.annotation.NonNull Context context,
            @androidx.annotation.Nullable AttributeSet attrs, int defStyleAttr,
            int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        LayoutInflater.from(context).inflate(R.layout.header_view, this);
        ButterKnife.bind(this);
        countAnimation(0, 1000, mPoints);
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
