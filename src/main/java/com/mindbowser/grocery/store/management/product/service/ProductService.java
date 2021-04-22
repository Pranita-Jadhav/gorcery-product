package com.mindbowser.grocery.store.management.product.service;

import java.util.List;

import javax.validation.Valid;

import com.mindbowser.grocery.store.management.product.entity.ProductEntity;

public interface ProductService {

	ProductEntity createProduct(@Valid ProductEntity product, String decodeToken);

	ProductEntity deleteNote(Integer id, String decodeToken);

	List<ProductEntity> getProductList(String decodeToken);

	ProductEntity updateNote(@Valid ProductEntity product, String decodeToken);

}
