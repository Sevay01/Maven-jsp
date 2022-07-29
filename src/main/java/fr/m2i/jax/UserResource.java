package fr.m2i.jax;



import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.m2i.models.User;

@Path("/User")
public class UserResource {
	private final List<User> listUser = new ArrayList<>();
	
	
	public UserResource() {
		
		this.listUser.add(new User("Richard","truc"));

		this.listUser.add(new User("Richard","truc"));

		this.listUser.add(new User("Richard","truc"));
		this.listUser.add(new User("Richard","truc"));

		this.listUser.add(new User("Richard","truc"));
		
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public List<User> get() {
	    
		return this.listUser;
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void create(@FormParam("nom") String nom, @FormParam("prenom") String prenom) {
		this.listUser.add(new User(nom,prenom));
		System.out.print(nom);
		System.out.print(this.listUser.size());
	}
	
	
}
