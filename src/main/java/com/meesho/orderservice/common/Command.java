package com.meesho.orderservice.common;

public interface Command {
    DomainEvent execute();
}
