package com.demo.data.model.server;

import java.util.List;

public class ServerTransactionsResponse {
    private List<ServerTransactionSingleEntity> mEntities;

    public List<ServerTransactionSingleEntity> getEntities() {
        return mEntities;
    }
}
