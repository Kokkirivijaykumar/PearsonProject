package com.te.pearson.dto;

import java.util.Comparator;

public class DateComparator implements Comparator<Shop>{

	@Override
	public int compare(Shop o1, Shop o2) {
		return o1.getNumberOfDays().compareTo(o2.getNumberOfDays());
	}



}
