package es.sidelab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CamaraController {

	@Autowired
	private CamaraRepository repositorioCamara;
	
	@Autowired
	private SmartphoneRepository repositorioSmartPhone;
	
	@Autowired
	private ProcesadorRepository repositorioProcesador;

	@RequestMapping("/SmartestPhone/buscar/camara")
	public String buscarCamara(@RequestParam long idCamara, Model model) {

		model.addAttribute("smartphones", repositorioSmartPhone.findByCamaraIdCamara(idCamara));

		return "inicio";
	}

	@RequestMapping("/SmartestPhone")												// deberia estar en webcontroller
	public String greetingInicio(Model model) {

		model.addAttribute("camaras", repositorioCamara.findAll());
		model.addAttribute("procesadores", repositorioProcesador.findAll());

		return "inicio";
	}

	@RequestMapping("/SmartestPhone/añadir/camara/solicitud")
	public String añadirSmartphone(@RequestParam String marcac, @RequestParam String modeloc, @RequestParam Integer megapixeles, Model model) {

		Camara camara = new Camara(marcac, modeloc, megapixeles);

		repositorioCamara.save(camara);

		return "añadirCamara";
	}
}
