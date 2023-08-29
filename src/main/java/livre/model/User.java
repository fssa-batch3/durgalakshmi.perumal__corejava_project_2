package livre.model;


public class User {
//getter and setters
	private String userId;
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
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
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
