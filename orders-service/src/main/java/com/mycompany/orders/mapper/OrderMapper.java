package com.mycompany.orders.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import com.mycompany.orders.dtos.OrderDto;
import com.mycompany.orders.enities.Order;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface OrderMapper {
OrderDto tDto(OrderDto dto);
Order toEntity(Order order); 
}
