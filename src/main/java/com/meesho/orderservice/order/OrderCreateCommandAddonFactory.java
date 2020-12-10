package com.meesho.orderservice.order;

import com.meesho.orderservice.common.EventType;

public class OrderCreateCommandAddonFactory {

    public OrderCreateCommandAddon get(EventType eventType) {
        return new PaymentInitiateCommandAddon();
    }
}
