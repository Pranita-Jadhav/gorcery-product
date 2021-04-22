package com.mindbowser.grocery.store.management.product.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindbowser.grocery.store.management.common.constant.CommonCostant;
import com.mindbowser.grocery.store.management.common.constant.ProductConstant;
import com.mindbowser.grocery.store.management.product.entity.ProductEntity;
import com.mindbowser.grocery.store.management.product.service.ProductService;
import com.mindbowser.grocery.store.management.response.Response;
import com.mindbowser.grocery.store.management.utility.TokenService;

import lombok.extern.slf4j.Slf4j;

@RestController
@CrossOrigin
@Slf4j
@RequestMapping("/home/product")
public class ProductController {
	@Autowired
	ProductService productService;

	@Autowired
	TokenService tokenService;

	@PostMapping("/create")
	public Response add(@Valid @RequestBody ProductEntity product, @RequestHeader String token) {
		try {
			String decodeToken = tokenService.getUserIdFromToken(token);
			ProductEntity response = productService.createProduct(product, decodeToken);
			if (response != null) {
				return new Response<>(ProductConstant.PRODUCT_CREATED_MSG, HttpServletResponse.SC_OK,
						CommonCostant.SUCCESS, response);
			} else {
				return new Response<>(ProductConstant.USER_NOT_AUTHORIZED_MSG, "Not Authorized !",
						HttpServletResponse.SC_EXPECTATION_FAILED, CommonCostant.FAILED);
			}
		} catch (Exception err) {
			log.error("FAILED TO FETCH CUSTOMER");
			return new Response<>(ProductConstant.FAILED, err.getMessage(), HttpServletResponse.SC_EXPECTATION_FAILED,
					CommonCostant.FAILED);
		}

	}

	@PostMapping("/delete")
	public Response delete(@RequestBody Integer id, @RequestHeader String token) {
		try {
			String decodeToken = tokenService.getUserIdFromToken(token);
			ProductEntity response = productService.deleteNote(id, decodeToken);
			if (response != null) {
				return new Response<>(ProductConstant.PRODUCT_DELETED_MSG, HttpServletResponse.SC_OK,
						CommonCostant.SUCCESS, response);
			} else {
				return new Response<>(ProductConstant.USER_NOT_AUTHORIZED_MSG, "Not Authorized !",
						HttpServletResponse.SC_EXPECTATION_FAILED, CommonCostant.FAILED);
			}
		} catch (Exception err) {
			log.error("FAILED TO FETCH CUSTOMER");
			return new Response<>(ProductConstant.FAILED, err.getMessage(), HttpServletResponse.SC_EXPECTATION_FAILED,
					CommonCostant.FAILED);
		}
	}

	@GetMapping("/findAll")
	public Response getListOfProducts(@RequestHeader String token) {
		try {
			String decodeToken = tokenService.getUserIdFromToken(token);
			List<ProductEntity> response = productService.getProductList(decodeToken);
			if (response != null) {
				return new Response<>(ProductConstant.PRODUCT_FETCHED_MSG, HttpServletResponse.SC_OK,
						CommonCostant.SUCCESS, response);
			} else {
				return new Response<>(ProductConstant.USER_NOT_AUTHORIZED_MSG, "Not Authorized !",
						HttpServletResponse.SC_EXPECTATION_FAILED, CommonCostant.FAILED);
			}
		} catch (Exception err) {
			log.error("FAILED TO FETCH CUSTOMER");
			return new Response<>(ProductConstant.FAILED, err.getMessage(), HttpServletResponse.SC_EXPECTATION_FAILED,
					CommonCostant.FAILED);
		}
	}

	@PutMapping("/update")
	public Response update(@Valid @RequestBody ProductEntity product, @RequestHeader String token) {

		try {
			String decodeToken = tokenService.getUserIdFromToken(token);
			ProductEntity response = productService.updateNote(product, decodeToken);
			productService.updateNote(product, decodeToken);
			if (response != null) {
				return new Response<>(ProductConstant.PRODUCT_FETCHED_MSG, HttpServletResponse.SC_OK,
						CommonCostant.SUCCESS, response);
			} else {
				return new Response<>(ProductConstant.USER_NOT_AUTHORIZED_MSG, "Not Authorized !",
						HttpServletResponse.SC_EXPECTATION_FAILED, CommonCostant.FAILED);
			}

		} catch (Exception err) {
			log.error("FAILED TO FETCH CUSTOMER");
			return new Response<>(ProductConstant.FAILED, err.getMessage(), HttpServletResponse.SC_EXPECTATION_FAILED,
					CommonCostant.FAILED);
		}
	}
}
