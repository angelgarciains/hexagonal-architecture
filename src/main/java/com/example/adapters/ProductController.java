package com.example.adapters;

import com.example.application.ProductService;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import lombok.Getter;

@Path("/products")
public class ProductController {

    private ProductService productService;
    
    @Inject
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getProducts() {
        return productService.getProducts();
    }
}
