package com.msvc.main.service;

import java.util.List;
import java.util.Optional;

import com.msvc.main.data.ItemDao;

public interface ItemsService {

	public List<ItemDao> convertList();
	
	public Optional<ItemDao> getDetail(Long id);
}
