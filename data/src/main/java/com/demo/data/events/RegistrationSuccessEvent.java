package com.demo.data.events;

import com.demo.data.model.server.ServerRegistrationEntity;

public class RegistrationSuccessEvent {
    private final ServerRegistrationEntity mEntity;

    public RegistrationSuccessEvent(ServerRegistrationEntity entity) {
        mEntity = entity;
    }
}
