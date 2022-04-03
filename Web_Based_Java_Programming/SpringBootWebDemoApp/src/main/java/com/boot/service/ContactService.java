package com.boot.service;

import java.util.List;

import com.boot.entity.Contacts;
import com.boot.entity.Users;

/**
 * Service which works with contact repository {@ContactRepository}
 * @author admin
 *
 */
public interface ContactService {
	
	List<Contacts> getUserContacts(Users user);

	Contacts findContactById(Integer contactId);

	void createContact(Contacts contact);

	void deleteContact(Contacts contact);

	void editContact(Contacts contact);
}
