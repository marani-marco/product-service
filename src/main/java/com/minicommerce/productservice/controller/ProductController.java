package com.minicommerce.productservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.minicommerce.productservice.entity.Product;
import com.minicommerce.productservice.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@PostMapping("/save")
	public Product saveProduct(@RequestBody Product product) {	
		return productService.saveProduct(product);		
	}
	
	@GetMapping("/get/{id}")
	public Optional<Product> getProductById(@PathVariable("id") String productId) {
		return productService.getProductById(productId);
	}
	
	@GetMapping("/get-by-category/{category}")
	public List<Product> getProductsByCategory(@PathVariable("category") String category) {
		return productService.getProductsByCategory(category);
	}

}
