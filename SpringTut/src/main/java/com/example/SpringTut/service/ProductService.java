package com.example.SpringTut.service;

import com.example.SpringTut.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private final ProductRepository _productRepository;
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this._productRepository = productRepository;
    }

}
