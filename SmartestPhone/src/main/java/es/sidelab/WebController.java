package es.sidelab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	public String greetingInicio(Model model) {

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
	public String greetingAñadirSmartphone(Model model) {

		model.addAttribute("camaras", repositorioCamara.findAll());
		model.addAttribute("procesadores", repositorioProcesador.findAll());

		return "añadirSmartphone";
	}

	@RequestMapping("/SmartestPhone/añadir/noticia")
	public String greetingAñadirNoticia(Model model) {

		model.addAttribute("smartphones", repositorioSmartphone.findAll());

		return "añadirNoticia";
	}

	@RequestMapping("/SmartestPhone/añadir/camara")
	public String greetingAñadirCamara(Model model) {

		return "añadirCamara";
	}

	@RequestMapping("/SmartestPhone/añadir/procesador")
	public String greetingAñadirProcesador(Model model) {

		return "añadirProcesador";
	}

	@RequestMapping("/SmartestPhone/detalles")
	public String greetingDetalles(@RequestParam long idSmartphone, Model model) {

		model.addAttribute("smartphone", repositorioSmartphone.findByIdSmartphone(idSmartphone));
		model.addAttribute("noticias",
				repositorioNoticia.findBySmartphonesIdSmartphoneOrderByIdNoticiaDesc(idSmartphone));

		return "detalles";
	}

	@RequestMapping("/SmartestPhone/noticias")
	public String greetingNoticias(Model model) {

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
	public String greetingGestion(Model model) {
		
		model.addAttribute("smartphones", repositorioSmartphone.findAll());
		model.addAttribute("camarasborrables", repositorioCamara.findBySmartphonesIsNull());
		model.addAttribute("camarasnoborrables", repositorioCamara.findBySmartphonesIsNotNull());
		model.addAttribute("procesadoresborrables", repositorioProcesador.findBySmartphonesIsNull());
		model.addAttribute("procesadoresnoborrables", repositorioProcesador.findBySmartphonesIsNotNull());
		model.addAttribute("noticias", repositorioNoticia.findAllByOrderByIdNoticiaDesc());

		return "gestion";
	}
}