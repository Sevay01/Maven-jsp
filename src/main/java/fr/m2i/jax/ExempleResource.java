package fr.m2i.jax;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.m2i.models.User;

@Path("/exemple")
public class ExempleResource {
	
	
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public List<User> sayHello() {
		
		List<User> users = new ArrayList<>();
		
		users.add(new User("Fred","Fred"));
		users.add(new User("Fred","Fred"));
		users.add(new User("Fred","Fred"));
		users.add(new User("Fred","Fred"));
		users.add(new User("Fred","Fred"));
		users.add(new User("Fred","Fred"));
		
		
		
		
		return users;
	}

}
