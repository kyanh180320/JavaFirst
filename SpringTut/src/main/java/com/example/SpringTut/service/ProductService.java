package com.example.SpringTut.service;

import com.example.SpringTut.model.Product;
import com.example.SpringTut.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository _productRepository;

    public ProductService(ProductRepository productRepository) {
        this._productRepository = productRepository;
    }

    public List<Product> getAll(){
        return _productRepository.findAll();
    }

    public Product save(Product product){
        return _productRepository.save(product);
    }

    public void delete(Long id){
        _productRepository.deleteById(id);
    }

    public Product getById(Long id){
        return _productRepository.findById(id).orElseThrow(() ->new ResourceAccessException("Product not found :" + id));
    }
}
