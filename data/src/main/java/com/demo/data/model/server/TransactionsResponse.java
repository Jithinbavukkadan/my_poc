package com.demo.data.model.server;

import java.util.List;

public class TransactionsResponse {
    private List<TransactionSingleEntity> mEntities;

    public List<TransactionSingleEntity> getEntities() {
        return mEntities;
    }
}
