package com.meesho.orderservice.common;

public enum EventType {
    ORDER_CREATED,
    ADDRESS_ADDED,
    PAYMENT_INITIATED,
    PAYMENT_SUCCESS,
    PAYMENT_PENDING,
    PAYMENT_FAILURE,
    ORDER_ABORTED,

    PAYMENT_REFUNDED,
    WALLET_REFUNDED
}
