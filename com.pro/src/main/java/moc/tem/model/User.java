package moc.tem.model;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public class User {
	
	private long userId;
	private String username;
	private String password;
	
	@Enumerated(EnumType.STRING)
	private Role role;
	
	public enum Role{
		ADMIN, PATIENT, DOCTOR;
	}

    // Constructors
	public User() {}

	public User(long userId, String username, String password, Role role) {
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.role = role;
	}

    // Getters and Setters
	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
    
    @Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", role=" + role + "]";
	}
}