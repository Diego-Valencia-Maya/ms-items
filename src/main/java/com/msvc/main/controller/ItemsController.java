package com.msvc.main.controller;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.msvc.main.data.ItemDao;
import com.msvc.main.service.ItemsService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/items")
public class ItemsController {

	final private ItemsService productService;

	@GetMapping("/list")
	public ResponseEntity<List<ItemDao>> getProductsList() {
		return ResponseEntity.ok(productService.convertList());
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getItemDetail(@PathVariable Long id) {
		Optional<ItemDao> product = productService.getDetail(id);
		if (product.isPresent()) {
			return ResponseEntity.ok(product.orElseThrow());
		}
		return ResponseEntity.status(404).body(Collections.singletonMap("message", "Producto no encontrado"));
	}

	/*
	 * @GetMapping public ResponseEntity<List<?>> getList() { return
	 * ResponseEntity.ok(productService.convertList()); }
	 * 
	 * @GetMapping("/{id}") public ResponseEntity<?> getDetail(@PathVariable Long
	 * id) { Optional<ProductDao> product = productService.convert(id); if
	 * (product.isPresent()) { return ResponseEntity.ok(product.orElseThrow()); }
	 * return ResponseEntity.notFound().build(); }
	 */
}
