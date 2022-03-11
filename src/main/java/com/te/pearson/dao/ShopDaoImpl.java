package com.te.pearson.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.te.pearson.dto.MyComparator;
import com.te.pearson.dto.Shop;

@Repository
public class ShopDaoImpl implements ShopDao {
	
	private LocalDate today = LocalDate.now();

	public List<Shop> getAllByid(String id) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("src/main/resources/stores.csv"));
		String details = "";
		List<Shop> al = new ArrayList<Shop>();

		while ((details = br.readLine()) != null) {
			String[] data = details.split(",");
			Shop c = new Shop();
			c.setStoreId(data[0]);
			c.setPostcode(data[1]);

			c.setCity(data[2]);
			c.setAddress(data[3]);
			c.setOpenedDate(data[4]);
			String[] s=c.getOpenedDate().split("-");
			
			 int year=Integer.parseInt(s[2]);
			 int month=Integer.parseInt(s[1]);
			 int day=Integer.parseInt(s[0]);
			LocalDate oldDate= LocalDate.of(year, month, day);
			long db = ChronoUnit.DAYS.between(oldDate, today);
			c.setNumberOfDays(db);

			if (id.equalsIgnoreCase(data[0])) {
				al.add(c);
			}

		}
		return al;
	}

	public List<Shop> getAll() throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("src/main/resources/stores.csv"));
		String details = "";
		List<Shop> al = new ArrayList<Shop>();

		while ((details = br.readLine()) != null) {
			String[] data = details.split(",");
			Shop c = new Shop();

			c.setStoreId(data[0]);

			c.setPostcode(data[1]);

			c.setCity(data[2]);
			c.setAddress(data[3]);
			c.setOpenedDate(data[4]);
			String[] s=c.getOpenedDate().split("-");
			
			 int year=Integer.parseInt(s[2]);
			 int month=Integer.parseInt(s[1]);
			 int day=Integer.parseInt(s[0]);
			LocalDate oldDate= LocalDate.of(year,month, day);
			long db = ChronoUnit.DAYS.between(oldDate, today);
			c.setNumberOfDays(db);
			al.add(c);
			Collections.sort(al, new MyComparator());

		}
		return al;
	}
	
	
	
	
	
	

//	public List<Shop> getAllByCity(String city) throws IOException {
//
//		BufferedReader br = new BufferedReader(new FileReader("src/main/resources/stores.csv"));
//		String details = "";
//		List<Shop> al = new ArrayList<Shop>();
//
//		while ((details = br.readLine()) != null) {
//			String[] data = details.split(",");
//			Shop c = new Shop();
//
//			c.setStoreId(data[0]);
//
//			c.setPostcode(data[1]);
//
//			c.setCity(data[2]);
//			c.setAddress(data[3]);
//			c.setOpenedDate(data[4]);
//			String[] s=c.getOpenedDate().split("-");
//			
//			 int year=Integer.parseInt(s[2]);
//			 int month=Integer.parseInt(s[1]);
//			 int day=Integer.parseInt(s[0]);
//			LocalDate oldDate= LocalDate.of(year, month, day);
//			long db = ChronoUnit.DAYS.between(oldDate, today);
//			c.setNumberOfDays(db);
//			if (city.equalsIgnoreCase(data[2])) {
//				al.add(c);
//			}
//
//		}
//		return al;
//	}
//
//	public List<Shop> getAllByDate(String date) throws IOException {
//
//		BufferedReader br = new BufferedReader(new FileReader("src/main/resources/stores.csv"));
//		String details = "";
//		List<Shop> al = new ArrayList<Shop>();
//
//		while ((details = br.readLine()) != null) {
//			String[] data = details.split(",");
//			Shop c = new Shop();
//
//			c.setStoreId(data[0]);
//
//			c.setPostcode(data[1]);
//
//			c.setCity(data[2]);
//			c.setAddress(data[3]);
//			c.setOpenedDate(data[4]);
//			String[] s=c.getOpenedDate().split("-");
//			
//			 int year=Integer.parseInt(s[2]);
//			 int month=Integer.parseInt(s[1]);
//			 int day=Integer.parseInt(s[0]);
//			LocalDate oldDate= LocalDate.of(year, month, day);
//			long db = ChronoUnit.DAYS.between(oldDate, today);
//			c.setNumberOfDays(db);
//			if (date.equalsIgnoreCase(data[4])) {
//				al.add(c);
//			}
//
//		}
//		return al;
//	}

}
