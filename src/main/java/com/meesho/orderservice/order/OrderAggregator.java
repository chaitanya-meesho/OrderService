package com.meesho.orderservice.order;

import com.meesho.orderservice.common.DomainEvent;
import com.meesho.orderservice.common.DomainEventConsolidator;
import com.meesho.orderservice.common.DomainEventConsolidatorFactory;
import com.meesho.orderservice.common.EntityType;
import com.meesho.orderservice.common.Record;
import com.meesho.orderservice.payment.PaymentRecord;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderAggregator {

    private  DomainEventConsolidatorFactory domainEventConsolidatorFactory;

    public Order aggregateOrder(List<DomainEvent> domainEvents) {
        Order order = new Order();



        Map<EntityType, List<DomainEvent>> entityEventsMap = new HashMap<>(); // generate from mapping


        entityEventsMap.forEach((entityType, entityDomainEvents) -> {
            incorporateEntitiesInOrder(order, entityType, entityDomainEvents);
        });

        return order;
    }

    private Order incorporateEntitiesInOrder(Order order, EntityType entityType, List<DomainEvent> domainEvents) {
        DomainEventConsolidator domainEventConsolidator = domainEventConsolidatorFactory.get(entityType);
        switch (entityType){
            case PAYMENT:
                Record record = domainEventConsolidator.consolidate(domainEvents);
                order.setPaymentRecord((PaymentRecord) record);
            case ORDER:
                order.enrichFromOrderCreatedRecord((OrderCreateRecord) domainEventConsolidator.consolidate(domainEvents));
            default:
                return order;

        }
    }
}
