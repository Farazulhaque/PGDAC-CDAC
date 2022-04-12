package com.medibox.admin.controller.userend;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.medibox.admin.model.User;
import com.medibox.admin.model.UserAddress;
import com.medibox.admin.service.UserAddressService;
import com.medibox.admin.service.UserService;

@Controller
public class CheckoutController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private UserAddressService uAddService;
	
	
	@ModelAttribute
	public void commonDataSendforModal(Model m,HttpServletRequest request) {
		HttpSession session=request.getSession();
		User user=(User) session.getAttribute("logedInUser");
		if(user!=null) {
			m.addAttribute("userdetails",userService.findByUserId(user.getUserId()));
		}	
	}
	
	//adding user address process
		@PostMapping("/saveUserAddressCheckout")
		public String saveUserAddressDB(UserAddress uAddress,Model m,HttpServletRequest request) {
			
			HttpSession session=request.getSession();
			User user=(User) session.getAttribute("logedInUser");
			if(user!=null) {
				uAddress.setUser(user);
				uAddService.addUserAddress(uAddress);
				m.addAttribute("addressSave", true);
				return "users/Checkout";	
			}
			return  "redirect:/userloginpage";
		}
		
		
		
		//useraddres edit data sending on form 
		@GetMapping("/editUserAddressCheckout")
		public String editAddForm(@RequestParam("userAId") Integer uAid, Model m,HttpServletRequest request) {
			HttpSession session=request.getSession();
			User user=(User) session.getAttribute("logedInUser");
			if(user!=null) {
				UserAddress userAddress=uAddService.findByUserAddressId(uAid);
				m.addAttribute("editAddFormDetails",userAddress);
				m.addAttribute("editAddForm", true);
				return "users/Checkout";
			}
			
			return  "redirect:/userloginpage";
		}
		
		
		
		
		
		
		//updating useraddress  
			@PostMapping("/updateUserAddressCheckout")
			public String updateUserAddress(UserAddress uAddress, Model m,HttpServletRequest request) {
				HttpSession session=request.getSession();
				User user=(User) session.getAttribute("logedInUser");
				if(user!=null) {
					uAddress.setUser(user);
					uAddService.addUserAddress(uAddress);
					return "users/Checkout";
				}
				return  "redirect:/userloginpage";
			}
		
	@RequestMapping("/checkout")
	public String checkout() {
		return "users/Checkout";
	}
	
}
