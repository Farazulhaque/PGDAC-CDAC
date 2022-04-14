package com.medibox.admin.controller.userend;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.medibox.admin.model.MedicineMaster;
import com.medibox.admin.service.SearchService;

@Controller
public class HomeController {

	// @Autowired
	// private UserSignupService userSignupService;

	@Autowired
	private SearchService searchService;

	@RequestMapping("/")
	public String index() {
		System.out.println("Index page called");
		return "users/index";
	}

	@RequestMapping("/home")
	public String home() {
		System.out.println("Index page called");
		return "users/index";
	}

	@RequestMapping("/aboutus")
	public String aboutUs() {
		System.out.println("AboutUs page called");
		return "users/AboutUs";
	}

	@RequestMapping("/contactus")
	public String contactUs() {
		System.out.println("ContactUs page called");
		return "users/ContactUs";
	}

	@GetMapping("/search")
	public String processQuery(@RequestParam("query") String query, Model model) {
		System.out.println("process query called");

		List<MedicineMaster> medicinesList = searchService.findByMedicineName(query);
		model.addAttribute("medicinesQueryList", medicinesList);
		model.addAttribute("query", query);
		if (medicinesList.size() == 0) {
			model.addAttribute("isEmpty", true);
		} else {
			model.addAttribute("isEmpty", false);
		}
		return "users/Search";
	}

	@RequestMapping("/processAJAX")
	@ResponseBody
	public ArrayList processAJAX(@RequestParam("query") String query, Model model) {
		List<MedicineMaster> medicinesList = searchService.findByMedicineName(query);

		model.addAttribute("medicinesQueryList", medicinesList);
		model.addAttribute("query", query);
		ArrayList arr = new ArrayList();

		for (MedicineMaster medicineMaster : medicinesList) {
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("medicineId", medicineMaster.getMedicineId() + "");
			map.put("medicineName", medicineMaster.getMedicineName());
			arr.add(map);
		}
		return arr;
	}

	@GetMapping("/product")
	public String product(@RequestParam("mid") Integer mid, Model model) {
		MedicineMaster medicine = searchService.findMedicineById(mid);
		model.addAttribute("medicine", medicine);
		System.out.println(medicine.getMedicineName());
		model.addAttribute("alternateMedicine", searchService.findAlternateMedicines(medicine.getSalt()));
		return "users/Product";
	}

	@RequestMapping("/cart")
	public String cart(HttpServletRequest request, Model model) {
		return "users/Cart";
	}

}
