package com.domain.resources;

public class Packet {
	int id;
	String location, ETA;
	float price;
	
	public Packet(int id, String location, float price, String ETA) {
		this.id = id;
		this.location = location;
		this.price = price;
		this.ETA = ETA;
	}
	
	public Packet() {
		id = -1;
		location ="";
		ETA = "";
		price = 0;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getETA() {
		return ETA;
	}

	public void setETA(String eTA) {
		ETA = eTA;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
	
}
