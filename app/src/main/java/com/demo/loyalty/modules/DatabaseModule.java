package com.demo.loyalty.modules;

import com.demo.data.database.LoyaltyDatabase;

import android.content.Context;

public class DatabaseModule {
    private static LoyaltyDatabase sLoyaltyDatabase;

    public static LoyaltyDatabase getLoyaltyDatabase(Context context) {
        if (sLoyaltyDatabase == null) {
            sLoyaltyDatabase = LoyaltyDatabase.getInstance(context);
        }
        return sLoyaltyDatabase;
    }
}
