package com.meesho.orderservice.payment;

import com.meesho.orderservice.common.DomainEvent;
import com.meesho.orderservice.common.Record;
import com.meesho.orderservice.common.EventType;

public class PaymentInitiatedEvent extends DomainEvent {

    private final PaymentRecord paymentRecord;

    public PaymentInitiatedEvent(String orderId, PaymentRecord paymentRecord) {
        this.paymentRecord = paymentRecord;
        setOrderId(orderId);
        setEventType(EventType.PAYMENT_INITIATED);
    }

    @Override
    public Record getRecord() {
        return paymentRecord;
    }
}
