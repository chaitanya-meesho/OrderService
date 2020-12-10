package com.meesho.orderservice.order;

import com.meesho.orderservice.common.Command;

public interface OrderCreateCommandAddon {
    boolean shouldExecute(OrderCreateRecord orderCreateRecord);
    Command createCommand(OrderCreateRecord orderCreateRecord);
}
