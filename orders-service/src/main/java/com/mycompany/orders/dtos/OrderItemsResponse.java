package com.mycompany.orders.dtos;

public record OrderItemsResponse(Long id, String sku, Double price, Long quantity) {

}
