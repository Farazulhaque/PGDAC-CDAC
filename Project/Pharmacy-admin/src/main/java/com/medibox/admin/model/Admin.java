package com.medibox.admin.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int adminId;

	@Column(nullable = false, length = 50)
	private String fullName;

	@Column(nullable = false, unique = true)
	private String username;

	@Column(nullable = false, length = 500)
	private String Password;

	public Admin(int adminId, String fullName, String username, String password) {

		this.adminId = adminId;
		this.fullName = fullName;
		this.username = username;
		this.Password = password;
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}
}
