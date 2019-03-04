package com.demo.data.events;

import com.demo.data.model.server.UserDetails;

public class CollectSuccessEvent {
    private final UserDetails mEntity;

    public CollectSuccessEvent(UserDetails entity) {
        mEntity = entity;
    }

    public UserDetails getEntity() {
        return mEntity;
    }
}
