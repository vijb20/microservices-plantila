package com.mycompany.inventory.service;


import java.util.List;

import com.mycompany.inventory.dtos.BaseResponse;
import com.mycompany.inventory.dtos.OrderItemRequest;

public interface InventoryService {
    public boolean isInStock(String sku);
    public BaseResponse areInStock(List<OrderItemRequest> orderItems);
}
