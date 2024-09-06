package com.infnet.petfriend.event;

import java.time.Instant;

public abstract class BaseEvent {
    private final String id;
    private final Instant timestamp;

    public BaseEvent(String id) {
        this.id = id;
        this.timestamp = Instant.now();
    }

    public String getId() {
        return id;
    }

    public Instant getTimestamp() {
        return timestamp;
    }
}
