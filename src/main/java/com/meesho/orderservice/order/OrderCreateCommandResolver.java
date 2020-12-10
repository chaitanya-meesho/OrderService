package com.meesho.orderservice.order;

import com.meesho.orderservice.common.Command;
import com.meesho.orderservice.common.EventType;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class OrderCreateCommandResolver {

    // This can be taken from properties
    private Set<EventType> eventsToBeProcessedOnOrderCreate = new HashSet<>();

    private OrderCreateCommandAddonFactory orderCreateCommandAddonFactory;

    public List<Command> resolveCommandsForOrderCreation(OrderCreateRecord orderCreateRecord) {
        return eventsToBeProcessedOnOrderCreate.stream()
                .map(eventType -> orderCreateCommandAddonFactory.get(eventType))
                .filter(orderCreateCommandAddon -> orderCreateCommandAddon.shouldExecute(orderCreateRecord))
                .map(orderCreateCommandAddon -> orderCreateCommandAddon.createCommand(orderCreateRecord))
                .collect(Collectors.toList());
    }

}
