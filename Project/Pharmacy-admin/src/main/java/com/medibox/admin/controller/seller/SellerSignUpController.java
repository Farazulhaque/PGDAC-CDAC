package com.medibox.admin.controller.seller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.*;

import com.medibox.admin.FileUploadUtils;
import com.medibox.admin.model.Seller;
import com.medibox.admin.service.OrderMasterService;
import com.medibox.admin.service.SellerService;

@Controller
public class SellerSignUpController {

	@Autowired
	private SellerService sellerService;
	
	@Autowired
	private OrderMasterService orderMasterService;

	@RequestMapping("/sellerSignUp")
	public String RegistrationForm() {
		// System.out.println("seller SignUp form");
		return "seller/sellerSignUp";
	}

	//	@PostMapping("/addSeller")
	//	public String Registration(Seller s,Model m) {
	//		sellerService.addSeller(s);
	//		m.addAttribute("sellerReg",true);
	//		System.out.println("seller Registration");
	//		return "sellerSignUp";
	//	}

	// signup -process
	@PostMapping("/addSeller")
	public String Registration(Seller s, @RequestParam("myfilesdoc") MultipartFile multipartFile, Model m)
			throws IOException {

		Seller existingseller = sellerService.findBySellerEmail(s.getEmailId());

		if (existingseller == null) {

			String filename = StringUtils.cleanPath(multipartFile.getOriginalFilename());
			// String uploadDir="src/main/resources/static/documents/seller";
			String uploadDir = "src/main/webapp/uplodedDocImg/DocumentSeller";

			FileUploadUtils.saveFile(uploadDir, filename, multipartFile);
			s.setDocumentUrl("/uplodedDocImg/DocumentSeller/" + filename);
			sellerService.addSeller(s);

			m.addAttribute("sellerReg", true);
			return "seller/sellerSignUp";
		}
		m.addAttribute("sellerexist", true);
		return "seller/sellerSignUp";
	}

	// seller login page opening
	@RequestMapping("/sellerlogin")
	public String loginpage() {
		System.out.println("seller login");
		return "seller/sellerLogin";
	}

	// sellerlogin
	@PostMapping("/sellerlogin")
	public String sellerLogin(@RequestParam("uemail") String uname, @RequestParam("upass") String upass,
			HttpServletRequest request, Model m) {

		Seller seller = sellerService.findBySellerEmailAndPasswordStatusIsActive(uname, upass);

		if (seller != null) {
			if (seller.getStatus() == 0) {
				m.addAttribute("notactive", true);
				return "seller/sellerLogin";
			} else {
				HttpSession session = request.getSession();
				session.setAttribute("logedinSeller", seller);
				m.addAttribute("pendingOrdercount",orderMasterService.PendingOrderOfSellerCount(seller.getSellerId()));
				m.addAttribute("pendingOrderList",orderMasterService.findOrderBySellerPendingOrder(seller.getSellerId()));
				return "seller/sellerIndex";
			}
		}
		m.addAttribute("invalid", true);
		System.out.println("login not success");
		return "seller/sellerLogin";
	}

	// logout seller
	@RequestMapping("/logout")
	public String Logoutseller(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();
		System.out.println("seller logout");
		return "redirect:/sellerlogin";
	}

}
