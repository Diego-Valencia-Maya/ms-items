package com.msvc.main.data;

import java.util.Date;

import lombok.Data;

@Data
public class ProductDao {

	private Long id;

	private String name;

	private Double price;

	private Date createdAt;

}
