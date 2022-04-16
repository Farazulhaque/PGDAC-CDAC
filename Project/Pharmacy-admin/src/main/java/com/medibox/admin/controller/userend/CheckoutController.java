package com.medibox.admin.controller.userend;

import java.util.ArrayList;
import java.util.HashMap;

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
import org.springframework.web.bind.annotation.ResponseBody;

import com.medibox.admin.model.MedicineMaster;
import com.medibox.admin.model.Seller;
import com.medibox.admin.model.User;
import com.medibox.admin.model.UserAddress;
import com.medibox.admin.reprository.SellerReprository;
import com.medibox.admin.service.UserAddressService;
import com.medibox.admin.service.UserService;
import com.medibox.admin.service.implement.MedicineMasterImplementation;

@Controller
public class CheckoutController {

	@Autowired
	private UserService userService;

	@Autowired
	private UserAddressService uAddService;

	@Autowired
	private MedicineMasterImplementation medicineMasterImp;

	@Autowired
	private SellerReprository sellerReprository;

	@ModelAttribute
	public void commonDataSendforModal(Model m, HttpServletRequest request) {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("logedInUser");
		if (user != null) {
			m.addAttribute("userdetails", userService.findByUserId(user.getUserId()));
		}
	}

	// adding user address process
	@PostMapping("/saveUserAddressCheckout")
	public String saveUserAddressDB(UserAddress uAddress, Model m, HttpServletRequest request) {

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("logedInUser");
		if (user != null) {
			uAddress.setUser(user);
			uAddService.addUserAddress(uAddress);
			m.addAttribute("addressSave", true);
			return "users/Checkout";
		}
		return "redirect:/userloginpage";
	}

	// useraddres edit data sending on form
	@GetMapping("/editUserAddressCheckout")
	public String editAddForm(@RequestParam("userAId") Integer uAid, Model m, HttpServletRequest request) {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("logedInUser");
		if (user != null) {
			UserAddress userAddress = uAddService.findByUserAddressId(uAid);
			m.addAttribute("editAddFormDetails", userAddress);
			m.addAttribute("editAddForm", true);
			return "users/Checkout";
		}

		return "redirect:/userloginpage";
	}

	// updating useraddress
	@PostMapping("/updateUserAddressCheckout")
	public String updateUserAddress(UserAddress uAddress, Model m, HttpServletRequest request) {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("logedInUser");
		if (user != null) {
			uAddress.setUser(user);
			uAddService.addUserAddress(uAddress);
			return "users/Checkout";
		}
		return "redirect:/userloginpage";
	}

	@RequestMapping("/checkout")
	public String checkout(HttpServletRequest request) {

		return "users/Checkout";
	}

	@GetMapping("/cartItems")
	public String cartItems(@RequestParam("mid") String mid, @RequestParam("mqty") String mqty, Model m,
			HttpServletRequest request) {

		String[] midStr = mid.split("_");
		String[] mqtyStrings = mqty.split("_");
		ArrayList<MedicineMaster> arr = new ArrayList<MedicineMaster>();
		for (int i = 0; i < midStr.length; i++) {
			Integer midInteger = Integer.parseInt(midStr[i]);
			MedicineMaster medicineMaster = medicineMasterImp.findByMedicineId(midInteger);
			arr.add(medicineMaster);

		}

		HttpSession session = request.getSession();
		session.setAttribute("medicines", arr);
		session.setAttribute("quantity", mqtyStrings);
		return "users/Checkout";
	}

	@GetMapping("/findSeller")
	@ResponseBody
	public HashMap<String, Seller> findseller(@RequestParam("pincode") String pin) {
		int pincode = Integer.parseInt(pin);
		System.out.println(pincode);
		Seller seller = sellerReprository.findSellerByPincode(pincode);
		HashMap<String, Seller> sellerMap = new HashMap<String, Seller>();

		if (seller == null) {
			sellerMap.put("seller", null);
			System.out.println("Seller not found!!");
		} else {
			sellerMap.put("seller", seller);
			System.out.println("Seller Name: " + seller.getFullName());
		}
		return sellerMap;
	}
}
