package org.example.listener.entity;

import org.springframework.context.ApplicationEvent;

import java.time.Clock;

public class EntityEvent extends ApplicationEvent {

    // Ивент это набор полей

    private final AccessType accessType;

    public EntityEvent(Object source, AccessType accessType) {
        super(source);
        this.accessType = accessType;
    }

    public AccessType getAccessType() {
        return accessType;
    }
}
