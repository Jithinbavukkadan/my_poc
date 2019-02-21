package com.demo.loyalty.modules;


import org.greenrobot.eventbus.EventBus;

public class EventBusModule {
    private static EventBus sEventBus = EventBus.getDefault();

    public static EventBus eventBus() {
        return sEventBus;
    }
}
