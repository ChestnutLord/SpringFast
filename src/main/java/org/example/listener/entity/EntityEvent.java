package org.example.listener.entity;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

import java.time.Clock;

public class EntityEvent extends ApplicationEvent {
    // Ивент это набор полей
    @Getter
    private final AccessType accessType;

    public EntityEvent(Object source, AccessType accessType) {
        super(source);
        this.accessType = accessType;
    }
}
