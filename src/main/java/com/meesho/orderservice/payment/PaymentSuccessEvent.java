package com.meesho.orderservice.payment;

import com.meesho.orderservice.common.DomainEvent;
import com.meesho.orderservice.common.Record;
import com.meesho.orderservice.common.EventType;

public class PaymentSuccessEvent extends DomainEvent {

    private final PaymentRecord paymentRecord;

    public PaymentSuccessEvent(PaymentRecord paymentRecord) {
        this.paymentRecord = paymentRecord;
        setEventType(EventType.PAYMENT_SUCCESS);
    }

    @Override
    public Record getRecord() {
        return paymentRecord;
    }
}
