package com.api.repository;

import com.api.config.entity.EntityProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<EntityProduct, Long> {

    List<EntityProduct> findByNameContainingIgnoreCase(String name);

    List<EntityProduct> findAll();

    List<String> findNames();
}
