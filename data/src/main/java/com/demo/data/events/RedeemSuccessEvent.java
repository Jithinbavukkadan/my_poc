package com.demo.data.events;

import com.demo.data.model.server.UserDetails;

public class RedeemSuccessEvent {
    private final UserDetails mEntity;

    public RedeemSuccessEvent(UserDetails entity) {
        mEntity = entity;
    }

    public UserDetails getEntity() {
        return mEntity;
    }
}
