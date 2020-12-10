package com.meesho.orderservice.payment;

import com.meesho.orderservice.common.Record;
import lombok.Data;

@Data
public class PaymentRecord implements Record {
    private String epgId;
    private PaymentStatus paymentStatus;
    private String paymentMode;
    private double amount;
}
