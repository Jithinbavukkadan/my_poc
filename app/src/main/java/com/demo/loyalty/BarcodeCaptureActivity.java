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
    }

}
