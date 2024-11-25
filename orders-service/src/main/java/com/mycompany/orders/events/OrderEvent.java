package com.mycompany.orders.events;

import com.mycompany.orders.enums.OrderStatus;

public record OrderEvent(String orderNumber, int itemsCount, OrderStatus orderStatus) {

}
