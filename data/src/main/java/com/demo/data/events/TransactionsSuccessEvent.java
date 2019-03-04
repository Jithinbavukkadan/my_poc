package com.demo.data.events;

import com.demo.data.model.server.TransactionsResponse;

public class TransactionsSuccessEvent {
    private final TransactionsResponse mResponse;

    public TransactionsSuccessEvent(TransactionsResponse response) {
        mResponse = response;
    }

    public TransactionsResponse getResponse() {
        return mResponse;
    }
}
