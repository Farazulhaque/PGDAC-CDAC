package com.medibox.admin.controller.seller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.medibox.admin.model.Seller;
import com.medibox.admin.service.MedicineMasterService;
import com.medibox.admin.service.OrderMasterService;
import com.medibox.admin.service.SellerService;

@Controller
public class SellerHomeController {

	@Autowired
	private OrderMasterService orderMasterService;
	@Autowired
	private MedicineMasterService medicineMasterService;
	@Autowired
	private SellerService sellerService;
	
	@ModelAttribute
	public void commonDataSendforModal(Model m, HttpServletRequest request) {
		HttpSession session = request.getSession();
		Seller seller = (Seller) session.getAttribute("logedinSeller");
		if (seller != null) {
			m.addAttribute("pendingOrdercount",orderMasterService.PendingOrderOfSellerCount(seller.getSellerId()));
			m.addAttribute("pendingOrderList",orderMasterService.findOrderBySellerPendingOrder(seller.getSellerId()));
		}
	}
	
	
	
	@RequestMapping("/homeseller")
	public String home(Model m, HttpServletRequest request) {
		HttpSession session = request.getSession();
		Seller seller = (Seller) session.getAttribute("logedinSeller");
		if (seller != null) {
			return "seller/sellerIndex";
		}
		
		return "redirect:/sellerlogin";		
	}

	
	@RequestMapping("/medicineInventory")
	public String medicineInventory(Model m, HttpServletRequest request) {
		HttpSession session = request.getSession();
		Seller seller = (Seller) session.getAttribute("logedinSeller");
		if (seller != null) {
			m.addAttribute("listOfMedicine", medicineMasterService.listOfMedicineMaster());
			return "seller/MedicineList";
		}
		return "redirect:/sellerlogin";	
	}
	
	@RequestMapping("/sellerProfile")
	public String sellerProfile(Model m, HttpServletRequest request) {
		HttpSession session = request.getSession();
		Seller seller = (Seller) session.getAttribute("logedinSeller");
		if (seller != null) {
			m.addAttribute("currentuser",sellerService.findBySellerId(seller.getSellerId()));
			return "seller/SellerProfile";
		}
		return "redirect:/sellerlogin";	
	}
	
	
	
	
	@RequestMapping("/sellerSettings")
	public String sellerSettings(Model m, HttpServletRequest request) {
		HttpSession session = request.getSession();
		Seller seller = (Seller) session.getAttribute("logedinSeller");
		if (seller != null) {
			
			return "seller/SellerSettings";
		}
		return "redirect:/sellerlogin";	
	}
	
}
