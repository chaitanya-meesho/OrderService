package com.meesho.orderservice.payment;

import com.meesho.orderservice.common.Command;
import com.meesho.orderservice.common.DomainEvent;

public class PaymentInitiateCommand implements Command {

    private final PaymentInitiateDto paymentInitiateDto;

    public PaymentInitiateCommand(PaymentInitiateDto paymentInitiateDto) {
        this.paymentInitiateDto = paymentInitiateDto;
    }

    @Override
    public DomainEvent execute() {
        // do epg calls
        return new PaymentInitiatedEvent(paymentInitiateDto.getOrderId(), new PaymentRecord());
    }
}
