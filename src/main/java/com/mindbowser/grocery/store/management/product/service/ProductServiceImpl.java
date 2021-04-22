package com.mindbowser.grocery.store.management.product.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindbowser.grocery.store.management.product.entity.ProductEntity;
import com.mindbowser.grocery.store.management.repository.ProductRepository;
import com.mindbowser.grocery.store.management.repository.SuperAdminRepository;
import com.mindbowser.grocery.store.management.superadmin.entity.SuperAdmin;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	SuperAdminRepository superAdminRepository;

	@Autowired
	ProductRepository productRepository;

	@Override
	public ProductEntity createProduct(@Valid ProductEntity productInput, String decodeToken) {
		Optional<SuperAdmin> user = superAdminRepository.findByEmail(decodeToken);
		ProductEntity productEntity = new ProductEntity(productInput);
		productRepository.save(productEntity);
		return productEntity;

	}

	@Override
	public ProductEntity deleteNote(Integer id, String decodeToken) {
		Optional<ProductEntity> product = productRepository.findById(id);

		product.get().setIsDelete(true);
		productRepository.save(product.get());
		return product.get();
	}

	@Override
	public List<ProductEntity> getProductList(String decodeToken) {
		List<ProductEntity> list = productRepository.findAll();
		return list;
	}

	@Override
	public ProductEntity updateNote(@Valid ProductEntity product, String decodeToken) {
		return null;
	}

}
