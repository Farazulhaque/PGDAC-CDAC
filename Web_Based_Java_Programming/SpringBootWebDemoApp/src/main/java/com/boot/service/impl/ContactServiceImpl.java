package com.boot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.entity.Contacts;
import com.boot.entity.Users;
import com.boot.repository.ContactRepository;
import com.boot.service.ContactService;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	ContactRepository contactRepository;

	@Override
	public List<Contacts> getUserContacts(Users user) {
		if (user != null) {
			return contactRepository.getUserContacts(user);
		}
		return null;
	}

	@Override
	public Contacts findContactById(Integer contactId) {
		if (contactId != null)
			return contactRepository.findContactById(contactId);
		return null;
	}

	@Override
	public void createContact(Contacts contact) {
		if (contact != null)
			contactRepository.createContact(contact);

	}

	@Override
	public void deleteContact(Contacts contact) {
		if (contact != null)
			contactRepository.deleteContact(contact);

	}

	@Override
	public void editContact(Contacts contact) {
		if (contact != null)
			contactRepository.editContact(contact);

	}

}
