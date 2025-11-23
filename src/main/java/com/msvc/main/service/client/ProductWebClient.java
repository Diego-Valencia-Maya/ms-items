package com.msvc.main.service.client;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

import org.springframework.context.annotation.Primary;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import com.msvc.main.data.ItemDao;
import com.msvc.main.data.ProductDao;
import com.msvc.main.service.ItemsService;

import lombok.AllArgsConstructor;


@AllArgsConstructor
@Service
@Primary
public class ProductWebClient implements ItemsService {
	
	private final WebClient.Builder client;

	@Override
	public List<ItemDao> convertList() {
		// TODO Auto-generated method stub
		return this.client.build().get().uri("/list").accept(MediaType.APPLICATION_JSON).retrieve()
				.bodyToFlux(ProductDao.class)
				.map(product -> new ItemDao(product, new Random().nextInt(10)+1)).collectList().block();
	} 

	@Override
	public Optional<ItemDao> getDetail(Long id) {
		// TODO Auto-generated method stub
		Map<String, Long> params = new HashMap<>();
		params.put("id", id);
		
		try {
			return Optional.ofNullable(client.build().get().uri("/{id}",params).accept(MediaType.APPLICATION_JSON)
					.retrieve().bodyToMono(ProductDao.class)
					.map(product -> new ItemDao(product, new Random().nextInt(10)+1)).block());
		} catch (WebClientResponseException e) {
			return Optional.empty();
		}
	
	}
}
