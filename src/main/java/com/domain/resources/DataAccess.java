package com.domain.resources;

public class DataAccess {
	public static String getPrice(String id) {
		String price;		
		Packet p = getPacket(Integer.parseInt(id));
		
		if (!String.valueOf(p.getPrice()).isEmpty()) {
			price = "The price for item "+ id + " is "+p.getPrice()+" Euros";
		}
		else {
			price = "Item not found. Please verify the item ID and try again";
		}
		return price;
	}
	
	public static String getStatus(String id) {
		String status;		
		Packet p = getPacket(Integer.parseInt(id));
		
		if (!String.valueOf(p.getLocation()).isEmpty()) {
			status = "Order "+ id+ " is in "+p.getLocation()+", and will be arriving "+p.getETA();
		}
		else {
			status = "Order not found. Please verify the order ID and try again";
		}
		return status;
	}
	
	private static Packet getPacket(int id) {
		if (id == 1)
		return new Packet (1, "Madrid", (float) 223.45, "Tomorrow");
		else
			if (id == 2)
				return new Packet (2, "Barcelona", (float) 223.45, "in 2 days");
			else
				if (id == 3)
					return new Packet (3, "Paris", (float) 223.45, "in 5 days");
				else
					if (id == 4)
						return new Packet (4, "Lisbon", (float) 223.45, "on Sunday");
					else
						if (id == 5)
							return new Packet (5, "London", (float) 223.45,  "not so soon");
						else
							return new Packet();	
	}

}
