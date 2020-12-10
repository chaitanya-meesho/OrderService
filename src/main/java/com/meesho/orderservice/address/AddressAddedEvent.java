package com.meesho.orderservice.address;

import com.meesho.orderservice.common.DomainEvent;
import com.meesho.orderservice.common.Record;
import com.meesho.orderservice.common.EventType;

public class AddressAddedEvent extends DomainEvent {

    private final AddressRecord addressRecord;

    public AddressAddedEvent(String orderId, AddressRecord addressRecord) {
        this.addressRecord = addressRecord;
        setOrderId(orderId);
        setEventType(EventType.ADDRESS_ADDED);
    }

    @Override
    public Record getRecord() {
        return addressRecord;
    }
}
