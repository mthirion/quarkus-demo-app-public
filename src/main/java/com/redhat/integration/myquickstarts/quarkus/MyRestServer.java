package com.redhat.integration.myquickstarts.quarkus;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.HEAD;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

@Path("/api/myresource")
public class MyRestServer {
    
	private MyJsonModel example;
	
	@HEAD
	@Produces(MediaType.TEXT_PLAIN)
	public Response getTextResource() {
		
		return Response.ok().build();
	}    	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Response getOneResource(@PathParam String id) {
		// code here
		
		MyJsonModel data = new MyJsonModel();data.setId(id);data.setName("John");
		return Response.ok(data).build();
	}    
    
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getResourceList() {
		Set<MyJsonModel> mylist = Collections.synchronizedSet(new LinkedHashSet<>());
		// code here
		
		mylist.add(new MyJsonModel());mylist.add(new MyJsonModel());
		return Response.ok(mylist).build();
	}  
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response createResource(MyJsonModel payload) {
		//code here
		
		example=payload;
		return Response.ok("success").build();
	}
		
}
