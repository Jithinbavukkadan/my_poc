package com.demo.data.events;

import com.demo.data.model.server.UserDetails;

public class VouchersSuccessEvent {
    private final UserDetails mEntity;

    public VouchersSuccessEvent(UserDetails entity) {
        mEntity = entity;
    }

    public UserDetails getEntity() {
        return mEntity;
    }
}
