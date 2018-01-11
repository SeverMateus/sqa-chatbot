package com.domain.resources;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

@Path("apiserver")
public class ApiResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getIt() {
    	System.out.println("Hola esto es un get");
        return Response.status(200).entity("{\"jdnjkdcnejw\"}").build();
    }
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response postIt(String req) {
    	
    	String resp = parseJson(req);
        return Response.status(200).type(MediaType.APPLICATION_JSON).entity(resp).build();
    }
    
    private String parseJson(String req) {
    	JSONObject json = new JSONObject(req); 
    	String action = json.getJSONObject("result").getString("action");
    	String resp;
    	switch (action) {
    		case "support.delivery":
    			resp = DataAccess.getStatus(json.getJSONObject("result").getJSONObject("parameters").getString("order-number"));
    		break;
    		case "sales.price":
    			resp = DataAccess.getPrice(json.getJSONObject("result").getJSONObject("parameters").getString("product-code"));
    		break;
    		default:
    			resp = "Unable to fulfill this request at this time, please try again.";
    		break;
    	
    	}
    	
    	String response = "{ \"speech\": \""+ resp +"\", \"displayText\": \""+resp+"\" }";
    	return response;
    }
}               
