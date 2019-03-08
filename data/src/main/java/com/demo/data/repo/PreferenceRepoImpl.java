package com.demo.data.repo;

import android.content.Context;

public class PreferenceRepoImpl implements PreferenceRepo {

    private final Context mContext;

    public PreferenceRepoImpl(Context context) {
        mContext = context;
    }

    @Override
    public int getTotalPoints() {
        return mContext.getSharedPreferences(PREF_FILE, Context.MODE_PRIVATE).getInt(PREF_TOTAL_POINTS, 0);
    }

    @Override
    public String getNickName() {
        return mContext.getSharedPreferences(PREF_FILE, Context.MODE_PRIVATE).getString(PREF_NICK_NAME, null);
    }

    @Override
    public String getEmployeeId() {
        return mContext.getSharedPreferences(PREF_FILE, Context.MODE_PRIVATE).getString(PREF_EMPLOYEE_ID, null);
    }

    @Override
    public void setTotalPoints(int totPoints) {
        mContext.getSharedPreferences(PREF_FILE, Context.MODE_PRIVATE).edit().putInt(PREF_TOTAL_POINTS, totPoints).apply();
    }

    @Override
    public void setNickName(String nickName) {
        mContext.getSharedPreferences(PREF_FILE, Context.MODE_PRIVATE).edit().putString(PREF_NICK_NAME, nickName).apply();
    }

    @Override
    public void setEmployeeId(String employeeId) {
        mContext.getSharedPreferences(PREF_FILE, Context.MODE_PRIVATE).edit().putString(PREF_EMPLOYEE_ID, employeeId).apply();
    }

    @Override
    public void setRedeemToVouchers(Boolean value) {
        mContext.getSharedPreferences(PREF_FILE, Context.MODE_PRIVATE).edit().putBoolean(PREF_REDEEM_VOUCHER, value).apply();
    }

    @Override
    public Boolean isRedeemedToVouchers() {
        return mContext.getSharedPreferences(PREF_FILE, Context.MODE_PRIVATE).getBoolean(PREF_REDEEM_VOUCHER, false);
    }

    @Override
    public void reset() {
        mContext.getSharedPreferences(PREF_FILE, Context.MODE_PRIVATE).edit().clear().commit();
    }
}
