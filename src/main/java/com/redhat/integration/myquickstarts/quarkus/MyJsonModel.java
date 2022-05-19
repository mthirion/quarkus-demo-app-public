package com.redhat.integration.myquickstarts.quarkus;

/*
 * This defines the Json data that the client will fetch
 */

public class MyJsonModel {

	public String id;
	public String name;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	
}
