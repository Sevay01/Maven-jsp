package fr.m2i.jax;



import java.util.ArrayList;
import java.util.List;


import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import fr.m2i.models.User;

@Path("/User")
public class UserResource {
	private final List<User> listUser = new ArrayList<>();
	
	
	public UserResource() {
		
		this.listUser.add(new User("Mimi","Mathis"));

		this.listUser.add(new User("Jean-Luc","Lahaye"));

		this.listUser.add(new User("Josiane","Balasko"));
		this.listUser.add(new User("Bernard","Minet"));

		this.listUser.add(new User("Moi","Moi"));
		
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public List<User> getAll(@QueryParam("name") String name) {
		System.out.println(name);
		return this.listUser;
	}
	
	@Path("/byid/{id}")
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public User getById(@PathParam("id") int id ) {
		
		return this.listUser.get(id);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void create(@FormParam("nom") String nom, @FormParam("prenom") String prenom) {
		this.listUser.add(new User(nom,prenom));
		System.out.print(nom);
		System.out.print(this.listUser.size());
	}
	
	
}
