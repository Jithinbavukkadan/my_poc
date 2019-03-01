package com.demo.loyalty;


import com.journeyapps.barcodescanner.CaptureActivity;

import android.os.Bundle;

/**
 * Only used in order to be able to capture barcodes in  portrait mode
 */
public class BarcodeCaptureActivity extends CaptureActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
/*
        int padding = getResources().getDimensionPixelSize(R.dimen.capture_text_padding);
        findViewById(R.id.zxing_status_view).setPadding(padding, padding, padding, padding);*/
    }

}
