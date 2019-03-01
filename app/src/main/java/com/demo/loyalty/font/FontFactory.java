package com.demo.loyalty.font;

import android.graphics.Typeface;

import androidx.annotation.NonNull;

/**
 * Provides typefaces based on their name
 */
public interface FontFactory {

    enum Roboto implements Font {
        LIGHT("fonts/Roboto-Light.ttf"),
        REGULAR("fonts/Roboto-Regular.ttf");

        private String mPath;

        Roboto(String path) {
            mPath = path;
        }


        @Override
        public String getPath() {
            return mPath;
        }

    }

    Typeface getFont(@NonNull Font fontName);
}
