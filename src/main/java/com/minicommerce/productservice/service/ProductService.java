package com.minicommerce.productservice.service;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.minicommerce.productservice.entity.Product;
import com.minicommerce.productservice.repository.ProductRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductService {

	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	MongoTemplate mongoTemplate;
	
	public Product saveProduct(Product product) {	
		log.info("ProductService.saveProduct - " + product.toString());
		return productRepository.save(product);
	}

	public Optional<Product> getProductById(String productId) {
		log.info("ProductService.getProductById - Searched product " + productId);
		return productRepository.findById(new ObjectId(productId));
	}

	public List<Product> getProductsByCategory(String category) {
		
		log.info("ProductService.getProductsByCategory - Searched category" + category);
		Query query = new Query();
		query.addCriteria(Criteria.where("category").is(category));
		return mongoTemplate.find(query, Product.class);
	}
	
}
