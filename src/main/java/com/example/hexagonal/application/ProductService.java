package com.example.hexagonal.application;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ProductService {
    public String getProducts() {
        return "Product 1, Product 2, Product 3";
    }
}
