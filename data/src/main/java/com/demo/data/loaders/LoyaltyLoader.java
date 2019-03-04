package com.demo.data.loaders;

public interface LoyaltyLoader<T> {
    void requestData(T data);
}
