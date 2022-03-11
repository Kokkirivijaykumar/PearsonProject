package com.te.pearson.service;

import java.io.IOException;
import java.util.List;

import com.te.pearson.dto.Shop;

public interface ShopService {
	
	public List<Shop> getAllByid(String id) throws IOException;
	
	public List<Shop> getAll(String sortBy) throws IOException;


}
