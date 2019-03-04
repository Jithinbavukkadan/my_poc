package com.demo.data.api;

import androidx.annotation.NonNull;

public interface ApiCallback<T> {

    void onSuccess(@NonNull T successType);

    void onError(@NonNull ApiError apiError);

    void onNoContentAvailable();

    void onNetworkError();

    void onUnknownError();

}
