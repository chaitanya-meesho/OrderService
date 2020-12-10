package com.meesho.orderservice.common;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public abstract class DomainEvent {

    private String orderId;
    private LocalDateTime occurredAt;
    private EventType eventType;

    public abstract Record getRecord();
}
