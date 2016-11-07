package com.example.web;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.example.api.RestExt;

@Path("/")
public class WebResources {

	public static RestExt restExtension;
	
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getResource() {
    	return restExtension.getIt();
    }
    
}
