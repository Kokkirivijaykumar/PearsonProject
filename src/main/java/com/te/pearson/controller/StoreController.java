package com.te.pearson.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.te.mycustomexception.CustomException;
import com.te.pearson.dto.Shop;
import com.te.pearson.dto.ShopResponses;
import com.te.pearson.service.ShopServiceImpl;

@RestController
public class StoreController {

	@Autowired
	private ShopServiceImpl service;

	@GetMapping("/getstore/{id}")
	public ResponseEntity<ShopResponses> getStoreById(@PathVariable("id") String id)throws IOException {
		
		List<Shop> storeList = service.getAllByid(id);
		ShopResponses response = new ShopResponses(200, "Sucessfull", "Below are the details", storeList);
		return new ResponseEntity<ShopResponses>(response,HttpStatus.OK);
		  }


  @GetMapping("/getstores/{sortBy}") 
  public ResponseEntity<ShopResponses> getAll(@PathVariable("sortBy") String sortBy) throws IOException {
	  List<Shop> storeList = service.getAll(sortBy);
	  ShopResponses response = new ShopResponses(200, "Sucessfull", "Below are the details", storeList);
		return new ResponseEntity<ShopResponses>(response,HttpStatus.OK);
  }
}

