package es.sidelab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class home {
	
	@Autowired
	private SmartPhoneRepository repositorioSmartPhone;
	
	@RequestMapping("/SmartestPhone")
	public String greeting(@RequestParam String arg1, 
			@RequestParam String arg2, @RequestParam String arg3, @RequestParam String accion, 
			Model model) {

		if (accion.equals("Añadir")) {
				SmartPhone smartphone = new SmartPhone();
				smartphone.setMarca(arg1);
				smartphone.setModelo(arg2);
				smartphone.setColor(arg3);
				repositorioSmartPhone.save(smartphone);
		}
		else if (accion.equals("Buscar")) {
				model.addAttribute("smartphone", repositorioSmartPhone.findByMarcaAndModelo(arg1, arg2));
		}
			
		return "home";
	}

}