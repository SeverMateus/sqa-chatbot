package com.domain.resources;

import org.junit.Test;
import static org.junit.Assert.*;


public class PacketTest {
	/**
	   * Test the price request with bad product id
	   */
	  @Test
	  public void testPacket() {
		  Packet p = new Packet();
		  p.setId(1);
		  p.setETA("Wednesday");
		  p.setLocation("Madrid");
		  p.setPrice(1234);
		  assertEquals(1, p.getId());
		  assertEquals("Wednesday", p.getETA());
		  assertEquals("Madrid", p.getLocation());
		  assertEquals(1234, p.getPrice(), 0);		  
	  }
}
