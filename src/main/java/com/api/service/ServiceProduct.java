package com.api.service;

import com.api.product.schema.Product;
import com.api.repository.ProductRepository;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ServiceProduct {

    @NonNull
    private ProductRepository productRepository;

    public List<Product> findByNameContainingIgnoreCase(String name) {
        return productRepository
                .findByNameContainingIgnoreCase(name)
                .stream()
                .map(entity -> {
                    Product product = new Product();
                    product.setCost(entity.getCost());
                    product.setId(entity.getId());
                    product.setName(entity.getName());
                    return product;
                }).collect(Collectors.toList());
    }

    public List<Product> findAll() {
        return productRepository
                .findAll()
                .stream()
                .map(entity -> {
                    Product product = new Product();
                    product.setCost(entity.getCost());
                    product.setId(entity.getId());
                    product.setName(entity.getName());
                    return product;
                }).collect(Collectors.toList());
    }

    public Long getCount() {
        return productRepository.count();
    }
}
