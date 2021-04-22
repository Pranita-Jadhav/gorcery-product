package com.mindbowser.grocery.store.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindbowser.grocery.store.management.product.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {

}
