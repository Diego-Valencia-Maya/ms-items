package com.msvc.main.service.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.msvc.main.data.ProductDao;

@FeignClient(url = "localhost:8080", name = "ms-products")
public interface ProductClient {

	@GetMapping("/api/products/list")
	List<ProductDao> getAll();
	
	@GetMapping("/api/products/{id}")
	public ProductDao getProductDetail(@PathVariable Long id);
	
}
