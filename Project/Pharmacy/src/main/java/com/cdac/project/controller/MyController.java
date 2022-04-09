package com.cdac.project.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cdac.project.model.MedicineMaster;
import com.cdac.project.model.User;
import com.cdac.project.service.SearchService;
import com.cdac.project.service.UserSignupService;

@Controller
public class MyController {

	@Autowired
	private UserSignupService userSignupService;

	@Autowired
	private SearchService searchService;

	@RequestMapping("/")
	public String index() {
		System.out.println("Index page called");
		return "index";
	}

	@RequestMapping("/home")
	public String home() {
		System.out.println("Index page called");
		return "index";
	}

	@RequestMapping("/UserSignup")
	public String userSignup() {
		System.out.println("UserSignup page called");
		return "UserSignup";
	}

	@RequestMapping("/UserLogin")
	public String userLogin() {
		System.out.println("UserLogin page called");
		return "UserLogin";
	}

	@PostMapping("/process_userSignup")
	public String ProcessUserSignup(User user) {
		System.out.println("process_userSignup called");
		userSignupService.saveUser(user);
		return "index";
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
		return "Search";
	}

	// @RequestMapping("/processAJAX")
	// @ResponseBody
	// public HashMap<String, String> processAJAX(@RequestParam("query") String
	// query, Model model) {
	// List<MedicineMaster> medicinesList =
	// searchService.findByMedicineName(query);

	// model.addAttribute("medicinesQueryList", medicinesList);
	// model.addAttribute("query", query);
	// HashMap<String, String> map = new HashMap<String, String>();
	// int i = 0;

	// for (MedicineMaster medicineMaster : medicinesList) {
	// map.put("medicineName" + i, medicineMaster.getMedicineName());
	// i++;

	// }
	// return map;
	// }

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
		return "Product";
	}

	@RequestMapping("/cart")
	public String cart(HttpServletRequest request, Model model) {
		return "Cart";
	}
}
