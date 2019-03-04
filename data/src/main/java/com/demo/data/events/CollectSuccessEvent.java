package com.demo.data.events;

import com.demo.data.model.server.ServerRegistrationEntity;

public class CollectSuccessEvent {
    private final ServerRegistrationEntity mEntity;

    public CollectSuccessEvent(ServerRegistrationEntity entity) {
        mEntity = entity;
    }

    public ServerRegistrationEntity getEntity() {
        return mEntity;
    }
}
