package es.sidelab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
			@RequestParam Integer megapixeles, Model model) {

		Camara camara = new Camara(marcac, modeloc, megapixeles);

		repositorioCamara.save(camara);

		return "añadirCamara";
	}

	@PostMapping("/SmartestPhone/gestion/camara")
	public String borrarCamara(@RequestParam long idCamara, Model model) {
		
		Camara camara = repositorioCamara.findByIdCamara(idCamara);

		repositorioCamara.delete(camara);

		model.addAttribute("smartphones", repositorioSmartphone.findAll());
		model.addAttribute("camaras", repositorioCamara.findAll());
		model.addAttribute("procesadores", repositorioProcesador.findAll());
		model.addAttribute("noticias", repositorioNoticia.findAllByOrderByIdNoticiaDesc());

		return "gestion";
	}
}
