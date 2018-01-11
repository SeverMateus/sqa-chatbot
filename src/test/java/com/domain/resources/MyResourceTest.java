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
    final String responseMsg = target("apiserver").request(MediaType.APPLICATION_JSON_TYPE).post(Entity.entity("{\"result\": {\"action\": \"support.delivery\", \"parameters\": {\"order-number\": \"12345-12345\" }} }", MediaType.APPLICATION_JSON_TYPE)).readEntity(String.class);
    assertEquals("{ \"speech\": \"Order 12345-12345 is in Madrid, and will be arriving Tomorrow\", \"displayText\": \"Order 12345-12345 is in Madrid, and will be arriving Tomorrow\" }", responseMsg);
  }
  /**
   * Test the price request
   */
  @Test
  public void testPrice() {
    final String responseMsg = target("apiserver").request(MediaType.APPLICATION_JSON_TYPE).post(Entity.entity("{\"result\": {\"action\": \"sales.price\", \"parameters\": {\"product-code\": \"12345-12345\" }} }", MediaType.APPLICATION_JSON_TYPE)).readEntity(String.class);
    assertEquals("{ \"speech\": \"The price for item 12345-12345 is 123.33\", \"displayText\": \"The price for item 12345-12345 is 123.33\" }", responseMsg);
  }
  /**
   * Test the default catch all in the switch
   */
  @Test
  public void testDefault() {
    final String responseMsg = target("apiserver").request(MediaType.APPLICATION_JSON_TYPE).post(Entity.entity("{\"result\": {\"action\": \"default\"} }", MediaType.APPLICATION_JSON_TYPE)).readEntity(String.class);
    assertEquals("{ \"speech\": \"Unable to fulfill this request at this time, please try again.\", \"displayText\": \"Unable to fulfill this request at this time, please try again.\" }", responseMsg);
  }
}
