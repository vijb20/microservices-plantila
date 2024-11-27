package com.mycompany.orders.dtos;

import java.util.List;

import com.mycompany.orders.enities.OrderItems;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDto {
private Long id;

    private String orderNumber;
}
