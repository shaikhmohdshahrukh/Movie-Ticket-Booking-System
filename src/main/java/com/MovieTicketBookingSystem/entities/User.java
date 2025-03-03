package com.MovieTicketBookingSystem.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class User {

	@Id
	private Long userId;
	private String userName;
	private String password;
	private String recoveryEmail;
	private boolean isAdmin;

	public User() {
		userName = new String();
		password = new String();
		recoveryEmail = new String();
	}

	public User(Long userId, String userName, String password, String recoveryEmail) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.recoveryEmail = recoveryEmail;
	}

	public User(Long userId, String userName, String password, String recoveryEmail, boolean isAdmin) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.recoveryEmail = recoveryEmail;
		this.isAdmin = isAdmin;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRecoveryEmail() {
		return recoveryEmail;
	}

	public void setRecoveryEmail(String recoveryEmail) {
		this.recoveryEmail = recoveryEmail;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + ", recoveryEmail="
				+ recoveryEmail + ", isAdmin=" + isAdmin + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((recoveryEmail == null) ? 0 : recoveryEmail.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

}
