package com.demo.data.events;

import com.demo.data.model.server.TransactionSingleEntity;

import java.util.List;

public class TransactionsSuccessEvent {
    private final List<TransactionSingleEntity> mResponse;

    public TransactionsSuccessEvent(List<TransactionSingleEntity> response) {
        mResponse = response;
    }

    public List<TransactionSingleEntity> getResponse() {
        return mResponse;
    }
}
