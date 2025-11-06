package com.msvc.main.data;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ItemDao {

	private ProductDao product;
	
	private int quantity;

}
