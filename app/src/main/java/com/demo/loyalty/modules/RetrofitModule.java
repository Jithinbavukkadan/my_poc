package com.demo.loyalty.modules;

import com.demo.loyalty.R;

import retrofit2.Retrofit;

public class RetrofitModule {
    private static Retrofit sApi;

    public static Retrofit retrofit() {
        if (sApi == null) {
            sApi = new Retrofit.Builder()
                    .client(OkHttpClientModule.okHttpClient())
                    .baseUrl("")
                    .build();
        }
        return sApi;
    }
}
