package com.boot.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Contact entity
 * 
 * @author admin
 */
@Entity
@Table(name = "contacts")
public class Contacts implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "contact_id")
	private Integer contactId;
	@Column(name = "name")
	@Size(min = 4, max = 30, message = "This is required field min 4 symbols")
	private String name;
	@Column(name = "surname")
	private String surname;
	@Column(name = "middlename")
	@Size(min = 4, max = 30, message = "This is required field min 4 symbols")
	private String middlename;
	@Column(name = "homephone")
	private String homephone;
	@Column(name = "mobilephone")
	private String mobilephone;
	@Column(name = "workemail")
	@Pattern(regexp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", message = "Invalid email")
	private String workemail;
	@Column(name = "personalemail")
	@Pattern(regexp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", message = "Invalid email")
	private String personalemail;
	@Column(name = "country")
	private String country;
	@Column(name = "workphone")
	private String workphone;
	@Column(name = "address")
	private String address;
	@JoinColumn(name = "user_id", referencedColumnName = "user_id")
	@ManyToOne(optional = false)
	private Users userId;

	public Contacts() {
	}

	public Integer getContactId() {
		return contactId;
	}

	public void setContactId(Integer contactId) {
		this.contactId = contactId;
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
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getHomephone() {
		return homephone;
	}

	public void setHomephone(String homephone) {
		this.homephone = homephone;
	}

	public String getMobilephone() {
		return mobilephone;
	}

	public void setMobilephone(String mobilephone) {
		this.mobilephone = mobilephone;
	}

	

	public String getWorkemail() {
		return workemail;
	}

	public void setWorkemail(String workemail) {
		this.workemail = workemail;
	}

	public String getPersonalemail() {
		return personalemail;
	}

	public void setPersonalemail(String personalemail) {
		this.personalemail = personalemail;
	}

	public String getWorkphone() {
		return workphone;
	}

	public void setWorkphone(String workphone) {
		this.workphone = workphone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	

	public Users getUserId() {
		return userId;
	}

	public void setUserId(Users userId) {
		this.userId = userId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((contactId == null) ? 0 : contactId.hashCode());
		result = prime * result + ((workemail == null) ? 0 : workemail.hashCode());
		result = prime * result + ((personalemail == null) ? 0 : personalemail.hashCode());
		result = prime * result + ((country == null)? 0 : country.hashCode());
		result = prime * result + ((homephone == null) ? 0 : homephone.hashCode());
		result = prime * result + ((middlename == null) ? 0 : middlename.hashCode());
		result = prime * result + ((mobilephone == null) ? 0 : mobilephone.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		result = prime * result + ((workphone == null) ? 0 : workphone.hashCode());
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
		Contacts other = (Contacts) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (contactId == null) {
			if (other.contactId != null)
				return false;
		} else if (!contactId.equals(other.contactId))
			return false;
		if (workemail == null) {
			if (other.workemail != null)
				return false;
		} else if (!workemail.equals(other.workemail))
			return false;
		if (personalemail == null) {
			if (other.personalemail != null)
				return false;
		} else if (!personalemail.equals(other.personalemail))
			return false;
		if (homephone == null) {
			if (other.homephone != null)
				return false;
		} else if (!homephone.equals(other.homephone))
			return false;
		if (middlename == null) {
			if (other.middlename != null)
				return false;
		} else if (!middlename.equals(other.middlename))
			return false;
		
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (mobilephone == null) {
			if (other.mobilephone != null)
				return false;
		} else if (!mobilephone.equals(other.mobilephone))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
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
		if (workphone == null) {
			if (other.workphone != null)
				return false;
		} else if (!workphone.equals(other.workphone))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Contacts [contactId=" + contactId + ", name=" + name + ", surname=" + surname + ", middlename="
				+ middlename + ",country="+ country + ", homephone=" + homephone + ", mobilephone=" + mobilephone + ", workemail=" + workemail
				+ ", personalemail="+personalemail+",workphone=" + workphone + ", address=" + address + ", userId=" + userId + "]";
	}

	
}
