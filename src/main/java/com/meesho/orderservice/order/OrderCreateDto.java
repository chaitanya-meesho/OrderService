package com.meesho.orderservice.order;

import com.meesho.orderservice.cart.Cart;
import lombok.Data;

@Data
public class OrderCreateDto {
    private String orderId;
    private Cart cart;
    private String addressId;
    private String senderId;
    private double marginAmount;
}
