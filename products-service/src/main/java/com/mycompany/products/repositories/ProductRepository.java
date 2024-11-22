package com.mycompany.products.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mycompany.products.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>  {

}
