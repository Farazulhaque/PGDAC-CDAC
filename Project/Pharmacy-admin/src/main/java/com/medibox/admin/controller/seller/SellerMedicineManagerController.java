package com.medibox.admin.controller.seller;

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
import com.medibox.admin.model.Seller;
import com.medibox.admin.model.SellerMedicneManager;
import com.medibox.admin.service.SellerMedicneManagerService;
import com.medibox.admin.service.implement.MedicineMasterImplementation;

@Controller
public class SellerMedicineManagerController {

	@Autowired
	private SellerMedicneManagerService sellerMedMngrService;
	@Autowired
	private MedicineMasterImplementation medicineMasterImp;

	@ModelAttribute
	public void commonDataSendforModal(Model m, HttpServletRequest request) {
		HttpSession session = request.getSession();
		Seller seller = (Seller) session.getAttribute("logedinSeller");
		if (seller != null) {
			m.addAttribute("listOfSellerMedicine", sellerMedMngrService.findBySellerId(seller.getSellerId()));
			m.addAttribute("listOfMedicine", medicineMasterImp.listOfMedicineMaster());
		}
	}

	@RequestMapping("/sellerMedicineManager")
	public String medicineManager(Model m, HttpServletRequest request) {

		HttpSession session = request.getSession();
		Seller seller = (Seller) session.getAttribute("logedinSeller");
		if (seller != null) {
			// m.addAttribute("listOfSellerMedicine",sellerMedMngrService.findBySellerId(seller.getSellerId()));
			// m.addAttribute("listOfMedicine",medicineMasterImp.listOfMedicineMaster());
			//
			return "seller/sellerMedicineManager";
		}
		return "redirect:/sellerlogin";
	}

	// form medicine inventery to qunatatiy manager page;
	@GetMapping("/AddinurStock")
	public String medicineManager(@RequestParam("mid") Integer mid, Model m, HttpServletRequest request) {

		HttpSession session = request.getSession();
		Seller seller = (Seller) session.getAttribute("logedinSeller");
		if (seller != null) {
			m.addAttribute("singleMedicine", medicineMasterImp.findByMedicineId(mid));
			// m.addAttribute("listOfSellerMedicine",sellerMedMngrService.findBySellerId(seller.getSellerId()));
			return "seller/sellerMedicineManager";
		}
		return "redirect:/sellerlogin";
	}

	// adding quantity and updating
	@PostMapping("/addQuant")
	public String addmedicineQuantity(SellerMedicneManager smManager, Model m, HttpServletRequest request) {

		HttpSession session = request.getSession();
		Seller seller = (Seller) session.getAttribute("logedinSeller");
		if (seller != null) {
			smManager.setSeller(seller);
			sellerMedMngrService.addSellerMedicneManager(smManager);
			return "seller/sellerMedicineManager";
		}
		return "redirect:/sellerlogin";
	}

	// update medicine from manager
	@GetMapping("/updateMfrmLst")
	public String updatemedicineQuantity(@RequestParam("medId") Integer mid, Model m, HttpServletRequest request) {

		HttpSession session = request.getSession();
		Seller seller = (Seller) session.getAttribute("logedinSeller");
		if (seller != null) {
			m.addAttribute("updateMedicine", sellerMedMngrService.findMediMgrIDWithSellerId(mid, seller.getSellerId()));
			return "seller/sellerMedicineManager";
		}
		return "redirect:/sellerlogin";
	}

	// delete medicine from manager
	@GetMapping("/deleteMfrmLst")
	public String deletemedicineQuantity(@RequestParam("medId") Integer mid, Model m, HttpServletRequest request) {

		HttpSession session = request.getSession();
		Seller seller = (Seller) session.getAttribute("logedinSeller");
		if (seller != null) {
			SellerMedicneManager smManager = sellerMedMngrService.findMediMgrIDWithSellerId(mid, seller.getSellerId());
			sellerMedMngrService.deleteSellerMedicneManager(smManager);
			return "seller/sellerMedicineManager";
		}
		return "redirect:/sellerlogin";
	}

//	@RequestMapping(value = "/AjaxFormedicineFind", method = RequestMethod.POST)
//	@ResponseBody
//	public ModelAndView search(@RequestParam("Mname") String value) {
//		ModelAndView mv = new ModelAndView();;
//		mv.setViewName("seller/sellerMedicineManager");
//		List<MedicineMaster> medciList = medicineMasterImp.findMedicineByNameLike(value);
//		mv.addObject("med", medciList);
//		return mv;
//	}

}
