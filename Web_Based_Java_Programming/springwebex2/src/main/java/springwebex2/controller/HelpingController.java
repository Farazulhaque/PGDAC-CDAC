package springwebex2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelpingController {

	@RequestMapping("/aboutus")
//	Holder for both Model and View in the web MVC framework.Note that these are entirely distinct. This class merely holdsboth to make it possible for a controller to return both modeland view in a single return value. 

	public ModelAndView aboutus() {
		System.out.println("About Us page...");
//		creating model view object
		ModelAndView modelobj = new ModelAndView();
		modelobj.addObject("name", "Faraz");
		modelobj.addObject("email", "faraz@gmail.com");
		modelobj.setViewName("About Us"); // setting view name
		return modelobj;
	}
}
