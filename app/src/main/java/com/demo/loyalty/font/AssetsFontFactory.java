package com.demo.loyalty.font;

import com.demo.loyalty.font.Font;
import com.demo.loyalty.font.FontFactory;

import android.content.res.Resources;
import android.graphics.Typeface;

import java.util.HashMap;
import java.util.Map;

import androidx.annotation.NonNull;
import uk.co.chrisjenx.calligraphy.TypefaceUtils;

public class AssetsFontFactory implements FontFactory {
    private final Resources mResources;
    private Map<Font, Typeface> mFonts;

    public AssetsFontFactory(Resources resources) {
        mResources = resources;
        mFonts = new HashMap<>();
    }

    @Override
    public Typeface getFont(@NonNull final Font fontName) {
        Typeface font = mFonts.get(fontName);
        if (font == null) {
            font = TypefaceUtils.load(mResources.getAssets(), fontName.getPath());
            mFonts.put(fontName, font);
        }

        return font;
    }

}
