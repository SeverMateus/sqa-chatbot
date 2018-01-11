package com.domain.resources;

public class DataAccess {
	public static String getPrice(String id) {
		String price = "Item not found. Please verify the item ID and try again";	
		Packet p = getPacket(Integer.parseInt(id));
		
		if (p.getPrice() != 0) {
			price = "The price for item "+ id + " is "+p.getPrice()+" Euros";
		}
		return price;
	}
	
	public static String getStatus(String id) {
		String status = "Order not found. Please verify the order ID and try again";		
		Packet p = getPacket(Integer.parseInt(id));
		
		if (!p.getLocation().isEmpty()) {
			status = "Order "+ id+ " is in "+p.getLocation()+", and will be arriving "+p.getETA();
		}

		return status;
	}
	
	public static Packet getPacket(int id) {
		Packet p; 
		switch(id) {
		case 1:
			p = new Packet (1, "Madrid", (float) 223.45, "Tomorrow");
			break;
		case 2:
			p = new Packet (2, "Barcelona", (float) 223.45, "in 2 days");
			break;
		case 3:
			p = new Packet (3, "Paris", (float) 223.45, "in 5 days");
			break;
		case 4:
			p = new Packet (4, "Lisbon", (float) 223.45, "on Sunday");
			break;
		case 5:
			p = new Packet (5, "London", (float) 223.45,  "not so soon");
			break;
		default:
			p = new Packet();
			break;		
		}	
		return p;
	}

}
