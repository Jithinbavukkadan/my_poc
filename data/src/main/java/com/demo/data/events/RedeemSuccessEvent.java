package com.demo.data.events;

import com.demo.data.model.server.ServerRegistrationEntity;

public class RedeemSuccessEvent {
    private final ServerRegistrationEntity mEntity;

    public RedeemSuccessEvent(ServerRegistrationEntity entity) {
        mEntity = entity;
    }

    public ServerRegistrationEntity getEntity() {
        return mEntity;
    }
}
