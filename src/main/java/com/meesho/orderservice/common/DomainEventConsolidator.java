package com.meesho.orderservice.common;

import java.util.List;

public interface DomainEventConsolidator {

    Record consolidate(List<DomainEvent> domainEvents);
}
