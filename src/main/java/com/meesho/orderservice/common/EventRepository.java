package com.meesho.orderservice.common;

import java.util.List;

public interface EventRepository {
    void saveEvent(DomainEvent domainEvent);

    List<DomainEvent> getEvents(String orderId);
}
