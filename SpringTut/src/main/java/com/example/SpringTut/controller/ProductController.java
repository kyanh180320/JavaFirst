package com.example.SpringTut.controller;

import com.example.SpringTut.model.Product;
import com.example.SpringTut.repository.ProductRepository;
import com.example.SpringTut.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    private final ProductService _productService;
    public ProductController(ProductService productService){
        this._productService = productService;
    }

    @GetMapping
    public List<Product> getAllProducts(){
        return _productService.getAll();
    }

    @GetMapping("/{id}")
    public Product getProductById(Long id){
        return _productService.getById(id);
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product){
        return new ResponseEntity<>(_productService.save(product), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Product> deleteProductById(@PathVariable Long id){
        _productService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
