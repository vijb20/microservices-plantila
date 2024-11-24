package com.mycompany.orders.service;

import java.util.List;

import com.mycompany.orders.dtos.OrderRequest;
import com.mycompany.orders.dtos.OrderResponse;

public interface OrderService {
    public OrderResponse  placeOrder(OrderRequest orderRequest);

    public List<OrderResponse> getAllOrders();
}
