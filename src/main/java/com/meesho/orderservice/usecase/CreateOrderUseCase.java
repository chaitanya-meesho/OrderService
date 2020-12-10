package com.meesho.orderservice.usecase;

import com.meesho.orderservice.common.Command;
import com.meesho.orderservice.common.DomainEvent;
import com.meesho.orderservice.common.EventRepository;
import com.meesho.orderservice.order.Order;
import com.meesho.orderservice.order.OrderAggregator;
import com.meesho.orderservice.order.OrderCreateCommand;
import com.meesho.orderservice.order.OrderCreateCommandResolver;
import com.meesho.orderservice.order.OrderCreateDto;
import com.meesho.orderservice.order.OrderCreateRecord;
import java.util.LinkedList;
import java.util.List;

public class CreateOrderUseCase {

    private EventRepository eventRepository;
    private OrderCreateCommandResolver orderCreateCommandResolver;
    private OrderAggregator orderAggregator;

    public Order createOrder(OrderCreateRequest orderCreateRequest) {
        // validate cart
        // Create OrderCreateDto
        return createOrder(new OrderCreateDto());
    }

    private Order createOrder(OrderCreateDto orderCreateDto) {
        List<DomainEvent> domainEvents = new LinkedList<>();
        Command orderCreateCommand = new OrderCreateCommand(orderCreateDto);
        DomainEvent orderCreateEvent = orderCreateCommand.execute();
        eventRepository.saveEvent(orderCreateEvent);
        domainEvents.add(orderCreateEvent);

        List<Command> commands = orderCreateCommandResolver.resolveCommandsForOrderCreation((OrderCreateRecord) orderCreateEvent.getRecord());

        // Get futures for all this commands
        // resolve futures
        // on success persist and add to domain event
        // on failure of any event execute order abort command

        return orderAggregator.aggregateOrder(domainEvents);
    }
}
