package com.meesho.orderservice.order;

import com.meesho.orderservice.address.AddressRecord;
import com.meesho.orderservice.payment.PaymentRecord;
import java.util.List;
import lombok.Data;

@Data
public class Order {
    private String orderId;
    private String total;
    private String paymentMode;
    private String addressId;
    private List<OrderDetailRecord> orderDetailRecords;
    private AddressRecord addressRecord;
    private PaymentRecord paymentRecord;

    public void enrichFromOrderCreatedRecord(OrderCreateRecord orderCreateRecord) {

    }
}
