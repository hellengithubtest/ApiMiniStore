package com.api.service;

import com.api.repository.ProductRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServiceProduct {

    @NonNull
    private ProductRepository productRepository;

    public List<String> findAllNames() {
        return productRepository.findAllNames();
    }
}
