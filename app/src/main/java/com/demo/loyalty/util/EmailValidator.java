package com.demo.loyalty.util;

import android.text.TextUtils;
import android.util.Patterns;

public class EmailValidator {
    public static boolean isValidEmailAddress(String email) {
        return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }
}
