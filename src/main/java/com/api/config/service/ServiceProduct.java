package com.api.config.service;

import com.api.config.entity.EntityProduct;
import com.api.endpoint.ProductEndpoint;
import com.api.repository.ProductRepository;
import com.api.product.schema.Product;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.eclipse.jdt.internal.compiler.env.ISourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ServiceProduct {

    @NonNull
    private ProductRepository productRepository;

    public List<Product> findByNameContainingIgnoreCase(String name) {
        System.out.println("List Service Product" );
        List<EntityProduct> listEntity = productRepository.findAll();

        System.out.println("List of Entity" + listEntity);
        List<Product> list = new ArrayList<Product>();

/*

        for (EntityProduct eProduct : list) {
            productList.add(new Product().setName(eProduct.getName().);
            System.out.println("Варианты: ");
            error.getS().forEach(System.out::println);
        }
*/
        return list;
    }

    public List<Product> findAll() {
        List<Product> list = new ArrayList<Product>();
        return list;
    }
}
