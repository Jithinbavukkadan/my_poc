package com.demo.data.events;

import com.demo.data.model.server.UserDetails;

public class UserInfoSuccessEvent {
    private final UserDetails mEntity;

    public UserInfoSuccessEvent(UserDetails entity) {
        mEntity = entity;
    }

    public UserDetails getEntity() {
        return mEntity;
    }
}
