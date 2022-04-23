package com.medibox.admin.controller.userend;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.medibox.admin.model.User;
import com.medibox.admin.service.UserService;

@Controller
public class UserSignuploginController {

	@Autowired
	private UserService userService;

	// opening signup page
	@RequestMapping("/UserSignup")
	public String userSignup() {
		System.out.println("UserSignup page called");
		return "users/UserSignup";
	}

	// user signup process
	@PostMapping("/process_userSignup")
	public String ProcessUserSignup(User user, Model m) {
		System.out.println("process_userSignup called");

		User existinguserbyemail = userService.findByUserEmail(user.getEmailId());
		User existinguserbymobile = userService.findByUserMobile(user.getContactNumber());

		if ((existinguserbyemail == null) && (existinguserbymobile == null)) {
			userService.addUser(user);
			m.addAttribute("userSignup", true);
			return "users/UserLogin";
		}
		m.addAttribute("userexist", true);
		return "users/UserSignup";
	}

	@RequestMapping("/userloginpage")
	public String userloginPage() {
		System.out.println("User login page called");
		return "users/UserLogin";
	}

	@PostMapping("/userlogin-process")
	public String userLogin(@RequestParam("uname") String uname, @RequestParam("upass") String upass,
			@RequestParam(value = "remember",required = false) String remember,HttpServletRequest request, Model m,HttpServletResponse response) {
		System.out.println("UserLogin page called");
		User user = userService.findByUserEmailAndPassword(uname, upass);
		
		
		if (user != null) {
			HttpSession session = request.getSession();
			session.setAttribute("logedInUser", user);
			if (remember != null) {
				Cookie ncookie = new Cookie("username",uname );
				Cookie pcookie = new Cookie("password",upass);
				
				ncookie.setMaxAge(180);
				pcookie.setMaxAge(180);
				
				response.addCookie(ncookie);
				response.addCookie(pcookie);
			}
			
			return "users/index";
		}
		m.addAttribute("invaliduser", true);
		return "users/UserLogin";
	}

	@RequestMapping("/logoutuser")
	public String Logoutseller(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();
		System.out.println("user logout");
		return "redirect:/userloginpage";
	}

}
