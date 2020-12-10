package com.meesho.orderservice.order;

import com.meesho.orderservice.common.DomainEvent;
import com.meesho.orderservice.common.Record;
import com.meesho.orderservice.common.EventType;

public class OrderCreatedEvent extends DomainEvent {

    private final OrderCreateRecord orderCreateRecord;

    public OrderCreatedEvent(String orderId, OrderCreateRecord orderCreateRecord) {
        this.orderCreateRecord = orderCreateRecord;
        setOrderId(orderId);
        setEventType(EventType.ORDER_CREATED);
    }

    @Override
    public Record getRecord() {
        return orderCreateRecord;
    }
}
