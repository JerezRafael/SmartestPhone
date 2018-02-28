package es.sidelab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProcesadorController {

	@Autowired
	private SmartphoneRepository repositorioSmartphone;
	@Autowired
	private ProcesadorRepository repositorioProcesador;
	@Autowired
	private CamaraRepository repositorioCamara;
	@Autowired
	private NoticiaRepository repositorioNoticia;

	@PostMapping("/SmartestPhone/añadir/procesador/solicitud")
	public String añadirSmartphone(@RequestParam String marcap, @RequestParam String modelop, @RequestParam Double ghz,
			@RequestParam Integer nucleos, Model model) {

		Procesador procesador = new Procesador(marcap, modelop, ghz, nucleos);

		repositorioProcesador.save(procesador);

		return "añadirProcesador";
	}

	@PostMapping("/SmartestPhone/gestion/procesador")
	public String borrarProcesador(@RequestParam long idProcesador, Model model) {
		
		Procesador procesador = repositorioProcesador.findByIdProcesador(idProcesador);

		repositorioProcesador.delete(procesador);
		
		model.addAttribute("smartphones", repositorioSmartphone.findAll());
		model.addAttribute("camaras", repositorioCamara.findBySmartphonesIsNull());
		model.addAttribute("procesadores", repositorioProcesador.findBySmartphonesIsNull());
		model.addAttribute("noticias", repositorioNoticia.findAllByOrderByIdNoticiaDesc());

		return "gestion";
	}
}
