package com.te.pearson.dto;

import java.util.Comparator;

public class MyComparator implements Comparator<Shop> {

	@Override
	public int compare(Shop o1, Shop o2) {

		return o1.getCity().compareTo(o2.getCity());
	}

}
