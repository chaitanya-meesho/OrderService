package com.meesho.orderservice.order;

import com.meesho.orderservice.common.Command;
import com.meesho.orderservice.common.DomainEvent;

public class OrderCreateCommand implements Command {

    private final OrderCreateDto orderCreateDto;

    public OrderCreateCommand(OrderCreateDto orderCreateDto) {
        this.orderCreateDto = orderCreateDto;
    }

    @Override
    public DomainEvent execute() {
        // Do order create operations
        // create order record

        return new OrderCreatedEvent(orderCreateDto.getOrderId(), new OrderCreateRecord());
    }
}
