package com.demo.data.events;

import com.demo.data.model.server.ServerTransactionsResponse;

public class TransactionsSuccessEvent {
    private final ServerTransactionsResponse mResponse;

    public TransactionsSuccessEvent(ServerTransactionsResponse response) {
        mResponse = response;
    }

    public ServerTransactionsResponse getResponse() {
        return mResponse;
    }
}
