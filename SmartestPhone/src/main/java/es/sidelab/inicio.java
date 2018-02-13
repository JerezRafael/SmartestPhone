package es.sidelab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class inicio {

	@Autowired
	private SmartPhoneRepository repositorioSmartPhone;

	@RequestMapping("/SmartestPhone")
	public String greetingInicio() {

		return "inicio";
	}

	@RequestMapping("/SmartestPhone/añadir")
	public String greetingAñadir() {

		return "añadir";
	}

}