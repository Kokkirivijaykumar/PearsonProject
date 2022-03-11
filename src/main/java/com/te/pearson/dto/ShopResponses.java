package com.te.pearson.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShopResponses {

	private int statusCode;
	private String msg;
	private String description;
	private List<Shop> shop;


}
