package com.domain.resources;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("apiserver")
public class ApiResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getIt() {
    	System.out.println("Hola esto es un get");
        return Response.status(200).entity("{jdnjkdcnejw}").build();
    }
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response postIt(String req) {
    	System.out.println(req);
    	String resp = "{ \"speech\": \"This is the server response\", \"displayText\": \"This is the server response\" }";
        return Response.status(200).type(MediaType.APPLICATION_JSON).entity(resp).build();
    }
}               
