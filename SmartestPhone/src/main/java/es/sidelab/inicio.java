package es.sidelab;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class inicio {

	@RequestMapping("/SmartestPhone")
	public String greetingInicio() {

		return "inicio";
	}

	@RequestMapping("/SmartestPhone/añadir")
	public String greetingAñadir() {

		return "añadir";
	}
	
	@RequestMapping("/SmartestPhone/noticias")
	public String greetingNoticias() {

		return "noticias";
	}

}