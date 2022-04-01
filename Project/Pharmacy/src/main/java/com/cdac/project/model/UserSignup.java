package com.cdac.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "User")
public class UserSignup {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int UserId;

	@Column(nullable = false)
	private String FullName;

	@Column(nullable = false, unique = true)
	private String EmailId;

	@Column(nullable = false, unique = true)
	private String ContactNumber;

	@Column(nullable = false)
	private String Password;

	public int getUserId() {
		return UserId;
	}

	public void setUserId(int userId) {
		UserId = userId;
	}

	public String getFullName() {
		return FullName;
	}

	public void setFullName(String fullName) {
		FullName = fullName;
	}

	public String getEmailId() {
		return EmailId;
	}

	public void setEmailId(String emailId) {
		EmailId = emailId;
	}

	public String getContactNumber() {
		return ContactNumber;
	}

	public void setContactNumber(String contactNumber) {
		ContactNumber = contactNumber;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

}
