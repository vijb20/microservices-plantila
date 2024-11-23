package com.mycompany.products.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.products.dto.ProductRequest;
import com.mycompany.products.dto.ProductResponse;
import com.mycompany.products.service.ProductService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
@Tag(name = "Producto", description = "Descripcion personalizada del controller producto")
public class ProductoController {

    private final ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation( summary = "Registrar producto", 
    description ="Metodo encargado de registrar un producto",
    tags = {"Producto"},
    requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
        description= "Request del producto",
        required = true,
        content = @Content(
            mediaType = "application/json",
            schema = @Schema(implementation = ProductRequest.class)
        )
    ),
    responses = {
        @ApiResponse(
            responseCode = "201",
            description = "Create"
        )
    }
    )
    public void addProduct(@RequestBody ProductRequest productRequest) {
        this.productService.addProduct(productRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation( summary = "Listar productos", 
    description ="Metodo encargado de listar todos los productos",
    tags = {"Producto"},
    responses = {
        @ApiResponse(
            responseCode = "200",
            description = "Successful",
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = ProductResponse.class)
            )
        )
    }
    )
    public List<ProductResponse> getAllProducts() {
        return this.productService.getAllProducts();
    }
}
