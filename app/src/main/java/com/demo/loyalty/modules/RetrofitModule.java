package com.demo.loyalty.modules;

import com.google.gson.Gson;

import com.demo.loyalty.R;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitModule {
    private static Retrofit sApi;

    public static Retrofit retrofit() {
        if (sApi == null) {
            sApi = new Retrofit.Builder()
                    .client(OkHttpClientModule.okHttpClient())
                    .baseUrl("http://loyaltyapp-env-1.3rr7mzxk2k.eu-west-2.elasticbeanstalk.com/")
                    .addConverterFactory(GsonConverterFactory.create(new Gson()))
                    .build();
        }
        return sApi;
    }
}
