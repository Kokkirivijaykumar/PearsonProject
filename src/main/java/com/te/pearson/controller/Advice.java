package com.te.pearson.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.te.mycustomexception.CustomException;
import com.te.pearson.dto.ShopResponses;

@ControllerAdvice
public class Advice {
	
	@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(CustomException.class)
	public ResponseEntity<ShopResponses> dataIsNull(CustomException exception){
		ShopResponses response = new ShopResponses(404, exception.getMessage(), "Store not found", null);
		return new ResponseEntity<ShopResponses>(response,HttpStatus.NOT_FOUND);
		
	}
	

}
