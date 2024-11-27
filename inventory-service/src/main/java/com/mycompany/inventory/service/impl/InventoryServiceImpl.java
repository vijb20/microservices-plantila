package com.mycompany.inventory.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mycompany.inventory.dtos.BaseResponse;
import com.mycompany.inventory.dtos.OrderItemRequest;
import com.mycompany.inventory.entities.Inventory;
import com.mycompany.inventory.repositories.InventoryRepository;
import com.mycompany.inventory.service.InventoryService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InventoryServiceImpl implements InventoryService{
    private final InventoryRepository inventoryRepository;

    @Override
    public boolean isInStock(String sku) {
        var inventory = inventoryRepository.findBySku(sku);

        return inventory.filter(value -> value.getQuantity() > 0).isPresent();
    }

    @Override
    public BaseResponse areInStock(List<OrderItemRequest> orderItems) {
        
        var errorList = new ArrayList<String>();

        List<String> skus = orderItems.stream().map(OrderItemRequest::getSku).toList();

        List<Inventory> inventoryList = inventoryRepository.findBySkuIn(skus);

        orderItems.forEach(orderItem -> {
            var inventory = inventoryList.stream().filter(value -> value.getSku().equals(orderItem.getSku())).findFirst();
            if (inventory.isEmpty()) {
                errorList.add("Product with sku " + orderItem.getSku() + " does not exist");
            } else if (inventory.get().getQuantity() < orderItem.getQuantity()) {
                errorList.add("Product with sku " + orderItem.getSku() + " has insufficient quantity");
            }
        });

        return !errorList.isEmpty() ? new BaseResponse(errorList.toArray(new String[0])) : new BaseResponse(null);
    }

}
