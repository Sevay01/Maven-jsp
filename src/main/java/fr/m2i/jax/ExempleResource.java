package fr.m2i.jax;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/exemple")
public class ExempleResource {
	
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public String sayHello() {
		
		return "Hello, the world!";
	}

}
