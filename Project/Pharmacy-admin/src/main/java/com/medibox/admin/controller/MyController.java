package com.medibox.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.medibox.admin.reprository.SellerReprository;
import com.medibox.admin.service.implement.SellerServiceImplemention;
import com.medibox.admin.service.implement.UserServiceImplemention;

@Controller
public class MyController {

	@Autowired
	private UserServiceImplemention userServiceImplemention;

	@Autowired
	private SellerServiceImplemention seImplemention;

	@ModelAttribute
	public void commonDataSendforModal(Model m) {
		m.addAttribute("userCount", userServiceImplemention.countUser());
		m.addAttribute("sellerCount", seImplemention.countSeller());
		m.addAttribute("pendingSeller", seImplemention.pendingListOfSeller());

	}

	@RequestMapping("/admin")
	public String index() {
		System.out.println("home is excuted");
		return "admin/index";
	}

	@RequestMapping("/adminhome")
	public String home() {
		System.out.println("home is excuted");
		return "admin/index";
	}

	@RequestMapping("/settings")
	public String settings() {
		System.out.println("settings is excuted");
		return "admin/settings";
	}

}
