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

	@RequestMapping("/SmartestPhone/buscar")
	public String buscar(@RequestParam String arg1, @RequestParam String arg2, @RequestParam String accion,
			Model model) {

		if (accion.equals("Buscar")) {
			model.addAttribute("smartphone", repositorioSmartPhone.findByMarcaAndModelo(arg1, arg2));
		}

		return "inicio";
	}
	
	@RequestMapping("/SmartestPhone")
	public String greeting() {

		return "inicio";
	}

}