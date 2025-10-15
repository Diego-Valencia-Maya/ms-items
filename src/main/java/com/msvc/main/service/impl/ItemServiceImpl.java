package com.msvc.main.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.msvc.main.data.ItemDao;
import com.msvc.main.data.ProductDao;
import com.msvc.main.service.ItemsService;
import com.msvc.main.service.client.ProductClient;

import feign.FeignException;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ItemServiceImpl implements ItemsService{

	/*
	 * @Autowired private ProductRepository productRepository;
	 */
	
	final private ProductClient productClient;

	@Override
	public List<ItemDao> convertList(){
		return productClient.getAll().stream().map(p->{
			//Random random = new Random();
			return new ItemDao(p, new Random().nextInt(10)+1);
		}).collect(Collectors.toList());
	}
	
	@Override
	public Optional<ItemDao> getDetail(Long id){
		try {
			ProductDao productDao = productClient.getProductDetail(id);
			return Optional.of( new ItemDao(productDao, new Random().nextInt(10)+1));
		} catch (FeignException e) {
			return Optional.empty();
		}
	}
	
}
