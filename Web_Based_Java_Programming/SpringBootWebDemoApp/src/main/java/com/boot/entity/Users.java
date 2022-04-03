package com.boot.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * User entity
 * 
 * @author admin
 */
@Entity
@Table(name = "users")
public class Users implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Integer userId;
	@Column(name = "login")
	private String login;
	

	@Column(name = "name")
	@Size(min = 5, max = 30, message = "This is required field min 5 symbols")
	private String name;
	@Column(name = "surname")
	@Size(min = 5, max = 30, message = "This is required field min 5 symbols")
	private String surname;
	@Column(name = "middlename")
	private String middlename;
	@Column(name = "email")
	@Size(min = 3, max = 30, message = "This is required field")
	@Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$", message = "valid email formate only")
	private String email;
	@Column(name = "password")
	@Size(min = 5, max = 50, message = "This is required field and min 5 symbols")
	private String password;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
	private Collection<Contacts> contactsCollection;

	public Users() {
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getMiddlename() {
		return middlename;
	}

	public void setMiddlename(String middlename) {
		this.middlename = middlename;
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

	public Collection<Contacts> getContactsCollection() {
		return contactsCollection;
	}

	public void setContactsCollection(Collection<Contacts> contactsCollection) {
		this.contactsCollection = contactsCollection;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contactsCollection == null) ? 0 : contactsCollection.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((middlename == null) ? 0 : middlename.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
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
		Users other = (Users) obj;
		if (contactsCollection == null) {
			if (other.contactsCollection != null)
				return false;
		} else if (!contactsCollection.equals(other.contactsCollection))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (middlename == null) {
			if (other.middlename != null)
				return false;
		} else if (!middlename.equals(other.middlename))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Users [userId=" + userId + ", name=" + name + ", surname=" + surname + ", middlename=" + middlename
				+ ", email=" + email + ", password=" + password + ", contactsCollection=" + contactsCollection + "]";
	}
	

}