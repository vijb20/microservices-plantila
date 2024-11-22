package com.mycompany.products.service;

import java.util.List;

import com.mycompany.products.dto.ProductRequest;
import com.mycompany.products.dto.ProductResponse;

public interface ProductService {
public void addProduct(ProductRequest productRequest);
public List<ProductResponse> getAllProducts();
}
