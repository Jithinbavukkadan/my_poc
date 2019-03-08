package com.demo.data.repo;

public interface PreferenceRepo {
    String PREF_FILE = "loyalty_pref_file";
    String PREF_TOTAL_POINTS = "pref_total_points";
    String PREF_NICK_NAME = "pref_nick_name";
    String PREF_EMPLOYEE_ID = "pref_employee_id";
    String PREF_REDEEM_VOUCHER = "pref_redeem_to_voucher";

    int getTotalPoints();

    String getNickName();

    String getEmployeeId();

    void setTotalPoints(int totPoints);

    void setNickName(String nickName);

    void setEmployeeId(String employeeId);

    void setRedeemToVouchers(Boolean value);

    Boolean isRedeemedToVouchers();

    void reset();
}
