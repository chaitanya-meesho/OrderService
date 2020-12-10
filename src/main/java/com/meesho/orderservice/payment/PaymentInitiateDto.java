package com.meesho.orderservice.payment;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PaymentInitiateDto {
    private String orderId;
    private String paymentMode;
    private double amount;
}
