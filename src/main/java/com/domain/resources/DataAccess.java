package com.domain.resources;

public class DataAccess {
	public static String getPrice(String id) {
		String price = "The price for item "+ id + " is 123.33";
		return price;
	}
	
	public static String getStatus(String id) {
		String status = "Order "+ id+ " is in Madrid, and will be arriving Tomorrow";
		
		return status;
		
	}

}
