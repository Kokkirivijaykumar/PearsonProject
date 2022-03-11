package com.te.pearson.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Shop {

	private String storeId;
	private String postcode;
	private String city;
	private String Address;
	private String openedDate;
	private Long numberOfDays;



}
