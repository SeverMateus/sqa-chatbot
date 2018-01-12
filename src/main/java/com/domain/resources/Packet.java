package com.domain.resources;

public class Packet {
  int id;
  String location;
  String eta;
  float price;

  /**
   * Parameterized constructor for the Packet.
   * 
   * @param id The id of the packet
   * @param location The location where the packet is at
   * @param price The price of the item
   * @param eta The estimated time of arrival for the packet
   */
  public Packet(int id, String location, float price, String eta) {
    this.id = id;
    this.location = location;
    this.price = price;
    this.eta = eta;
  }
  
  /**
   * The empty constructor for the Packet.
   */
  public Packet() {
    id = -1;
    location = "";
    eta = "";
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

  public String getEta() {
    return eta;
  }

  public void setEta(String eta) {
    this.eta = eta;
  }

  public float getPrice() {
    return price;
  }

  public void setPrice(float price) {
    this.price = price;
  }


}
