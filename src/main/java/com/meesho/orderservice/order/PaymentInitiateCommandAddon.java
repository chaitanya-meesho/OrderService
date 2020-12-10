package com.meesho.orderservice.order;

import com.meesho.orderservice.common.Command;
import com.meesho.orderservice.payment.PaymentInitiateCommand;
import com.meesho.orderservice.payment.PaymentInitiateDto;

public class PaymentInitiateCommandAddon implements OrderCreateCommandAddon {

    @Override
    public boolean shouldExecute(OrderCreateRecord orderCreateRecord) {
        return orderCreateRecord.getPaymentMode() != "cod";
    }

    @Override
    public Command createCommand(OrderCreateRecord orderCreateRecord) {
        PaymentInitiateDto paymentInitiateDto = PaymentInitiateDto.builder()
                .orderId(orderCreateRecord.getOrderId())
                .paymentMode(orderCreateRecord.getPaymentMode())
                .amount(orderCreateRecord.getTotal())
                .build();

        return new PaymentInitiateCommand(paymentInitiateDto);
    }
}
