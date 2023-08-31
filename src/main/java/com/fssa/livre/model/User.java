package com.fssa.livre.model;


public class User {
//getter and setters
	private int userId;
	private String email;
	private String password;
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	//constructor for servlet
	
	public User(int userId , String email, String password) {
		super();
		this.userId = userId;
		this.email = email;
		this.password = password;
	}
	
	// constructot
	public User(int userId, String email) {
		this.userId = userId;
		this.email = email;
	}
	//constructor
	public User(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	// Generates a string representation of the User object.
	@Override
	public String toString() { 
		return "User [email=" + email + ", password=" + password + ", getEmail()=" + getEmail() + ", getPassword()="
				+ getPassword() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

    // Default constructor
	public User() {
		
	}
	

}
