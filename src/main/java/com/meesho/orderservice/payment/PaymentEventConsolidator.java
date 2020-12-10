package com.meesho.orderservice.payment;

import com.meesho.orderservice.common.DomainEvent;
import com.meesho.orderservice.common.DomainEventConsolidator;
import com.meesho.orderservice.common.Record;
import java.util.List;

public class PaymentEventConsolidator implements DomainEventConsolidator {

    @Override
    public Record consolidate(List<DomainEvent> domainEvents) {

        // Directly get the last or apply custom logic / validation
        return domainEvents.get(domainEvents.size() - 1).getRecord();
    }
}
