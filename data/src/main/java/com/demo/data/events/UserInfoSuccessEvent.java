package com.demo.data.events;

import com.demo.data.model.server.ServerRegistrationEntity;
import com.demo.data.model.server.ServerTransactionsResponse;

public class UserInfoSuccessEvent {
    private final ServerRegistrationEntity mEntity;

    public UserInfoSuccessEvent(ServerRegistrationEntity entity) {
        mEntity = entity;
    }

    public ServerRegistrationEntity getEntity() {
        return mEntity;
    }
}
