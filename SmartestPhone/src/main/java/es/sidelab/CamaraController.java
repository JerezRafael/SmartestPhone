package es.sidelab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CamaraController {

	@Autowired
	private CamaraRepository repositorioCamara;

	@PostMapping("/SmartestPhone/añadir/camara/solicitud")
	public String añadirSmartphone(@RequestParam String marcac, @RequestParam String modeloc, @RequestParam Integer megapixeles, Model model) {

		Camara camara = new Camara(marcac, modeloc, megapixeles);

		repositorioCamara.save(camara);

		return "añadirCamara";
	}
}
