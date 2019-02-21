package com.demo.loyalty.modules;

import com.demo.data.api.ApiService;

public class ApiServiceModule {
    private static ApiService sApiService;

    public static ApiService getApiService() {
        if (sApiService == null) {
            sApiService = RetrofitModule.retrofit().create(ApiService.class);
        }
        return sApiService;
    }

}
