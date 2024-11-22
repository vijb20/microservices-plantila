package com.mycompany.orders.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mycompany.orders.enities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
