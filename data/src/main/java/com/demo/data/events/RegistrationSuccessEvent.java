package com.demo.data.events;

import com.demo.data.model.server.UserDetails;

public class RegistrationSuccessEvent {
    private final UserDetails mEntity;

    public RegistrationSuccessEvent(UserDetails entity) {
        mEntity = entity;
    }

    public UserDetails getEntity() {
        return mEntity;
    }
}
