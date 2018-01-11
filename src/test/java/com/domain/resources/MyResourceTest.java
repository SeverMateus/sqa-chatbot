package com.domain.resources;

import static org.junit.Assert.assertEquals;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

public class MyResourceTest extends JerseyTest {

  @Override
    protected Application configure() {
	  new DataAccess();
    return new ResourceConfig(ApiResource.class);
  }

  /**
   * Test the status request
   */
  @Test
  public void testStatus() {
    final String responseMsg = target("apiserver").request(MediaType.APPLICATION_JSON_TYPE).post(Entity.entity("{\"result\": {\"action\": \"support.delivery\", \"parameters\": {\"order-number\": \"1\" }} }", MediaType.APPLICATION_JSON_TYPE)).readEntity(String.class);
    assertEquals("{ \"speech\": \"Order 1 is in Madrid, and will be arriving Tomorrow\", \"displayText\": \"Order 1 is in Madrid, and will be arriving Tomorrow\" }", responseMsg);
  }
  
  /**
   * Test the wrong order number
   */
  @Test
  public void testStatusBad() {
    final String responseMsg = target("apiserver").request(MediaType.APPLICATION_JSON_TYPE).post(Entity.entity("{\"result\": {\"action\": \"support.delivery\", \"parameters\": {\"order-number\": \"-1\" }} }", MediaType.APPLICATION_JSON_TYPE)).readEntity(String.class);
    assertEquals("{ \"speech\": \"Order not found. Please verify the order ID and try again\", \"displayText\": \"Order not found. Please verify the order ID and try again\" }", responseMsg);
  }
  /**
   * Test the price request
   */
  @Test
  public void testPrice() {
    final String responseMsg = target("apiserver").request(MediaType.APPLICATION_JSON_TYPE).post(Entity.entity("{\"result\": {\"action\": \"sales.price\", \"parameters\": {\"product-code\": \"1\" }} }", MediaType.APPLICATION_JSON_TYPE)).readEntity(String.class);
    assertEquals("{ \"speech\": \"The price for item 1 is 223.45 Euros\", \"displayText\": \"The price for item 1 is 223.45 Euros\" }", responseMsg);
  }
  /**
   * Test the price request with bad product id
   */
  @Test
  public void testPriceBad() {
    final String responseMsg = target("apiserver").request(MediaType.APPLICATION_JSON_TYPE).post(Entity.entity("{\"result\": {\"action\": \"sales.price\", \"parameters\": {\"product-code\": \"-1\" }} }", MediaType.APPLICATION_JSON_TYPE)).readEntity(String.class);
    assertEquals("{ \"speech\": \"Item not found. Please verify the item ID and try again\", \"displayText\": \"Item not found. Please verify the item ID and try again\" }", responseMsg);
  }
  /**
   * Test the default catch all in the switch
   */
  @Test
  public void testDefault() {
    final String responseMsg = target("apiserver").request(MediaType.APPLICATION_JSON_TYPE).post(Entity.entity("{\"result\": {\"action\": \"default\"} }", MediaType.APPLICATION_JSON_TYPE)).readEntity(String.class);
    assertEquals("{ \"speech\": \"Unable to fulfill this request at this time, please try again.\", \"displayText\": \"Unable to fulfill this request at this time, please try again.\" }", responseMsg);
  }
  /**
   * Test the default catch all in the switch
   */
  @Test
  public void testPackets() {
    Packet p = DataAccess.getPacket(1);
    assertEquals(1, p.getId());
    p = DataAccess.getPacket(2);
    assertEquals(2, p.getId());
    p = DataAccess.getPacket(3);
    assertEquals(3, p.getId());
    p = DataAccess.getPacket(4);
    assertEquals(4, p.getId());
    p = DataAccess.getPacket(5);
    assertEquals(5, p.getId());
    p = DataAccess.getPacket(-1);
    assertEquals(-1, p.getId());
    
  }
}
