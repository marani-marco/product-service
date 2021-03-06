package com.minicommerce.productservice.entity;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

	@Id
	private String id;
	private String name;
	private String description;
	private String category;
	private Double price;
	private Integer quantity;
	private Boolean enabled;	
	
}
