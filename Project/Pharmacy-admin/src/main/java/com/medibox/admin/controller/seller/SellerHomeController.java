package com.medibox.admin.controller.seller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.medibox.admin.service.MedicineMasterService;

@Controller
public class SellerHomeController {

	
	@Autowired
	private MedicineMasterService medicineMasterService;
	
	@RequestMapping("/homeseller")
	public String home(Model m) {
		
		//System.out.println(medicineMasterImp.listOfMedicineNameId());
		return "seller/sellerIndex";	
	}

	
	@RequestMapping("/medicineInventory")
	public String medicineInventory(Model m) {
		
		m.addAttribute("listOfMedicine", medicineMasterService.listOfMedicineMaster());
		
		return "seller/MedicineList";	
	}
}
