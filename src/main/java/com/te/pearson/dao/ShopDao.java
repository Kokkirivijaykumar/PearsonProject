package com.te.pearson.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.te.pearson.dto.MyComparator;
import com.te.pearson.dto.Shop;

public interface ShopDao {
	
	
	public List<Shop> getAllByid(String id) throws IOException;
	
	public List<Shop> getAll() throws IOException;

	/*
	 * public List<Shop> getAllByCity(String city) throws IOException;
	 * 
	 * public List<Shop> getAllByDate(String date) throws IOException;
	 */
}
