package com.meesho.orderservice.order;

import com.meesho.orderservice.common.Record;
import java.util.List;
import lombok.Data;

@Data
public class OrderCreateRecord implements Record {
    private String orderId;
    private double total;
    private String paymentMode;
    private String addressId;
    private List<OrderDetailRecord> orderDetailRecords;
}
