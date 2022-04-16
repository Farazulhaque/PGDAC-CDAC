package com.medibox.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.medibox.admin.model.Seller;
import com.medibox.admin.reprository.SellerReprository;
import com.medibox.admin.service.SellerService;

@Controller
public class SellerController {

	@Autowired
	private SellerService sellerService;
	@Autowired
	private SellerReprository sellerReprository;

	@RequestMapping("/seller")
	public String Seller(Model m) {

		m.addAttribute("Sellerlist", sellerService.listOfSeller());
		// m.addAttribute("Sellerlist",sellerReprository.findAll());
		// System.out.println("sellerList");
		return "admin/sellerList";
	}

	@GetMapping("/sellerDetailsFind")
	public String sellerDetails(@RequestParam("sid") Integer sid, Model m) {
		m.addAttribute("currentuser", sellerService.findBySellerId(sid));

		// System.out.println(sellerService.listOfSeller());
		return "admin/sellerDetails";
	}

	@PostMapping("/sellerStatusupdate")
	public String sellerDetailsUpdate(Seller seller, Model m) {
		Seller sellerDetails = sellerService.findBySellerId(seller.getSellerId());
		seller.setPassword(sellerDetails.getPassword());
		sellerService.editSeller(seller);
		m.addAttribute("currentuser", sellerService.findBySellerId(seller.getSellerId()));
		return "admin/sellerDetails";
	}

}
