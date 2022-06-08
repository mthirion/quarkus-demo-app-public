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

import java.sql.Connection;
import java.sql.ResultSet;
import javax.inject.Inject;
import io.agroal.api.AgroalDataSource;

@Path("/api/myresource")
public class MyRestServer {
    
	private MyJsonModel example;

	@Inject
	AgroalDataSource defaultDataSource;	
	
	@HEAD
	@Produces(MediaType.TEXT_PLAIN)
	public Response getTextResource() {
		
		return Response.ok().build();
	}    	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Response getOneResource(@PathParam String id) throws java.sql.SQLException {
		
		MyJsonModel data = new MyJsonModel();
		data.setId(id);
		//data.setName("John");
	
		/* ADD SQL */
		/*
		java.sql.Connection connection = defaultDataSource.getConnection();
		java.sql.Statement statement = connection.createStatement();
		java.sql.ResultSet rs = statement.executeQuery("select * from users where id='"+id+"'");
		String s = "empty";
		if (rs.next()) s = rs.getString(2);
		data.setName(s);
		*/
		/*   FIN ADD SQL */	

		/* ADD ENVARS */
		data.setName(java.lang.System.getenv().getOrDefault("NAME","John"));
		/* FIN ADD ENVARS */
	
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
