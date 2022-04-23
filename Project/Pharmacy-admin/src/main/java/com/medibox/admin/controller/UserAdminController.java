package com.medibox.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.medibox.admin.model.User;
import com.medibox.admin.service.OrderMasterService;
import com.medibox.admin.service.UserService;

@Controller
public class UserAdminController {
	
	@Autowired
	private OrderMasterService orderMasterService;
	
	@Autowired
	private UserService userService;

	@RequestMapping("/Users")
	public String Users(Model m) {
		List<User> users = userService.listOfUser();
		m.addAttribute("Userlist", users);
		return "admin/Users";
	}

	@GetMapping("/UserDetailsFind")
	public String UserDetails(@RequestParam("uid") Integer uid, Model m) {
		m.addAttribute("currentuser", userService.findByUserId(uid));
		m.addAttribute("totalOrders", orderMasterService.findOrderByUserId(uid));
		return "admin/UserDetails";
	}

//	// adding data in database
//	@PostMapping("/addaddress")
//	public String saveUserAddress(UserAddress uAdd, Model m) {
//		System.out.println("saveUserAddress");
//		if (uAdd.getUser() != null) {
//			uAddService.addUserAddress(uAdd);
//			m.addAttribute("addressSave", true);
//			m.addAttribute("currentuser", userService.findByUserId(uAdd.getUser().getUserId()));
//			return "admin/UserDetails";
//		}
//
//		m.addAttribute("currentuser", userService.findByUserId(uAdd.getUser().getUserId()));
//		return "admin/UserDetails";
//	}

	/*
	 * @RequestMapping("/UserDetails") public String UserSDetailsList(Model m) {
	 * List<User> users=userService.listOfUser();
	 * 
	 * m.addAttribute("Userlist", users); System.out.println(users); return
	 * "UserDetails"; }
	 */

//	// useraddres edit data sending on form
//	@GetMapping("/editAddress")
//	public String editAddForm(@RequestParam("userAId") Integer uid, Model m) {
//		UserAddress userAddress = uAddService.findByUserAddressId(uid);
//		if (userAddress != null) {
//			m.addAttribute("currentuser", userService.findByUserId(userAddress.getUser().getUserId()));
//
//			m.addAttribute("editAddFormDetails", userAddress);
//			m.addAttribute("editAddForm", true);
//			return "admin/UserDetails";
//		}
//		m.addAttribute("currentuser", userService.findByUserId(userAddress.getUser().getUserId()));
//		return "admin/UserDetails";
//	}

//	// updating useraddress
//	@PostMapping("/updateAddress")
//	public String updateUserAddress(UserAddress uAdd, Model m) {
//		System.out.println("update UserAddress");
//		uAddService.addUserAddress(uAdd);
//		m.addAttribute("currentuser", userService.findByUserId(uAdd.getUser().getUserId()));
//		return "admin/UserDetails";
//	}

//	// deleting user address
//	@GetMapping("/deleteAddress")
//	public String deleteUAddress(@RequestParam("userAId") Integer uid, Model m) {
//		UserAddress userAddress = uAddService.findByUserAddressId(uid);
//		if (userAddress != null) {
//			uAddService.deleteUserAddress(userAddress);
//			m.addAttribute("deletedAdd", true);
//			m.addAttribute("currentuser", userService.findByUserId(userAddress.getUser().getUserId()));
//			return "admin/UserDetails";
//		}
//		m.addAttribute("currentuser", userService.findByUserId(userAddress.getUser().getUserId()));
//		return "admin/UserDetails";
//	}

}
