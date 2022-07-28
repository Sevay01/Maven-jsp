package fr.m2i.models;


public class User {
	private String login;
	private String mdp;
	
	
	public User() {
		
	}
	
	public User(String login, String mdp) {
		this.setLogin(login);
		this.setMdp(mdp);
	}
	
	
	
	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}



}
