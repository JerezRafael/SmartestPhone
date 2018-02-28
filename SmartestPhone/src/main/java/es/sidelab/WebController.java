package es.sidelab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebController {

	@Autowired
	private SmartphoneRepository repositorioSmartphone;
	@Autowired
	private ProcesadorRepository repositorioProcesador;
	@Autowired
	private CamaraRepository repositorioCamara;
	@Autowired
	private NoticiaRepository repositorioNoticia;

	@RequestMapping("/SmartestPhone")
	public String inicio(Model model) {

		model.addAttribute("camaras", repositorioCamara.findAll());
		model.addAttribute("procesadores", repositorioProcesador.findAll());

		return "inicio";
	}

	@RequestMapping("/SmartestPhone/buscar/modelo")
	public String buscarSmartphone(@RequestParam String marca, @RequestParam String modelo, Model model) {

		model.addAttribute("smartphones", repositorioSmartphone.findByMarcaAndModelo(marca, modelo));

		return "inicio";
	}

	@RequestMapping("/SmartestPhone/buscar/procesador")
	public String buscarProcesador(@RequestParam long idProcesador, Model model) {

		model.addAttribute("smartphones", repositorioSmartphone.findByProcesadorIdProcesador(idProcesador));

		model.addAttribute("camaras", repositorioCamara.findAll());
		model.addAttribute("procesadores", repositorioProcesador.findAll());

		return "inicio";
	}

	@RequestMapping("/SmartestPhone/buscar/camara")
	public String buscarCamara(@RequestParam long idCamara, Model model) {

		model.addAttribute("smartphones", repositorioSmartphone.findByCamaraIdCamara(idCamara));

		model.addAttribute("camaras", repositorioCamara.findAll());
		model.addAttribute("procesadores", repositorioProcesador.findAll());

		return "inicio";
	}

	@RequestMapping("/SmartestPhone/añadir/smartphone")
	public String añadirSmartphone(Model model) {

		model.addAttribute("camaras", repositorioCamara.findAll());
		model.addAttribute("procesadores", repositorioProcesador.findAll());

		return "añadirSmartphone";
	}

	@RequestMapping("/SmartestPhone/añadir/noticia")
	public String añadirNoticia(Model model) {

		model.addAttribute("smartphones", repositorioSmartphone.findAll());

		return "añadirNoticia";
	}

	@RequestMapping("/SmartestPhone/añadir/camara")
	public String añadirCamara(Model model) {

		return "añadirCamara";
	}

	@RequestMapping("/SmartestPhone/añadir/procesador")
	public String añadirProcesador(Model model) {

		return "añadirProcesador";
	}

	@RequestMapping("/SmartestPhone/detalles")
	public String detalles(@RequestParam long idSmartphone, Model model) {

		model.addAttribute("smartphone", repositorioSmartphone.findByIdSmartphone(idSmartphone));
		model.addAttribute("noticias",
				repositorioNoticia.findBySmartphonesIdSmartphoneOrderByIdNoticiaDesc(idSmartphone));

		return "detalles";
	}

	@RequestMapping("/SmartestPhone/noticias")
	public String noticias(Model model) {

		model.addAttribute("noticias", repositorioNoticia.findAllByOrderByIdNoticiaDesc());

		model.addAttribute("smartphones", repositorioSmartphone.findAll());

		return "noticias";
	}

	@RequestMapping("/SmartestPhone/noticias/buscar")
	public String añadirNoticia(@RequestParam long idSmartphone, Model model) {

		model.addAttribute("smartphone", repositorioSmartphone.findByIdSmartphone(idSmartphone));
		model.addAttribute("noticias",
				repositorioNoticia.findBySmartphonesIdSmartphoneOrderByIdNoticiaDesc(idSmartphone));
		model.addAttribute("smartphones", repositorioSmartphone.findAll());

		return "noticias";
	}

	@RequestMapping("/SmartestPhone/gestion")
	public String gestion(Model model) {

		model.addAttribute("smartphones", repositorioSmartphone.findAll());
		model.addAttribute("camaras", repositorioCamara.findBySmartphonesIsNull());
		model.addAttribute("procesadores", repositorioProcesador.findBySmartphonesIsNull());
		model.addAttribute("noticias", repositorioNoticia.findAllByOrderByIdNoticiaDesc());

		return "gestion";
	}

	@GetMapping("/SmartestPhone/acceder")
	public String acceder() {
		return "acceder";
	}

	@GetMapping("/SmartestPhone/erroracceder")
	public String errorAcceder() {
		return "erroracceder";
	}

	@GetMapping("/SmartestPhone/salir")
	public String salir() {
		return "salir";
	}
}