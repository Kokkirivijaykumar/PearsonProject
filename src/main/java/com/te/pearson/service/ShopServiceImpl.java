package com.te.pearson.service;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.mycustomexception.CustomException;
import com.te.pearson.dao.ShopDaoImpl;
import com.te.pearson.dto.DateComparator;
import com.te.pearson.dto.MyComparator;
import com.te.pearson.dto.Shop;

@Service
public class ShopServiceImpl implements ShopService {

	@Autowired
	private ShopDaoImpl dao;

	public List<Shop> getAllByid(String id) throws IOException {

		if (id.isEmpty()) {
			throw new CustomException("Id field can't be blank. Please try again with a valid store ID");
		} else if (dao.getAllByid(id).size() <= 0) {
			throw new CustomException("Unable to find the store with the id. Please try again with a different ID");
		} else
			return dao.getAllByid(id);
	}

	public List<Shop> getAll(String sortBy) throws IOException{
		List<Shop> shopList = dao.getAll();
		if(sortBy.equalsIgnoreCase("city")) {
			Collections.sort(shopList, new MyComparator());
			return shopList;
		}else if (sortBy.equalsIgnoreCase("OpendDate") || sortBy.equalsIgnoreCase("Opened Date")) {
			Collections.sort(shopList, new DateComparator());
			return shopList;
		}else throw new CustomException("Please let us know how would you like to sort the stores.By City or Date");
}}
