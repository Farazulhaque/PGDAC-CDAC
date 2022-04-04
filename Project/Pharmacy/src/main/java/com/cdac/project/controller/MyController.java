package com.cdac.project.controller;

import java.util.List;

import org.hibernate.loader.plan.spi.QuerySpaceUidNotRegisteredException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cassandra.CassandraProperties.Request;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cdac.project.model.MedicineMaster;
import com.cdac.project.model.UserSignup;
import com.cdac.project.repository.SearchRepository;
import com.cdac.project.repository.UserSignupRepository;
import com.cdac.project.service.UserSignupService;

@Controller
public class MyController {

	@Autowired
	private UserSignupService userSignupService;

	@Autowired
	private SearchRepository searchRepository;

	@RequestMapping("/")
	public String index() {
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
	public String ProcessUserSignup(UserSignup user) {
		System.out.println("process_userSignup called");
		userSignupService.saveUser(user);
		return "index";
	}

	@GetMapping("/search")
	public String processQuery(@RequestParam("query") String query, Model model) {
		System.out.println("process query called");

//		System.out.println(query);

		List<MedicineMaster> medicinesList = searchRepository.findByMedicineName(query);
//		for (MedicineMaster medicineMaster : medicinesList) {
//		 System.out.println(medicineMaster.toString());
//		}
		model.addAttribute("medicinesQueryList", medicinesList);
		model.addAttribute("query", query);
//		System.out.println(medicinesList);
		return "Search";
	}

	@RequestMapping("/processAJAX")
	@ResponseBody
//	@RequestMapping(value = "/processAJAX", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
//	public @ResponseBody List<MedicineMaster> processAJAX(@RequestParam("query") String query, Model model) {
	public List<MedicineMaster> processAJAX(@RequestParam("query") String query, Model model) {

		List<MedicineMaster> medicinesList = searchRepository.findByMedicineName(query);

		model.addAttribute("medicinesQueryList", medicinesList);
		model.addAttribute("query", query);
//		System.out.println(medicinesList);
		return medicinesList;
	}

	@GetMapping("/product")
	public String product(@RequestParam("mid") Integer mid, Model model) {
		MedicineMaster medicine = searchRepository.findMedicineById(mid);
		model.addAttribute("medicine", medicine);
		System.out.println(medicine.getMedicineName());
		model.addAttribute("alternateMedicine", searchRepository.findAlternateMedicines(medicine.getSalt()));
		return "Product";
	}

}
