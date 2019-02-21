package com.demo.loyalty.modules;

import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;

public class OkHttpClientModule {
    private static final int MAX_DISK_CACHE_SIZE = 42 * 1024 * 1024;
    private static final long CONNECTION_TIMEOUT = 15;
    private static final long READ_TIMEOUT = 15;
    private static OkHttpClient sOkHttpClient;

    public static OkHttpClient okHttpClient() {
        if (sOkHttpClient == null) {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.cache(new Cache(ApplicationModule.applicationContext().getCacheDir(), MAX_DISK_CACHE_SIZE))
                    .connectTimeout(CONNECTION_TIMEOUT, TimeUnit.SECONDS)
                    .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
                    .retryOnConnectionFailure(true);

            sOkHttpClient = builder.build();
        }
        return sOkHttpClient;
    }
}
