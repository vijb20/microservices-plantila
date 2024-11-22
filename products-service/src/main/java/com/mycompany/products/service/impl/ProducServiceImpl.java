package com.mycompany.products.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mycompany.products.dto.ProductRequest;
import com.mycompany.products.dto.ProductResponse;
import com.mycompany.products.entities.Product;
import com.mycompany.products.repositories.ProductRepository;
import com.mycompany.products.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ProducServiceImpl implements ProductService{
    private final ProductRepository productRepository;

    ProducServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
        
    }
    @Override
    public void addProduct(ProductRequest productRequest) {
  
        var product = Product.builder()
                .sku(productRequest.getSku())
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .status(productRequest.getStatus())
                .build();

        productRepository.save(product);
        log.info("Product added: {}", product);
    }

    @Override
    public List<ProductResponse> getAllProducts() {
        var products = productRepository.findAll();

        return products.stream().map(this::mapToProductResponse).toList();    
    }
        private ProductResponse mapToProductResponse(Product product) {
            return ProductResponse.builder()
                    .id(product.getId())
                    .sku(product.getSku())
                    .name(product.getName())
                    .description(product.getDescription())
                    .price(product.getPrice())
                    .status(product.getStatus())
                    .build();
        }

}
