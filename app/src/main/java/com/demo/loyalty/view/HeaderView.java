package com.demo.loyalty.view;

import com.demo.loyalty.R;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import butterknife.ButterKnife;

public class HeaderView extends FrameLayout {
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
    }
}
