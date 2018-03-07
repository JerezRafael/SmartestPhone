package es.sidelab.SmartestPhone.controladores;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.sidelab.SmartestPhone.clases.Camara;
import es.sidelab.SmartestPhone.repositorios.*;

@Controller
public class CamaraController {

	@Autowired
	private SmartphoneRepository repositorioSmartphone;
	@Autowired
	private ProcesadorRepository repositorioProcesador;
	@Autowired
	private CamaraRepository repositorioCamara;
	@Autowired
	private NoticiaRepository repositorioNoticia;

	@PostMapping("/SmartestPhone/añadir/camara/solicitud")
	public String añadirSmartphone(@RequestParam String marcac, @RequestParam String modeloc,
			@RequestParam Integer megapixeles, Model model, HttpServletRequest request) {

		Camara camara = new Camara(marcac, modeloc, megapixeles);

		repositorioCamara.save(camara);

		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		model.addAttribute("user", request.isUserInRole("USER"));

		return "añadirCamara";
	}

	@PostMapping("/SmartestPhone/gestion/camara")
	public String borrarCamara(@RequestParam long idCamara, Model model, HttpServletRequest request) {
		
		Camara camara = repositorioCamara.findByIdCamara(idCamara);

		repositorioCamara.delete(camara);

		model.addAttribute("smartphones", repositorioSmartphone.findAll());
		model.addAttribute("camaras", repositorioCamara.findBySmartphonesIsNull());
		model.addAttribute("procesadores", repositorioProcesador.findBySmartphonesIsNull());
		model.addAttribute("noticias", repositorioNoticia.findAllByOrderByIdNoticiaDesc());

		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		model.addAttribute("user", request.isUserInRole("USER"));

		return "gestion";
	}
}
