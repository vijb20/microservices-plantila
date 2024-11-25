package com.mycompany.notification.events;

import com.mycompany.notification.models.enums.OrderStatus;

public record OrderEvent(String orderNumber, int itemsCount, OrderStatus orderStatus) {

}
