package com.boot.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.boot.entity.Contacts;
import com.boot.entity.Users;
import com.boot.service.ContactService;

/**
 * Serves CRUD contact operations
 * 
 * @author admin
 *
 */
@Controller
public class ContactController {

	@Autowired
	private ContactService contactDao;
     
	
	
	@GetMapping("/add-contact")
	public String getCreateContactPage(Model model) {
		Contacts contact = new Contacts();
		model.addAttribute("newContact", contact);
		model.addAttribute("adding", true);
		return "addContact";
	}

	@PostMapping("/add-contact")
	public String addNewContact(@ModelAttribute("newContact") @Valid Contacts contact, BindingResult result,
			HttpServletRequest request, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("adding", true);
			return "addContact";
		}
		
		HttpSession session = request.getSession();
		Users user = (Users) session.getAttribute("currentUser");
		if (contact != null) {
			contact.setUserId(user);
			contactDao.createContact(contact);
		}
		
		return "redirect:/home";
	}

	@GetMapping("/delete")
	public String editContact(@RequestParam("contactId") Integer contactId) {
		if (contactId != null) {
			contactDao.deleteContact(contactDao.findContactById(contactId));
		}
		return "redirect:/home";
	}

	@GetMapping("/edit")
	public String getEditContactPage(@RequestParam("contactId") Integer contactId, Model model) {
		model.addAttribute("newContact", contactDao.findContactById(contactId));
		model.addAttribute("editing", true);
		return "addContact";
	}

	@PostMapping("/edit")
	public String editContact(@ModelAttribute("newContact") @Valid Contacts contact, BindingResult result,
			HttpServletRequest request, Model model) {
		if (result.hasErrors()){
			model.addAttribute("editing", true);
			return "addContact";
		}
			
		HttpSession session = request.getSession();
		Users user = (Users) session.getAttribute("currentUser");
		if (contact != null) {
			contact.setUserId(user);
			contactDao.editContact(contact);
		}
		return "redirect:/home";
	}

}
