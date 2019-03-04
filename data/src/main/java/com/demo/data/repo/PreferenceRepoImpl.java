package com.demo.data.repo;

import android.content.Context;

public class PreferenceRepoImpl implements PreferenceRepo {

    private final Context mContext;

    public PreferenceRepoImpl(Context context) {
        mContext = context;
    }

    @Override
    public Long getTotalPoints() {
        return mContext.getSharedPreferences(PREF_FILE, Context.MODE_PRIVATE).getLong(PREF_TOTAL_POINTS, 0);
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
    public void setTotalPoints(Long totPoints) {
        mContext.getSharedPreferences(PREF_FILE, Context.MODE_PRIVATE).edit().putLong(PREF_TOTAL_POINTS, totPoints).apply();
    }

    @Override
    public void setNickName(String nickName) {
        mContext.getSharedPreferences(PREF_FILE, Context.MODE_PRIVATE).edit().putString(PREF_NICK_NAME, nickName).apply();
    }

    @Override
    public void setEmployeeId(String employeeId) {
        mContext.getSharedPreferences(PREF_FILE, Context.MODE_PRIVATE).edit().putString(PREF_EMPLOYEE_ID, employeeId).apply();
    }
}
