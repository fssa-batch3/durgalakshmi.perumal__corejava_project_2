package com.fssa.livre.model;


public class User {
//getter and setters
	private int userId;
	private String password;
	private String email;
	private String name;
	private long phoneNumber;

    private int age;
    
    
    public User(String email, String password, String name, long phoneNumber, int age) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.age = age;
    }


    
	public String getname() {
		return name;
	}

	public void setname(String name) {
		this.name = name;
	}



	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	private boolean isAdmin; 
	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

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
//	
//	public User(int userId , String email, String password) {
//		super();
//		this.userId = userId;
//		this.email = email;
//		this.password = password;
//	}
	
	// constructot
	public User(int userId, String email) {
		this.userId = userId;
		this.email = email;
	}
	//constructor
	public User() {
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



}
