package es.sidelab;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class home {

	@RequestMapping("/SmartestPhone")
	public String greeting(Model model) {

		model.addAttribute("name", "SmartestPhone");

		return "home";
	}

}