package es.sidelab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {

	@Autowired
	private SmartphoneRepository repositorioSmartphone;
	@Autowired
	private ProcesadorRepository repositorioProcesador;
	@Autowired
	private CamaraRepository repositorioCamara;

	@RequestMapping("/SmartestPhone/añadir/smartphone")
	public String greetingAñadirSmartphone(Model model) {
		
		model.addAttribute("camaras", repositorioCamara.findAll());
		model.addAttribute("procesadores", repositorioProcesador.findAll());

		return "añadirSmartphone";
	}

	@RequestMapping("/SmartestPhone/añadir/camara")
	public String greetingAñadirCamara(Model model) {

		return "añadirCamara";
	}

	@RequestMapping("/SmartestPhone/añadir/procesador")
	public String greetingAñadirProcesador(Model model) {

		return "añadirProcesador";
	}

	@RequestMapping("/SmartestPhone/añadir/noticia")
	public String greetingAñadirNoticia(Model model) {

		model.addAttribute("smartphones", repositorioSmartphone.findAll());

		return "añadirNoticia";
	}

}